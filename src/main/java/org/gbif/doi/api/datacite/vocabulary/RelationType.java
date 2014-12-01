package org.gbif.doi.api.datacite.vocabulary;

/**
 * Enumeration representing the controlled vocabulary in the DataCite metadata schema version 3 for the different types
 * of relationships of the resource being registered (A) and the related resource (B).
 */
public enum RelationType {
  IS_CITED_BY("IsCitedBy"),
  CITES("Cites"),
  IS_SUPPLEMENT_TO("IsSupplementTo"),
  IS_SUPPLEMENTED_BY("IsSupplementedBy"),
  IS_CONTINUED_BY("IsContinuedBy"),
  CONTINUES("Continues"),
  HAS_METADATA("HasMetadata"),
  IS_METADATA_FOR("IsMetadataFor"),
  IS_NEW_VERSION_OF("IsNewVersionOf"),
  IS_PREVIOUS_VERSION_OF("IsPreviousVersionOf"),
  IS_PART_OF("IsPartOf"),
  HAS_PART("HasPart"),
  IS_REFERENCED_BY("IsReferencedBy"),
  REFERENCES("References"),
  IS_DOCUMENTED_BY("IsDocumentedBy"),
  DOCUMENTS("Documents"),
  IS_COMPILED_BY("IsCompiledBy"),
  COMPILES("Compiles"),
  IS_VARIANT_FORM_OF("IsVariantFormOf"),
  IS_ORIGINAL_FORM_OF("IsOriginalFormOf"),
  IS_IDENTICAL_TO("IsIdenticalTo");

  private final String printType;

  RelationType(String printType) {
    this.printType = printType;
  }

  /**
   * @return the RelationType as it should be printed in the XML document
   */
  public String getPrintType() {
    return printType;
  }
}
