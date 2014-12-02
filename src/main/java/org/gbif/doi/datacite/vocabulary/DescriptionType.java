package org.gbif.doi.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of descriptions.
 */
public enum DescriptionType {
  ABSTRACT("Abstract"),
  METHODS("Methods"),
  SERIES_INFORMATION("SeriesInformation"),
  TABLE_OF_CONTENTS("TableOfContents"),
  OTHER("Other");

  private final String value;

  DescriptionType(String value) {
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
