package org.gbif.doi.metadata.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.api.vocabulary.Language;
import org.gbif.doi.service.datacite.DataCiteValidator;
import org.gbif.utils.file.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataCiteMetadataTest {

  public static DataCiteMetadata testMetadata() {
    return testMetadata(new DOI("10.21373/WDCC/CCSRNIES_SRES_B2"), "My Title");
  }

  public static DataCiteMetadata testMetadata(DOI doi, String title) {
    return DataCiteMetadata.builder()
        .withIdentifier().withValue(doi.getDoiName()).withIdentifierType("DOI").end()
        .withResourceType(DataCiteMetadata.ResourceType.builder().withResourceTypeGeneral(ResourceType.DATASET).build())
        .withCreators().addCreator().withCreatorName().withValue("Markus").end()
        .withNameIdentifier().addNameIdentifier().withNameIdentifierScheme("ORCID")
        .withSchemeURI("orcid.org").withValue("0000-0001-7757-1889").end()
        .end()
        .end()
        .withTitles()
        .addTitle().withValue(title).withLang(Language.ENGLISH.getIso3LetterCode()).end()
        .addTitle().withValue("Meine Übersetzung").withLang(Language.GERMAN.getIso3LetterCode()).withTitleType(
            TitleType.TRANSLATED_TITLE).end()
        .end()
        .withPublicationYear("2014")
        .withPublisher().withValue("Pensoft").end()
        .build();
  }

  @Test
  public void testObjectFactory() {
    ObjectFactory of = new ObjectFactory();
    DataCiteMetadata res = of.createDataCiteMetadata();

    DataCiteMetadata.Creators creators = of.createDataCiteMetadataCreators();
    DataCiteMetadata.Creators.Creator creator = of.createDataCiteMetadataCreatorsCreator();
    DataCiteMetadata.Creators.Creator.CreatorName cn = of.createDataCiteMetadataCreatorsCreatorCreatorName();
    cn.setValue("Piyapong");
    creator.setCreatorName(cn);
    DataCiteMetadata.Creators.Creator.NameIdentifier nid = of.createDataCiteMetadataCreatorsCreatorNameIdentifier();
    nid.setValue("pc1405");
    creator.getNameIdentifier().add(nid);
    creators.getCreator().add(creator);
    res.setCreators(creators);

    DataCiteMetadata.Identifier id = of.createDataCiteMetadataIdentifier();
    id.setIdentifierType("DOI");
    id.setValue("10.21373/WDCC/CCSRNIES_SRES_B2");
    res.setIdentifier(id);

    DataCiteMetadata.Titles titles = of.createDataCiteMetadataTitles();
    DataCiteMetadata.Titles.Title title = of.createDataCiteMetadataTitlesTitle();
    title.setValue("National Institute for Environmental Studies and Center for Climate System Research Japan");
    titles.getTitle().add(title);
    res.setTitles(titles);

    res.setPublicationYear("2014");
    DataCiteMetadata.Publisher pub = of.createDataCiteMetadataPublisher();
    pub.setValue("Piyapong");
    res.setPublisher(pub);

    System.out.print(res);
  }

  @Test
  public void testBuilder() {
    DataCiteMetadata r = testMetadata();
    System.out.print(r);
  }

  @Test
  @Ignore("This fails and serves as a test only to try to serde the full datacite object into JSON for messaging")
  public void testJsonSerde() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    DataCiteMetadata m = DataCiteValidator.fromXml(FileUtils.classpathStream("metadata/datacite-example-full-v4.xml"));
    String json = mapper.writeValueAsString(m);
    DataCiteMetadata m2 = mapper.readValue(json, DataCiteMetadata.class);
    assertEquals(m, m2);
  }
}
