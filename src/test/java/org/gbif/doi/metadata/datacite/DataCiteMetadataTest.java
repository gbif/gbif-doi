package org.gbif.doi.metadata.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Contributor;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Contributor.ContributorName;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Creator;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Creator.CreatorName;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Dates.Date;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Descriptions.Description;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations.GeoLocation;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Identifier;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.RightsList.Rights;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Subjects.Subject;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Titles.Title;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Metadata helper.
 */
public class DataCiteMetadataTest {

  /**
   * Helper for providing the mock metadata object.
   */
  public static DataCiteMetadata getMockMetadata(DOI doi, String title) {
    return DataCiteMetadata.builder()
        // build titles
        .withTitles()
        .addTitle(Title.builder()
            .withLang("en-us")
            .withValue(title)
            .build())
        .addTitle(Title.builder()
            .withLang("en-us")
            .withTitleType(TitleType.SUBTITLE)
            .withValue("Demonstration of DataCite Properties.")
            .build())
        .end()

        // build publisher
        .withPublisher()
        .withValue("DataCite")
        .end()

        // build publication year
        .withPublicationYear("2014")

        // build resource type
        .withResourceType()
        .withResourceTypeGeneral(ResourceType.SOFTWARE).withValue("XML")
        .end()

        // build related identifiers
        .withRelatedIdentifiers()
        .addRelatedIdentifier(RelatedIdentifier.builder()
            .withRelatedIdentifierType(RelatedIdentifierType.URL)
            .withRelationType(RelationType.HAS_METADATA)
            .withRelatedMetadataScheme("citeproc+json")
            .withSchemeURI("https://github.com/citation-style-language/schema/raw/master/csl-data.json")
            .withValue("http://data.datacite.org/application/citeproc+json/10.21373/example-full")
            .build())
        .addRelatedIdentifier(RelatedIdentifier.builder()
            .withRelatedIdentifierType(RelatedIdentifierType.AR_XIV)
            .withRelationType(RelationType.IS_REVIEWED_BY)
            .withValue("arXiv:0706.0001")
            .build())
        .end()

        // build dates
        .withDates()
        .addDate(Date.builder()
            .withDateType(DateType.UPDATED)
            .withValue("2014-10-17")
            .build())
        .end()

        // build creators
        .withCreators()
        .addCreator(Creator.builder()
            .withCreatorName(CreatorName.builder()
                .withValue("Miller, Elizabeth")
                .build())
            .addNameIdentifier(NameIdentifier.builder()
                .withSchemeURI("http://orcid.org")
                .withNameIdentifierScheme("ORCID")
                .withValue("http://orcid.org/0000-0001-5000-0007")
                .build())
            .addAffiliation(Affiliation.builder()
                .withValue("DataCite")
                .build())
            .build())
        .end()

        // build identifier
        .withIdentifier(Identifier.builder()
            .withIdentifierType("DOI")
            .withValue(doi.getDoiName())
            .build())

        // build alternate identifiers
        .withAlternateIdentifiers()
        .addAlternateIdentifier(AlternateIdentifier.builder()
            .withAlternateIdentifierType("URL")
            .withValue("http://schema.datacite.org/schema/meta/kernel-4/example/datacite-example-full-v4.xml")
            .build())
        .end()

        // build descriptions
        .withDescriptions()
        .addDescription(Description.builder()
            .withLang("en-us")
            .withDescriptionType(DescriptionType.ABSTRACT)
            .withContent("XML example of all DataCite Metadata Schema v3.1 properties.")
            .build())
        .end()

        // build language
        .withLanguage("en-us")

        // build rights list
        .withRightsList()
        .addRights(Rights.builder()
            .withRightsURI("http://creativecommons.org/publicdomain/zero/1.0/")
            .withValue("CC0 1.0 Universal")
            .build())
        .end()

        // build geo locations
        .withGeoLocations()
        .addGeoLocation(GeoLocation.builder()
            .addGeoLocationPoint(Point.builder()
                .withPointLongitude(31.233f)
                .withPointLatitude(-67.302f)
                .build())
            .addGeoLocationBox(Box.builder()
                .withWestBoundLongitude(-71.032f)
                .withEastBoundLongitude(-68.211f)
                .withSouthBoundLatitude(41.090f)
                .withNorthBoundLatitude(42.893f)
                .build())
            .addGeoLocationPlace("Atlantic Ocean")
            .build())
        .end()

        // build version
        .withVersion("3.1")

        // build sizes
        .withSizes()
        .addSize("3KB")
        .end()

        // build formats
        .withFormats()
        .addFormat("application/xml")
        .end()

        // build contributors
        .withContributors()
        .addContributor(Contributor.builder()
            .withContributorType(ContributorType.PROJECT_LEADER)
            .withContributorName(ContributorName.builder()
                .withValue("Starr, Joan")
                .build())
            .withNameIdentifier(NameIdentifier.builder()
                .withSchemeURI("http://orcid.org/")
                .withNameIdentifierScheme("ORCID")
                .withValue("http://orcid.org/0000-0002-7285-027X")
                .build())
            .withAffiliation(Affiliation.builder()
                .withValue("California Digital Library")
                .build())
            .build())
        .end()

        // build subjects
        .withSubjects()
        .addSubject(Subject.builder()
            .withLang("en-us")
            .withSchemeURI("http://dewey.info/")
            .withSubjectScheme("dewey")
            .withValue("000 computer science")
            .build())
        .end()
        .build();
  }

  /**
   * Just check everything was generated properly.
   */
  @Test
  public void testObjectFactory() {
    ObjectFactory of = new ObjectFactory();
    DataCiteMetadata res = of.createDataCiteMetadata();

    DataCiteMetadata.Creators creators = of.createDataCiteMetadataCreators();
    Creator creator = of.createDataCiteMetadataCreatorsCreator();
    CreatorName cn = of.createDataCiteMetadataCreatorsCreatorCreatorName();
    cn.setValue("Piyapong");
    creator.setCreatorName(cn);

    NameIdentifier nid = of.createNameIdentifier();
    nid.setValue("pc1405");
    creator.getNameIdentifier().add(nid);
    creators.getCreator().add(creator);
    res.setCreators(creators);

    Identifier id = of.createDataCiteMetadataIdentifier();
    id.setIdentifierType("DOI");
    id.setValue("10.21373/WDCC/CCSRNIES_SRES_B2");
    res.setIdentifier(id);

    DataCiteMetadata.Titles titles = of.createDataCiteMetadataTitles();
    Title title = of.createDataCiteMetadataTitlesTitle();
    title.setValue("National Institute for Environmental Studies and Center for Climate System Research Japan");
    titles.getTitle().add(title);
    res.setTitles(titles);

    res.setPublicationYear("2014");
    DataCiteMetadata.Publisher pub = of.createDataCiteMetadataPublisher();
    pub.setValue("Piyapong");
    res.setPublisher(pub);

    assertNotNull(res);
    System.out.print(res);
  }
}
