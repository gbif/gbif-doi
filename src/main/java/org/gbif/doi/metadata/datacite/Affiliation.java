/*
 * Copyright 2021 Global Biodiversity Information Facility (GBIF)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gbif.doi.metadata.datacite;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;

/**
 * Uniquely identifies an affiliation, according to various identifier schemes.
 *
 * <p>Java class for affiliation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="affiliation"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
 *       &lt;attribute name="affiliationIdentifier" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="affiliationIdentifierScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "affiliation",
    propOrder = {"value"})
public class Affiliation {

  @XmlValue protected String value;

  @XmlAttribute(name = "affiliationIdentifier")
  @XmlSchemaType(name = "anySimpleType")
  protected String affiliationIdentifier;

  @XmlAttribute(name = "affiliationIdentifierScheme")
  @XmlSchemaType(name = "anySimpleType")
  protected String affiliationIdentifierScheme;

  @XmlAttribute(name = "schemeURI")
  @XmlSchemaType(name = "anyURI")
  protected String schemeURI;

  /**
   * Gets the value of the value property.
   *
   * @return possible object is {@link String }
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the value property.
   *
   * @param value allowed object is {@link String }
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Gets the value of the affiliationIdentifier property.
   *
   * @return possible object is {@link String }
   */
  public String getAffiliationIdentifier() {
    return affiliationIdentifier;
  }

  /**
   * Sets the value of the affiliationIdentifier property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAffiliationIdentifier(String value) {
    this.affiliationIdentifier = value;
  }

  /**
   * Gets the value of the affiliationIdentifierScheme property.
   *
   * @return possible object is {@link String }
   */
  public String getAffiliationIdentifierScheme() {
    return affiliationIdentifierScheme;
  }

  /**
   * Sets the value of the affiliationIdentifierScheme property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAffiliationIdentifierScheme(String value) {
    this.affiliationIdentifierScheme = value;
  }

  /**
   * Gets the value of the schemeURI property.
   *
   * @return possible object is {@link String }
   */
  public String getSchemeURI() {
    return schemeURI;
  }

  /**
   * Sets the value of the schemeURI property.
   *
   * @param value allowed object is {@link String }
   */
  public void setSchemeURI(String value) {
    this.schemeURI = value;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method
   * and should not be called directly by client code.
   *
   * @param _other A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final Affiliation.Builder<_B> _other) {
    _other.value = this.value;
    _other.affiliationIdentifier = this.affiliationIdentifier;
    _other.affiliationIdentifierScheme = this.affiliationIdentifierScheme;
    _other.schemeURI = this.schemeURI;
  }

  public <_B> Affiliation.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new Affiliation.Builder<_B>(_parentBuilder, this, true);
  }

  public Affiliation.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static Affiliation.Builder<Void> builder() {
    return new Affiliation.Builder<Void>(null, null, false);
  }

  public static <_B> Affiliation.Builder<_B> copyOf(final Affiliation _other) {
    final Affiliation.Builder<_B> _newBuilder = new Affiliation.Builder<_B>(null, null, false);
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method
   * and should not be called directly by client code.
   *
   * @param _other A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(
      final Affiliation.Builder<_B> _other,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    final PropertyTree valuePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("value"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (valuePropertyTree != null)
        : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
      _other.value = this.value;
    }
    final PropertyTree affiliationIdentifierPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("affiliationIdentifier"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (affiliationIdentifierPropertyTree != null)
        : ((affiliationIdentifierPropertyTree == null)
            || (!affiliationIdentifierPropertyTree.isLeaf())))) {
      _other.affiliationIdentifier = this.affiliationIdentifier;
    }
    final PropertyTree affiliationIdentifierSchemePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("affiliationIdentifierScheme"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (affiliationIdentifierSchemePropertyTree != null)
        : ((affiliationIdentifierSchemePropertyTree == null)
            || (!affiliationIdentifierSchemePropertyTree.isLeaf())))) {
      _other.affiliationIdentifierScheme = this.affiliationIdentifierScheme;
    }
    final PropertyTree schemeURIPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (schemeURIPropertyTree != null)
        : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
      _other.schemeURI = this.schemeURI;
    }
  }

  public <_B> Affiliation.Builder<_B> newCopyBuilder(
      final _B _parentBuilder,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    return new Affiliation.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public Affiliation.Builder<Void> newCopyBuilder(
      final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> Affiliation.Builder<_B> copyOf(
      final Affiliation _other,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    final Affiliation.Builder<_B> _newBuilder = new Affiliation.Builder<_B>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static Affiliation.Builder<Void> copyExcept(
      final Affiliation _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static Affiliation.Builder<Void> copyOnly(
      final Affiliation _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Affiliation.class.getSimpleName() + "[", "]")
        .add("value='" + value + "'")
        .add("affiliationIdentifier='" + affiliationIdentifier + "'")
        .add("affiliationIdentifierScheme='" + affiliationIdentifierScheme + "'")
        .add("schemeURI='" + schemeURI + "'")
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Affiliation that = (Affiliation) o;

    return Objects.equals(value, that.value)
        && Objects.equals(affiliationIdentifier, that.affiliationIdentifier)
        && Objects.equals(affiliationIdentifierScheme, that.affiliationIdentifierScheme)
        && Objects.equals(schemeURI, that.schemeURI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, affiliationIdentifier, affiliationIdentifierScheme, schemeURI);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final Affiliation _storedValue;
    private String value;
    private String affiliationIdentifier;
    private String affiliationIdentifierScheme;
    private String schemeURI;

    public Builder(final _B _parentBuilder, final Affiliation _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.value = _other.value;
          this.affiliationIdentifier = _other.affiliationIdentifier;
          this.affiliationIdentifierScheme = _other.affiliationIdentifierScheme;
          this.schemeURI = _other.schemeURI;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
        final _B _parentBuilder,
        final Affiliation _other,
        final boolean _copy,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree valuePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("value"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (valuePropertyTree != null)
              : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
            this.value = _other.value;
          }
          final PropertyTree affiliationIdentifierPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("affiliationIdentifier"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (affiliationIdentifierPropertyTree != null)
              : ((affiliationIdentifierPropertyTree == null)
                  || (!affiliationIdentifierPropertyTree.isLeaf())))) {
            this.affiliationIdentifier = _other.affiliationIdentifier;
          }
          final PropertyTree affiliationIdentifierSchemePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("affiliationIdentifierScheme"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (affiliationIdentifierSchemePropertyTree != null)
              : ((affiliationIdentifierSchemePropertyTree == null)
                  || (!affiliationIdentifierSchemePropertyTree.isLeaf())))) {
            this.affiliationIdentifierScheme = _other.affiliationIdentifierScheme;
          }
          final PropertyTree schemeURIPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (schemeURIPropertyTree != null)
              : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
            this.schemeURI = _other.schemeURI;
          }
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public _B end() {
      return this._parentBuilder;
    }

    protected <_P extends Affiliation> _P init(final _P _product) {
      _product.value = this.value;
      _product.affiliationIdentifier = this.affiliationIdentifier;
      _product.affiliationIdentifierScheme = this.affiliationIdentifierScheme;
      _product.schemeURI = this.schemeURI;
      return _product;
    }

    /**
     * Sets the new value of "value" (any previous value will be replaced)
     *
     * @param value New value of the "value" property.
     */
    public Affiliation.Builder<_B> withValue(final String value) {
      this.value = value;
      return this;
    }

    /**
     * Sets the new value of "affiliationIdentifier" (any previous value will be replaced)
     *
     * @param affiliationIdentifier New value of the "affiliationIdentifier" property.
     */
    public Affiliation.Builder<_B> withAffiliationIdentifier(final String affiliationIdentifier) {
      this.affiliationIdentifier = affiliationIdentifier;
      return this;
    }

    /**
     * Sets the new value of "affiliationIdentifierScheme" (any previous value will be replaced)
     *
     * @param affiliationIdentifierScheme New value of the "affiliationIdentifierScheme" property.
     */
    public Affiliation.Builder<_B> withAffiliationIdentifierScheme(
        final String affiliationIdentifierScheme) {
      this.affiliationIdentifierScheme = affiliationIdentifierScheme;
      return this;
    }

    /**
     * Sets the new value of "schemeURI" (any previous value will be replaced)
     *
     * @param schemeURI New value of the "schemeURI" property.
     */
    public Affiliation.Builder<_B> withSchemeURI(final String schemeURI) {
      this.schemeURI = schemeURI;
      return this;
    }

    @Override
    public Affiliation build() {
      if (_storedValue == null) {
        return this.init(new Affiliation());
      } else {
        return ((Affiliation) _storedValue);
      }
    }

    public Affiliation.Builder<_B> copyOf(final Affiliation _other) {
      _other.copyTo(this);
      return this;
    }

    public Affiliation.Builder<_B> copyOf(final Affiliation.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends Affiliation.Selector<Affiliation.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static Affiliation.Select _root() {
      return new Affiliation.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
      extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>> value = null;
    private com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>>
        affiliationIdentifier = null;
    private com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>>
        affiliationIdentifierScheme = null;
    private com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>> schemeURI =
        null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
      products.putAll(super.buildChildren());
      if (this.value != null) {
        products.put("value", this.value.init());
      }
      if (this.affiliationIdentifier != null) {
        products.put("affiliationIdentifier", this.affiliationIdentifier.init());
      }
      if (this.affiliationIdentifierScheme != null) {
        products.put("affiliationIdentifierScheme", this.affiliationIdentifierScheme.init());
      }
      if (this.schemeURI != null) {
        products.put("schemeURI", this.schemeURI.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>> value() {
      return ((this.value == null)
          ? this.value =
              new com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>>(
                  this._root, this, "value")
          : this.value);
    }

    public com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>>
        affiliationIdentifier() {
      return ((this.affiliationIdentifier == null)
          ? this.affiliationIdentifier =
              new com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>>(
                  this._root, this, "affiliationIdentifier")
          : this.affiliationIdentifier);
    }

    public com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>>
        affiliationIdentifierScheme() {
      return ((this.affiliationIdentifierScheme == null)
          ? this.affiliationIdentifierScheme =
              new com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>>(
                  this._root, this, "affiliationIdentifierScheme")
          : this.affiliationIdentifierScheme);
    }

    public com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>> schemeURI() {
      return ((this.schemeURI == null)
          ? this.schemeURI =
              new com.kscs.util.jaxb.Selector<TRoot, Affiliation.Selector<TRoot, TParent>>(
                  this._root, this, "schemeURI")
          : this.schemeURI);
    }
  }
}
