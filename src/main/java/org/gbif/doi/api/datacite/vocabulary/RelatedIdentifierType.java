package org.gbif.doi.api.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of related identifier types.
 */
public enum RelatedIdentifierType {
  ARK("ARK"),
  DOI("DOI"),
  EAN13("EAN13"),
  EISN("EISN"),
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

  private final String printType;

   RelatedIdentifierType(String printType) {
     this.printType = printType;
  }

  /**
   * @return the RelatedIdentifierType as it should be printed in the XML document
   */
  public String getPrintType() {
    return printType;
  }
}
