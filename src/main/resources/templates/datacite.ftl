<#escape x as x?xml>
  <#-- macro to populate nameIdentifier element from userId -->
  <#macro nameIdentifier agent>
    <#if agent.userIds?? && (agent.userIds?size>0)>
      <#assign userId = agent.userIds[0]/>
    <#-- If nameIdentifier is used, nameIdentifierScheme is mandatory. Currently only ORCIDs and ResearcherIDs are interpreted -->
      <#if userId?? && userId.identifier?? && userId.directory??>
        <#if userId.directory?lower_case?contains("orcid")>
        <nameIdentifier schemeURI="${userId.directory}" nameIdentifierScheme="ORCID">${userId.identifier}</nameIdentifier>
        <#elseif userId.directory?lower_case?contains("researcherid")>
        <nameIdentifier schemeURI="${userId.directory}" nameIdentifierScheme="ResearcherID">${userId.identifier}</nameIdentifier>
        </#if>
      </#if>
    </#if>
  </#macro>
  <#-- macro to populate a list of contributor elements from a list of agents -->
  <#macro contributorList contributors contributorType>
    <#if (contributors?size>0) >
      <#list contributors as contributor>
      <contributor contributorType="${contributorType}">
        <#if contributor.lastName??>
            <contributorName>${contributor.lastName}<#if contributor.firstName??>, ${contributor.firstName}</#if></contributorName>
        </#if>
        <@nameIdentifier contributor/>
        <#if contributor.organisation??>
            <affiliation>${contributor.organisation!}</affiliation>
        </#if>
      </contributor>
      </#list>
    </#if>
  </#macro>
  <#assign DATEIsoFormat="yyyy-MM-dd"/>
<?xml version="1.0" encoding="UTF-8"?>
<resource xsi:schemaLocation="http://datacite.org/schema/kernel-3 http://schema.datacite.org/meta/kernel-3/metadata.xsd" xmlns="http://datacite.org/schema/kernel-3" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <#-- DOI that uniquely identifies the resource -->
  <#if doi??>
    <identifier identifierType="DOI">${doi}</identifier>
  </#if>
  <#if (eml.creators?size>0) >
    <#-- Creators: the main researchers involved in producing the data in priority order -->
    <creators>
      <#list eml.creators as creator>
        <creator>
          <#if creator.lastName??>
            <creatorName>${creator.lastName}<#if creator.firstName??>, ${creator.firstName}</#if></creatorName>
          </#if>
          <@nameIdentifier creator/>
          <#if creator.organisation??>
              <affiliation>${creator.organisation!}</affiliation>
          </#if>
        </creator>
      </#list>
    </creators>
  </#if>
  <#if eml.title??>
    <#-- Resource title, language specified using xml:lang attribute defaulting to English -->
    <titles>
      <title xml:lang="${eml.metadataLanguage!"en"}">${eml.title}</title>
    </titles>
  </#if>
  <#if publisher??>
    <#-- Resource publishing organisation -->
    <publisher>${publisher}</publisher>
  </#if>
  <#if eml.dateStamp??>
    <#-- Year when resource was first published -->
    <publicationYear>${eml.dateStamp?date?string("yyyy")}</publicationYear>
  </#if>
  <#if (eml.keywords?size>0)>
    <#-- keyword(s) including language and scheme of the official keyword thesaurus from which keyword was derived -->
    <subjects>
      <#list eml.keywords as keyword>
        <#if (keyword.keywords?size>0)>
          <#list keyword.keywords as k>
            <subject xml:lang="${eml.metadataLanguage!"en"}" <#if keyword.keywordThesaurus??>subjectScheme="${keyword.keywordThesaurus}"</#if>>${k}</subject>
          </#list>
        </#if>
      </#list>
    </subjects>
  </#if>
  <#if (eml.contacts?size>0) || (eml.metadataProviders?size>0) || (eml.associatedParties?size>0)>
    <#-- Contributors: persons or intitutions contributing to the development of the resource -->
    <contributors>
      <#-- Contributors with contributorType ContactPerson (populated from EML contacts) -->
      <@contributorList eml.contacts "ContactPerson"/>
      <#-- Contributors with contributorType Editor (populated from EML metadataProviders) -->
      <@contributorList eml.metadataProviders "Editor"/>
      <#-- Contributors with contributorType Other (populated from EML associatedParties) -->
      <@contributorList eml.associatedParties "Other"/>
    </contributors>
  </#if>
  <#if eml.pubDate?? && eml.emlVersion??>
    <#-- Resource publication date, with dateType="Created" for initial publication and "Updated" for subsequent publications -->
    <dates>
      <#if eml.emlVersion?string == "1.0">
          <date dateType="Created">${eml.pubDate?date?string(DATEIsoFormat)}</date>
      <#else>
          <date dateType="Updated">${eml.pubDate?date?string(DATEIsoFormat)}</date>
      </#if>
    </dates>
  </#if>
  <#-- Primary language of the resource, defautling to English -->
  <language>${eml.language!"en"}</language>
  <#if resourceType??>
    <#-- A single free-text term describing more specifically what type of "Dataset" this resource is -->
    <resourceType resourceTypeGeneral="Dataset">${resourceType}</resourceType>
  </#if>
  <#if (eml.alternateIdentifiers?size>0)>
    <#-- Identifier(s) other than the primary identifier (DOI) -->
    <#-- If alternateIdentifier is used, alternateIdentifierType is mandatory. Currently only URLs and UUIDs are interpreted -->
    <alternateIdentifiers>
      <#list eml.alternateIdentifiers as alternateIdentifier>
        <#if alternateIdentifier?starts_with("http")>
          <alternateIdentifier alternateIdentifierType="URL">${alternateIdentifier}</alternateIdentifier>
        <#elseif alternateIdentifier?length == 32 || alternateIdentifier?length == 36>
          <alternateIdentifier alternateIdentifierType="UUID">${alternateIdentifier}</alternateIdentifier>
        </#if>
      </#list>
    </alternateIdentifiers>
  </#if>
  <#if eml.emlVersion??>
    <#-- The version number of the resource -->
    <version>${eml.emlVersion?string}</version>
  </#if>
  <#assign licenseUri="${eml.parseLicenseUrl()!}"/>
  <#assign licenseTitle="${eml.parseLicenseTitle()!}"/>
  <#if licenseUri?has_content && licenseTitle?has_content>
    <#-- Rights management statement for the resource -->
    <rightsList>
      <rights rightsURI="${licenseUri}">${licenseTitle}</rights>
    </rightsList>
  </#if>
  <#if eml.description??>
    <#-- Resource description(s) -->
    <descriptions>
      <description xml:lang="en-us" descriptionType="Abstract">${eml.description}</description>
    </descriptions>
  </#if>
  <#if eml.geospatialCoverages?? && (eml.geospatialCoverages?size>0)>
    <#-- Spatial region(s) where the data was gathered or where the data is focused -->
    <geoLocations>
      <#list eml.geospatialCoverages as geospatialCoverage>
        <#if geospatialCoverage.description?? && geospatialCoverage.boundingCoordinates??>
          <geoLocation>
            <geoLocationBox>${geospatialCoverage.boundingCoordinates.toStringWMS()?replace(","," ")!}</geoLocationBox>
            <geoLocationPlace>${geospatialCoverage.description!}</geoLocationPlace>
          </geoLocation>
        </#if>
      </#list>
    </geoLocations>
  </#if>
</resource>
</#escape>