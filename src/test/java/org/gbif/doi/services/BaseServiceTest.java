package org.gbif.doi.services;

import org.gbif.api.vocabulary.Language;
import org.gbif.doi.datacite.DataCiteMetadataV3;
import org.gbif.doi.datacite.model.Contributor;
import org.gbif.doi.datacite.model.Creator;
import org.gbif.doi.datacite.model.NameIdentifier;
import org.gbif.doi.datacite.model.TypedDate;
import org.gbif.doi.datacite.model.TypedTitle;
import org.gbif.doi.datacite.vocabulary.ContributorType;
import org.gbif.doi.datacite.vocabulary.DateType;
import org.gbif.doi.datacite.vocabulary.TitleType;

import org.junit.Test;

public class BaseServiceTest {

  @Test
  public void testXmlSerde() throws Exception {

    DataCiteMetadataV3 d = DataCiteMetadataV3.builder().doi("doi:10.1038/nature01851").appendCreator(
      Creator.builder().identifier(new NameIdentifier("me23", "ORCID", "orcid.org")).appendAffiliation("GBIF")
        .appendAffiliation("TDWG").name("Markus").build()).appendCreator(
      Creator.builder().identifier(new NameIdentifier("him24", "ORCID", "orcid.org")).name("Klaas").build())
      .appendFormat("xml").appendFormat("json").appendSize("10MB").appendTypedTitle(
        TypedTitle.builder().title("Hau chanit").language(Language.AFRIKAANS).type(TitleType.TRANSLATED_TITLE).build())
      .appendTypedTitle(
        TypedTitle.builder().title("Hallo").language(Language.ENGLISH).type(TitleType.ALTERNATIVE_TITLE).build())
      .appendContributor(
        Contributor.builder().identifier(new NameIdentifier("me23", "ORCID", "orcid.org")).appendAffiliation("GBIF")
          .appendAffiliation("TDWG").name("Markus").type(ContributorType.DATA_MANAGER).build()).appendContributor(
        Contributor.builder().identifier(new NameIdentifier("him24", "ORCID", "orcid.org")).name("Klaas")
          .type(ContributorType.CONTACT_PERSON).build())
      .appendTypedDate(TypedDate.builder().dates("2014").type(DateType.UPDATED).build())
      .appendTypedDate(TypedDate.builder().dates("1987-03-01").type(DateType.CREATED).build())
      .language(Language.AFRIKAANS).build();

    String xml = BaseService.xmlMapper.writeValueAsString(d);
    System.out.println(xml);

    DataciteValidator.validateMetadata(xml);

  }
}