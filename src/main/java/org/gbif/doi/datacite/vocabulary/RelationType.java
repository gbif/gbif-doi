package org.gbif.doi.datacite.vocabulary;

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
  IS_IDENTICAL_TO("IsIdenticalTo"),
  HAS_METADATA("HasMetadata"),
  IS_METADATA_FOR("IsMetadataFor"),
  REVIEWS("Reviews"),
  IS_REVIEWED_BY("IsReviewedBy"),
  IS_DERIVED_FROM("IsDerivedFrom"),
  IS_SOURCE_OF("IsSourceOf");

  private final String value;

  RelationType(String value) {
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
