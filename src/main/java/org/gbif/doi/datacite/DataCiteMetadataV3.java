package org.gbif.doi.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.api.vocabulary.IdentifierType;
import org.gbif.api.vocabulary.Language;
import org.gbif.doi.datacite.model.AlternateIdentifier;
import org.gbif.doi.datacite.model.Contributor;
import org.gbif.doi.datacite.model.Creator;
import org.gbif.doi.datacite.model.GeoLocation;
import org.gbif.doi.datacite.model.RelatedIdentifier;
import org.gbif.doi.datacite.model.Subject;
import org.gbif.doi.datacite.model.TypedDate;
import org.gbif.doi.datacite.model.TypedDescription;
import org.gbif.doi.datacite.model.TypedTitle;
import org.gbif.doi.datacite.vocabulary.ResourceTypeGeneral;

import java.net.URI;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.common.collect.Lists;

/**
 * Class representing DataCite metadata XML document version 3.
 * This class is mutable with a builder and therefore not thread safe.
 * Mandatory elements are indicated with @NotNull annotations.
 */
@JacksonXmlRootElement( localName = "resource" )
public class DataCiteMetadataV3 {
  @JacksonXmlProperty(localName = "xmlns", isAttribute = true)
  private String NS = "http://datacite.org/schema/kernel-3";
  public static class Builder {

    private DOI doi; // TODO use our DOI object
    private List<Creator> creators = Lists.newArrayList();
    private List<Contributor> contributors = Lists.newArrayList();
    private List<TypedTitle> titles = Lists.newArrayList();
    private List<TypedDate> dates = Lists.newArrayList();
    private String publisher;
    private Integer publicationYear;
    private List<Subject> subjects = Lists.newArrayList();
    private Language language = Language.ENGLISH; // default
    private ResourceTypeGeneral resourceTypeGeneral;
    private String resourceType;
    private List<AlternateIdentifier> alternateIdentifiers = Lists.newArrayList();
    private List<RelatedIdentifier> relatedIdentifiers = Lists.newArrayList();
    private List<String> sizes = Lists.newArrayList();
    private List<String> formats = Lists.newArrayList();
    private String version;
    private List<String> rights = Lists.newArrayList();
    private URI licenseUri;
    private String licenseTitle;
    private List<TypedDescription> descriptions = Lists.newArrayList();
    private List<GeoLocation> geoLocations = Lists.newArrayList();

    public Builder doi(String doi) {
      this.doi = new DOI(doi);
      return this;
    }

    public Builder doi(DOI doi) {
      this.doi = doi;
      return this;
    }

    public Builder appendCreator(Creator creator) {
      if (creator != null) {
        this.creators.add(creator);
      }
      return this;
    }

    public Builder appendAlternateIdentifier(AlternateIdentifier identifier) {
      if (identifier != null) {
        this.alternateIdentifiers.add(identifier);
      }
      return this;
    }

    public Builder appendGeoLocation(GeoLocation geoLocation) {
      if (geoLocation != null) {
        this.geoLocations.add(geoLocation);
      }
      return this;
    }

    public Builder appendRelatedIdentifier(RelatedIdentifier identifier) {
      if (identifier != null) {
        this.relatedIdentifiers.add(identifier);
      }
      return this;
    }

    public Builder appendSubject(Subject subject) {
      if (subject != null) {
        this.subjects.add(subject);
      }
      return this;
    }

    public Builder appendContributor(Contributor agent) {
      if (agent != null) {
        this.contributors.add(agent);
      }
      return this;
    }

    public Builder appendTypedDate(TypedDate date) {
      if (date != null) {
        this.dates.add(date);
      }
      return this;
    }

    public Builder appendTypedDescription(TypedDescription description) {
      if (description != null) {
        this.descriptions.add(description);
      }
      return this;
    }

    public Builder appendTypedTitle(TypedTitle title) {
      if (title != null) {
        this.titles.add(title);
      }
      return this;
    }

    public Builder appendSize(String size) {
      if (size != null) {
        this.sizes.add(size);
      }
      return this;
    }

    public Builder appendFormat(String format) {
      if (format != null) {
        this.formats.add(format);
      }
      return this;
    }

    public Builder appendRight(String right) {
      if (right != null) {
        this.rights.add(right);
      }
      return this;
    }

    public Builder publisher(String publisher) {
      this.publisher = publisher;
      return this;
    }

    public Builder publicationYear(Integer publicationYear) {
      this.publicationYear = publicationYear;
      return this;
    }

    public Builder language(Language language) {
      this.language = language;
      return this;
    }

    public Builder resourceTypeGeneral(ResourceTypeGeneral resourceTypeGeneral) {
      this.resourceTypeGeneral = resourceTypeGeneral;
      return this;
    }

    public Builder resourceType(String resourceType) {
      this.resourceType = resourceType;
      return this;
    }

    public Builder version(String version) {
      this.version = version;
      return this;
    }

    public Builder licenseUri(URI licenseUri) {
      this.licenseUri = licenseUri;
      return this;
    }

    public Builder licenseTitle(String licenseTitle) {
      this.licenseTitle = licenseTitle;
      return this;
    }


    public DataCiteMetadataV3 build() {
      return new DataCiteMetadataV3(this);
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -6325204169161362016L;

  private static final IdentifierType IDENTIFIER_TYPE = IdentifierType.DOI;

  @JsonProperty("identifier")
  private DOI doi;
  @JacksonXmlProperty(localName = "identifierType", isAttribute = true)
  private String dummy = "DOI";

  @JacksonXmlElementWrapper(localName = "creators")
  @JsonProperty("creator")
  private List<Creator> creators = Lists.newArrayList();
  @JacksonXmlElementWrapper(localName = "contributors")
  @JsonProperty("contributor")
  private List<Contributor> contributors = Lists.newArrayList();
  @JacksonXmlElementWrapper(localName = "titles")
  @JsonProperty("title")
  private List<TypedTitle> titles = Lists.newArrayList();
  @JacksonXmlElementWrapper(localName = "dates")
  @JsonProperty("dates")
  private List<TypedDate> dates = Lists.newArrayList();
  private List<Subject> subjects = Lists.newArrayList();
  private List<AlternateIdentifier> alternateIdentifiers = Lists.newArrayList();
  private List<RelatedIdentifier> relatedIdentifiers = Lists.newArrayList();
  @JacksonXmlElementWrapper(localName = "description")
  private List<TypedDescription> description = Lists.newArrayList();
  private List<GeoLocation> geoLocations = Lists.newArrayList();

  @JacksonXmlElementWrapper(localName = "sizes")
  @JsonProperty("size")
  private List<String> sizes = Lists.newArrayList();
  private List<String> format = Lists.newArrayList();
  @JacksonXmlElementWrapper(localName = "rightsList")
  private List<String> right = Lists.newArrayList();

  private String publisher;
  private Integer publicationYear;
  private Language language = Language.ENGLISH; // defaults to English
  private ResourceTypeGeneral resourceTypeGeneral;
  private String resourceType;
  private String version;
  private URI licenseUri;
  private String licenseTitle;

  public DataCiteMetadataV3() {
  }

  private DataCiteMetadataV3(Builder builder) {
    this.doi = builder.doi;
    this.creators = builder.creators;
    this.alternateIdentifiers = builder.alternateIdentifiers;
    this.geoLocations = builder.geoLocations;
    this.relatedIdentifiers = builder.relatedIdentifiers;
    this.subjects = builder.subjects;
    this.contributors = builder.contributors;
    this.dates = builder.dates;
    this.description = builder.descriptions;
    this.titles = builder.titles;
    this.sizes = builder.sizes;
    this.format = builder.formats;
    this.right = builder.rights;
    this.publisher = builder.publisher;
    this.publicationYear = builder.publicationYear;
    this.language = builder.language;
    this.resourceTypeGeneral = builder.resourceTypeGeneral;
    this.resourceType = builder.resourceType;
    this.version = builder.version;
    this.licenseUri = builder.licenseUri;
    this.licenseTitle = builder.licenseTitle;
  }

  public static IdentifierType getIdentifierType() {
    return IDENTIFIER_TYPE;
  }

  /**
   * @return DOI (Digital Object Identifier) registered by a DataCite member. Format should be “10.1234/foo”
   */
  @NotNull
  public DOI getDoi() {
    return doi;
  }

  public void setDoi(DOI doi) {
    this.doi = doi;
  }

  /**
   * @return the main researchers involved in producing the data, or the authors of the publication, in priority order.
   */
  @NotNull
  public List<Creator> getCreators() {
    return creators;
  }

  public void setCreators(List<Creator> creators) {
    this.creators = creators;
  }

  /**
   * @return the institution or person responsible for collecting, managing, distributing, or otherwise contributing
   * to the development of the resource. 
   */
  public List<Contributor> getContributors() {
    return contributors;
  }

  public void setContributors(List<Contributor> contributors) {
    this.contributors = contributors;
  }

  /**
   * @return list of titles by which a resource is known
   */
  public List<TypedTitle> getTitles() {
    return titles;
  }

  public void setTitles(List<TypedTitle> titles) {
    this.titles = titles;
  }

  /**
   * @return list of different dates relevant to the work
   */
  public List<TypedDate> getDates() {
    return dates;
  }

  public void setDates(List<TypedDate> dates) {
    this.dates = dates;
  }

  /**
   * @return the name of the entity that holds, archives, publishes prints, distributes, releases, issues, or produces
   * the resource.
   */
  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * @return list of subjects, keywords, classification codes, or key phrase describing the resource
   */
  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }

  /**
   * @return the primary language of the resource (data), not metadata
   */
  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  /**
   * If ResourceType is used, resourceTypeGeneral is mandatory.
   *
   * @return the general type of a resource
   */
  public ResourceTypeGeneral getResourceTypeGeneral() {
    return resourceTypeGeneral;
  }

  public void setResourceTypeGeneral(ResourceTypeGeneral resourceTypeGeneral) {
    this.resourceTypeGeneral = resourceTypeGeneral;
  }

  /**
   * @return free text description of the resource, whose preferred format is a single term of some detail so that a
   * pair can be formed with the sub‐property, e.g. Dataset/Census Data.
   */
  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * @return the list of identifier other than the primary DOI applied to the resource being registered.
   */
  public List<AlternateIdentifier> getAlternateIdentifiers() {
    return alternateIdentifiers;
  }

  public void setAlternateIdentifiers(List<AlternateIdentifier> alternateIdentifiers) {
    this.alternateIdentifiers = alternateIdentifiers;
  }

  /**
   * @return list of globally unique identifiers of related resources
   */
  public List<RelatedIdentifier> getRelatedIdentifiers() {
    return relatedIdentifiers;
  }

  public void setRelatedIdentifiers(List<RelatedIdentifier> relatedIdentifiers) {
    this.relatedIdentifiers = relatedIdentifiers;
  }

  /**
   * @return list of unstructured sizes information about the resource, e.g. 6 MB.
   */
  public List<String> getSizes() {
    return sizes;
  }

  public void setSizes(List<String> sizes) {
    this.sizes = sizes;
  }

  /**
   * @return list of technical format of the resource using file type or MIME type if possible, e.g. XML. 
   */
  public List<String> getFormat() {
    return format;
  }

  public void setFormat(List<String> format) {
    this.format = format;
  }

  /**
   * Suggested practice by DataCite: track major_version.minor_version.
   *
   * @return the version number of the resource. 
   */
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * @return a right management statement for the resource or reference a service providing such information
   */
  public List<String> getRight() {
    return right;
  }

  public void setRight(List<String> right) {
    this.right = right;
  }

  /**
   * @return the URI of the license
   */
  public URI getLicenseUri() {
    return licenseUri;
  }

  public void setLicenseUri(URI licenseUri) {
    this.licenseUri = licenseUri;
  }

  /**
   * @return the titles of the license
   */
  public String getLicenseTitle() {
    return licenseTitle;
  }

  public void setLicenseTitle(String licenseTitle) {
    this.licenseTitle = licenseTitle;
  }

  /**
   * @return list of description about the resource
   */
  public List<TypedDescription> getDescription() {
    return description;
  }

  public void setDescription(List<TypedDescription> description) {
    this.description = description;
  }

  /**
   * @return list of spatial regions or named places where the data was gathered or about which the data is focused
   */
  public List<GeoLocation> getGeoLocations() {
    return geoLocations;
  }

  public void setGeoLocations(List<GeoLocation> geoLocations) {
    this.geoLocations = geoLocations;
  }

  /**
   * @return the year when the data was or will be made publicly available
   */
  @Min(1500)
  @Max(2020)
  public Integer getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(Integer publicationYear) {
    this.publicationYear = publicationYear;
  }
}
