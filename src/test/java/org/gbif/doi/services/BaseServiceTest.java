package org.gbif.doi.services;

import org.gbif.api.vocabulary.Language;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.ResourceType;
import org.gbif.doi.metadata.datacite.TitleType;

import junit.framework.TestCase;
import org.junit.Test;

public class BaseServiceTest extends TestCase {

  static class FakeService extends BaseService {
    protected FakeService() {
      super(null, "", "");
    }
  }

  @Test
  public void testToXml() throws Exception {
    BaseService bs = new FakeService();

    DataCiteMetadata d = DataCiteMetadata.builder()
      .withResourceType(DataCiteMetadata.ResourceType.builder().withResourceTypeGeneral(ResourceType.DATASET).build())
      .withCreators()
      .addCreator().withCreatorName("Markus")
      .withNameIdentifier().withNameIdentifierScheme("ORCID").withSchemeURI("orcid.org").withValue("12445322").end()
      .end()
      .end()
      .withTitles()
      .addTitle().withValue("My Title").withLang(Language.GERMAN.getIso3LetterCode()).withTitleType(
        TitleType.TRANSLATED_TITLE).end()
      .end()
      .build();

    String xml = bs.toXml(d);
    System.out.println(xml);

//    DataciteValidator.validateMetadata(xml);
  }
}