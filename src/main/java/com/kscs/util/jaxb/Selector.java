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
import java.util.Map;

/**
 * Helper class acting as base class for all selectors and concrete implementation of leaf
 * selectors.
 */
public class Selector<TRoot extends Selector<TRoot, ?>, TParent> {
  public final TRoot _root;
  public final TParent _parent;
  protected final String _propertyName;
  protected final boolean _include;

  @SuppressWarnings("unchecked")
  public Selector(
      final TRoot root, final TParent parent, final String propertyName, final boolean include) {
    this._root = root == null ? (TRoot) this : root;
    this._parent = parent;
    this._propertyName = propertyName;
    this._include = include;
  }

  public Selector(final TRoot root, final TParent parent, final String propertyName) {
    this(root, parent, propertyName, true);
  }

  /**
   * This is only used by builders and other implementational details
   *
   * @return A map representing the child nodes of this selector
   */
  public Map<String, PropertyTree> buildChildren() {
    return Collections.emptyMap();
  }

  /**
   * Builds a property tree specified by this selector
   *
   * @return A property tree specified by this selector
   */
  public PropertyTree build() {
    return this._root.init();
  }

  /**
   * This is only used by builders and other implementational details
   *
   * @return A property tree specified by this selector
   */
  public PropertyTree init() {
    return new PropertyTree(this._propertyName, buildChildren());
  }
}
