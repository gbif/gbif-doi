package org.gbif.doi.datacite.model;

import org.gbif.doi.datacite.vocabulary.ResourceType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class TypedResource {
  @JacksonXmlProperty(isAttribute = true, localName = "resourceTypeGeneral")
  private ResourceType general;
  @JacksonXmlText
  private String type;

}
