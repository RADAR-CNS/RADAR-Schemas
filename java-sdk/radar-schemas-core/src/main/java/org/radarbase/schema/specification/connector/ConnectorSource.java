package org.radarbase.schema.specification.connector;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.radarbase.schema.Scope;
import org.radarbase.schema.specification.DataProducer;
import org.radarbase.schema.specification.DataTopic;

/**
 * Data producer for third-party connectors. This data topic does not register schemas to the schema
 * registry by default, since Kafka Connect will do that itself. To enable auto-registration, set
 * the {@code register_schema} property to {@code true}.
 */
@JsonInclude(Include.NON_NULL)
public class ConnectorSource extends DataProducer<DataTopic> {
    @JsonProperty
    private List<DataTopic> data;

    @JsonProperty
    private String vendor;

    @JsonProperty
    private String model;

    @JsonProperty
    private String version;

    public ConnectorSource() {
        registerSchema = false;
    }

    @Override
    public List<DataTopic> getData() {
        return data;
    }

    @Override
    public Scope getScope() {
        return Scope.CONNECTOR;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }
}
