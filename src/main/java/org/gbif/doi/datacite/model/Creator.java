package org.gbif.doi.datacite.model;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * Class representing a Creator in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class Creator implements Serializable {

  public static class Builder {

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

    public Creator build() {
      return new Creator(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -2625204169161362016L;

  @JsonProperty("creatorName")
  private String name;
  private NameIdentifier nameIdentifier;
  @JacksonXmlElementWrapper(useWrapping = false)
  @JsonProperty("affiliation")
  private List<String> affiliations = Lists.newArrayList();

  public Creator() {
  }

  protected Creator(Builder builder) {
    this.name = builder.name;
    this.nameIdentifier = builder.nameIdentifier;
    this.affiliations = builder.affiliations;
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
    return Objects.hashCode(name, nameIdentifier);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Creator) {
      Creator that = (Creator) object;
      return Objects.equal(this.name, that.name)
             && Objects.equal(this.nameIdentifier, that.nameIdentifier);
    }
    return false;
  }
}
