package org.gbif.doi.datacite;

import org.gbif.api.vocabulary.Language;
import org.gbif.doi.datacite.model.Contributor;
import org.gbif.doi.datacite.model.Creator;
import org.gbif.doi.datacite.model.NameIdentifier;
import org.gbif.doi.datacite.model.TypedDate;
import org.gbif.doi.datacite.model.TypedTitle;
import org.gbif.doi.datacite.vocabulary.ContributorType;
import org.gbif.doi.datacite.vocabulary.DateType;
import org.gbif.doi.datacite.vocabulary.TitleType;
import org.gbif.utils.file.InputStreamUtils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Test;

public class DataCiteMetadataV3Test {
  InputStreamUtils isu = new InputStreamUtils();



}