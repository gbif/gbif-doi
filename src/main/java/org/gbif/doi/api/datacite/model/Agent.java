package org.gbif.doi.api.datacite.model;

import org.gbif.doi.api.datacite.vocabulary.NameIdentifierScheme;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * Class representing a Creator in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class Agent implements Serializable {

  public static class Builder {

    private String name;
    private String identifier;
    private NameIdentifierScheme identifierScheme;
    private List<String> affiliations = Lists.newArrayList();

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder identifier(String identifier) {
      this.identifier = identifier;
      return this;
    }

    public Builder identifierScheme(NameIdentifierScheme identifierScheme) {
      this.identifierScheme = identifierScheme;
      return this;
    }

    public Builder appendAffiliation(String affiliation) {
      if (affiliation != null) {
        this.affiliations.add(affiliation);
      }
      return this;
    }

    public Agent build() {
      return new Agent(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -2625204169161362016L;

  private String name;
  private String identifier;
  private NameIdentifierScheme identifierScheme;
  private List<String> affiliations = Lists.newArrayList();

  public Agent() {
  }

  protected Agent(Builder builder) {
    this.name = builder.name;
    this.identifier = builder.identifier;
    this.identifierScheme = builder.identifierScheme;
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
   * @return the unique identifier for the agent according to some scheme, e.g. "http://orcid.org/0000-0002-1825-0097"
   */
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * Mandatory if nameIdentifier is used.
   *
   * @return the scheme for the agent's unique identifier, e.g. "ORCID"
   */
  public NameIdentifierScheme getIdentifierScheme() {
    return identifierScheme;
  }

  public void setIdentifierScheme(NameIdentifierScheme identifierScheme) {
    this.identifierScheme = identifierScheme;
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
      .add("identifier", identifier)
      .add("identifierScheme", identifierScheme).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name, identifier, identifierScheme);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Agent) {
      Agent that = (Agent) object;
      return Objects.equal(this.name, that.name)
             && Objects.equal(this.identifier, that.identifier)
             && Objects.equal(this.identifierScheme, that.identifierScheme);
    }
    return false;
  }
}
