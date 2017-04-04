/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.radarcns.avro.restapi.header;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Metadata for Dataset. It is a summary explaining what kind of information are stored in the Dataset. */
@org.apache.avro.specific.AvroGenerated
public class Header extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5725976672629014356L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Header\",\"namespace\":\"org.radarcns.avro.restapi.header\",\"doc\":\"Metadata for Dataset. It is a summary explaining what kind of information are stored in the Dataset.\",\"fields\":[{\"name\":\"descriptiveStatistic\",\"type\":{\"type\":\"enum\",\"name\":\"DescriptiveStatistic\",\"doc\":\"Set of available statical value\",\"symbols\":[\"AVERAGE\",\"COUNT\",\"MAXIMUM\",\"MEDIAN\",\"MINIMUM\",\"SUM\",\"INTERQUARTILE_RANGE\",\"LOWER_QUARTILE\",\"UPPER_QUARTILE\",\"QUARTILES\"]}},{\"name\":\"unit\",\"type\":{\"type\":\"enum\",\"name\":\"Unit\",\"namespace\":\"org.radarcns.avro.restapi.sensor\",\"doc\":\"Set of measurement units\",\"symbols\":[\"BEATS_PER_MIN\",\"CELSIUS\",\"DIMENSIONLESS\",\"G\",\"MICROSIEMENS\",\"SECOND\",\"NANOWATT\",\"PERCENTAGE\"]}},{\"name\":\"effectiveTimeFrame\",\"type\":{\"type\":\"record\",\"name\":\"EffectiveTimeFrame\",\"doc\":\"Time window\",\"fields\":[{\"name\":\"startDateTime\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"It is a point in time (ISO8601) with UTC timezone.\"},{\"name\":\"endDateTime\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"It is a point in time (ISO8601) with UTC timezone.\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public org.radarcns.avro.restapi.header.DescriptiveStatistic descriptiveStatistic;
  @Deprecated public org.radarcns.avro.restapi.sensor.Unit unit;
  @Deprecated public org.radarcns.avro.restapi.header.EffectiveTimeFrame effectiveTimeFrame;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Header() {}

  /**
   * All-args constructor.
   * @param descriptiveStatistic The new value for descriptiveStatistic
   * @param unit The new value for unit
   * @param effectiveTimeFrame The new value for effectiveTimeFrame
   */
  public Header(org.radarcns.avro.restapi.header.DescriptiveStatistic descriptiveStatistic, org.radarcns.avro.restapi.sensor.Unit unit, org.radarcns.avro.restapi.header.EffectiveTimeFrame effectiveTimeFrame) {
    this.descriptiveStatistic = descriptiveStatistic;
    this.unit = unit;
    this.effectiveTimeFrame = effectiveTimeFrame;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return descriptiveStatistic;
    case 1: return unit;
    case 2: return effectiveTimeFrame;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: descriptiveStatistic = (org.radarcns.avro.restapi.header.DescriptiveStatistic)value$; break;
    case 1: unit = (org.radarcns.avro.restapi.sensor.Unit)value$; break;
    case 2: effectiveTimeFrame = (org.radarcns.avro.restapi.header.EffectiveTimeFrame)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'descriptiveStatistic' field.
   * @return The value of the 'descriptiveStatistic' field.
   */
  public org.radarcns.avro.restapi.header.DescriptiveStatistic getDescriptiveStatistic() {
    return descriptiveStatistic;
  }

  /**
   * Sets the value of the 'descriptiveStatistic' field.
   * @param value the value to set.
   */
  public void setDescriptiveStatistic(org.radarcns.avro.restapi.header.DescriptiveStatistic value) {
    this.descriptiveStatistic = value;
  }

  /**
   * Gets the value of the 'unit' field.
   * @return The value of the 'unit' field.
   */
  public org.radarcns.avro.restapi.sensor.Unit getUnit() {
    return unit;
  }

  /**
   * Sets the value of the 'unit' field.
   * @param value the value to set.
   */
  public void setUnit(org.radarcns.avro.restapi.sensor.Unit value) {
    this.unit = value;
  }

  /**
   * Gets the value of the 'effectiveTimeFrame' field.
   * @return The value of the 'effectiveTimeFrame' field.
   */
  public org.radarcns.avro.restapi.header.EffectiveTimeFrame getEffectiveTimeFrame() {
    return effectiveTimeFrame;
  }

  /**
   * Sets the value of the 'effectiveTimeFrame' field.
   * @param value the value to set.
   */
  public void setEffectiveTimeFrame(org.radarcns.avro.restapi.header.EffectiveTimeFrame value) {
    this.effectiveTimeFrame = value;
  }

  /**
   * Creates a new Header RecordBuilder.
   * @return A new Header RecordBuilder
   */
  public static org.radarcns.avro.restapi.header.Header.Builder newBuilder() {
    return new org.radarcns.avro.restapi.header.Header.Builder();
  }

  /**
   * Creates a new Header RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Header RecordBuilder
   */
  public static org.radarcns.avro.restapi.header.Header.Builder newBuilder(org.radarcns.avro.restapi.header.Header.Builder other) {
    return new org.radarcns.avro.restapi.header.Header.Builder(other);
  }

  /**
   * Creates a new Header RecordBuilder by copying an existing Header instance.
   * @param other The existing instance to copy.
   * @return A new Header RecordBuilder
   */
  public static org.radarcns.avro.restapi.header.Header.Builder newBuilder(org.radarcns.avro.restapi.header.Header other) {
    return new org.radarcns.avro.restapi.header.Header.Builder(other);
  }

  /**
   * RecordBuilder for Header instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Header>
    implements org.apache.avro.data.RecordBuilder<Header> {

    private org.radarcns.avro.restapi.header.DescriptiveStatistic descriptiveStatistic;
    private org.radarcns.avro.restapi.sensor.Unit unit;
    private org.radarcns.avro.restapi.header.EffectiveTimeFrame effectiveTimeFrame;
    private org.radarcns.avro.restapi.header.EffectiveTimeFrame.Builder effectiveTimeFrameBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.radarcns.avro.restapi.header.Header.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.descriptiveStatistic)) {
        this.descriptiveStatistic = data().deepCopy(fields()[0].schema(), other.descriptiveStatistic);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.unit)) {
        this.unit = data().deepCopy(fields()[1].schema(), other.unit);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.effectiveTimeFrame)) {
        this.effectiveTimeFrame = data().deepCopy(fields()[2].schema(), other.effectiveTimeFrame);
        fieldSetFlags()[2] = true;
      }
      if (other.hasEffectiveTimeFrameBuilder()) {
        this.effectiveTimeFrameBuilder = org.radarcns.avro.restapi.header.EffectiveTimeFrame.newBuilder(other.getEffectiveTimeFrameBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing Header instance
     * @param other The existing instance to copy.
     */
    private Builder(org.radarcns.avro.restapi.header.Header other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.descriptiveStatistic)) {
        this.descriptiveStatistic = data().deepCopy(fields()[0].schema(), other.descriptiveStatistic);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.unit)) {
        this.unit = data().deepCopy(fields()[1].schema(), other.unit);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.effectiveTimeFrame)) {
        this.effectiveTimeFrame = data().deepCopy(fields()[2].schema(), other.effectiveTimeFrame);
        fieldSetFlags()[2] = true;
      }
      this.effectiveTimeFrameBuilder = null;
    }

    /**
      * Gets the value of the 'descriptiveStatistic' field.
      * @return The value.
      */
    public org.radarcns.avro.restapi.header.DescriptiveStatistic getDescriptiveStatistic() {
      return descriptiveStatistic;
    }

    /**
      * Sets the value of the 'descriptiveStatistic' field.
      * @param value The value of 'descriptiveStatistic'.
      * @return This builder.
      */
    public org.radarcns.avro.restapi.header.Header.Builder setDescriptiveStatistic(org.radarcns.avro.restapi.header.DescriptiveStatistic value) {
      validate(fields()[0], value);
      this.descriptiveStatistic = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'descriptiveStatistic' field has been set.
      * @return True if the 'descriptiveStatistic' field has been set, false otherwise.
      */
    public boolean hasDescriptiveStatistic() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'descriptiveStatistic' field.
      * @return This builder.
      */
    public org.radarcns.avro.restapi.header.Header.Builder clearDescriptiveStatistic() {
      descriptiveStatistic = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'unit' field.
      * @return The value.
      */
    public org.radarcns.avro.restapi.sensor.Unit getUnit() {
      return unit;
    }

    /**
      * Sets the value of the 'unit' field.
      * @param value The value of 'unit'.
      * @return This builder.
      */
    public org.radarcns.avro.restapi.header.Header.Builder setUnit(org.radarcns.avro.restapi.sensor.Unit value) {
      validate(fields()[1], value);
      this.unit = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'unit' field has been set.
      * @return True if the 'unit' field has been set, false otherwise.
      */
    public boolean hasUnit() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'unit' field.
      * @return This builder.
      */
    public org.radarcns.avro.restapi.header.Header.Builder clearUnit() {
      unit = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'effectiveTimeFrame' field.
      * @return The value.
      */
    public org.radarcns.avro.restapi.header.EffectiveTimeFrame getEffectiveTimeFrame() {
      return effectiveTimeFrame;
    }

    /**
      * Sets the value of the 'effectiveTimeFrame' field.
      * @param value The value of 'effectiveTimeFrame'.
      * @return This builder.
      */
    public org.radarcns.avro.restapi.header.Header.Builder setEffectiveTimeFrame(org.radarcns.avro.restapi.header.EffectiveTimeFrame value) {
      validate(fields()[2], value);
      this.effectiveTimeFrameBuilder = null;
      this.effectiveTimeFrame = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'effectiveTimeFrame' field has been set.
      * @return True if the 'effectiveTimeFrame' field has been set, false otherwise.
      */
    public boolean hasEffectiveTimeFrame() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'effectiveTimeFrame' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public org.radarcns.avro.restapi.header.EffectiveTimeFrame.Builder getEffectiveTimeFrameBuilder() {
      if (effectiveTimeFrameBuilder == null) {
        if (hasEffectiveTimeFrame()) {
          setEffectiveTimeFrameBuilder(org.radarcns.avro.restapi.header.EffectiveTimeFrame.newBuilder(effectiveTimeFrame));
        } else {
          setEffectiveTimeFrameBuilder(org.radarcns.avro.restapi.header.EffectiveTimeFrame.newBuilder());
        }
      }
      return effectiveTimeFrameBuilder;
    }

    /**
     * Sets the Builder instance for the 'effectiveTimeFrame' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public org.radarcns.avro.restapi.header.Header.Builder setEffectiveTimeFrameBuilder(org.radarcns.avro.restapi.header.EffectiveTimeFrame.Builder value) {
      clearEffectiveTimeFrame();
      effectiveTimeFrameBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'effectiveTimeFrame' field has an active Builder instance
     * @return True if the 'effectiveTimeFrame' field has an active Builder instance
     */
    public boolean hasEffectiveTimeFrameBuilder() {
      return effectiveTimeFrameBuilder != null;
    }

    /**
      * Clears the value of the 'effectiveTimeFrame' field.
      * @return This builder.
      */
    public org.radarcns.avro.restapi.header.Header.Builder clearEffectiveTimeFrame() {
      effectiveTimeFrame = null;
      effectiveTimeFrameBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public Header build() {
      try {
        Header record = new Header();
        record.descriptiveStatistic = fieldSetFlags()[0] ? this.descriptiveStatistic : (org.radarcns.avro.restapi.header.DescriptiveStatistic) defaultValue(fields()[0]);
        record.unit = fieldSetFlags()[1] ? this.unit : (org.radarcns.avro.restapi.sensor.Unit) defaultValue(fields()[1]);
        if (effectiveTimeFrameBuilder != null) {
          record.effectiveTimeFrame = this.effectiveTimeFrameBuilder.build();
        } else {
          record.effectiveTimeFrame = fieldSetFlags()[2] ? this.effectiveTimeFrame : (org.radarcns.avro.restapi.header.EffectiveTimeFrame) defaultValue(fields()[2]);
        }
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}