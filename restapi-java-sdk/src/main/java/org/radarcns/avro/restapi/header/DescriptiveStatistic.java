/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.radarcns.avro.restapi.header;
@SuppressWarnings("all")
/** Set of available statical value */
@org.apache.avro.specific.AvroGenerated
public enum DescriptiveStatistic {
  AVERAGE, COUNT, MAXIMUM, MEDIAN, MINIMUM, SUM, INTERQUARTILE_RANGE, LOWER_QUARTILE, UPPER_QUARTILE, QUARTILES  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"DescriptiveStatistic\",\"namespace\":\"org.radarcns.avro.restapi.header\",\"doc\":\"Set of available statical value\",\"symbols\":[\"AVERAGE\",\"COUNT\",\"MAXIMUM\",\"MEDIAN\",\"MINIMUM\",\"SUM\",\"INTERQUARTILE_RANGE\",\"LOWER_QUARTILE\",\"UPPER_QUARTILE\",\"QUARTILES\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}