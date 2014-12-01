package org.gbif.doi.datacite.model;

import java.io.Serializable;

import com.google.common.base.Objects;

/**
 * Class representing an AlternateIdentifier in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class GeoLocation implements Serializable {

  public static class Builder {

    private LocationPoint point;
    private LocationBox box;
    private String description;

    public Builder point(LocationPoint point) {
      this.point = point;
      return this;
    }

    public Builder box(LocationBox box) {
      this.box = box;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public GeoLocation build() {
      return new GeoLocation(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  public GeoLocation() {
  }

  private GeoLocation(Builder builder) {
    this.point = builder.point;
    this.box = builder.box;
    this.description = builder.description;
  }

  private static final long serialVersionUID = -665204169161302016L;

  private LocationPoint point;
  private LocationBox box;
  private String description;

  /**
   * @return the point location in space. A point contains a single latitude‐longitude pair, separated by whitespace.
   * E.g. 31.233 ‐67.302
   */
  public LocationPoint getPoint() {
    return point;
  }

  public void setPoint(LocationPoint point) {
    this.point = point;
  }

  /**
   * @return the spatial limits of a place. A box contains two white space separated latitude‐longitude pairs, with
   * each pair separated by whitespace. E.g. 41.090 ‐71.032  42.893 ‐68.211
   */
  public LocationBox getBox() {
    return box;
  }

  public void setBox(LocationBox box) {
    this.box = box;
  }

  /**
   * @return the description of a geographic location  
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("point", point).add("box", box).add("description", description).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(point, box, description);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof GeoLocation) {
      GeoLocation that = (GeoLocation) object;
      return Objects.equal(this.point, that.point) && Objects.equal(this.box, that.box) && Objects
        .equal(this.description, that.description);
    }
    return false;
  }
}
