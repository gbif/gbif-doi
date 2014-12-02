package org.gbif.doi.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of resources.
 */
public enum ResourceType {
  AUDIOVISUAL("Audiovisual"),
  COLLECTION("Collection"),
  DATASET("Dataset"),
  EVENT("Event"),
  IMAGE("Image"),
  INTERACTIVE_RESOURCE("InteractiveResource"),
  MODEL("Model"),
  PHYSICAL_OBJECT("PhysicalObject"),
  SERVICE("Service"),
  SOFTWARE("Software"),
  SOUND("Sound"),
  TEXT("Text"),
  WORKFLOW("Workflow"),
  OTHER("Other");

  private final String value;

  ResourceType(String value) {
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
