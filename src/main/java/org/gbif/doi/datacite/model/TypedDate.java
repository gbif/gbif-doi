package org.gbif.doi.datacite.model;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.google.common.base.Objects;

/**
 * Class representing a Date in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class TypedDate implements Serializable {

  public static class Builder {

    private String dates;
    private String type;

    public Builder dates(String dates) {
      this.dates = dates;
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public TypedDate build() {
      return new TypedDate(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -3333304169161362016L;

  @JacksonXmlText()
  private String dates;
  @JacksonXmlProperty(localName = "dateType", isAttribute = true)
  private String type;

  public TypedDate() {
  }

  protected TypedDate(Builder builder) {
    this.dates = builder.dates;
    this.type = builder.type;
  }


  @Override
  public String toString() {
    return Objects.toStringHelper(this)
      .add("dates", dates)
      .add("type", type).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(dates, type);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof TypedDate) {
      TypedDate that = (TypedDate) object;
      return Objects.equal(this.dates, that.dates)
             && Objects.equal(this.type, that.type);
    }
    return false;
  }
}
