package org.gbif.doi.datacite.model;

import org.gbif.doi.datacite.vocabulary.DescriptionType;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;

/**
 * Class representing a description in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class TypedDescription implements Serializable {

  public static class Builder {

    private String description;
    private DescriptionType type;

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder type(DescriptionType type) {
      this.type = type;
      return this;
    }

    public TypedDescription build() {
      return new TypedDescription(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -4444204169161362016L;

  public TypedDescription() {
  }

  protected TypedDescription(Builder builder) {
    this.description = builder.description;
    this.type = builder.type;
  }

  private String description;
  private DescriptionType type;

  /**
   * @return the additional information that does not fit in any of the other categories.
   */
  @NotNull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * If Description is used, descriptionType is mandatory.
   *
   * @return the type of the Description 
   */
  @NotNull
  public DescriptionType getType() {
    return type;
  }

  public void setType(DescriptionType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("description", description)
      .add("type", type).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(description, type);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof TypedDescription) {
      TypedDescription that = (TypedDescription) object;
      return Objects.equal(this.description, that.description)
             && Objects.equal(this.type, that.type);
    }
    return false;
  }
}
