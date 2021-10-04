/*
 * Copyright 2021 Global Biodiversity Information Facility (GBIF)
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
 * Java class for resourceType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="resourceType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Audiovisual"/&gt;
 *     &lt;enumeration value="Collection"/&gt;
 *     &lt;enumeration value="DataPaper"/&gt;
 *     &lt;enumeration value="Dataset"/&gt;
 *     &lt;enumeration value="Event"/&gt;
 *     &lt;enumeration value="Image"/&gt;
 *     &lt;enumeration value="InteractiveResource"/&gt;
 *     &lt;enumeration value="Model"/&gt;
 *     &lt;enumeration value="PhysicalObject"/&gt;
 *     &lt;enumeration value="Service"/&gt;
 *     &lt;enumeration value="Software"/&gt;
 *     &lt;enumeration value="Sound"/&gt;
 *     &lt;enumeration value="Text"/&gt;
 *     &lt;enumeration value="Workflow"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "resourceType")
@XmlEnum
public enum ResourceType {
  @XmlEnumValue("Audiovisual")
  AUDIOVISUAL("Audiovisual"),
  @XmlEnumValue("Collection")
  COLLECTION("Collection"),
  @XmlEnumValue("DataPaper")
  DATA_PAPER("DataPaper"),
  @XmlEnumValue("Dataset")
  DATASET("Dataset"),
  @XmlEnumValue("Event")
  EVENT("Event"),
  @XmlEnumValue("Image")
  IMAGE("Image"),
  @XmlEnumValue("InteractiveResource")
  INTERACTIVE_RESOURCE("InteractiveResource"),
  @XmlEnumValue("Model")
  MODEL("Model"),
  @XmlEnumValue("PhysicalObject")
  PHYSICAL_OBJECT("PhysicalObject"),
  @XmlEnumValue("Service")
  SERVICE("Service"),
  @XmlEnumValue("Software")
  SOFTWARE("Software"),
  @XmlEnumValue("Sound")
  SOUND("Sound"),
  @XmlEnumValue("Text")
  TEXT("Text"),
  @XmlEnumValue("Workflow")
  WORKFLOW("Workflow"),
  @XmlEnumValue("Other")
  OTHER("Other");
  private final String value;

  ResourceType(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ResourceType fromValue(String v) {
    for (ResourceType c : ResourceType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
