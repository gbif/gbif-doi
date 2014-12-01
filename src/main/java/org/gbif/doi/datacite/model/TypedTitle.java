package org.gbif.doi.datacite.model;

import org.gbif.api.vocabulary.Language;
import org.gbif.doi.datacite.vocabulary.TitleType;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.google.common.base.Objects;

/**
 * Class representing a title in the DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class TypedTitle implements Serializable {

  public static class Builder {

    private String title;
    private TitleType type;
    private Language language;

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder type(TitleType type) {
      this.type = type;
      return this;
    }

    public Builder language(Language language) {
      this.language = language;
      return this;
    }

    public TypedTitle build() {
      return new TypedTitle(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = -4444204169161362016L;

  public TypedTitle() {
  }

  protected TypedTitle(Builder builder) {
    this.title = builder.title;
    this.type = builder.type;
    this.language = builder.language;
  }

  @JacksonXmlText()
  private String title;
  @JacksonXmlProperty(isAttribute = true)
  private TitleType type;
  @JacksonXmlProperty(isAttribute = true)
  private Language language;

  /**
   * @return the name or title by which a resource is known
   */
  @NotNull
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the type of the title 
   */
  @NotNull
  public TitleType getType() {
    return type;
  }

  public void setType(TitleType type) {
    this.type = type;
  }

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("title", title).add("type", type).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(title, type, language);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof TypedTitle) {
      TypedTitle that = (TypedTitle) object;
      return Objects.equal(this.title, that.title)
             && Objects.equal(this.type, that.type)
             && Objects.equal(this.language, that.language);
    }
    return false;
  }
}
