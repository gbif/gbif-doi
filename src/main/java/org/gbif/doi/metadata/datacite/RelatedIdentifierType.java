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

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for relatedIdentifierType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="relatedIdentifierType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ARK"/&gt;
 *     &lt;enumeration value="arXiv"/&gt;
 *     &lt;enumeration value="bibcode"/&gt;
 *     &lt;enumeration value="DOI"/&gt;
 *     &lt;enumeration value="EAN13"/&gt;
 *     &lt;enumeration value="EISSN"/&gt;
 *     &lt;enumeration value="Handle"/&gt;
 *     &lt;enumeration value="IGSN"/&gt;
 *     &lt;enumeration value="ISBN"/&gt;
 *     &lt;enumeration value="ISSN"/&gt;
 *     &lt;enumeration value="ISTC"/&gt;
 *     &lt;enumeration value="LISSN"/&gt;
 *     &lt;enumeration value="LSID"/&gt;
 *     &lt;enumeration value="PMID"/&gt;
 *     &lt;enumeration value="PURL"/&gt;
 *     &lt;enumeration value="UPC"/&gt;
 *     &lt;enumeration value="URL"/&gt;
 *     &lt;enumeration value="URN"/&gt;
 *     &lt;enumeration value="w3id"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "relatedIdentifierType")
@XmlEnum
public enum RelatedIdentifierType {
  ARK("ARK"),
  @XmlEnumValue("arXiv")
  AR_XIV("arXiv"),
  @XmlEnumValue("bibcode")
  BIBCODE("bibcode"),
  DOI("DOI"),
  @XmlEnumValue("EAN13")
  EAN_13("EAN13"),
  EISSN("EISSN"),
  @XmlEnumValue("Handle")
  HANDLE("Handle"),
  IGSN("IGSN"),
  ISBN("ISBN"),
  ISSN("ISSN"),
  ISTC("ISTC"),
  LISSN("LISSN"),
  LSID("LSID"),
  PMID("PMID"),
  PURL("PURL"),
  UPC("UPC"),
  URL("URL"),
  URN("URN"),
  @XmlEnumValue("w3id")
  W_3_ID("w3id");
  private final String value;

  RelatedIdentifierType(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static RelatedIdentifierType fromValue(String v) {
    for (RelatedIdentifierType c : RelatedIdentifierType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
