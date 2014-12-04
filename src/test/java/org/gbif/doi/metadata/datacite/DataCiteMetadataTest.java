package org.gbif.doi.metadata.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.api.vocabulary.Language;

import org.junit.Test;

public class DataCiteMetadataTest {

  public static DataCiteMetadata testMetadata() {
    return testMetadata(new DOI("10.5072/WDCC/CCSRNIES_SRES_B2"), "My Title");
  }
  public static DataCiteMetadata testMetadata(DOI doi, String title) {
    return DataCiteMetadata.builder()
      .withIdentifier().withValue(doi.getDoiName()).withIdentifierType("DOI").end()
      .withResourceType(DataCiteMetadata.ResourceType.builder().withResourceTypeGeneral(ResourceType.DATASET).build())
      .withCreators()
      .addCreator().withCreatorName("Markus")
      .withNameIdentifier().withNameIdentifierScheme("ORCID").withSchemeURI("orcid.org").withValue("0000-0001-7757-1889").end()
      .end()
      .end()
      .withTitles()
      .addTitle().withValue(title).withLang(Language.ENGLISH.getIso3LetterCode()).end()
      .addTitle().withValue("Meine Übersetzung").withLang(Language.GERMAN.getIso3LetterCode()).withTitleType(
        TitleType.TRANSLATED_TITLE).end()
      .end()
      .withPublicationYear("2014")
      .withPublisher("Pensoft")
      .build();
  }

  @Test
  public void testObjectFactory() throws Exception {
    ObjectFactory of = new ObjectFactory();
    DataCiteMetadata res = of.createDataCiteMetadata();

    DataCiteMetadata.Creators creators = of.createDataCiteMetadataCreators();
    DataCiteMetadata.Creators.Creator creator = of.createDataCiteMetadataCreatorsCreator();
    creator.setCreatorName("Piyapong");
    DataCiteMetadata.Creators.Creator.NameIdentifier nid = of.createDataCiteMetadataCreatorsCreatorNameIdentifier();
    nid.setValue("pc1405");
    creator.setNameIdentifier(nid);
    creators.getCreator().add(creator);
    res.setCreators(creators);

    DataCiteMetadata.Identifier id = of.createDataCiteMetadataIdentifier();
    id.setIdentifierType("DOI");
    id.setValue("10.5072/WDCC/CCSRNIES_SRES_B2");
    res.setIdentifier(id);

    DataCiteMetadata.Titles titles = of.createDataCiteMetadataTitles();
    DataCiteMetadata.Titles.Title title = of.createDataCiteMetadataTitlesTitle();
    title.setValue("National Institute for Environmental Studies and Center for Climate System Research Japan");
    titles.getTitle().add(title);
    res.setTitles(titles);

    res.setPublicationYear("2014");
    res.setPublisher("Piyapong");

    System.out.print(res);
  }

  @Test
  public void testBuilder() throws Exception {
    DataCiteMetadata r = testMetadata();
    System.out.print(r);
  }
}