/*
 * Copyright 2020 Global Biodiversity Information Facility (GBIF)
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import com.google.common.base.Objects;
import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;

/**
 * Uniquely identifies a creator or contributor, according to various identifier schemes.
 *
 * <p>Java class for nameIdentifier complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="nameIdentifier"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
 *       &lt;attribute name="nameIdentifierScheme" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "nameIdentifier",
    propOrder = {"value"})
public class NameIdentifier {

  @XmlValue protected String value;

  @XmlAttribute(name = "nameIdentifierScheme", required = true)
  @XmlSchemaType(name = "anySimpleType")
  protected String nameIdentifierScheme;

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
   * Gets the value of the nameIdentifierScheme property.
   *
   * @return possible object is {@link String }
   */
  public String getNameIdentifierScheme() {
    return nameIdentifierScheme;
  }

  /**
   * Sets the value of the nameIdentifierScheme property.
   *
   * @param value allowed object is {@link String }
   */
  public void setNameIdentifierScheme(String value) {
    this.nameIdentifierScheme = value;
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
  public <_B> void copyTo(final NameIdentifier.Builder<_B> _other) {
    _other.value = this.value;
    _other.nameIdentifierScheme = this.nameIdentifierScheme;
    _other.schemeURI = this.schemeURI;
  }

  public <_B> NameIdentifier.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new NameIdentifier.Builder<_B>(_parentBuilder, this, true);
  }

  public NameIdentifier.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static NameIdentifier.Builder<Void> builder() {
    return new NameIdentifier.Builder<Void>(null, null, false);
  }

  public static <_B> NameIdentifier.Builder<_B> copyOf(final NameIdentifier _other) {
    final NameIdentifier.Builder<_B> _newBuilder =
        new NameIdentifier.Builder<_B>(null, null, false);
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
      final NameIdentifier.Builder<_B> _other,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    final PropertyTree valuePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("value"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (valuePropertyTree != null)
        : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
      _other.value = this.value;
    }
    final PropertyTree nameIdentifierSchemePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("nameIdentifierScheme"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (nameIdentifierSchemePropertyTree != null)
        : ((nameIdentifierSchemePropertyTree == null)
            || (!nameIdentifierSchemePropertyTree.isLeaf())))) {
      _other.nameIdentifierScheme = this.nameIdentifierScheme;
    }
    final PropertyTree schemeURIPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (schemeURIPropertyTree != null)
        : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
      _other.schemeURI = this.schemeURI;
    }
  }

  public <_B> NameIdentifier.Builder<_B> newCopyBuilder(
      final _B _parentBuilder,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    return new NameIdentifier.Builder<_B>(
        _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public NameIdentifier.Builder<Void> newCopyBuilder(
      final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> NameIdentifier.Builder<_B> copyOf(
      final NameIdentifier _other,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    final NameIdentifier.Builder<_B> _newBuilder =
        new NameIdentifier.Builder<_B>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static NameIdentifier.Builder<Void> copyExcept(
      final NameIdentifier _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static NameIdentifier.Builder<Void> copyOnly(
      final NameIdentifier _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("value", value)
        .add("nameIdentifierScheme", nameIdentifierScheme)
        .add("schemeURI", schemeURI)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value, nameIdentifierScheme, schemeURI);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    final NameIdentifier o = ((NameIdentifier) other);
    return ((Objects.equal(value, o.value)
            && Objects.equal(nameIdentifierScheme, o.nameIdentifierScheme))
        && Objects.equal(schemeURI, o.schemeURI));
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final NameIdentifier _storedValue;
    private String value;
    private String nameIdentifierScheme;
    private String schemeURI;

    public Builder(final _B _parentBuilder, final NameIdentifier _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.value = _other.value;
          this.nameIdentifierScheme = _other.nameIdentifierScheme;
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
        final NameIdentifier _other,
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
          final PropertyTree nameIdentifierSchemePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("nameIdentifierScheme"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (nameIdentifierSchemePropertyTree != null)
              : ((nameIdentifierSchemePropertyTree == null)
                  || (!nameIdentifierSchemePropertyTree.isLeaf())))) {
            this.nameIdentifierScheme = _other.nameIdentifierScheme;
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

    protected <_P extends NameIdentifier> _P init(final _P _product) {
      _product.value = this.value;
      _product.nameIdentifierScheme = this.nameIdentifierScheme;
      _product.schemeURI = this.schemeURI;
      return _product;
    }

    /**
     * Sets the new value of "value" (any previous value will be replaced)
     *
     * @param value New value of the "value" property.
     */
    public NameIdentifier.Builder<_B> withValue(final String value) {
      this.value = value;
      return this;
    }

    /**
     * Sets the new value of "nameIdentifierScheme" (any previous value will be replaced)
     *
     * @param nameIdentifierScheme New value of the "nameIdentifierScheme" property.
     */
    public NameIdentifier.Builder<_B> withNameIdentifierScheme(final String nameIdentifierScheme) {
      this.nameIdentifierScheme = nameIdentifierScheme;
      return this;
    }

    /**
     * Sets the new value of "schemeURI" (any previous value will be replaced)
     *
     * @param schemeURI New value of the "schemeURI" property.
     */
    public NameIdentifier.Builder<_B> withSchemeURI(final String schemeURI) {
      this.schemeURI = schemeURI;
      return this;
    }

    @Override
    public NameIdentifier build() {
      if (_storedValue == null) {
        return this.init(new NameIdentifier());
      } else {
        return ((NameIdentifier) _storedValue);
      }
    }

    public NameIdentifier.Builder<_B> copyOf(final NameIdentifier _other) {
      _other.copyTo(this);
      return this;
    }

    public NameIdentifier.Builder<_B> copyOf(final NameIdentifier.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends NameIdentifier.Selector<NameIdentifier.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static NameIdentifier.Select _root() {
      return new NameIdentifier.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
      extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>> value =
        null;
    private com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>>
        nameIdentifierScheme = null;
    private com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>> schemeURI =
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
      if (this.nameIdentifierScheme != null) {
        products.put("nameIdentifierScheme", this.nameIdentifierScheme.init());
      }
      if (this.schemeURI != null) {
        products.put("schemeURI", this.schemeURI.init());
      }
      return products;
    }

    public com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>> value() {
      return ((this.value == null)
          ? this.value =
              new com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>>(
                  this._root, this, "value")
          : this.value);
    }

    public com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>>
        nameIdentifierScheme() {
      return ((this.nameIdentifierScheme == null)
          ? this.nameIdentifierScheme =
              new com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>>(
                  this._root, this, "nameIdentifierScheme")
          : this.nameIdentifierScheme);
    }

    public com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>> schemeURI() {
      return ((this.schemeURI == null)
          ? this.schemeURI =
              new com.kscs.util.jaxb.Selector<TRoot, NameIdentifier.Selector<TRoot, TParent>>(
                  this._root, this, "schemeURI")
          : this.schemeURI);
    }
  }
}
