package org.gbif.doi.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.api.vocabulary.Language;
import org.gbif.doi.datacite.model.Contributor;
import org.gbif.doi.datacite.model.Creator;
import org.gbif.doi.datacite.model.NameIdentifier;
import org.gbif.doi.datacite.model.TypedDate;
import org.gbif.doi.datacite.model.TypedTitle;
import org.gbif.doi.datacite.vocabulary.ContributorType;
import org.gbif.doi.datacite.vocabulary.NameIdentifierScheme;
import org.gbif.doi.datacite.vocabulary.TitleType;
import org.gbif.utils.file.InputStreamUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Test;

public class DataCiteMetadataV3Test {
  InputStreamUtils isu = new InputStreamUtils();

  @Test
  public void testSerde() throws Exception {

    JAXBContext context = JAXBContext.newInstance( DataCiteMetadataV3.class );

    DataCiteMetadataV3 r = new DataCiteMetadataV3 ();
    r.setDoi(new DOI("doi:10.1038/nature01851"));

    Marshaller m = context.createMarshaller();
    m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
    m.marshal( r, System.out );

    Unmarshaller um = context.createUnmarshaller();
    r = (DataCiteMetadataV3) um.unmarshal(isu.classpathStream("metadata/datacite_sample.xml"));

  }

  @Test
  public void testJacksonSerde() throws Exception {
    JacksonXmlModule module = new JacksonXmlModule();
    module.setDefaultUseWrapper(true);
    module.addSerializer(Language.class, LanguageSerde.serializer);
    module.addDeserializer(Language.class, LanguageSerde.deserializer);

    XmlMapper xmlMapper = new XmlMapper(module);
    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    xmlMapper.configure( ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true );

    DataCiteMetadataV3 d = DataCiteMetadataV3.builder()
      .doi("doi:10.1038/nature01851")
      .appendCreator(
        Creator.builder().identifier(new NameIdentifier("me23", NameIdentifierScheme.ORCID)).appendAffiliation("GBIF")
          .appendAffiliation("TDWG").name("Markus").build())
      .appendCreator(
        Creator.builder().identifier(new NameIdentifier("him24", NameIdentifierScheme.ORCID)).name("Klaas").build())
      .appendFormat("xml")
      .appendFormat("json")
      .appendSize("10MB")
      .appendTypedTitle(
        TypedTitle.builder().title("Hau chanit").language(Language.AFRIKAANS).type(TitleType.TRANSLATED_TITLE).build())
      .appendTypedTitle(
        TypedTitle.builder().title("Hallo").language(Language.ENGLISH).type(TitleType.ALTERNATIVE_TITLE).build())
      .appendContributor(Contributor.builder().identifier(new NameIdentifier("me23", NameIdentifierScheme.ORCID))
          .appendAffiliation("GBIF").appendAffiliation("TDWG").name("Markus").type(ContributorType.DATA_MANAGER).build())
      .appendContributor(
        Contributor.builder().identifier(new NameIdentifier("him24", NameIdentifierScheme.ORCID)).name("Klaas").build())
      .appendTypedDate(TypedDate.builder().dates("2014").type("Updated").build())
      .appendTypedDate(TypedDate.builder().dates("1987-03-01").type("Created").build())
      .language(Language.AFRIKAANS)
      .build();

    String xml = xmlMapper.writeValueAsString(d);
    System.out.println(xml);
  }


}