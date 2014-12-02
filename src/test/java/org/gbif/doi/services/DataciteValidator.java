package org.gbif.doi.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * For the validation of DataCite metadata files.
 */
public class DataciteValidator {
  private static Validator DATACITE_VALIDATOR;

  /**
   * @return an xml validator based on the DataCite metadata schema version 3
   */
  public static void validateMetadata(String xml) throws IOException, SAXException {
    getValidator().validate(new StreamSource(new StringReader(xml)));
  }

  public static void validateMetadata(InputStream xml) throws IOException, SAXException {
    getValidator().validate(new StreamSource(xml));
  }

  private static Validator getValidator() throws IOException, SAXException {
    if (DATACITE_VALIDATOR == null) {
      // define the type of schema - we use W3C:
      String schemaLang = "http://www.w3.org/2001/XMLSchema";
      // get validation driver:
      SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
      // create schema by reading it from an URL:
      //File f = FileUtils.getClasspathFile("datacite/metadata.xsd");
      Schema schema = factory.newSchema(new StreamSource("http://schema.datacite.org/meta/kernel-3/metadata.xsd"));
      DATACITE_VALIDATOR = schema.newValidator();
    }
    return DATACITE_VALIDATOR;
  }

}
