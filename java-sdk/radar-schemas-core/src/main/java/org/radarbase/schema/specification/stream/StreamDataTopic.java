package org.radarbase.schema.specification.stream;

import static org.radarbase.schema.util.SchemaUtils.applyOrEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.radarbase.config.AvroTopicConfig;
import org.radarbase.schema.SchemaCatalogue;
import org.radarbase.schema.specification.DataTopic;
import org.radarbase.stream.TimeWindowMetadata;
import org.radarbase.topic.AvroTopic;
import org.radarcns.kafka.AggregateKey;
import org.radarcns.kafka.ObservationKey;

/**
 * Topic used for Kafka Streams.
 */
@JsonInclude(Include.NON_NULL)
public class StreamDataTopic extends DataTopic {
    /** Whether the stream is a windowed stream with standard TimeWindow windows. */
    @JsonProperty
    private boolean windowed = false;

    /** Input topic for the stream. */
    @JsonProperty("input_topics")
    private final List<String> inputTopics = new ArrayList<>();

    /**
     * Base topic name for output topics. If windowed, output topics would become
     * {@code [topicBase]_[time-frame]}, otherwise it becomes {@code [topicBase]_output}.
     * If a fixed topic is set, this will override the topic base for non-windowed topics.
     */
    @JsonProperty("topic_base")
    private String topicBase;

    @JsonSetter
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void setWindowed(boolean windowed) {
        this.windowed = windowed;
        if (windowed && (this.getKeySchema() == null
                || this.getKeySchema().equals(ObservationKey.class.getName()))) {
            this.setKeySchema(AggregateKey.class.getName());
        }
    }

    @JsonSetter("input_topic")
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void setInputTopic(String inputTopic) {
        if (topicBase == null) {
            topicBase = inputTopic;
        }
        if (!this.inputTopics.isEmpty()) {
            throw new IllegalStateException("Input topics already set");
        }
        this.inputTopics.add(inputTopic);
    }

    /** Get human readable output topic. */
    @Override
    public String getTopic() {
        if (windowed) {
            return topicBase + "_<time-frame>";
        } else if (super.getTopic() == null) {
            return topicBase + "_output";
        } else {
            return super.getTopic();
        }
    }

    public boolean isWindowed() {
        return windowed;
    }

    /** Get the input topics. */
    public List<String> getInputTopics() {
        return inputTopics;
    }

    @JsonSetter
    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void setInputTopics(Collection<? extends String> topics) {
        if (!this.inputTopics.isEmpty()) {
            throw new IllegalStateException("Input topics already set");
        }
        this.inputTopics.addAll(topics);
    }

    public String getTopicBase() {
        return topicBase;
    }

    @JsonIgnore
    @Override
    public Stream<String> getTopicNames() {
        if (windowed) {
            return Arrays.stream(TimeWindowMetadata.values())
                    .map(label -> label.getTopicLabel(topicBase));
        } else {
            String currentTopic = getTopic();
            if (currentTopic == null) {
                currentTopic = topicBase + "_output";
                setTopic(currentTopic);
            }
            return Stream.of(currentTopic);
        }
    }

    @JsonIgnore
    @Override
    public Stream<AvroTopic<?, ?>> getTopics(SchemaCatalogue schemaCatalogue) {
        return getTopicNames()
                .flatMap(applyOrEmpty(topic -> {
                    AvroTopicConfig config = new AvroTopicConfig();
                    config.setTopic(topic);
                    config.setKeySchema(getKeySchema());
                    config.setValueSchema(getValueSchema());
                    return Stream.of(schemaCatalogue.getGenericAvroTopic(config));
                }));
    }

    /** Get only topic names that are used with the fixed time windows. */
    @JsonIgnore
    public Stream<String> getTimedTopicNames() {
        if (windowed) {
            return getTopicNames();
        } else {
            return Stream.empty();
        }
    }

    @Override
    protected void propertiesMap(Map<String, Object> properties, boolean reduce) {
        properties.put("input_topics", inputTopics);
        properties.put("windowed", windowed);
        if (!reduce) {
            properties.put("topic_base", topicBase);
        }
    }
}
