package org.gbif.doi.api.datacite.model;

import org.gbif.doi.api.datacite.vocabulary.ContributorType;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;

/**
 * Class representing a Contributor in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class TypedAgent extends Agent implements Serializable {

  public static class Builder extends Agent.Builder {

    private ContributorType type;

    public Builder type(ContributorType type) {
      this.type = type;
      return this;
    }

    public TypedAgent build() {
      return new TypedAgent(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -5650000169161365016L;

  private ContributorType type;

  public TypedAgent() {
  }

  private TypedAgent(Builder builder) {
    super(builder);
    this.type = builder.type;
  }

  /**
   * @return the type of contributor of the resource
   */
  @NotNull
  public ContributorType getType() {
    return type;
  }

  public void setType(ContributorType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return super.toString() + Objects.toStringHelper(this).add("type", type).toString();
  }

  @Override
  public int hashCode() {
    return super.hashCode() + Objects.hashCode(type);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof TypedAgent) {
      TypedAgent that = (TypedAgent) object;
      return super.equals(object) && Objects.equal(this.type, that.type);
    }
    return false;
  }
}
