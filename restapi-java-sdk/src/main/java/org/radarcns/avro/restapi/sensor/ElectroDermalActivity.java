/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.radarcns.avro.restapi.sensor;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Aggregated data representing electrodermal activity expressed as microsiemens (µS) */
@org.apache.avro.specific.AvroGenerated
public class ElectroDermalActivity extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3844314750265688284L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ElectroDermalActivity\",\"namespace\":\"org.radarcns.avro.restapi.sensor\",\"doc\":\"Aggregated data representing electrodermal activity expressed as microsiemens (µS)\",\"fields\":[{\"name\":\"value\",\"type\":[\"double\",{\"type\":\"record\",\"name\":\"Quartiles\",\"namespace\":\"org.radarcns.avro.restapi.dataset\",\"doc\":\"List of quartiles\",\"fields\":[{\"name\":\"first\",\"type\":\"double\"},{\"name\":\"second\",\"type\":\"double\"},{\"name\":\"third\",\"type\":\"double\"}]}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.Object value;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ElectroDermalActivity() {}

  /**
   * All-args constructor.
   * @param value The new value for value
   */
  public ElectroDermalActivity(java.lang.Object value) {
    this.value = value;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return value;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: value = (java.lang.Object)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public java.lang.Object getValue() {
    return value;
  }

  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(java.lang.Object value) {
    this.value = value;
  }

  /**
   * Creates a new ElectroDermalActivity RecordBuilder.
   * @return A new ElectroDermalActivity RecordBuilder
   */
  public static org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder newBuilder() {
    return new org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder();
  }

  /**
   * Creates a new ElectroDermalActivity RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ElectroDermalActivity RecordBuilder
   */
  public static org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder newBuilder(org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder other) {
    return new org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder(other);
  }

  /**
   * Creates a new ElectroDermalActivity RecordBuilder by copying an existing ElectroDermalActivity instance.
   * @param other The existing instance to copy.
   * @return A new ElectroDermalActivity RecordBuilder
   */
  public static org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder newBuilder(org.radarcns.avro.restapi.sensor.ElectroDermalActivity other) {
    return new org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder(other);
  }

  /**
   * RecordBuilder for ElectroDermalActivity instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ElectroDermalActivity>
    implements org.apache.avro.data.RecordBuilder<ElectroDermalActivity> {

    private java.lang.Object value;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.value)) {
        this.value = data().deepCopy(fields()[0].schema(), other.value);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ElectroDermalActivity instance
     * @param other The existing instance to copy.
     */
    private Builder(org.radarcns.avro.restapi.sensor.ElectroDermalActivity other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.value)) {
        this.value = data().deepCopy(fields()[0].schema(), other.value);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public java.lang.Object getValue() {
      return value;
    }

    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder setValue(java.lang.Object value) {
      validate(fields()[0], value);
      this.value = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public org.radarcns.avro.restapi.sensor.ElectroDermalActivity.Builder clearValue() {
      value = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public ElectroDermalActivity build() {
      try {
        ElectroDermalActivity record = new ElectroDermalActivity();
        record.value = fieldSetFlags()[0] ? this.value : (java.lang.Object) defaultValue(fields()[0]);
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