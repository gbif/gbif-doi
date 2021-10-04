/*
 * Copyright 2021 Global Biodiversity Information Facility (GBIF)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gbif.doi.metadata.datacite;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.gbif.doi.metadata.datacite package.
 *
 * <p>An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type definitions, element
 * declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

  private static final QName _DataCiteMetadataDescriptionsDescriptionBr_QNAME =
      new QName("http://datacite.org/schema/kernel-4", "br");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: org.gbif.doi.metadata.datacite
   */
  public ObjectFactory() {}

  /** Create an instance of {@link DataCiteMetadata } */
  public DataCiteMetadata createDataCiteMetadata() {
    return new DataCiteMetadata();
  }

  /** Create an instance of {@link DataCiteMetadata.FundingReferences } */
  public DataCiteMetadata.FundingReferences createDataCiteMetadataFundingReferences() {
    return new DataCiteMetadata.FundingReferences();
  }

  /** Create an instance of {@link DataCiteMetadata.FundingReferences.FundingReference } */
  public DataCiteMetadata.FundingReferences.FundingReference
      createDataCiteMetadataFundingReferencesFundingReference() {
    return new DataCiteMetadata.FundingReferences.FundingReference();
  }

  /** Create an instance of {@link DataCiteMetadata.GeoLocations } */
  public DataCiteMetadata.GeoLocations createDataCiteMetadataGeoLocations() {
    return new DataCiteMetadata.GeoLocations();
  }

  /** Create an instance of {@link DataCiteMetadata.GeoLocations.GeoLocation } */
  public DataCiteMetadata.GeoLocations.GeoLocation createDataCiteMetadataGeoLocationsGeoLocation() {
    return new DataCiteMetadata.GeoLocations.GeoLocation();
  }

  /** Create an instance of {@link DataCiteMetadata.Descriptions } */
  public DataCiteMetadata.Descriptions createDataCiteMetadataDescriptions() {
    return new DataCiteMetadata.Descriptions();
  }

  /** Create an instance of {@link DataCiteMetadata.Descriptions.Description } */
  public DataCiteMetadata.Descriptions.Description createDataCiteMetadataDescriptionsDescription() {
    return new DataCiteMetadata.Descriptions.Description();
  }

  /** Create an instance of {@link DataCiteMetadata.RightsList } */
  public DataCiteMetadata.RightsList createDataCiteMetadataRightsList() {
    return new DataCiteMetadata.RightsList();
  }

  /** Create an instance of {@link DataCiteMetadata.RelatedIdentifiers } */
  public DataCiteMetadata.RelatedIdentifiers createDataCiteMetadataRelatedIdentifiers() {
    return new DataCiteMetadata.RelatedIdentifiers();
  }

  /** Create an instance of {@link DataCiteMetadata.AlternateIdentifiers } */
  public DataCiteMetadata.AlternateIdentifiers createDataCiteMetadataAlternateIdentifiers() {
    return new DataCiteMetadata.AlternateIdentifiers();
  }

  /** Create an instance of {@link DataCiteMetadata.Dates } */
  public DataCiteMetadata.Dates createDataCiteMetadataDates() {
    return new DataCiteMetadata.Dates();
  }

  /** Create an instance of {@link DataCiteMetadata.Contributors } */
  public DataCiteMetadata.Contributors createDataCiteMetadataContributors() {
    return new DataCiteMetadata.Contributors();
  }

  /** Create an instance of {@link DataCiteMetadata.Contributors.Contributor } */
  public DataCiteMetadata.Contributors.Contributor createDataCiteMetadataContributorsContributor() {
    return new DataCiteMetadata.Contributors.Contributor();
  }

  /** Create an instance of {@link DataCiteMetadata.Subjects } */
  public DataCiteMetadata.Subjects createDataCiteMetadataSubjects() {
    return new DataCiteMetadata.Subjects();
  }

  /** Create an instance of {@link DataCiteMetadata.Titles } */
  public DataCiteMetadata.Titles createDataCiteMetadataTitles() {
    return new DataCiteMetadata.Titles();
  }

  /** Create an instance of {@link DataCiteMetadata.Creators } */
  public DataCiteMetadata.Creators createDataCiteMetadataCreators() {
    return new DataCiteMetadata.Creators();
  }

  /** Create an instance of {@link DataCiteMetadata.Creators.Creator } */
  public DataCiteMetadata.Creators.Creator createDataCiteMetadataCreatorsCreator() {
    return new DataCiteMetadata.Creators.Creator();
  }

  /** Create an instance of {@link NameIdentifier } */
  public NameIdentifier createNameIdentifier() {
    return new NameIdentifier();
  }

  /** Create an instance of {@link Affiliation } */
  public Affiliation createAffiliation() {
    return new Affiliation();
  }

  /** Create an instance of {@link Point } */
  public Point createPoint() {
    return new Point();
  }

  /** Create an instance of {@link Box } */
  public Box createBox() {
    return new Box();
  }

  /** Create an instance of {@link DataCiteMetadata.Identifier } */
  public DataCiteMetadata.Identifier createDataCiteMetadataIdentifier() {
    return new DataCiteMetadata.Identifier();
  }

  /** Create an instance of {@link DataCiteMetadata.Publisher } */
  public DataCiteMetadata.Publisher createDataCiteMetadataPublisher() {
    return new DataCiteMetadata.Publisher();
  }

  /** Create an instance of {@link DataCiteMetadata.ResourceType } */
  public DataCiteMetadata.ResourceType createDataCiteMetadataResourceType() {
    return new DataCiteMetadata.ResourceType();
  }

  /** Create an instance of {@link DataCiteMetadata.Sizes } */
  public DataCiteMetadata.Sizes createDataCiteMetadataSizes() {
    return new DataCiteMetadata.Sizes();
  }

  /** Create an instance of {@link DataCiteMetadata.Formats } */
  public DataCiteMetadata.Formats createDataCiteMetadataFormats() {
    return new DataCiteMetadata.Formats();
  }

  /**
   * Create an instance of {@link
   * DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier }
   */
  public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
      createDataCiteMetadataFundingReferencesFundingReferenceFunderIdentifier() {
    return new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier();
  }

  /**
   * Create an instance of {@link DataCiteMetadata.FundingReferences.FundingReference.AwardNumber }
   */
  public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber
      createDataCiteMetadataFundingReferencesFundingReferenceAwardNumber() {
    return new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber();
  }

  /** Create an instance of {@link DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon } */
  public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon
      createDataCiteMetadataGeoLocationsGeoLocationGeoLocationPolygon() {
    return new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon();
  }

  /** Create an instance of {@link DataCiteMetadata.Descriptions.Description.Br } */
  public DataCiteMetadata.Descriptions.Description.Br
      createDataCiteMetadataDescriptionsDescriptionBr() {
    return new DataCiteMetadata.Descriptions.Description.Br();
  }

  /** Create an instance of {@link DataCiteMetadata.RightsList.Rights } */
  public DataCiteMetadata.RightsList.Rights createDataCiteMetadataRightsListRights() {
    return new DataCiteMetadata.RightsList.Rights();
  }

  /** Create an instance of {@link DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier } */
  public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier
      createDataCiteMetadataRelatedIdentifiersRelatedIdentifier() {
    return new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier();
  }

  /** Create an instance of {@link DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier } */
  public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier
      createDataCiteMetadataAlternateIdentifiersAlternateIdentifier() {
    return new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier();
  }

  /** Create an instance of {@link DataCiteMetadata.Dates.Date } */
  public DataCiteMetadata.Dates.Date createDataCiteMetadataDatesDate() {
    return new DataCiteMetadata.Dates.Date();
  }

  /** Create an instance of {@link DataCiteMetadata.Contributors.Contributor.ContributorName } */
  public DataCiteMetadata.Contributors.Contributor.ContributorName
      createDataCiteMetadataContributorsContributorContributorName() {
    return new DataCiteMetadata.Contributors.Contributor.ContributorName();
  }

  /** Create an instance of {@link DataCiteMetadata.Subjects.Subject } */
  public DataCiteMetadata.Subjects.Subject createDataCiteMetadataSubjectsSubject() {
    return new DataCiteMetadata.Subjects.Subject();
  }

  /** Create an instance of {@link DataCiteMetadata.Titles.Title } */
  public DataCiteMetadata.Titles.Title createDataCiteMetadataTitlesTitle() {
    return new DataCiteMetadata.Titles.Title();
  }

  /** Create an instance of {@link DataCiteMetadata.Creators.Creator.CreatorName } */
  public DataCiteMetadata.Creators.Creator.CreatorName
      createDataCiteMetadataCreatorsCreatorCreatorName() {
    return new DataCiteMetadata.Creators.Creator.CreatorName();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link
   * DataCiteMetadata.Descriptions.Description.Br }{@code >}
   *
   * @param value Java instance representing xml element's value.
   * @return the new instance of {@link JAXBElement }{@code <}{@link
   *     DataCiteMetadata.Descriptions.Description.Br }{@code >}
   */
  @XmlElementDecl(
      namespace = "http://datacite.org/schema/kernel-4",
      name = "br",
      scope = DataCiteMetadata.Descriptions.Description.class)
  public JAXBElement<DataCiteMetadata.Descriptions.Description.Br>
      createDataCiteMetadataDescriptionsDescriptionBr(
          DataCiteMetadata.Descriptions.Description.Br value) {
    return new JAXBElement<DataCiteMetadata.Descriptions.Description.Br>(
        _DataCiteMetadataDescriptionsDescriptionBr_QNAME,
        DataCiteMetadata.Descriptions.Description.Br.class,
        DataCiteMetadata.Descriptions.Description.class,
        value);
  }
}
