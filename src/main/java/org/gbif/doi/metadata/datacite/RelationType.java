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
 * Java class for relationType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="relationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="IsCitedBy"/&gt;
 *     &lt;enumeration value="Cites"/&gt;
 *     &lt;enumeration value="IsSupplementTo"/&gt;
 *     &lt;enumeration value="IsSupplementedBy"/&gt;
 *     &lt;enumeration value="IsContinuedBy"/&gt;
 *     &lt;enumeration value="Continues"/&gt;
 *     &lt;enumeration value="IsNewVersionOf"/&gt;
 *     &lt;enumeration value="IsPreviousVersionOf"/&gt;
 *     &lt;enumeration value="IsPartOf"/&gt;
 *     &lt;enumeration value="HasPart"/&gt;
 *     &lt;enumeration value="IsReferencedBy"/&gt;
 *     &lt;enumeration value="References"/&gt;
 *     &lt;enumeration value="IsDocumentedBy"/&gt;
 *     &lt;enumeration value="Documents"/&gt;
 *     &lt;enumeration value="IsCompiledBy"/&gt;
 *     &lt;enumeration value="Compiles"/&gt;
 *     &lt;enumeration value="IsVariantFormOf"/&gt;
 *     &lt;enumeration value="IsOriginalFormOf"/&gt;
 *     &lt;enumeration value="IsIdenticalTo"/&gt;
 *     &lt;enumeration value="HasMetadata"/&gt;
 *     &lt;enumeration value="IsMetadataFor"/&gt;
 *     &lt;enumeration value="Reviews"/&gt;
 *     &lt;enumeration value="IsReviewedBy"/&gt;
 *     &lt;enumeration value="IsDerivedFrom"/&gt;
 *     &lt;enumeration value="IsSourceOf"/&gt;
 *     &lt;enumeration value="Describes"/&gt;
 *     &lt;enumeration value="IsDescribedBy"/&gt;
 *     &lt;enumeration value="HasVersion"/&gt;
 *     &lt;enumeration value="IsVersionOf"/&gt;
 *     &lt;enumeration value="Requires"/&gt;
 *     &lt;enumeration value="IsRequiredBy"/&gt;
 *     &lt;enumeration value="Obsoletes"/&gt;
 *     &lt;enumeration value="IsObsoletedBy"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "relationType")
@XmlEnum
public enum RelationType {
  @XmlEnumValue("IsCitedBy")
  IS_CITED_BY("IsCitedBy"),
  @XmlEnumValue("Cites")
  CITES("Cites"),
  @XmlEnumValue("IsSupplementTo")
  IS_SUPPLEMENT_TO("IsSupplementTo"),
  @XmlEnumValue("IsSupplementedBy")
  IS_SUPPLEMENTED_BY("IsSupplementedBy"),
  @XmlEnumValue("IsContinuedBy")
  IS_CONTINUED_BY("IsContinuedBy"),
  @XmlEnumValue("Continues")
  CONTINUES("Continues"),
  @XmlEnumValue("IsNewVersionOf")
  IS_NEW_VERSION_OF("IsNewVersionOf"),
  @XmlEnumValue("IsPreviousVersionOf")
  IS_PREVIOUS_VERSION_OF("IsPreviousVersionOf"),
  @XmlEnumValue("IsPartOf")
  IS_PART_OF("IsPartOf"),
  @XmlEnumValue("HasPart")
  HAS_PART("HasPart"),
  @XmlEnumValue("IsReferencedBy")
  IS_REFERENCED_BY("IsReferencedBy"),
  @XmlEnumValue("References")
  REFERENCES("References"),
  @XmlEnumValue("IsDocumentedBy")
  IS_DOCUMENTED_BY("IsDocumentedBy"),
  @XmlEnumValue("Documents")
  DOCUMENTS("Documents"),
  @XmlEnumValue("IsCompiledBy")
  IS_COMPILED_BY("IsCompiledBy"),
  @XmlEnumValue("Compiles")
  COMPILES("Compiles"),
  @XmlEnumValue("IsVariantFormOf")
  IS_VARIANT_FORM_OF("IsVariantFormOf"),
  @XmlEnumValue("IsOriginalFormOf")
  IS_ORIGINAL_FORM_OF("IsOriginalFormOf"),
  @XmlEnumValue("IsIdenticalTo")
  IS_IDENTICAL_TO("IsIdenticalTo"),
  @XmlEnumValue("HasMetadata")
  HAS_METADATA("HasMetadata"),
  @XmlEnumValue("IsMetadataFor")
  IS_METADATA_FOR("IsMetadataFor"),
  @XmlEnumValue("Reviews")
  REVIEWS("Reviews"),
  @XmlEnumValue("IsReviewedBy")
  IS_REVIEWED_BY("IsReviewedBy"),
  @XmlEnumValue("IsDerivedFrom")
  IS_DERIVED_FROM("IsDerivedFrom"),
  @XmlEnumValue("IsSourceOf")
  IS_SOURCE_OF("IsSourceOf"),
  @XmlEnumValue("Describes")
  DESCRIBES("Describes"),
  @XmlEnumValue("IsDescribedBy")
  IS_DESCRIBED_BY("IsDescribedBy"),
  @XmlEnumValue("HasVersion")
  HAS_VERSION("HasVersion"),
  @XmlEnumValue("IsVersionOf")
  IS_VERSION_OF("IsVersionOf"),
  @XmlEnumValue("Requires")
  REQUIRES("Requires"),
  @XmlEnumValue("IsRequiredBy")
  IS_REQUIRED_BY("IsRequiredBy"),
  @XmlEnumValue("Obsoletes")
  OBSOLETES("Obsoletes"),
  @XmlEnumValue("IsObsoletedBy")
  IS_OBSOLETED_BY("IsObsoletedBy");
  private final String value;

  RelationType(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static RelationType fromValue(String v) {
    for (RelationType c : RelationType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
