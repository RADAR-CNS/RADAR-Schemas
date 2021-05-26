/*
 * Copyright 2017 King's College London and The Hyve
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.radarbase.schema.registration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.radarbase.config.ServerConfig;
import org.radarbase.producer.rest.RestClient;
import org.radarbase.producer.rest.SchemaRetriever;
import org.radarbase.schema.specification.DataProducer;
import org.radarbase.schema.specification.SourceCatalogue;
import org.radarbase.topic.AvroTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Schema registry interface.
 */
public class SchemaRegistry {
    private static final Logger logger = LoggerFactory.getLogger(SchemaRegistry.class);
    private final SchemaRetriever schemaClient;
    private final RestClient httpClient;
    private static final int MAX_SLEEP = 32;

    /**
     * Schema registry for given URL. If this is https, unsafe certificates are accepted.
     *
     * @param baseUrl URL of the schema registry
     * @throws MalformedURLException if given URL is invalid.
     */
    public SchemaRegistry(String baseUrl) throws MalformedURLException {
        ServerConfig config = new ServerConfig(baseUrl);
        config.setUnsafe(false);
        this.httpClient = RestClient.global()
                .timeout(10, TimeUnit.SECONDS)
                .server(config)
                .build();
        this.schemaClient = new SchemaRetriever(this.httpClient);
    }

    public SchemaRegistry(String baseUrl, String apiKey, String apiSecret)
            throws MalformedURLException {
        ServerConfig config = new ServerConfig(baseUrl);
        config.setUnsafe(true);
        this.httpClient = RestClient.global()
                .timeout(10, TimeUnit.SECONDS)
                .server(config)
                .headers(Headers.of("Authorization", Credentials.basic(apiKey, apiSecret)))
                .build();
        this.schemaClient = new SchemaRetriever(this.httpClient);
    }

    /**
     * Wait for schema registry to become available. This uses a polling mechanism, waiting for at
     * most 200 seconds.
     *
     * @throws InterruptedException when waiting for the brokers is interrupted.
     * @throws IllegalStateException if the schema registry is not ready after wait is finished.
     */
    public void initialize() throws InterruptedException {
        int sleep = 2;
        int numTries = 20;

        for (int tries = 0; tries < numTries; tries++) {
            try (Response response = httpClient.request("subjects")) {
                if (response.isSuccessful()) {
                    return;
                } else {
                    logger.error("Schema registry {} not ready, responded with HTTP {}: {}",
                            httpClient.getServer(), response.code(),
                            RestClient.responseBody(response));
                }
            } catch (IOException e) {
                logger.error("Failed to connect to schema registry {}",
                        httpClient.getServer());
            }

            if (tries < numTries - 1) {
                logger.warn("Waiting {} seconds for schema registry.", sleep);
                Thread.sleep(sleep * 1000L);
                sleep = Math.min(MAX_SLEEP, sleep * 2);
            }
        }

        throw new IllegalStateException(
                "Schema registry " + httpClient.getServer() + " not available");
    }

    /**
     * Register all schemas in a source catalogue. Stream and connector sources are ignored.
     *
     * @param catalogue schema catalogue to read schemas from
     * @return whether all schemas were successfully registered.
     */
    public boolean registerSchemas(SourceCatalogue catalogue) {
        return catalogue.getSources().stream()
                .filter(DataProducer::doRegisterSchema)
                .flatMap(p -> p.getTopics(catalogue.getSchemaCatalogue()))
                .sorted(Comparator.comparing(AvroTopic::getName))
                .distinct()
                .peek(t -> logger.info("Registering topic {} schemas: {} - {}",
                        t.getName(), t.getKeySchema().getFullName(),
                        t.getValueSchema().getFullName()))
                .allMatch(this::registerSchema);
    }

    /**
     * Register the schema of a single topic.
     */
    public boolean registerSchema(AvroTopic<?, ?> topic) {
        try {
            this.schemaClient.addSchema(topic.getName(), false, topic.getKeySchema());
            this.schemaClient.addSchema(topic.getName(), true, topic.getValueSchema());
            return true;
        } catch (IOException ex) {
            logger.error("Failed to register schemas for topic {}", topic.getName(), ex);
            return false;
        }
    }

    /**
     * Set the compatibility level of the schema registry.
     *
     * @param compatibility target compatibility level.
     * @return whether the request was successful.
     */
    public boolean putCompatibility(Compatibility compatibility) {
        logger.info("Setting compatibility to {}", compatibility);

        Request request;
        try {
            request = httpClient.requestBuilder("config")
                    .put(new RequestBody() {
                        @Override
                        public MediaType contentType() {
                            return MediaType.parse(
                                    "application/vnd.schemaregistry.v1+json; charset=utf-8");
                        }

                        @Override
                        public void writeTo(@NotNull BufferedSink sink) throws IOException {
                            sink.writeUtf8("{\"compatibility\": \"");
                            sink.writeUtf8(compatibility.name());
                            sink.writeUtf8("\"}");
                        }
                    })
                    .build();
        } catch (MalformedURLException ex) {
            // should not occur with valid base URL
            return false;
        }

        try (Response response = httpClient.request(request);
                ResponseBody body = response.body()) {
            if (response.isSuccessful()) {
                logger.info("Compatibility set to {}", compatibility);
                return true;
            } else {
                String bodyString = body == null ? null : body.string();
                logger.info("Failed to set compatibility set to {}: {}", compatibility, bodyString);
                return false;
            }
        } catch (IOException ex) {
            logger.error("Error changing compatibility level to {}", compatibility, ex);
            return false;
        }
    }

    public enum Compatibility {
        NONE, FULL, BACKWARD, FORWARD, BACKWARD_TRANSITIVE, FORWARD_TRANSITIVE, FULL_TRANSITIVE
    }
}
