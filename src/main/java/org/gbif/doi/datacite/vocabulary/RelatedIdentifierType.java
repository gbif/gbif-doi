package org.gbif.doi.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of related identifier types.
 */
public enum RelatedIdentifierType {
  ARK("ARK"),
  AR_XIV("arXiv"),
  BIBCODE("bibcode"),
  DOI("DOI"),
  EAN_13("EAN13"),
  EISSN("EISSN"),
  HANDLE("Handle"),
  ISBN("ISBN"),
  ISSN("ISSN"),
  ISTC("ISTC"),
  LISSN("LISSN"),
  LSID("LSID"),
  PMID("PMID"),
  PURL("PURL"),
  UPC("UPC"),
  URL("URL"),
  URN("URN");

  private final String value;

   RelatedIdentifierType(String value) {
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
