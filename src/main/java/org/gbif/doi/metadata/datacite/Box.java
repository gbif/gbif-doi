/*
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
import javax.xml.bind.annotation.XmlType;

import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;

/**
 * Java class for box complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="box"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="westBoundLongitude" type="{http://datacite.org/schema/kernel-4}longitudeType"/&gt;
 *         &lt;element name="eastBoundLongitude" type="{http://datacite.org/schema/kernel-4}longitudeType"/&gt;
 *         &lt;element name="southBoundLatitude" type="{http://datacite.org/schema/kernel-4}latitudeType"/&gt;
 *         &lt;element name="northBoundLatitude" type="{http://datacite.org/schema/kernel-4}latitudeType"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "box",
    propOrder = {})
public class Box {

  protected float westBoundLongitude;
  protected float eastBoundLongitude;
  protected float southBoundLatitude;
  protected float northBoundLatitude;

  /** Gets the value of the westBoundLongitude property. */
  public float getWestBoundLongitude() {
    return westBoundLongitude;
  }

  /** Sets the value of the westBoundLongitude property. */
  public void setWestBoundLongitude(float value) {
    this.westBoundLongitude = value;
  }

  /** Gets the value of the eastBoundLongitude property. */
  public float getEastBoundLongitude() {
    return eastBoundLongitude;
  }

  /** Sets the value of the eastBoundLongitude property. */
  public void setEastBoundLongitude(float value) {
    this.eastBoundLongitude = value;
  }

  /** Gets the value of the southBoundLatitude property. */
  public float getSouthBoundLatitude() {
    return southBoundLatitude;
  }

  /** Sets the value of the southBoundLatitude property. */
  public void setSouthBoundLatitude(float value) {
    this.southBoundLatitude = value;
  }

  /** Gets the value of the northBoundLatitude property. */
  public float getNorthBoundLatitude() {
    return northBoundLatitude;
  }

  /** Sets the value of the northBoundLatitude property. */
  public void setNorthBoundLatitude(float value) {
    this.northBoundLatitude = value;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method
   * and should not be called directly by client code.
   *
   * @param _other A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final Box.Builder<_B> _other) {
    _other.westBoundLongitude = this.westBoundLongitude;
    _other.eastBoundLongitude = this.eastBoundLongitude;
    _other.southBoundLatitude = this.southBoundLatitude;
    _other.northBoundLatitude = this.northBoundLatitude;
  }

  public <_B> Box.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new Box.Builder<_B>(_parentBuilder, this, true);
  }

  public Box.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static Box.Builder<Void> builder() {
    return new Box.Builder<Void>(null, null, false);
  }

  public static <_B> Box.Builder<_B> copyOf(final Box _other) {
    final Box.Builder<_B> _newBuilder = new Box.Builder<_B>(null, null, false);
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
      final Box.Builder<_B> _other,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    final PropertyTree westBoundLongitudePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("westBoundLongitude"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (westBoundLongitudePropertyTree != null)
        : ((westBoundLongitudePropertyTree == null)
            || (!westBoundLongitudePropertyTree.isLeaf())))) {
      _other.westBoundLongitude = this.westBoundLongitude;
    }
    final PropertyTree eastBoundLongitudePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("eastBoundLongitude"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (eastBoundLongitudePropertyTree != null)
        : ((eastBoundLongitudePropertyTree == null)
            || (!eastBoundLongitudePropertyTree.isLeaf())))) {
      _other.eastBoundLongitude = this.eastBoundLongitude;
    }
    final PropertyTree southBoundLatitudePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("southBoundLatitude"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (southBoundLatitudePropertyTree != null)
        : ((southBoundLatitudePropertyTree == null)
            || (!southBoundLatitudePropertyTree.isLeaf())))) {
      _other.southBoundLatitude = this.southBoundLatitude;
    }
    final PropertyTree northBoundLatitudePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("northBoundLatitude"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (northBoundLatitudePropertyTree != null)
        : ((northBoundLatitudePropertyTree == null)
            || (!northBoundLatitudePropertyTree.isLeaf())))) {
      _other.northBoundLatitude = this.northBoundLatitude;
    }
  }

  public <_B> Box.Builder<_B> newCopyBuilder(
      final _B _parentBuilder,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    return new Box.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public Box.Builder<Void> newCopyBuilder(
      final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> Box.Builder<_B> copyOf(
      final Box _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    final Box.Builder<_B> _newBuilder = new Box.Builder<_B>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static Box.Builder<Void> copyExcept(final Box _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static Box.Builder<Void> copyOnly(final Box _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Box.class.getSimpleName() + "[", "]")
        .add("westBoundLongitude=" + westBoundLongitude)
        .add("eastBoundLongitude=" + eastBoundLongitude)
        .add("southBoundLatitude=" + southBoundLatitude)
        .add("northBoundLatitude=" + northBoundLatitude)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Box box = (Box) o;

    return Float.compare(box.westBoundLongitude, westBoundLongitude) == 0
        && Float.compare(box.eastBoundLongitude, eastBoundLongitude) == 0
        && Float.compare(box.southBoundLatitude, southBoundLatitude) == 0
        && Float.compare(box.northBoundLatitude, northBoundLatitude) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        westBoundLongitude, eastBoundLongitude, southBoundLatitude, northBoundLatitude);
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final Box _storedValue;
    private float westBoundLongitude;
    private float eastBoundLongitude;
    private float southBoundLatitude;
    private float northBoundLatitude;

    public Builder(final _B _parentBuilder, final Box _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.westBoundLongitude = _other.westBoundLongitude;
          this.eastBoundLongitude = _other.eastBoundLongitude;
          this.southBoundLatitude = _other.southBoundLatitude;
          this.northBoundLatitude = _other.northBoundLatitude;
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
        final _B _parentBuilder,
        final Box _other,
        final boolean _copy,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree westBoundLongitudePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("westBoundLongitude"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (westBoundLongitudePropertyTree != null)
              : ((westBoundLongitudePropertyTree == null)
                  || (!westBoundLongitudePropertyTree.isLeaf())))) {
            this.westBoundLongitude = _other.westBoundLongitude;
          }
          final PropertyTree eastBoundLongitudePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("eastBoundLongitude"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (eastBoundLongitudePropertyTree != null)
              : ((eastBoundLongitudePropertyTree == null)
                  || (!eastBoundLongitudePropertyTree.isLeaf())))) {
            this.eastBoundLongitude = _other.eastBoundLongitude;
          }
          final PropertyTree southBoundLatitudePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("southBoundLatitude"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (southBoundLatitudePropertyTree != null)
              : ((southBoundLatitudePropertyTree == null)
                  || (!southBoundLatitudePropertyTree.isLeaf())))) {
            this.southBoundLatitude = _other.southBoundLatitude;
          }
          final PropertyTree northBoundLatitudePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("northBoundLatitude"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (northBoundLatitudePropertyTree != null)
              : ((northBoundLatitudePropertyTree == null)
                  || (!northBoundLatitudePropertyTree.isLeaf())))) {
            this.northBoundLatitude = _other.northBoundLatitude;
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

    protected <_P extends Box> _P init(final _P _product) {
      _product.westBoundLongitude = this.westBoundLongitude;
      _product.eastBoundLongitude = this.eastBoundLongitude;
      _product.southBoundLatitude = this.southBoundLatitude;
      _product.northBoundLatitude = this.northBoundLatitude;
      return _product;
    }

    /**
     * Sets the new value of "westBoundLongitude" (any previous value will be replaced)
     *
     * @param westBoundLongitude New value of the "westBoundLongitude" property.
     */
    public Box.Builder<_B> withWestBoundLongitude(final float westBoundLongitude) {
      this.westBoundLongitude = westBoundLongitude;
      return this;
    }

    /**
     * Sets the new value of "eastBoundLongitude" (any previous value will be replaced)
     *
     * @param eastBoundLongitude New value of the "eastBoundLongitude" property.
     */
    public Box.Builder<_B> withEastBoundLongitude(final float eastBoundLongitude) {
      this.eastBoundLongitude = eastBoundLongitude;
      return this;
    }

    /**
     * Sets the new value of "southBoundLatitude" (any previous value will be replaced)
     *
     * @param southBoundLatitude New value of the "southBoundLatitude" property.
     */
    public Box.Builder<_B> withSouthBoundLatitude(final float southBoundLatitude) {
      this.southBoundLatitude = southBoundLatitude;
      return this;
    }

    /**
     * Sets the new value of "northBoundLatitude" (any previous value will be replaced)
     *
     * @param northBoundLatitude New value of the "northBoundLatitude" property.
     */
    public Box.Builder<_B> withNorthBoundLatitude(final float northBoundLatitude) {
      this.northBoundLatitude = northBoundLatitude;
      return this;
    }

    @Override
    public Box build() {
      if (_storedValue == null) {
        return this.init(new Box());
      } else {
        return ((Box) _storedValue);
      }
    }

    public Box.Builder<_B> copyOf(final Box _other) {
      _other.copyTo(this);
      return this;
    }

    public Box.Builder<_B> copyOf(final Box.Builder _other) {
      return copyOf(_other.build());
    }
  }

  public static class Select extends Box.Selector<Box.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static Box.Select _root() {
      return new Box.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
      extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
      products.putAll(super.buildChildren());
      return products;
    }
  }
}
