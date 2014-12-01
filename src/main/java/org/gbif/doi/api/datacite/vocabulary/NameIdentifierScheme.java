package org.gbif.doi.api.datacite.vocabulary;

/**
 * Enumeration representing the different name identifier schemes handled/understood.
 */
public enum NameIdentifierScheme {
  ORCID("ORCID", "http://orcid.org"),
  RESEARCHER_ID("ResearcherId", "http://www.researcherid.com/rid/");

  private final String printValue;
  private final String schemaUri;

   NameIdentifierScheme(String printValue, String schemaUri) {
     this.printValue = printValue;
     this.schemaUri = schemaUri;
  }

  /**
   * @return the URI of the name identifier scheme
   */
  public String getSchemaUri() {
    return schemaUri;
  }

  /**
   * @return the NameIdentifierScheme as it should be printed in the XML document
   */
  public String getPrintValue() {
    return printValue;
  }
}
