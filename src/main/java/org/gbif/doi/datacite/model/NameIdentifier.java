package org.gbif.doi.datacite.model;

import java.net.URI;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class NameIdentifier {
  @JacksonXmlText
  private String nameIdentifier;
  @JacksonXmlProperty(isAttribute = true)
  private String nameIdentifierScheme;
  @JacksonXmlProperty(isAttribute = true)
  private URI schemeURI;

  public NameIdentifier() {

  }
  public NameIdentifier(String nameIdentifier, String scheme, String uri) {
    this.nameIdentifier = nameIdentifier;
    this.nameIdentifierScheme = scheme;
    this.schemeURI = URI.create(uri);
  }

  public String getNameIdentifier() {
    return nameIdentifier;
  }

  public void setNameIdentifier(String nameIdentifier) {
    this.nameIdentifier = nameIdentifier;
  }

  public String getNameIdentifierScheme() {
    return nameIdentifierScheme;
  }

  public void setNameIdentifierScheme(String nameIdentifierScheme) {
    this.nameIdentifierScheme = nameIdentifierScheme;
  }

  public URI getSchemeURI() {
    return schemeURI;
  }

  public void setSchemeURI(URI schemeURI) {
    this.schemeURI = schemeURI;
  }
}
