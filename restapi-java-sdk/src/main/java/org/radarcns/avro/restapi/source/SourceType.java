/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.radarcns.avro.restapi.source;
@SuppressWarnings("all")
/** All available sources */
@org.apache.avro.specific.AvroGenerated
public enum SourceType {
  ANDROID, EMPATICA, PEBBLE, BIOVOTION  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"SourceType\",\"namespace\":\"org.radarcns.avro.restapi.source\",\"doc\":\"All available sources\",\"symbols\":[\"ANDROID\",\"EMPATICA\",\"PEBBLE\",\"BIOVOTION\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}