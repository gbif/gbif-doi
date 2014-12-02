package org.gbif.doi.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of title.
 */
public enum TitleType {
  ALTERNATIVE_TITLE("AlternativeTitle"),
  SUBTITLE("Subtitle"),
  TRANSLATED_TITLE("TranslatedTitle");

  private final String value;

   TitleType(String value) {
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
