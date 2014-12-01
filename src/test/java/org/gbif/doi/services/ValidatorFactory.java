package org.gbif.doi.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * For the validation of DataCite metadata files.
 */
public class ValidatorFactory {

  public static final String DATACITE_SCHEMA_URL = "http://schema.xsd.datacite.org/meta/kernel-3/metadata.xsd";

  /**
   * @return an xml validator based on the DataCite metadata schema version 3
   */
  public static Validator getDataciteValidator() throws MalformedURLException, SAXException {
    return getValidator(DATACITE_SCHEMA_URL);
  }

  private static Validator getValidator(String schemaUrl) throws MalformedURLException, SAXException {
    // define the type of schema - we use W3C:
    String schemaLang = "http://www.w3.org/2001/XMLSchema";
    // get validation driver:
    SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
    // create schema by reading it from an URL:
    Schema schema = factory.newSchema(new URL(schemaUrl));
    return schema.newValidator();
  }
}
