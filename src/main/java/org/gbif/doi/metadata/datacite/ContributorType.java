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
 * Java class for contributorType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="contributorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ContactPerson"/&gt;
 *     &lt;enumeration value="DataCollector"/&gt;
 *     &lt;enumeration value="DataCurator"/&gt;
 *     &lt;enumeration value="DataManager"/&gt;
 *     &lt;enumeration value="Distributor"/&gt;
 *     &lt;enumeration value="Editor"/&gt;
 *     &lt;enumeration value="HostingInstitution"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *     &lt;enumeration value="Producer"/&gt;
 *     &lt;enumeration value="ProjectLeader"/&gt;
 *     &lt;enumeration value="ProjectManager"/&gt;
 *     &lt;enumeration value="ProjectMember"/&gt;
 *     &lt;enumeration value="RegistrationAgency"/&gt;
 *     &lt;enumeration value="RegistrationAuthority"/&gt;
 *     &lt;enumeration value="RelatedPerson"/&gt;
 *     &lt;enumeration value="ResearchGroup"/&gt;
 *     &lt;enumeration value="RightsHolder"/&gt;
 *     &lt;enumeration value="Researcher"/&gt;
 *     &lt;enumeration value="Sponsor"/&gt;
 *     &lt;enumeration value="Supervisor"/&gt;
 *     &lt;enumeration value="WorkPackageLeader"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "contributorType")
@XmlEnum
public enum ContributorType {
  @XmlEnumValue("ContactPerson")
  CONTACT_PERSON("ContactPerson"),
  @XmlEnumValue("DataCollector")
  DATA_COLLECTOR("DataCollector"),
  @XmlEnumValue("DataCurator")
  DATA_CURATOR("DataCurator"),
  @XmlEnumValue("DataManager")
  DATA_MANAGER("DataManager"),
  @XmlEnumValue("Distributor")
  DISTRIBUTOR("Distributor"),
  @XmlEnumValue("Editor")
  EDITOR("Editor"),
  @XmlEnumValue("HostingInstitution")
  HOSTING_INSTITUTION("HostingInstitution"),
  @XmlEnumValue("Other")
  OTHER("Other"),
  @XmlEnumValue("Producer")
  PRODUCER("Producer"),
  @XmlEnumValue("ProjectLeader")
  PROJECT_LEADER("ProjectLeader"),
  @XmlEnumValue("ProjectManager")
  PROJECT_MANAGER("ProjectManager"),
  @XmlEnumValue("ProjectMember")
  PROJECT_MEMBER("ProjectMember"),
  @XmlEnumValue("RegistrationAgency")
  REGISTRATION_AGENCY("RegistrationAgency"),
  @XmlEnumValue("RegistrationAuthority")
  REGISTRATION_AUTHORITY("RegistrationAuthority"),
  @XmlEnumValue("RelatedPerson")
  RELATED_PERSON("RelatedPerson"),
  @XmlEnumValue("ResearchGroup")
  RESEARCH_GROUP("ResearchGroup"),
  @XmlEnumValue("RightsHolder")
  RIGHTS_HOLDER("RightsHolder"),
  @XmlEnumValue("Researcher")
  RESEARCHER("Researcher"),
  @XmlEnumValue("Sponsor")
  SPONSOR("Sponsor"),
  @XmlEnumValue("Supervisor")
  SUPERVISOR("Supervisor"),
  @XmlEnumValue("WorkPackageLeader")
  WORK_PACKAGE_LEADER("WorkPackageLeader");
  private final String value;

  ContributorType(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ContributorType fromValue(String v) {
    for (ContributorType c : ContributorType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
