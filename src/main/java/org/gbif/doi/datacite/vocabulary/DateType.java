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

  private final String printValue;

  DateType(String printValue) {
    this.printValue = printValue;
  }

  /**
   * @return @return the DateType as it should be printed in the XML document
   */
  public String getPrintValue() {
    return printValue;
  }
}
