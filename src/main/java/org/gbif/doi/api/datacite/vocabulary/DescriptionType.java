package org.gbif.doi.api.datacite.vocabulary;

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

  private final String printType;

  DescriptionType(String printType) {
    this.printType = printType;

  }

  /**
   * @return the DescriptionType as it should be printed in the XML document
   */
  public String getPrintType() {
    return printType;
  }
}
