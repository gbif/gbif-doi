package org.gbif.doi.datacite.model;

import org.gbif.doi.datacite.vocabulary.RelatedIdentifierType;
import org.gbif.doi.datacite.vocabulary.RelationType;

import java.io.Serializable;

import com.google.common.base.Objects;

/**
 * Class representing an AlternateIdentifier in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class RelatedIdentifier implements Serializable {

  public static class Builder {

    private String identifier;
    private RelatedIdentifierType type;
    private RelationType relationType;
    private String metadataScheme;
    private String schemeUri;
    private String schemeType;

    public Builder identifier(String identifier) {
      this.identifier = identifier;
      return this;
    }

    public Builder type(RelatedIdentifierType type) {
      this.type = type;
      return this;
    }

    public Builder relationType(RelationType relationType) {
      this.relationType = relationType;
      return this;
    }

    public Builder metadataScheme(String metadataScheme) {
      this.metadataScheme = metadataScheme;
      return this;
    }

    public Builder schemeUri(String schemeUri) {
      this.schemeUri = schemeUri;
      return this;
    }

    public Builder schemeType(String schemeType) {
      this.schemeType = schemeType;
      return this;
    }

    public RelatedIdentifier build() {
      return new RelatedIdentifier(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = 1615104169161362016L;

  private String identifier;
  private RelatedIdentifierType type;
  private RelationType relationType;
  private String metadataScheme;
  private String schemeUri;
  private String schemeType;

  public RelatedIdentifier() {
  }

  private RelatedIdentifier(Builder builder) {
    this.identifier = builder.identifier;
    this.type = builder.type;
    this.relationType = builder.relationType;
    this.metadataScheme = builder.metadataScheme;
    this.schemeUri = builder.schemeUri;
    this.schemeType = builder.schemeType;
  }

  /**
   * @return globally unique identifier of related resource
   */
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * If RelatedIdentifier is used, relatedIdentifierType is mandatory.
   *
   * @return the type of the RelatedIdentifier
   */
  public RelatedIdentifierType getType() {
    return type;
  }

  public void setType(RelatedIdentifierType type) {
    this.type = type;
  }

  /**
   * If RelatedIdentifier is used, relationType is mandatory.
   *
   * @return the description of the relationship of the resource being registered (A) and the related resource (B).
   */
  public RelationType getRelationType() {
    return relationType;
  }

  public void setRelationType(RelationType relationType) {
    this.relationType = relationType;
  }

  /**
   * @return the name of the scheme, used with relation RelationType.HasMetadataFor and
   * RelationType.IsMetadataFor
   */
  public String getMetadataScheme() {
    return metadataScheme;
  }

  public void setMetadataScheme(String metadataScheme) {
    this.metadataScheme = metadataScheme;
  }

  /**
   * @return the URI of the relatedMetadataScheme, used with relation RelationType.HasMetadataFor and
   * RelationType.IsMetadataFor
   */
  public String getSchemeUri() {
    return schemeUri;
  }

  public void setSchemeUri(String schemeUri) {
    this.schemeUri = schemeUri;
  }

  /**
   * @return the type of the relatedMetadataScheme, linked with the schemeURI., used with relation
   * RelationType.HasMetadataFor and RelationType.IsMetadataFor
   */
  public String getSchemeType() {
    return schemeType;
  }

  public void setSchemeType(String schemeType) {
    this.schemeType = schemeType;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("identifier", identifier)
      .add("type", type)
      .add("relationType", relationType)
      .add("metadataScheme", metadataScheme)
      .add("schemeUri", schemeUri)
      .add("schemeType", schemeType).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(identifier, type, relationType, metadataScheme, schemeUri,
      schemeType);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof RelatedIdentifier) {
      RelatedIdentifier that = (RelatedIdentifier) object;
      return Objects.equal(this.identifier, that.identifier)
             && Objects.equal(this.type, that.type)
             && Objects.equal(this.relationType, that.relationType)
             && Objects.equal(this.metadataScheme, that.metadataScheme)
             && Objects.equal(this.schemeUri, that.schemeUri)
             && Objects.equal(this.schemeType, that.schemeType);
    }
    return false;
  }
}
