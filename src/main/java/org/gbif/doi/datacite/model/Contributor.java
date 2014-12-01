package org.gbif.doi.datacite.model;

import org.gbif.doi.datacite.vocabulary.ContributorType;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * Class representing a Contributor in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class Contributor implements Serializable {

  public static class Builder {

    private ContributorType type;
    private String name;
    private NameIdentifier nameIdentifier;
    private List<String> affiliations = Lists.newArrayList();

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder identifier(NameIdentifier identifier) {
      this.nameIdentifier = identifier;
      return this;
    }

    public Builder appendAffiliation(String affiliation) {
      if (affiliation != null) {
        this.affiliations.add(affiliation);
      }
      return this;
    }

    public Builder type(ContributorType type) {
      this.type = type;
      return this;
    }

    public Contributor build() {
      return new Contributor(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -2625204169161362016L;

  @JacksonXmlProperty(localName = "contributorType", isAttribute = true)
  private ContributorType type;
  @JsonProperty("contributorName")
  private String name;
  private NameIdentifier nameIdentifier;
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonProperty("affiliation")
  private List<String> affiliations = Lists.newArrayList();

  public Contributor() {
  }

  protected Contributor(Builder builder) {
    this.name = builder.name;
    this.nameIdentifier = builder.nameIdentifier;
    this.affiliations = builder.affiliations;
    this.type = builder.type;
  }

  public ContributorType getType() {
    return type;
  }

  public void setType(ContributorType type) {
    this.type = type;
  }

  /**
   * @return the name of the agent, e.g. "Smith, John"
   */
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the unique nameIdentifier for the agent according to some scheme, e.g. "http://orcid.org/0000-0002-1825-0097"
   */
  public NameIdentifier getNameIdentifier() {
    return nameIdentifier;
  }

  public void setNameIdentifier(NameIdentifier nameIdentifier) {
    this.nameIdentifier = nameIdentifier;
  }

  /**
   * @return the organizational or institutional affiliation of the agent
   */
  public List<String> getAffiliations() {
    return affiliations;
  }

  public void setAffiliations(List<String> affiliations) {
    this.affiliations = affiliations;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("name", name)
      .add("nameIdentifier", nameIdentifier)
      .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(type, name, nameIdentifier);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Contributor) {
      Contributor that = (Contributor) object;
      return Objects.equal(this.name, that.name)
             && Objects.equal(this.type, that.type)
             && Objects.equal(this.nameIdentifier, that.nameIdentifier);
    }
    return false;
  }
}
