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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for descriptionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="descriptionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Abstract"/&gt;
 *     &lt;enumeration value="Methods"/&gt;
 *     &lt;enumeration value="SeriesInformation"/&gt;
 *     &lt;enumeration value="TableOfContents"/&gt;
 *     &lt;enumeration value="TechnicalInfo"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "descriptionType")
@XmlEnum
public enum DescriptionType {
  @XmlEnumValue("Abstract")
  ABSTRACT("Abstract"),
  @XmlEnumValue("Methods")
  METHODS("Methods"),
  @XmlEnumValue("SeriesInformation")
  SERIES_INFORMATION("SeriesInformation"),
  @XmlEnumValue("TableOfContents")
  TABLE_OF_CONTENTS("TableOfContents"),
  @XmlEnumValue("TechnicalInfo")
  TECHNICAL_INFO("TechnicalInfo"),
  @XmlEnumValue("Other")
  OTHER("Other");
  private final String value;

  DescriptionType(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static DescriptionType fromValue(String v) {
    for (DescriptionType c : DescriptionType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
