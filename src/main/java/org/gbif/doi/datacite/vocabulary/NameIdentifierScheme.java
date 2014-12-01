package org.gbif.doi.datacite.vocabulary;

import java.net.URI;

/**
 * Enumeration representing the different name identifier schemes handled/understood.
 */
public enum NameIdentifierScheme {
  ORCID("ORCID", URI.create("http://orcid.org")),
  RESEARCHER_ID("ResearcherId", URI.create("http://www.researcherid.com/rid/"));

  private final String scheme;
  private final URI schemaUri;

   NameIdentifierScheme(String scheme, URI schemaUri) {
     this.scheme = scheme;
     this.schemaUri = schemaUri;
  }

  /**
   * @return the URI of the name identifier scheme
   */
  public URI getSchemaUri() {
    return schemaUri;
  }

  /**
   * @return the NameIdentifierScheme as it should be printed in the XML document
   */
  public String getScheme() {
    return scheme;
  }
}
