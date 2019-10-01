package org.gbif.doi.metadata.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.AlternateIdentifiers;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Contributor;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Contributor.ContributorName;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Creator;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Creator.CreatorName;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Dates;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Dates.Date;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Descriptions;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Descriptions.Description;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Formats;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations.GeoLocation;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Identifier;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Publisher;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.RelatedIdentifiers;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.RightsList;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.RightsList.Rights;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Sizes;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Subjects;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Subjects.Subject;
import org.gbif.doi.metadata.datacite.DataCiteMetadata.Titles;
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
        .withTitles(Titles.builder()
            .addTitle(Title.builder()
                .withLang("en-us")
                .withValue(title)
                .build())
            .addTitle(Title.builder()
                .withLang("en-us")
                .withTitleType(TitleType.SUBTITLE)
                .withValue("Demonstration of DataCite Properties.")
                .build())
            .build())

        // build publisher
        .withPublisher(Publisher.builder()
            .withValue("DataCite")
            .build())

        // build publication year
        .withPublicationYear("2014")

        // build resource type
        .withResourceType(DataCiteMetadata.ResourceType.builder()
            .withResourceTypeGeneral(ResourceType.SOFTWARE)
            .withValue("XML")
            .build())

        // build related identifiers
        .withRelatedIdentifiers(RelatedIdentifiers.builder()
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
            .build())

        // build dates
        .withDates(Dates.builder()
            .addDate(Date.builder()
                .withDateType(DateType.UPDATED)
                .withValue("2014-10-17")
                .build())
            .build())

        // build creators
        .withCreators(Creators.builder()
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
            .build())

        // build identifier
        .withIdentifier(Identifier.builder()
            .withIdentifierType("DOI")
            .withValue(doi.getDoiName())
            .build())

        // build alternate identifiers
        .withAlternateIdentifiers(AlternateIdentifiers.builder()
            .addAlternateIdentifier(AlternateIdentifier.builder()
                .withAlternateIdentifierType("URL")
                .withValue("http://schema.datacite.org/schema/meta/kernel-4/example/datacite-example-full-v4.xml")
                .build())
            .build())

        // build descriptions
        .withDescriptions(Descriptions.builder()
            .addDescription(Description.builder()
                .withLang("en-us")
                .withDescriptionType(DescriptionType.ABSTRACT)
                .withContent("XML example of all DataCite Metadata Schema v3.1 properties.")
                .build())
            .build())

        // build language
        .withLanguage("en-us")

        // build rights list
        .withRightsList(RightsList.builder()
            .addRights(Rights.builder()
                .withRightsURI("http://creativecommons.org/publicdomain/zero/1.0/")
                .withValue("CC0 1.0 Universal")
                .build())
            .build())

        // build geo locations
        .withGeoLocations(GeoLocations.builder()
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
            .build())

        // build version
        .withVersion("3.1")

        // build sizes
        .withSizes(Sizes.builder()
            .addSize("3KB")
            .build())

        // build formats
        .withFormats(Formats.builder()
            .addFormat("application/xml")
            .build())

        // build contributors
        .withContributors(Contributors.builder()
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
            .build())

        // build subjects
        .withSubjects(Subjects.builder()
            .addSubject(Subject.builder()
                .withLang("en-us")
                .withSchemeURI("http://dewey.info/")
                .withSubjectScheme("dewey")
                .withValue("000 computer science")
                .build())
            .build())
        .build();
  }

  /**
   * Just check everything was generated properly.
   */
  @Test
  public void testObjectFactory() {
    ObjectFactory of = new ObjectFactory();
    DataCiteMetadata res = of.createDataCiteMetadata();

    Creators creators = of.createDataCiteMetadataCreators();
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

    Titles titles = of.createDataCiteMetadataTitles();
    Title title = of.createDataCiteMetadataTitlesTitle();
    title.setValue("National Institute for Environmental Studies and Center for Climate System Research Japan");
    titles.getTitle().add(title);
    res.setTitles(titles);

    res.setPublicationYear("2014");
    Publisher pub = of.createDataCiteMetadataPublisher();
    pub.setValue("Piyapong");
    res.setPublisher(pub);

    assertNotNull(res);
    System.out.print(res);
  }
}
