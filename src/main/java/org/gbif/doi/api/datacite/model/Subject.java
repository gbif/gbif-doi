package org.gbif.doi.api.datacite.model;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import com.google.common.base.Objects;

/**
 * Class representing a subject in DataCite metadata schema version 3.
 * This class is mutable with a builder and therefore not thread safe.
 */
public class Subject implements Serializable {

  public static class Builder {

    private String subject;
    private String scheme;
    private URI schemeUri;

    public Builder subject(String subject) {
      this.subject = subject;
      return this;
    }

    public Builder scheme(String scheme) {
      this.scheme = scheme;
      return this;
    }

    public Builder schemeUri(String schemeUri) throws URISyntaxException {
      this.schemeUri = new URI(schemeUri);
      return this;
    }

    public Subject build() {
      return new Subject(this);
    }

  }

  public static Builder builder() {
    return new Builder();
  }

  private static final long serialVersionUID = 2625204169162361016L;

  private String subject;
  private String scheme;
  private URI schemeUri;

  public Subject() {
  }

  private Subject(Builder builder) {
    this.subject = builder.subject;
    this.scheme = builder.scheme;
    this.schemeUri = builder.schemeUri;
  }

  /**
   * @return Subject, keyword, classification code, or key phrase describing the resource
   */
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * @return the name of the subject scheme or classification code or authority if one is used
   */
  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  /**
   * @return the URI of the subject identifier scheme
   */
  public URI getSchemeUri() {
    return schemeUri;
  }

  public void setSchemeUri(URI schemeUri) {
    this.schemeUri = schemeUri;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("subject", subject)
      .add("scheme", scheme)
      .add("schemeUri", schemeUri).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(subject, scheme, schemeUri);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Subject) {
      Subject that = (Subject) object;
      return Objects.equal(this.subject, that.subject)
             && Objects.equal(this.scheme, that.scheme)
             && Objects.equal(this.schemeUri, that.schemeUri);
    }
    return false;
  }
}
