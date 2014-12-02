package org.gbif.doi.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of Contributors .
 */
public enum ContributorType {
  CONTACT_PERSON("ContactPerson"),
  DATA_COLLECTOR("DataCollector"),
  DATA_MANAGER("DataManager"),
  DISTRIBUTOR("Distributor"),
  EDITOR("Editor"),
  FUNDER("Funder"),
  HOSTING_INSTITUTION("HostingInstitution"),
  PRODUCER("Producer"),
  PROJECT_LEADER("ProjectLeader"),
  PROJECT_MANAGER("ProjectManager"),
  PROJECT_MEMBER("ProjectMember"),
  REGISTRATION_AGENCY("RegistrationAgency"),
  REGISTRATION_AUTHORITY("RegistrationAuthority"),
  RELATED_PERSON("RelatedPerson"),
  RESEARCHER("Researcher"),
  RESEARCH_GROUP("ResearchGroup"),
  RIGHTS_HOLDER("RightsHolder"),
  SPONSOR("Sponsor"),
  SUPERVISOR("Supervisor"),
  WORK_PACKAGE_LEADER("WorkPackageLeader"),
  OTHER("Other");

  private final String value;

  ContributorType(String value) {
    this.value = value;
  }

  /**
   * Return the appropriate XML value for the enum value.
   * This allows us to configure Jackson directly to use this without special (de)serializers.
   */
  @Override
  public String toString() {
    return value;
  }
}
