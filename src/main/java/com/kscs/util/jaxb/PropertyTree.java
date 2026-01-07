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
package com.kscs.util.jaxb;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Represents a property path for use in the clone() method */
public class PropertyTree {
  private final Map<String, PropertyTree> children;
  private final String propertyName;

  public static final class Builder {
    private final Map<String, Builder> children = new LinkedHashMap<>();
    private final Builder parent;
    private final String propertyName;

    public Builder() {
      this(null, null);
    }

    private Builder(final Builder parent, final String propertyName) {
      this.parent = parent;
      this.propertyName = propertyName;
    }

    public Builder with(final String propertyName) {
      Builder child = this.children.get(propertyName);
      if (child == null) {
        child = new Builder(this, propertyName);
        this.children.put(propertyName, child);
      }
      return child;
    }

    public PropertyTree build() {
      if (this.parent != null) {
        return this.parent.build();
      } else {
        return new PropertyTree(this.propertyName, buildChildren());
      }
    }

    private Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> childProducts =
          new LinkedHashMap<>(this.children.size());
      for (final Builder childBuilder : this.children.values()) {
        final PropertyTree child =
            new PropertyTree(childBuilder.propertyName, childBuilder.buildChildren());
        childProducts.put(child.propertyName, child);
      }
      return Collections.unmodifiableMap(childProducts);
    }

    public Builder parent() {
      return this.parent;
    }

    public Builder root() {
      if (this.parent != null) {
        return this.parent.root();
      } else {
        return this;
      }
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public PropertyTree(final String propertyName, final Map<String, PropertyTree> children) {
    this.propertyName = propertyName;
    this.children = Collections.unmodifiableMap(children);
  }

  public PropertyTree get(final String propertyName) {
    return isLeaf() ? null : this.children.get(propertyName);
  }

  public boolean isLeaf() {
    return this.children == null || this.children.isEmpty();
  }

  public String propertyName() {
    return this.propertyName;
  }
}
