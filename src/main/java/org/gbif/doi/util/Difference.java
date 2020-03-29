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
package org.gbif.doi.util;

import org.gbif.api.annotation.Generated;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/** Difference between two objects. This object is intended to use for metadata comparing. */
public class Difference {

  private static final String DIFFERENCE_DELIMITER = "--------------------";

  private final Set<DifferenceItem> items;

  public Difference(Set<DifferenceItem> items) {
    this.items = items;
  }

  public Set<DifferenceItem> getItems() {
    return Collections.unmodifiableSet(items);
  }

  @Override
  @Generated
  public String toString() {
    return items.stream()
        .map(DifferenceItem::toString)
        .collect(
            Collectors.joining(DIFFERENCE_DELIMITER, DIFFERENCE_DELIMITER, DIFFERENCE_DELIMITER));
  }

  public static class DifferenceItem {

    private final String fieldName;
    private final Object value1;
    private final Object value2;

    public DifferenceItem(String fieldName, Object value1, Object value2) {
      this.fieldName = fieldName;
      this.value1 = value1;
      this.value2 = value2;
    }

    public String getFieldName() {
      return fieldName;
    }

    public Object getValue1() {
      return value1;
    }

    public Object getValue2() {
      return value2;
    }

    @Override
    @Generated
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      DifferenceItem that = (DifferenceItem) o;
      return Objects.equals(fieldName, that.fieldName)
          && Objects.equals(value1, that.value1)
          && Objects.equals(value2, that.value2);
    }

    @Override
    @Generated
    public int hashCode() {
      return Objects.hash(fieldName, value1, value2);
    }

    @Override
    @Generated
    public String toString() {
      return '\n' + fieldName + '\n' + value1 + '\n' + value2 + '\n';
    }
  }
}
