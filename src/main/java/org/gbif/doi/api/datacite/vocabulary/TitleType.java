package org.gbif.doi.api.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of title.
 */
public enum TitleType {
  ALTERNATIVE_TITLE("AlternativeTitle"),
  SUBTITLE("Subtitle"),
  TRANSLATED_TITLE("TranslatedTitle");

  private final String printValue;

   TitleType(String printValue) {
     this.printValue = printValue;
  }

  /**
   * @return the TitleType as it should be printed in the XML document
   */
  public String getPrintValue() {
    return printValue;
  }
}
