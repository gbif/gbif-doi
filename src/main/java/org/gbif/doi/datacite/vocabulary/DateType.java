package org.gbif.doi.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of dates.
 */
public enum DateType {
  ACCEPTED("Accepted"),
  AVAILABLE("Available"),
  COPYRIGHTED("Copyrighted"),
  COLLECTED("Collected"),
  CREATED("Created"),
  ISSUED("Issued"),
  SUBMITTED("Submitted"),
  UPDATED("Updated"),
  VALID("Valid");

  private final String value;

  DateType(String value) {
    this.value = value;
  }


  /**
   * Return the appropriate XML value for the enum value.
   * This allows us to configure Jackson directly to use this without special (de)serializers.
   */
  @Override
  public String toString() {
    return value;
  }
}
