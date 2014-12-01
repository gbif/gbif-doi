package org.gbif.doi.api.datacite.model;

import java.io.Serializable;

import com.google.common.base.Objects;

/**
 * Class representing an AlternateIdentifier in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */

public class AlternateIdentifier implements Serializable {

  public static class Builder {

    private String identifier;
    private String type;

    public Builder identifier(String identifier) {
      this.identifier = identifier;
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public AlternateIdentifier build() {
      return new AlternateIdentifier(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -995204169161362016L;

  private String identifier;
  private String type;

  public AlternateIdentifier() {
  }

  private AlternateIdentifier(Builder builder) {
    this.identifier = builder.identifier;
    this.type = builder.type;
  }

  /**
   * @return the identifier other than the primary DOI applied to the resource being registered.
   */
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * Mandatory if AlternateIdentifier is used.
   *
   * @return  the type of alternate identifier, e.g. “A local accession number”
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("identifier", identifier)
      .add("type", type).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(identifier, type);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof AlternateIdentifier) {
      AlternateIdentifier that = (AlternateIdentifier) object;
      return Objects.equal(this.identifier, that.identifier)
             && Objects.equal(this.type, that.type);
    }
    return false;
  }
}
