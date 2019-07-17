//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.17 at 03:36:00 PM CEST 
//


package org.gbif.doi.metadata.datacite;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.google.common.base.Objects;
import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;


/**
 * <p>Java class for point complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="point"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="pointLongitude" type="{http://datacite.org/schema/kernel-4}longitudeType"/&gt;
 *         &lt;element name="pointLatitude" type="{http://datacite.org/schema/kernel-4}latitudeType"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "point", propOrder = {

})
public class Point {

    protected float pointLongitude;
    protected float pointLatitude;

    /**
     * Gets the value of the pointLongitude property.
     * 
     */
    public float getPointLongitude() {
        return pointLongitude;
    }

    /**
     * Sets the value of the pointLongitude property.
     * 
     */
    public void setPointLongitude(float value) {
        this.pointLongitude = value;
    }

    /**
     * Gets the value of the pointLatitude property.
     * 
     */
    public float getPointLatitude() {
        return pointLatitude;
    }

    /**
     * Sets the value of the pointLatitude property.
     * 
     */
    public void setPointLatitude(float value) {
        this.pointLatitude = value;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final Point.Builder<_B> _other) {
        _other.pointLongitude = this.pointLongitude;
        _other.pointLatitude = this.pointLatitude;
    }

    public<_B >Point.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
        return new Point.Builder<_B>(_parentBuilder, this, true);
    }

    public Point.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
    }

    public static Point.Builder<Void> builder() {
        return new Point.Builder<Void>(null, null, false);
    }

    public static<_B >Point.Builder<_B> copyOf(final Point _other) {
        final Point.Builder<_B> _newBuilder = new Point.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final Point.Builder<_B> _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree pointLongitudePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("pointLongitude"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(pointLongitudePropertyTree!= null):((pointLongitudePropertyTree == null)||(!pointLongitudePropertyTree.isLeaf())))) {
            _other.pointLongitude = this.pointLongitude;
        }
        final PropertyTree pointLatitudePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("pointLatitude"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(pointLatitudePropertyTree!= null):((pointLatitudePropertyTree == null)||(!pointLatitudePropertyTree.isLeaf())))) {
            _other.pointLatitude = this.pointLatitude;
        }
    }

    public<_B >Point.Builder<_B> newCopyBuilder(final _B _parentBuilder, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return new Point.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public Point.Builder<Void> newCopyBuilder(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static<_B >Point.Builder<_B> copyOf(final Point _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final Point.Builder<_B> _newBuilder = new Point.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
    }

    public static Point.Builder<Void> copyExcept(final Point _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static Point.Builder<Void> copyOnly(final Point _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("pointLongitude", pointLongitude).add("pointLatitude", pointLatitude).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pointLongitude, pointLatitude);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (getClass()!= other.getClass()) {
            return false;
        }
        final Point o = ((Point) other);
        return (Objects.equal(pointLongitude, o.pointLongitude)&&Objects.equal(pointLatitude, o.pointLatitude));
    }

    public static class Builder<_B >implements Buildable
    {

        protected final _B _parentBuilder;
        protected final Point _storedValue;
        private float pointLongitude;
        private float pointLatitude;

        public Builder(final _B _parentBuilder, final Point _other, final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                    this.pointLongitude = _other.pointLongitude;
                    this.pointLatitude = _other.pointLatitude;
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public Builder(final _B _parentBuilder, final Point _other, final boolean _copy, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                    final PropertyTree pointLongitudePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("pointLongitude"));
                    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(pointLongitudePropertyTree!= null):((pointLongitudePropertyTree == null)||(!pointLongitudePropertyTree.isLeaf())))) {
                        this.pointLongitude = _other.pointLongitude;
                    }
                    final PropertyTree pointLatitudePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("pointLatitude"));
                    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(pointLatitudePropertyTree!= null):((pointLatitudePropertyTree == null)||(!pointLatitudePropertyTree.isLeaf())))) {
                        this.pointLatitude = _other.pointLatitude;
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

        protected<_P extends Point >_P init(final _P _product) {
            _product.pointLongitude = this.pointLongitude;
            _product.pointLatitude = this.pointLatitude;
            return _product;
        }

        /**
         * Sets the new value of "pointLongitude" (any previous value will be replaced)
         * 
         * @param pointLongitude
         *     New value of the "pointLongitude" property.
         */
        public Point.Builder<_B> withPointLongitude(final float pointLongitude) {
            this.pointLongitude = pointLongitude;
            return this;
        }

        /**
         * Sets the new value of "pointLatitude" (any previous value will be replaced)
         * 
         * @param pointLatitude
         *     New value of the "pointLatitude" property.
         */
        public Point.Builder<_B> withPointLatitude(final float pointLatitude) {
            this.pointLatitude = pointLatitude;
            return this;
        }

        @Override
        public Point build() {
            if (_storedValue == null) {
                return this.init(new Point());
            } else {
                return ((Point) _storedValue);
            }
        }

        public Point.Builder<_B> copyOf(final Point _other) {
            _other.copyTo(this);
            return this;
        }

        public Point.Builder<_B> copyOf(final Point.Builder _other) {
            return copyOf(_other.build());
        }

    }

    public static class Select
        extends Point.Selector<Point.Select, Void>
    {


        Select() {
            super(null, null, null);
        }

        public static Point.Select _root() {
            return new Point.Select();
        }

    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?> , TParent >
        extends com.kscs.util.jaxb.Selector<TRoot, TParent>
    {


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
