package org.gbif.doi.api.datacite;

import org.gbif.api.vocabulary.Language;
import org.gbif.doi.api.datacite.model.AgentTest;
import org.gbif.doi.api.datacite.model.AlternateIdentifierTest;
import org.gbif.doi.api.datacite.model.GeoLocationTest;
import org.gbif.doi.api.datacite.model.RelatedIdentifierTest;
import org.gbif.doi.api.datacite.model.SubjectTest;
import org.gbif.doi.api.datacite.model.TypedAgentTest;
import org.gbif.doi.api.datacite.model.TypedDateTest;
import org.gbif.doi.api.datacite.model.TypedDescriptionTest;
import org.gbif.doi.api.datacite.model.TypedTitleTest;
import org.gbif.doi.api.datacite.vocabulary.ResourceTypeGeneral;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataCiteMetadataV3Test {

  /**
   * Test that the builder operates.
   */
  @Test
  public void testMetadataBuilder() throws URISyntaxException {

    DataCiteMetadataV3.Builder builder = DataCiteMetadataV3.builder();
    DataCiteMetadataV3 metadata = builder.doi("10.1234/foo").appendCreator(AgentTest.agent)
      .appendAlternateIdentifier(AlternateIdentifierTest.alternateIdentifier)
      .appendGeoLocation(GeoLocationTest.geoLocation).appendRelatedIdentifier(RelatedIdentifierTest.relatedIdentifier)
      .appendSubject(SubjectTest.subject).appendContributor(TypedAgentTest.typedAgent)
      .appendTypedDate(TypedDateTest.typedDate).appendTypedDescription(TypedDescriptionTest.description)
      .appendTypedTitle(TypedTitleTest.title).appendSize("6 MB").appendFormat("DwC-A").appendRight("Under CC0")
      .licenseTitle("CC0").licenseUri(new URI("http://creativecommons.org/publicdomain/zero/1.0/legalcode"))
      .publisher("NHM").publicationYear(2011).language(Language.FRENCH).resourceTypeGeneral(ResourceTypeGeneral.DATASET)
      .resourceType("Species observations").version("1.3").build();

    assertEquals("10.1234/foo", metadata.getDoi());
    // Creators
    assertEquals(1, metadata.getCreators().size());
    AgentTest.verifyAgent(metadata.getCreators().get(0));
    // AlternateIdentifiers
    assertEquals(1, metadata.getAlternateIdentifiers().size());
    AlternateIdentifierTest.verifyAlternateIdentifier(metadata.getAlternateIdentifiers().get(0));
    // GeoLocation
    assertEquals(1, metadata.getGeoLocations().size());
    GeoLocationTest.verifyGeoLocation(metadata.getGeoLocations().get(0));
    // RelatedIdentifier
    assertEquals(1, metadata.getRelatedIdentifiers().size());
    RelatedIdentifierTest.verifyRelatedIdentifier(metadata.getRelatedIdentifiers().get(0));
    // Subject
    assertEquals(1, metadata.getSubjects().size());
    SubjectTest.verifySubject(metadata.getSubjects().get(0));
    // Contributor
    assertEquals(1, metadata.getContributors().size());
    TypedAgentTest.verifyTypedAgent(metadata.getContributors().get(0));
    // Dates
    assertEquals(1, metadata.getDates().size());
    TypedDateTest.verifyTypedDate(metadata.getDates().get(0));
    // Description
    assertEquals(1, metadata.getDescriptions().size());
    TypedDescriptionTest.verifyTypedDescription(metadata.getDescriptions().get(0));
    // Title
    assertEquals(1, metadata.getTitles().size());
    TypedTitleTest.verifyTypedTitle(metadata.getTitles().get(0));
    // Size
    assertEquals(1, metadata.getSizes().size());
    assertEquals("6 MB", metadata.getSizes().get(0));
    // Format
    assertEquals(1, metadata.getFormats().size());
    assertEquals("DwC-A", metadata.getFormats().get(0));
    // Rights
    assertEquals(1, metadata.getRights().size());
    assertEquals("Under CC0", metadata.getRights().get(0));
    // License Title
    assertEquals("CC0", metadata.getLicenseTitle());
    // License URI
    assertEquals("http://creativecommons.org/publicdomain/zero/1.0/legalcode", metadata.getLicenseUri().toString());
    // Publisher
    assertEquals("NHM", metadata.getPublisher());
    // Publication Year
    assertEquals("2011", String.valueOf(metadata.getPublicationYear()));
    // Language
    assertEquals("fr", metadata.getLanguage().getIso2LetterCode().toLowerCase());
    // ResourceTypeGeneral
    assertEquals(ResourceTypeGeneral.DATASET, metadata.getResourceTypeGeneral());
    // ResourceType
    assertEquals("Species observations", metadata.getResourceType());
    // Version
    assertEquals("1.3", metadata.getVersion());
  }
}
