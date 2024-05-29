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
 * Java class for dateType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="dateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Accepted"/&gt;
 *     &lt;enumeration value="Available"/&gt;
 *     &lt;enumeration value="Collected"/&gt;
 *     &lt;enumeration value="Copyrighted"/&gt;
 *     &lt;enumeration value="Created"/&gt;
 *     &lt;enumeration value="Issued"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *     &lt;enumeration value="Submitted"/&gt;
 *     &lt;enumeration value="Updated"/&gt;
 *     &lt;enumeration value="Valid"/&gt;
 *     &lt;enumeration value="Withdrawn"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "dateType")
@XmlEnum
public enum DateType {
  @XmlEnumValue("Accepted")
  ACCEPTED("Accepted"),
  @XmlEnumValue("Available")
  AVAILABLE("Available"),
  @XmlEnumValue("Collected")
  COLLECTED("Collected"),
  @XmlEnumValue("Copyrighted")
  COPYRIGHTED("Copyrighted"),
  @XmlEnumValue("Created")
  CREATED("Created"),
  @XmlEnumValue("Issued")
  ISSUED("Issued"),
  @XmlEnumValue("Other")
  OTHER("Other"),
  @XmlEnumValue("Submitted")
  SUBMITTED("Submitted"),
  @XmlEnumValue("Updated")
  UPDATED("Updated"),
  @XmlEnumValue("Valid")
  VALID("Valid"),
  @XmlEnumValue("Withdrawn")
  WITHDRAWN("Withdrawn");
  private final String value;

  DateType(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static DateType fromValue(String v) {
    for (DateType c : DateType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
