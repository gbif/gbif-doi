package org.gbif.doi.api.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of general resource types.
 */
public enum ResourceTypeGeneral {
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

  private final String printType;

  ResourceTypeGeneral(String printType) {
   this.printType = printType;
  }

  /**
   * @return the ResourceTypeGeneral as it should be printed in the XML document
   */
  public String getPrintType() {
    return printType;
  }
}
