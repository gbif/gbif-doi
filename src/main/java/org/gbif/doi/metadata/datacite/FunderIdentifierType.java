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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for funderIdentifierType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="funderIdentifierType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ISNI"/&gt;
 *     &lt;enumeration value="GRID"/&gt;
 *     &lt;enumeration value="ROR"/&gt;
 *     &lt;enumeration value="Crossref Funder ID"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "funderIdentifierType")
@XmlEnum
public enum FunderIdentifierType {
  ISNI("ISNI"),
  GRID("GRID"),
  ROR("ROR"),
  @XmlEnumValue("Crossref Funder ID")
  CROSSREF_FUNDER_ID("Crossref Funder ID"),
  @XmlEnumValue("Other")
  OTHER("Other");
  private final String value;

  FunderIdentifierType(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static FunderIdentifierType fromValue(String v) {
    for (FunderIdentifierType c : FunderIdentifierType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
