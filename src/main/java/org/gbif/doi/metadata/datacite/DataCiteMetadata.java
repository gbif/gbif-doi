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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;

/**
 * No content in this wrapper element.
 *
 * <p>Java class for resource element declaration.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;element name="resource"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;all&gt;
 *           &lt;element name="identifier"&gt;
 *             &lt;complexType&gt;
 *               &lt;simpleContent&gt;
 *                 &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
 *                   &lt;attribute name="identifierType" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                 &lt;/extension&gt;
 *               &lt;/simpleContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="creators"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="creator" maxOccurs="unbounded"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="creatorName"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;simpleContent&gt;
 *                                     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                       &lt;attribute name="nameType" type="{http://datacite.org/schema/kernel-4}nameType" /&gt;
 *                                       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/simpleContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *                               &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *                               &lt;element name="nameIdentifier" type="{http://datacite.org/schema/kernel-4}nameIdentifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element name="affiliation" type="{http://datacite.org/schema/kernel-4}affiliation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="titles"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="title" maxOccurs="unbounded"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;simpleContent&gt;
 *                           &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                             &lt;attribute name="titleType" type="{http://datacite.org/schema/kernel-4}titleType" /&gt;
 *                             &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/simpleContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="publisher"&gt;
 *             &lt;complexType&gt;
 *               &lt;simpleContent&gt;
 *                 &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
 *                   &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
 *                 &lt;/extension&gt;
 *               &lt;/simpleContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="publicationYear"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://datacite.org/schema/kernel-4}yearType"&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="resourceType"&gt;
 *             &lt;complexType&gt;
 *               &lt;simpleContent&gt;
 *                 &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                   &lt;attribute name="resourceTypeGeneral" use="required" type="{http://datacite.org/schema/kernel-4}resourceType" /&gt;
 *                 &lt;/extension&gt;
 *               &lt;/simpleContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="subjects" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="subject" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;simpleContent&gt;
 *                           &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                             &lt;attribute name="subjectScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                             &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                             &lt;attribute name="valueURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                             &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/simpleContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="contributors" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="contributor" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="contributorName"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;simpleContent&gt;
 *                                     &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
 *                                       &lt;attribute name="nameType" type="{http://datacite.org/schema/kernel-4}nameType" /&gt;
 *                                       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/simpleContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *                               &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *                               &lt;element name="nameIdentifier" type="{http://datacite.org/schema/kernel-4}nameIdentifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element name="affiliation" type="{http://datacite.org/schema/kernel-4}affiliation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;attribute name="contributorType" use="required" type="{http://datacite.org/schema/kernel-4}contributorType" /&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="dates" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="date" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;simpleContent&gt;
 *                           &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                             &lt;attribute name="dateType" use="required" type="{http://datacite.org/schema/kernel-4}dateType" /&gt;
 *                             &lt;attribute name="dateInformation" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/simpleContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}language" minOccurs="0"/&gt;
 *           &lt;element name="alternateIdentifiers" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="alternateIdentifier" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;simpleContent&gt;
 *                           &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                             &lt;attribute name="alternateIdentifierType" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/simpleContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="relatedIdentifiers" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="relatedIdentifier" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;simpleContent&gt;
 *                           &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                             &lt;attribute name="resourceTypeGeneral" type="{http://datacite.org/schema/kernel-4}resourceType" /&gt;
 *                             &lt;attribute name="relatedIdentifierType" use="required" type="{http://datacite.org/schema/kernel-4}relatedIdentifierType" /&gt;
 *                             &lt;attribute name="relationType" use="required" type="{http://datacite.org/schema/kernel-4}relationType" /&gt;
 *                             &lt;attribute name="relatedMetadataScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                             &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                             &lt;attribute name="schemeType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/simpleContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="sizes" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="formats" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *           &lt;element name="rightsList" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="rights" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;simpleContent&gt;
 *                           &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                             &lt;attribute name="rightsURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                             &lt;attribute name="rightsIdentifier" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                             &lt;attribute name="rightsIdentifierScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                             &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                             &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/simpleContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="descriptions" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="description" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="br" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/choice&gt;
 *                             &lt;attribute name="descriptionType" use="required" type="{http://datacite.org/schema/kernel-4}descriptionType" /&gt;
 *                             &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="geoLocations" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="geoLocation" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;choice maxOccurs="unbounded"&gt;
 *                               &lt;element name="geoLocationPlace" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *                               &lt;element name="geoLocationPoint" type="{http://datacite.org/schema/kernel-4}point" minOccurs="0"/&gt;
 *                               &lt;element name="geoLocationBox" type="{http://datacite.org/schema/kernel-4}box" minOccurs="0"/&gt;
 *                               &lt;element name="geoLocationPolygon" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="polygonPoint" type="{http://datacite.org/schema/kernel-4}point" maxOccurs="unbounded" minOccurs="4"/&gt;
 *                                         &lt;element name="inPolygonPoint" type="{http://datacite.org/schema/kernel-4}point" minOccurs="0"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/choice&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="fundingReferences" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="fundingReference" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;all&gt;
 *                               &lt;element name="funderName"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://datacite.org/schema/kernel-4}nonemptycontentStringType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="funderIdentifier" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;simpleContent&gt;
 *                                     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                       &lt;attribute name="funderIdentifierType" use="required" type="{http://datacite.org/schema/kernel-4}funderIdentifierType" /&gt;
 *                                       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/simpleContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="awardNumber" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;simpleContent&gt;
 *                                     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                       &lt;attribute name="awardURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/simpleContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="awardTitle" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *                             &lt;/all&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/all&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {})
@XmlRootElement(name = "resource")
public class DataCiteMetadata {

  @XmlElement(required = true)
  protected DataCiteMetadata.Identifier identifier;

  @XmlElement(required = true)
  protected DataCiteMetadata.Creators creators;

  @XmlElement(required = true)
  protected DataCiteMetadata.Titles titles;

  @XmlElement(required = true)
  protected DataCiteMetadata.Publisher publisher;

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String publicationYear;

  @XmlElement(required = true)
  protected DataCiteMetadata.ResourceType resourceType;

  protected DataCiteMetadata.Subjects subjects;
  protected DataCiteMetadata.Contributors contributors;
  protected DataCiteMetadata.Dates dates;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "language")
  protected String language;

  protected DataCiteMetadata.AlternateIdentifiers alternateIdentifiers;
  protected DataCiteMetadata.RelatedIdentifiers relatedIdentifiers;
  protected DataCiteMetadata.Sizes sizes;
  protected DataCiteMetadata.Formats formats;
  protected String version;
  protected DataCiteMetadata.RightsList rightsList;
  protected DataCiteMetadata.Descriptions descriptions;
  protected DataCiteMetadata.GeoLocations geoLocations;
  protected DataCiteMetadata.FundingReferences fundingReferences;

  /**
   * Gets the value of the identifier property.
   *
   * @return possible object is {@link DataCiteMetadata.Identifier }
   */
  public DataCiteMetadata.Identifier getIdentifier() {
    return identifier;
  }

  /**
   * Sets the value of the identifier property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Identifier }
   */
  public void setIdentifier(DataCiteMetadata.Identifier value) {
    this.identifier = value;
  }

  /**
   * Gets the value of the creators property.
   *
   * @return possible object is {@link DataCiteMetadata.Creators }
   */
  public DataCiteMetadata.Creators getCreators() {
    return creators;
  }

  /**
   * Sets the value of the creators property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Creators }
   */
  public void setCreators(DataCiteMetadata.Creators value) {
    this.creators = value;
  }

  /**
   * Gets the value of the titles property.
   *
   * @return possible object is {@link DataCiteMetadata.Titles }
   */
  public DataCiteMetadata.Titles getTitles() {
    return titles;
  }

  /**
   * Sets the value of the titles property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Titles }
   */
  public void setTitles(DataCiteMetadata.Titles value) {
    this.titles = value;
  }

  /**
   * Gets the value of the publisher property.
   *
   * @return possible object is {@link DataCiteMetadata.Publisher }
   */
  public DataCiteMetadata.Publisher getPublisher() {
    return publisher;
  }

  /**
   * Sets the value of the publisher property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Publisher }
   */
  public void setPublisher(DataCiteMetadata.Publisher value) {
    this.publisher = value;
  }

  /**
   * Gets the value of the publicationYear property.
   *
   * @return possible object is {@link String }
   */
  public String getPublicationYear() {
    return publicationYear;
  }

  /**
   * Sets the value of the publicationYear property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPublicationYear(String value) {
    this.publicationYear = value;
  }

  /**
   * Gets the value of the resourceType property.
   *
   * @return possible object is {@link DataCiteMetadata.ResourceType }
   */
  public DataCiteMetadata.ResourceType getResourceType() {
    return resourceType;
  }

  /**
   * Sets the value of the resourceType property.
   *
   * @param value allowed object is {@link DataCiteMetadata.ResourceType }
   */
  public void setResourceType(DataCiteMetadata.ResourceType value) {
    this.resourceType = value;
  }

  /**
   * Gets the value of the subjects property.
   *
   * @return possible object is {@link DataCiteMetadata.Subjects }
   */
  public DataCiteMetadata.Subjects getSubjects() {
    return subjects;
  }

  /**
   * Sets the value of the subjects property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Subjects }
   */
  public void setSubjects(DataCiteMetadata.Subjects value) {
    this.subjects = value;
  }

  /**
   * Gets the value of the contributors property.
   *
   * @return possible object is {@link DataCiteMetadata.Contributors }
   */
  public DataCiteMetadata.Contributors getContributors() {
    return contributors;
  }

  /**
   * Sets the value of the contributors property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Contributors }
   */
  public void setContributors(DataCiteMetadata.Contributors value) {
    this.contributors = value;
  }

  /**
   * Gets the value of the dates property.
   *
   * @return possible object is {@link DataCiteMetadata.Dates }
   */
  public DataCiteMetadata.Dates getDates() {
    return dates;
  }

  /**
   * Sets the value of the dates property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Dates }
   */
  public void setDates(DataCiteMetadata.Dates value) {
    this.dates = value;
  }

  /**
   * Gets the value of the language property.
   *
   * @return possible object is {@link String }
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Sets the value of the language property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLanguage(String value) {
    this.language = value;
  }

  /**
   * Gets the value of the alternateIdentifiers property.
   *
   * @return possible object is {@link DataCiteMetadata.AlternateIdentifiers }
   */
  public DataCiteMetadata.AlternateIdentifiers getAlternateIdentifiers() {
    return alternateIdentifiers;
  }

  /**
   * Sets the value of the alternateIdentifiers property.
   *
   * @param value allowed object is {@link DataCiteMetadata.AlternateIdentifiers }
   */
  public void setAlternateIdentifiers(DataCiteMetadata.AlternateIdentifiers value) {
    this.alternateIdentifiers = value;
  }

  /**
   * Gets the value of the relatedIdentifiers property.
   *
   * @return possible object is {@link DataCiteMetadata.RelatedIdentifiers }
   */
  public DataCiteMetadata.RelatedIdentifiers getRelatedIdentifiers() {
    return relatedIdentifiers;
  }

  /**
   * Sets the value of the relatedIdentifiers property.
   *
   * @param value allowed object is {@link DataCiteMetadata.RelatedIdentifiers }
   */
  public void setRelatedIdentifiers(DataCiteMetadata.RelatedIdentifiers value) {
    this.relatedIdentifiers = value;
  }

  /**
   * Gets the value of the sizes property.
   *
   * @return possible object is {@link DataCiteMetadata.Sizes }
   */
  public DataCiteMetadata.Sizes getSizes() {
    return sizes;
  }

  /**
   * Sets the value of the sizes property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Sizes }
   */
  public void setSizes(DataCiteMetadata.Sizes value) {
    this.sizes = value;
  }

  /**
   * Gets the value of the formats property.
   *
   * @return possible object is {@link DataCiteMetadata.Formats }
   */
  public DataCiteMetadata.Formats getFormats() {
    return formats;
  }

  /**
   * Sets the value of the formats property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Formats }
   */
  public void setFormats(DataCiteMetadata.Formats value) {
    this.formats = value;
  }

  /**
   * Gets the value of the version property.
   *
   * @return possible object is {@link String }
   */
  public String getVersion() {
    return version;
  }

  /**
   * Sets the value of the version property.
   *
   * @param value allowed object is {@link String }
   */
  public void setVersion(String value) {
    this.version = value;
  }

  /**
   * Gets the value of the rightsList property.
   *
   * @return possible object is {@link DataCiteMetadata.RightsList }
   */
  public DataCiteMetadata.RightsList getRightsList() {
    return rightsList;
  }

  /**
   * Sets the value of the rightsList property.
   *
   * @param value allowed object is {@link DataCiteMetadata.RightsList }
   */
  public void setRightsList(DataCiteMetadata.RightsList value) {
    this.rightsList = value;
  }

  /**
   * Gets the value of the descriptions property.
   *
   * @return possible object is {@link DataCiteMetadata.Descriptions }
   */
  public DataCiteMetadata.Descriptions getDescriptions() {
    return descriptions;
  }

  /**
   * Sets the value of the descriptions property.
   *
   * @param value allowed object is {@link DataCiteMetadata.Descriptions }
   */
  public void setDescriptions(DataCiteMetadata.Descriptions value) {
    this.descriptions = value;
  }

  /**
   * Gets the value of the geoLocations property.
   *
   * @return possible object is {@link DataCiteMetadata.GeoLocations }
   */
  public DataCiteMetadata.GeoLocations getGeoLocations() {
    return geoLocations;
  }

  /**
   * Sets the value of the geoLocations property.
   *
   * @param value allowed object is {@link DataCiteMetadata.GeoLocations }
   */
  public void setGeoLocations(DataCiteMetadata.GeoLocations value) {
    this.geoLocations = value;
  }

  /**
   * Gets the value of the fundingReferences property.
   *
   * @return possible object is {@link DataCiteMetadata.FundingReferences }
   */
  public DataCiteMetadata.FundingReferences getFundingReferences() {
    return fundingReferences;
  }

  /**
   * Sets the value of the fundingReferences property.
   *
   * @param value allowed object is {@link DataCiteMetadata.FundingReferences }
   */
  public void setFundingReferences(DataCiteMetadata.FundingReferences value) {
    this.fundingReferences = value;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method
   * and should not be called directly by client code.
   *
   * @param _other A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(final DataCiteMetadata.Builder<_B> _other) {
    _other.identifier = ((this.identifier == null) ? null : this.identifier.newCopyBuilder(_other));
    _other.creators = ((this.creators == null) ? null : this.creators.newCopyBuilder(_other));
    _other.titles = ((this.titles == null) ? null : this.titles.newCopyBuilder(_other));
    _other.publisher = ((this.publisher == null) ? null : this.publisher.newCopyBuilder(_other));
    _other.publicationYear = this.publicationYear;
    _other.resourceType =
        ((this.resourceType == null) ? null : this.resourceType.newCopyBuilder(_other));
    _other.subjects = ((this.subjects == null) ? null : this.subjects.newCopyBuilder(_other));
    _other.contributors =
        ((this.contributors == null) ? null : this.contributors.newCopyBuilder(_other));
    _other.dates = ((this.dates == null) ? null : this.dates.newCopyBuilder(_other));
    _other.language = this.language;
    _other.alternateIdentifiers =
        ((this.alternateIdentifiers == null)
            ? null
            : this.alternateIdentifiers.newCopyBuilder(_other));
    _other.relatedIdentifiers =
        ((this.relatedIdentifiers == null) ? null : this.relatedIdentifiers.newCopyBuilder(_other));
    _other.sizes = ((this.sizes == null) ? null : this.sizes.newCopyBuilder(_other));
    _other.formats = ((this.formats == null) ? null : this.formats.newCopyBuilder(_other));
    _other.version = this.version;
    _other.rightsList = ((this.rightsList == null) ? null : this.rightsList.newCopyBuilder(_other));
    _other.descriptions =
        ((this.descriptions == null) ? null : this.descriptions.newCopyBuilder(_other));
    _other.geoLocations =
        ((this.geoLocations == null) ? null : this.geoLocations.newCopyBuilder(_other));
    _other.fundingReferences =
        ((this.fundingReferences == null) ? null : this.fundingReferences.newCopyBuilder(_other));
  }

  public <_B> DataCiteMetadata.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
    return new DataCiteMetadata.Builder<_B>(_parentBuilder, this, true);
  }

  public DataCiteMetadata.Builder<Void> newCopyBuilder() {
    return newCopyBuilder(null);
  }

  public static DataCiteMetadata.Builder<Void> builder() {
    return new DataCiteMetadata.Builder<Void>(null, null, false);
  }

  public static <_B> DataCiteMetadata.Builder<_B> copyOf(final DataCiteMetadata _other) {
    final DataCiteMetadata.Builder<_B> _newBuilder =
        new DataCiteMetadata.Builder<_B>(null, null, false);
    _other.copyTo(_newBuilder);
    return _newBuilder;
  }

  /**
   * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method
   * and should not be called directly by client code.
   *
   * @param _other A builder instance to which the state of this object will be copied.
   */
  public <_B> void copyTo(
      final DataCiteMetadata.Builder<_B> _other,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    final PropertyTree identifierPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("identifier"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (identifierPropertyTree != null)
        : ((identifierPropertyTree == null) || (!identifierPropertyTree.isLeaf())))) {
      _other.identifier =
          ((this.identifier == null)
              ? null
              : this.identifier.newCopyBuilder(_other, identifierPropertyTree, _propertyTreeUse));
    }
    final PropertyTree creatorsPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("creators"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (creatorsPropertyTree != null)
        : ((creatorsPropertyTree == null) || (!creatorsPropertyTree.isLeaf())))) {
      _other.creators =
          ((this.creators == null)
              ? null
              : this.creators.newCopyBuilder(_other, creatorsPropertyTree, _propertyTreeUse));
    }
    final PropertyTree titlesPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("titles"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (titlesPropertyTree != null)
        : ((titlesPropertyTree == null) || (!titlesPropertyTree.isLeaf())))) {
      _other.titles =
          ((this.titles == null)
              ? null
              : this.titles.newCopyBuilder(_other, titlesPropertyTree, _propertyTreeUse));
    }
    final PropertyTree publisherPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("publisher"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (publisherPropertyTree != null)
        : ((publisherPropertyTree == null) || (!publisherPropertyTree.isLeaf())))) {
      _other.publisher =
          ((this.publisher == null)
              ? null
              : this.publisher.newCopyBuilder(_other, publisherPropertyTree, _propertyTreeUse));
    }
    final PropertyTree publicationYearPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("publicationYear"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (publicationYearPropertyTree != null)
        : ((publicationYearPropertyTree == null) || (!publicationYearPropertyTree.isLeaf())))) {
      _other.publicationYear = this.publicationYear;
    }
    final PropertyTree resourceTypePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("resourceType"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (resourceTypePropertyTree != null)
        : ((resourceTypePropertyTree == null) || (!resourceTypePropertyTree.isLeaf())))) {
      _other.resourceType =
          ((this.resourceType == null)
              ? null
              : this.resourceType.newCopyBuilder(
                  _other, resourceTypePropertyTree, _propertyTreeUse));
    }
    final PropertyTree subjectsPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("subjects"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (subjectsPropertyTree != null)
        : ((subjectsPropertyTree == null) || (!subjectsPropertyTree.isLeaf())))) {
      _other.subjects =
          ((this.subjects == null)
              ? null
              : this.subjects.newCopyBuilder(_other, subjectsPropertyTree, _propertyTreeUse));
    }
    final PropertyTree contributorsPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("contributors"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (contributorsPropertyTree != null)
        : ((contributorsPropertyTree == null) || (!contributorsPropertyTree.isLeaf())))) {
      _other.contributors =
          ((this.contributors == null)
              ? null
              : this.contributors.newCopyBuilder(
                  _other, contributorsPropertyTree, _propertyTreeUse));
    }
    final PropertyTree datesPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("dates"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (datesPropertyTree != null)
        : ((datesPropertyTree == null) || (!datesPropertyTree.isLeaf())))) {
      _other.dates =
          ((this.dates == null)
              ? null
              : this.dates.newCopyBuilder(_other, datesPropertyTree, _propertyTreeUse));
    }
    final PropertyTree languagePropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("language"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (languagePropertyTree != null)
        : ((languagePropertyTree == null) || (!languagePropertyTree.isLeaf())))) {
      _other.language = this.language;
    }
    final PropertyTree alternateIdentifiersPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("alternateIdentifiers"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (alternateIdentifiersPropertyTree != null)
        : ((alternateIdentifiersPropertyTree == null)
            || (!alternateIdentifiersPropertyTree.isLeaf())))) {
      _other.alternateIdentifiers =
          ((this.alternateIdentifiers == null)
              ? null
              : this.alternateIdentifiers.newCopyBuilder(
                  _other, alternateIdentifiersPropertyTree, _propertyTreeUse));
    }
    final PropertyTree relatedIdentifiersPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("relatedIdentifiers"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (relatedIdentifiersPropertyTree != null)
        : ((relatedIdentifiersPropertyTree == null)
            || (!relatedIdentifiersPropertyTree.isLeaf())))) {
      _other.relatedIdentifiers =
          ((this.relatedIdentifiers == null)
              ? null
              : this.relatedIdentifiers.newCopyBuilder(
                  _other, relatedIdentifiersPropertyTree, _propertyTreeUse));
    }
    final PropertyTree sizesPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("sizes"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (sizesPropertyTree != null)
        : ((sizesPropertyTree == null) || (!sizesPropertyTree.isLeaf())))) {
      _other.sizes =
          ((this.sizes == null)
              ? null
              : this.sizes.newCopyBuilder(_other, sizesPropertyTree, _propertyTreeUse));
    }
    final PropertyTree formatsPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("formats"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (formatsPropertyTree != null)
        : ((formatsPropertyTree == null) || (!formatsPropertyTree.isLeaf())))) {
      _other.formats =
          ((this.formats == null)
              ? null
              : this.formats.newCopyBuilder(_other, formatsPropertyTree, _propertyTreeUse));
    }
    final PropertyTree versionPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("version"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (versionPropertyTree != null)
        : ((versionPropertyTree == null) || (!versionPropertyTree.isLeaf())))) {
      _other.version = this.version;
    }
    final PropertyTree rightsListPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("rightsList"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (rightsListPropertyTree != null)
        : ((rightsListPropertyTree == null) || (!rightsListPropertyTree.isLeaf())))) {
      _other.rightsList =
          ((this.rightsList == null)
              ? null
              : this.rightsList.newCopyBuilder(_other, rightsListPropertyTree, _propertyTreeUse));
    }
    final PropertyTree descriptionsPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("descriptions"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (descriptionsPropertyTree != null)
        : ((descriptionsPropertyTree == null) || (!descriptionsPropertyTree.isLeaf())))) {
      _other.descriptions =
          ((this.descriptions == null)
              ? null
              : this.descriptions.newCopyBuilder(
                  _other, descriptionsPropertyTree, _propertyTreeUse));
    }
    final PropertyTree geoLocationsPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("geoLocations"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (geoLocationsPropertyTree != null)
        : ((geoLocationsPropertyTree == null) || (!geoLocationsPropertyTree.isLeaf())))) {
      _other.geoLocations =
          ((this.geoLocations == null)
              ? null
              : this.geoLocations.newCopyBuilder(
                  _other, geoLocationsPropertyTree, _propertyTreeUse));
    }
    final PropertyTree fundingReferencesPropertyTree =
        ((_propertyTree == null) ? null : _propertyTree.get("fundingReferences"));
    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
        ? (fundingReferencesPropertyTree != null)
        : ((fundingReferencesPropertyTree == null) || (!fundingReferencesPropertyTree.isLeaf())))) {
      _other.fundingReferences =
          ((this.fundingReferences == null)
              ? null
              : this.fundingReferences.newCopyBuilder(
                  _other, fundingReferencesPropertyTree, _propertyTreeUse));
    }
  }

  public <_B> DataCiteMetadata.Builder<_B> newCopyBuilder(
      final _B _parentBuilder,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    return new DataCiteMetadata.Builder<_B>(
        _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
  }

  public DataCiteMetadata.Builder<Void> newCopyBuilder(
      final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
  }

  public static <_B> DataCiteMetadata.Builder<_B> copyOf(
      final DataCiteMetadata _other,
      final PropertyTree _propertyTree,
      final PropertyTreeUse _propertyTreeUse) {
    final DataCiteMetadata.Builder<_B> _newBuilder =
        new DataCiteMetadata.Builder<_B>(null, null, false);
    _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
    return _newBuilder;
  }

  public static DataCiteMetadata.Builder<Void> copyExcept(
      final DataCiteMetadata _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
  }

  public static DataCiteMetadata.Builder<Void> copyOnly(
      final DataCiteMetadata _other, final PropertyTree _propertyTree) {
    return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", DataCiteMetadata.class.getSimpleName() + "[", "]")
        .add("identifier=" + identifier)
        .add("creators=" + creators)
        .add("titles=" + titles)
        .add("publisher=" + publisher)
        .add("publicationYear='" + publicationYear + "'")
        .add("resourceType=" + resourceType)
        .add("subjects=" + subjects)
        .add("contributors=" + contributors)
        .add("dates=" + dates)
        .add("language='" + language + "'")
        .add("alternateIdentifiers=" + alternateIdentifiers)
        .add("relatedIdentifiers=" + relatedIdentifiers)
        .add("sizes=" + sizes)
        .add("formats=" + formats)
        .add("version='" + version + "'")
        .add("rightsList=" + rightsList)
        .add("descriptions=" + descriptions)
        .add("geoLocations=" + geoLocations)
        .add("fundingReferences=" + fundingReferences)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DataCiteMetadata that = (DataCiteMetadata) o;

    return Objects.equals(identifier, that.identifier)
        && Objects.equals(creators, that.creators)
        && Objects.equals(titles, that.titles)
        && Objects.equals(publisher, that.publisher)
        && Objects.equals(publicationYear, that.publicationYear)
        && Objects.equals(resourceType, that.resourceType)
        && Objects.equals(subjects, that.subjects)
        && Objects.equals(contributors, that.contributors)
        && Objects.equals(dates, that.dates)
        && Objects.equals(language, that.language)
        && Objects.equals(alternateIdentifiers, that.alternateIdentifiers)
        && Objects.equals(relatedIdentifiers, that.relatedIdentifiers)
        && Objects.equals(sizes, that.sizes)
        && Objects.equals(formats, that.formats)
        && Objects.equals(version, that.version)
        && Objects.equals(rightsList, that.rightsList)
        && Objects.equals(descriptions, that.descriptions)
        && Objects.equals(geoLocations, that.geoLocations)
        && Objects.equals(fundingReferences, that.fundingReferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        identifier,
        creators,
        titles,
        publisher,
        publicationYear,
        resourceType,
        subjects,
        contributors,
        dates,
        language,
        alternateIdentifiers,
        relatedIdentifiers,
        sizes,
        formats,
        version,
        rightsList,
        descriptions,
        geoLocations,
        fundingReferences);
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="alternateIdentifier" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;simpleContent&gt;
   *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                 &lt;attribute name="alternateIdentifierType" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
   *               &lt;/extension&gt;
   *             &lt;/simpleContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"alternateIdentifier"})
  public static class AlternateIdentifiers {

    protected List<DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier> alternateIdentifier;

    /**
     * Gets the value of the alternateIdentifier property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the alternateIdentifier property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getAlternateIdentifier().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier }
     */
    public List<DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier>
        getAlternateIdentifier() {
      if (alternateIdentifier == null) {
        alternateIdentifier =
            new ArrayList<DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier>();
      }
      return this.alternateIdentifier;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.AlternateIdentifiers.Builder<_B> _other) {
      if (this.alternateIdentifier == null) {
        _other.alternateIdentifier = null;
      } else {
        _other.alternateIdentifier =
            new ArrayList<
                DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                    DataCiteMetadata.AlternateIdentifiers.Builder<_B>>>();
        for (DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _item :
            this.alternateIdentifier) {
          _other.alternateIdentifier.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.AlternateIdentifiers.Builder<_B> newCopyBuilder(
        final _B _parentBuilder) {
      return new DataCiteMetadata.AlternateIdentifiers.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.AlternateIdentifiers.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.AlternateIdentifiers.Builder<Void> builder() {
      return new DataCiteMetadata.AlternateIdentifiers.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.AlternateIdentifiers.Builder<_B> copyOf(
        final DataCiteMetadata.AlternateIdentifiers _other) {
      final DataCiteMetadata.AlternateIdentifiers.Builder<_B> _newBuilder =
          new DataCiteMetadata.AlternateIdentifiers.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.AlternateIdentifiers.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree alternateIdentifierPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("alternateIdentifier"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (alternateIdentifierPropertyTree != null)
          : ((alternateIdentifierPropertyTree == null)
              || (!alternateIdentifierPropertyTree.isLeaf())))) {
        if (this.alternateIdentifier == null) {
          _other.alternateIdentifier = null;
        } else {
          _other.alternateIdentifier =
              new ArrayList<
                  DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                      DataCiteMetadata.AlternateIdentifiers.Builder<_B>>>();
          for (DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _item :
              this.alternateIdentifier) {
            _other.alternateIdentifier.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(
                        _other, alternateIdentifierPropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.AlternateIdentifiers.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.AlternateIdentifiers.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.AlternateIdentifiers.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.AlternateIdentifiers.Builder<_B> copyOf(
        final DataCiteMetadata.AlternateIdentifiers _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.AlternateIdentifiers.Builder<_B> _newBuilder =
          new DataCiteMetadata.AlternateIdentifiers.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.AlternateIdentifiers.Builder<Void> copyExcept(
        final DataCiteMetadata.AlternateIdentifiers _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.AlternateIdentifiers.Builder<Void> copyOnly(
        final DataCiteMetadata.AlternateIdentifiers _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", AlternateIdentifiers.class.getSimpleName() + "[", "]")
          .add("alternateIdentifier=" + alternateIdentifier)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      AlternateIdentifiers that = (AlternateIdentifiers) o;
      return Objects.equals(alternateIdentifier, that.alternateIdentifier);
    }

    @Override
    public int hashCode() {
      return Objects.hash(alternateIdentifier);
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="alternateIdentifierType" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"value"})
    public static class AlternateIdentifier {

      @XmlValue protected String value;

      @XmlAttribute(name = "alternateIdentifierType", required = true)
      @XmlSchemaType(name = "anySimpleType")
      protected String alternateIdentifierType;

      /**
       * Gets the value of the value property.
       *
       * @return possible object is {@link String }
       */
      public String getValue() {
        return value;
      }

      /**
       * Sets the value of the value property.
       *
       * @param value allowed object is {@link String }
       */
      public void setValue(String value) {
        this.value = value;
      }

      /**
       * Gets the value of the alternateIdentifierType property.
       *
       * @return possible object is {@link String }
       */
      public String getAlternateIdentifierType() {
        return alternateIdentifierType;
      }

      /**
       * Sets the value of the alternateIdentifierType property.
       *
       * @param value allowed object is {@link String }
       */
      public void setAlternateIdentifierType(String value) {
        this.alternateIdentifierType = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> _other) {
        _other.value = this.value;
        _other.alternateIdentifierType = this.alternateIdentifierType;
      }

      public <_B>
          DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> newCopyBuilder(
              final _B _parentBuilder) {
        return new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B>(
            _parentBuilder, this, true);
      }

      public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<Void>
          newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<Void>
          builder() {
        return new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<Void>(
            null, null, false);
      }

      public static <_B>
          DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> copyOf(
              final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _other) {
        final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> _newBuilder =
            new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B>(
                null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree valuePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("value"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (valuePropertyTree != null)
            : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
          _other.value = this.value;
        }
        final PropertyTree alternateIdentifierTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("alternateIdentifierType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (alternateIdentifierTypePropertyTree != null)
            : ((alternateIdentifierTypePropertyTree == null)
                || (!alternateIdentifierTypePropertyTree.isLeaf())))) {
          _other.alternateIdentifierType = this.alternateIdentifierType;
        }
      }

      public <_B>
          DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> newCopyBuilder(
              final _B _parentBuilder,
              final PropertyTree _propertyTree,
              final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B>
          DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> copyOf(
              final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _other,
              final PropertyTree _propertyTree,
              final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> _newBuilder =
            new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B>(
                null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<Void>
          copyExcept(
              final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _other,
              final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<Void>
          copyOnly(
              final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _other,
              final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", AlternateIdentifier.class.getSimpleName() + "[", "]")
            .add("value='" + value + "'")
            .add("alternateIdentifierType='" + alternateIdentifierType + "'")
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlternateIdentifier that = (AlternateIdentifier) o;
        return Objects.equals(value, that.value)
            && Objects.equals(alternateIdentifierType, that.alternateIdentifierType);
      }

      @Override
      public int hashCode() {
        return Objects.hash(value, alternateIdentifierType);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _storedValue;
        private String value;
        private String alternateIdentifierType;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.value = _other.value;
              this.alternateIdentifierType = _other.alternateIdentifierType;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree valuePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("value"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (valuePropertyTree != null)
                  : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                this.value = _other.value;
              }
              final PropertyTree alternateIdentifierTypePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("alternateIdentifierType"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (alternateIdentifierTypePropertyTree != null)
                  : ((alternateIdentifierTypePropertyTree == null)
                      || (!alternateIdentifierTypePropertyTree.isLeaf())))) {
                this.alternateIdentifierType = _other.alternateIdentifierType;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier> _P init(
            final _P _product) {
          _product.value = this.value;
          _product.alternateIdentifierType = this.alternateIdentifierType;
          return _product;
        }

        /**
         * Sets the new value of "value" (any previous value will be replaced)
         *
         * @param value New value of the "value" property.
         */
        public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> withValue(
            final String value) {
          this.value = value;
          return this;
        }

        /**
         * Sets the new value of "alternateIdentifierType" (any previous value will be replaced)
         *
         * @param alternateIdentifierType New value of the "alternateIdentifierType" property.
         */
        public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B>
            withAlternateIdentifierType(final String alternateIdentifierType) {
          this.alternateIdentifierType = alternateIdentifierType;
          return this;
        }

        @Override
        public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier());
          } else {
            return ((DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier) _storedValue);
          }
        }

        public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> copyOf(
            final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<_B> copyOf(
            final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder _other) {
          return copyOf(_other.build());
        }
      }

      public static class Select
          extends DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<
              DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Select _root() {
          return new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<TRoot, TParent>>
            value = null;
        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<TRoot, TParent>>
            alternateIdentifierType = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.value != null) {
            products.put("value", this.value.init());
          }
          if (this.alternateIdentifierType != null) {
            products.put("alternateIdentifierType", this.alternateIdentifierType.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<TRoot, TParent>>
            value() {
          return ((this.value == null)
              ? this.value =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "value")
              : this.value);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<TRoot, TParent>>
            alternateIdentifierType() {
          return ((this.alternateIdentifierType == null)
              ? this.alternateIdentifierType =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "alternateIdentifierType")
              : this.alternateIdentifierType);
        }
      }
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.AlternateIdentifiers _storedValue;
      private List<
              DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                  DataCiteMetadata.AlternateIdentifiers.Builder<_B>>>
          alternateIdentifier;

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.AlternateIdentifiers _other,
          final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.alternateIdentifier == null) {
              this.alternateIdentifier = null;
            } else {
              this.alternateIdentifier =
                  new ArrayList<
                      DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                          DataCiteMetadata.AlternateIdentifiers.Builder<_B>>>();
              for (DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _item :
                  _other.alternateIdentifier) {
                this.alternateIdentifier.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.AlternateIdentifiers _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree alternateIdentifierPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("alternateIdentifier"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (alternateIdentifierPropertyTree != null)
                : ((alternateIdentifierPropertyTree == null)
                    || (!alternateIdentifierPropertyTree.isLeaf())))) {
              if (_other.alternateIdentifier == null) {
                this.alternateIdentifier = null;
              } else {
                this.alternateIdentifier =
                    new ArrayList<
                        DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                            DataCiteMetadata.AlternateIdentifiers.Builder<_B>>>();
                for (DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _item :
                    _other.alternateIdentifier) {
                  this.alternateIdentifier.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(
                              this, alternateIdentifierPropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.AlternateIdentifiers> _P init(final _P _product) {
        if (this.alternateIdentifier != null) {
          final List<DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier>
              alternateIdentifier =
                  new ArrayList<DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier>(
                      this.alternateIdentifier.size());
          for (DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                  DataCiteMetadata.AlternateIdentifiers.Builder<_B>>
              _item : this.alternateIdentifier) {
            alternateIdentifier.add(_item.build());
          }
          _product.alternateIdentifier = alternateIdentifier;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "alternateIdentifier"
       *
       * @param alternateIdentifier Items to add to the value of the "alternateIdentifier" property
       */
      public DataCiteMetadata.AlternateIdentifiers.Builder<_B> addAlternateIdentifier(
          final Iterable<? extends DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier>
              alternateIdentifier) {
        if (alternateIdentifier != null) {
          if (this.alternateIdentifier == null) {
            this.alternateIdentifier =
                new ArrayList<
                    DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                        DataCiteMetadata.AlternateIdentifiers.Builder<_B>>>();
          }
          for (DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier _item :
              alternateIdentifier) {
            this.alternateIdentifier.add(
                new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                    DataCiteMetadata.AlternateIdentifiers.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "alternateIdentifier" (any previous value will be replaced)
       *
       * @param alternateIdentifier New value of the "alternateIdentifier" property.
       */
      public DataCiteMetadata.AlternateIdentifiers.Builder<_B> withAlternateIdentifier(
          final Iterable<? extends DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier>
              alternateIdentifier) {
        if (this.alternateIdentifier != null) {
          this.alternateIdentifier.clear();
        }
        return addAlternateIdentifier(alternateIdentifier);
      }

      /**
       * Adds the given items to the value of "alternateIdentifier"
       *
       * @param alternateIdentifier Items to add to the value of the "alternateIdentifier" property
       */
      public DataCiteMetadata.AlternateIdentifiers.Builder<_B> addAlternateIdentifier(
          DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier... alternateIdentifier) {
        addAlternateIdentifier(Arrays.asList(alternateIdentifier));
        return this;
      }

      /**
       * Sets the new value of "alternateIdentifier" (any previous value will be replaced)
       *
       * @param alternateIdentifier New value of the "alternateIdentifier" property.
       */
      public DataCiteMetadata.AlternateIdentifiers.Builder<_B> withAlternateIdentifier(
          DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier... alternateIdentifier) {
        withAlternateIdentifier(Arrays.asList(alternateIdentifier));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "AlternateIdentifier" property.
       * Use {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder#end()}
       * to return to the current builder.
       *
       * @return a new builder to build an additional value of the "AlternateIdentifier" property.
       *     Use {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder#end()}
       *     to return to the current builder.
       */
      public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
              ? extends DataCiteMetadata.AlternateIdentifiers.Builder<_B>>
          addAlternateIdentifier() {
        if (this.alternateIdentifier == null) {
          this.alternateIdentifier =
              new ArrayList<
                  DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                      DataCiteMetadata.AlternateIdentifiers.Builder<_B>>>();
        }
        final DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                DataCiteMetadata.AlternateIdentifiers.Builder<_B>>
            alternateIdentifier_Builder =
                new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Builder<
                    DataCiteMetadata.AlternateIdentifiers.Builder<_B>>(this, null, false);
        this.alternateIdentifier.add(alternateIdentifier_Builder);
        return alternateIdentifier_Builder;
      }

      @Override
      public DataCiteMetadata.AlternateIdentifiers build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.AlternateIdentifiers());
        } else {
          return ((DataCiteMetadata.AlternateIdentifiers) _storedValue);
        }
      }

      public DataCiteMetadata.AlternateIdentifiers.Builder<_B> copyOf(
          final DataCiteMetadata.AlternateIdentifiers _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.AlternateIdentifiers.Builder<_B> copyOf(
          final DataCiteMetadata.AlternateIdentifiers.Builder _other) {
        return copyOf(_other.build());
      }
    }

    public static class Select
        extends DataCiteMetadata.AlternateIdentifiers.Selector<
            DataCiteMetadata.AlternateIdentifiers.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.AlternateIdentifiers.Select _root() {
        return new DataCiteMetadata.AlternateIdentifiers.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<
              TRoot, DataCiteMetadata.AlternateIdentifiers.Selector<TRoot, TParent>>
          alternateIdentifier = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.alternateIdentifier != null) {
          products.put("alternateIdentifier", this.alternateIdentifier.init());
        }
        return products;
      }

      public DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<
              TRoot, DataCiteMetadata.AlternateIdentifiers.Selector<TRoot, TParent>>
          alternateIdentifier() {
        return ((this.alternateIdentifier == null)
            ? this.alternateIdentifier =
                new DataCiteMetadata.AlternateIdentifiers.AlternateIdentifier.Selector<
                    TRoot, DataCiteMetadata.AlternateIdentifiers.Selector<TRoot, TParent>>(
                    this._root, this, "alternateIdentifier")
            : this.alternateIdentifier);
      }
    }
  }

  public static class Builder<_B> implements Buildable {

    protected final _B _parentBuilder;
    protected final DataCiteMetadata _storedValue;
    private DataCiteMetadata.Identifier.Builder<DataCiteMetadata.Builder<_B>> identifier;
    private DataCiteMetadata.Creators.Builder<DataCiteMetadata.Builder<_B>> creators;
    private DataCiteMetadata.Titles.Builder<DataCiteMetadata.Builder<_B>> titles;
    private DataCiteMetadata.Publisher.Builder<DataCiteMetadata.Builder<_B>> publisher;
    private String publicationYear;
    private DataCiteMetadata.ResourceType.Builder<DataCiteMetadata.Builder<_B>> resourceType;
    private DataCiteMetadata.Subjects.Builder<DataCiteMetadata.Builder<_B>> subjects;
    private DataCiteMetadata.Contributors.Builder<DataCiteMetadata.Builder<_B>> contributors;
    private DataCiteMetadata.Dates.Builder<DataCiteMetadata.Builder<_B>> dates;
    private String language;
    private DataCiteMetadata.AlternateIdentifiers.Builder<DataCiteMetadata.Builder<_B>>
        alternateIdentifiers;
    private DataCiteMetadata.RelatedIdentifiers.Builder<DataCiteMetadata.Builder<_B>>
        relatedIdentifiers;
    private DataCiteMetadata.Sizes.Builder<DataCiteMetadata.Builder<_B>> sizes;
    private DataCiteMetadata.Formats.Builder<DataCiteMetadata.Builder<_B>> formats;
    private String version;
    private DataCiteMetadata.RightsList.Builder<DataCiteMetadata.Builder<_B>> rightsList;
    private DataCiteMetadata.Descriptions.Builder<DataCiteMetadata.Builder<_B>> descriptions;
    private DataCiteMetadata.GeoLocations.Builder<DataCiteMetadata.Builder<_B>> geoLocations;
    private DataCiteMetadata.FundingReferences.Builder<DataCiteMetadata.Builder<_B>>
        fundingReferences;

    public Builder(final _B _parentBuilder, final DataCiteMetadata _other, final boolean _copy) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          this.identifier =
              ((_other.identifier == null) ? null : _other.identifier.newCopyBuilder(this));
          this.creators = ((_other.creators == null) ? null : _other.creators.newCopyBuilder(this));
          this.titles = ((_other.titles == null) ? null : _other.titles.newCopyBuilder(this));
          this.publisher =
              ((_other.publisher == null) ? null : _other.publisher.newCopyBuilder(this));
          this.publicationYear = _other.publicationYear;
          this.resourceType =
              ((_other.resourceType == null) ? null : _other.resourceType.newCopyBuilder(this));
          this.subjects = ((_other.subjects == null) ? null : _other.subjects.newCopyBuilder(this));
          this.contributors =
              ((_other.contributors == null) ? null : _other.contributors.newCopyBuilder(this));
          this.dates = ((_other.dates == null) ? null : _other.dates.newCopyBuilder(this));
          this.language = _other.language;
          this.alternateIdentifiers =
              ((_other.alternateIdentifiers == null)
                  ? null
                  : _other.alternateIdentifiers.newCopyBuilder(this));
          this.relatedIdentifiers =
              ((_other.relatedIdentifiers == null)
                  ? null
                  : _other.relatedIdentifiers.newCopyBuilder(this));
          this.sizes = ((_other.sizes == null) ? null : _other.sizes.newCopyBuilder(this));
          this.formats = ((_other.formats == null) ? null : _other.formats.newCopyBuilder(this));
          this.version = _other.version;
          this.rightsList =
              ((_other.rightsList == null) ? null : _other.rightsList.newCopyBuilder(this));
          this.descriptions =
              ((_other.descriptions == null) ? null : _other.descriptions.newCopyBuilder(this));
          this.geoLocations =
              ((_other.geoLocations == null) ? null : _other.geoLocations.newCopyBuilder(this));
          this.fundingReferences =
              ((_other.fundingReferences == null)
                  ? null
                  : _other.fundingReferences.newCopyBuilder(this));
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public Builder(
        final _B _parentBuilder,
        final DataCiteMetadata _other,
        final boolean _copy,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      this._parentBuilder = _parentBuilder;
      if (_other != null) {
        if (_copy) {
          _storedValue = null;
          final PropertyTree identifierPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("identifier"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (identifierPropertyTree != null)
              : ((identifierPropertyTree == null) || (!identifierPropertyTree.isLeaf())))) {
            this.identifier =
                ((_other.identifier == null)
                    ? null
                    : _other.identifier.newCopyBuilder(
                        this, identifierPropertyTree, _propertyTreeUse));
          }
          final PropertyTree creatorsPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("creators"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (creatorsPropertyTree != null)
              : ((creatorsPropertyTree == null) || (!creatorsPropertyTree.isLeaf())))) {
            this.creators =
                ((_other.creators == null)
                    ? null
                    : _other.creators.newCopyBuilder(this, creatorsPropertyTree, _propertyTreeUse));
          }
          final PropertyTree titlesPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("titles"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (titlesPropertyTree != null)
              : ((titlesPropertyTree == null) || (!titlesPropertyTree.isLeaf())))) {
            this.titles =
                ((_other.titles == null)
                    ? null
                    : _other.titles.newCopyBuilder(this, titlesPropertyTree, _propertyTreeUse));
          }
          final PropertyTree publisherPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("publisher"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (publisherPropertyTree != null)
              : ((publisherPropertyTree == null) || (!publisherPropertyTree.isLeaf())))) {
            this.publisher =
                ((_other.publisher == null)
                    ? null
                    : _other.publisher.newCopyBuilder(
                        this, publisherPropertyTree, _propertyTreeUse));
          }
          final PropertyTree publicationYearPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("publicationYear"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (publicationYearPropertyTree != null)
              : ((publicationYearPropertyTree == null)
                  || (!publicationYearPropertyTree.isLeaf())))) {
            this.publicationYear = _other.publicationYear;
          }
          final PropertyTree resourceTypePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("resourceType"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (resourceTypePropertyTree != null)
              : ((resourceTypePropertyTree == null) || (!resourceTypePropertyTree.isLeaf())))) {
            this.resourceType =
                ((_other.resourceType == null)
                    ? null
                    : _other.resourceType.newCopyBuilder(
                        this, resourceTypePropertyTree, _propertyTreeUse));
          }
          final PropertyTree subjectsPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("subjects"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (subjectsPropertyTree != null)
              : ((subjectsPropertyTree == null) || (!subjectsPropertyTree.isLeaf())))) {
            this.subjects =
                ((_other.subjects == null)
                    ? null
                    : _other.subjects.newCopyBuilder(this, subjectsPropertyTree, _propertyTreeUse));
          }
          final PropertyTree contributorsPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("contributors"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (contributorsPropertyTree != null)
              : ((contributorsPropertyTree == null) || (!contributorsPropertyTree.isLeaf())))) {
            this.contributors =
                ((_other.contributors == null)
                    ? null
                    : _other.contributors.newCopyBuilder(
                        this, contributorsPropertyTree, _propertyTreeUse));
          }
          final PropertyTree datesPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("dates"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (datesPropertyTree != null)
              : ((datesPropertyTree == null) || (!datesPropertyTree.isLeaf())))) {
            this.dates =
                ((_other.dates == null)
                    ? null
                    : _other.dates.newCopyBuilder(this, datesPropertyTree, _propertyTreeUse));
          }
          final PropertyTree languagePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("language"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (languagePropertyTree != null)
              : ((languagePropertyTree == null) || (!languagePropertyTree.isLeaf())))) {
            this.language = _other.language;
          }
          final PropertyTree alternateIdentifiersPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("alternateIdentifiers"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (alternateIdentifiersPropertyTree != null)
              : ((alternateIdentifiersPropertyTree == null)
                  || (!alternateIdentifiersPropertyTree.isLeaf())))) {
            this.alternateIdentifiers =
                ((_other.alternateIdentifiers == null)
                    ? null
                    : _other.alternateIdentifiers.newCopyBuilder(
                        this, alternateIdentifiersPropertyTree, _propertyTreeUse));
          }
          final PropertyTree relatedIdentifiersPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("relatedIdentifiers"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (relatedIdentifiersPropertyTree != null)
              : ((relatedIdentifiersPropertyTree == null)
                  || (!relatedIdentifiersPropertyTree.isLeaf())))) {
            this.relatedIdentifiers =
                ((_other.relatedIdentifiers == null)
                    ? null
                    : _other.relatedIdentifiers.newCopyBuilder(
                        this, relatedIdentifiersPropertyTree, _propertyTreeUse));
          }
          final PropertyTree sizesPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("sizes"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (sizesPropertyTree != null)
              : ((sizesPropertyTree == null) || (!sizesPropertyTree.isLeaf())))) {
            this.sizes =
                ((_other.sizes == null)
                    ? null
                    : _other.sizes.newCopyBuilder(this, sizesPropertyTree, _propertyTreeUse));
          }
          final PropertyTree formatsPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("formats"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (formatsPropertyTree != null)
              : ((formatsPropertyTree == null) || (!formatsPropertyTree.isLeaf())))) {
            this.formats =
                ((_other.formats == null)
                    ? null
                    : _other.formats.newCopyBuilder(this, formatsPropertyTree, _propertyTreeUse));
          }
          final PropertyTree versionPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("version"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (versionPropertyTree != null)
              : ((versionPropertyTree == null) || (!versionPropertyTree.isLeaf())))) {
            this.version = _other.version;
          }
          final PropertyTree rightsListPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("rightsList"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (rightsListPropertyTree != null)
              : ((rightsListPropertyTree == null) || (!rightsListPropertyTree.isLeaf())))) {
            this.rightsList =
                ((_other.rightsList == null)
                    ? null
                    : _other.rightsList.newCopyBuilder(
                        this, rightsListPropertyTree, _propertyTreeUse));
          }
          final PropertyTree descriptionsPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("descriptions"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (descriptionsPropertyTree != null)
              : ((descriptionsPropertyTree == null) || (!descriptionsPropertyTree.isLeaf())))) {
            this.descriptions =
                ((_other.descriptions == null)
                    ? null
                    : _other.descriptions.newCopyBuilder(
                        this, descriptionsPropertyTree, _propertyTreeUse));
          }
          final PropertyTree geoLocationsPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("geoLocations"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (geoLocationsPropertyTree != null)
              : ((geoLocationsPropertyTree == null) || (!geoLocationsPropertyTree.isLeaf())))) {
            this.geoLocations =
                ((_other.geoLocations == null)
                    ? null
                    : _other.geoLocations.newCopyBuilder(
                        this, geoLocationsPropertyTree, _propertyTreeUse));
          }
          final PropertyTree fundingReferencesPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("fundingReferences"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (fundingReferencesPropertyTree != null)
              : ((fundingReferencesPropertyTree == null)
                  || (!fundingReferencesPropertyTree.isLeaf())))) {
            this.fundingReferences =
                ((_other.fundingReferences == null)
                    ? null
                    : _other.fundingReferences.newCopyBuilder(
                        this, fundingReferencesPropertyTree, _propertyTreeUse));
          }
        } else {
          _storedValue = _other;
        }
      } else {
        _storedValue = null;
      }
    }

    public _B end() {
      return this._parentBuilder;
    }

    protected <_P extends DataCiteMetadata> _P init(final _P _product) {
      _product.identifier = ((this.identifier == null) ? null : this.identifier.build());
      _product.creators = ((this.creators == null) ? null : this.creators.build());
      _product.titles = ((this.titles == null) ? null : this.titles.build());
      _product.publisher = ((this.publisher == null) ? null : this.publisher.build());
      _product.publicationYear = this.publicationYear;
      _product.resourceType = ((this.resourceType == null) ? null : this.resourceType.build());
      _product.subjects = ((this.subjects == null) ? null : this.subjects.build());
      _product.contributors = ((this.contributors == null) ? null : this.contributors.build());
      _product.dates = ((this.dates == null) ? null : this.dates.build());
      _product.language = this.language;
      _product.alternateIdentifiers =
          ((this.alternateIdentifiers == null) ? null : this.alternateIdentifiers.build());
      _product.relatedIdentifiers =
          ((this.relatedIdentifiers == null) ? null : this.relatedIdentifiers.build());
      _product.sizes = ((this.sizes == null) ? null : this.sizes.build());
      _product.formats = ((this.formats == null) ? null : this.formats.build());
      _product.version = this.version;
      _product.rightsList = ((this.rightsList == null) ? null : this.rightsList.build());
      _product.descriptions = ((this.descriptions == null) ? null : this.descriptions.build());
      _product.geoLocations = ((this.geoLocations == null) ? null : this.geoLocations.build());
      _product.fundingReferences =
          ((this.fundingReferences == null) ? null : this.fundingReferences.build());
      return _product;
    }

    /**
     * Sets the new value of "identifier" (any previous value will be replaced)
     *
     * @param identifier New value of the "identifier" property.
     */
    public DataCiteMetadata.Builder<_B> withIdentifier(
        final DataCiteMetadata.Identifier identifier) {
      this.identifier =
          ((identifier == null)
              ? null
              : new DataCiteMetadata.Identifier.Builder<DataCiteMetadata.Builder<_B>>(
                  this, identifier, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "identifier"
     * property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.Identifier.Builder#end()} to return to the
     * current builder.
     *
     * @return A new builder to build the value of the "identifier" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Identifier.Builder#end()} to return to
     *     the current builder.
     */
    public DataCiteMetadata.Identifier.Builder<? extends DataCiteMetadata.Builder<_B>>
        withIdentifier() {
      if (this.identifier != null) {
        return this.identifier;
      }
      return this.identifier =
          new DataCiteMetadata.Identifier.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "creators" (any previous value will be replaced)
     *
     * @param creators New value of the "creators" property.
     */
    public DataCiteMetadata.Builder<_B> withCreators(final DataCiteMetadata.Creators creators) {
      this.creators =
          ((creators == null)
              ? null
              : new DataCiteMetadata.Creators.Builder<DataCiteMetadata.Builder<_B>>(
                  this, creators, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "creators" property.
     * Use {@link org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Builder#end()} to return
     * to the current builder.
     *
     * @return A new builder to build the value of the "creators" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Builder#end()} to return to the
     *     current builder.
     */
    public DataCiteMetadata.Creators.Builder<? extends DataCiteMetadata.Builder<_B>>
        withCreators() {
      if (this.creators != null) {
        return this.creators;
      }
      return this.creators =
          new DataCiteMetadata.Creators.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "titles" (any previous value will be replaced)
     *
     * @param titles New value of the "titles" property.
     */
    public DataCiteMetadata.Builder<_B> withTitles(final DataCiteMetadata.Titles titles) {
      this.titles =
          ((titles == null)
              ? null
              : new DataCiteMetadata.Titles.Builder<DataCiteMetadata.Builder<_B>>(
                  this, titles, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "titles" property.
     * Use {@link org.gbif.doi.metadata.datacite.DataCiteMetadata.Titles.Builder#end()} to return to
     * the current builder.
     *
     * @return A new builder to build the value of the "titles" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Titles.Builder#end()} to return to the
     *     current builder.
     */
    public DataCiteMetadata.Titles.Builder<? extends DataCiteMetadata.Builder<_B>> withTitles() {
      if (this.titles != null) {
        return this.titles;
      }
      return this.titles =
          new DataCiteMetadata.Titles.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "publisher" (any previous value will be replaced)
     *
     * @param publisher New value of the "publisher" property.
     */
    public DataCiteMetadata.Builder<_B> withPublisher(final DataCiteMetadata.Publisher publisher) {
      this.publisher =
          ((publisher == null)
              ? null
              : new DataCiteMetadata.Publisher.Builder<DataCiteMetadata.Builder<_B>>(
                  this, publisher, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "publisher" property.
     * Use {@link org.gbif.doi.metadata.datacite.DataCiteMetadata.Publisher.Builder#end()} to return
     * to the current builder.
     *
     * @return A new builder to build the value of the "publisher" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Publisher.Builder#end()} to return to the
     *     current builder.
     */
    public DataCiteMetadata.Publisher.Builder<? extends DataCiteMetadata.Builder<_B>>
        withPublisher() {
      if (this.publisher != null) {
        return this.publisher;
      }
      return this.publisher =
          new DataCiteMetadata.Publisher.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "publicationYear" (any previous value will be replaced)
     *
     * @param publicationYear New value of the "publicationYear" property.
     */
    public DataCiteMetadata.Builder<_B> withPublicationYear(final String publicationYear) {
      this.publicationYear = publicationYear;
      return this;
    }

    /**
     * Sets the new value of "resourceType" (any previous value will be replaced)
     *
     * @param resourceType New value of the "resourceType" property.
     */
    public DataCiteMetadata.Builder<_B> withResourceType(
        final DataCiteMetadata.ResourceType resourceType) {
      this.resourceType =
          ((resourceType == null)
              ? null
              : new DataCiteMetadata.ResourceType.Builder<DataCiteMetadata.Builder<_B>>(
                  this, resourceType, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "resourceType"
     * property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.ResourceType.Builder#end()} to return to the
     * current builder.
     *
     * @return A new builder to build the value of the "resourceType" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.ResourceType.Builder#end()} to return to
     *     the current builder.
     */
    public DataCiteMetadata.ResourceType.Builder<? extends DataCiteMetadata.Builder<_B>>
        withResourceType() {
      if (this.resourceType != null) {
        return this.resourceType;
      }
      return this.resourceType =
          new DataCiteMetadata.ResourceType.Builder<DataCiteMetadata.Builder<_B>>(
              this, null, false);
    }

    /**
     * Sets the new value of "subjects" (any previous value will be replaced)
     *
     * @param subjects New value of the "subjects" property.
     */
    public DataCiteMetadata.Builder<_B> withSubjects(final DataCiteMetadata.Subjects subjects) {
      this.subjects =
          ((subjects == null)
              ? null
              : new DataCiteMetadata.Subjects.Builder<DataCiteMetadata.Builder<_B>>(
                  this, subjects, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "subjects" property.
     * Use {@link org.gbif.doi.metadata.datacite.DataCiteMetadata.Subjects.Builder#end()} to return
     * to the current builder.
     *
     * @return A new builder to build the value of the "subjects" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Subjects.Builder#end()} to return to the
     *     current builder.
     */
    public DataCiteMetadata.Subjects.Builder<? extends DataCiteMetadata.Builder<_B>>
        withSubjects() {
      if (this.subjects != null) {
        return this.subjects;
      }
      return this.subjects =
          new DataCiteMetadata.Subjects.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "contributors" (any previous value will be replaced)
     *
     * @param contributors New value of the "contributors" property.
     */
    public DataCiteMetadata.Builder<_B> withContributors(
        final DataCiteMetadata.Contributors contributors) {
      this.contributors =
          ((contributors == null)
              ? null
              : new DataCiteMetadata.Contributors.Builder<DataCiteMetadata.Builder<_B>>(
                  this, contributors, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "contributors"
     * property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Builder#end()} to return to the
     * current builder.
     *
     * @return A new builder to build the value of the "contributors" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Builder#end()} to return to
     *     the current builder.
     */
    public DataCiteMetadata.Contributors.Builder<? extends DataCiteMetadata.Builder<_B>>
        withContributors() {
      if (this.contributors != null) {
        return this.contributors;
      }
      return this.contributors =
          new DataCiteMetadata.Contributors.Builder<DataCiteMetadata.Builder<_B>>(
              this, null, false);
    }

    /**
     * Sets the new value of "dates" (any previous value will be replaced)
     *
     * @param dates New value of the "dates" property.
     */
    public DataCiteMetadata.Builder<_B> withDates(final DataCiteMetadata.Dates dates) {
      this.dates =
          ((dates == null)
              ? null
              : new DataCiteMetadata.Dates.Builder<DataCiteMetadata.Builder<_B>>(
                  this, dates, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "dates" property. Use
     * {@link org.gbif.doi.metadata.datacite.DataCiteMetadata.Dates.Builder#end()} to return to the
     * current builder.
     *
     * @return A new builder to build the value of the "dates" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Dates.Builder#end()} to return to the
     *     current builder.
     */
    public DataCiteMetadata.Dates.Builder<? extends DataCiteMetadata.Builder<_B>> withDates() {
      if (this.dates != null) {
        return this.dates;
      }
      return this.dates =
          new DataCiteMetadata.Dates.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "language" (any previous value will be replaced)
     *
     * @param language New value of the "language" property.
     */
    public DataCiteMetadata.Builder<_B> withLanguage(final String language) {
      this.language = language;
      return this;
    }

    /**
     * Sets the new value of "alternateIdentifiers" (any previous value will be replaced)
     *
     * @param alternateIdentifiers New value of the "alternateIdentifiers" property.
     */
    public DataCiteMetadata.Builder<_B> withAlternateIdentifiers(
        final DataCiteMetadata.AlternateIdentifiers alternateIdentifiers) {
      this.alternateIdentifiers =
          ((alternateIdentifiers == null)
              ? null
              : new DataCiteMetadata.AlternateIdentifiers.Builder<DataCiteMetadata.Builder<_B>>(
                  this, alternateIdentifiers, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the
     * "alternateIdentifiers" property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.AlternateIdentifiers.Builder#end()} to return
     * to the current builder.
     *
     * @return A new builder to build the value of the "alternateIdentifiers" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.AlternateIdentifiers.Builder#end()} to
     *     return to the current builder.
     */
    public DataCiteMetadata.AlternateIdentifiers.Builder<? extends DataCiteMetadata.Builder<_B>>
        withAlternateIdentifiers() {
      if (this.alternateIdentifiers != null) {
        return this.alternateIdentifiers;
      }
      return this.alternateIdentifiers =
          new DataCiteMetadata.AlternateIdentifiers.Builder<DataCiteMetadata.Builder<_B>>(
              this, null, false);
    }

    /**
     * Sets the new value of "relatedIdentifiers" (any previous value will be replaced)
     *
     * @param relatedIdentifiers New value of the "relatedIdentifiers" property.
     */
    public DataCiteMetadata.Builder<_B> withRelatedIdentifiers(
        final DataCiteMetadata.RelatedIdentifiers relatedIdentifiers) {
      this.relatedIdentifiers =
          ((relatedIdentifiers == null)
              ? null
              : new DataCiteMetadata.RelatedIdentifiers.Builder<DataCiteMetadata.Builder<_B>>(
                  this, relatedIdentifiers, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "relatedIdentifiers"
     * property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.RelatedIdentifiers.Builder#end()} to return
     * to the current builder.
     *
     * @return A new builder to build the value of the "relatedIdentifiers" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.RelatedIdentifiers.Builder#end()} to
     *     return to the current builder.
     */
    public DataCiteMetadata.RelatedIdentifiers.Builder<? extends DataCiteMetadata.Builder<_B>>
        withRelatedIdentifiers() {
      if (this.relatedIdentifiers != null) {
        return this.relatedIdentifiers;
      }
      return this.relatedIdentifiers =
          new DataCiteMetadata.RelatedIdentifiers.Builder<DataCiteMetadata.Builder<_B>>(
              this, null, false);
    }

    /**
     * Sets the new value of "sizes" (any previous value will be replaced)
     *
     * @param sizes New value of the "sizes" property.
     */
    public DataCiteMetadata.Builder<_B> withSizes(final DataCiteMetadata.Sizes sizes) {
      this.sizes =
          ((sizes == null)
              ? null
              : new DataCiteMetadata.Sizes.Builder<DataCiteMetadata.Builder<_B>>(
                  this, sizes, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "sizes" property. Use
     * {@link org.gbif.doi.metadata.datacite.DataCiteMetadata.Sizes.Builder#end()} to return to the
     * current builder.
     *
     * @return A new builder to build the value of the "sizes" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Sizes.Builder#end()} to return to the
     *     current builder.
     */
    public DataCiteMetadata.Sizes.Builder<? extends DataCiteMetadata.Builder<_B>> withSizes() {
      if (this.sizes != null) {
        return this.sizes;
      }
      return this.sizes =
          new DataCiteMetadata.Sizes.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "formats" (any previous value will be replaced)
     *
     * @param formats New value of the "formats" property.
     */
    public DataCiteMetadata.Builder<_B> withFormats(final DataCiteMetadata.Formats formats) {
      this.formats =
          ((formats == null)
              ? null
              : new DataCiteMetadata.Formats.Builder<DataCiteMetadata.Builder<_B>>(
                  this, formats, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "formats" property.
     * Use {@link org.gbif.doi.metadata.datacite.DataCiteMetadata.Formats.Builder#end()} to return
     * to the current builder.
     *
     * @return A new builder to build the value of the "formats" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Formats.Builder#end()} to return to the
     *     current builder.
     */
    public DataCiteMetadata.Formats.Builder<? extends DataCiteMetadata.Builder<_B>> withFormats() {
      if (this.formats != null) {
        return this.formats;
      }
      return this.formats =
          new DataCiteMetadata.Formats.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "version" (any previous value will be replaced)
     *
     * @param version New value of the "version" property.
     */
    public DataCiteMetadata.Builder<_B> withVersion(final String version) {
      this.version = version;
      return this;
    }

    /**
     * Sets the new value of "rightsList" (any previous value will be replaced)
     *
     * @param rightsList New value of the "rightsList" property.
     */
    public DataCiteMetadata.Builder<_B> withRightsList(
        final DataCiteMetadata.RightsList rightsList) {
      this.rightsList =
          ((rightsList == null)
              ? null
              : new DataCiteMetadata.RightsList.Builder<DataCiteMetadata.Builder<_B>>(
                  this, rightsList, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "rightsList"
     * property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.RightsList.Builder#end()} to return to the
     * current builder.
     *
     * @return A new builder to build the value of the "rightsList" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.RightsList.Builder#end()} to return to
     *     the current builder.
     */
    public DataCiteMetadata.RightsList.Builder<? extends DataCiteMetadata.Builder<_B>>
        withRightsList() {
      if (this.rightsList != null) {
        return this.rightsList;
      }
      return this.rightsList =
          new DataCiteMetadata.RightsList.Builder<DataCiteMetadata.Builder<_B>>(this, null, false);
    }

    /**
     * Sets the new value of "descriptions" (any previous value will be replaced)
     *
     * @param descriptions New value of the "descriptions" property.
     */
    public DataCiteMetadata.Builder<_B> withDescriptions(
        final DataCiteMetadata.Descriptions descriptions) {
      this.descriptions =
          ((descriptions == null)
              ? null
              : new DataCiteMetadata.Descriptions.Builder<DataCiteMetadata.Builder<_B>>(
                  this, descriptions, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "descriptions"
     * property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.Descriptions.Builder#end()} to return to the
     * current builder.
     *
     * @return A new builder to build the value of the "descriptions" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Descriptions.Builder#end()} to return to
     *     the current builder.
     */
    public DataCiteMetadata.Descriptions.Builder<? extends DataCiteMetadata.Builder<_B>>
        withDescriptions() {
      if (this.descriptions != null) {
        return this.descriptions;
      }
      return this.descriptions =
          new DataCiteMetadata.Descriptions.Builder<DataCiteMetadata.Builder<_B>>(
              this, null, false);
    }

    /**
     * Sets the new value of "geoLocations" (any previous value will be replaced)
     *
     * @param geoLocations New value of the "geoLocations" property.
     */
    public DataCiteMetadata.Builder<_B> withGeoLocations(
        final DataCiteMetadata.GeoLocations geoLocations) {
      this.geoLocations =
          ((geoLocations == null)
              ? null
              : new DataCiteMetadata.GeoLocations.Builder<DataCiteMetadata.Builder<_B>>(
                  this, geoLocations, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "geoLocations"
     * property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations.Builder#end()} to return to the
     * current builder.
     *
     * @return A new builder to build the value of the "geoLocations" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations.Builder#end()} to return to
     *     the current builder.
     */
    public DataCiteMetadata.GeoLocations.Builder<? extends DataCiteMetadata.Builder<_B>>
        withGeoLocations() {
      if (this.geoLocations != null) {
        return this.geoLocations;
      }
      return this.geoLocations =
          new DataCiteMetadata.GeoLocations.Builder<DataCiteMetadata.Builder<_B>>(
              this, null, false);
    }

    /**
     * Sets the new value of "fundingReferences" (any previous value will be replaced)
     *
     * @param fundingReferences New value of the "fundingReferences" property.
     */
    public DataCiteMetadata.Builder<_B> withFundingReferences(
        final DataCiteMetadata.FundingReferences fundingReferences) {
      this.fundingReferences =
          ((fundingReferences == null)
              ? null
              : new DataCiteMetadata.FundingReferences.Builder<DataCiteMetadata.Builder<_B>>(
                  this, fundingReferences, false));
      return this;
    }

    /**
     * Returns the existing builder or a new builder to build the value of the "fundingReferences"
     * property. Use {@link
     * org.gbif.doi.metadata.datacite.DataCiteMetadata.FundingReferences.Builder#end()} to return to
     * the current builder.
     *
     * @return A new builder to build the value of the "fundingReferences" property. Use {@link
     *     org.gbif.doi.metadata.datacite.DataCiteMetadata.FundingReferences.Builder#end()} to
     *     return to the current builder.
     */
    public DataCiteMetadata.FundingReferences.Builder<? extends DataCiteMetadata.Builder<_B>>
        withFundingReferences() {
      if (this.fundingReferences != null) {
        return this.fundingReferences;
      }
      return this.fundingReferences =
          new DataCiteMetadata.FundingReferences.Builder<DataCiteMetadata.Builder<_B>>(
              this, null, false);
    }

    @Override
    public DataCiteMetadata build() {
      if (_storedValue == null) {
        return this.init(new DataCiteMetadata());
      } else {
        return ((DataCiteMetadata) _storedValue);
      }
    }

    public DataCiteMetadata.Builder<_B> copyOf(final DataCiteMetadata _other) {
      _other.copyTo(this);
      return this;
    }

    public DataCiteMetadata.Builder<_B> copyOf(final DataCiteMetadata.Builder _other) {
      return copyOf(_other.build());
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="contributor" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;complexContent&gt;
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *                 &lt;sequence&gt;
   *                   &lt;element name="contributorName"&gt;
   *                     &lt;complexType&gt;
   *                       &lt;simpleContent&gt;
   *                         &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
   *                           &lt;attribute name="nameType" type="{http://datacite.org/schema/kernel-4}nameType" /&gt;
   *                           &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
   *                         &lt;/extension&gt;
   *                       &lt;/simpleContent&gt;
   *                     &lt;/complexType&gt;
   *                   &lt;/element&gt;
   *                   &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
   *                   &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
   *                   &lt;element name="nameIdentifier" type="{http://datacite.org/schema/kernel-4}nameIdentifier" maxOccurs="unbounded" minOccurs="0"/&gt;
   *                   &lt;element name="affiliation" type="{http://datacite.org/schema/kernel-4}affiliation" maxOccurs="unbounded" minOccurs="0"/&gt;
   *                 &lt;/sequence&gt;
   *                 &lt;attribute name="contributorType" use="required" type="{http://datacite.org/schema/kernel-4}contributorType" /&gt;
   *               &lt;/restriction&gt;
   *             &lt;/complexContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"contributor"})
  public static class Contributors {

    protected List<DataCiteMetadata.Contributors.Contributor> contributor;

    /**
     * Gets the value of the contributor property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the contributor property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getContributor().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.Contributors.Contributor }
     */
    public List<DataCiteMetadata.Contributors.Contributor> getContributor() {
      if (contributor == null) {
        contributor = new ArrayList<DataCiteMetadata.Contributors.Contributor>();
      }
      return this.contributor;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Contributors.Builder<_B> _other) {
      if (this.contributor == null) {
        _other.contributor = null;
      } else {
        _other.contributor =
            new ArrayList<
                DataCiteMetadata.Contributors.Contributor.Builder<
                    DataCiteMetadata.Contributors.Builder<_B>>>();
        for (DataCiteMetadata.Contributors.Contributor _item : this.contributor) {
          _other.contributor.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.Contributors.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Contributors.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Contributors.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Contributors.Builder<Void> builder() {
      return new DataCiteMetadata.Contributors.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Contributors.Builder<_B> copyOf(
        final DataCiteMetadata.Contributors _other) {
      final DataCiteMetadata.Contributors.Builder<_B> _newBuilder =
          new DataCiteMetadata.Contributors.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Contributors.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree contributorPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("contributor"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (contributorPropertyTree != null)
          : ((contributorPropertyTree == null) || (!contributorPropertyTree.isLeaf())))) {
        if (this.contributor == null) {
          _other.contributor = null;
        } else {
          _other.contributor =
              new ArrayList<
                  DataCiteMetadata.Contributors.Contributor.Builder<
                      DataCiteMetadata.Contributors.Builder<_B>>>();
          for (DataCiteMetadata.Contributors.Contributor _item : this.contributor) {
            _other.contributor.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(_other, contributorPropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.Contributors.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Contributors.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Contributors.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Contributors.Builder<_B> copyOf(
        final DataCiteMetadata.Contributors _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Contributors.Builder<_B> _newBuilder =
          new DataCiteMetadata.Contributors.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Contributors.Builder<Void> copyExcept(
        final DataCiteMetadata.Contributors _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Contributors.Builder<Void> copyOnly(
        final DataCiteMetadata.Contributors _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Contributors.class.getSimpleName() + "[", "]")
          .add("contributor=" + contributor)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Contributors that = (Contributors) o;
      return Objects.equals(contributor, that.contributor);
    }

    @Override
    public int hashCode() {
      return Objects.hash(contributor);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Contributors _storedValue;
      private List<
              DataCiteMetadata.Contributors.Contributor.Builder<
                  DataCiteMetadata.Contributors.Builder<_B>>>
          contributor;

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Contributors _other,
          final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.contributor == null) {
              this.contributor = null;
            } else {
              this.contributor =
                  new ArrayList<
                      DataCiteMetadata.Contributors.Contributor.Builder<
                          DataCiteMetadata.Contributors.Builder<_B>>>();
              for (DataCiteMetadata.Contributors.Contributor _item : _other.contributor) {
                this.contributor.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Contributors _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree contributorPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("contributor"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (contributorPropertyTree != null)
                : ((contributorPropertyTree == null) || (!contributorPropertyTree.isLeaf())))) {
              if (_other.contributor == null) {
                this.contributor = null;
              } else {
                this.contributor =
                    new ArrayList<
                        DataCiteMetadata.Contributors.Contributor.Builder<
                            DataCiteMetadata.Contributors.Builder<_B>>>();
                for (DataCiteMetadata.Contributors.Contributor _item : _other.contributor) {
                  this.contributor.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(this, contributorPropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Contributors> _P init(final _P _product) {
        if (this.contributor != null) {
          final List<DataCiteMetadata.Contributors.Contributor> contributor =
              new ArrayList<DataCiteMetadata.Contributors.Contributor>(this.contributor.size());
          for (DataCiteMetadata.Contributors.Contributor.Builder<
                  DataCiteMetadata.Contributors.Builder<_B>>
              _item : this.contributor) {
            contributor.add(_item.build());
          }
          _product.contributor = contributor;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "contributor"
       *
       * @param contributor Items to add to the value of the "contributor" property
       */
      public DataCiteMetadata.Contributors.Builder<_B> addContributor(
          final Iterable<? extends DataCiteMetadata.Contributors.Contributor> contributor) {
        if (contributor != null) {
          if (this.contributor == null) {
            this.contributor =
                new ArrayList<
                    DataCiteMetadata.Contributors.Contributor.Builder<
                        DataCiteMetadata.Contributors.Builder<_B>>>();
          }
          for (DataCiteMetadata.Contributors.Contributor _item : contributor) {
            this.contributor.add(
                new DataCiteMetadata.Contributors.Contributor.Builder<
                    DataCiteMetadata.Contributors.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "contributor" (any previous value will be replaced)
       *
       * @param contributor New value of the "contributor" property.
       */
      public DataCiteMetadata.Contributors.Builder<_B> withContributor(
          final Iterable<? extends DataCiteMetadata.Contributors.Contributor> contributor) {
        if (this.contributor != null) {
          this.contributor.clear();
        }
        return addContributor(contributor);
      }

      /**
       * Adds the given items to the value of "contributor"
       *
       * @param contributor Items to add to the value of the "contributor" property
       */
      public DataCiteMetadata.Contributors.Builder<_B> addContributor(
          DataCiteMetadata.Contributors.Contributor... contributor) {
        addContributor(Arrays.asList(contributor));
        return this;
      }

      /**
       * Sets the new value of "contributor" (any previous value will be replaced)
       *
       * @param contributor New value of the "contributor" property.
       */
      public DataCiteMetadata.Contributors.Builder<_B> withContributor(
          DataCiteMetadata.Contributors.Contributor... contributor) {
        withContributor(Arrays.asList(contributor));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "Contributor" property. Use
       * {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Contributor.Builder#end()} to
       * return to the current builder.
       *
       * @return a new builder to build an additional value of the "Contributor" property. Use
       *     {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Contributor.Builder#end()}
       *     to return to the current builder.
       */
      public DataCiteMetadata.Contributors.Contributor.Builder<
              ? extends DataCiteMetadata.Contributors.Builder<_B>>
          addContributor() {
        if (this.contributor == null) {
          this.contributor =
              new ArrayList<
                  DataCiteMetadata.Contributors.Contributor.Builder<
                      DataCiteMetadata.Contributors.Builder<_B>>>();
        }
        final DataCiteMetadata.Contributors.Contributor.Builder<
                DataCiteMetadata.Contributors.Builder<_B>>
            contributor_Builder =
                new DataCiteMetadata.Contributors.Contributor.Builder<
                    DataCiteMetadata.Contributors.Builder<_B>>(this, null, false);
        this.contributor.add(contributor_Builder);
        return contributor_Builder;
      }

      @Override
      public DataCiteMetadata.Contributors build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Contributors());
        } else {
          return ((DataCiteMetadata.Contributors) _storedValue);
        }
      }

      public DataCiteMetadata.Contributors.Builder<_B> copyOf(
          final DataCiteMetadata.Contributors _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Contributors.Builder<_B> copyOf(
          final DataCiteMetadata.Contributors.Builder _other) {
        return copyOf(_other.build());
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="contributorName"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
     *                 &lt;attribute name="nameType" type="{http://datacite.org/schema/kernel-4}nameType" /&gt;
     *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
     *         &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
     *         &lt;element name="nameIdentifier" type="{http://datacite.org/schema/kernel-4}nameIdentifier" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="affiliation" type="{http://datacite.org/schema/kernel-4}affiliation" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="contributorType" use="required" type="{http://datacite.org/schema/kernel-4}contributorType" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"contributorName", "givenName", "familyName", "nameIdentifier", "affiliation"})
    public static class Contributor {

      @XmlElement(required = true)
      protected DataCiteMetadata.Contributors.Contributor.ContributorName contributorName;

      protected Object givenName;
      protected Object familyName;
      protected List<NameIdentifier> nameIdentifier;
      protected List<Affiliation> affiliation;

      @XmlAttribute(name = "contributorType", required = true)
      protected ContributorType contributorType;

      /**
       * Gets the value of the contributorName property.
       *
       * @return possible object is {@link DataCiteMetadata.Contributors.Contributor.ContributorName
       *     }
       */
      public DataCiteMetadata.Contributors.Contributor.ContributorName getContributorName() {
        return contributorName;
      }

      /**
       * Sets the value of the contributorName property.
       *
       * @param value allowed object is {@link
       *     DataCiteMetadata.Contributors.Contributor.ContributorName }
       */
      public void setContributorName(
          DataCiteMetadata.Contributors.Contributor.ContributorName value) {
        this.contributorName = value;
      }

      /**
       * Gets the value of the givenName property.
       *
       * @return possible object is {@link Object }
       */
      public Object getGivenName() {
        return givenName;
      }

      /**
       * Sets the value of the givenName property.
       *
       * @param value allowed object is {@link Object }
       */
      public void setGivenName(Object value) {
        this.givenName = value;
      }

      /**
       * Gets the value of the familyName property.
       *
       * @return possible object is {@link Object }
       */
      public Object getFamilyName() {
        return familyName;
      }

      /**
       * Sets the value of the familyName property.
       *
       * @param value allowed object is {@link Object }
       */
      public void setFamilyName(Object value) {
        this.familyName = value;
      }

      /**
       * Gets the value of the nameIdentifier property.
       *
       * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
       * modification you make to the returned list will be present inside the JAXB object. This is
       * why there is not a <CODE>set</CODE> method for the nameIdentifier property.
       *
       * <p>For example, to add a new item, do as follows:
       *
       * <pre>
       *    getNameIdentifier().add(newItem);
       * </pre>
       *
       * <p>Objects of the following type(s) are allowed in the list {@link NameIdentifier }
       */
      public List<NameIdentifier> getNameIdentifier() {
        if (nameIdentifier == null) {
          nameIdentifier = new ArrayList<NameIdentifier>();
        }
        return this.nameIdentifier;
      }

      /**
       * Gets the value of the affiliation property.
       *
       * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
       * modification you make to the returned list will be present inside the JAXB object. This is
       * why there is not a <CODE>set</CODE> method for the affiliation property.
       *
       * <p>For example, to add a new item, do as follows:
       *
       * <pre>
       *    getAffiliation().add(newItem);
       * </pre>
       *
       * <p>Objects of the following type(s) are allowed in the list {@link Affiliation }
       */
      public List<Affiliation> getAffiliation() {
        if (affiliation == null) {
          affiliation = new ArrayList<Affiliation>();
        }
        return this.affiliation;
      }

      /**
       * Gets the value of the contributorType property.
       *
       * @return possible object is {@link ContributorType }
       */
      public ContributorType getContributorType() {
        return contributorType;
      }

      /**
       * Sets the value of the contributorType property.
       *
       * @param value allowed object is {@link ContributorType }
       */
      public void setContributorType(ContributorType value) {
        this.contributorType = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(final DataCiteMetadata.Contributors.Contributor.Builder<_B> _other) {
        _other.contributorName =
            ((this.contributorName == null) ? null : this.contributorName.newCopyBuilder(_other));
        _other.givenName = this.givenName;
        _other.familyName = this.familyName;
        if (this.nameIdentifier == null) {
          _other.nameIdentifier = null;
        } else {
          _other.nameIdentifier =
              new ArrayList<
                  NameIdentifier.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
          for (NameIdentifier _item : this.nameIdentifier) {
            _other.nameIdentifier.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
          }
        }
        if (this.affiliation == null) {
          _other.affiliation = null;
        } else {
          _other.affiliation =
              new ArrayList<
                  Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
          for (Affiliation _item : this.affiliation) {
            _other.affiliation.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
          }
        }
        _other.contributorType = this.contributorType;
      }

      public <_B> DataCiteMetadata.Contributors.Contributor.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.Contributors.Contributor.Builder<_B>(
            _parentBuilder, this, true);
      }

      public DataCiteMetadata.Contributors.Contributor.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.Contributors.Contributor.Builder<Void> builder() {
        return new DataCiteMetadata.Contributors.Contributor.Builder<Void>(null, null, false);
      }

      public static <_B> DataCiteMetadata.Contributors.Contributor.Builder<_B> copyOf(
          final DataCiteMetadata.Contributors.Contributor _other) {
        final DataCiteMetadata.Contributors.Contributor.Builder<_B> _newBuilder =
            new DataCiteMetadata.Contributors.Contributor.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.Contributors.Contributor.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree contributorNamePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("contributorName"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (contributorNamePropertyTree != null)
            : ((contributorNamePropertyTree == null) || (!contributorNamePropertyTree.isLeaf())))) {
          _other.contributorName =
              ((this.contributorName == null)
                  ? null
                  : this.contributorName.newCopyBuilder(
                      _other, contributorNamePropertyTree, _propertyTreeUse));
        }
        final PropertyTree givenNamePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("givenName"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (givenNamePropertyTree != null)
            : ((givenNamePropertyTree == null) || (!givenNamePropertyTree.isLeaf())))) {
          _other.givenName = this.givenName;
        }
        final PropertyTree familyNamePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("familyName"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (familyNamePropertyTree != null)
            : ((familyNamePropertyTree == null) || (!familyNamePropertyTree.isLeaf())))) {
          _other.familyName = this.familyName;
        }
        final PropertyTree nameIdentifierPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("nameIdentifier"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (nameIdentifierPropertyTree != null)
            : ((nameIdentifierPropertyTree == null) || (!nameIdentifierPropertyTree.isLeaf())))) {
          if (this.nameIdentifier == null) {
            _other.nameIdentifier = null;
          } else {
            _other.nameIdentifier =
                new ArrayList<
                    NameIdentifier.Builder<
                        DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
            for (NameIdentifier _item : this.nameIdentifier) {
              _other.nameIdentifier.add(
                  ((_item == null)
                      ? null
                      : _item.newCopyBuilder(
                          _other, nameIdentifierPropertyTree, _propertyTreeUse)));
            }
          }
        }
        final PropertyTree affiliationPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("affiliation"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (affiliationPropertyTree != null)
            : ((affiliationPropertyTree == null) || (!affiliationPropertyTree.isLeaf())))) {
          if (this.affiliation == null) {
            _other.affiliation = null;
          } else {
            _other.affiliation =
                new ArrayList<
                    Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
            for (Affiliation _item : this.affiliation) {
              _other.affiliation.add(
                  ((_item == null)
                      ? null
                      : _item.newCopyBuilder(_other, affiliationPropertyTree, _propertyTreeUse)));
            }
          }
        }
        final PropertyTree contributorTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("contributorType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (contributorTypePropertyTree != null)
            : ((contributorTypePropertyTree == null) || (!contributorTypePropertyTree.isLeaf())))) {
          _other.contributorType = this.contributorType;
        }
      }

      public <_B> DataCiteMetadata.Contributors.Contributor.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.Contributors.Contributor.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.Contributors.Contributor.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.Contributors.Contributor.Builder<_B> copyOf(
          final DataCiteMetadata.Contributors.Contributor _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.Contributors.Contributor.Builder<_B> _newBuilder =
            new DataCiteMetadata.Contributors.Contributor.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.Contributors.Contributor.Builder<Void> copyExcept(
          final DataCiteMetadata.Contributors.Contributor _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.Contributors.Contributor.Builder<Void> copyOnly(
          final DataCiteMetadata.Contributors.Contributor _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", Contributor.class.getSimpleName() + "[", "]")
            .add("contributorName=" + contributorName)
            .add("givenName=" + givenName)
            .add("familyName=" + familyName)
            .add("nameIdentifier=" + nameIdentifier)
            .add("affiliation=" + affiliation)
            .add("contributorType=" + contributorType)
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contributor that = (Contributor) o;

        return Objects.equals(contributorName, that.contributorName)
            && Objects.equals(givenName, that.givenName)
            && Objects.equals(familyName, that.familyName)
            && Objects.equals(nameIdentifier, that.nameIdentifier)
            && Objects.equals(affiliation, that.affiliation)
            && contributorType == that.contributorType;
      }

      @Override
      public int hashCode() {
        return Objects.hash(
            contributorName, givenName, familyName, nameIdentifier, affiliation, contributorType);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.Contributors.Contributor _storedValue;
        private DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<
                DataCiteMetadata.Contributors.Contributor.Builder<_B>>
            contributorName;
        private Object givenName;
        private Object familyName;
        private List<NameIdentifier.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>>
            nameIdentifier;
        private List<Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>>
            affiliation;
        private ContributorType contributorType;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Contributors.Contributor _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.contributorName =
                  ((_other.contributorName == null)
                      ? null
                      : _other.contributorName.newCopyBuilder(this));
              this.givenName = _other.givenName;
              this.familyName = _other.familyName;
              if (_other.nameIdentifier == null) {
                this.nameIdentifier = null;
              } else {
                this.nameIdentifier =
                    new ArrayList<
                        NameIdentifier.Builder<
                            DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
                for (NameIdentifier _item : _other.nameIdentifier) {
                  this.nameIdentifier.add(((_item == null) ? null : _item.newCopyBuilder(this)));
                }
              }
              if (_other.affiliation == null) {
                this.affiliation = null;
              } else {
                this.affiliation =
                    new ArrayList<
                        Affiliation.Builder<
                            DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
                for (Affiliation _item : _other.affiliation) {
                  this.affiliation.add(((_item == null) ? null : _item.newCopyBuilder(this)));
                }
              }
              this.contributorType = _other.contributorType;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Contributors.Contributor _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree contributorNamePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("contributorName"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (contributorNamePropertyTree != null)
                  : ((contributorNamePropertyTree == null)
                      || (!contributorNamePropertyTree.isLeaf())))) {
                this.contributorName =
                    ((_other.contributorName == null)
                        ? null
                        : _other.contributorName.newCopyBuilder(
                            this, contributorNamePropertyTree, _propertyTreeUse));
              }
              final PropertyTree givenNamePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("givenName"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (givenNamePropertyTree != null)
                  : ((givenNamePropertyTree == null) || (!givenNamePropertyTree.isLeaf())))) {
                this.givenName = _other.givenName;
              }
              final PropertyTree familyNamePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("familyName"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (familyNamePropertyTree != null)
                  : ((familyNamePropertyTree == null) || (!familyNamePropertyTree.isLeaf())))) {
                this.familyName = _other.familyName;
              }
              final PropertyTree nameIdentifierPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("nameIdentifier"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (nameIdentifierPropertyTree != null)
                  : ((nameIdentifierPropertyTree == null)
                      || (!nameIdentifierPropertyTree.isLeaf())))) {
                if (_other.nameIdentifier == null) {
                  this.nameIdentifier = null;
                } else {
                  this.nameIdentifier =
                      new ArrayList<
                          NameIdentifier.Builder<
                              DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
                  for (NameIdentifier _item : _other.nameIdentifier) {
                    this.nameIdentifier.add(
                        ((_item == null)
                            ? null
                            : _item.newCopyBuilder(
                                this, nameIdentifierPropertyTree, _propertyTreeUse)));
                  }
                }
              }
              final PropertyTree affiliationPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("affiliation"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (affiliationPropertyTree != null)
                  : ((affiliationPropertyTree == null) || (!affiliationPropertyTree.isLeaf())))) {
                if (_other.affiliation == null) {
                  this.affiliation = null;
                } else {
                  this.affiliation =
                      new ArrayList<
                          Affiliation.Builder<
                              DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
                  for (Affiliation _item : _other.affiliation) {
                    this.affiliation.add(
                        ((_item == null)
                            ? null
                            : _item.newCopyBuilder(
                                this, affiliationPropertyTree, _propertyTreeUse)));
                  }
                }
              }
              final PropertyTree contributorTypePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("contributorType"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (contributorTypePropertyTree != null)
                  : ((contributorTypePropertyTree == null)
                      || (!contributorTypePropertyTree.isLeaf())))) {
                this.contributorType = _other.contributorType;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.Contributors.Contributor> _P init(
            final _P _product) {
          _product.contributorName =
              ((this.contributorName == null) ? null : this.contributorName.build());
          _product.givenName = this.givenName;
          _product.familyName = this.familyName;
          if (this.nameIdentifier != null) {
            final List<NameIdentifier> nameIdentifier =
                new ArrayList<NameIdentifier>(this.nameIdentifier.size());
            for (NameIdentifier.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>
                _item : this.nameIdentifier) {
              nameIdentifier.add(_item.build());
            }
            _product.nameIdentifier = nameIdentifier;
          }
          if (this.affiliation != null) {
            final List<Affiliation> affiliation =
                new ArrayList<Affiliation>(this.affiliation.size());
            for (Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>> _item :
                this.affiliation) {
              affiliation.add(_item.build());
            }
            _product.affiliation = affiliation;
          }
          _product.contributorType = this.contributorType;
          return _product;
        }

        /**
         * Sets the new value of "contributorName" (any previous value will be replaced)
         *
         * @param contributorName New value of the "contributorName" property.
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> withContributorName(
            final DataCiteMetadata.Contributors.Contributor.ContributorName contributorName) {
          this.contributorName =
              ((contributorName == null)
                  ? null
                  : new DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<
                      DataCiteMetadata.Contributors.Contributor.Builder<_B>>(
                      this, contributorName, false));
          return this;
        }

        /**
         * Returns the existing builder or a new builder to build the value of the "contributorName"
         * property. Use {@link
         * org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Contributor.ContributorName.Builder#end()}
         * to return to the current builder.
         *
         * @return A new builder to build the value of the "contributorName" property. Use {@link
         *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Contributors.Contributor.ContributorName.Builder#end()}
         *     to return to the current builder.
         */
        public DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<
                ? extends DataCiteMetadata.Contributors.Contributor.Builder<_B>>
            withContributorName() {
          if (this.contributorName != null) {
            return this.contributorName;
          }
          return this.contributorName =
              new DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<
                  DataCiteMetadata.Contributors.Contributor.Builder<_B>>(this, null, false);
        }

        /**
         * Sets the new value of "givenName" (any previous value will be replaced)
         *
         * @param givenName New value of the "givenName" property.
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> withGivenName(
            final Object givenName) {
          this.givenName = givenName;
          return this;
        }

        /**
         * Sets the new value of "familyName" (any previous value will be replaced)
         *
         * @param familyName New value of the "familyName" property.
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> withFamilyName(
            final Object familyName) {
          this.familyName = familyName;
          return this;
        }

        /**
         * Adds the given items to the value of "nameIdentifier"
         *
         * @param nameIdentifier Items to add to the value of the "nameIdentifier" property
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> addNameIdentifier(
            final Iterable<? extends NameIdentifier> nameIdentifier) {
          if (nameIdentifier != null) {
            if (this.nameIdentifier == null) {
              this.nameIdentifier =
                  new ArrayList<
                      NameIdentifier.Builder<
                          DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
            }
            for (NameIdentifier _item : nameIdentifier) {
              this.nameIdentifier.add(
                  new NameIdentifier.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>(
                      this, _item, false));
            }
          }
          return this;
        }

        /**
         * Sets the new value of "nameIdentifier" (any previous value will be replaced)
         *
         * @param nameIdentifier New value of the "nameIdentifier" property.
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> withNameIdentifier(
            final Iterable<? extends NameIdentifier> nameIdentifier) {
          if (this.nameIdentifier != null) {
            this.nameIdentifier.clear();
          }
          return addNameIdentifier(nameIdentifier);
        }

        /**
         * Adds the given items to the value of "nameIdentifier"
         *
         * @param nameIdentifier Items to add to the value of the "nameIdentifier" property
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> addNameIdentifier(
            NameIdentifier... nameIdentifier) {
          addNameIdentifier(Arrays.asList(nameIdentifier));
          return this;
        }

        /**
         * Sets the new value of "nameIdentifier" (any previous value will be replaced)
         *
         * @param nameIdentifier New value of the "nameIdentifier" property.
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> withNameIdentifier(
            NameIdentifier... nameIdentifier) {
          withNameIdentifier(Arrays.asList(nameIdentifier));
          return this;
        }

        /**
         * Returns a new builder to build an additional value of the "NameIdentifier" property. Use
         * {@link org.gbif.doi.metadata.datacite.NameIdentifier.Builder#end()} to return to the
         * current builder.
         *
         * @return a new builder to build an additional value of the "NameIdentifier" property. Use
         *     {@link org.gbif.doi.metadata.datacite.NameIdentifier.Builder#end()} to return to the
         *     current builder.
         */
        public NameIdentifier.Builder<
                ? extends DataCiteMetadata.Contributors.Contributor.Builder<_B>>
            addNameIdentifier() {
          if (this.nameIdentifier == null) {
            this.nameIdentifier =
                new ArrayList<
                    NameIdentifier.Builder<
                        DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
          }
          final NameIdentifier.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>
              nameIdentifier_Builder =
                  new NameIdentifier.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>(
                      this, null, false);
          this.nameIdentifier.add(nameIdentifier_Builder);
          return nameIdentifier_Builder;
        }

        /**
         * Adds the given items to the value of "affiliation"
         *
         * @param affiliation Items to add to the value of the "affiliation" property
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> addAffiliation(
            final Iterable<? extends Affiliation> affiliation) {
          if (affiliation != null) {
            if (this.affiliation == null) {
              this.affiliation =
                  new ArrayList<
                      Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
            }
            for (Affiliation _item : affiliation) {
              this.affiliation.add(
                  new Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>(
                      this, _item, false));
            }
          }
          return this;
        }

        /**
         * Sets the new value of "affiliation" (any previous value will be replaced)
         *
         * @param affiliation New value of the "affiliation" property.
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> withAffiliation(
            final Iterable<? extends Affiliation> affiliation) {
          if (this.affiliation != null) {
            this.affiliation.clear();
          }
          return addAffiliation(affiliation);
        }

        /**
         * Adds the given items to the value of "affiliation"
         *
         * @param affiliation Items to add to the value of the "affiliation" property
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> addAffiliation(
            Affiliation... affiliation) {
          addAffiliation(Arrays.asList(affiliation));
          return this;
        }

        /**
         * Sets the new value of "affiliation" (any previous value will be replaced)
         *
         * @param affiliation New value of the "affiliation" property.
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> withAffiliation(
            Affiliation... affiliation) {
          withAffiliation(Arrays.asList(affiliation));
          return this;
        }

        /**
         * Returns a new builder to build an additional value of the "Affiliation" property. Use
         * {@link org.gbif.doi.metadata.datacite.Affiliation.Builder#end()} to return to the current
         * builder.
         *
         * @return a new builder to build an additional value of the "Affiliation" property. Use
         *     {@link org.gbif.doi.metadata.datacite.Affiliation.Builder#end()} to return to the
         *     current builder.
         */
        public Affiliation.Builder<? extends DataCiteMetadata.Contributors.Contributor.Builder<_B>>
            addAffiliation() {
          if (this.affiliation == null) {
            this.affiliation =
                new ArrayList<
                    Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>>();
          }
          final Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>
              affiliation_Builder =
                  new Affiliation.Builder<DataCiteMetadata.Contributors.Contributor.Builder<_B>>(
                      this, null, false);
          this.affiliation.add(affiliation_Builder);
          return affiliation_Builder;
        }

        /**
         * Sets the new value of "contributorType" (any previous value will be replaced)
         *
         * @param contributorType New value of the "contributorType" property.
         */
        public DataCiteMetadata.Contributors.Contributor.Builder<_B> withContributorType(
            final ContributorType contributorType) {
          this.contributorType = contributorType;
          return this;
        }

        @Override
        public DataCiteMetadata.Contributors.Contributor build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.Contributors.Contributor());
          } else {
            return ((DataCiteMetadata.Contributors.Contributor) _storedValue);
          }
        }

        public DataCiteMetadata.Contributors.Contributor.Builder<_B> copyOf(
            final DataCiteMetadata.Contributors.Contributor _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.Contributors.Contributor.Builder<_B> copyOf(
            final DataCiteMetadata.Contributors.Contributor.Builder _other) {
          return copyOf(_other.build());
        }
      }

      /**
       * Java class for anonymous complex type.
       *
       * <p>The following schema fragment specifies the expected content contained within this
       * class.
       *
       * <pre>
       * &lt;complexType&gt;
       *   &lt;simpleContent&gt;
       *     &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
       *       &lt;attribute name="nameType" type="{http://datacite.org/schema/kernel-4}nameType" /&gt;
       *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
       *     &lt;/extension&gt;
       *   &lt;/simpleContent&gt;
       * &lt;/complexType&gt;
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(
          name = "",
          propOrder = {"value"})
      public static class ContributorName {

        @XmlValue protected String value;

        @XmlAttribute(name = "nameType")
        protected NameType nameType;

        @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
        protected String lang;

        /**
         * Gets the value of the value property.
         *
         * @return possible object is {@link String }
         */
        public String getValue() {
          return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is {@link String }
         */
        public void setValue(String value) {
          this.value = value;
        }

        /**
         * Gets the value of the nameType property.
         *
         * @return possible object is {@link NameType }
         */
        public NameType getNameType() {
          return nameType;
        }

        /**
         * Sets the value of the nameType property.
         *
         * @param value allowed object is {@link NameType }
         */
        public void setNameType(NameType value) {
          this.nameType = value;
        }

        /**
         * Gets the value of the lang property.
         *
         * @return possible object is {@link String }
         */
        public String getLang() {
          return lang;
        }

        /**
         * Sets the value of the lang property.
         *
         * @param value allowed object is {@link String }
         */
        public void setLang(String value) {
          this.lang = value;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> _other) {
          _other.value = this.value;
          _other.nameType = this.nameType;
          _other.lang = this.lang;
        }

        public <_B>
            DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> newCopyBuilder(
                final _B _parentBuilder) {
          return new DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B>(
              _parentBuilder, this, true);
        }

        public DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<Void>
            newCopyBuilder() {
          return newCopyBuilder(null);
        }

        public static DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<Void>
            builder() {
          return new DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<Void>(
              null, null, false);
        }

        public static <_B>
            DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> copyOf(
                final DataCiteMetadata.Contributors.Contributor.ContributorName _other) {
          final DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> _newBuilder =
              new DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B>(
                  null, null, false);
          _other.copyTo(_newBuilder);
          return _newBuilder;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> _other,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          final PropertyTree valuePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("value"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (valuePropertyTree != null)
              : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
            _other.value = this.value;
          }
          final PropertyTree nameTypePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("nameType"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (nameTypePropertyTree != null)
              : ((nameTypePropertyTree == null) || (!nameTypePropertyTree.isLeaf())))) {
            _other.nameType = this.nameType;
          }
          final PropertyTree langPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("lang"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (langPropertyTree != null)
              : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
            _other.lang = this.lang;
          }
        }

        public <_B>
            DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> newCopyBuilder(
                final _B _parentBuilder,
                final PropertyTree _propertyTree,
                final PropertyTreeUse _propertyTreeUse) {
          return new DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B>(
              _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
        }

        public DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<Void>
            newCopyBuilder(
                final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
          return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
        }

        public static <_B>
            DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> copyOf(
                final DataCiteMetadata.Contributors.Contributor.ContributorName _other,
                final PropertyTree _propertyTree,
                final PropertyTreeUse _propertyTreeUse) {
          final DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> _newBuilder =
              new DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B>(
                  null, null, false);
          _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
          return _newBuilder;
        }

        public static DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<Void>
            copyExcept(
                final DataCiteMetadata.Contributors.Contributor.ContributorName _other,
                final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
        }

        public static DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<Void>
            copyOnly(
                final DataCiteMetadata.Contributors.Contributor.ContributorName _other,
                final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
        }

        @Override
        public String toString() {
          return new StringJoiner(", ", ContributorName.class.getSimpleName() + "[", "]")
              .add("value='" + value + "'")
              .add("nameType=" + nameType)
              .add("lang='" + lang + "'")
              .toString();
        }

        @Override
        public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          ContributorName that = (ContributorName) o;
          return Objects.equals(value, that.value)
              && nameType == that.nameType
              && Objects.equals(lang, that.lang);
        }

        @Override
        public int hashCode() {
          return Objects.hash(value, nameType, lang);
        }

        public static class Builder<_B> implements Buildable {

          protected final _B _parentBuilder;
          protected final DataCiteMetadata.Contributors.Contributor.ContributorName _storedValue;
          private String value;
          private NameType nameType;
          private String lang;

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.Contributors.Contributor.ContributorName _other,
              final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                this.value = _other.value;
                this.nameType = _other.nameType;
                this.lang = _other.lang;
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.Contributors.Contributor.ContributorName _other,
              final boolean _copy,
              final PropertyTree _propertyTree,
              final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                final PropertyTree valuePropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("value"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (valuePropertyTree != null)
                    : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                  this.value = _other.value;
                }
                final PropertyTree nameTypePropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("nameType"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (nameTypePropertyTree != null)
                    : ((nameTypePropertyTree == null) || (!nameTypePropertyTree.isLeaf())))) {
                  this.nameType = _other.nameType;
                }
                final PropertyTree langPropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("lang"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (langPropertyTree != null)
                    : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
                  this.lang = _other.lang;
                }
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public _B end() {
            return this._parentBuilder;
          }

          protected <_P extends DataCiteMetadata.Contributors.Contributor.ContributorName> _P init(
              final _P _product) {
            _product.value = this.value;
            _product.nameType = this.nameType;
            _product.lang = this.lang;
            return _product;
          }

          /**
           * Sets the new value of "value" (any previous value will be replaced)
           *
           * @param value New value of the "value" property.
           */
          public DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> withValue(
              final String value) {
            this.value = value;
            return this;
          }

          /**
           * Sets the new value of "nameType" (any previous value will be replaced)
           *
           * @param nameType New value of the "nameType" property.
           */
          public DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> withNameType(
              final NameType nameType) {
            this.nameType = nameType;
            return this;
          }

          /**
           * Sets the new value of "lang" (any previous value will be replaced)
           *
           * @param lang New value of the "lang" property.
           */
          public DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> withLang(
              final String lang) {
            this.lang = lang;
            return this;
          }

          @Override
          public DataCiteMetadata.Contributors.Contributor.ContributorName build() {
            if (_storedValue == null) {
              return this.init(new DataCiteMetadata.Contributors.Contributor.ContributorName());
            } else {
              return ((DataCiteMetadata.Contributors.Contributor.ContributorName) _storedValue);
            }
          }

          public DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> copyOf(
              final DataCiteMetadata.Contributors.Contributor.ContributorName _other) {
            _other.copyTo(this);
            return this;
          }

          public DataCiteMetadata.Contributors.Contributor.ContributorName.Builder<_B> copyOf(
              final DataCiteMetadata.Contributors.Contributor.ContributorName.Builder _other) {
            return copyOf(_other.build());
          }
        }

        public static class Select
            extends DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                DataCiteMetadata.Contributors.Contributor.ContributorName.Select, Void> {

          Select() {
            super(null, null, null);
          }

          public static DataCiteMetadata.Contributors.Contributor.ContributorName.Select _root() {
            return new DataCiteMetadata.Contributors.Contributor.ContributorName.Select();
          }
        }

        public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
            extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

          private com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                      TRoot, TParent>>
              value = null;
          private com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                      TRoot, TParent>>
              nameType = null;
          private com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                      TRoot, TParent>>
              lang = null;

          public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
          }

          @Override
          public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.value != null) {
              products.put("value", this.value.init());
            }
            if (this.nameType != null) {
              products.put("nameType", this.nameType.init());
            }
            if (this.lang != null) {
              products.put("lang", this.lang.init());
            }
            return products;
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                      TRoot, TParent>>
              value() {
            return ((this.value == null)
                ? this.value =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                            TRoot, TParent>>(this._root, this, "value")
                : this.value);
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                      TRoot, TParent>>
              nameType() {
            return ((this.nameType == null)
                ? this.nameType =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                            TRoot, TParent>>(this._root, this, "nameType")
                : this.nameType);
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                      TRoot, TParent>>
              lang() {
            return ((this.lang == null)
                ? this.lang =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                            TRoot, TParent>>(this._root, this, "lang")
                : this.lang);
          }
        }
      }

      public static class Select
          extends DataCiteMetadata.Contributors.Contributor.Selector<
              DataCiteMetadata.Contributors.Contributor.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.Contributors.Contributor.Select _root() {
          return new DataCiteMetadata.Contributors.Contributor.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            contributorName = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            givenName = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            familyName = null;
        private NameIdentifier.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            nameIdentifier = null;
        private Affiliation.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            affiliation = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            contributorType = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.contributorName != null) {
            products.put("contributorName", this.contributorName.init());
          }
          if (this.givenName != null) {
            products.put("givenName", this.givenName.init());
          }
          if (this.familyName != null) {
            products.put("familyName", this.familyName.init());
          }
          if (this.nameIdentifier != null) {
            products.put("nameIdentifier", this.nameIdentifier.init());
          }
          if (this.affiliation != null) {
            products.put("affiliation", this.affiliation.init());
          }
          if (this.contributorType != null) {
            products.put("contributorType", this.contributorType.init());
          }
          return products;
        }

        public DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            contributorName() {
          return ((this.contributorName == null)
              ? this.contributorName =
                  new DataCiteMetadata.Contributors.Contributor.ContributorName.Selector<
                      TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>(
                      this._root, this, "contributorName")
              : this.contributorName);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            givenName() {
          return ((this.givenName == null)
              ? this.givenName =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>(
                      this._root, this, "givenName")
              : this.givenName);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            familyName() {
          return ((this.familyName == null)
              ? this.familyName =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>(
                      this._root, this, "familyName")
              : this.familyName);
        }

        public NameIdentifier.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            nameIdentifier() {
          return ((this.nameIdentifier == null)
              ? this.nameIdentifier =
                  new NameIdentifier.Selector<
                      TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>(
                      this._root, this, "nameIdentifier")
              : this.nameIdentifier);
        }

        public Affiliation.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            affiliation() {
          return ((this.affiliation == null)
              ? this.affiliation =
                  new Affiliation.Selector<
                      TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>(
                      this._root, this, "affiliation")
              : this.affiliation);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>
            contributorType() {
          return ((this.contributorType == null)
              ? this.contributorType =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Contributors.Contributor.Selector<TRoot, TParent>>(
                      this._root, this, "contributorType")
              : this.contributorType);
        }
      }
    }

    public static class Select
        extends DataCiteMetadata.Contributors.Selector<DataCiteMetadata.Contributors.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Contributors.Select _root() {
        return new DataCiteMetadata.Contributors.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.Contributors.Contributor.Selector<
              TRoot, DataCiteMetadata.Contributors.Selector<TRoot, TParent>>
          contributor = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.contributor != null) {
          products.put("contributor", this.contributor.init());
        }
        return products;
      }

      public DataCiteMetadata.Contributors.Contributor.Selector<
              TRoot, DataCiteMetadata.Contributors.Selector<TRoot, TParent>>
          contributor() {
        return ((this.contributor == null)
            ? this.contributor =
                new DataCiteMetadata.Contributors.Contributor.Selector<
                    TRoot, DataCiteMetadata.Contributors.Selector<TRoot, TParent>>(
                    this._root, this, "contributor")
            : this.contributor);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="creator" maxOccurs="unbounded"&gt;
   *           &lt;complexType&gt;
   *             &lt;complexContent&gt;
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *                 &lt;sequence&gt;
   *                   &lt;element name="creatorName"&gt;
   *                     &lt;complexType&gt;
   *                       &lt;simpleContent&gt;
   *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                           &lt;attribute name="nameType" type="{http://datacite.org/schema/kernel-4}nameType" /&gt;
   *                           &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
   *                         &lt;/extension&gt;
   *                       &lt;/simpleContent&gt;
   *                     &lt;/complexType&gt;
   *                   &lt;/element&gt;
   *                   &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
   *                   &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
   *                   &lt;element name="nameIdentifier" type="{http://datacite.org/schema/kernel-4}nameIdentifier" maxOccurs="unbounded" minOccurs="0"/&gt;
   *                   &lt;element name="affiliation" type="{http://datacite.org/schema/kernel-4}affiliation" maxOccurs="unbounded" minOccurs="0"/&gt;
   *                 &lt;/sequence&gt;
   *               &lt;/restriction&gt;
   *             &lt;/complexContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"creator"})
  public static class Creators {

    @XmlElement(required = true)
    protected List<DataCiteMetadata.Creators.Creator> creator;

    /**
     * Gets the value of the creator property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the creator property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getCreator().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.Creators.Creator }
     */
    public List<DataCiteMetadata.Creators.Creator> getCreator() {
      if (creator == null) {
        creator = new ArrayList<DataCiteMetadata.Creators.Creator>();
      }
      return this.creator;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Creators.Builder<_B> _other) {
      if (this.creator == null) {
        _other.creator = null;
      } else {
        _other.creator =
            new ArrayList<
                DataCiteMetadata.Creators.Creator.Builder<DataCiteMetadata.Creators.Builder<_B>>>();
        for (DataCiteMetadata.Creators.Creator _item : this.creator) {
          _other.creator.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.Creators.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Creators.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Creators.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Creators.Builder<Void> builder() {
      return new DataCiteMetadata.Creators.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Creators.Builder<_B> copyOf(
        final DataCiteMetadata.Creators _other) {
      final DataCiteMetadata.Creators.Builder<_B> _newBuilder =
          new DataCiteMetadata.Creators.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Creators.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree creatorPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("creator"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (creatorPropertyTree != null)
          : ((creatorPropertyTree == null) || (!creatorPropertyTree.isLeaf())))) {
        if (this.creator == null) {
          _other.creator = null;
        } else {
          _other.creator =
              new ArrayList<
                  DataCiteMetadata.Creators.Creator.Builder<
                      DataCiteMetadata.Creators.Builder<_B>>>();
          for (DataCiteMetadata.Creators.Creator _item : this.creator) {
            _other.creator.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(_other, creatorPropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.Creators.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Creators.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Creators.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Creators.Builder<_B> copyOf(
        final DataCiteMetadata.Creators _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Creators.Builder<_B> _newBuilder =
          new DataCiteMetadata.Creators.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Creators.Builder<Void> copyExcept(
        final DataCiteMetadata.Creators _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Creators.Builder<Void> copyOnly(
        final DataCiteMetadata.Creators _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Creators.class.getSimpleName() + "[", "]")
          .add("creator=" + creator)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Creators creators = (Creators) o;
      return Objects.equals(creator, creators.creator);
    }

    @Override
    public int hashCode() {
      return Objects.hash(creator);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Creators _storedValue;
      private List<DataCiteMetadata.Creators.Creator.Builder<DataCiteMetadata.Creators.Builder<_B>>>
          creator;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.Creators _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.creator == null) {
              this.creator = null;
            } else {
              this.creator =
                  new ArrayList<
                      DataCiteMetadata.Creators.Creator.Builder<
                          DataCiteMetadata.Creators.Builder<_B>>>();
              for (DataCiteMetadata.Creators.Creator _item : _other.creator) {
                this.creator.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Creators _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree creatorPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("creator"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (creatorPropertyTree != null)
                : ((creatorPropertyTree == null) || (!creatorPropertyTree.isLeaf())))) {
              if (_other.creator == null) {
                this.creator = null;
              } else {
                this.creator =
                    new ArrayList<
                        DataCiteMetadata.Creators.Creator.Builder<
                            DataCiteMetadata.Creators.Builder<_B>>>();
                for (DataCiteMetadata.Creators.Creator _item : _other.creator) {
                  this.creator.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(this, creatorPropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Creators> _P init(final _P _product) {
        if (this.creator != null) {
          final List<DataCiteMetadata.Creators.Creator> creator =
              new ArrayList<DataCiteMetadata.Creators.Creator>(this.creator.size());
          for (DataCiteMetadata.Creators.Creator.Builder<DataCiteMetadata.Creators.Builder<_B>>
              _item : this.creator) {
            creator.add(_item.build());
          }
          _product.creator = creator;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "creator"
       *
       * @param creator Items to add to the value of the "creator" property
       */
      public DataCiteMetadata.Creators.Builder<_B> addCreator(
          final Iterable<? extends DataCiteMetadata.Creators.Creator> creator) {
        if (creator != null) {
          if (this.creator == null) {
            this.creator =
                new ArrayList<
                    DataCiteMetadata.Creators.Creator.Builder<
                        DataCiteMetadata.Creators.Builder<_B>>>();
          }
          for (DataCiteMetadata.Creators.Creator _item : creator) {
            this.creator.add(
                new DataCiteMetadata.Creators.Creator.Builder<
                    DataCiteMetadata.Creators.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "creator" (any previous value will be replaced)
       *
       * @param creator New value of the "creator" property.
       */
      public DataCiteMetadata.Creators.Builder<_B> withCreator(
          final Iterable<? extends DataCiteMetadata.Creators.Creator> creator) {
        if (this.creator != null) {
          this.creator.clear();
        }
        return addCreator(creator);
      }

      /**
       * Adds the given items to the value of "creator"
       *
       * @param creator Items to add to the value of the "creator" property
       */
      public DataCiteMetadata.Creators.Builder<_B> addCreator(
          DataCiteMetadata.Creators.Creator... creator) {
        addCreator(Arrays.asList(creator));
        return this;
      }

      /**
       * Sets the new value of "creator" (any previous value will be replaced)
       *
       * @param creator New value of the "creator" property.
       */
      public DataCiteMetadata.Creators.Builder<_B> withCreator(
          DataCiteMetadata.Creators.Creator... creator) {
        withCreator(Arrays.asList(creator));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "Creator" property. Use {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Creator.Builder#end()} to return
       * to the current builder.
       *
       * @return a new builder to build an additional value of the "Creator" property. Use {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Creator.Builder#end()} to
       *     return to the current builder.
       */
      public DataCiteMetadata.Creators.Creator.Builder<
              ? extends DataCiteMetadata.Creators.Builder<_B>>
          addCreator() {
        if (this.creator == null) {
          this.creator =
              new ArrayList<
                  DataCiteMetadata.Creators.Creator.Builder<
                      DataCiteMetadata.Creators.Builder<_B>>>();
        }
        final DataCiteMetadata.Creators.Creator.Builder<DataCiteMetadata.Creators.Builder<_B>>
            creator_Builder =
                new DataCiteMetadata.Creators.Creator.Builder<
                    DataCiteMetadata.Creators.Builder<_B>>(this, null, false);
        this.creator.add(creator_Builder);
        return creator_Builder;
      }

      @Override
      public DataCiteMetadata.Creators build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Creators());
        } else {
          return ((DataCiteMetadata.Creators) _storedValue);
        }
      }

      public DataCiteMetadata.Creators.Builder<_B> copyOf(final DataCiteMetadata.Creators _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Creators.Builder<_B> copyOf(
          final DataCiteMetadata.Creators.Builder _other) {
        return copyOf(_other.build());
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="creatorName"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="nameType" type="{http://datacite.org/schema/kernel-4}nameType" /&gt;
     *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
     *         &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
     *         &lt;element name="nameIdentifier" type="{http://datacite.org/schema/kernel-4}nameIdentifier" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="affiliation" type="{http://datacite.org/schema/kernel-4}affiliation" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"creatorName", "givenName", "familyName", "nameIdentifier", "affiliation"})
    public static class Creator {

      @XmlElement(required = true)
      protected DataCiteMetadata.Creators.Creator.CreatorName creatorName;

      protected Object givenName;
      protected Object familyName;
      protected List<NameIdentifier> nameIdentifier;
      protected List<Affiliation> affiliation;

      /**
       * Gets the value of the creatorName property.
       *
       * @return possible object is {@link DataCiteMetadata.Creators.Creator.CreatorName }
       */
      public DataCiteMetadata.Creators.Creator.CreatorName getCreatorName() {
        return creatorName;
      }

      /**
       * Sets the value of the creatorName property.
       *
       * @param value allowed object is {@link DataCiteMetadata.Creators.Creator.CreatorName }
       */
      public void setCreatorName(DataCiteMetadata.Creators.Creator.CreatorName value) {
        this.creatorName = value;
      }

      /**
       * Gets the value of the givenName property.
       *
       * @return possible object is {@link Object }
       */
      public Object getGivenName() {
        return givenName;
      }

      /**
       * Sets the value of the givenName property.
       *
       * @param value allowed object is {@link Object }
       */
      public void setGivenName(Object value) {
        this.givenName = value;
      }

      /**
       * Gets the value of the familyName property.
       *
       * @return possible object is {@link Object }
       */
      public Object getFamilyName() {
        return familyName;
      }

      /**
       * Sets the value of the familyName property.
       *
       * @param value allowed object is {@link Object }
       */
      public void setFamilyName(Object value) {
        this.familyName = value;
      }

      /**
       * Gets the value of the nameIdentifier property.
       *
       * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
       * modification you make to the returned list will be present inside the JAXB object. This is
       * why there is not a <CODE>set</CODE> method for the nameIdentifier property.
       *
       * <p>For example, to add a new item, do as follows:
       *
       * <pre>
       *    getNameIdentifier().add(newItem);
       * </pre>
       *
       * <p>Objects of the following type(s) are allowed in the list {@link NameIdentifier }
       */
      public List<NameIdentifier> getNameIdentifier() {
        if (nameIdentifier == null) {
          nameIdentifier = new ArrayList<NameIdentifier>();
        }
        return this.nameIdentifier;
      }

      /**
       * Gets the value of the affiliation property.
       *
       * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
       * modification you make to the returned list will be present inside the JAXB object. This is
       * why there is not a <CODE>set</CODE> method for the affiliation property.
       *
       * <p>For example, to add a new item, do as follows:
       *
       * <pre>
       *    getAffiliation().add(newItem);
       * </pre>
       *
       * <p>Objects of the following type(s) are allowed in the list {@link Affiliation }
       */
      public List<Affiliation> getAffiliation() {
        if (affiliation == null) {
          affiliation = new ArrayList<Affiliation>();
        }
        return this.affiliation;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(final DataCiteMetadata.Creators.Creator.Builder<_B> _other) {
        _other.creatorName =
            ((this.creatorName == null) ? null : this.creatorName.newCopyBuilder(_other));
        _other.givenName = this.givenName;
        _other.familyName = this.familyName;
        if (this.nameIdentifier == null) {
          _other.nameIdentifier = null;
        } else {
          _other.nameIdentifier =
              new ArrayList<
                  NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
          for (NameIdentifier _item : this.nameIdentifier) {
            _other.nameIdentifier.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
          }
        }
        if (this.affiliation == null) {
          _other.affiliation = null;
        } else {
          _other.affiliation =
              new ArrayList<Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
          for (Affiliation _item : this.affiliation) {
            _other.affiliation.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
          }
        }
      }

      public <_B> DataCiteMetadata.Creators.Creator.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.Creators.Creator.Builder<_B>(_parentBuilder, this, true);
      }

      public DataCiteMetadata.Creators.Creator.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.Creators.Creator.Builder<Void> builder() {
        return new DataCiteMetadata.Creators.Creator.Builder<Void>(null, null, false);
      }

      public static <_B> DataCiteMetadata.Creators.Creator.Builder<_B> copyOf(
          final DataCiteMetadata.Creators.Creator _other) {
        final DataCiteMetadata.Creators.Creator.Builder<_B> _newBuilder =
            new DataCiteMetadata.Creators.Creator.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.Creators.Creator.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree creatorNamePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("creatorName"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (creatorNamePropertyTree != null)
            : ((creatorNamePropertyTree == null) || (!creatorNamePropertyTree.isLeaf())))) {
          _other.creatorName =
              ((this.creatorName == null)
                  ? null
                  : this.creatorName.newCopyBuilder(
                      _other, creatorNamePropertyTree, _propertyTreeUse));
        }
        final PropertyTree givenNamePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("givenName"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (givenNamePropertyTree != null)
            : ((givenNamePropertyTree == null) || (!givenNamePropertyTree.isLeaf())))) {
          _other.givenName = this.givenName;
        }
        final PropertyTree familyNamePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("familyName"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (familyNamePropertyTree != null)
            : ((familyNamePropertyTree == null) || (!familyNamePropertyTree.isLeaf())))) {
          _other.familyName = this.familyName;
        }
        final PropertyTree nameIdentifierPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("nameIdentifier"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (nameIdentifierPropertyTree != null)
            : ((nameIdentifierPropertyTree == null) || (!nameIdentifierPropertyTree.isLeaf())))) {
          if (this.nameIdentifier == null) {
            _other.nameIdentifier = null;
          } else {
            _other.nameIdentifier =
                new ArrayList<
                    NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
            for (NameIdentifier _item : this.nameIdentifier) {
              _other.nameIdentifier.add(
                  ((_item == null)
                      ? null
                      : _item.newCopyBuilder(
                          _other, nameIdentifierPropertyTree, _propertyTreeUse)));
            }
          }
        }
        final PropertyTree affiliationPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("affiliation"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (affiliationPropertyTree != null)
            : ((affiliationPropertyTree == null) || (!affiliationPropertyTree.isLeaf())))) {
          if (this.affiliation == null) {
            _other.affiliation = null;
          } else {
            _other.affiliation =
                new ArrayList<Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
            for (Affiliation _item : this.affiliation) {
              _other.affiliation.add(
                  ((_item == null)
                      ? null
                      : _item.newCopyBuilder(_other, affiliationPropertyTree, _propertyTreeUse)));
            }
          }
        }
      }

      public <_B> DataCiteMetadata.Creators.Creator.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.Creators.Creator.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.Creators.Creator.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.Creators.Creator.Builder<_B> copyOf(
          final DataCiteMetadata.Creators.Creator _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.Creators.Creator.Builder<_B> _newBuilder =
            new DataCiteMetadata.Creators.Creator.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.Creators.Creator.Builder<Void> copyExcept(
          final DataCiteMetadata.Creators.Creator _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.Creators.Creator.Builder<Void> copyOnly(
          final DataCiteMetadata.Creators.Creator _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", Creator.class.getSimpleName() + "[", "]")
            .add("creatorName=" + creatorName)
            .add("givenName=" + givenName)
            .add("familyName=" + familyName)
            .add("nameIdentifier=" + nameIdentifier)
            .add("affiliation=" + affiliation)
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creator creator = (Creator) o;
        return Objects.equals(creatorName, creator.creatorName)
            && Objects.equals(givenName, creator.givenName)
            && Objects.equals(familyName, creator.familyName)
            && Objects.equals(nameIdentifier, creator.nameIdentifier)
            && Objects.equals(affiliation, creator.affiliation);
      }

      @Override
      public int hashCode() {
        return Objects.hash(creatorName, givenName, familyName, nameIdentifier, affiliation);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.Creators.Creator _storedValue;
        private DataCiteMetadata.Creators.Creator.CreatorName.Builder<
                DataCiteMetadata.Creators.Creator.Builder<_B>>
            creatorName;
        private Object givenName;
        private Object familyName;
        private List<NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>
            nameIdentifier;
        private List<Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>
            affiliation;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Creators.Creator _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.creatorName =
                  ((_other.creatorName == null) ? null : _other.creatorName.newCopyBuilder(this));
              this.givenName = _other.givenName;
              this.familyName = _other.familyName;
              if (_other.nameIdentifier == null) {
                this.nameIdentifier = null;
              } else {
                this.nameIdentifier =
                    new ArrayList<
                        NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
                for (NameIdentifier _item : _other.nameIdentifier) {
                  this.nameIdentifier.add(((_item == null) ? null : _item.newCopyBuilder(this)));
                }
              }
              if (_other.affiliation == null) {
                this.affiliation = null;
              } else {
                this.affiliation =
                    new ArrayList<
                        Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
                for (Affiliation _item : _other.affiliation) {
                  this.affiliation.add(((_item == null) ? null : _item.newCopyBuilder(this)));
                }
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Creators.Creator _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree creatorNamePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("creatorName"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (creatorNamePropertyTree != null)
                  : ((creatorNamePropertyTree == null) || (!creatorNamePropertyTree.isLeaf())))) {
                this.creatorName =
                    ((_other.creatorName == null)
                        ? null
                        : _other.creatorName.newCopyBuilder(
                            this, creatorNamePropertyTree, _propertyTreeUse));
              }
              final PropertyTree givenNamePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("givenName"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (givenNamePropertyTree != null)
                  : ((givenNamePropertyTree == null) || (!givenNamePropertyTree.isLeaf())))) {
                this.givenName = _other.givenName;
              }
              final PropertyTree familyNamePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("familyName"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (familyNamePropertyTree != null)
                  : ((familyNamePropertyTree == null) || (!familyNamePropertyTree.isLeaf())))) {
                this.familyName = _other.familyName;
              }
              final PropertyTree nameIdentifierPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("nameIdentifier"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (nameIdentifierPropertyTree != null)
                  : ((nameIdentifierPropertyTree == null)
                      || (!nameIdentifierPropertyTree.isLeaf())))) {
                if (_other.nameIdentifier == null) {
                  this.nameIdentifier = null;
                } else {
                  this.nameIdentifier =
                      new ArrayList<
                          NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
                  for (NameIdentifier _item : _other.nameIdentifier) {
                    this.nameIdentifier.add(
                        ((_item == null)
                            ? null
                            : _item.newCopyBuilder(
                                this, nameIdentifierPropertyTree, _propertyTreeUse)));
                  }
                }
              }
              final PropertyTree affiliationPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("affiliation"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (affiliationPropertyTree != null)
                  : ((affiliationPropertyTree == null) || (!affiliationPropertyTree.isLeaf())))) {
                if (_other.affiliation == null) {
                  this.affiliation = null;
                } else {
                  this.affiliation =
                      new ArrayList<
                          Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
                  for (Affiliation _item : _other.affiliation) {
                    this.affiliation.add(
                        ((_item == null)
                            ? null
                            : _item.newCopyBuilder(
                                this, affiliationPropertyTree, _propertyTreeUse)));
                  }
                }
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.Creators.Creator> _P init(final _P _product) {
          _product.creatorName = ((this.creatorName == null) ? null : this.creatorName.build());
          _product.givenName = this.givenName;
          _product.familyName = this.familyName;
          if (this.nameIdentifier != null) {
            final List<NameIdentifier> nameIdentifier =
                new ArrayList<NameIdentifier>(this.nameIdentifier.size());
            for (NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>> _item :
                this.nameIdentifier) {
              nameIdentifier.add(_item.build());
            }
            _product.nameIdentifier = nameIdentifier;
          }
          if (this.affiliation != null) {
            final List<Affiliation> affiliation =
                new ArrayList<Affiliation>(this.affiliation.size());
            for (Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>> _item :
                this.affiliation) {
              affiliation.add(_item.build());
            }
            _product.affiliation = affiliation;
          }
          return _product;
        }

        /**
         * Sets the new value of "creatorName" (any previous value will be replaced)
         *
         * @param creatorName New value of the "creatorName" property.
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> withCreatorName(
            final DataCiteMetadata.Creators.Creator.CreatorName creatorName) {
          this.creatorName =
              ((creatorName == null)
                  ? null
                  : new DataCiteMetadata.Creators.Creator.CreatorName.Builder<
                      DataCiteMetadata.Creators.Creator.Builder<_B>>(this, creatorName, false));
          return this;
        }

        /**
         * Returns the existing builder or a new builder to build the value of the "creatorName"
         * property. Use {@link
         * org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Creator.CreatorName.Builder#end()}
         * to return to the current builder.
         *
         * @return A new builder to build the value of the "creatorName" property. Use {@link
         *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Creators.Creator.CreatorName.Builder#end()}
         *     to return to the current builder.
         */
        public DataCiteMetadata.Creators.Creator.CreatorName.Builder<
                ? extends DataCiteMetadata.Creators.Creator.Builder<_B>>
            withCreatorName() {
          if (this.creatorName != null) {
            return this.creatorName;
          }
          return this.creatorName =
              new DataCiteMetadata.Creators.Creator.CreatorName.Builder<
                  DataCiteMetadata.Creators.Creator.Builder<_B>>(this, null, false);
        }

        /**
         * Sets the new value of "givenName" (any previous value will be replaced)
         *
         * @param givenName New value of the "givenName" property.
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> withGivenName(final Object givenName) {
          this.givenName = givenName;
          return this;
        }

        /**
         * Sets the new value of "familyName" (any previous value will be replaced)
         *
         * @param familyName New value of the "familyName" property.
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> withFamilyName(
            final Object familyName) {
          this.familyName = familyName;
          return this;
        }

        /**
         * Adds the given items to the value of "nameIdentifier"
         *
         * @param nameIdentifier Items to add to the value of the "nameIdentifier" property
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> addNameIdentifier(
            final Iterable<? extends NameIdentifier> nameIdentifier) {
          if (nameIdentifier != null) {
            if (this.nameIdentifier == null) {
              this.nameIdentifier =
                  new ArrayList<
                      NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
            }
            for (NameIdentifier _item : nameIdentifier) {
              this.nameIdentifier.add(
                  new NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>(
                      this, _item, false));
            }
          }
          return this;
        }

        /**
         * Sets the new value of "nameIdentifier" (any previous value will be replaced)
         *
         * @param nameIdentifier New value of the "nameIdentifier" property.
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> withNameIdentifier(
            final Iterable<? extends NameIdentifier> nameIdentifier) {
          if (this.nameIdentifier != null) {
            this.nameIdentifier.clear();
          }
          return addNameIdentifier(nameIdentifier);
        }

        /**
         * Adds the given items to the value of "nameIdentifier"
         *
         * @param nameIdentifier Items to add to the value of the "nameIdentifier" property
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> addNameIdentifier(
            NameIdentifier... nameIdentifier) {
          addNameIdentifier(Arrays.asList(nameIdentifier));
          return this;
        }

        /**
         * Sets the new value of "nameIdentifier" (any previous value will be replaced)
         *
         * @param nameIdentifier New value of the "nameIdentifier" property.
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> withNameIdentifier(
            NameIdentifier... nameIdentifier) {
          withNameIdentifier(Arrays.asList(nameIdentifier));
          return this;
        }

        /**
         * Returns a new builder to build an additional value of the "NameIdentifier" property. Use
         * {@link org.gbif.doi.metadata.datacite.NameIdentifier.Builder#end()} to return to the
         * current builder.
         *
         * @return a new builder to build an additional value of the "NameIdentifier" property. Use
         *     {@link org.gbif.doi.metadata.datacite.NameIdentifier.Builder#end()} to return to the
         *     current builder.
         */
        public NameIdentifier.Builder<? extends DataCiteMetadata.Creators.Creator.Builder<_B>>
            addNameIdentifier() {
          if (this.nameIdentifier == null) {
            this.nameIdentifier =
                new ArrayList<
                    NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
          }
          final NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>
              nameIdentifier_Builder =
                  new NameIdentifier.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>(
                      this, null, false);
          this.nameIdentifier.add(nameIdentifier_Builder);
          return nameIdentifier_Builder;
        }

        /**
         * Adds the given items to the value of "affiliation"
         *
         * @param affiliation Items to add to the value of the "affiliation" property
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> addAffiliation(
            final Iterable<? extends Affiliation> affiliation) {
          if (affiliation != null) {
            if (this.affiliation == null) {
              this.affiliation =
                  new ArrayList<
                      Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
            }
            for (Affiliation _item : affiliation) {
              this.affiliation.add(
                  new Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>(
                      this, _item, false));
            }
          }
          return this;
        }

        /**
         * Sets the new value of "affiliation" (any previous value will be replaced)
         *
         * @param affiliation New value of the "affiliation" property.
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> withAffiliation(
            final Iterable<? extends Affiliation> affiliation) {
          if (this.affiliation != null) {
            this.affiliation.clear();
          }
          return addAffiliation(affiliation);
        }

        /**
         * Adds the given items to the value of "affiliation"
         *
         * @param affiliation Items to add to the value of the "affiliation" property
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> addAffiliation(
            Affiliation... affiliation) {
          addAffiliation(Arrays.asList(affiliation));
          return this;
        }

        /**
         * Sets the new value of "affiliation" (any previous value will be replaced)
         *
         * @param affiliation New value of the "affiliation" property.
         */
        public DataCiteMetadata.Creators.Creator.Builder<_B> withAffiliation(
            Affiliation... affiliation) {
          withAffiliation(Arrays.asList(affiliation));
          return this;
        }

        /**
         * Returns a new builder to build an additional value of the "Affiliation" property. Use
         * {@link org.gbif.doi.metadata.datacite.Affiliation.Builder#end()} to return to the current
         * builder.
         *
         * @return a new builder to build an additional value of the "Affiliation" property. Use
         *     {@link org.gbif.doi.metadata.datacite.Affiliation.Builder#end()} to return to the
         *     current builder.
         */
        public Affiliation.Builder<? extends DataCiteMetadata.Creators.Creator.Builder<_B>>
            addAffiliation() {
          if (this.affiliation == null) {
            this.affiliation =
                new ArrayList<Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>>();
          }
          final Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>
              affiliation_Builder =
                  new Affiliation.Builder<DataCiteMetadata.Creators.Creator.Builder<_B>>(
                      this, null, false);
          this.affiliation.add(affiliation_Builder);
          return affiliation_Builder;
        }

        @Override
        public DataCiteMetadata.Creators.Creator build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.Creators.Creator());
          } else {
            return ((DataCiteMetadata.Creators.Creator) _storedValue);
          }
        }

        public DataCiteMetadata.Creators.Creator.Builder<_B> copyOf(
            final DataCiteMetadata.Creators.Creator _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.Creators.Creator.Builder<_B> copyOf(
            final DataCiteMetadata.Creators.Creator.Builder _other) {
          return copyOf(_other.build());
        }
      }

      /**
       * Java class for anonymous complex type.
       *
       * <p>The following schema fragment specifies the expected content contained within this
       * class.
       *
       * <pre>
       * &lt;complexType&gt;
       *   &lt;simpleContent&gt;
       *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
       *       &lt;attribute name="nameType" type="{http://datacite.org/schema/kernel-4}nameType" /&gt;
       *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
       *     &lt;/extension&gt;
       *   &lt;/simpleContent&gt;
       * &lt;/complexType&gt;
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(
          name = "",
          propOrder = {"value"})
      public static class CreatorName {

        @XmlValue protected String value;

        @XmlAttribute(name = "nameType")
        protected NameType nameType;

        @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
        protected String lang;

        /**
         * Gets the value of the value property.
         *
         * @return possible object is {@link String }
         */
        public String getValue() {
          return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is {@link String }
         */
        public void setValue(String value) {
          this.value = value;
        }

        /**
         * Gets the value of the nameType property.
         *
         * @return possible object is {@link NameType }
         */
        public NameType getNameType() {
          return nameType;
        }

        /**
         * Sets the value of the nameType property.
         *
         * @param value allowed object is {@link NameType }
         */
        public void setNameType(NameType value) {
          this.nameType = value;
        }

        /**
         * Gets the value of the lang property.
         *
         * @return possible object is {@link String }
         */
        public String getLang() {
          return lang;
        }

        /**
         * Sets the value of the lang property.
         *
         * @param value allowed object is {@link String }
         */
        public void setLang(String value) {
          this.lang = value;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> _other) {
          _other.value = this.value;
          _other.nameType = this.nameType;
          _other.lang = this.lang;
        }

        public <_B> DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> newCopyBuilder(
            final _B _parentBuilder) {
          return new DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B>(
              _parentBuilder, this, true);
        }

        public DataCiteMetadata.Creators.Creator.CreatorName.Builder<Void> newCopyBuilder() {
          return newCopyBuilder(null);
        }

        public static DataCiteMetadata.Creators.Creator.CreatorName.Builder<Void> builder() {
          return new DataCiteMetadata.Creators.Creator.CreatorName.Builder<Void>(null, null, false);
        }

        public static <_B> DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> copyOf(
            final DataCiteMetadata.Creators.Creator.CreatorName _other) {
          final DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> _newBuilder =
              new DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B>(null, null, false);
          _other.copyTo(_newBuilder);
          return _newBuilder;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> _other,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          final PropertyTree valuePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("value"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (valuePropertyTree != null)
              : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
            _other.value = this.value;
          }
          final PropertyTree nameTypePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("nameType"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (nameTypePropertyTree != null)
              : ((nameTypePropertyTree == null) || (!nameTypePropertyTree.isLeaf())))) {
            _other.nameType = this.nameType;
          }
          final PropertyTree langPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("lang"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (langPropertyTree != null)
              : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
            _other.lang = this.lang;
          }
        }

        public <_B> DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> newCopyBuilder(
            final _B _parentBuilder,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          return new DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B>(
              _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
        }

        public DataCiteMetadata.Creators.Creator.CreatorName.Builder<Void> newCopyBuilder(
            final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
          return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
        }

        public static <_B> DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> copyOf(
            final DataCiteMetadata.Creators.Creator.CreatorName _other,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          final DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> _newBuilder =
              new DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B>(null, null, false);
          _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
          return _newBuilder;
        }

        public static DataCiteMetadata.Creators.Creator.CreatorName.Builder<Void> copyExcept(
            final DataCiteMetadata.Creators.Creator.CreatorName _other,
            final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
        }

        public static DataCiteMetadata.Creators.Creator.CreatorName.Builder<Void> copyOnly(
            final DataCiteMetadata.Creators.Creator.CreatorName _other,
            final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
        }

        @Override
        public String toString() {
          return new StringJoiner(", ", CreatorName.class.getSimpleName() + "[", "]")
              .add("value='" + value + "'")
              .add("nameType=" + nameType)
              .add("lang='" + lang + "'")
              .toString();
        }

        @Override
        public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          CreatorName that = (CreatorName) o;
          return Objects.equals(value, that.value)
              && nameType == that.nameType
              && Objects.equals(lang, that.lang);
        }

        @Override
        public int hashCode() {
          return Objects.hash(value, nameType, lang);
        }

        public static class Builder<_B> implements Buildable {

          protected final _B _parentBuilder;
          protected final DataCiteMetadata.Creators.Creator.CreatorName _storedValue;
          private String value;
          private NameType nameType;
          private String lang;

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.Creators.Creator.CreatorName _other,
              final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                this.value = _other.value;
                this.nameType = _other.nameType;
                this.lang = _other.lang;
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.Creators.Creator.CreatorName _other,
              final boolean _copy,
              final PropertyTree _propertyTree,
              final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                final PropertyTree valuePropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("value"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (valuePropertyTree != null)
                    : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                  this.value = _other.value;
                }
                final PropertyTree nameTypePropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("nameType"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (nameTypePropertyTree != null)
                    : ((nameTypePropertyTree == null) || (!nameTypePropertyTree.isLeaf())))) {
                  this.nameType = _other.nameType;
                }
                final PropertyTree langPropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("lang"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (langPropertyTree != null)
                    : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
                  this.lang = _other.lang;
                }
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public _B end() {
            return this._parentBuilder;
          }

          protected <_P extends DataCiteMetadata.Creators.Creator.CreatorName> _P init(
              final _P _product) {
            _product.value = this.value;
            _product.nameType = this.nameType;
            _product.lang = this.lang;
            return _product;
          }

          /**
           * Sets the new value of "value" (any previous value will be replaced)
           *
           * @param value New value of the "value" property.
           */
          public DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> withValue(
              final String value) {
            this.value = value;
            return this;
          }

          /**
           * Sets the new value of "nameType" (any previous value will be replaced)
           *
           * @param nameType New value of the "nameType" property.
           */
          public DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> withNameType(
              final NameType nameType) {
            this.nameType = nameType;
            return this;
          }

          /**
           * Sets the new value of "lang" (any previous value will be replaced)
           *
           * @param lang New value of the "lang" property.
           */
          public DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> withLang(
              final String lang) {
            this.lang = lang;
            return this;
          }

          @Override
          public DataCiteMetadata.Creators.Creator.CreatorName build() {
            if (_storedValue == null) {
              return this.init(new DataCiteMetadata.Creators.Creator.CreatorName());
            } else {
              return ((DataCiteMetadata.Creators.Creator.CreatorName) _storedValue);
            }
          }

          public DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> copyOf(
              final DataCiteMetadata.Creators.Creator.CreatorName _other) {
            _other.copyTo(this);
            return this;
          }

          public DataCiteMetadata.Creators.Creator.CreatorName.Builder<_B> copyOf(
              final DataCiteMetadata.Creators.Creator.CreatorName.Builder _other) {
            return copyOf(_other.build());
          }
        }

        public static class Select
            extends DataCiteMetadata.Creators.Creator.CreatorName.Selector<
                DataCiteMetadata.Creators.Creator.CreatorName.Select, Void> {

          Select() {
            super(null, null, null);
          }

          public static DataCiteMetadata.Creators.Creator.CreatorName.Select _root() {
            return new DataCiteMetadata.Creators.Creator.CreatorName.Select();
          }
        }

        public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
            extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

          private com.kscs.util.jaxb.Selector<
                  TRoot, DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>
              value = null;
          private com.kscs.util.jaxb.Selector<
                  TRoot, DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>
              nameType = null;
          private com.kscs.util.jaxb.Selector<
                  TRoot, DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>
              lang = null;

          public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
          }

          @Override
          public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.value != null) {
              products.put("value", this.value.init());
            }
            if (this.nameType != null) {
              products.put("nameType", this.nameType.init());
            }
            if (this.lang != null) {
              products.put("lang", this.lang.init());
            }
            return products;
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot, DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>
              value() {
            return ((this.value == null)
                ? this.value =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>(
                        this._root, this, "value")
                : this.value);
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot, DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>
              nameType() {
            return ((this.nameType == null)
                ? this.nameType =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>(
                        this._root, this, "nameType")
                : this.nameType);
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot, DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>
              lang() {
            return ((this.lang == null)
                ? this.lang =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.Creators.Creator.CreatorName.Selector<TRoot, TParent>>(
                        this._root, this, "lang")
                : this.lang);
          }
        }
      }

      public static class Select
          extends DataCiteMetadata.Creators.Creator.Selector<
              DataCiteMetadata.Creators.Creator.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.Creators.Creator.Select _root() {
          return new DataCiteMetadata.Creators.Creator.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private DataCiteMetadata.Creators.Creator.CreatorName.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            creatorName = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            givenName = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            familyName = null;
        private NameIdentifier.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            nameIdentifier = null;
        private Affiliation.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            affiliation = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.creatorName != null) {
            products.put("creatorName", this.creatorName.init());
          }
          if (this.givenName != null) {
            products.put("givenName", this.givenName.init());
          }
          if (this.familyName != null) {
            products.put("familyName", this.familyName.init());
          }
          if (this.nameIdentifier != null) {
            products.put("nameIdentifier", this.nameIdentifier.init());
          }
          if (this.affiliation != null) {
            products.put("affiliation", this.affiliation.init());
          }
          return products;
        }

        public DataCiteMetadata.Creators.Creator.CreatorName.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            creatorName() {
          return ((this.creatorName == null)
              ? this.creatorName =
                  new DataCiteMetadata.Creators.Creator.CreatorName.Selector<
                      TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>(
                      this._root, this, "creatorName")
              : this.creatorName);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            givenName() {
          return ((this.givenName == null)
              ? this.givenName =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>(
                      this._root, this, "givenName")
              : this.givenName);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            familyName() {
          return ((this.familyName == null)
              ? this.familyName =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>(
                      this._root, this, "familyName")
              : this.familyName);
        }

        public NameIdentifier.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            nameIdentifier() {
          return ((this.nameIdentifier == null)
              ? this.nameIdentifier =
                  new NameIdentifier.Selector<
                      TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>(
                      this._root, this, "nameIdentifier")
              : this.nameIdentifier);
        }

        public Affiliation.Selector<
                TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>
            affiliation() {
          return ((this.affiliation == null)
              ? this.affiliation =
                  new Affiliation.Selector<
                      TRoot, DataCiteMetadata.Creators.Creator.Selector<TRoot, TParent>>(
                      this._root, this, "affiliation")
              : this.affiliation);
        }
      }
    }

    public static class Select
        extends DataCiteMetadata.Creators.Selector<DataCiteMetadata.Creators.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Creators.Select _root() {
        return new DataCiteMetadata.Creators.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.Creators.Creator.Selector<
              TRoot, DataCiteMetadata.Creators.Selector<TRoot, TParent>>
          creator = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.creator != null) {
          products.put("creator", this.creator.init());
        }
        return products;
      }

      public DataCiteMetadata.Creators.Creator.Selector<
              TRoot, DataCiteMetadata.Creators.Selector<TRoot, TParent>>
          creator() {
        return ((this.creator == null)
            ? this.creator =
                new DataCiteMetadata.Creators.Creator.Selector<
                    TRoot, DataCiteMetadata.Creators.Selector<TRoot, TParent>>(
                    this._root, this, "creator")
            : this.creator);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="date" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;simpleContent&gt;
   *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                 &lt;attribute name="dateType" use="required" type="{http://datacite.org/schema/kernel-4}dateType" /&gt;
   *                 &lt;attribute name="dateInformation" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
   *               &lt;/extension&gt;
   *             &lt;/simpleContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"date"})
  public static class Dates {

    protected List<DataCiteMetadata.Dates.Date> date;

    /**
     * Gets the value of the date property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the date property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getDate().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.Dates.Date }
     */
    public List<DataCiteMetadata.Dates.Date> getDate() {
      if (date == null) {
        date = new ArrayList<DataCiteMetadata.Dates.Date>();
      }
      return this.date;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Dates.Builder<_B> _other) {
      if (this.date == null) {
        _other.date = null;
      } else {
        _other.date =
            new ArrayList<
                DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>>();
        for (DataCiteMetadata.Dates.Date _item : this.date) {
          _other.date.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.Dates.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Dates.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Dates.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Dates.Builder<Void> builder() {
      return new DataCiteMetadata.Dates.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Dates.Builder<_B> copyOf(
        final DataCiteMetadata.Dates _other) {
      final DataCiteMetadata.Dates.Builder<_B> _newBuilder =
          new DataCiteMetadata.Dates.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Dates.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree datePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("date"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (datePropertyTree != null)
          : ((datePropertyTree == null) || (!datePropertyTree.isLeaf())))) {
        if (this.date == null) {
          _other.date = null;
        } else {
          _other.date =
              new ArrayList<
                  DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>>();
          for (DataCiteMetadata.Dates.Date _item : this.date) {
            _other.date.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(_other, datePropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.Dates.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Dates.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Dates.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Dates.Builder<_B> copyOf(
        final DataCiteMetadata.Dates _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Dates.Builder<_B> _newBuilder =
          new DataCiteMetadata.Dates.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Dates.Builder<Void> copyExcept(
        final DataCiteMetadata.Dates _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Dates.Builder<Void> copyOnly(
        final DataCiteMetadata.Dates _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Dates.class.getSimpleName() + "[", "]")
          .add("date=" + date)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Dates dates = (Dates) o;
      return Objects.equals(date, dates.date);
    }

    @Override
    public int hashCode() {
      return Objects.hash(date);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Dates _storedValue;
      private List<DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>> date;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.Dates _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.date == null) {
              this.date = null;
            } else {
              this.date =
                  new ArrayList<
                      DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>>();
              for (DataCiteMetadata.Dates.Date _item : _other.date) {
                this.date.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Dates _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree datePropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("date"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (datePropertyTree != null)
                : ((datePropertyTree == null) || (!datePropertyTree.isLeaf())))) {
              if (_other.date == null) {
                this.date = null;
              } else {
                this.date =
                    new ArrayList<
                        DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>>();
                for (DataCiteMetadata.Dates.Date _item : _other.date) {
                  this.date.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(this, datePropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Dates> _P init(final _P _product) {
        if (this.date != null) {
          final List<DataCiteMetadata.Dates.Date> date =
              new ArrayList<DataCiteMetadata.Dates.Date>(this.date.size());
          for (DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>> _item :
              this.date) {
            date.add(_item.build());
          }
          _product.date = date;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "date"
       *
       * @param date Items to add to the value of the "date" property
       */
      public DataCiteMetadata.Dates.Builder<_B> addDate(
          final Iterable<? extends DataCiteMetadata.Dates.Date> date) {
        if (date != null) {
          if (this.date == null) {
            this.date =
                new ArrayList<
                    DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>>();
          }
          for (DataCiteMetadata.Dates.Date _item : date) {
            this.date.add(
                new DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>(
                    this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "date" (any previous value will be replaced)
       *
       * @param date New value of the "date" property.
       */
      public DataCiteMetadata.Dates.Builder<_B> withDate(
          final Iterable<? extends DataCiteMetadata.Dates.Date> date) {
        if (this.date != null) {
          this.date.clear();
        }
        return addDate(date);
      }

      /**
       * Adds the given items to the value of "date"
       *
       * @param date Items to add to the value of the "date" property
       */
      public DataCiteMetadata.Dates.Builder<_B> addDate(DataCiteMetadata.Dates.Date... date) {
        addDate(Arrays.asList(date));
        return this;
      }

      /**
       * Sets the new value of "date" (any previous value will be replaced)
       *
       * @param date New value of the "date" property.
       */
      public DataCiteMetadata.Dates.Builder<_B> withDate(DataCiteMetadata.Dates.Date... date) {
        withDate(Arrays.asList(date));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "Date" property. Use {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.Dates.Date.Builder#end()} to return to the
       * current builder.
       *
       * @return a new builder to build an additional value of the "Date" property. Use {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Dates.Date.Builder#end()} to return to
       *     the current builder.
       */
      public DataCiteMetadata.Dates.Date.Builder<? extends DataCiteMetadata.Dates.Builder<_B>>
          addDate() {
        if (this.date == null) {
          this.date =
              new ArrayList<
                  DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>>();
        }
        final DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>> date_Builder =
            new DataCiteMetadata.Dates.Date.Builder<DataCiteMetadata.Dates.Builder<_B>>(
                this, null, false);
        this.date.add(date_Builder);
        return date_Builder;
      }

      @Override
      public DataCiteMetadata.Dates build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Dates());
        } else {
          return ((DataCiteMetadata.Dates) _storedValue);
        }
      }

      public DataCiteMetadata.Dates.Builder<_B> copyOf(final DataCiteMetadata.Dates _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Dates.Builder<_B> copyOf(
          final DataCiteMetadata.Dates.Builder _other) {
        return copyOf(_other.build());
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="dateType" use="required" type="{http://datacite.org/schema/kernel-4}dateType" /&gt;
     *       &lt;attribute name="dateInformation" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"value"})
    public static class Date {

      @XmlValue protected String value;

      @XmlAttribute(name = "dateType", required = true)
      protected DateType dateType;

      @XmlAttribute(name = "dateInformation")
      @XmlSchemaType(name = "anySimpleType")
      protected String dateInformation;

      /**
       * Gets the value of the value property.
       *
       * @return possible object is {@link String }
       */
      public String getValue() {
        return value;
      }

      /**
       * Sets the value of the value property.
       *
       * @param value allowed object is {@link String }
       */
      public void setValue(String value) {
        this.value = value;
      }

      /**
       * Gets the value of the dateType property.
       *
       * @return possible object is {@link DateType }
       */
      public DateType getDateType() {
        return dateType;
      }

      /**
       * Sets the value of the dateType property.
       *
       * @param value allowed object is {@link DateType }
       */
      public void setDateType(DateType value) {
        this.dateType = value;
      }

      /**
       * Gets the value of the dateInformation property.
       *
       * @return possible object is {@link String }
       */
      public String getDateInformation() {
        return dateInformation;
      }

      /**
       * Sets the value of the dateInformation property.
       *
       * @param value allowed object is {@link String }
       */
      public void setDateInformation(String value) {
        this.dateInformation = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(final DataCiteMetadata.Dates.Date.Builder<_B> _other) {
        _other.value = this.value;
        _other.dateType = this.dateType;
        _other.dateInformation = this.dateInformation;
      }

      public <_B> DataCiteMetadata.Dates.Date.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
        return new DataCiteMetadata.Dates.Date.Builder<_B>(_parentBuilder, this, true);
      }

      public DataCiteMetadata.Dates.Date.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.Dates.Date.Builder<Void> builder() {
        return new DataCiteMetadata.Dates.Date.Builder<Void>(null, null, false);
      }

      public static <_B> DataCiteMetadata.Dates.Date.Builder<_B> copyOf(
          final DataCiteMetadata.Dates.Date _other) {
        final DataCiteMetadata.Dates.Date.Builder<_B> _newBuilder =
            new DataCiteMetadata.Dates.Date.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.Dates.Date.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree valuePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("value"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (valuePropertyTree != null)
            : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
          _other.value = this.value;
        }
        final PropertyTree dateTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("dateType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (dateTypePropertyTree != null)
            : ((dateTypePropertyTree == null) || (!dateTypePropertyTree.isLeaf())))) {
          _other.dateType = this.dateType;
        }
        final PropertyTree dateInformationPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("dateInformation"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (dateInformationPropertyTree != null)
            : ((dateInformationPropertyTree == null) || (!dateInformationPropertyTree.isLeaf())))) {
          _other.dateInformation = this.dateInformation;
        }
      }

      public <_B> DataCiteMetadata.Dates.Date.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.Dates.Date.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.Dates.Date.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.Dates.Date.Builder<_B> copyOf(
          final DataCiteMetadata.Dates.Date _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.Dates.Date.Builder<_B> _newBuilder =
            new DataCiteMetadata.Dates.Date.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.Dates.Date.Builder<Void> copyExcept(
          final DataCiteMetadata.Dates.Date _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.Dates.Date.Builder<Void> copyOnly(
          final DataCiteMetadata.Dates.Date _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", Date.class.getSimpleName() + "[", "]")
            .add("value='" + value + "'")
            .add("dateType=" + dateType)
            .add("dateInformation='" + dateInformation + "'")
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(value, date.value)
            && dateType == date.dateType
            && Objects.equals(dateInformation, date.dateInformation);
      }

      @Override
      public int hashCode() {
        return Objects.hash(value, dateType, dateInformation);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.Dates.Date _storedValue;
        private String value;
        private DateType dateType;
        private String dateInformation;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Dates.Date _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.value = _other.value;
              this.dateType = _other.dateType;
              this.dateInformation = _other.dateInformation;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Dates.Date _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree valuePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("value"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (valuePropertyTree != null)
                  : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                this.value = _other.value;
              }
              final PropertyTree dateTypePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("dateType"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (dateTypePropertyTree != null)
                  : ((dateTypePropertyTree == null) || (!dateTypePropertyTree.isLeaf())))) {
                this.dateType = _other.dateType;
              }
              final PropertyTree dateInformationPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("dateInformation"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (dateInformationPropertyTree != null)
                  : ((dateInformationPropertyTree == null)
                      || (!dateInformationPropertyTree.isLeaf())))) {
                this.dateInformation = _other.dateInformation;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.Dates.Date> _P init(final _P _product) {
          _product.value = this.value;
          _product.dateType = this.dateType;
          _product.dateInformation = this.dateInformation;
          return _product;
        }

        /**
         * Sets the new value of "value" (any previous value will be replaced)
         *
         * @param value New value of the "value" property.
         */
        public DataCiteMetadata.Dates.Date.Builder<_B> withValue(final String value) {
          this.value = value;
          return this;
        }

        /**
         * Sets the new value of "dateType" (any previous value will be replaced)
         *
         * @param dateType New value of the "dateType" property.
         */
        public DataCiteMetadata.Dates.Date.Builder<_B> withDateType(final DateType dateType) {
          this.dateType = dateType;
          return this;
        }

        /**
         * Sets the new value of "dateInformation" (any previous value will be replaced)
         *
         * @param dateInformation New value of the "dateInformation" property.
         */
        public DataCiteMetadata.Dates.Date.Builder<_B> withDateInformation(
            final String dateInformation) {
          this.dateInformation = dateInformation;
          return this;
        }

        @Override
        public DataCiteMetadata.Dates.Date build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.Dates.Date());
          } else {
            return ((DataCiteMetadata.Dates.Date) _storedValue);
          }
        }

        public DataCiteMetadata.Dates.Date.Builder<_B> copyOf(
            final DataCiteMetadata.Dates.Date _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.Dates.Date.Builder<_B> copyOf(
            final DataCiteMetadata.Dates.Date.Builder _other) {
          return copyOf(_other.build());
        }
      }

      public static class Select
          extends DataCiteMetadata.Dates.Date.Selector<DataCiteMetadata.Dates.Date.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.Dates.Date.Select _root() {
          return new DataCiteMetadata.Dates.Date.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>
            value = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>
            dateType = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>
            dateInformation = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.value != null) {
            products.put("value", this.value.init());
          }
          if (this.dateType != null) {
            products.put("dateType", this.dateType.init());
          }
          if (this.dateInformation != null) {
            products.put("dateInformation", this.dateInformation.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>
            value() {
          return ((this.value == null)
              ? this.value =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>(
                      this._root, this, "value")
              : this.value);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>
            dateType() {
          return ((this.dateType == null)
              ? this.dateType =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>(
                      this._root, this, "dateType")
              : this.dateType);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>
            dateInformation() {
          return ((this.dateInformation == null)
              ? this.dateInformation =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Dates.Date.Selector<TRoot, TParent>>(
                      this._root, this, "dateInformation")
              : this.dateInformation);
        }
      }
    }

    public static class Select
        extends DataCiteMetadata.Dates.Selector<DataCiteMetadata.Dates.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Dates.Select _root() {
        return new DataCiteMetadata.Dates.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.Dates.Date.Selector<
              TRoot, DataCiteMetadata.Dates.Selector<TRoot, TParent>>
          date = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.date != null) {
          products.put("date", this.date.init());
        }
        return products;
      }

      public DataCiteMetadata.Dates.Date.Selector<
              TRoot, DataCiteMetadata.Dates.Selector<TRoot, TParent>>
          date() {
        return ((this.date == null)
            ? this.date =
                new DataCiteMetadata.Dates.Date.Selector<
                    TRoot, DataCiteMetadata.Dates.Selector<TRoot, TParent>>(
                    this._root, this, "date")
            : this.date);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="description" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;complexContent&gt;
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *                 &lt;choice&gt;
   *                   &lt;element name="br" maxOccurs="unbounded" minOccurs="0"&gt;
   *                     &lt;complexType&gt;
   *                       &lt;complexContent&gt;
   *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *                         &lt;/restriction&gt;
   *                       &lt;/complexContent&gt;
   *                     &lt;/complexType&gt;
   *                   &lt;/element&gt;
   *                 &lt;/choice&gt;
   *                 &lt;attribute name="descriptionType" use="required" type="{http://datacite.org/schema/kernel-4}descriptionType" /&gt;
   *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
   *               &lt;/restriction&gt;
   *             &lt;/complexContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"description"})
  public static class Descriptions {

    protected List<DataCiteMetadata.Descriptions.Description> description;

    /**
     * Gets the value of the description property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the description property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.Descriptions.Description }
     */
    public List<DataCiteMetadata.Descriptions.Description> getDescription() {
      if (description == null) {
        description = new ArrayList<DataCiteMetadata.Descriptions.Description>();
      }
      return this.description;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Descriptions.Builder<_B> _other) {
      if (this.description == null) {
        _other.description = null;
      } else {
        _other.description =
            new ArrayList<
                DataCiteMetadata.Descriptions.Description.Builder<
                    DataCiteMetadata.Descriptions.Builder<_B>>>();
        for (DataCiteMetadata.Descriptions.Description _item : this.description) {
          _other.description.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.Descriptions.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Descriptions.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Descriptions.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Descriptions.Builder<Void> builder() {
      return new DataCiteMetadata.Descriptions.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Descriptions.Builder<_B> copyOf(
        final DataCiteMetadata.Descriptions _other) {
      final DataCiteMetadata.Descriptions.Builder<_B> _newBuilder =
          new DataCiteMetadata.Descriptions.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Descriptions.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree descriptionPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("description"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (descriptionPropertyTree != null)
          : ((descriptionPropertyTree == null) || (!descriptionPropertyTree.isLeaf())))) {
        if (this.description == null) {
          _other.description = null;
        } else {
          _other.description =
              new ArrayList<
                  DataCiteMetadata.Descriptions.Description.Builder<
                      DataCiteMetadata.Descriptions.Builder<_B>>>();
          for (DataCiteMetadata.Descriptions.Description _item : this.description) {
            _other.description.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(_other, descriptionPropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.Descriptions.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Descriptions.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Descriptions.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Descriptions.Builder<_B> copyOf(
        final DataCiteMetadata.Descriptions _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Descriptions.Builder<_B> _newBuilder =
          new DataCiteMetadata.Descriptions.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Descriptions.Builder<Void> copyExcept(
        final DataCiteMetadata.Descriptions _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Descriptions.Builder<Void> copyOnly(
        final DataCiteMetadata.Descriptions _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Descriptions.class.getSimpleName() + "[", "]")
          .add("description=" + description)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Descriptions that = (Descriptions) o;
      return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
      return Objects.hash(description);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Descriptions _storedValue;
      private List<
              DataCiteMetadata.Descriptions.Description.Builder<
                  DataCiteMetadata.Descriptions.Builder<_B>>>
          description;

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Descriptions _other,
          final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.description == null) {
              this.description = null;
            } else {
              this.description =
                  new ArrayList<
                      DataCiteMetadata.Descriptions.Description.Builder<
                          DataCiteMetadata.Descriptions.Builder<_B>>>();
              for (DataCiteMetadata.Descriptions.Description _item : _other.description) {
                this.description.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Descriptions _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree descriptionPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("description"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (descriptionPropertyTree != null)
                : ((descriptionPropertyTree == null) || (!descriptionPropertyTree.isLeaf())))) {
              if (_other.description == null) {
                this.description = null;
              } else {
                this.description =
                    new ArrayList<
                        DataCiteMetadata.Descriptions.Description.Builder<
                            DataCiteMetadata.Descriptions.Builder<_B>>>();
                for (DataCiteMetadata.Descriptions.Description _item : _other.description) {
                  this.description.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(this, descriptionPropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Descriptions> _P init(final _P _product) {
        if (this.description != null) {
          final List<DataCiteMetadata.Descriptions.Description> description =
              new ArrayList<DataCiteMetadata.Descriptions.Description>(this.description.size());
          for (DataCiteMetadata.Descriptions.Description.Builder<
                  DataCiteMetadata.Descriptions.Builder<_B>>
              _item : this.description) {
            description.add(_item.build());
          }
          _product.description = description;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "description"
       *
       * @param description Items to add to the value of the "description" property
       */
      public DataCiteMetadata.Descriptions.Builder<_B> addDescription(
          final Iterable<? extends DataCiteMetadata.Descriptions.Description> description) {
        if (description != null) {
          if (this.description == null) {
            this.description =
                new ArrayList<
                    DataCiteMetadata.Descriptions.Description.Builder<
                        DataCiteMetadata.Descriptions.Builder<_B>>>();
          }
          for (DataCiteMetadata.Descriptions.Description _item : description) {
            this.description.add(
                new DataCiteMetadata.Descriptions.Description.Builder<
                    DataCiteMetadata.Descriptions.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "description" (any previous value will be replaced)
       *
       * @param description New value of the "description" property.
       */
      public DataCiteMetadata.Descriptions.Builder<_B> withDescription(
          final Iterable<? extends DataCiteMetadata.Descriptions.Description> description) {
        if (this.description != null) {
          this.description.clear();
        }
        return addDescription(description);
      }

      /**
       * Adds the given items to the value of "description"
       *
       * @param description Items to add to the value of the "description" property
       */
      public DataCiteMetadata.Descriptions.Builder<_B> addDescription(
          DataCiteMetadata.Descriptions.Description... description) {
        addDescription(Arrays.asList(description));
        return this;
      }

      /**
       * Sets the new value of "description" (any previous value will be replaced)
       *
       * @param description New value of the "description" property.
       */
      public DataCiteMetadata.Descriptions.Builder<_B> withDescription(
          DataCiteMetadata.Descriptions.Description... description) {
        withDescription(Arrays.asList(description));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "Description" property. Use
       * {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.Descriptions.Description.Builder#end()} to
       * return to the current builder.
       *
       * @return a new builder to build an additional value of the "Description" property. Use
       *     {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Descriptions.Description.Builder#end()}
       *     to return to the current builder.
       */
      public DataCiteMetadata.Descriptions.Description.Builder<
              ? extends DataCiteMetadata.Descriptions.Builder<_B>>
          addDescription() {
        if (this.description == null) {
          this.description =
              new ArrayList<
                  DataCiteMetadata.Descriptions.Description.Builder<
                      DataCiteMetadata.Descriptions.Builder<_B>>>();
        }
        final DataCiteMetadata.Descriptions.Description.Builder<
                DataCiteMetadata.Descriptions.Builder<_B>>
            description_Builder =
                new DataCiteMetadata.Descriptions.Description.Builder<
                    DataCiteMetadata.Descriptions.Builder<_B>>(this, null, false);
        this.description.add(description_Builder);
        return description_Builder;
      }

      @Override
      public DataCiteMetadata.Descriptions build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Descriptions());
        } else {
          return ((DataCiteMetadata.Descriptions) _storedValue);
        }
      }

      public DataCiteMetadata.Descriptions.Builder<_B> copyOf(
          final DataCiteMetadata.Descriptions _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Descriptions.Builder<_B> copyOf(
          final DataCiteMetadata.Descriptions.Builder _other) {
        return copyOf(_other.build());
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element name="br" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/choice&gt;
     *       &lt;attribute name="descriptionType" use="required" type="{http://datacite.org/schema/kernel-4}descriptionType" /&gt;
     *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"content"})
    public static class Description {

      @XmlElementRef(
          name = "br",
          namespace = "http://datacite.org/schema/kernel-4",
          type = JAXBElement.class,
          required = false)
      @XmlMixed
      protected List<Serializable> content;

      @XmlAttribute(name = "descriptionType", required = true)
      protected DescriptionType descriptionType;

      @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
      protected String lang;

      /**
       * Gets the value of the content property.
       *
       * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
       * modification you make to the returned list will be present inside the JAXB object. This is
       * why there is not a <CODE>set</CODE> method for the content property.
       *
       * <p>For example, to add a new item, do as follows:
       *
       * <pre>
       *    getContent().add(newItem);
       * </pre>
       *
       * <p>Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code
       * <}{@link DataCiteMetadata.Descriptions.Description.Br }{@code >} {@link String }
       */
      public List<Serializable> getContent() {
        if (content == null) {
          content = new ArrayList<Serializable>();
        }
        return this.content;
      }

      /**
       * Gets the value of the descriptionType property.
       *
       * @return possible object is {@link DescriptionType }
       */
      public DescriptionType getDescriptionType() {
        return descriptionType;
      }

      /**
       * Sets the value of the descriptionType property.
       *
       * @param value allowed object is {@link DescriptionType }
       */
      public void setDescriptionType(DescriptionType value) {
        this.descriptionType = value;
      }

      /**
       * Gets the value of the lang property.
       *
       * @return possible object is {@link String }
       */
      public String getLang() {
        return lang;
      }

      /**
       * Sets the value of the lang property.
       *
       * @param value allowed object is {@link String }
       */
      public void setLang(String value) {
        this.lang = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(final DataCiteMetadata.Descriptions.Description.Builder<_B> _other) {
        if (this.content == null) {
          _other.content = null;
        } else {
          _other.content = new ArrayList<Buildable>();
          for (Serializable _item : this.content) {
            _other.content.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
          }
        }
        _other.descriptionType = this.descriptionType;
        _other.lang = this.lang;
      }

      public <_B> DataCiteMetadata.Descriptions.Description.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.Descriptions.Description.Builder<_B>(
            _parentBuilder, this, true);
      }

      public DataCiteMetadata.Descriptions.Description.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.Descriptions.Description.Builder<Void> builder() {
        return new DataCiteMetadata.Descriptions.Description.Builder<Void>(null, null, false);
      }

      public static <_B> DataCiteMetadata.Descriptions.Description.Builder<_B> copyOf(
          final DataCiteMetadata.Descriptions.Description _other) {
        final DataCiteMetadata.Descriptions.Description.Builder<_B> _newBuilder =
            new DataCiteMetadata.Descriptions.Description.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.Descriptions.Description.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree contentPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("content"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (contentPropertyTree != null)
            : ((contentPropertyTree == null) || (!contentPropertyTree.isLeaf())))) {
          if (this.content == null) {
            _other.content = null;
          } else {
            _other.content = new ArrayList<Buildable>();
            for (Serializable _item : this.content) {
              _other.content.add(
                  ((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
            }
          }
        }
        final PropertyTree descriptionTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("descriptionType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (descriptionTypePropertyTree != null)
            : ((descriptionTypePropertyTree == null) || (!descriptionTypePropertyTree.isLeaf())))) {
          _other.descriptionType = this.descriptionType;
        }
        final PropertyTree langPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("lang"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (langPropertyTree != null)
            : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
          _other.lang = this.lang;
        }
      }

      public <_B> DataCiteMetadata.Descriptions.Description.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.Descriptions.Description.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.Descriptions.Description.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.Descriptions.Description.Builder<_B> copyOf(
          final DataCiteMetadata.Descriptions.Description _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.Descriptions.Description.Builder<_B> _newBuilder =
            new DataCiteMetadata.Descriptions.Description.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.Descriptions.Description.Builder<Void> copyExcept(
          final DataCiteMetadata.Descriptions.Description _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.Descriptions.Description.Builder<Void> copyOnly(
          final DataCiteMetadata.Descriptions.Description _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", Description.class.getSimpleName() + "[", "]")
            .add("content=" + content)
            .add("descriptionType=" + descriptionType)
            .add("lang='" + lang + "'")
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(content, that.content)
            && descriptionType == that.descriptionType
            && Objects.equals(lang, that.lang);
      }

      @Override
      public int hashCode() {
        return Objects.hash(content, descriptionType, lang);
      }

      /**
       * Java class for anonymous complex type.
       *
       * <p>The following schema fragment specifies the expected content contained within this
       * class.
       *
       * <pre>
       * &lt;complexType&gt;
       *   &lt;complexContent&gt;
       *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
       *     &lt;/restriction&gt;
       *   &lt;/complexContent&gt;
       * &lt;/complexType&gt;
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name = "")
      public static class Br {

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.Descriptions.Description.Br.Builder<_B> _other) {}

        public <_B> DataCiteMetadata.Descriptions.Description.Br.Builder<_B> newCopyBuilder(
            final _B _parentBuilder) {
          return new DataCiteMetadata.Descriptions.Description.Br.Builder<_B>(
              _parentBuilder, this, true);
        }

        public DataCiteMetadata.Descriptions.Description.Br.Builder<Void> newCopyBuilder() {
          return newCopyBuilder(null);
        }

        public static DataCiteMetadata.Descriptions.Description.Br.Builder<Void> builder() {
          return new DataCiteMetadata.Descriptions.Description.Br.Builder<Void>(null, null, false);
        }

        public static <_B> DataCiteMetadata.Descriptions.Description.Br.Builder<_B> copyOf(
            final DataCiteMetadata.Descriptions.Description.Br _other) {
          final DataCiteMetadata.Descriptions.Description.Br.Builder<_B> _newBuilder =
              new DataCiteMetadata.Descriptions.Description.Br.Builder<_B>(null, null, false);
          _other.copyTo(_newBuilder);
          return _newBuilder;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.Descriptions.Description.Br.Builder<_B> _other,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {}

        public <_B> DataCiteMetadata.Descriptions.Description.Br.Builder<_B> newCopyBuilder(
            final _B _parentBuilder,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          return new DataCiteMetadata.Descriptions.Description.Br.Builder<_B>(
              _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
        }

        public DataCiteMetadata.Descriptions.Description.Br.Builder<Void> newCopyBuilder(
            final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
          return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
        }

        public static <_B> DataCiteMetadata.Descriptions.Description.Br.Builder<_B> copyOf(
            final DataCiteMetadata.Descriptions.Description.Br _other,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          final DataCiteMetadata.Descriptions.Description.Br.Builder<_B> _newBuilder =
              new DataCiteMetadata.Descriptions.Description.Br.Builder<_B>(null, null, false);
          _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
          return _newBuilder;
        }

        public static DataCiteMetadata.Descriptions.Description.Br.Builder<Void> copyExcept(
            final DataCiteMetadata.Descriptions.Description.Br _other,
            final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
        }

        public static DataCiteMetadata.Descriptions.Description.Br.Builder<Void> copyOnly(
            final DataCiteMetadata.Descriptions.Description.Br _other,
            final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
        }

        @Override
        public String toString() {
          return new StringJoiner(", ", Br.class.getSimpleName() + "[", "]").toString();
        }

        public static class Builder<_B> implements Buildable {

          protected final _B _parentBuilder;
          protected final DataCiteMetadata.Descriptions.Description.Br _storedValue;

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.Descriptions.Description.Br _other,
              final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.Descriptions.Description.Br _other,
              final boolean _copy,
              final PropertyTree _propertyTree,
              final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public _B end() {
            return this._parentBuilder;
          }

          protected <_P extends DataCiteMetadata.Descriptions.Description.Br> _P init(
              final _P _product) {
            return _product;
          }

          @Override
          public DataCiteMetadata.Descriptions.Description.Br build() {
            if (_storedValue == null) {
              return this.init(new DataCiteMetadata.Descriptions.Description.Br());
            } else {
              return ((DataCiteMetadata.Descriptions.Description.Br) _storedValue);
            }
          }

          public DataCiteMetadata.Descriptions.Description.Br.Builder<_B> copyOf(
              final DataCiteMetadata.Descriptions.Description.Br _other) {
            _other.copyTo(this);
            return this;
          }

          public DataCiteMetadata.Descriptions.Description.Br.Builder<_B> copyOf(
              final DataCiteMetadata.Descriptions.Description.Br.Builder _other) {
            return copyOf(_other.build());
          }
        }

        public static class Select
            extends DataCiteMetadata.Descriptions.Description.Br.Selector<
                DataCiteMetadata.Descriptions.Description.Br.Select, Void> {

          Select() {
            super(null, null, null);
          }

          public static DataCiteMetadata.Descriptions.Description.Br.Select _root() {
            return new DataCiteMetadata.Descriptions.Description.Br.Select();
          }
        }

        public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
            extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

          public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
          }

          @Override
          public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            return products;
          }
        }
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.Descriptions.Description _storedValue;
        private List<Buildable> content;
        private DescriptionType descriptionType;
        private String lang;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Descriptions.Description _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              if (_other.content == null) {
                this.content = null;
              } else {
                this.content = new ArrayList<Buildable>();
                for (Serializable _item : _other.content) {
                  this.content.add(
                      ((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
                }
              }
              this.descriptionType = _other.descriptionType;
              this.lang = _other.lang;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Descriptions.Description _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree contentPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("content"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (contentPropertyTree != null)
                  : ((contentPropertyTree == null) || (!contentPropertyTree.isLeaf())))) {
                if (_other.content == null) {
                  this.content = null;
                } else {
                  this.content = new ArrayList<Buildable>();
                  for (Serializable _item : _other.content) {
                    this.content.add(
                        ((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
                  }
                }
              }
              final PropertyTree descriptionTypePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("descriptionType"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (descriptionTypePropertyTree != null)
                  : ((descriptionTypePropertyTree == null)
                      || (!descriptionTypePropertyTree.isLeaf())))) {
                this.descriptionType = _other.descriptionType;
              }
              final PropertyTree langPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("lang"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (langPropertyTree != null)
                  : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
                this.lang = _other.lang;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.Descriptions.Description> _P init(
            final _P _product) {
          if (this.content != null) {
            final List<Serializable> content = new ArrayList<Serializable>(this.content.size());
            for (Buildable _item : this.content) {
              content.add(((Serializable) _item.build()));
            }
            _product.content = content;
          }
          _product.descriptionType = this.descriptionType;
          _product.lang = this.lang;
          return _product;
        }

        /**
         * Adds the given items to the value of "content"
         *
         * @param content Items to add to the value of the "content" property
         */
        public DataCiteMetadata.Descriptions.Description.Builder<_B> addContent(
            final Iterable<? extends Serializable> content) {
          if (content != null) {
            if (this.content == null) {
              this.content = new ArrayList<Buildable>();
            }
            for (Serializable _item : content) {
              this.content.add(new Buildable.PrimitiveBuildable(_item));
            }
          }
          return this;
        }

        /**
         * Sets the new value of "content" (any previous value will be replaced)
         *
         * @param content New value of the "content" property.
         */
        public DataCiteMetadata.Descriptions.Description.Builder<_B> withContent(
            final Iterable<? extends Serializable> content) {
          if (this.content != null) {
            this.content.clear();
          }
          return addContent(content);
        }

        /**
         * Adds the given items to the value of "content"
         *
         * @param content Items to add to the value of the "content" property
         */
        public DataCiteMetadata.Descriptions.Description.Builder<_B> addContent(
            Serializable... content) {
          addContent(Arrays.asList(content));
          return this;
        }

        /**
         * Sets the new value of "content" (any previous value will be replaced)
         *
         * @param content New value of the "content" property.
         */
        public DataCiteMetadata.Descriptions.Description.Builder<_B> withContent(
            Serializable... content) {
          withContent(Arrays.asList(content));
          return this;
        }

        /**
         * Sets the new value of "descriptionType" (any previous value will be replaced)
         *
         * @param descriptionType New value of the "descriptionType" property.
         */
        public DataCiteMetadata.Descriptions.Description.Builder<_B> withDescriptionType(
            final DescriptionType descriptionType) {
          this.descriptionType = descriptionType;
          return this;
        }

        /**
         * Sets the new value of "lang" (any previous value will be replaced)
         *
         * @param lang New value of the "lang" property.
         */
        public DataCiteMetadata.Descriptions.Description.Builder<_B> withLang(final String lang) {
          this.lang = lang;
          return this;
        }

        @Override
        public DataCiteMetadata.Descriptions.Description build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.Descriptions.Description());
          } else {
            return ((DataCiteMetadata.Descriptions.Description) _storedValue);
          }
        }

        public DataCiteMetadata.Descriptions.Description.Builder<_B> copyOf(
            final DataCiteMetadata.Descriptions.Description _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.Descriptions.Description.Builder<_B> copyOf(
            final DataCiteMetadata.Descriptions.Description.Builder _other) {
          return copyOf(_other.build());
        }
      }

      public static class Select
          extends DataCiteMetadata.Descriptions.Description.Selector<
              DataCiteMetadata.Descriptions.Description.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.Descriptions.Description.Select _root() {
          return new DataCiteMetadata.Descriptions.Description.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>
            content = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>
            descriptionType = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>
            lang = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.content != null) {
            products.put("content", this.content.init());
          }
          if (this.descriptionType != null) {
            products.put("descriptionType", this.descriptionType.init());
          }
          if (this.lang != null) {
            products.put("lang", this.lang.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>
            content() {
          return ((this.content == null)
              ? this.content =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>(
                      this._root, this, "content")
              : this.content);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>
            descriptionType() {
          return ((this.descriptionType == null)
              ? this.descriptionType =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>(
                      this._root, this, "descriptionType")
              : this.descriptionType);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>
            lang() {
          return ((this.lang == null)
              ? this.lang =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Descriptions.Description.Selector<TRoot, TParent>>(
                      this._root, this, "lang")
              : this.lang);
        }
      }
    }

    public static class Select
        extends DataCiteMetadata.Descriptions.Selector<DataCiteMetadata.Descriptions.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Descriptions.Select _root() {
        return new DataCiteMetadata.Descriptions.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.Descriptions.Description.Selector<
              TRoot, DataCiteMetadata.Descriptions.Selector<TRoot, TParent>>
          description = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.description != null) {
          products.put("description", this.description.init());
        }
        return products;
      }

      public DataCiteMetadata.Descriptions.Description.Selector<
              TRoot, DataCiteMetadata.Descriptions.Selector<TRoot, TParent>>
          description() {
        return ((this.description == null)
            ? this.description =
                new DataCiteMetadata.Descriptions.Description.Selector<
                    TRoot, DataCiteMetadata.Descriptions.Selector<TRoot, TParent>>(
                    this._root, this, "description")
            : this.description);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"format"})
  public static class Formats {

    protected List<String> format;

    /**
     * Gets the value of the format property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the format property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getFormat().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link String }
     */
    public List<String> getFormat() {
      if (format == null) {
        format = new ArrayList<String>();
      }
      return this.format;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Formats.Builder<_B> _other) {
      if (this.format == null) {
        _other.format = null;
      } else {
        _other.format = new ArrayList<Buildable>();
        for (String _item : this.format) {
          _other.format.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
        }
      }
    }

    public <_B> DataCiteMetadata.Formats.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Formats.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Formats.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Formats.Builder<Void> builder() {
      return new DataCiteMetadata.Formats.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Formats.Builder<_B> copyOf(
        final DataCiteMetadata.Formats _other) {
      final DataCiteMetadata.Formats.Builder<_B> _newBuilder =
          new DataCiteMetadata.Formats.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Formats.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree formatPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("format"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (formatPropertyTree != null)
          : ((formatPropertyTree == null) || (!formatPropertyTree.isLeaf())))) {
        if (this.format == null) {
          _other.format = null;
        } else {
          _other.format = new ArrayList<Buildable>();
          for (String _item : this.format) {
            _other.format.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.Formats.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Formats.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Formats.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Formats.Builder<_B> copyOf(
        final DataCiteMetadata.Formats _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Formats.Builder<_B> _newBuilder =
          new DataCiteMetadata.Formats.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Formats.Builder<Void> copyExcept(
        final DataCiteMetadata.Formats _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Formats.Builder<Void> copyOnly(
        final DataCiteMetadata.Formats _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Formats.class.getSimpleName() + "[", "]")
          .add("format=" + format)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Formats formats = (Formats) o;
      return Objects.equals(format, formats.format);
    }

    @Override
    public int hashCode() {
      return Objects.hash(format);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Formats _storedValue;
      private List<Buildable> format;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.Formats _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.format == null) {
              this.format = null;
            } else {
              this.format = new ArrayList<Buildable>();
              for (String _item : _other.format) {
                this.format.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Formats _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree formatPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("format"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (formatPropertyTree != null)
                : ((formatPropertyTree == null) || (!formatPropertyTree.isLeaf())))) {
              if (_other.format == null) {
                this.format = null;
              } else {
                this.format = new ArrayList<Buildable>();
                for (String _item : _other.format) {
                  this.format.add(
                      ((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Formats> _P init(final _P _product) {
        if (this.format != null) {
          final List<String> format = new ArrayList<String>(this.format.size());
          for (Buildable _item : this.format) {
            format.add(((String) _item.build()));
          }
          _product.format = format;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "format"
       *
       * @param format Items to add to the value of the "format" property
       */
      public DataCiteMetadata.Formats.Builder<_B> addFormat(
          final Iterable<? extends String> format) {
        if (format != null) {
          if (this.format == null) {
            this.format = new ArrayList<Buildable>();
          }
          for (String _item : format) {
            this.format.add(new Buildable.PrimitiveBuildable(_item));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "format" (any previous value will be replaced)
       *
       * @param format New value of the "format" property.
       */
      public DataCiteMetadata.Formats.Builder<_B> withFormat(
          final Iterable<? extends String> format) {
        if (this.format != null) {
          this.format.clear();
        }
        return addFormat(format);
      }

      /**
       * Adds the given items to the value of "format"
       *
       * @param format Items to add to the value of the "format" property
       */
      public DataCiteMetadata.Formats.Builder<_B> addFormat(String... format) {
        addFormat(Arrays.asList(format));
        return this;
      }

      /**
       * Sets the new value of "format" (any previous value will be replaced)
       *
       * @param format New value of the "format" property.
       */
      public DataCiteMetadata.Formats.Builder<_B> withFormat(String... format) {
        withFormat(Arrays.asList(format));
        return this;
      }

      @Override
      public DataCiteMetadata.Formats build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Formats());
        } else {
          return ((DataCiteMetadata.Formats) _storedValue);
        }
      }

      public DataCiteMetadata.Formats.Builder<_B> copyOf(final DataCiteMetadata.Formats _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Formats.Builder<_B> copyOf(
          final DataCiteMetadata.Formats.Builder _other) {
        return copyOf(_other.build());
      }
    }

    public static class Select
        extends DataCiteMetadata.Formats.Selector<DataCiteMetadata.Formats.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Formats.Select _root() {
        return new DataCiteMetadata.Formats.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Formats.Selector<TRoot, TParent>>
          format = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.format != null) {
          products.put("format", this.format.init());
        }
        return products;
      }

      public com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Formats.Selector<TRoot, TParent>>
          format() {
        return ((this.format == null)
            ? this.format =
                new com.kscs.util.jaxb.Selector<
                    TRoot, DataCiteMetadata.Formats.Selector<TRoot, TParent>>(
                    this._root, this, "format")
            : this.format);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="fundingReference" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;complexContent&gt;
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *                 &lt;all&gt;
   *                   &lt;element name="funderName"&gt;
   *                     &lt;simpleType&gt;
   *                       &lt;restriction base="{http://datacite.org/schema/kernel-4}nonemptycontentStringType"&gt;
   *                       &lt;/restriction&gt;
   *                     &lt;/simpleType&gt;
   *                   &lt;/element&gt;
   *                   &lt;element name="funderIdentifier" minOccurs="0"&gt;
   *                     &lt;complexType&gt;
   *                       &lt;simpleContent&gt;
   *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                           &lt;attribute name="funderIdentifierType" use="required" type="{http://datacite.org/schema/kernel-4}funderIdentifierType" /&gt;
   *                           &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
   *                         &lt;/extension&gt;
   *                       &lt;/simpleContent&gt;
   *                     &lt;/complexType&gt;
   *                   &lt;/element&gt;
   *                   &lt;element name="awardNumber" minOccurs="0"&gt;
   *                     &lt;complexType&gt;
   *                       &lt;simpleContent&gt;
   *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                           &lt;attribute name="awardURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
   *                         &lt;/extension&gt;
   *                       &lt;/simpleContent&gt;
   *                     &lt;/complexType&gt;
   *                   &lt;/element&gt;
   *                   &lt;element name="awardTitle" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
   *                 &lt;/all&gt;
   *               &lt;/restriction&gt;
   *             &lt;/complexContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"fundingReference"})
  public static class FundingReferences {

    protected List<DataCiteMetadata.FundingReferences.FundingReference> fundingReference;

    /**
     * Gets the value of the fundingReference property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the fundingReference property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getFundingReference().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.FundingReferences.FundingReference }
     */
    public List<DataCiteMetadata.FundingReferences.FundingReference> getFundingReference() {
      if (fundingReference == null) {
        fundingReference = new ArrayList<DataCiteMetadata.FundingReferences.FundingReference>();
      }
      return this.fundingReference;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.FundingReferences.Builder<_B> _other) {
      if (this.fundingReference == null) {
        _other.fundingReference = null;
      } else {
        _other.fundingReference =
            new ArrayList<
                DataCiteMetadata.FundingReferences.FundingReference.Builder<
                    DataCiteMetadata.FundingReferences.Builder<_B>>>();
        for (DataCiteMetadata.FundingReferences.FundingReference _item : this.fundingReference) {
          _other.fundingReference.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.FundingReferences.Builder<_B> newCopyBuilder(
        final _B _parentBuilder) {
      return new DataCiteMetadata.FundingReferences.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.FundingReferences.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.FundingReferences.Builder<Void> builder() {
      return new DataCiteMetadata.FundingReferences.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.FundingReferences.Builder<_B> copyOf(
        final DataCiteMetadata.FundingReferences _other) {
      final DataCiteMetadata.FundingReferences.Builder<_B> _newBuilder =
          new DataCiteMetadata.FundingReferences.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.FundingReferences.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree fundingReferencePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("fundingReference"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (fundingReferencePropertyTree != null)
          : ((fundingReferencePropertyTree == null) || (!fundingReferencePropertyTree.isLeaf())))) {
        if (this.fundingReference == null) {
          _other.fundingReference = null;
        } else {
          _other.fundingReference =
              new ArrayList<
                  DataCiteMetadata.FundingReferences.FundingReference.Builder<
                      DataCiteMetadata.FundingReferences.Builder<_B>>>();
          for (DataCiteMetadata.FundingReferences.FundingReference _item : this.fundingReference) {
            _other.fundingReference.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(
                        _other, fundingReferencePropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.FundingReferences.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.FundingReferences.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.FundingReferences.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.FundingReferences.Builder<_B> copyOf(
        final DataCiteMetadata.FundingReferences _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.FundingReferences.Builder<_B> _newBuilder =
          new DataCiteMetadata.FundingReferences.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.FundingReferences.Builder<Void> copyExcept(
        final DataCiteMetadata.FundingReferences _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.FundingReferences.Builder<Void> copyOnly(
        final DataCiteMetadata.FundingReferences _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", FundingReferences.class.getSimpleName() + "[", "]")
          .add("fundingReference=" + fundingReference)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      FundingReferences that = (FundingReferences) o;
      return Objects.equals(fundingReference, that.fundingReference);
    }

    @Override
    public int hashCode() {
      return Objects.hash(fundingReference);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.FundingReferences _storedValue;
      private List<
              DataCiteMetadata.FundingReferences.FundingReference.Builder<
                  DataCiteMetadata.FundingReferences.Builder<_B>>>
          fundingReference;

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.FundingReferences _other,
          final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.fundingReference == null) {
              this.fundingReference = null;
            } else {
              this.fundingReference =
                  new ArrayList<
                      DataCiteMetadata.FundingReferences.FundingReference.Builder<
                          DataCiteMetadata.FundingReferences.Builder<_B>>>();
              for (DataCiteMetadata.FundingReferences.FundingReference _item :
                  _other.fundingReference) {
                this.fundingReference.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.FundingReferences _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree fundingReferencePropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("fundingReference"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (fundingReferencePropertyTree != null)
                : ((fundingReferencePropertyTree == null)
                    || (!fundingReferencePropertyTree.isLeaf())))) {
              if (_other.fundingReference == null) {
                this.fundingReference = null;
              } else {
                this.fundingReference =
                    new ArrayList<
                        DataCiteMetadata.FundingReferences.FundingReference.Builder<
                            DataCiteMetadata.FundingReferences.Builder<_B>>>();
                for (DataCiteMetadata.FundingReferences.FundingReference _item :
                    _other.fundingReference) {
                  this.fundingReference.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(
                              this, fundingReferencePropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.FundingReferences> _P init(final _P _product) {
        if (this.fundingReference != null) {
          final List<DataCiteMetadata.FundingReferences.FundingReference> fundingReference =
              new ArrayList<DataCiteMetadata.FundingReferences.FundingReference>(
                  this.fundingReference.size());
          for (DataCiteMetadata.FundingReferences.FundingReference.Builder<
                  DataCiteMetadata.FundingReferences.Builder<_B>>
              _item : this.fundingReference) {
            fundingReference.add(_item.build());
          }
          _product.fundingReference = fundingReference;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "fundingReference"
       *
       * @param fundingReference Items to add to the value of the "fundingReference" property
       */
      public DataCiteMetadata.FundingReferences.Builder<_B> addFundingReference(
          final Iterable<? extends DataCiteMetadata.FundingReferences.FundingReference>
              fundingReference) {
        if (fundingReference != null) {
          if (this.fundingReference == null) {
            this.fundingReference =
                new ArrayList<
                    DataCiteMetadata.FundingReferences.FundingReference.Builder<
                        DataCiteMetadata.FundingReferences.Builder<_B>>>();
          }
          for (DataCiteMetadata.FundingReferences.FundingReference _item : fundingReference) {
            this.fundingReference.add(
                new DataCiteMetadata.FundingReferences.FundingReference.Builder<
                    DataCiteMetadata.FundingReferences.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "fundingReference" (any previous value will be replaced)
       *
       * @param fundingReference New value of the "fundingReference" property.
       */
      public DataCiteMetadata.FundingReferences.Builder<_B> withFundingReference(
          final Iterable<? extends DataCiteMetadata.FundingReferences.FundingReference>
              fundingReference) {
        if (this.fundingReference != null) {
          this.fundingReference.clear();
        }
        return addFundingReference(fundingReference);
      }

      /**
       * Adds the given items to the value of "fundingReference"
       *
       * @param fundingReference Items to add to the value of the "fundingReference" property
       */
      public DataCiteMetadata.FundingReferences.Builder<_B> addFundingReference(
          DataCiteMetadata.FundingReferences.FundingReference... fundingReference) {
        addFundingReference(Arrays.asList(fundingReference));
        return this;
      }

      /**
       * Sets the new value of "fundingReference" (any previous value will be replaced)
       *
       * @param fundingReference New value of the "fundingReference" property.
       */
      public DataCiteMetadata.FundingReferences.Builder<_B> withFundingReference(
          DataCiteMetadata.FundingReferences.FundingReference... fundingReference) {
        withFundingReference(Arrays.asList(fundingReference));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "FundingReference" property. Use
       * {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.FundingReferences.FundingReference.Builder#end()}
       * to return to the current builder.
       *
       * @return a new builder to build an additional value of the "FundingReference" property. Use
       *     {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.FundingReferences.FundingReference.Builder#end()}
       *     to return to the current builder.
       */
      public DataCiteMetadata.FundingReferences.FundingReference.Builder<
              ? extends DataCiteMetadata.FundingReferences.Builder<_B>>
          addFundingReference() {
        if (this.fundingReference == null) {
          this.fundingReference =
              new ArrayList<
                  DataCiteMetadata.FundingReferences.FundingReference.Builder<
                      DataCiteMetadata.FundingReferences.Builder<_B>>>();
        }
        final DataCiteMetadata.FundingReferences.FundingReference.Builder<
                DataCiteMetadata.FundingReferences.Builder<_B>>
            fundingReference_Builder =
                new DataCiteMetadata.FundingReferences.FundingReference.Builder<
                    DataCiteMetadata.FundingReferences.Builder<_B>>(this, null, false);
        this.fundingReference.add(fundingReference_Builder);
        return fundingReference_Builder;
      }

      @Override
      public DataCiteMetadata.FundingReferences build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.FundingReferences());
        } else {
          return ((DataCiteMetadata.FundingReferences) _storedValue);
        }
      }

      public DataCiteMetadata.FundingReferences.Builder<_B> copyOf(
          final DataCiteMetadata.FundingReferences _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.FundingReferences.Builder<_B> copyOf(
          final DataCiteMetadata.FundingReferences.Builder _other) {
        return copyOf(_other.build());
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="funderName"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://datacite.org/schema/kernel-4}nonemptycontentStringType"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="funderIdentifier" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="funderIdentifierType" use="required" type="{http://datacite.org/schema/kernel-4}funderIdentifierType" /&gt;
     *                 &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="awardNumber" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="awardURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="awardTitle" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {})
    public static class FundingReference {

      @XmlElement(required = true)
      protected String funderName;

      protected DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
          funderIdentifier;
      protected DataCiteMetadata.FundingReferences.FundingReference.AwardNumber awardNumber;
      protected Object awardTitle;

      /**
       * Gets the value of the funderName property.
       *
       * @return possible object is {@link String }
       */
      public String getFunderName() {
        return funderName;
      }

      /**
       * Sets the value of the funderName property.
       *
       * @param value allowed object is {@link String }
       */
      public void setFunderName(String value) {
        this.funderName = value;
      }

      /**
       * Gets the value of the funderIdentifier property.
       *
       * @return possible object is {@link
       *     DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier }
       */
      public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
          getFunderIdentifier() {
        return funderIdentifier;
      }

      /**
       * Sets the value of the funderIdentifier property.
       *
       * @param value allowed object is {@link
       *     DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier }
       */
      public void setFunderIdentifier(
          DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier value) {
        this.funderIdentifier = value;
      }

      /**
       * Gets the value of the awardNumber property.
       *
       * @return possible object is {@link
       *     DataCiteMetadata.FundingReferences.FundingReference.AwardNumber }
       */
      public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber getAwardNumber() {
        return awardNumber;
      }

      /**
       * Sets the value of the awardNumber property.
       *
       * @param value allowed object is {@link
       *     DataCiteMetadata.FundingReferences.FundingReference.AwardNumber }
       */
      public void setAwardNumber(
          DataCiteMetadata.FundingReferences.FundingReference.AwardNumber value) {
        this.awardNumber = value;
      }

      /**
       * Gets the value of the awardTitle property.
       *
       * @return possible object is {@link Object }
       */
      public Object getAwardTitle() {
        return awardTitle;
      }

      /**
       * Sets the value of the awardTitle property.
       *
       * @param value allowed object is {@link Object }
       */
      public void setAwardTitle(Object value) {
        this.awardTitle = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> _other) {
        _other.funderName = this.funderName;
        _other.funderIdentifier =
            ((this.funderIdentifier == null) ? null : this.funderIdentifier.newCopyBuilder(_other));
        _other.awardNumber =
            ((this.awardNumber == null) ? null : this.awardNumber.newCopyBuilder(_other));
        _other.awardTitle = this.awardTitle;
      }

      public <_B> DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>(
            _parentBuilder, this, true);
      }

      public DataCiteMetadata.FundingReferences.FundingReference.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.FundingReferences.FundingReference.Builder<Void> builder() {
        return new DataCiteMetadata.FundingReferences.FundingReference.Builder<Void>(
            null, null, false);
      }

      public static <_B> DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> copyOf(
          final DataCiteMetadata.FundingReferences.FundingReference _other) {
        final DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> _newBuilder =
            new DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree funderNamePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("funderName"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (funderNamePropertyTree != null)
            : ((funderNamePropertyTree == null) || (!funderNamePropertyTree.isLeaf())))) {
          _other.funderName = this.funderName;
        }
        final PropertyTree funderIdentifierPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("funderIdentifier"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (funderIdentifierPropertyTree != null)
            : ((funderIdentifierPropertyTree == null)
                || (!funderIdentifierPropertyTree.isLeaf())))) {
          _other.funderIdentifier =
              ((this.funderIdentifier == null)
                  ? null
                  : this.funderIdentifier.newCopyBuilder(
                      _other, funderIdentifierPropertyTree, _propertyTreeUse));
        }
        final PropertyTree awardNumberPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("awardNumber"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (awardNumberPropertyTree != null)
            : ((awardNumberPropertyTree == null) || (!awardNumberPropertyTree.isLeaf())))) {
          _other.awardNumber =
              ((this.awardNumber == null)
                  ? null
                  : this.awardNumber.newCopyBuilder(
                      _other, awardNumberPropertyTree, _propertyTreeUse));
        }
        final PropertyTree awardTitlePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("awardTitle"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (awardTitlePropertyTree != null)
            : ((awardTitlePropertyTree == null) || (!awardTitlePropertyTree.isLeaf())))) {
          _other.awardTitle = this.awardTitle;
        }
      }

      public <_B> DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.FundingReferences.FundingReference.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> copyOf(
          final DataCiteMetadata.FundingReferences.FundingReference _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> _newBuilder =
            new DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.FundingReferences.FundingReference.Builder<Void> copyExcept(
          final DataCiteMetadata.FundingReferences.FundingReference _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.FundingReferences.FundingReference.Builder<Void> copyOnly(
          final DataCiteMetadata.FundingReferences.FundingReference _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", FundingReference.class.getSimpleName() + "[", "]")
            .add("funderName='" + funderName + "'")
            .add("funderIdentifier=" + funderIdentifier)
            .add("awardNumber=" + awardNumber)
            .add("awardTitle=" + awardTitle)
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundingReference that = (FundingReference) o;
        return Objects.equals(funderName, that.funderName)
            && Objects.equals(funderIdentifier, that.funderIdentifier)
            && Objects.equals(awardNumber, that.awardNumber)
            && Objects.equals(awardTitle, that.awardTitle);
      }

      @Override
      public int hashCode() {
        return Objects.hash(funderName, funderIdentifier, awardNumber, awardTitle);
      }

      /**
       * Java class for anonymous complex type.
       *
       * <p>The following schema fragment specifies the expected content contained within this
       * class.
       *
       * <pre>
       * &lt;complexType&gt;
       *   &lt;simpleContent&gt;
       *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
       *       &lt;attribute name="awardURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
       *     &lt;/extension&gt;
       *   &lt;/simpleContent&gt;
       * &lt;/complexType&gt;
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(
          name = "",
          propOrder = {"value"})
      public static class AwardNumber {

        @XmlValue protected String value;

        @XmlAttribute(name = "awardURI")
        @XmlSchemaType(name = "anyURI")
        protected String awardURI;

        /**
         * Gets the value of the value property.
         *
         * @return possible object is {@link String }
         */
        public String getValue() {
          return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is {@link String }
         */
        public void setValue(String value) {
          this.value = value;
        }

        /**
         * Gets the value of the awardURI property.
         *
         * @return possible object is {@link String }
         */
        public String getAwardURI() {
          return awardURI;
        }

        /**
         * Sets the value of the awardURI property.
         *
         * @param value allowed object is {@link String }
         */
        public void setAwardURI(String value) {
          this.awardURI = value;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>
                _other) {
          _other.value = this.value;
          _other.awardURI = this.awardURI;
        }

        public <_B>
            DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>
                newCopyBuilder(final _B _parentBuilder) {
          return new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>(
              _parentBuilder, this, true);
        }

        public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<Void>
            newCopyBuilder() {
          return newCopyBuilder(null);
        }

        public static DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<Void>
            builder() {
          return new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<Void>(
              null, null, false);
        }

        public static <_B>
            DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B> copyOf(
                final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber _other) {
          final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>
              _newBuilder =
                  new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>(
                      null, null, false);
          _other.copyTo(_newBuilder);
          return _newBuilder;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>
                _other,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          final PropertyTree valuePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("value"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (valuePropertyTree != null)
              : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
            _other.value = this.value;
          }
          final PropertyTree awardURIPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("awardURI"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (awardURIPropertyTree != null)
              : ((awardURIPropertyTree == null) || (!awardURIPropertyTree.isLeaf())))) {
            _other.awardURI = this.awardURI;
          }
        }

        public <_B>
            DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>
                newCopyBuilder(
                    final _B _parentBuilder,
                    final PropertyTree _propertyTree,
                    final PropertyTreeUse _propertyTreeUse) {
          return new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>(
              _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
        }

        public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<Void>
            newCopyBuilder(
                final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
          return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
        }

        public static <_B>
            DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B> copyOf(
                final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber _other,
                final PropertyTree _propertyTree,
                final PropertyTreeUse _propertyTreeUse) {
          final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>
              _newBuilder =
                  new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>(
                      null, null, false);
          _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
          return _newBuilder;
        }

        public static DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<Void>
            copyExcept(
                final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber _other,
                final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
        }

        public static DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<Void>
            copyOnly(
                final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber _other,
                final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
        }

        @Override
        public String toString() {
          return new StringJoiner(", ", AwardNumber.class.getSimpleName() + "[", "]")
              .add("value='" + value + "'")
              .add("awardURI='" + awardURI + "'")
              .toString();
        }

        @Override
        public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          AwardNumber that = (AwardNumber) o;
          return Objects.equals(value, that.value) && Objects.equals(awardURI, that.awardURI);
        }

        @Override
        public int hashCode() {
          return Objects.hash(value, awardURI);
        }

        public static class Builder<_B> implements Buildable {

          protected final _B _parentBuilder;
          protected final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber
              _storedValue;
          private String value;
          private String awardURI;

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber _other,
              final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                this.value = _other.value;
                this.awardURI = _other.awardURI;
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber _other,
              final boolean _copy,
              final PropertyTree _propertyTree,
              final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                final PropertyTree valuePropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("value"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (valuePropertyTree != null)
                    : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                  this.value = _other.value;
                }
                final PropertyTree awardURIPropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("awardURI"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (awardURIPropertyTree != null)
                    : ((awardURIPropertyTree == null) || (!awardURIPropertyTree.isLeaf())))) {
                  this.awardURI = _other.awardURI;
                }
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public _B end() {
            return this._parentBuilder;
          }

          protected <_P extends DataCiteMetadata.FundingReferences.FundingReference.AwardNumber>
              _P init(final _P _product) {
            _product.value = this.value;
            _product.awardURI = this.awardURI;
            return _product;
          }

          /**
           * Sets the new value of "value" (any previous value will be replaced)
           *
           * @param value New value of the "value" property.
           */
          public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>
              withValue(final String value) {
            this.value = value;
            return this;
          }

          /**
           * Sets the new value of "awardURI" (any previous value will be replaced)
           *
           * @param awardURI New value of the "awardURI" property.
           */
          public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B>
              withAwardURI(final String awardURI) {
            this.awardURI = awardURI;
            return this;
          }

          @Override
          public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber build() {
            if (_storedValue == null) {
              return this.init(
                  new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber());
            } else {
              return ((DataCiteMetadata.FundingReferences.FundingReference.AwardNumber)
                  _storedValue);
            }
          }

          public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B> copyOf(
              final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber _other) {
            _other.copyTo(this);
            return this;
          }

          public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<_B> copyOf(
              final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder
                  _other) {
            return copyOf(_other.build());
          }
        }

        public static class Select
            extends DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Select, Void> {

          Select() {
            super(null, null, null);
          }

          public static DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Select
              _root() {
            return new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Select();
          }
        }

        public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
            extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

          private com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                      TRoot, TParent>>
              value = null;
          private com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                      TRoot, TParent>>
              awardURI = null;

          public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
          }

          @Override
          public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.value != null) {
              products.put("value", this.value.init());
            }
            if (this.awardURI != null) {
              products.put("awardURI", this.awardURI.init());
            }
            return products;
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                      TRoot, TParent>>
              value() {
            return ((this.value == null)
                ? this.value =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                            TRoot, TParent>>(this._root, this, "value")
                : this.value);
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                      TRoot, TParent>>
              awardURI() {
            return ((this.awardURI == null)
                ? this.awardURI =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                            TRoot, TParent>>(this._root, this, "awardURI")
                : this.awardURI);
          }
        }
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.FundingReferences.FundingReference _storedValue;
        private String funderName;
        private DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
                DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>>
            funderIdentifier;
        private DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<
                DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>>
            awardNumber;
        private Object awardTitle;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.FundingReferences.FundingReference _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.funderName = _other.funderName;
              this.funderIdentifier =
                  ((_other.funderIdentifier == null)
                      ? null
                      : _other.funderIdentifier.newCopyBuilder(this));
              this.awardNumber =
                  ((_other.awardNumber == null) ? null : _other.awardNumber.newCopyBuilder(this));
              this.awardTitle = _other.awardTitle;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.FundingReferences.FundingReference _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree funderNamePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("funderName"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (funderNamePropertyTree != null)
                  : ((funderNamePropertyTree == null) || (!funderNamePropertyTree.isLeaf())))) {
                this.funderName = _other.funderName;
              }
              final PropertyTree funderIdentifierPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("funderIdentifier"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (funderIdentifierPropertyTree != null)
                  : ((funderIdentifierPropertyTree == null)
                      || (!funderIdentifierPropertyTree.isLeaf())))) {
                this.funderIdentifier =
                    ((_other.funderIdentifier == null)
                        ? null
                        : _other.funderIdentifier.newCopyBuilder(
                            this, funderIdentifierPropertyTree, _propertyTreeUse));
              }
              final PropertyTree awardNumberPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("awardNumber"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (awardNumberPropertyTree != null)
                  : ((awardNumberPropertyTree == null) || (!awardNumberPropertyTree.isLeaf())))) {
                this.awardNumber =
                    ((_other.awardNumber == null)
                        ? null
                        : _other.awardNumber.newCopyBuilder(
                            this, awardNumberPropertyTree, _propertyTreeUse));
              }
              final PropertyTree awardTitlePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("awardTitle"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (awardTitlePropertyTree != null)
                  : ((awardTitlePropertyTree == null) || (!awardTitlePropertyTree.isLeaf())))) {
                this.awardTitle = _other.awardTitle;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.FundingReferences.FundingReference> _P init(
            final _P _product) {
          _product.funderName = this.funderName;
          _product.funderIdentifier =
              ((this.funderIdentifier == null) ? null : this.funderIdentifier.build());
          _product.awardNumber = ((this.awardNumber == null) ? null : this.awardNumber.build());
          _product.awardTitle = this.awardTitle;
          return _product;
        }

        /**
         * Sets the new value of "funderName" (any previous value will be replaced)
         *
         * @param funderName New value of the "funderName" property.
         */
        public DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> withFunderName(
            final String funderName) {
          this.funderName = funderName;
          return this;
        }

        /**
         * Sets the new value of "funderIdentifier" (any previous value will be replaced)
         *
         * @param funderIdentifier New value of the "funderIdentifier" property.
         */
        public DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> withFunderIdentifier(
            final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
                funderIdentifier) {
          this.funderIdentifier =
              ((funderIdentifier == null)
                  ? null
                  : new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
                          .Builder<
                      DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>>(
                      this, funderIdentifier, false));
          return this;
        }

        /**
         * Returns the existing builder or a new builder to build the value of the
         * "funderIdentifier" property. Use {@link
         * org.gbif.doi.metadata.datacite.DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder#end()}
         * to return to the current builder.
         *
         * @return A new builder to build the value of the "funderIdentifier" property. Use {@link
         *     org.gbif.doi.metadata.datacite.DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder#end()}
         *     to return to the current builder.
         */
        public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
                ? extends DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>>
            withFunderIdentifier() {
          if (this.funderIdentifier != null) {
            return this.funderIdentifier;
          }
          return this.funderIdentifier =
              new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
                  DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>>(
                  this, null, false);
        }

        /**
         * Sets the new value of "awardNumber" (any previous value will be replaced)
         *
         * @param awardNumber New value of the "awardNumber" property.
         */
        public DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> withAwardNumber(
            final DataCiteMetadata.FundingReferences.FundingReference.AwardNumber awardNumber) {
          this.awardNumber =
              ((awardNumber == null)
                  ? null
                  : new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<
                      DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>>(
                      this, awardNumber, false));
          return this;
        }

        /**
         * Returns the existing builder or a new builder to build the value of the "awardNumber"
         * property. Use {@link
         * org.gbif.doi.metadata.datacite.DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder#end()}
         * to return to the current builder.
         *
         * @return A new builder to build the value of the "awardNumber" property. Use {@link
         *     org.gbif.doi.metadata.datacite.DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder#end()}
         *     to return to the current builder.
         */
        public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<
                ? extends DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>>
            withAwardNumber() {
          if (this.awardNumber != null) {
            return this.awardNumber;
          }
          return this.awardNumber =
              new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Builder<
                  DataCiteMetadata.FundingReferences.FundingReference.Builder<_B>>(
                  this, null, false);
        }

        /**
         * Sets the new value of "awardTitle" (any previous value will be replaced)
         *
         * @param awardTitle New value of the "awardTitle" property.
         */
        public DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> withAwardTitle(
            final Object awardTitle) {
          this.awardTitle = awardTitle;
          return this;
        }

        @Override
        public DataCiteMetadata.FundingReferences.FundingReference build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.FundingReferences.FundingReference());
          } else {
            return ((DataCiteMetadata.FundingReferences.FundingReference) _storedValue);
          }
        }

        public DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> copyOf(
            final DataCiteMetadata.FundingReferences.FundingReference _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.FundingReferences.FundingReference.Builder<_B> copyOf(
            final DataCiteMetadata.FundingReferences.FundingReference.Builder _other) {
          return copyOf(_other.build());
        }
      }

      /**
       * Java class for anonymous complex type.
       *
       * <p>The following schema fragment specifies the expected content contained within this
       * class.
       *
       * <pre>
       * &lt;complexType&gt;
       *   &lt;simpleContent&gt;
       *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
       *       &lt;attribute name="funderIdentifierType" use="required" type="{http://datacite.org/schema/kernel-4}funderIdentifierType" /&gt;
       *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
       *     &lt;/extension&gt;
       *   &lt;/simpleContent&gt;
       * &lt;/complexType&gt;
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(
          name = "",
          propOrder = {"value"})
      public static class FunderIdentifier {

        @XmlValue protected String value;

        @XmlAttribute(name = "funderIdentifierType", required = true)
        protected FunderIdentifierType funderIdentifierType;

        @XmlAttribute(name = "schemeURI")
        @XmlSchemaType(name = "anyURI")
        protected String schemeURI;

        /**
         * Gets the value of the value property.
         *
         * @return possible object is {@link String }
         */
        public String getValue() {
          return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is {@link String }
         */
        public void setValue(String value) {
          this.value = value;
        }

        /**
         * Gets the value of the funderIdentifierType property.
         *
         * @return possible object is {@link FunderIdentifierType }
         */
        public FunderIdentifierType getFunderIdentifierType() {
          return funderIdentifierType;
        }

        /**
         * Sets the value of the funderIdentifierType property.
         *
         * @param value allowed object is {@link FunderIdentifierType }
         */
        public void setFunderIdentifierType(FunderIdentifierType value) {
          this.funderIdentifierType = value;
        }

        /**
         * Gets the value of the schemeURI property.
         *
         * @return possible object is {@link String }
         */
        public String getSchemeURI() {
          return schemeURI;
        }

        /**
         * Sets the value of the schemeURI property.
         *
         * @param value allowed object is {@link String }
         */
        public void setSchemeURI(String value) {
          this.schemeURI = value;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
                _other) {
          _other.value = this.value;
          _other.funderIdentifierType = this.funderIdentifierType;
          _other.schemeURI = this.schemeURI;
        }

        public <_B>
            DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
                newCopyBuilder(final _B _parentBuilder) {
          return new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
              _B>(_parentBuilder, this, true);
        }

        public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<Void>
            newCopyBuilder() {
          return newCopyBuilder(null);
        }

        public static DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
                Void>
            builder() {
          return new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
              Void>(null, null, false);
        }

        public static <_B>
            DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B> copyOf(
                final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier _other) {
          final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
              _newBuilder =
                  new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
                      _B>(null, null, false);
          _other.copyTo(_newBuilder);
          return _newBuilder;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
                _other,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          final PropertyTree valuePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("value"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (valuePropertyTree != null)
              : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
            _other.value = this.value;
          }
          final PropertyTree funderIdentifierTypePropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("funderIdentifierType"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (funderIdentifierTypePropertyTree != null)
              : ((funderIdentifierTypePropertyTree == null)
                  || (!funderIdentifierTypePropertyTree.isLeaf())))) {
            _other.funderIdentifierType = this.funderIdentifierType;
          }
          final PropertyTree schemeURIPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (schemeURIPropertyTree != null)
              : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
            _other.schemeURI = this.schemeURI;
          }
        }

        public <_B>
            DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
                newCopyBuilder(
                    final _B _parentBuilder,
                    final PropertyTree _propertyTree,
                    final PropertyTreeUse _propertyTreeUse) {
          return new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
              _B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
        }

        public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<Void>
            newCopyBuilder(
                final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
          return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
        }

        public static <_B>
            DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B> copyOf(
                final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier _other,
                final PropertyTree _propertyTree,
                final PropertyTreeUse _propertyTreeUse) {
          final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
              _newBuilder =
                  new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
                      _B>(null, null, false);
          _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
          return _newBuilder;
        }

        public static DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
                Void>
            copyExcept(
                final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier _other,
                final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
        }

        public static DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<
                Void>
            copyOnly(
                final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier _other,
                final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
        }

        @Override
        public String toString() {
          return new StringJoiner(", ", FunderIdentifier.class.getSimpleName() + "[", "]")
              .add("value='" + value + "'")
              .add("funderIdentifierType=" + funderIdentifierType)
              .add("schemeURI='" + schemeURI + "'")
              .toString();
        }

        @Override
        public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          FunderIdentifier that = (FunderIdentifier) o;
          return Objects.equals(value, that.value)
              && funderIdentifierType == that.funderIdentifierType
              && Objects.equals(schemeURI, that.schemeURI);
        }

        @Override
        public int hashCode() {
          return Objects.hash(value, funderIdentifierType, schemeURI);
        }

        public static class Builder<_B> implements Buildable {

          protected final _B _parentBuilder;
          protected final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
              _storedValue;
          private String value;
          private FunderIdentifierType funderIdentifierType;
          private String schemeURI;

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier _other,
              final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                this.value = _other.value;
                this.funderIdentifierType = _other.funderIdentifierType;
                this.schemeURI = _other.schemeURI;
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier _other,
              final boolean _copy,
              final PropertyTree _propertyTree,
              final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                final PropertyTree valuePropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("value"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (valuePropertyTree != null)
                    : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                  this.value = _other.value;
                }
                final PropertyTree funderIdentifierTypePropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("funderIdentifierType"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (funderIdentifierTypePropertyTree != null)
                    : ((funderIdentifierTypePropertyTree == null)
                        || (!funderIdentifierTypePropertyTree.isLeaf())))) {
                  this.funderIdentifierType = _other.funderIdentifierType;
                }
                final PropertyTree schemeURIPropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (schemeURIPropertyTree != null)
                    : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
                  this.schemeURI = _other.schemeURI;
                }
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public _B end() {
            return this._parentBuilder;
          }

          protected <
                  _P extends DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier>
              _P init(final _P _product) {
            _product.value = this.value;
            _product.funderIdentifierType = this.funderIdentifierType;
            _product.schemeURI = this.schemeURI;
            return _product;
          }

          /**
           * Sets the new value of "value" (any previous value will be replaced)
           *
           * @param value New value of the "value" property.
           */
          public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
              withValue(final String value) {
            this.value = value;
            return this;
          }

          /**
           * Sets the new value of "funderIdentifierType" (any previous value will be replaced)
           *
           * @param funderIdentifierType New value of the "funderIdentifierType" property.
           */
          public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
              withFunderIdentifierType(final FunderIdentifierType funderIdentifierType) {
            this.funderIdentifierType = funderIdentifierType;
            return this;
          }

          /**
           * Sets the new value of "schemeURI" (any previous value will be replaced)
           *
           * @param schemeURI New value of the "schemeURI" property.
           */
          public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
              withSchemeURI(final String schemeURI) {
            this.schemeURI = schemeURI;
            return this;
          }

          @Override
          public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier build() {
            if (_storedValue == null) {
              return this.init(
                  new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier());
            } else {
              return ((DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier)
                  _storedValue);
            }
          }

          public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
              copyOf(
                  final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
                      _other) {
            _other.copyTo(this);
            return this;
          }

          public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder<_B>
              copyOf(
                  final DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Builder
                      _other) {
            return copyOf(_other.build());
          }
        }

        public static class Select
            extends DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Select, Void> {

          Select() {
            super(null, null, null);
          }

          public static DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Select
              _root() {
            return new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
                .Select();
          }
        }

        public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
            extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

          private com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                      TRoot, TParent>>
              value = null;
          private com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                      TRoot, TParent>>
              funderIdentifierType = null;
          private com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                      TRoot, TParent>>
              schemeURI = null;

          public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
          }

          @Override
          public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.value != null) {
              products.put("value", this.value.init());
            }
            if (this.funderIdentifierType != null) {
              products.put("funderIdentifierType", this.funderIdentifierType.init());
            }
            if (this.schemeURI != null) {
              products.put("schemeURI", this.schemeURI.init());
            }
            return products;
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                      TRoot, TParent>>
              value() {
            return ((this.value == null)
                ? this.value =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
                                .Selector<
                            TRoot, TParent>>(this._root, this, "value")
                : this.value);
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                      TRoot, TParent>>
              funderIdentifierType() {
            return ((this.funderIdentifierType == null)
                ? this.funderIdentifierType =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
                                .Selector<
                            TRoot, TParent>>(this._root, this, "funderIdentifierType")
                : this.funderIdentifierType);
          }

          public com.kscs.util.jaxb.Selector<
                  TRoot,
                  DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                      TRoot, TParent>>
              schemeURI() {
            return ((this.schemeURI == null)
                ? this.schemeURI =
                    new com.kscs.util.jaxb.Selector<
                        TRoot,
                        DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier
                                .Selector<
                            TRoot, TParent>>(this._root, this, "schemeURI")
                : this.schemeURI);
          }
        }
      }

      public static class Select
          extends DataCiteMetadata.FundingReferences.FundingReference.Selector<
              DataCiteMetadata.FundingReferences.FundingReference.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.FundingReferences.FundingReference.Select _root() {
          return new DataCiteMetadata.FundingReferences.FundingReference.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>
            funderName = null;
        private DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                TRoot, DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>
            funderIdentifier = null;
        private DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                TRoot, DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>
            awardNumber = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>
            awardTitle = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.funderName != null) {
            products.put("funderName", this.funderName.init());
          }
          if (this.funderIdentifier != null) {
            products.put("funderIdentifier", this.funderIdentifier.init());
          }
          if (this.awardNumber != null) {
            products.put("awardNumber", this.awardNumber.init());
          }
          if (this.awardTitle != null) {
            products.put("awardTitle", this.awardTitle.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>
            funderName() {
          return ((this.funderName == null)
              ? this.funderName =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>(
                      this._root, this, "funderName")
              : this.funderName);
        }

        public DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                TRoot, DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>
            funderIdentifier() {
          return ((this.funderIdentifier == null)
              ? this.funderIdentifier =
                  new DataCiteMetadata.FundingReferences.FundingReference.FunderIdentifier.Selector<
                      TRoot,
                      DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>(
                      this._root, this, "funderIdentifier")
              : this.funderIdentifier);
        }

        public DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                TRoot, DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>
            awardNumber() {
          return ((this.awardNumber == null)
              ? this.awardNumber =
                  new DataCiteMetadata.FundingReferences.FundingReference.AwardNumber.Selector<
                      TRoot,
                      DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>(
                      this._root, this, "awardNumber")
              : this.awardNumber);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>
            awardTitle() {
          return ((this.awardTitle == null)
              ? this.awardTitle =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.FundingReferences.FundingReference.Selector<TRoot, TParent>>(
                      this._root, this, "awardTitle")
              : this.awardTitle);
        }
      }
    }

    public static class Select
        extends DataCiteMetadata.FundingReferences.Selector<
            DataCiteMetadata.FundingReferences.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.FundingReferences.Select _root() {
        return new DataCiteMetadata.FundingReferences.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.FundingReferences.FundingReference.Selector<
              TRoot, DataCiteMetadata.FundingReferences.Selector<TRoot, TParent>>
          fundingReference = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.fundingReference != null) {
          products.put("fundingReference", this.fundingReference.init());
        }
        return products;
      }

      public DataCiteMetadata.FundingReferences.FundingReference.Selector<
              TRoot, DataCiteMetadata.FundingReferences.Selector<TRoot, TParent>>
          fundingReference() {
        return ((this.fundingReference == null)
            ? this.fundingReference =
                new DataCiteMetadata.FundingReferences.FundingReference.Selector<
                    TRoot, DataCiteMetadata.FundingReferences.Selector<TRoot, TParent>>(
                    this._root, this, "fundingReference")
            : this.fundingReference);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="geoLocation" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;complexContent&gt;
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *                 &lt;choice maxOccurs="unbounded"&gt;
   *                   &lt;element name="geoLocationPlace" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
   *                   &lt;element name="geoLocationPoint" type="{http://datacite.org/schema/kernel-4}point" minOccurs="0"/&gt;
   *                   &lt;element name="geoLocationBox" type="{http://datacite.org/schema/kernel-4}box" minOccurs="0"/&gt;
   *                   &lt;element name="geoLocationPolygon" maxOccurs="unbounded" minOccurs="0"&gt;
   *                     &lt;complexType&gt;
   *                       &lt;complexContent&gt;
   *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *                           &lt;sequence&gt;
   *                             &lt;element name="polygonPoint" type="{http://datacite.org/schema/kernel-4}point" maxOccurs="unbounded" minOccurs="4"/&gt;
   *                             &lt;element name="inPolygonPoint" type="{http://datacite.org/schema/kernel-4}point" minOccurs="0"/&gt;
   *                           &lt;/sequence&gt;
   *                         &lt;/restriction&gt;
   *                       &lt;/complexContent&gt;
   *                     &lt;/complexType&gt;
   *                   &lt;/element&gt;
   *                 &lt;/choice&gt;
   *               &lt;/restriction&gt;
   *             &lt;/complexContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"geoLocation"})
  public static class GeoLocations {

    protected List<DataCiteMetadata.GeoLocations.GeoLocation> geoLocation;

    /**
     * Gets the value of the geoLocation property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the geoLocation property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getGeoLocation().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.GeoLocations.GeoLocation }
     */
    public List<DataCiteMetadata.GeoLocations.GeoLocation> getGeoLocation() {
      if (geoLocation == null) {
        geoLocation = new ArrayList<DataCiteMetadata.GeoLocations.GeoLocation>();
      }
      return this.geoLocation;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.GeoLocations.Builder<_B> _other) {
      if (this.geoLocation == null) {
        _other.geoLocation = null;
      } else {
        _other.geoLocation =
            new ArrayList<
                DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                    DataCiteMetadata.GeoLocations.Builder<_B>>>();
        for (DataCiteMetadata.GeoLocations.GeoLocation _item : this.geoLocation) {
          _other.geoLocation.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.GeoLocations.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.GeoLocations.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.GeoLocations.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.GeoLocations.Builder<Void> builder() {
      return new DataCiteMetadata.GeoLocations.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.GeoLocations.Builder<_B> copyOf(
        final DataCiteMetadata.GeoLocations _other) {
      final DataCiteMetadata.GeoLocations.Builder<_B> _newBuilder =
          new DataCiteMetadata.GeoLocations.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.GeoLocations.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree geoLocationPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("geoLocation"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (geoLocationPropertyTree != null)
          : ((geoLocationPropertyTree == null) || (!geoLocationPropertyTree.isLeaf())))) {
        if (this.geoLocation == null) {
          _other.geoLocation = null;
        } else {
          _other.geoLocation =
              new ArrayList<
                  DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                      DataCiteMetadata.GeoLocations.Builder<_B>>>();
          for (DataCiteMetadata.GeoLocations.GeoLocation _item : this.geoLocation) {
            _other.geoLocation.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(_other, geoLocationPropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.GeoLocations.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.GeoLocations.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.GeoLocations.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.GeoLocations.Builder<_B> copyOf(
        final DataCiteMetadata.GeoLocations _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.GeoLocations.Builder<_B> _newBuilder =
          new DataCiteMetadata.GeoLocations.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.GeoLocations.Builder<Void> copyExcept(
        final DataCiteMetadata.GeoLocations _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.GeoLocations.Builder<Void> copyOnly(
        final DataCiteMetadata.GeoLocations _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", GeoLocations.class.getSimpleName() + "[", "]")
          .add("geoLocation=" + geoLocation)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      GeoLocations that = (GeoLocations) o;
      return Objects.equals(geoLocation, that.geoLocation);
    }

    @Override
    public int hashCode() {
      return Objects.hash(geoLocation);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.GeoLocations _storedValue;
      private List<
              DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                  DataCiteMetadata.GeoLocations.Builder<_B>>>
          geoLocation;

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.GeoLocations _other,
          final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.geoLocation == null) {
              this.geoLocation = null;
            } else {
              this.geoLocation =
                  new ArrayList<
                      DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                          DataCiteMetadata.GeoLocations.Builder<_B>>>();
              for (DataCiteMetadata.GeoLocations.GeoLocation _item : _other.geoLocation) {
                this.geoLocation.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.GeoLocations _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree geoLocationPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("geoLocation"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (geoLocationPropertyTree != null)
                : ((geoLocationPropertyTree == null) || (!geoLocationPropertyTree.isLeaf())))) {
              if (_other.geoLocation == null) {
                this.geoLocation = null;
              } else {
                this.geoLocation =
                    new ArrayList<
                        DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                            DataCiteMetadata.GeoLocations.Builder<_B>>>();
                for (DataCiteMetadata.GeoLocations.GeoLocation _item : _other.geoLocation) {
                  this.geoLocation.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(this, geoLocationPropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.GeoLocations> _P init(final _P _product) {
        if (this.geoLocation != null) {
          final List<DataCiteMetadata.GeoLocations.GeoLocation> geoLocation =
              new ArrayList<DataCiteMetadata.GeoLocations.GeoLocation>(this.geoLocation.size());
          for (DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                  DataCiteMetadata.GeoLocations.Builder<_B>>
              _item : this.geoLocation) {
            geoLocation.add(_item.build());
          }
          _product.geoLocation = geoLocation;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "geoLocation"
       *
       * @param geoLocation Items to add to the value of the "geoLocation" property
       */
      public DataCiteMetadata.GeoLocations.Builder<_B> addGeoLocation(
          final Iterable<? extends DataCiteMetadata.GeoLocations.GeoLocation> geoLocation) {
        if (geoLocation != null) {
          if (this.geoLocation == null) {
            this.geoLocation =
                new ArrayList<
                    DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                        DataCiteMetadata.GeoLocations.Builder<_B>>>();
          }
          for (DataCiteMetadata.GeoLocations.GeoLocation _item : geoLocation) {
            this.geoLocation.add(
                new DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                    DataCiteMetadata.GeoLocations.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "geoLocation" (any previous value will be replaced)
       *
       * @param geoLocation New value of the "geoLocation" property.
       */
      public DataCiteMetadata.GeoLocations.Builder<_B> withGeoLocation(
          final Iterable<? extends DataCiteMetadata.GeoLocations.GeoLocation> geoLocation) {
        if (this.geoLocation != null) {
          this.geoLocation.clear();
        }
        return addGeoLocation(geoLocation);
      }

      /**
       * Adds the given items to the value of "geoLocation"
       *
       * @param geoLocation Items to add to the value of the "geoLocation" property
       */
      public DataCiteMetadata.GeoLocations.Builder<_B> addGeoLocation(
          DataCiteMetadata.GeoLocations.GeoLocation... geoLocation) {
        addGeoLocation(Arrays.asList(geoLocation));
        return this;
      }

      /**
       * Sets the new value of "geoLocation" (any previous value will be replaced)
       *
       * @param geoLocation New value of the "geoLocation" property.
       */
      public DataCiteMetadata.GeoLocations.Builder<_B> withGeoLocation(
          DataCiteMetadata.GeoLocations.GeoLocation... geoLocation) {
        withGeoLocation(Arrays.asList(geoLocation));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "GeoLocation" property. Use
       * {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations.GeoLocation.Builder#end()} to
       * return to the current builder.
       *
       * @return a new builder to build an additional value of the "GeoLocation" property. Use
       *     {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations.GeoLocation.Builder#end()}
       *     to return to the current builder.
       */
      public DataCiteMetadata.GeoLocations.GeoLocation.Builder<
              ? extends DataCiteMetadata.GeoLocations.Builder<_B>>
          addGeoLocation() {
        if (this.geoLocation == null) {
          this.geoLocation =
              new ArrayList<
                  DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                      DataCiteMetadata.GeoLocations.Builder<_B>>>();
        }
        final DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                DataCiteMetadata.GeoLocations.Builder<_B>>
            geoLocation_Builder =
                new DataCiteMetadata.GeoLocations.GeoLocation.Builder<
                    DataCiteMetadata.GeoLocations.Builder<_B>>(this, null, false);
        this.geoLocation.add(geoLocation_Builder);
        return geoLocation_Builder;
      }

      @Override
      public DataCiteMetadata.GeoLocations build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.GeoLocations());
        } else {
          return ((DataCiteMetadata.GeoLocations) _storedValue);
        }
      }

      public DataCiteMetadata.GeoLocations.Builder<_B> copyOf(
          final DataCiteMetadata.GeoLocations _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.GeoLocations.Builder<_B> copyOf(
          final DataCiteMetadata.GeoLocations.Builder _other) {
        return copyOf(_other.build());
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice maxOccurs="unbounded"&gt;
     *         &lt;element name="geoLocationPlace" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
     *         &lt;element name="geoLocationPoint" type="{http://datacite.org/schema/kernel-4}point" minOccurs="0"/&gt;
     *         &lt;element name="geoLocationBox" type="{http://datacite.org/schema/kernel-4}box" minOccurs="0"/&gt;
     *         &lt;element name="geoLocationPolygon" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="polygonPoint" type="{http://datacite.org/schema/kernel-4}point" maxOccurs="unbounded" minOccurs="4"/&gt;
     *                   &lt;element name="inPolygonPoint" type="{http://datacite.org/schema/kernel-4}point" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"geoLocationPlaceOrGeoLocationPointOrGeoLocationBox"})
    public static class GeoLocation {

      @XmlElements({
        @XmlElement(name = "geoLocationPlace"),
        @XmlElement(name = "geoLocationPoint", type = Point.class),
        @XmlElement(name = "geoLocationBox", type = Box.class),
        @XmlElement(
            name = "geoLocationPolygon",
            type = DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.class)
      })
      protected List<Object> geoLocationPlaceOrGeoLocationPointOrGeoLocationBox;

      /**
       * Gets the value of the geoLocationPlaceOrGeoLocationPointOrGeoLocationBox property.
       *
       * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
       * modification you make to the returned list will be present inside the JAXB object. This is
       * why there is not a <CODE>set</CODE> method for the
       * geoLocationPlaceOrGeoLocationPointOrGeoLocationBox property.
       *
       * <p>For example, to add a new item, do as follows:
       *
       * <pre>
       *    getGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox().add(newItem);
       * </pre>
       *
       * <p>Objects of the following type(s) are allowed in the list {@link Object } {@link Point }
       * {@link Box } {@link DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon }
       */
      public List<Object> getGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox() {
        if (geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
          geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Object>();
        }
        return this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(final DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> _other) {
        if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
          _other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = null;
        } else {
          _other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
          for (Object _item : this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
            _other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(
                ((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
          }
        }
      }

      public <_B> DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>(
            _parentBuilder, this, true);
      }

      public DataCiteMetadata.GeoLocations.GeoLocation.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.GeoLocations.GeoLocation.Builder<Void> builder() {
        return new DataCiteMetadata.GeoLocations.GeoLocation.Builder<Void>(null, null, false);
      }

      public static <_B> DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> copyOf(
          final DataCiteMetadata.GeoLocations.GeoLocation _other) {
        final DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> _newBuilder =
            new DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree geoLocationPlaceOrGeoLocationPointOrGeoLocationBoxPropertyTree =
            ((_propertyTree == null)
                ? null
                : _propertyTree.get("geoLocationPlaceOrGeoLocationPointOrGeoLocationBox"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (geoLocationPlaceOrGeoLocationPointOrGeoLocationBoxPropertyTree != null)
            : ((geoLocationPlaceOrGeoLocationPointOrGeoLocationBoxPropertyTree == null)
                || (!geoLocationPlaceOrGeoLocationPointOrGeoLocationBoxPropertyTree.isLeaf())))) {
          if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
            _other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = null;
          } else {
            _other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
            for (Object _item : this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
              _other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(
                  ((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
            }
          }
        }
      }

      public <_B> DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.GeoLocations.GeoLocation.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> copyOf(
          final DataCiteMetadata.GeoLocations.GeoLocation _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> _newBuilder =
            new DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.GeoLocations.GeoLocation.Builder<Void> copyExcept(
          final DataCiteMetadata.GeoLocations.GeoLocation _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.GeoLocations.GeoLocation.Builder<Void> copyOnly(
          final DataCiteMetadata.GeoLocations.GeoLocation _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", GeoLocation.class.getSimpleName() + "[", "]")
            .add(
                "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox="
                    + geoLocationPlaceOrGeoLocationPointOrGeoLocationBox)
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoLocation that = (GeoLocation) o;
        return Objects.equals(
            geoLocationPlaceOrGeoLocationPointOrGeoLocationBox,
            that.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox);
      }

      @Override
      public int hashCode() {
        return Objects.hash(geoLocationPlaceOrGeoLocationPointOrGeoLocationBox);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.GeoLocations.GeoLocation _storedValue;
        private List<Buildable> geoLocationPlaceOrGeoLocationPointOrGeoLocationBox;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.GeoLocations.GeoLocation _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              if (_other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
                this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = null;
              } else {
                this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox =
                    new ArrayList<Buildable>();
                for (Object _item : _other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
                  this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(
                      ((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
                }
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.GeoLocations.GeoLocation _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree geoLocationPlaceOrGeoLocationPointOrGeoLocationBoxPropertyTree =
                  ((_propertyTree == null)
                      ? null
                      : _propertyTree.get("geoLocationPlaceOrGeoLocationPointOrGeoLocationBox"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (geoLocationPlaceOrGeoLocationPointOrGeoLocationBoxPropertyTree != null)
                  : ((geoLocationPlaceOrGeoLocationPointOrGeoLocationBoxPropertyTree == null)
                      || (!geoLocationPlaceOrGeoLocationPointOrGeoLocationBoxPropertyTree
                          .isLeaf())))) {
                if (_other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
                  this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = null;
                } else {
                  this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox =
                      new ArrayList<Buildable>();
                  for (Object _item : _other.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
                    this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(
                        ((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
                  }
                }
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.GeoLocations.GeoLocation> _P init(
            final _P _product) {
          if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox != null) {
            final List<Object> geoLocationPlaceOrGeoLocationPointOrGeoLocationBox =
                new ArrayList<Object>(
                    this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.size());
            for (Buildable _item : this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
              geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(((Object) _item.build()));
            }
            _product.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox =
                geoLocationPlaceOrGeoLocationPointOrGeoLocationBox;
          }
          return _product;
        }

        /**
         * Adds the given items to the value of "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox"
         *
         * @param geoLocationPlaceOrGeoLocationPointOrGeoLocationBox Items to add to the value of
         *     the "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox" property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>
            addGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox(
                final Iterable<?> geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
          if (geoLocationPlaceOrGeoLocationPointOrGeoLocationBox != null) {
            if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
              this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
            }
            for (Object _item : geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
              this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(
                  new Buildable.PrimitiveBuildable(_item));
            }
          }
          return this;
        }

        /**
         * Sets the new value of "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox" (any previous
         * value will be replaced)
         *
         * @param geoLocationPlaceOrGeoLocationPointOrGeoLocationBox New value of the
         *     "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox" property.
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>
            withGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox(
                final Iterable<?> geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
          if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox != null) {
            this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.clear();
          }
          return addGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox(
              geoLocationPlaceOrGeoLocationPointOrGeoLocationBox);
        }

        /**
         * Adds the given items to the value of "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox"
         *
         * @param geoLocationPlaceOrGeoLocationPointOrGeoLocationBox Items to add to the value of
         *     the "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox" property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>
            addGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox(
                Object... geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
          addGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox(
              Arrays.asList(geoLocationPlaceOrGeoLocationPointOrGeoLocationBox));
          return this;
        }

        /**
         * Sets the new value of "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox" (any previous
         * value will be replaced)
         *
         * @param geoLocationPlaceOrGeoLocationPointOrGeoLocationBox New value of the
         *     "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox" property.
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>
            withGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox(
                Object... geoLocationPlaceOrGeoLocationPointOrGeoLocationBox) {
          withGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox(
              Arrays.asList(geoLocationPlaceOrGeoLocationPointOrGeoLocationBox));
          return this;
        }

        /**
         * Adds the given items to the value of "geoLocationPlace_"
         *
         * @param geoLocationPlace_ Items to add to the value of the "geoLocationPlace_" property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> addGeoLocationPlace(
            final Iterable<?> geoLocationPlace_) {
          return addGeoLocationPlaceOrGeoLocationPointOrGeoLocationBox(geoLocationPlace_);
        }

        /**
         * Adds the given items to the value of "geoLocationPlace_"
         *
         * @param geoLocationPlace_ Items to add to the value of the "geoLocationPlace_" property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> addGeoLocationPlace(
            Object... geoLocationPlace_) {
          return addGeoLocationPlace(Arrays.asList(geoLocationPlace_));
        }

        /**
         * Adds the given items to the value of "geoLocationPoint_"
         *
         * @param geoLocationPoint_ Items to add to the value of the "geoLocationPoint_" property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> addGeoLocationPoint(
            final Iterable<? extends Point> geoLocationPoint_) {
          if (geoLocationPoint_ != null) {
            if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
              this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
            }
            for (Point _item : geoLocationPoint_) {
              this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(
                  new Point.Builder<DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>(
                      this, _item, false));
            }
          }
          return this;
        }

        /**
         * Adds the given items to the value of "geoLocationPoint_"
         *
         * @param geoLocationPoint_ Items to add to the value of the "geoLocationPoint_" property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> addGeoLocationPoint(
            Point... geoLocationPoint_) {
          return addGeoLocationPoint(Arrays.asList(geoLocationPoint_));
        }

        /**
         * Returns a new builder to build an additional value of the "geoLocationPoint" property.
         * Use {@link org.gbif.doi.metadata.datacite.Point.Builder#end()} to return to the current
         * builder.
         *
         * @return a new builder to build an additional value of the "geoLocationPoint" property.
         *     Use {@link org.gbif.doi.metadata.datacite.Point.Builder#end()} to return to the
         *     current builder.
         */
        public Point.Builder<? extends DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>
            addGeoLocationPoint() {
          if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
            this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
          }
          final Point.Builder<DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>
              geoLocationPoint_Builder =
                  new Point.Builder<DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>(
                      this, null, false);
          this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(geoLocationPoint_Builder);
          return geoLocationPoint_Builder;
        }

        /**
         * Adds the given items to the value of "geoLocationBox_"
         *
         * @param geoLocationBox_ Items to add to the value of the "geoLocationBox_" property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> addGeoLocationBox(
            final Iterable<? extends Box> geoLocationBox_) {
          if (geoLocationBox_ != null) {
            if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
              this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
            }
            for (Box _item : geoLocationBox_) {
              this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(
                  new Box.Builder<DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>(
                      this, _item, false));
            }
          }
          return this;
        }

        /**
         * Adds the given items to the value of "geoLocationBox_"
         *
         * @param geoLocationBox_ Items to add to the value of the "geoLocationBox_" property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> addGeoLocationBox(
            Box... geoLocationBox_) {
          return addGeoLocationBox(Arrays.asList(geoLocationBox_));
        }

        /**
         * Returns a new builder to build an additional value of the "geoLocationBox" property. Use
         * {@link org.gbif.doi.metadata.datacite.Box.Builder#end()} to return to the current
         * builder.
         *
         * @return a new builder to build an additional value of the "geoLocationBox" property. Use
         *     {@link org.gbif.doi.metadata.datacite.Box.Builder#end()} to return to the current
         *     builder.
         */
        public Box.Builder<? extends DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>
            addGeoLocationBox() {
          if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
            this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
          }
          final Box.Builder<DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>
              geoLocationBox_Builder =
                  new Box.Builder<DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>(
                      this, null, false);
          this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(geoLocationBox_Builder);
          return geoLocationBox_Builder;
        }

        /**
         * Adds the given items to the value of "geoLocationPolygon_"
         *
         * @param geoLocationPolygon_ Items to add to the value of the "geoLocationPolygon_"
         *     property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> addGeoLocationPolygon(
            final Iterable<? extends DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon>
                geoLocationPolygon_) {
          if (geoLocationPolygon_ != null) {
            if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
              this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
            }
            for (DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _item :
                geoLocationPolygon_) {
              this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(
                  new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                      DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>(this, _item, false));
            }
          }
          return this;
        }

        /**
         * Adds the given items to the value of "geoLocationPolygon_"
         *
         * @param geoLocationPolygon_ Items to add to the value of the "geoLocationPolygon_"
         *     property
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> addGeoLocationPolygon(
            DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon... geoLocationPolygon_) {
          return addGeoLocationPolygon(Arrays.asList(geoLocationPolygon_));
        }

        /**
         * Returns a new builder to build an additional value of the "geoLocationPolygon" property.
         * Use {@link
         * org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder#end()}
         * to return to the current builder.
         *
         * @return a new builder to build an additional value of the "geoLocationPolygon" property.
         *     Use {@link
         *     org.gbif.doi.metadata.datacite.DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder#end()}
         *     to return to the current builder.
         */
        public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                ? extends DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>
            addGeoLocationPolygon() {
          if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null) {
            this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = new ArrayList<Buildable>();
          }
          final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                  DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>
              geoLocationPolygon_Builder =
                  new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                      DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B>>(this, null, false);
          this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.add(geoLocationPolygon_Builder);
          return geoLocationPolygon_Builder;
        }

        @Override
        public DataCiteMetadata.GeoLocations.GeoLocation build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.GeoLocations.GeoLocation());
          } else {
            return ((DataCiteMetadata.GeoLocations.GeoLocation) _storedValue);
          }
        }

        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> copyOf(
            final DataCiteMetadata.GeoLocations.GeoLocation _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.GeoLocations.GeoLocation.Builder<_B> copyOf(
            final DataCiteMetadata.GeoLocations.GeoLocation.Builder _other) {
          return copyOf(_other.build());
        }
      }

      /**
       * Java class for anonymous complex type.
       *
       * <p>The following schema fragment specifies the expected content contained within this
       * class.
       *
       * <pre>
       * &lt;complexType&gt;
       *   &lt;complexContent&gt;
       *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
       *       &lt;sequence&gt;
       *         &lt;element name="polygonPoint" type="{http://datacite.org/schema/kernel-4}point" maxOccurs="unbounded" minOccurs="4"/&gt;
       *         &lt;element name="inPolygonPoint" type="{http://datacite.org/schema/kernel-4}point" minOccurs="0"/&gt;
       *       &lt;/sequence&gt;
       *     &lt;/restriction&gt;
       *   &lt;/complexContent&gt;
       * &lt;/complexType&gt;
       * </pre>
       */
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(
          name = "",
          propOrder = {"polygonPoint", "inPolygonPoint"})
      public static class GeoLocationPolygon {

        @XmlElement(required = true)
        protected List<Point> polygonPoint;

        protected Point inPolygonPoint;

        /**
         * Gets the value of the polygonPoint property.
         *
         * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore
         * any modification you make to the returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the polygonPoint property.
         *
         * <p>For example, to add a new item, do as follows:
         *
         * <pre>
         *    getPolygonPoint().add(newItem);
         * </pre>
         *
         * <p>Objects of the following type(s) are allowed in the list {@link Point }
         */
        public List<Point> getPolygonPoint() {
          if (polygonPoint == null) {
            polygonPoint = new ArrayList<Point>();
          }
          return this.polygonPoint;
        }

        /**
         * Gets the value of the inPolygonPoint property.
         *
         * @return possible object is {@link Point }
         */
        public Point getInPolygonPoint() {
          return inPolygonPoint;
        }

        /**
         * Sets the value of the inPolygonPoint property.
         *
         * @param value allowed object is {@link Point }
         */
        public void setInPolygonPoint(Point value) {
          this.inPolygonPoint = value;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B> _other) {
          if (this.polygonPoint == null) {
            _other.polygonPoint = null;
          } else {
            _other.polygonPoint =
                new ArrayList<
                    Point.Builder<
                        DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                            _B>>>();
            for (Point _item : this.polygonPoint) {
              _other.polygonPoint.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
            }
          }
          _other.inPolygonPoint =
              ((this.inPolygonPoint == null) ? null : this.inPolygonPoint.newCopyBuilder(_other));
        }

        public <_B>
            DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B> newCopyBuilder(
                final _B _parentBuilder) {
          return new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>(
              _parentBuilder, this, true);
        }

        public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<Void>
            newCopyBuilder() {
          return newCopyBuilder(null);
        }

        public static DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<Void>
            builder() {
          return new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<Void>(
              null, null, false);
        }

        public static <_B>
            DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B> copyOf(
                final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _other) {
          final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>
              _newBuilder =
                  new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>(
                      null, null, false);
          _other.copyTo(_newBuilder);
          return _newBuilder;
        }

        /**
         * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
         * method and should not be called directly by client code.
         *
         * @param _other A builder instance to which the state of this object will be copied.
         */
        public <_B> void copyTo(
            final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B> _other,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          final PropertyTree polygonPointPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("polygonPoint"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (polygonPointPropertyTree != null)
              : ((polygonPointPropertyTree == null) || (!polygonPointPropertyTree.isLeaf())))) {
            if (this.polygonPoint == null) {
              _other.polygonPoint = null;
            } else {
              _other.polygonPoint =
                  new ArrayList<
                      Point.Builder<
                          DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                              _B>>>();
              for (Point _item : this.polygonPoint) {
                _other.polygonPoint.add(
                    ((_item == null)
                        ? null
                        : _item.newCopyBuilder(
                            _other, polygonPointPropertyTree, _propertyTreeUse)));
              }
            }
          }
          final PropertyTree inPolygonPointPropertyTree =
              ((_propertyTree == null) ? null : _propertyTree.get("inPolygonPoint"));
          if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
              ? (inPolygonPointPropertyTree != null)
              : ((inPolygonPointPropertyTree == null) || (!inPolygonPointPropertyTree.isLeaf())))) {
            _other.inPolygonPoint =
                ((this.inPolygonPoint == null)
                    ? null
                    : this.inPolygonPoint.newCopyBuilder(
                        _other, inPolygonPointPropertyTree, _propertyTreeUse));
          }
        }

        public <_B>
            DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B> newCopyBuilder(
                final _B _parentBuilder,
                final PropertyTree _propertyTree,
                final PropertyTreeUse _propertyTreeUse) {
          return new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>(
              _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
        }

        public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<Void>
            newCopyBuilder(
                final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
          return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
        }

        public static <_B>
            DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B> copyOf(
                final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _other,
                final PropertyTree _propertyTree,
                final PropertyTreeUse _propertyTreeUse) {
          final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>
              _newBuilder =
                  new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>(
                      null, null, false);
          _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
          return _newBuilder;
        }

        public static DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<Void>
            copyExcept(
                final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _other,
                final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
        }

        public static DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<Void>
            copyOnly(
                final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _other,
                final PropertyTree _propertyTree) {
          return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
        }

        @Override
        public String toString() {
          return new StringJoiner(", ", GeoLocationPolygon.class.getSimpleName() + "[", "]")
              .add("polygonPoint=" + polygonPoint)
              .add("inPolygonPoint=" + inPolygonPoint)
              .toString();
        }

        @Override
        public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          GeoLocationPolygon that = (GeoLocationPolygon) o;
          return Objects.equals(polygonPoint, that.polygonPoint)
              && Objects.equals(inPolygonPoint, that.inPolygonPoint);
        }

        @Override
        public int hashCode() {
          return Objects.hash(polygonPoint, inPolygonPoint);
        }

        public static class Builder<_B> implements Buildable {

          protected final _B _parentBuilder;
          protected final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _storedValue;
          private List<
                  Point.Builder<
                      DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>>
              polygonPoint;
          private Point.Builder<
                  DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>
              inPolygonPoint;

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _other,
              final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                if (_other.polygonPoint == null) {
                  this.polygonPoint = null;
                } else {
                  this.polygonPoint =
                      new ArrayList<
                          Point.Builder<
                              DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                                  _B>>>();
                  for (Point _item : _other.polygonPoint) {
                    this.polygonPoint.add(((_item == null) ? null : _item.newCopyBuilder(this)));
                  }
                }
                this.inPolygonPoint =
                    ((_other.inPolygonPoint == null)
                        ? null
                        : _other.inPolygonPoint.newCopyBuilder(this));
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public Builder(
              final _B _parentBuilder,
              final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _other,
              final boolean _copy,
              final PropertyTree _propertyTree,
              final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other != null) {
              if (_copy) {
                _storedValue = null;
                final PropertyTree polygonPointPropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("polygonPoint"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (polygonPointPropertyTree != null)
                    : ((polygonPointPropertyTree == null)
                        || (!polygonPointPropertyTree.isLeaf())))) {
                  if (_other.polygonPoint == null) {
                    this.polygonPoint = null;
                  } else {
                    this.polygonPoint =
                        new ArrayList<
                            Point.Builder<
                                DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon
                                        .Builder<
                                    _B>>>();
                    for (Point _item : _other.polygonPoint) {
                      this.polygonPoint.add(
                          ((_item == null)
                              ? null
                              : _item.newCopyBuilder(
                                  this, polygonPointPropertyTree, _propertyTreeUse)));
                    }
                  }
                }
                final PropertyTree inPolygonPointPropertyTree =
                    ((_propertyTree == null) ? null : _propertyTree.get("inPolygonPoint"));
                if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                    ? (inPolygonPointPropertyTree != null)
                    : ((inPolygonPointPropertyTree == null)
                        || (!inPolygonPointPropertyTree.isLeaf())))) {
                  this.inPolygonPoint =
                      ((_other.inPolygonPoint == null)
                          ? null
                          : _other.inPolygonPoint.newCopyBuilder(
                              this, inPolygonPointPropertyTree, _propertyTreeUse));
                }
              } else {
                _storedValue = _other;
              }
            } else {
              _storedValue = null;
            }
          }

          public _B end() {
            return this._parentBuilder;
          }

          protected <_P extends DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon>
              _P init(final _P _product) {
            if (this.polygonPoint != null) {
              final List<Point> polygonPoint = new ArrayList<Point>(this.polygonPoint.size());
              for (Point.Builder<
                      DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>
                  _item : this.polygonPoint) {
                polygonPoint.add(_item.build());
              }
              _product.polygonPoint = polygonPoint;
            }
            _product.inPolygonPoint =
                ((this.inPolygonPoint == null) ? null : this.inPolygonPoint.build());
            return _product;
          }

          /**
           * Adds the given items to the value of "polygonPoint"
           *
           * @param polygonPoint Items to add to the value of the "polygonPoint" property
           */
          public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>
              addPolygonPoint(final Iterable<? extends Point> polygonPoint) {
            if (polygonPoint != null) {
              if (this.polygonPoint == null) {
                this.polygonPoint =
                    new ArrayList<
                        Point.Builder<
                            DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                                _B>>>();
              }
              for (Point _item : polygonPoint) {
                this.polygonPoint.add(
                    new Point.Builder<
                        DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>(
                        this, _item, false));
              }
            }
            return this;
          }

          /**
           * Sets the new value of "polygonPoint" (any previous value will be replaced)
           *
           * @param polygonPoint New value of the "polygonPoint" property.
           */
          public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>
              withPolygonPoint(final Iterable<? extends Point> polygonPoint) {
            if (this.polygonPoint != null) {
              this.polygonPoint.clear();
            }
            return addPolygonPoint(polygonPoint);
          }

          /**
           * Adds the given items to the value of "polygonPoint"
           *
           * @param polygonPoint Items to add to the value of the "polygonPoint" property
           */
          public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>
              addPolygonPoint(Point... polygonPoint) {
            addPolygonPoint(Arrays.asList(polygonPoint));
            return this;
          }

          /**
           * Sets the new value of "polygonPoint" (any previous value will be replaced)
           *
           * @param polygonPoint New value of the "polygonPoint" property.
           */
          public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>
              withPolygonPoint(Point... polygonPoint) {
            withPolygonPoint(Arrays.asList(polygonPoint));
            return this;
          }

          /**
           * Returns a new builder to build an additional value of the "PolygonPoint" property. Use
           * {@link org.gbif.doi.metadata.datacite.Point.Builder#end()} to return to the current
           * builder.
           *
           * @return a new builder to build an additional value of the "PolygonPoint" property. Use
           *     {@link org.gbif.doi.metadata.datacite.Point.Builder#end()} to return to the current
           *     builder.
           */
          public Point.Builder<
                  ? extends
                      DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>
              addPolygonPoint() {
            if (this.polygonPoint == null) {
              this.polygonPoint =
                  new ArrayList<
                      Point.Builder<
                          DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<
                              _B>>>();
            }
            final Point.Builder<
                    DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>
                polygonPoint_Builder =
                    new Point.Builder<
                        DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>(
                        this, null, false);
            this.polygonPoint.add(polygonPoint_Builder);
            return polygonPoint_Builder;
          }

          /**
           * Sets the new value of "inPolygonPoint" (any previous value will be replaced)
           *
           * @param inPolygonPoint New value of the "inPolygonPoint" property.
           */
          public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>
              withInPolygonPoint(final Point inPolygonPoint) {
            this.inPolygonPoint =
                ((inPolygonPoint == null)
                    ? null
                    : new Point.Builder<
                        DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>(
                        this, inPolygonPoint, false));
            return this;
          }

          /**
           * Returns the existing builder or a new builder to build the value of the
           * "inPolygonPoint" property. Use {@link
           * org.gbif.doi.metadata.datacite.Point.Builder#end()} to return to the current builder.
           *
           * @return A new builder to build the value of the "inPolygonPoint" property. Use {@link
           *     org.gbif.doi.metadata.datacite.Point.Builder#end()} to return to the current
           *     builder.
           */
          public Point.Builder<
                  ? extends
                      DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>
              withInPolygonPoint() {
            if (this.inPolygonPoint != null) {
              return this.inPolygonPoint;
            }
            return this.inPolygonPoint =
                new Point.Builder<
                    DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B>>(
                    this, null, false);
          }

          @Override
          public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon build() {
            if (_storedValue == null) {
              return this.init(new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon());
            } else {
              return ((DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon) _storedValue);
            }
          }

          public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B> copyOf(
              final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon _other) {
            _other.copyTo(this);
            return this;
          }

          public DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder<_B> copyOf(
              final DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Builder _other) {
            return copyOf(_other.build());
          }
        }

        public static class Select
            extends DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Selector<
                DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Select, Void> {

          Select() {
            super(null, null, null);
          }

          public static DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Select
              _root() {
            return new DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Select();
          }
        }

        public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
            extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

          private Point.Selector<
                  TRoot,
                  DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Selector<
                      TRoot, TParent>>
              polygonPoint = null;
          private Point.Selector<
                  TRoot,
                  DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Selector<
                      TRoot, TParent>>
              inPolygonPoint = null;

          public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
          }

          @Override
          public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.polygonPoint != null) {
              products.put("polygonPoint", this.polygonPoint.init());
            }
            if (this.inPolygonPoint != null) {
              products.put("inPolygonPoint", this.inPolygonPoint.init());
            }
            return products;
          }

          public Point.Selector<
                  TRoot,
                  DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Selector<
                      TRoot, TParent>>
              polygonPoint() {
            return ((this.polygonPoint == null)
                ? this.polygonPoint =
                    new Point.Selector<
                        TRoot,
                        DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Selector<
                            TRoot, TParent>>(this._root, this, "polygonPoint")
                : this.polygonPoint);
          }

          public Point.Selector<
                  TRoot,
                  DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Selector<
                      TRoot, TParent>>
              inPolygonPoint() {
            return ((this.inPolygonPoint == null)
                ? this.inPolygonPoint =
                    new Point.Selector<
                        TRoot,
                        DataCiteMetadata.GeoLocations.GeoLocation.GeoLocationPolygon.Selector<
                            TRoot, TParent>>(this._root, this, "inPolygonPoint")
                : this.inPolygonPoint);
          }
        }
      }

      public static class Select
          extends DataCiteMetadata.GeoLocations.GeoLocation.Selector<
              DataCiteMetadata.GeoLocations.GeoLocation.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.GeoLocations.GeoLocation.Select _root() {
          return new DataCiteMetadata.GeoLocations.GeoLocation.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.GeoLocations.GeoLocation.Selector<TRoot, TParent>>
            geoLocationPlaceOrGeoLocationPointOrGeoLocationBox = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox != null) {
            products.put(
                "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox",
                this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.GeoLocations.GeoLocation.Selector<TRoot, TParent>>
            geoLocationPlaceOrGeoLocationPointOrGeoLocationBox() {
          return ((this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox == null)
              ? this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.GeoLocations.GeoLocation.Selector<TRoot, TParent>>(
                      this._root, this, "geoLocationPlaceOrGeoLocationPointOrGeoLocationBox")
              : this.geoLocationPlaceOrGeoLocationPointOrGeoLocationBox);
        }
      }
    }

    public static class Select
        extends DataCiteMetadata.GeoLocations.Selector<DataCiteMetadata.GeoLocations.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.GeoLocations.Select _root() {
        return new DataCiteMetadata.GeoLocations.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.GeoLocations.GeoLocation.Selector<
              TRoot, DataCiteMetadata.GeoLocations.Selector<TRoot, TParent>>
          geoLocation = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.geoLocation != null) {
          products.put("geoLocation", this.geoLocation.init());
        }
        return products;
      }

      public DataCiteMetadata.GeoLocations.GeoLocation.Selector<
              TRoot, DataCiteMetadata.GeoLocations.Selector<TRoot, TParent>>
          geoLocation() {
        return ((this.geoLocation == null)
            ? this.geoLocation =
                new DataCiteMetadata.GeoLocations.GeoLocation.Selector<
                    TRoot, DataCiteMetadata.GeoLocations.Selector<TRoot, TParent>>(
                    this._root, this, "geoLocation")
            : this.geoLocation);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;simpleContent&gt;
   *     &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
   *       &lt;attribute name="identifierType" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
   *     &lt;/extension&gt;
   *   &lt;/simpleContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"value"})
  public static class Identifier {

    @XmlValue protected String value;

    @XmlAttribute(name = "identifierType", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String identifierType;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link String }
     */
    public String getValue() {
      return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link String }
     */
    public void setValue(String value) {
      this.value = value;
    }

    /**
     * Gets the value of the identifierType property.
     *
     * @return possible object is {@link String }
     */
    public String getIdentifierType() {
      return identifierType;
    }

    /**
     * Sets the value of the identifierType property.
     *
     * @param value allowed object is {@link String }
     */
    public void setIdentifierType(String value) {
      this.identifierType = value;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Identifier.Builder<_B> _other) {
      _other.value = this.value;
      _other.identifierType = this.identifierType;
    }

    public <_B> DataCiteMetadata.Identifier.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Identifier.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Identifier.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Identifier.Builder<Void> builder() {
      return new DataCiteMetadata.Identifier.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Identifier.Builder<_B> copyOf(
        final DataCiteMetadata.Identifier _other) {
      final DataCiteMetadata.Identifier.Builder<_B> _newBuilder =
          new DataCiteMetadata.Identifier.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Identifier.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree valuePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("value"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (valuePropertyTree != null)
          : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
        _other.value = this.value;
      }
      final PropertyTree identifierTypePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("identifierType"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (identifierTypePropertyTree != null)
          : ((identifierTypePropertyTree == null) || (!identifierTypePropertyTree.isLeaf())))) {
        _other.identifierType = this.identifierType;
      }
    }

    public <_B> DataCiteMetadata.Identifier.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Identifier.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Identifier.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Identifier.Builder<_B> copyOf(
        final DataCiteMetadata.Identifier _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Identifier.Builder<_B> _newBuilder =
          new DataCiteMetadata.Identifier.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Identifier.Builder<Void> copyExcept(
        final DataCiteMetadata.Identifier _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Identifier.Builder<Void> copyOnly(
        final DataCiteMetadata.Identifier _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Identifier.class.getSimpleName() + "[", "]")
          .add("value='" + value + "'")
          .add("identifierType='" + identifierType + "'")
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Identifier that = (Identifier) o;
      return Objects.equals(value, that.value)
          && Objects.equals(identifierType, that.identifierType);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, identifierType);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Identifier _storedValue;
      private String value;
      private String identifierType;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.Identifier _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            this.value = _other.value;
            this.identifierType = _other.identifierType;
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Identifier _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree valuePropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("value"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (valuePropertyTree != null)
                : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
              this.value = _other.value;
            }
            final PropertyTree identifierTypePropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("identifierType"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (identifierTypePropertyTree != null)
                : ((identifierTypePropertyTree == null)
                    || (!identifierTypePropertyTree.isLeaf())))) {
              this.identifierType = _other.identifierType;
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Identifier> _P init(final _P _product) {
        _product.value = this.value;
        _product.identifierType = this.identifierType;
        return _product;
      }

      /**
       * Sets the new value of "value" (any previous value will be replaced)
       *
       * @param value New value of the "value" property.
       */
      public DataCiteMetadata.Identifier.Builder<_B> withValue(final String value) {
        this.value = value;
        return this;
      }

      /**
       * Sets the new value of "identifierType" (any previous value will be replaced)
       *
       * @param identifierType New value of the "identifierType" property.
       */
      public DataCiteMetadata.Identifier.Builder<_B> withIdentifierType(
          final String identifierType) {
        this.identifierType = identifierType;
        return this;
      }

      @Override
      public DataCiteMetadata.Identifier build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Identifier());
        } else {
          return ((DataCiteMetadata.Identifier) _storedValue);
        }
      }

      public DataCiteMetadata.Identifier.Builder<_B> copyOf(
          final DataCiteMetadata.Identifier _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Identifier.Builder<_B> copyOf(
          final DataCiteMetadata.Identifier.Builder _other) {
        return copyOf(_other.build());
      }
    }

    public static class Select
        extends DataCiteMetadata.Identifier.Selector<DataCiteMetadata.Identifier.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Identifier.Select _root() {
        return new DataCiteMetadata.Identifier.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.Identifier.Selector<TRoot, TParent>>
          value = null;
      private com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.Identifier.Selector<TRoot, TParent>>
          identifierType = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.value != null) {
          products.put("value", this.value.init());
        }
        if (this.identifierType != null) {
          products.put("identifierType", this.identifierType.init());
        }
        return products;
      }

      public com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.Identifier.Selector<TRoot, TParent>>
          value() {
        return ((this.value == null)
            ? this.value =
                new com.kscs.util.jaxb.Selector<
                    TRoot, DataCiteMetadata.Identifier.Selector<TRoot, TParent>>(
                    this._root, this, "value")
            : this.value);
      }

      public com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.Identifier.Selector<TRoot, TParent>>
          identifierType() {
        return ((this.identifierType == null)
            ? this.identifierType =
                new com.kscs.util.jaxb.Selector<
                    TRoot, DataCiteMetadata.Identifier.Selector<TRoot, TParent>>(
                    this._root, this, "identifierType")
            : this.identifierType);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;simpleContent&gt;
   *     &lt;extension base="&lt;http://datacite.org/schema/kernel-4&gt;nonemptycontentStringType"&gt;
   *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
   *     &lt;/extension&gt;
   *   &lt;/simpleContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"value"})
  public static class Publisher {

    @XmlValue protected String value;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    protected String lang;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link String }
     */
    public String getValue() {
      return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link String }
     */
    public void setValue(String value) {
      this.value = value;
    }

    /**
     * Gets the value of the lang property.
     *
     * @return possible object is {@link String }
     */
    public String getLang() {
      return lang;
    }

    /**
     * Sets the value of the lang property.
     *
     * @param value allowed object is {@link String }
     */
    public void setLang(String value) {
      this.lang = value;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Publisher.Builder<_B> _other) {
      _other.value = this.value;
      _other.lang = this.lang;
    }

    public <_B> DataCiteMetadata.Publisher.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Publisher.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Publisher.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Publisher.Builder<Void> builder() {
      return new DataCiteMetadata.Publisher.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Publisher.Builder<_B> copyOf(
        final DataCiteMetadata.Publisher _other) {
      final DataCiteMetadata.Publisher.Builder<_B> _newBuilder =
          new DataCiteMetadata.Publisher.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Publisher.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree valuePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("value"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (valuePropertyTree != null)
          : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
        _other.value = this.value;
      }
      final PropertyTree langPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("lang"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (langPropertyTree != null)
          : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
        _other.lang = this.lang;
      }
    }

    public <_B> DataCiteMetadata.Publisher.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Publisher.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Publisher.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Publisher.Builder<_B> copyOf(
        final DataCiteMetadata.Publisher _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Publisher.Builder<_B> _newBuilder =
          new DataCiteMetadata.Publisher.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Publisher.Builder<Void> copyExcept(
        final DataCiteMetadata.Publisher _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Publisher.Builder<Void> copyOnly(
        final DataCiteMetadata.Publisher _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Publisher.class.getSimpleName() + "[", "]")
          .add("value='" + value + "'")
          .add("lang='" + lang + "'")
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Publisher publisher = (Publisher) o;
      return Objects.equals(value, publisher.value) && Objects.equals(lang, publisher.lang);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, lang);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Publisher _storedValue;
      private String value;
      private String lang;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.Publisher _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            this.value = _other.value;
            this.lang = _other.lang;
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Publisher _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree valuePropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("value"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (valuePropertyTree != null)
                : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
              this.value = _other.value;
            }
            final PropertyTree langPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("lang"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (langPropertyTree != null)
                : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
              this.lang = _other.lang;
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Publisher> _P init(final _P _product) {
        _product.value = this.value;
        _product.lang = this.lang;
        return _product;
      }

      /**
       * Sets the new value of "value" (any previous value will be replaced)
       *
       * @param value New value of the "value" property.
       */
      public DataCiteMetadata.Publisher.Builder<_B> withValue(final String value) {
        this.value = value;
        return this;
      }

      /**
       * Sets the new value of "lang" (any previous value will be replaced)
       *
       * @param lang New value of the "lang" property.
       */
      public DataCiteMetadata.Publisher.Builder<_B> withLang(final String lang) {
        this.lang = lang;
        return this;
      }

      @Override
      public DataCiteMetadata.Publisher build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Publisher());
        } else {
          return ((DataCiteMetadata.Publisher) _storedValue);
        }
      }

      public DataCiteMetadata.Publisher.Builder<_B> copyOf(
          final DataCiteMetadata.Publisher _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Publisher.Builder<_B> copyOf(
          final DataCiteMetadata.Publisher.Builder _other) {
        return copyOf(_other.build());
      }
    }

    public static class Select
        extends DataCiteMetadata.Publisher.Selector<DataCiteMetadata.Publisher.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Publisher.Select _root() {
        return new DataCiteMetadata.Publisher.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.Publisher.Selector<TRoot, TParent>>
          value = null;
      private com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.Publisher.Selector<TRoot, TParent>>
          lang = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.value != null) {
          products.put("value", this.value.init());
        }
        if (this.lang != null) {
          products.put("lang", this.lang.init());
        }
        return products;
      }

      public com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Publisher.Selector<TRoot, TParent>>
          value() {
        return ((this.value == null)
            ? this.value =
                new com.kscs.util.jaxb.Selector<
                    TRoot, DataCiteMetadata.Publisher.Selector<TRoot, TParent>>(
                    this._root, this, "value")
            : this.value);
      }

      public com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Publisher.Selector<TRoot, TParent>>
          lang() {
        return ((this.lang == null)
            ? this.lang =
                new com.kscs.util.jaxb.Selector<
                    TRoot, DataCiteMetadata.Publisher.Selector<TRoot, TParent>>(
                    this._root, this, "lang")
            : this.lang);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="relatedIdentifier" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;simpleContent&gt;
   *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                 &lt;attribute name="resourceTypeGeneral" type="{http://datacite.org/schema/kernel-4}resourceType" /&gt;
   *                 &lt;attribute name="relatedIdentifierType" use="required" type="{http://datacite.org/schema/kernel-4}relatedIdentifierType" /&gt;
   *                 &lt;attribute name="relationType" use="required" type="{http://datacite.org/schema/kernel-4}relationType" /&gt;
   *                 &lt;attribute name="relatedMetadataScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
   *                 &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
   *                 &lt;attribute name="schemeType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
   *               &lt;/extension&gt;
   *             &lt;/simpleContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"relatedIdentifier"})
  public static class RelatedIdentifiers {

    protected List<DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier> relatedIdentifier;

    /**
     * Gets the value of the relatedIdentifier property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the relatedIdentifier property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getRelatedIdentifier().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier }
     */
    public List<DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier> getRelatedIdentifier() {
      if (relatedIdentifier == null) {
        relatedIdentifier = new ArrayList<DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier>();
      }
      return this.relatedIdentifier;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.RelatedIdentifiers.Builder<_B> _other) {
      if (this.relatedIdentifier == null) {
        _other.relatedIdentifier = null;
      } else {
        _other.relatedIdentifier =
            new ArrayList<
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                    DataCiteMetadata.RelatedIdentifiers.Builder<_B>>>();
        for (DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _item : this.relatedIdentifier) {
          _other.relatedIdentifier.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.RelatedIdentifiers.Builder<_B> newCopyBuilder(
        final _B _parentBuilder) {
      return new DataCiteMetadata.RelatedIdentifiers.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.RelatedIdentifiers.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.RelatedIdentifiers.Builder<Void> builder() {
      return new DataCiteMetadata.RelatedIdentifiers.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.RelatedIdentifiers.Builder<_B> copyOf(
        final DataCiteMetadata.RelatedIdentifiers _other) {
      final DataCiteMetadata.RelatedIdentifiers.Builder<_B> _newBuilder =
          new DataCiteMetadata.RelatedIdentifiers.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.RelatedIdentifiers.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree relatedIdentifierPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("relatedIdentifier"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (relatedIdentifierPropertyTree != null)
          : ((relatedIdentifierPropertyTree == null)
              || (!relatedIdentifierPropertyTree.isLeaf())))) {
        if (this.relatedIdentifier == null) {
          _other.relatedIdentifier = null;
        } else {
          _other.relatedIdentifier =
              new ArrayList<
                  DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                      DataCiteMetadata.RelatedIdentifiers.Builder<_B>>>();
          for (DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _item :
              this.relatedIdentifier) {
            _other.relatedIdentifier.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(
                        _other, relatedIdentifierPropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.RelatedIdentifiers.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.RelatedIdentifiers.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.RelatedIdentifiers.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.RelatedIdentifiers.Builder<_B> copyOf(
        final DataCiteMetadata.RelatedIdentifiers _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.RelatedIdentifiers.Builder<_B> _newBuilder =
          new DataCiteMetadata.RelatedIdentifiers.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.RelatedIdentifiers.Builder<Void> copyExcept(
        final DataCiteMetadata.RelatedIdentifiers _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.RelatedIdentifiers.Builder<Void> copyOnly(
        final DataCiteMetadata.RelatedIdentifiers _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", RelatedIdentifiers.class.getSimpleName() + "[", "]")
          .add("relatedIdentifier=" + relatedIdentifier)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      RelatedIdentifiers that = (RelatedIdentifiers) o;
      return Objects.equals(relatedIdentifier, that.relatedIdentifier);
    }

    @Override
    public int hashCode() {
      return Objects.hash(relatedIdentifier);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.RelatedIdentifiers _storedValue;
      private List<
              DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                  DataCiteMetadata.RelatedIdentifiers.Builder<_B>>>
          relatedIdentifier;

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.RelatedIdentifiers _other,
          final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.relatedIdentifier == null) {
              this.relatedIdentifier = null;
            } else {
              this.relatedIdentifier =
                  new ArrayList<
                      DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                          DataCiteMetadata.RelatedIdentifiers.Builder<_B>>>();
              for (DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _item :
                  _other.relatedIdentifier) {
                this.relatedIdentifier.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.RelatedIdentifiers _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree relatedIdentifierPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("relatedIdentifier"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (relatedIdentifierPropertyTree != null)
                : ((relatedIdentifierPropertyTree == null)
                    || (!relatedIdentifierPropertyTree.isLeaf())))) {
              if (_other.relatedIdentifier == null) {
                this.relatedIdentifier = null;
              } else {
                this.relatedIdentifier =
                    new ArrayList<
                        DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                            DataCiteMetadata.RelatedIdentifiers.Builder<_B>>>();
                for (DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _item :
                    _other.relatedIdentifier) {
                  this.relatedIdentifier.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(
                              this, relatedIdentifierPropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.RelatedIdentifiers> _P init(final _P _product) {
        if (this.relatedIdentifier != null) {
          final List<DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier> relatedIdentifier =
              new ArrayList<DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier>(
                  this.relatedIdentifier.size());
          for (DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                  DataCiteMetadata.RelatedIdentifiers.Builder<_B>>
              _item : this.relatedIdentifier) {
            relatedIdentifier.add(_item.build());
          }
          _product.relatedIdentifier = relatedIdentifier;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "relatedIdentifier"
       *
       * @param relatedIdentifier Items to add to the value of the "relatedIdentifier" property
       */
      public DataCiteMetadata.RelatedIdentifiers.Builder<_B> addRelatedIdentifier(
          final Iterable<? extends DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier>
              relatedIdentifier) {
        if (relatedIdentifier != null) {
          if (this.relatedIdentifier == null) {
            this.relatedIdentifier =
                new ArrayList<
                    DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                        DataCiteMetadata.RelatedIdentifiers.Builder<_B>>>();
          }
          for (DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _item : relatedIdentifier) {
            this.relatedIdentifier.add(
                new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                    DataCiteMetadata.RelatedIdentifiers.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "relatedIdentifier" (any previous value will be replaced)
       *
       * @param relatedIdentifier New value of the "relatedIdentifier" property.
       */
      public DataCiteMetadata.RelatedIdentifiers.Builder<_B> withRelatedIdentifier(
          final Iterable<? extends DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier>
              relatedIdentifier) {
        if (this.relatedIdentifier != null) {
          this.relatedIdentifier.clear();
        }
        return addRelatedIdentifier(relatedIdentifier);
      }

      /**
       * Adds the given items to the value of "relatedIdentifier"
       *
       * @param relatedIdentifier Items to add to the value of the "relatedIdentifier" property
       */
      public DataCiteMetadata.RelatedIdentifiers.Builder<_B> addRelatedIdentifier(
          DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier... relatedIdentifier) {
        addRelatedIdentifier(Arrays.asList(relatedIdentifier));
        return this;
      }

      /**
       * Sets the new value of "relatedIdentifier" (any previous value will be replaced)
       *
       * @param relatedIdentifier New value of the "relatedIdentifier" property.
       */
      public DataCiteMetadata.RelatedIdentifiers.Builder<_B> withRelatedIdentifier(
          DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier... relatedIdentifier) {
        withRelatedIdentifier(Arrays.asList(relatedIdentifier));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "RelatedIdentifier" property. Use
       * {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder#end()}
       * to return to the current builder.
       *
       * @return a new builder to build an additional value of the "RelatedIdentifier" property. Use
       *     {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder#end()}
       *     to return to the current builder.
       */
      public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
              ? extends DataCiteMetadata.RelatedIdentifiers.Builder<_B>>
          addRelatedIdentifier() {
        if (this.relatedIdentifier == null) {
          this.relatedIdentifier =
              new ArrayList<
                  DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                      DataCiteMetadata.RelatedIdentifiers.Builder<_B>>>();
        }
        final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                DataCiteMetadata.RelatedIdentifiers.Builder<_B>>
            relatedIdentifier_Builder =
                new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<
                    DataCiteMetadata.RelatedIdentifiers.Builder<_B>>(this, null, false);
        this.relatedIdentifier.add(relatedIdentifier_Builder);
        return relatedIdentifier_Builder;
      }

      @Override
      public DataCiteMetadata.RelatedIdentifiers build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.RelatedIdentifiers());
        } else {
          return ((DataCiteMetadata.RelatedIdentifiers) _storedValue);
        }
      }

      public DataCiteMetadata.RelatedIdentifiers.Builder<_B> copyOf(
          final DataCiteMetadata.RelatedIdentifiers _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.RelatedIdentifiers.Builder<_B> copyOf(
          final DataCiteMetadata.RelatedIdentifiers.Builder _other) {
        return copyOf(_other.build());
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="resourceTypeGeneral" type="{http://datacite.org/schema/kernel-4}resourceType" /&gt;
     *       &lt;attribute name="relatedIdentifierType" use="required" type="{http://datacite.org/schema/kernel-4}relatedIdentifierType" /&gt;
     *       &lt;attribute name="relationType" use="required" type="{http://datacite.org/schema/kernel-4}relationType" /&gt;
     *       &lt;attribute name="relatedMetadataScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *       &lt;attribute name="schemeType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"value"})
    public static class RelatedIdentifier {

      @XmlValue protected String value;

      @XmlAttribute(name = "resourceTypeGeneral")
      protected org.gbif.doi.metadata.datacite.ResourceType resourceTypeGeneral;

      @XmlAttribute(name = "relatedIdentifierType", required = true)
      protected RelatedIdentifierType relatedIdentifierType;

      @XmlAttribute(name = "relationType", required = true)
      protected RelationType relationType;

      @XmlAttribute(name = "relatedMetadataScheme")
      @XmlSchemaType(name = "anySimpleType")
      protected String relatedMetadataScheme;

      @XmlAttribute(name = "schemeURI")
      @XmlSchemaType(name = "anyURI")
      protected String schemeURI;

      @XmlAttribute(name = "schemeType")
      @XmlSchemaType(name = "anySimpleType")
      protected String schemeType;

      /**
       * Gets the value of the value property.
       *
       * @return possible object is {@link String }
       */
      public String getValue() {
        return value;
      }

      /**
       * Sets the value of the value property.
       *
       * @param value allowed object is {@link String }
       */
      public void setValue(String value) {
        this.value = value;
      }

      /**
       * Gets the value of the resourceTypeGeneral property.
       *
       * @return possible object is {@link org.gbif.doi.metadata.datacite.ResourceType }
       */
      public org.gbif.doi.metadata.datacite.ResourceType getResourceTypeGeneral() {
        return resourceTypeGeneral;
      }

      /**
       * Sets the value of the resourceTypeGeneral property.
       *
       * @param value allowed object is {@link org.gbif.doi.metadata.datacite.ResourceType }
       */
      public void setResourceTypeGeneral(org.gbif.doi.metadata.datacite.ResourceType value) {
        this.resourceTypeGeneral = value;
      }

      /**
       * Gets the value of the relatedIdentifierType property.
       *
       * @return possible object is {@link RelatedIdentifierType }
       */
      public RelatedIdentifierType getRelatedIdentifierType() {
        return relatedIdentifierType;
      }

      /**
       * Sets the value of the relatedIdentifierType property.
       *
       * @param value allowed object is {@link RelatedIdentifierType }
       */
      public void setRelatedIdentifierType(RelatedIdentifierType value) {
        this.relatedIdentifierType = value;
      }

      /**
       * Gets the value of the relationType property.
       *
       * @return possible object is {@link RelationType }
       */
      public RelationType getRelationType() {
        return relationType;
      }

      /**
       * Sets the value of the relationType property.
       *
       * @param value allowed object is {@link RelationType }
       */
      public void setRelationType(RelationType value) {
        this.relationType = value;
      }

      /**
       * Gets the value of the relatedMetadataScheme property.
       *
       * @return possible object is {@link String }
       */
      public String getRelatedMetadataScheme() {
        return relatedMetadataScheme;
      }

      /**
       * Sets the value of the relatedMetadataScheme property.
       *
       * @param value allowed object is {@link String }
       */
      public void setRelatedMetadataScheme(String value) {
        this.relatedMetadataScheme = value;
      }

      /**
       * Gets the value of the schemeURI property.
       *
       * @return possible object is {@link String }
       */
      public String getSchemeURI() {
        return schemeURI;
      }

      /**
       * Sets the value of the schemeURI property.
       *
       * @param value allowed object is {@link String }
       */
      public void setSchemeURI(String value) {
        this.schemeURI = value;
      }

      /**
       * Gets the value of the schemeType property.
       *
       * @return possible object is {@link String }
       */
      public String getSchemeType() {
        return schemeType;
      }

      /**
       * Sets the value of the schemeType property.
       *
       * @param value allowed object is {@link String }
       */
      public void setSchemeType(String value) {
        this.schemeType = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> _other) {
        _other.value = this.value;
        _other.resourceTypeGeneral = this.resourceTypeGeneral;
        _other.relatedIdentifierType = this.relatedIdentifierType;
        _other.relationType = this.relationType;
        _other.relatedMetadataScheme = this.relatedMetadataScheme;
        _other.schemeURI = this.schemeURI;
        _other.schemeType = this.schemeType;
      }

      public <_B> DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B>(
            _parentBuilder, this, true);
      }

      public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<Void> builder() {
        return new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<Void>(
            null, null, false);
      }

      public static <_B> DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> copyOf(
          final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _other) {
        final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> _newBuilder =
            new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B>(
                null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree valuePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("value"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (valuePropertyTree != null)
            : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
          _other.value = this.value;
        }
        final PropertyTree resourceTypeGeneralPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("resourceTypeGeneral"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (resourceTypeGeneralPropertyTree != null)
            : ((resourceTypeGeneralPropertyTree == null)
                || (!resourceTypeGeneralPropertyTree.isLeaf())))) {
          _other.resourceTypeGeneral = this.resourceTypeGeneral;
        }
        final PropertyTree relatedIdentifierTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("relatedIdentifierType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (relatedIdentifierTypePropertyTree != null)
            : ((relatedIdentifierTypePropertyTree == null)
                || (!relatedIdentifierTypePropertyTree.isLeaf())))) {
          _other.relatedIdentifierType = this.relatedIdentifierType;
        }
        final PropertyTree relationTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("relationType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (relationTypePropertyTree != null)
            : ((relationTypePropertyTree == null) || (!relationTypePropertyTree.isLeaf())))) {
          _other.relationType = this.relationType;
        }
        final PropertyTree relatedMetadataSchemePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("relatedMetadataScheme"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (relatedMetadataSchemePropertyTree != null)
            : ((relatedMetadataSchemePropertyTree == null)
                || (!relatedMetadataSchemePropertyTree.isLeaf())))) {
          _other.relatedMetadataScheme = this.relatedMetadataScheme;
        }
        final PropertyTree schemeURIPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (schemeURIPropertyTree != null)
            : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
          _other.schemeURI = this.schemeURI;
        }
        final PropertyTree schemeTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("schemeType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (schemeTypePropertyTree != null)
            : ((schemeTypePropertyTree == null) || (!schemeTypePropertyTree.isLeaf())))) {
          _other.schemeType = this.schemeType;
        }
      }

      public <_B> DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> copyOf(
          final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> _newBuilder =
            new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B>(
                null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<Void> copyExcept(
          final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<Void> copyOnly(
          final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _other,
          final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", RelatedIdentifier.class.getSimpleName() + "[", "]")
            .add("value='" + value + "'")
            .add("resourceTypeGeneral=" + resourceTypeGeneral)
            .add("relatedIdentifierType=" + relatedIdentifierType)
            .add("relationType=" + relationType)
            .add("relatedMetadataScheme='" + relatedMetadataScheme + "'")
            .add("schemeURI='" + schemeURI + "'")
            .add("schemeType='" + schemeType + "'")
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatedIdentifier that = (RelatedIdentifier) o;
        return Objects.equals(value, that.value)
            && resourceTypeGeneral == that.resourceTypeGeneral
            && relatedIdentifierType == that.relatedIdentifierType
            && relationType == that.relationType
            && Objects.equals(relatedMetadataScheme, that.relatedMetadataScheme)
            && Objects.equals(schemeURI, that.schemeURI)
            && Objects.equals(schemeType, that.schemeType);
      }

      @Override
      public int hashCode() {
        return Objects.hash(
            value,
            resourceTypeGeneral,
            relatedIdentifierType,
            relationType,
            relatedMetadataScheme,
            schemeURI,
            schemeType);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _storedValue;
        private String value;
        private org.gbif.doi.metadata.datacite.ResourceType resourceTypeGeneral;
        private RelatedIdentifierType relatedIdentifierType;
        private RelationType relationType;
        private String relatedMetadataScheme;
        private String schemeURI;
        private String schemeType;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.value = _other.value;
              this.resourceTypeGeneral = _other.resourceTypeGeneral;
              this.relatedIdentifierType = _other.relatedIdentifierType;
              this.relationType = _other.relationType;
              this.relatedMetadataScheme = _other.relatedMetadataScheme;
              this.schemeURI = _other.schemeURI;
              this.schemeType = _other.schemeType;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree valuePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("value"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (valuePropertyTree != null)
                  : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                this.value = _other.value;
              }
              final PropertyTree resourceTypeGeneralPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("resourceTypeGeneral"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (resourceTypeGeneralPropertyTree != null)
                  : ((resourceTypeGeneralPropertyTree == null)
                      || (!resourceTypeGeneralPropertyTree.isLeaf())))) {
                this.resourceTypeGeneral = _other.resourceTypeGeneral;
              }
              final PropertyTree relatedIdentifierTypePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("relatedIdentifierType"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (relatedIdentifierTypePropertyTree != null)
                  : ((relatedIdentifierTypePropertyTree == null)
                      || (!relatedIdentifierTypePropertyTree.isLeaf())))) {
                this.relatedIdentifierType = _other.relatedIdentifierType;
              }
              final PropertyTree relationTypePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("relationType"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (relationTypePropertyTree != null)
                  : ((relationTypePropertyTree == null) || (!relationTypePropertyTree.isLeaf())))) {
                this.relationType = _other.relationType;
              }
              final PropertyTree relatedMetadataSchemePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("relatedMetadataScheme"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (relatedMetadataSchemePropertyTree != null)
                  : ((relatedMetadataSchemePropertyTree == null)
                      || (!relatedMetadataSchemePropertyTree.isLeaf())))) {
                this.relatedMetadataScheme = _other.relatedMetadataScheme;
              }
              final PropertyTree schemeURIPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (schemeURIPropertyTree != null)
                  : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
                this.schemeURI = _other.schemeURI;
              }
              final PropertyTree schemeTypePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("schemeType"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (schemeTypePropertyTree != null)
                  : ((schemeTypePropertyTree == null) || (!schemeTypePropertyTree.isLeaf())))) {
                this.schemeType = _other.schemeType;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier> _P init(
            final _P _product) {
          _product.value = this.value;
          _product.resourceTypeGeneral = this.resourceTypeGeneral;
          _product.relatedIdentifierType = this.relatedIdentifierType;
          _product.relationType = this.relationType;
          _product.relatedMetadataScheme = this.relatedMetadataScheme;
          _product.schemeURI = this.schemeURI;
          _product.schemeType = this.schemeType;
          return _product;
        }

        /**
         * Sets the new value of "value" (any previous value will be replaced)
         *
         * @param value New value of the "value" property.
         */
        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> withValue(
            final String value) {
          this.value = value;
          return this;
        }

        /**
         * Sets the new value of "resourceTypeGeneral" (any previous value will be replaced)
         *
         * @param resourceTypeGeneral New value of the "resourceTypeGeneral" property.
         */
        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B>
            withResourceTypeGeneral(
                final org.gbif.doi.metadata.datacite.ResourceType resourceTypeGeneral) {
          this.resourceTypeGeneral = resourceTypeGeneral;
          return this;
        }

        /**
         * Sets the new value of "relatedIdentifierType" (any previous value will be replaced)
         *
         * @param relatedIdentifierType New value of the "relatedIdentifierType" property.
         */
        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B>
            withRelatedIdentifierType(final RelatedIdentifierType relatedIdentifierType) {
          this.relatedIdentifierType = relatedIdentifierType;
          return this;
        }

        /**
         * Sets the new value of "relationType" (any previous value will be replaced)
         *
         * @param relationType New value of the "relationType" property.
         */
        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> withRelationType(
            final RelationType relationType) {
          this.relationType = relationType;
          return this;
        }

        /**
         * Sets the new value of "relatedMetadataScheme" (any previous value will be replaced)
         *
         * @param relatedMetadataScheme New value of the "relatedMetadataScheme" property.
         */
        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B>
            withRelatedMetadataScheme(final String relatedMetadataScheme) {
          this.relatedMetadataScheme = relatedMetadataScheme;
          return this;
        }

        /**
         * Sets the new value of "schemeURI" (any previous value will be replaced)
         *
         * @param schemeURI New value of the "schemeURI" property.
         */
        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> withSchemeURI(
            final String schemeURI) {
          this.schemeURI = schemeURI;
          return this;
        }

        /**
         * Sets the new value of "schemeType" (any previous value will be replaced)
         *
         * @param schemeType New value of the "schemeType" property.
         */
        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> withSchemeType(
            final String schemeType) {
          this.schemeType = schemeType;
          return this;
        }

        @Override
        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier());
          } else {
            return ((DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier) _storedValue);
          }
        }

        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> copyOf(
            final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder<_B> copyOf(
            final DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Builder _other) {
          return copyOf(_other.build());
        }
      }

      public static class Select
          extends DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
              DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Select _root() {
          return new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            value = null;
        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            resourceTypeGeneral = null;
        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            relatedIdentifierType = null;
        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            relationType = null;
        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            relatedMetadataScheme = null;
        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            schemeURI = null;
        private com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            schemeType = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.value != null) {
            products.put("value", this.value.init());
          }
          if (this.resourceTypeGeneral != null) {
            products.put("resourceTypeGeneral", this.resourceTypeGeneral.init());
          }
          if (this.relatedIdentifierType != null) {
            products.put("relatedIdentifierType", this.relatedIdentifierType.init());
          }
          if (this.relationType != null) {
            products.put("relationType", this.relationType.init());
          }
          if (this.relatedMetadataScheme != null) {
            products.put("relatedMetadataScheme", this.relatedMetadataScheme.init());
          }
          if (this.schemeURI != null) {
            products.put("schemeURI", this.schemeURI.init());
          }
          if (this.schemeType != null) {
            products.put("schemeType", this.schemeType.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            value() {
          return ((this.value == null)
              ? this.value =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "value")
              : this.value);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            resourceTypeGeneral() {
          return ((this.resourceTypeGeneral == null)
              ? this.resourceTypeGeneral =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "resourceTypeGeneral")
              : this.resourceTypeGeneral);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            relatedIdentifierType() {
          return ((this.relatedIdentifierType == null)
              ? this.relatedIdentifierType =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "relatedIdentifierType")
              : this.relatedIdentifierType);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            relationType() {
          return ((this.relationType == null)
              ? this.relationType =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "relationType")
              : this.relationType);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            relatedMetadataScheme() {
          return ((this.relatedMetadataScheme == null)
              ? this.relatedMetadataScheme =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "relatedMetadataScheme")
              : this.relatedMetadataScheme);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            schemeURI() {
          return ((this.schemeURI == null)
              ? this.schemeURI =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "schemeURI")
              : this.schemeURI);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot,
                DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<TRoot, TParent>>
            schemeType() {
          return ((this.schemeType == null)
              ? this.schemeType =
                  new com.kscs.util.jaxb.Selector<
                      TRoot,
                      DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
                          TRoot, TParent>>(this._root, this, "schemeType")
              : this.schemeType);
        }
      }
    }

    public static class Select
        extends DataCiteMetadata.RelatedIdentifiers.Selector<
            DataCiteMetadata.RelatedIdentifiers.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.RelatedIdentifiers.Select _root() {
        return new DataCiteMetadata.RelatedIdentifiers.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
              TRoot, DataCiteMetadata.RelatedIdentifiers.Selector<TRoot, TParent>>
          relatedIdentifier = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.relatedIdentifier != null) {
          products.put("relatedIdentifier", this.relatedIdentifier.init());
        }
        return products;
      }

      public DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
              TRoot, DataCiteMetadata.RelatedIdentifiers.Selector<TRoot, TParent>>
          relatedIdentifier() {
        return ((this.relatedIdentifier == null)
            ? this.relatedIdentifier =
                new DataCiteMetadata.RelatedIdentifiers.RelatedIdentifier.Selector<
                    TRoot, DataCiteMetadata.RelatedIdentifiers.Selector<TRoot, TParent>>(
                    this._root, this, "relatedIdentifier")
            : this.relatedIdentifier);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;simpleContent&gt;
   *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *       &lt;attribute name="resourceTypeGeneral" use="required" type="{http://datacite.org/schema/kernel-4}resourceType" /&gt;
   *     &lt;/extension&gt;
   *   &lt;/simpleContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"value"})
  public static class ResourceType {

    @XmlValue protected String value;

    @XmlAttribute(name = "resourceTypeGeneral", required = true)
    protected org.gbif.doi.metadata.datacite.ResourceType resourceTypeGeneral;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link String }
     */
    public String getValue() {
      return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link String }
     */
    public void setValue(String value) {
      this.value = value;
    }

    /**
     * Gets the value of the resourceTypeGeneral property.
     *
     * @return possible object is {@link org.gbif.doi.metadata.datacite.ResourceType }
     */
    public org.gbif.doi.metadata.datacite.ResourceType getResourceTypeGeneral() {
      return resourceTypeGeneral;
    }

    /**
     * Sets the value of the resourceTypeGeneral property.
     *
     * @param value allowed object is {@link org.gbif.doi.metadata.datacite.ResourceType }
     */
    public void setResourceTypeGeneral(org.gbif.doi.metadata.datacite.ResourceType value) {
      this.resourceTypeGeneral = value;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.ResourceType.Builder<_B> _other) {
      _other.value = this.value;
      _other.resourceTypeGeneral = this.resourceTypeGeneral;
    }

    public <_B> DataCiteMetadata.ResourceType.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.ResourceType.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.ResourceType.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.ResourceType.Builder<Void> builder() {
      return new DataCiteMetadata.ResourceType.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.ResourceType.Builder<_B> copyOf(
        final DataCiteMetadata.ResourceType _other) {
      final DataCiteMetadata.ResourceType.Builder<_B> _newBuilder =
          new DataCiteMetadata.ResourceType.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.ResourceType.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree valuePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("value"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (valuePropertyTree != null)
          : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
        _other.value = this.value;
      }
      final PropertyTree resourceTypeGeneralPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("resourceTypeGeneral"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (resourceTypeGeneralPropertyTree != null)
          : ((resourceTypeGeneralPropertyTree == null)
              || (!resourceTypeGeneralPropertyTree.isLeaf())))) {
        _other.resourceTypeGeneral = this.resourceTypeGeneral;
      }
    }

    public <_B> DataCiteMetadata.ResourceType.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.ResourceType.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.ResourceType.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.ResourceType.Builder<_B> copyOf(
        final DataCiteMetadata.ResourceType _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.ResourceType.Builder<_B> _newBuilder =
          new DataCiteMetadata.ResourceType.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.ResourceType.Builder<Void> copyExcept(
        final DataCiteMetadata.ResourceType _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.ResourceType.Builder<Void> copyOnly(
        final DataCiteMetadata.ResourceType _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", ResourceType.class.getSimpleName() + "[", "]")
          .add("value='" + value + "'")
          .add("resourceTypeGeneral=" + resourceTypeGeneral)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ResourceType that = (ResourceType) o;
      return Objects.equals(value, that.value) && resourceTypeGeneral == that.resourceTypeGeneral;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, resourceTypeGeneral);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.ResourceType _storedValue;
      private String value;
      private org.gbif.doi.metadata.datacite.ResourceType resourceTypeGeneral;

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.ResourceType _other,
          final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            this.value = _other.value;
            this.resourceTypeGeneral = _other.resourceTypeGeneral;
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.ResourceType _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree valuePropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("value"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (valuePropertyTree != null)
                : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
              this.value = _other.value;
            }
            final PropertyTree resourceTypeGeneralPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("resourceTypeGeneral"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (resourceTypeGeneralPropertyTree != null)
                : ((resourceTypeGeneralPropertyTree == null)
                    || (!resourceTypeGeneralPropertyTree.isLeaf())))) {
              this.resourceTypeGeneral = _other.resourceTypeGeneral;
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.ResourceType> _P init(final _P _product) {
        _product.value = this.value;
        _product.resourceTypeGeneral = this.resourceTypeGeneral;
        return _product;
      }

      /**
       * Sets the new value of "value" (any previous value will be replaced)
       *
       * @param value New value of the "value" property.
       */
      public DataCiteMetadata.ResourceType.Builder<_B> withValue(final String value) {
        this.value = value;
        return this;
      }

      /**
       * Sets the new value of "resourceTypeGeneral" (any previous value will be replaced)
       *
       * @param resourceTypeGeneral New value of the "resourceTypeGeneral" property.
       */
      public DataCiteMetadata.ResourceType.Builder<_B> withResourceTypeGeneral(
          final org.gbif.doi.metadata.datacite.ResourceType resourceTypeGeneral) {
        this.resourceTypeGeneral = resourceTypeGeneral;
        return this;
      }

      @Override
      public DataCiteMetadata.ResourceType build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.ResourceType());
        } else {
          return ((DataCiteMetadata.ResourceType) _storedValue);
        }
      }

      public DataCiteMetadata.ResourceType.Builder<_B> copyOf(
          final DataCiteMetadata.ResourceType _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.ResourceType.Builder<_B> copyOf(
          final DataCiteMetadata.ResourceType.Builder _other) {
        return copyOf(_other.build());
      }
    }

    public static class Select
        extends DataCiteMetadata.ResourceType.Selector<DataCiteMetadata.ResourceType.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.ResourceType.Select _root() {
        return new DataCiteMetadata.ResourceType.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.ResourceType.Selector<TRoot, TParent>>
          value = null;
      private com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.ResourceType.Selector<TRoot, TParent>>
          resourceTypeGeneral = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.value != null) {
          products.put("value", this.value.init());
        }
        if (this.resourceTypeGeneral != null) {
          products.put("resourceTypeGeneral", this.resourceTypeGeneral.init());
        }
        return products;
      }

      public com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.ResourceType.Selector<TRoot, TParent>>
          value() {
        return ((this.value == null)
            ? this.value =
                new com.kscs.util.jaxb.Selector<
                    TRoot, DataCiteMetadata.ResourceType.Selector<TRoot, TParent>>(
                    this._root, this, "value")
            : this.value);
      }

      public com.kscs.util.jaxb.Selector<
              TRoot, DataCiteMetadata.ResourceType.Selector<TRoot, TParent>>
          resourceTypeGeneral() {
        return ((this.resourceTypeGeneral == null)
            ? this.resourceTypeGeneral =
                new com.kscs.util.jaxb.Selector<
                    TRoot, DataCiteMetadata.ResourceType.Selector<TRoot, TParent>>(
                    this._root, this, "resourceTypeGeneral")
            : this.resourceTypeGeneral);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="rights" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;simpleContent&gt;
   *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                 &lt;attribute name="rightsURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
   *                 &lt;attribute name="rightsIdentifier" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
   *                 &lt;attribute name="rightsIdentifierScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
   *                 &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
   *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
   *               &lt;/extension&gt;
   *             &lt;/simpleContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"rights"})
  public static class RightsList {

    protected List<DataCiteMetadata.RightsList.Rights> rights;

    /**
     * Gets the value of the rights property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the rights property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getRights().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.RightsList.Rights }
     */
    public List<DataCiteMetadata.RightsList.Rights> getRights() {
      if (rights == null) {
        rights = new ArrayList<DataCiteMetadata.RightsList.Rights>();
      }
      return this.rights;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.RightsList.Builder<_B> _other) {
      if (this.rights == null) {
        _other.rights = null;
      } else {
        _other.rights =
            new ArrayList<
                DataCiteMetadata.RightsList.Rights.Builder<
                    DataCiteMetadata.RightsList.Builder<_B>>>();
        for (DataCiteMetadata.RightsList.Rights _item : this.rights) {
          _other.rights.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.RightsList.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.RightsList.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.RightsList.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.RightsList.Builder<Void> builder() {
      return new DataCiteMetadata.RightsList.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.RightsList.Builder<_B> copyOf(
        final DataCiteMetadata.RightsList _other) {
      final DataCiteMetadata.RightsList.Builder<_B> _newBuilder =
          new DataCiteMetadata.RightsList.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.RightsList.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree rightsPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("rights"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (rightsPropertyTree != null)
          : ((rightsPropertyTree == null) || (!rightsPropertyTree.isLeaf())))) {
        if (this.rights == null) {
          _other.rights = null;
        } else {
          _other.rights =
              new ArrayList<
                  DataCiteMetadata.RightsList.Rights.Builder<
                      DataCiteMetadata.RightsList.Builder<_B>>>();
          for (DataCiteMetadata.RightsList.Rights _item : this.rights) {
            _other.rights.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(_other, rightsPropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.RightsList.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.RightsList.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.RightsList.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.RightsList.Builder<_B> copyOf(
        final DataCiteMetadata.RightsList _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.RightsList.Builder<_B> _newBuilder =
          new DataCiteMetadata.RightsList.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.RightsList.Builder<Void> copyExcept(
        final DataCiteMetadata.RightsList _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.RightsList.Builder<Void> copyOnly(
        final DataCiteMetadata.RightsList _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", RightsList.class.getSimpleName() + "[", "]")
          .add("rights=" + rights)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      RightsList that = (RightsList) o;
      return Objects.equals(rights, that.rights);
    }

    @Override
    public int hashCode() {
      return Objects.hash(rights);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.RightsList _storedValue;
      private List<
              DataCiteMetadata.RightsList.Rights.Builder<DataCiteMetadata.RightsList.Builder<_B>>>
          rights;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.RightsList _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.rights == null) {
              this.rights = null;
            } else {
              this.rights =
                  new ArrayList<
                      DataCiteMetadata.RightsList.Rights.Builder<
                          DataCiteMetadata.RightsList.Builder<_B>>>();
              for (DataCiteMetadata.RightsList.Rights _item : _other.rights) {
                this.rights.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.RightsList _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree rightsPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("rights"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (rightsPropertyTree != null)
                : ((rightsPropertyTree == null) || (!rightsPropertyTree.isLeaf())))) {
              if (_other.rights == null) {
                this.rights = null;
              } else {
                this.rights =
                    new ArrayList<
                        DataCiteMetadata.RightsList.Rights.Builder<
                            DataCiteMetadata.RightsList.Builder<_B>>>();
                for (DataCiteMetadata.RightsList.Rights _item : _other.rights) {
                  this.rights.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(this, rightsPropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.RightsList> _P init(final _P _product) {
        if (this.rights != null) {
          final List<DataCiteMetadata.RightsList.Rights> rights =
              new ArrayList<DataCiteMetadata.RightsList.Rights>(this.rights.size());
          for (DataCiteMetadata.RightsList.Rights.Builder<DataCiteMetadata.RightsList.Builder<_B>>
              _item : this.rights) {
            rights.add(_item.build());
          }
          _product.rights = rights;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "rights"
       *
       * @param rights Items to add to the value of the "rights" property
       */
      public DataCiteMetadata.RightsList.Builder<_B> addRights(
          final Iterable<? extends DataCiteMetadata.RightsList.Rights> rights) {
        if (rights != null) {
          if (this.rights == null) {
            this.rights =
                new ArrayList<
                    DataCiteMetadata.RightsList.Rights.Builder<
                        DataCiteMetadata.RightsList.Builder<_B>>>();
          }
          for (DataCiteMetadata.RightsList.Rights _item : rights) {
            this.rights.add(
                new DataCiteMetadata.RightsList.Rights.Builder<
                    DataCiteMetadata.RightsList.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "rights" (any previous value will be replaced)
       *
       * @param rights New value of the "rights" property.
       */
      public DataCiteMetadata.RightsList.Builder<_B> withRights(
          final Iterable<? extends DataCiteMetadata.RightsList.Rights> rights) {
        if (this.rights != null) {
          this.rights.clear();
        }
        return addRights(rights);
      }

      /**
       * Adds the given items to the value of "rights"
       *
       * @param rights Items to add to the value of the "rights" property
       */
      public DataCiteMetadata.RightsList.Builder<_B> addRights(
          DataCiteMetadata.RightsList.Rights... rights) {
        addRights(Arrays.asList(rights));
        return this;
      }

      /**
       * Sets the new value of "rights" (any previous value will be replaced)
       *
       * @param rights New value of the "rights" property.
       */
      public DataCiteMetadata.RightsList.Builder<_B> withRights(
          DataCiteMetadata.RightsList.Rights... rights) {
        withRights(Arrays.asList(rights));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "Rights" property. Use {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.RightsList.Rights.Builder#end()} to return
       * to the current builder.
       *
       * @return a new builder to build an additional value of the "Rights" property. Use {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.RightsList.Rights.Builder#end()} to
       *     return to the current builder.
       */
      public DataCiteMetadata.RightsList.Rights.Builder<
              ? extends DataCiteMetadata.RightsList.Builder<_B>>
          addRights() {
        if (this.rights == null) {
          this.rights =
              new ArrayList<
                  DataCiteMetadata.RightsList.Rights.Builder<
                      DataCiteMetadata.RightsList.Builder<_B>>>();
        }
        final DataCiteMetadata.RightsList.Rights.Builder<DataCiteMetadata.RightsList.Builder<_B>>
            rights_Builder =
                new DataCiteMetadata.RightsList.Rights.Builder<
                    DataCiteMetadata.RightsList.Builder<_B>>(this, null, false);
        this.rights.add(rights_Builder);
        return rights_Builder;
      }

      @Override
      public DataCiteMetadata.RightsList build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.RightsList());
        } else {
          return ((DataCiteMetadata.RightsList) _storedValue);
        }
      }

      public DataCiteMetadata.RightsList.Builder<_B> copyOf(
          final DataCiteMetadata.RightsList _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.RightsList.Builder<_B> copyOf(
          final DataCiteMetadata.RightsList.Builder _other) {
        return copyOf(_other.build());
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="rightsURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *       &lt;attribute name="rightsIdentifier" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="rightsIdentifierScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"value"})
    public static class Rights {

      @XmlValue protected String value;

      @XmlAttribute(name = "rightsURI")
      @XmlSchemaType(name = "anyURI")
      protected String rightsURI;

      @XmlAttribute(name = "rightsIdentifier")
      @XmlSchemaType(name = "anySimpleType")
      protected String rightsIdentifier;

      @XmlAttribute(name = "rightsIdentifierScheme")
      @XmlSchemaType(name = "anySimpleType")
      protected String rightsIdentifierScheme;

      @XmlAttribute(name = "schemeURI")
      @XmlSchemaType(name = "anyURI")
      protected String schemeURI;

      @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
      protected String lang;

      /**
       * Gets the value of the value property.
       *
       * @return possible object is {@link String }
       */
      public String getValue() {
        return value;
      }

      /**
       * Sets the value of the value property.
       *
       * @param value allowed object is {@link String }
       */
      public void setValue(String value) {
        this.value = value;
      }

      /**
       * Gets the value of the rightsURI property.
       *
       * @return possible object is {@link String }
       */
      public String getRightsURI() {
        return rightsURI;
      }

      /**
       * Sets the value of the rightsURI property.
       *
       * @param value allowed object is {@link String }
       */
      public void setRightsURI(String value) {
        this.rightsURI = value;
      }

      /**
       * Gets the value of the rightsIdentifier property.
       *
       * @return possible object is {@link String }
       */
      public String getRightsIdentifier() {
        return rightsIdentifier;
      }

      /**
       * Sets the value of the rightsIdentifier property.
       *
       * @param value allowed object is {@link String }
       */
      public void setRightsIdentifier(String value) {
        this.rightsIdentifier = value;
      }

      /**
       * Gets the value of the rightsIdentifierScheme property.
       *
       * @return possible object is {@link String }
       */
      public String getRightsIdentifierScheme() {
        return rightsIdentifierScheme;
      }

      /**
       * Sets the value of the rightsIdentifierScheme property.
       *
       * @param value allowed object is {@link String }
       */
      public void setRightsIdentifierScheme(String value) {
        this.rightsIdentifierScheme = value;
      }

      /**
       * Gets the value of the schemeURI property.
       *
       * @return possible object is {@link String }
       */
      public String getSchemeURI() {
        return schemeURI;
      }

      /**
       * Sets the value of the schemeURI property.
       *
       * @param value allowed object is {@link String }
       */
      public void setSchemeURI(String value) {
        this.schemeURI = value;
      }

      /**
       * Gets the value of the lang property.
       *
       * @return possible object is {@link String }
       */
      public String getLang() {
        return lang;
      }

      /**
       * Sets the value of the lang property.
       *
       * @param value allowed object is {@link String }
       */
      public void setLang(String value) {
        this.lang = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(final DataCiteMetadata.RightsList.Rights.Builder<_B> _other) {
        _other.value = this.value;
        _other.rightsURI = this.rightsURI;
        _other.rightsIdentifier = this.rightsIdentifier;
        _other.rightsIdentifierScheme = this.rightsIdentifierScheme;
        _other.schemeURI = this.schemeURI;
        _other.lang = this.lang;
      }

      public <_B> DataCiteMetadata.RightsList.Rights.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.RightsList.Rights.Builder<_B>(_parentBuilder, this, true);
      }

      public DataCiteMetadata.RightsList.Rights.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.RightsList.Rights.Builder<Void> builder() {
        return new DataCiteMetadata.RightsList.Rights.Builder<Void>(null, null, false);
      }

      public static <_B> DataCiteMetadata.RightsList.Rights.Builder<_B> copyOf(
          final DataCiteMetadata.RightsList.Rights _other) {
        final DataCiteMetadata.RightsList.Rights.Builder<_B> _newBuilder =
            new DataCiteMetadata.RightsList.Rights.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.RightsList.Rights.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree valuePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("value"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (valuePropertyTree != null)
            : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
          _other.value = this.value;
        }
        final PropertyTree rightsURIPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("rightsURI"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (rightsURIPropertyTree != null)
            : ((rightsURIPropertyTree == null) || (!rightsURIPropertyTree.isLeaf())))) {
          _other.rightsURI = this.rightsURI;
        }
        final PropertyTree rightsIdentifierPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("rightsIdentifier"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (rightsIdentifierPropertyTree != null)
            : ((rightsIdentifierPropertyTree == null)
                || (!rightsIdentifierPropertyTree.isLeaf())))) {
          _other.rightsIdentifier = this.rightsIdentifier;
        }
        final PropertyTree rightsIdentifierSchemePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("rightsIdentifierScheme"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (rightsIdentifierSchemePropertyTree != null)
            : ((rightsIdentifierSchemePropertyTree == null)
                || (!rightsIdentifierSchemePropertyTree.isLeaf())))) {
          _other.rightsIdentifierScheme = this.rightsIdentifierScheme;
        }
        final PropertyTree schemeURIPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (schemeURIPropertyTree != null)
            : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
          _other.schemeURI = this.schemeURI;
        }
        final PropertyTree langPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("lang"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (langPropertyTree != null)
            : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
          _other.lang = this.lang;
        }
      }

      public <_B> DataCiteMetadata.RightsList.Rights.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.RightsList.Rights.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.RightsList.Rights.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.RightsList.Rights.Builder<_B> copyOf(
          final DataCiteMetadata.RightsList.Rights _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.RightsList.Rights.Builder<_B> _newBuilder =
            new DataCiteMetadata.RightsList.Rights.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.RightsList.Rights.Builder<Void> copyExcept(
          final DataCiteMetadata.RightsList.Rights _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.RightsList.Rights.Builder<Void> copyOnly(
          final DataCiteMetadata.RightsList.Rights _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", Rights.class.getSimpleName() + "[", "]")
            .add("value='" + value + "'")
            .add("rightsURI='" + rightsURI + "'")
            .add("rightsIdentifier='" + rightsIdentifier + "'")
            .add("rightsIdentifierScheme='" + rightsIdentifierScheme + "'")
            .add("schemeURI='" + schemeURI + "'")
            .add("lang='" + lang + "'")
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rights rights = (Rights) o;
        return Objects.equals(value, rights.value)
            && Objects.equals(rightsURI, rights.rightsURI)
            && Objects.equals(rightsIdentifier, rights.rightsIdentifier)
            && Objects.equals(rightsIdentifierScheme, rights.rightsIdentifierScheme)
            && Objects.equals(schemeURI, rights.schemeURI)
            && Objects.equals(lang, rights.lang);
      }

      @Override
      public int hashCode() {
        return Objects.hash(
            value, rightsURI, rightsIdentifier, rightsIdentifierScheme, schemeURI, lang);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.RightsList.Rights _storedValue;
        private String value;
        private String rightsURI;
        private String rightsIdentifier;
        private String rightsIdentifierScheme;
        private String schemeURI;
        private String lang;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.RightsList.Rights _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.value = _other.value;
              this.rightsURI = _other.rightsURI;
              this.rightsIdentifier = _other.rightsIdentifier;
              this.rightsIdentifierScheme = _other.rightsIdentifierScheme;
              this.schemeURI = _other.schemeURI;
              this.lang = _other.lang;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.RightsList.Rights _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree valuePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("value"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (valuePropertyTree != null)
                  : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                this.value = _other.value;
              }
              final PropertyTree rightsURIPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("rightsURI"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (rightsURIPropertyTree != null)
                  : ((rightsURIPropertyTree == null) || (!rightsURIPropertyTree.isLeaf())))) {
                this.rightsURI = _other.rightsURI;
              }
              final PropertyTree rightsIdentifierPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("rightsIdentifier"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (rightsIdentifierPropertyTree != null)
                  : ((rightsIdentifierPropertyTree == null)
                      || (!rightsIdentifierPropertyTree.isLeaf())))) {
                this.rightsIdentifier = _other.rightsIdentifier;
              }
              final PropertyTree rightsIdentifierSchemePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("rightsIdentifierScheme"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (rightsIdentifierSchemePropertyTree != null)
                  : ((rightsIdentifierSchemePropertyTree == null)
                      || (!rightsIdentifierSchemePropertyTree.isLeaf())))) {
                this.rightsIdentifierScheme = _other.rightsIdentifierScheme;
              }
              final PropertyTree schemeURIPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (schemeURIPropertyTree != null)
                  : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
                this.schemeURI = _other.schemeURI;
              }
              final PropertyTree langPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("lang"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (langPropertyTree != null)
                  : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
                this.lang = _other.lang;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.RightsList.Rights> _P init(final _P _product) {
          _product.value = this.value;
          _product.rightsURI = this.rightsURI;
          _product.rightsIdentifier = this.rightsIdentifier;
          _product.rightsIdentifierScheme = this.rightsIdentifierScheme;
          _product.schemeURI = this.schemeURI;
          _product.lang = this.lang;
          return _product;
        }

        /**
         * Sets the new value of "value" (any previous value will be replaced)
         *
         * @param value New value of the "value" property.
         */
        public DataCiteMetadata.RightsList.Rights.Builder<_B> withValue(final String value) {
          this.value = value;
          return this;
        }

        /**
         * Sets the new value of "rightsURI" (any previous value will be replaced)
         *
         * @param rightsURI New value of the "rightsURI" property.
         */
        public DataCiteMetadata.RightsList.Rights.Builder<_B> withRightsURI(
            final String rightsURI) {
          this.rightsURI = rightsURI;
          return this;
        }

        /**
         * Sets the new value of "rightsIdentifier" (any previous value will be replaced)
         *
         * @param rightsIdentifier New value of the "rightsIdentifier" property.
         */
        public DataCiteMetadata.RightsList.Rights.Builder<_B> withRightsIdentifier(
            final String rightsIdentifier) {
          this.rightsIdentifier = rightsIdentifier;
          return this;
        }

        /**
         * Sets the new value of "rightsIdentifierScheme" (any previous value will be replaced)
         *
         * @param rightsIdentifierScheme New value of the "rightsIdentifierScheme" property.
         */
        public DataCiteMetadata.RightsList.Rights.Builder<_B> withRightsIdentifierScheme(
            final String rightsIdentifierScheme) {
          this.rightsIdentifierScheme = rightsIdentifierScheme;
          return this;
        }

        /**
         * Sets the new value of "schemeURI" (any previous value will be replaced)
         *
         * @param schemeURI New value of the "schemeURI" property.
         */
        public DataCiteMetadata.RightsList.Rights.Builder<_B> withSchemeURI(
            final String schemeURI) {
          this.schemeURI = schemeURI;
          return this;
        }

        /**
         * Sets the new value of "lang" (any previous value will be replaced)
         *
         * @param lang New value of the "lang" property.
         */
        public DataCiteMetadata.RightsList.Rights.Builder<_B> withLang(final String lang) {
          this.lang = lang;
          return this;
        }

        @Override
        public DataCiteMetadata.RightsList.Rights build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.RightsList.Rights());
          } else {
            return ((DataCiteMetadata.RightsList.Rights) _storedValue);
          }
        }

        public DataCiteMetadata.RightsList.Rights.Builder<_B> copyOf(
            final DataCiteMetadata.RightsList.Rights _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.RightsList.Rights.Builder<_B> copyOf(
            final DataCiteMetadata.RightsList.Rights.Builder _other) {
          return copyOf(_other.build());
        }
      }

      public static class Select
          extends DataCiteMetadata.RightsList.Rights.Selector<
              DataCiteMetadata.RightsList.Rights.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.RightsList.Rights.Select _root() {
          return new DataCiteMetadata.RightsList.Rights.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            value = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            rightsURI = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            rightsIdentifier = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            rightsIdentifierScheme = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            schemeURI = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            lang = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.value != null) {
            products.put("value", this.value.init());
          }
          if (this.rightsURI != null) {
            products.put("rightsURI", this.rightsURI.init());
          }
          if (this.rightsIdentifier != null) {
            products.put("rightsIdentifier", this.rightsIdentifier.init());
          }
          if (this.rightsIdentifierScheme != null) {
            products.put("rightsIdentifierScheme", this.rightsIdentifierScheme.init());
          }
          if (this.schemeURI != null) {
            products.put("schemeURI", this.schemeURI.init());
          }
          if (this.lang != null) {
            products.put("lang", this.lang.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            value() {
          return ((this.value == null)
              ? this.value =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>(
                      this._root, this, "value")
              : this.value);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            rightsURI() {
          return ((this.rightsURI == null)
              ? this.rightsURI =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>(
                      this._root, this, "rightsURI")
              : this.rightsURI);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            rightsIdentifier() {
          return ((this.rightsIdentifier == null)
              ? this.rightsIdentifier =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>(
                      this._root, this, "rightsIdentifier")
              : this.rightsIdentifier);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            rightsIdentifierScheme() {
          return ((this.rightsIdentifierScheme == null)
              ? this.rightsIdentifierScheme =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>(
                      this._root, this, "rightsIdentifierScheme")
              : this.rightsIdentifierScheme);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            schemeURI() {
          return ((this.schemeURI == null)
              ? this.schemeURI =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>(
                      this._root, this, "schemeURI")
              : this.schemeURI);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>
            lang() {
          return ((this.lang == null)
              ? this.lang =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.RightsList.Rights.Selector<TRoot, TParent>>(
                      this._root, this, "lang")
              : this.lang);
        }
      }
    }

    public static class Select
        extends DataCiteMetadata.RightsList.Selector<DataCiteMetadata.RightsList.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.RightsList.Select _root() {
        return new DataCiteMetadata.RightsList.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.RightsList.Rights.Selector<
              TRoot, DataCiteMetadata.RightsList.Selector<TRoot, TParent>>
          rights = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.rights != null) {
          products.put("rights", this.rights.init());
        }
        return products;
      }

      public DataCiteMetadata.RightsList.Rights.Selector<
              TRoot, DataCiteMetadata.RightsList.Selector<TRoot, TParent>>
          rights() {
        return ((this.rights == null)
            ? this.rights =
                new DataCiteMetadata.RightsList.Rights.Selector<
                    TRoot, DataCiteMetadata.RightsList.Selector<TRoot, TParent>>(
                    this._root, this, "rights")
            : this.rights);
      }
    }
  }

  public static class Select extends DataCiteMetadata.Selector<DataCiteMetadata.Select, Void> {

    Select() {
      super(null, null, null);
    }

    public static DataCiteMetadata.Select _root() {
      return new DataCiteMetadata.Select();
    }
  }

  public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
      extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

    private DataCiteMetadata.Identifier.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        identifier = null;
    private DataCiteMetadata.Creators.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        creators = null;
    private DataCiteMetadata.Titles.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        titles = null;
    private DataCiteMetadata.Publisher.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        publisher = null;
    private com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        publicationYear = null;
    private DataCiteMetadata.ResourceType.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        resourceType = null;
    private DataCiteMetadata.Subjects.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        subjects = null;
    private DataCiteMetadata.Contributors.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        contributors = null;
    private DataCiteMetadata.Dates.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        dates = null;
    private com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>> language =
        null;
    private DataCiteMetadata.AlternateIdentifiers.Selector<
            TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        alternateIdentifiers = null;
    private DataCiteMetadata.RelatedIdentifiers.Selector<
            TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        relatedIdentifiers = null;
    private DataCiteMetadata.Sizes.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        sizes = null;
    private DataCiteMetadata.Formats.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        formats = null;
    private com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>> version =
        null;
    private DataCiteMetadata.RightsList.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        rightsList = null;
    private DataCiteMetadata.Descriptions.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        descriptions = null;
    private DataCiteMetadata.GeoLocations.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        geoLocations = null;
    private DataCiteMetadata.FundingReferences.Selector<
            TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        fundingReferences = null;

    public Selector(final TRoot root, final TParent parent, final String propertyName) {
      super(root, parent, propertyName);
    }

    @Override
    public Map<String, PropertyTree> buildChildren() {
      final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
      products.putAll(super.buildChildren());
      if (this.identifier != null) {
        products.put("identifier", this.identifier.init());
      }
      if (this.creators != null) {
        products.put("creators", this.creators.init());
      }
      if (this.titles != null) {
        products.put("titles", this.titles.init());
      }
      if (this.publisher != null) {
        products.put("publisher", this.publisher.init());
      }
      if (this.publicationYear != null) {
        products.put("publicationYear", this.publicationYear.init());
      }
      if (this.resourceType != null) {
        products.put("resourceType", this.resourceType.init());
      }
      if (this.subjects != null) {
        products.put("subjects", this.subjects.init());
      }
      if (this.contributors != null) {
        products.put("contributors", this.contributors.init());
      }
      if (this.dates != null) {
        products.put("dates", this.dates.init());
      }
      if (this.language != null) {
        products.put("language", this.language.init());
      }
      if (this.alternateIdentifiers != null) {
        products.put("alternateIdentifiers", this.alternateIdentifiers.init());
      }
      if (this.relatedIdentifiers != null) {
        products.put("relatedIdentifiers", this.relatedIdentifiers.init());
      }
      if (this.sizes != null) {
        products.put("sizes", this.sizes.init());
      }
      if (this.formats != null) {
        products.put("formats", this.formats.init());
      }
      if (this.version != null) {
        products.put("version", this.version.init());
      }
      if (this.rightsList != null) {
        products.put("rightsList", this.rightsList.init());
      }
      if (this.descriptions != null) {
        products.put("descriptions", this.descriptions.init());
      }
      if (this.geoLocations != null) {
        products.put("geoLocations", this.geoLocations.init());
      }
      if (this.fundingReferences != null) {
        products.put("fundingReferences", this.fundingReferences.init());
      }
      return products;
    }

    public DataCiteMetadata.Identifier.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        identifier() {
      return ((this.identifier == null)
          ? this.identifier =
              new DataCiteMetadata.Identifier.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(this._root, this, "identifier")
          : this.identifier);
    }

    public DataCiteMetadata.Creators.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        creators() {
      return ((this.creators == null)
          ? this.creators =
              new DataCiteMetadata.Creators.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(this._root, this, "creators")
          : this.creators);
    }

    public DataCiteMetadata.Titles.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        titles() {
      return ((this.titles == null)
          ? this.titles =
              new DataCiteMetadata.Titles.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(this._root, this, "titles")
          : this.titles);
    }

    public DataCiteMetadata.Publisher.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        publisher() {
      return ((this.publisher == null)
          ? this.publisher =
              new DataCiteMetadata.Publisher.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(this._root, this, "publisher")
          : this.publisher);
    }

    public com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        publicationYear() {
      return ((this.publicationYear == null)
          ? this.publicationYear =
              new com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "publicationYear")
          : this.publicationYear);
    }

    public DataCiteMetadata.ResourceType.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        resourceType() {
      return ((this.resourceType == null)
          ? this.resourceType =
              new DataCiteMetadata.ResourceType.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "resourceType")
          : this.resourceType);
    }

    public DataCiteMetadata.Subjects.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        subjects() {
      return ((this.subjects == null)
          ? this.subjects =
              new DataCiteMetadata.Subjects.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(this._root, this, "subjects")
          : this.subjects);
    }

    public DataCiteMetadata.Contributors.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        contributors() {
      return ((this.contributors == null)
          ? this.contributors =
              new DataCiteMetadata.Contributors.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "contributors")
          : this.contributors);
    }

    public DataCiteMetadata.Dates.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        dates() {
      return ((this.dates == null)
          ? this.dates =
              new DataCiteMetadata.Dates.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "dates")
          : this.dates);
    }

    public com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        language() {
      return ((this.language == null)
          ? this.language =
              new com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "language")
          : this.language);
    }

    public DataCiteMetadata.AlternateIdentifiers.Selector<
            TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        alternateIdentifiers() {
      return ((this.alternateIdentifiers == null)
          ? this.alternateIdentifiers =
              new DataCiteMetadata.AlternateIdentifiers.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "alternateIdentifiers")
          : this.alternateIdentifiers);
    }

    public DataCiteMetadata.RelatedIdentifiers.Selector<
            TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        relatedIdentifiers() {
      return ((this.relatedIdentifiers == null)
          ? this.relatedIdentifiers =
              new DataCiteMetadata.RelatedIdentifiers.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "relatedIdentifiers")
          : this.relatedIdentifiers);
    }

    public DataCiteMetadata.Sizes.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        sizes() {
      return ((this.sizes == null)
          ? this.sizes =
              new DataCiteMetadata.Sizes.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "sizes")
          : this.sizes);
    }

    public DataCiteMetadata.Formats.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        formats() {
      return ((this.formats == null)
          ? this.formats =
              new DataCiteMetadata.Formats.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(this._root, this, "formats")
          : this.formats);
    }

    public com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>> version() {
      return ((this.version == null)
          ? this.version =
              new com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "version")
          : this.version);
    }

    public DataCiteMetadata.RightsList.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        rightsList() {
      return ((this.rightsList == null)
          ? this.rightsList =
              new DataCiteMetadata.RightsList.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(this._root, this, "rightsList")
          : this.rightsList);
    }

    public DataCiteMetadata.Descriptions.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        descriptions() {
      return ((this.descriptions == null)
          ? this.descriptions =
              new DataCiteMetadata.Descriptions.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "descriptions")
          : this.descriptions);
    }

    public DataCiteMetadata.GeoLocations.Selector<TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        geoLocations() {
      return ((this.geoLocations == null)
          ? this.geoLocations =
              new DataCiteMetadata.GeoLocations.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "geoLocations")
          : this.geoLocations);
    }

    public DataCiteMetadata.FundingReferences.Selector<
            TRoot, DataCiteMetadata.Selector<TRoot, TParent>>
        fundingReferences() {
      return ((this.fundingReferences == null)
          ? this.fundingReferences =
              new DataCiteMetadata.FundingReferences.Selector<
                  TRoot, DataCiteMetadata.Selector<TRoot, TParent>>(
                  this._root, this, "fundingReferences")
          : this.fundingReferences);
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"size"})
  public static class Sizes {

    protected List<String> size;

    /**
     * Gets the value of the size property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the size property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getSize().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link String }
     */
    public List<String> getSize() {
      if (size == null) {
        size = new ArrayList<String>();
      }
      return this.size;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Sizes.Builder<_B> _other) {
      if (this.size == null) {
        _other.size = null;
      } else {
        _other.size = new ArrayList<Buildable>();
        for (String _item : this.size) {
          _other.size.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
        }
      }
    }

    public <_B> DataCiteMetadata.Sizes.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Sizes.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Sizes.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Sizes.Builder<Void> builder() {
      return new DataCiteMetadata.Sizes.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Sizes.Builder<_B> copyOf(
        final DataCiteMetadata.Sizes _other) {
      final DataCiteMetadata.Sizes.Builder<_B> _newBuilder =
          new DataCiteMetadata.Sizes.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Sizes.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree sizePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("size"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (sizePropertyTree != null)
          : ((sizePropertyTree == null) || (!sizePropertyTree.isLeaf())))) {
        if (this.size == null) {
          _other.size = null;
        } else {
          _other.size = new ArrayList<Buildable>();
          for (String _item : this.size) {
            _other.size.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.Sizes.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Sizes.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Sizes.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Sizes.Builder<_B> copyOf(
        final DataCiteMetadata.Sizes _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Sizes.Builder<_B> _newBuilder =
          new DataCiteMetadata.Sizes.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Sizes.Builder<Void> copyExcept(
        final DataCiteMetadata.Sizes _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Sizes.Builder<Void> copyOnly(
        final DataCiteMetadata.Sizes _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Sizes.class.getSimpleName() + "[", "]")
          .add("size=" + size)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Sizes sizes = (Sizes) o;
      return Objects.equals(size, sizes.size);
    }

    @Override
    public int hashCode() {
      return Objects.hash(size);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Sizes _storedValue;
      private List<Buildable> size;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.Sizes _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.size == null) {
              this.size = null;
            } else {
              this.size = new ArrayList<Buildable>();
              for (String _item : _other.size) {
                this.size.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Sizes _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree sizePropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("size"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (sizePropertyTree != null)
                : ((sizePropertyTree == null) || (!sizePropertyTree.isLeaf())))) {
              if (_other.size == null) {
                this.size = null;
              } else {
                this.size = new ArrayList<Buildable>();
                for (String _item : _other.size) {
                  this.size.add(((_item == null) ? null : new Buildable.PrimitiveBuildable(_item)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Sizes> _P init(final _P _product) {
        if (this.size != null) {
          final List<String> size = new ArrayList<String>(this.size.size());
          for (Buildable _item : this.size) {
            size.add(((String) _item.build()));
          }
          _product.size = size;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "size"
       *
       * @param size Items to add to the value of the "size" property
       */
      public DataCiteMetadata.Sizes.Builder<_B> addSize(final Iterable<? extends String> size) {
        if (size != null) {
          if (this.size == null) {
            this.size = new ArrayList<Buildable>();
          }
          for (String _item : size) {
            this.size.add(new Buildable.PrimitiveBuildable(_item));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "size" (any previous value will be replaced)
       *
       * @param size New value of the "size" property.
       */
      public DataCiteMetadata.Sizes.Builder<_B> withSize(final Iterable<? extends String> size) {
        if (this.size != null) {
          this.size.clear();
        }
        return addSize(size);
      }

      /**
       * Adds the given items to the value of "size"
       *
       * @param size Items to add to the value of the "size" property
       */
      public DataCiteMetadata.Sizes.Builder<_B> addSize(String... size) {
        addSize(Arrays.asList(size));
        return this;
      }

      /**
       * Sets the new value of "size" (any previous value will be replaced)
       *
       * @param size New value of the "size" property.
       */
      public DataCiteMetadata.Sizes.Builder<_B> withSize(String... size) {
        withSize(Arrays.asList(size));
        return this;
      }

      @Override
      public DataCiteMetadata.Sizes build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Sizes());
        } else {
          return ((DataCiteMetadata.Sizes) _storedValue);
        }
      }

      public DataCiteMetadata.Sizes.Builder<_B> copyOf(final DataCiteMetadata.Sizes _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Sizes.Builder<_B> copyOf(
          final DataCiteMetadata.Sizes.Builder _other) {
        return copyOf(_other.build());
      }
    }

    public static class Select
        extends DataCiteMetadata.Sizes.Selector<DataCiteMetadata.Sizes.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Sizes.Select _root() {
        return new DataCiteMetadata.Sizes.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Sizes.Selector<TRoot, TParent>>
          size = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.size != null) {
          products.put("size", this.size.init());
        }
        return products;
      }

      public com.kscs.util.jaxb.Selector<TRoot, DataCiteMetadata.Sizes.Selector<TRoot, TParent>>
          size() {
        return ((this.size == null)
            ? this.size =
                new com.kscs.util.jaxb.Selector<
                    TRoot, DataCiteMetadata.Sizes.Selector<TRoot, TParent>>(
                    this._root, this, "size")
            : this.size);
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="subject" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;simpleContent&gt;
   *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                 &lt;attribute name="subjectScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
   *                 &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
   *                 &lt;attribute name="valueURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
   *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
   *               &lt;/extension&gt;
   *             &lt;/simpleContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"subject"})
  public static class Subjects {

    protected List<DataCiteMetadata.Subjects.Subject> subject;

    /**
     * Gets the value of the subject property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the subject property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getSubject().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.Subjects.Subject }
     */
    public List<DataCiteMetadata.Subjects.Subject> getSubject() {
      if (subject == null) {
        subject = new ArrayList<DataCiteMetadata.Subjects.Subject>();
      }
      return this.subject;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Subjects.Builder<_B> _other) {
      if (this.subject == null) {
        _other.subject = null;
      } else {
        _other.subject =
            new ArrayList<
                DataCiteMetadata.Subjects.Subject.Builder<DataCiteMetadata.Subjects.Builder<_B>>>();
        for (DataCiteMetadata.Subjects.Subject _item : this.subject) {
          _other.subject.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.Subjects.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Subjects.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Subjects.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Subjects.Builder<Void> builder() {
      return new DataCiteMetadata.Subjects.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Subjects.Builder<_B> copyOf(
        final DataCiteMetadata.Subjects _other) {
      final DataCiteMetadata.Subjects.Builder<_B> _newBuilder =
          new DataCiteMetadata.Subjects.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Subjects.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree subjectPropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("subject"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (subjectPropertyTree != null)
          : ((subjectPropertyTree == null) || (!subjectPropertyTree.isLeaf())))) {
        if (this.subject == null) {
          _other.subject = null;
        } else {
          _other.subject =
              new ArrayList<
                  DataCiteMetadata.Subjects.Subject.Builder<
                      DataCiteMetadata.Subjects.Builder<_B>>>();
          for (DataCiteMetadata.Subjects.Subject _item : this.subject) {
            _other.subject.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(_other, subjectPropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.Subjects.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Subjects.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Subjects.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Subjects.Builder<_B> copyOf(
        final DataCiteMetadata.Subjects _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Subjects.Builder<_B> _newBuilder =
          new DataCiteMetadata.Subjects.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Subjects.Builder<Void> copyExcept(
        final DataCiteMetadata.Subjects _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Subjects.Builder<Void> copyOnly(
        final DataCiteMetadata.Subjects _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Subjects.class.getSimpleName() + "[", "]")
          .add("subject=" + subject)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Subjects subjects = (Subjects) o;
      return Objects.equals(subject, subjects.subject);
    }

    @Override
    public int hashCode() {
      return Objects.hash(subject);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Subjects _storedValue;
      private List<DataCiteMetadata.Subjects.Subject.Builder<DataCiteMetadata.Subjects.Builder<_B>>>
          subject;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.Subjects _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.subject == null) {
              this.subject = null;
            } else {
              this.subject =
                  new ArrayList<
                      DataCiteMetadata.Subjects.Subject.Builder<
                          DataCiteMetadata.Subjects.Builder<_B>>>();
              for (DataCiteMetadata.Subjects.Subject _item : _other.subject) {
                this.subject.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Subjects _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree subjectPropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("subject"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (subjectPropertyTree != null)
                : ((subjectPropertyTree == null) || (!subjectPropertyTree.isLeaf())))) {
              if (_other.subject == null) {
                this.subject = null;
              } else {
                this.subject =
                    new ArrayList<
                        DataCiteMetadata.Subjects.Subject.Builder<
                            DataCiteMetadata.Subjects.Builder<_B>>>();
                for (DataCiteMetadata.Subjects.Subject _item : _other.subject) {
                  this.subject.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(this, subjectPropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Subjects> _P init(final _P _product) {
        if (this.subject != null) {
          final List<DataCiteMetadata.Subjects.Subject> subject =
              new ArrayList<DataCiteMetadata.Subjects.Subject>(this.subject.size());
          for (DataCiteMetadata.Subjects.Subject.Builder<DataCiteMetadata.Subjects.Builder<_B>>
              _item : this.subject) {
            subject.add(_item.build());
          }
          _product.subject = subject;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "subject"
       *
       * @param subject Items to add to the value of the "subject" property
       */
      public DataCiteMetadata.Subjects.Builder<_B> addSubject(
          final Iterable<? extends DataCiteMetadata.Subjects.Subject> subject) {
        if (subject != null) {
          if (this.subject == null) {
            this.subject =
                new ArrayList<
                    DataCiteMetadata.Subjects.Subject.Builder<
                        DataCiteMetadata.Subjects.Builder<_B>>>();
          }
          for (DataCiteMetadata.Subjects.Subject _item : subject) {
            this.subject.add(
                new DataCiteMetadata.Subjects.Subject.Builder<
                    DataCiteMetadata.Subjects.Builder<_B>>(this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "subject" (any previous value will be replaced)
       *
       * @param subject New value of the "subject" property.
       */
      public DataCiteMetadata.Subjects.Builder<_B> withSubject(
          final Iterable<? extends DataCiteMetadata.Subjects.Subject> subject) {
        if (this.subject != null) {
          this.subject.clear();
        }
        return addSubject(subject);
      }

      /**
       * Adds the given items to the value of "subject"
       *
       * @param subject Items to add to the value of the "subject" property
       */
      public DataCiteMetadata.Subjects.Builder<_B> addSubject(
          DataCiteMetadata.Subjects.Subject... subject) {
        addSubject(Arrays.asList(subject));
        return this;
      }

      /**
       * Sets the new value of "subject" (any previous value will be replaced)
       *
       * @param subject New value of the "subject" property.
       */
      public DataCiteMetadata.Subjects.Builder<_B> withSubject(
          DataCiteMetadata.Subjects.Subject... subject) {
        withSubject(Arrays.asList(subject));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "Subject" property. Use {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.Subjects.Subject.Builder#end()} to return
       * to the current builder.
       *
       * @return a new builder to build an additional value of the "Subject" property. Use {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Subjects.Subject.Builder#end()} to
       *     return to the current builder.
       */
      public DataCiteMetadata.Subjects.Subject.Builder<
              ? extends DataCiteMetadata.Subjects.Builder<_B>>
          addSubject() {
        if (this.subject == null) {
          this.subject =
              new ArrayList<
                  DataCiteMetadata.Subjects.Subject.Builder<
                      DataCiteMetadata.Subjects.Builder<_B>>>();
        }
        final DataCiteMetadata.Subjects.Subject.Builder<DataCiteMetadata.Subjects.Builder<_B>>
            subject_Builder =
                new DataCiteMetadata.Subjects.Subject.Builder<
                    DataCiteMetadata.Subjects.Builder<_B>>(this, null, false);
        this.subject.add(subject_Builder);
        return subject_Builder;
      }

      @Override
      public DataCiteMetadata.Subjects build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Subjects());
        } else {
          return ((DataCiteMetadata.Subjects) _storedValue);
        }
      }

      public DataCiteMetadata.Subjects.Builder<_B> copyOf(final DataCiteMetadata.Subjects _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Subjects.Builder<_B> copyOf(
          final DataCiteMetadata.Subjects.Builder _other) {
        return copyOf(_other.build());
      }
    }

    public static class Select
        extends DataCiteMetadata.Subjects.Selector<DataCiteMetadata.Subjects.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Subjects.Select _root() {
        return new DataCiteMetadata.Subjects.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.Subjects.Subject.Selector<
              TRoot, DataCiteMetadata.Subjects.Selector<TRoot, TParent>>
          subject = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.subject != null) {
          products.put("subject", this.subject.init());
        }
        return products;
      }

      public DataCiteMetadata.Subjects.Subject.Selector<
              TRoot, DataCiteMetadata.Subjects.Selector<TRoot, TParent>>
          subject() {
        return ((this.subject == null)
            ? this.subject =
                new DataCiteMetadata.Subjects.Subject.Selector<
                    TRoot, DataCiteMetadata.Subjects.Selector<TRoot, TParent>>(
                    this._root, this, "subject")
            : this.subject);
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="subjectScheme" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *       &lt;attribute name="valueURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"value"})
    public static class Subject {

      @XmlValue protected String value;

      @XmlAttribute(name = "subjectScheme")
      @XmlSchemaType(name = "anySimpleType")
      protected String subjectScheme;

      @XmlAttribute(name = "schemeURI")
      @XmlSchemaType(name = "anyURI")
      protected String schemeURI;

      @XmlAttribute(name = "valueURI")
      @XmlSchemaType(name = "anyURI")
      protected String valueURI;

      @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
      protected String lang;

      /**
       * Gets the value of the value property.
       *
       * @return possible object is {@link String }
       */
      public String getValue() {
        return value;
      }

      /**
       * Sets the value of the value property.
       *
       * @param value allowed object is {@link String }
       */
      public void setValue(String value) {
        this.value = value;
      }

      /**
       * Gets the value of the subjectScheme property.
       *
       * @return possible object is {@link String }
       */
      public String getSubjectScheme() {
        return subjectScheme;
      }

      /**
       * Sets the value of the subjectScheme property.
       *
       * @param value allowed object is {@link String }
       */
      public void setSubjectScheme(String value) {
        this.subjectScheme = value;
      }

      /**
       * Gets the value of the schemeURI property.
       *
       * @return possible object is {@link String }
       */
      public String getSchemeURI() {
        return schemeURI;
      }

      /**
       * Sets the value of the schemeURI property.
       *
       * @param value allowed object is {@link String }
       */
      public void setSchemeURI(String value) {
        this.schemeURI = value;
      }

      /**
       * Gets the value of the valueURI property.
       *
       * @return possible object is {@link String }
       */
      public String getValueURI() {
        return valueURI;
      }

      /**
       * Sets the value of the valueURI property.
       *
       * @param value allowed object is {@link String }
       */
      public void setValueURI(String value) {
        this.valueURI = value;
      }

      /**
       * Gets the value of the lang property.
       *
       * @return possible object is {@link String }
       */
      public String getLang() {
        return lang;
      }

      /**
       * Sets the value of the lang property.
       *
       * @param value allowed object is {@link String }
       */
      public void setLang(String value) {
        this.lang = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(final DataCiteMetadata.Subjects.Subject.Builder<_B> _other) {
        _other.value = this.value;
        _other.subjectScheme = this.subjectScheme;
        _other.schemeURI = this.schemeURI;
        _other.valueURI = this.valueURI;
        _other.lang = this.lang;
      }

      public <_B> DataCiteMetadata.Subjects.Subject.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.Subjects.Subject.Builder<_B>(_parentBuilder, this, true);
      }

      public DataCiteMetadata.Subjects.Subject.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.Subjects.Subject.Builder<Void> builder() {
        return new DataCiteMetadata.Subjects.Subject.Builder<Void>(null, null, false);
      }

      public static <_B> DataCiteMetadata.Subjects.Subject.Builder<_B> copyOf(
          final DataCiteMetadata.Subjects.Subject _other) {
        final DataCiteMetadata.Subjects.Subject.Builder<_B> _newBuilder =
            new DataCiteMetadata.Subjects.Subject.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.Subjects.Subject.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree valuePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("value"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (valuePropertyTree != null)
            : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
          _other.value = this.value;
        }
        final PropertyTree subjectSchemePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("subjectScheme"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (subjectSchemePropertyTree != null)
            : ((subjectSchemePropertyTree == null) || (!subjectSchemePropertyTree.isLeaf())))) {
          _other.subjectScheme = this.subjectScheme;
        }
        final PropertyTree schemeURIPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (schemeURIPropertyTree != null)
            : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
          _other.schemeURI = this.schemeURI;
        }
        final PropertyTree valueURIPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("valueURI"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (valueURIPropertyTree != null)
            : ((valueURIPropertyTree == null) || (!valueURIPropertyTree.isLeaf())))) {
          _other.valueURI = this.valueURI;
        }
        final PropertyTree langPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("lang"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (langPropertyTree != null)
            : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
          _other.lang = this.lang;
        }
      }

      public <_B> DataCiteMetadata.Subjects.Subject.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.Subjects.Subject.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.Subjects.Subject.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.Subjects.Subject.Builder<_B> copyOf(
          final DataCiteMetadata.Subjects.Subject _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.Subjects.Subject.Builder<_B> _newBuilder =
            new DataCiteMetadata.Subjects.Subject.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.Subjects.Subject.Builder<Void> copyExcept(
          final DataCiteMetadata.Subjects.Subject _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.Subjects.Subject.Builder<Void> copyOnly(
          final DataCiteMetadata.Subjects.Subject _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", Subject.class.getSimpleName() + "[", "]")
            .add("value='" + value + "'")
            .add("subjectScheme='" + subjectScheme + "'")
            .add("schemeURI='" + schemeURI + "'")
            .add("valueURI='" + valueURI + "'")
            .add("lang='" + lang + "'")
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(value, subject.value)
            && Objects.equals(subjectScheme, subject.subjectScheme)
            && Objects.equals(schemeURI, subject.schemeURI)
            && Objects.equals(valueURI, subject.valueURI)
            && Objects.equals(lang, subject.lang);
      }

      @Override
      public int hashCode() {
        return Objects.hash(value, subjectScheme, schemeURI, valueURI, lang);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.Subjects.Subject _storedValue;
        private String value;
        private String subjectScheme;
        private String schemeURI;
        private String valueURI;
        private String lang;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Subjects.Subject _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.value = _other.value;
              this.subjectScheme = _other.subjectScheme;
              this.schemeURI = _other.schemeURI;
              this.valueURI = _other.valueURI;
              this.lang = _other.lang;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Subjects.Subject _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree valuePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("value"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (valuePropertyTree != null)
                  : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                this.value = _other.value;
              }
              final PropertyTree subjectSchemePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("subjectScheme"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (subjectSchemePropertyTree != null)
                  : ((subjectSchemePropertyTree == null)
                      || (!subjectSchemePropertyTree.isLeaf())))) {
                this.subjectScheme = _other.subjectScheme;
              }
              final PropertyTree schemeURIPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("schemeURI"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (schemeURIPropertyTree != null)
                  : ((schemeURIPropertyTree == null) || (!schemeURIPropertyTree.isLeaf())))) {
                this.schemeURI = _other.schemeURI;
              }
              final PropertyTree valueURIPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("valueURI"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (valueURIPropertyTree != null)
                  : ((valueURIPropertyTree == null) || (!valueURIPropertyTree.isLeaf())))) {
                this.valueURI = _other.valueURI;
              }
              final PropertyTree langPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("lang"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (langPropertyTree != null)
                  : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
                this.lang = _other.lang;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.Subjects.Subject> _P init(final _P _product) {
          _product.value = this.value;
          _product.subjectScheme = this.subjectScheme;
          _product.schemeURI = this.schemeURI;
          _product.valueURI = this.valueURI;
          _product.lang = this.lang;
          return _product;
        }

        /**
         * Sets the new value of "value" (any previous value will be replaced)
         *
         * @param value New value of the "value" property.
         */
        public DataCiteMetadata.Subjects.Subject.Builder<_B> withValue(final String value) {
          this.value = value;
          return this;
        }

        /**
         * Sets the new value of "subjectScheme" (any previous value will be replaced)
         *
         * @param subjectScheme New value of the "subjectScheme" property.
         */
        public DataCiteMetadata.Subjects.Subject.Builder<_B> withSubjectScheme(
            final String subjectScheme) {
          this.subjectScheme = subjectScheme;
          return this;
        }

        /**
         * Sets the new value of "schemeURI" (any previous value will be replaced)
         *
         * @param schemeURI New value of the "schemeURI" property.
         */
        public DataCiteMetadata.Subjects.Subject.Builder<_B> withSchemeURI(final String schemeURI) {
          this.schemeURI = schemeURI;
          return this;
        }

        /**
         * Sets the new value of "valueURI" (any previous value will be replaced)
         *
         * @param valueURI New value of the "valueURI" property.
         */
        public DataCiteMetadata.Subjects.Subject.Builder<_B> withValueURI(final String valueURI) {
          this.valueURI = valueURI;
          return this;
        }

        /**
         * Sets the new value of "lang" (any previous value will be replaced)
         *
         * @param lang New value of the "lang" property.
         */
        public DataCiteMetadata.Subjects.Subject.Builder<_B> withLang(final String lang) {
          this.lang = lang;
          return this;
        }

        @Override
        public DataCiteMetadata.Subjects.Subject build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.Subjects.Subject());
          } else {
            return ((DataCiteMetadata.Subjects.Subject) _storedValue);
          }
        }

        public DataCiteMetadata.Subjects.Subject.Builder<_B> copyOf(
            final DataCiteMetadata.Subjects.Subject _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.Subjects.Subject.Builder<_B> copyOf(
            final DataCiteMetadata.Subjects.Subject.Builder _other) {
          return copyOf(_other.build());
        }
      }

      public static class Select
          extends DataCiteMetadata.Subjects.Subject.Selector<
              DataCiteMetadata.Subjects.Subject.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.Subjects.Subject.Select _root() {
          return new DataCiteMetadata.Subjects.Subject.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            value = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            subjectScheme = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            schemeURI = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            valueURI = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            lang = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.value != null) {
            products.put("value", this.value.init());
          }
          if (this.subjectScheme != null) {
            products.put("subjectScheme", this.subjectScheme.init());
          }
          if (this.schemeURI != null) {
            products.put("schemeURI", this.schemeURI.init());
          }
          if (this.valueURI != null) {
            products.put("valueURI", this.valueURI.init());
          }
          if (this.lang != null) {
            products.put("lang", this.lang.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            value() {
          return ((this.value == null)
              ? this.value =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>(
                      this._root, this, "value")
              : this.value);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            subjectScheme() {
          return ((this.subjectScheme == null)
              ? this.subjectScheme =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>(
                      this._root, this, "subjectScheme")
              : this.subjectScheme);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            schemeURI() {
          return ((this.schemeURI == null)
              ? this.schemeURI =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>(
                      this._root, this, "schemeURI")
              : this.schemeURI);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            valueURI() {
          return ((this.valueURI == null)
              ? this.valueURI =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>(
                      this._root, this, "valueURI")
              : this.valueURI);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>
            lang() {
          return ((this.lang == null)
              ? this.lang =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Subjects.Subject.Selector<TRoot, TParent>>(
                      this._root, this, "lang")
              : this.lang);
        }
      }
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="title" maxOccurs="unbounded"&gt;
   *           &lt;complexType&gt;
   *             &lt;simpleContent&gt;
   *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
   *                 &lt;attribute name="titleType" type="{http://datacite.org/schema/kernel-4}titleType" /&gt;
   *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
   *               &lt;/extension&gt;
   *             &lt;/simpleContent&gt;
   *           &lt;/complexType&gt;
   *         &lt;/element&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"title"})
  public static class Titles {

    @XmlElement(required = true)
    protected List<DataCiteMetadata.Titles.Title> title;

    /**
     * Gets the value of the title property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the title property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getTitle().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * DataCiteMetadata.Titles.Title }
     */
    public List<DataCiteMetadata.Titles.Title> getTitle() {
      if (title == null) {
        title = new ArrayList<DataCiteMetadata.Titles.Title>();
      }
      return this.title;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(final DataCiteMetadata.Titles.Builder<_B> _other) {
      if (this.title == null) {
        _other.title = null;
      } else {
        _other.title =
            new ArrayList<
                DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>>();
        for (DataCiteMetadata.Titles.Title _item : this.title) {
          _other.title.add(((_item == null) ? null : _item.newCopyBuilder(_other)));
        }
      }
    }

    public <_B> DataCiteMetadata.Titles.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
      return new DataCiteMetadata.Titles.Builder<_B>(_parentBuilder, this, true);
    }

    public DataCiteMetadata.Titles.Builder<Void> newCopyBuilder() {
      return newCopyBuilder(null);
    }

    public static DataCiteMetadata.Titles.Builder<Void> builder() {
      return new DataCiteMetadata.Titles.Builder<Void>(null, null, false);
    }

    public static <_B> DataCiteMetadata.Titles.Builder<_B> copyOf(
        final DataCiteMetadata.Titles _other) {
      final DataCiteMetadata.Titles.Builder<_B> _newBuilder =
          new DataCiteMetadata.Titles.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder);
      return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
     * method and should not be called directly by client code.
     *
     * @param _other A builder instance to which the state of this object will be copied.
     */
    public <_B> void copyTo(
        final DataCiteMetadata.Titles.Builder<_B> _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final PropertyTree titlePropertyTree =
          ((_propertyTree == null) ? null : _propertyTree.get("title"));
      if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
          ? (titlePropertyTree != null)
          : ((titlePropertyTree == null) || (!titlePropertyTree.isLeaf())))) {
        if (this.title == null) {
          _other.title = null;
        } else {
          _other.title =
              new ArrayList<
                  DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>>();
          for (DataCiteMetadata.Titles.Title _item : this.title) {
            _other.title.add(
                ((_item == null)
                    ? null
                    : _item.newCopyBuilder(_other, titlePropertyTree, _propertyTreeUse)));
          }
        }
      }
    }

    public <_B> DataCiteMetadata.Titles.Builder<_B> newCopyBuilder(
        final _B _parentBuilder,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      return new DataCiteMetadata.Titles.Builder<_B>(
          _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public DataCiteMetadata.Titles.Builder<Void> newCopyBuilder(
        final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
      return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static <_B> DataCiteMetadata.Titles.Builder<_B> copyOf(
        final DataCiteMetadata.Titles _other,
        final PropertyTree _propertyTree,
        final PropertyTreeUse _propertyTreeUse) {
      final DataCiteMetadata.Titles.Builder<_B> _newBuilder =
          new DataCiteMetadata.Titles.Builder<_B>(null, null, false);
      _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
      return _newBuilder;
    }

    public static DataCiteMetadata.Titles.Builder<Void> copyExcept(
        final DataCiteMetadata.Titles _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static DataCiteMetadata.Titles.Builder<Void> copyOnly(
        final DataCiteMetadata.Titles _other, final PropertyTree _propertyTree) {
      return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Titles.class.getSimpleName() + "[", "]")
          .add("title=" + title)
          .toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Titles titles = (Titles) o;
      return Objects.equals(title, titles.title);
    }

    @Override
    public int hashCode() {
      return Objects.hash(title);
    }

    public static class Builder<_B> implements Buildable {

      protected final _B _parentBuilder;
      protected final DataCiteMetadata.Titles _storedValue;
      private List<DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>>
          title;

      public Builder(
          final _B _parentBuilder, final DataCiteMetadata.Titles _other, final boolean _copy) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            if (_other.title == null) {
              this.title = null;
            } else {
              this.title =
                  new ArrayList<
                      DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>>();
              for (DataCiteMetadata.Titles.Title _item : _other.title) {
                this.title.add(((_item == null) ? null : _item.newCopyBuilder(this)));
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public Builder(
          final _B _parentBuilder,
          final DataCiteMetadata.Titles _other,
          final boolean _copy,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        this._parentBuilder = _parentBuilder;
        if (_other != null) {
          if (_copy) {
            _storedValue = null;
            final PropertyTree titlePropertyTree =
                ((_propertyTree == null) ? null : _propertyTree.get("title"));
            if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                ? (titlePropertyTree != null)
                : ((titlePropertyTree == null) || (!titlePropertyTree.isLeaf())))) {
              if (_other.title == null) {
                this.title = null;
              } else {
                this.title =
                    new ArrayList<
                        DataCiteMetadata.Titles.Title.Builder<
                            DataCiteMetadata.Titles.Builder<_B>>>();
                for (DataCiteMetadata.Titles.Title _item : _other.title) {
                  this.title.add(
                      ((_item == null)
                          ? null
                          : _item.newCopyBuilder(this, titlePropertyTree, _propertyTreeUse)));
                }
              }
            }
          } else {
            _storedValue = _other;
          }
        } else {
          _storedValue = null;
        }
      }

      public _B end() {
        return this._parentBuilder;
      }

      protected <_P extends DataCiteMetadata.Titles> _P init(final _P _product) {
        if (this.title != null) {
          final List<DataCiteMetadata.Titles.Title> title =
              new ArrayList<DataCiteMetadata.Titles.Title>(this.title.size());
          for (DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>> _item :
              this.title) {
            title.add(_item.build());
          }
          _product.title = title;
        }
        return _product;
      }

      /**
       * Adds the given items to the value of "title"
       *
       * @param title Items to add to the value of the "title" property
       */
      public DataCiteMetadata.Titles.Builder<_B> addTitle(
          final Iterable<? extends DataCiteMetadata.Titles.Title> title) {
        if (title != null) {
          if (this.title == null) {
            this.title =
                new ArrayList<
                    DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>>();
          }
          for (DataCiteMetadata.Titles.Title _item : title) {
            this.title.add(
                new DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>(
                    this, _item, false));
          }
        }
        return this;
      }

      /**
       * Sets the new value of "title" (any previous value will be replaced)
       *
       * @param title New value of the "title" property.
       */
      public DataCiteMetadata.Titles.Builder<_B> withTitle(
          final Iterable<? extends DataCiteMetadata.Titles.Title> title) {
        if (this.title != null) {
          this.title.clear();
        }
        return addTitle(title);
      }

      /**
       * Adds the given items to the value of "title"
       *
       * @param title Items to add to the value of the "title" property
       */
      public DataCiteMetadata.Titles.Builder<_B> addTitle(DataCiteMetadata.Titles.Title... title) {
        addTitle(Arrays.asList(title));
        return this;
      }

      /**
       * Sets the new value of "title" (any previous value will be replaced)
       *
       * @param title New value of the "title" property.
       */
      public DataCiteMetadata.Titles.Builder<_B> withTitle(DataCiteMetadata.Titles.Title... title) {
        withTitle(Arrays.asList(title));
        return this;
      }

      /**
       * Returns a new builder to build an additional value of the "Title" property. Use {@link
       * org.gbif.doi.metadata.datacite.DataCiteMetadata.Titles.Title.Builder#end()} to return to
       * the current builder.
       *
       * @return a new builder to build an additional value of the "Title" property. Use {@link
       *     org.gbif.doi.metadata.datacite.DataCiteMetadata.Titles.Title.Builder#end()} to return
       *     to the current builder.
       */
      public DataCiteMetadata.Titles.Title.Builder<? extends DataCiteMetadata.Titles.Builder<_B>>
          addTitle() {
        if (this.title == null) {
          this.title =
              new ArrayList<
                  DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>>();
        }
        final DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>
            title_Builder =
                new DataCiteMetadata.Titles.Title.Builder<DataCiteMetadata.Titles.Builder<_B>>(
                    this, null, false);
        this.title.add(title_Builder);
        return title_Builder;
      }

      @Override
      public DataCiteMetadata.Titles build() {
        if (_storedValue == null) {
          return this.init(new DataCiteMetadata.Titles());
        } else {
          return ((DataCiteMetadata.Titles) _storedValue);
        }
      }

      public DataCiteMetadata.Titles.Builder<_B> copyOf(final DataCiteMetadata.Titles _other) {
        _other.copyTo(this);
        return this;
      }

      public DataCiteMetadata.Titles.Builder<_B> copyOf(
          final DataCiteMetadata.Titles.Builder _other) {
        return copyOf(_other.build());
      }
    }

    public static class Select
        extends DataCiteMetadata.Titles.Selector<DataCiteMetadata.Titles.Select, Void> {

      Select() {
        super(null, null, null);
      }

      public static DataCiteMetadata.Titles.Select _root() {
        return new DataCiteMetadata.Titles.Select();
      }
    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
        extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

      private DataCiteMetadata.Titles.Title.Selector<
              TRoot, DataCiteMetadata.Titles.Selector<TRoot, TParent>>
          title = null;

      public Selector(final TRoot root, final TParent parent, final String propertyName) {
        super(root, parent, propertyName);
      }

      @Override
      public Map<String, PropertyTree> buildChildren() {
        final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
        products.putAll(super.buildChildren());
        if (this.title != null) {
          products.put("title", this.title.init());
        }
        return products;
      }

      public DataCiteMetadata.Titles.Title.Selector<
              TRoot, DataCiteMetadata.Titles.Selector<TRoot, TParent>>
          title() {
        return ((this.title == null)
            ? this.title =
                new DataCiteMetadata.Titles.Title.Selector<
                    TRoot, DataCiteMetadata.Titles.Selector<TRoot, TParent>>(
                    this._root, this, "title")
            : this.title);
      }
    }

    /**
     * Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="titleType" type="{http://datacite.org/schema/kernel-4}titleType" /&gt;
     *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"value"})
    public static class Title {

      @XmlValue protected String value;

      @XmlAttribute(name = "titleType")
      protected TitleType titleType;

      @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
      protected String lang;

      /**
       * Gets the value of the value property.
       *
       * @return possible object is {@link String }
       */
      public String getValue() {
        return value;
      }

      /**
       * Sets the value of the value property.
       *
       * @param value allowed object is {@link String }
       */
      public void setValue(String value) {
        this.value = value;
      }

      /**
       * Gets the value of the titleType property.
       *
       * @return possible object is {@link TitleType }
       */
      public TitleType getTitleType() {
        return titleType;
      }

      /**
       * Sets the value of the titleType property.
       *
       * @param value allowed object is {@link TitleType }
       */
      public void setTitleType(TitleType value) {
        this.titleType = value;
      }

      /**
       * Gets the value of the lang property.
       *
       * @return possible object is {@link String }
       */
      public String getLang() {
        return lang;
      }

      /**
       * Sets the value of the lang property.
       *
       * @param value allowed object is {@link String }
       */
      public void setLang(String value) {
        this.lang = value;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(final DataCiteMetadata.Titles.Title.Builder<_B> _other) {
        _other.value = this.value;
        _other.titleType = this.titleType;
        _other.lang = this.lang;
      }

      public <_B> DataCiteMetadata.Titles.Title.Builder<_B> newCopyBuilder(
          final _B _parentBuilder) {
        return new DataCiteMetadata.Titles.Title.Builder<_B>(_parentBuilder, this, true);
      }

      public DataCiteMetadata.Titles.Title.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
      }

      public static DataCiteMetadata.Titles.Title.Builder<Void> builder() {
        return new DataCiteMetadata.Titles.Title.Builder<Void>(null, null, false);
      }

      public static <_B> DataCiteMetadata.Titles.Title.Builder<_B> copyOf(
          final DataCiteMetadata.Titles.Title _other) {
        final DataCiteMetadata.Titles.Title.Builder<_B> _newBuilder =
            new DataCiteMetadata.Titles.Title.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
      }

      /**
       * Copies all state of this object to a builder. This method is used by the {@link #copyOf}
       * method and should not be called directly by client code.
       *
       * @param _other A builder instance to which the state of this object will be copied.
       */
      public <_B> void copyTo(
          final DataCiteMetadata.Titles.Title.Builder<_B> _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree valuePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("value"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (valuePropertyTree != null)
            : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
          _other.value = this.value;
        }
        final PropertyTree titleTypePropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("titleType"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (titleTypePropertyTree != null)
            : ((titleTypePropertyTree == null) || (!titleTypePropertyTree.isLeaf())))) {
          _other.titleType = this.titleType;
        }
        final PropertyTree langPropertyTree =
            ((_propertyTree == null) ? null : _propertyTree.get("lang"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
            ? (langPropertyTree != null)
            : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
          _other.lang = this.lang;
        }
      }

      public <_B> DataCiteMetadata.Titles.Title.Builder<_B> newCopyBuilder(
          final _B _parentBuilder,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        return new DataCiteMetadata.Titles.Title.Builder<_B>(
            _parentBuilder, this, true, _propertyTree, _propertyTreeUse);
      }

      public DataCiteMetadata.Titles.Title.Builder<Void> newCopyBuilder(
          final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
      }

      public static <_B> DataCiteMetadata.Titles.Title.Builder<_B> copyOf(
          final DataCiteMetadata.Titles.Title _other,
          final PropertyTree _propertyTree,
          final PropertyTreeUse _propertyTreeUse) {
        final DataCiteMetadata.Titles.Title.Builder<_B> _newBuilder =
            new DataCiteMetadata.Titles.Title.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
      }

      public static DataCiteMetadata.Titles.Title.Builder<Void> copyExcept(
          final DataCiteMetadata.Titles.Title _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
      }

      public static DataCiteMetadata.Titles.Title.Builder<Void> copyOnly(
          final DataCiteMetadata.Titles.Title _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
      }

      @Override
      public String toString() {
        return new StringJoiner(", ", Title.class.getSimpleName() + "[", "]")
            .add("value='" + value + "'")
            .add("titleType=" + titleType)
            .add("lang='" + lang + "'")
            .toString();
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(value, title.value)
            && titleType == title.titleType
            && Objects.equals(lang, title.lang);
      }

      @Override
      public int hashCode() {
        return Objects.hash(value, titleType, lang);
      }

      public static class Builder<_B> implements Buildable {

        protected final _B _parentBuilder;
        protected final DataCiteMetadata.Titles.Title _storedValue;
        private String value;
        private TitleType titleType;
        private String lang;

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Titles.Title _other,
            final boolean _copy) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              this.value = _other.value;
              this.titleType = _other.titleType;
              this.lang = _other.lang;
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public Builder(
            final _B _parentBuilder,
            final DataCiteMetadata.Titles.Title _other,
            final boolean _copy,
            final PropertyTree _propertyTree,
            final PropertyTreeUse _propertyTreeUse) {
          this._parentBuilder = _parentBuilder;
          if (_other != null) {
            if (_copy) {
              _storedValue = null;
              final PropertyTree valuePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("value"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (valuePropertyTree != null)
                  : ((valuePropertyTree == null) || (!valuePropertyTree.isLeaf())))) {
                this.value = _other.value;
              }
              final PropertyTree titleTypePropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("titleType"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (titleTypePropertyTree != null)
                  : ((titleTypePropertyTree == null) || (!titleTypePropertyTree.isLeaf())))) {
                this.titleType = _other.titleType;
              }
              final PropertyTree langPropertyTree =
                  ((_propertyTree == null) ? null : _propertyTree.get("lang"));
              if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)
                  ? (langPropertyTree != null)
                  : ((langPropertyTree == null) || (!langPropertyTree.isLeaf())))) {
                this.lang = _other.lang;
              }
            } else {
              _storedValue = _other;
            }
          } else {
            _storedValue = null;
          }
        }

        public _B end() {
          return this._parentBuilder;
        }

        protected <_P extends DataCiteMetadata.Titles.Title> _P init(final _P _product) {
          _product.value = this.value;
          _product.titleType = this.titleType;
          _product.lang = this.lang;
          return _product;
        }

        /**
         * Sets the new value of "value" (any previous value will be replaced)
         *
         * @param value New value of the "value" property.
         */
        public DataCiteMetadata.Titles.Title.Builder<_B> withValue(final String value) {
          this.value = value;
          return this;
        }

        /**
         * Sets the new value of "titleType" (any previous value will be replaced)
         *
         * @param titleType New value of the "titleType" property.
         */
        public DataCiteMetadata.Titles.Title.Builder<_B> withTitleType(final TitleType titleType) {
          this.titleType = titleType;
          return this;
        }

        /**
         * Sets the new value of "lang" (any previous value will be replaced)
         *
         * @param lang New value of the "lang" property.
         */
        public DataCiteMetadata.Titles.Title.Builder<_B> withLang(final String lang) {
          this.lang = lang;
          return this;
        }

        @Override
        public DataCiteMetadata.Titles.Title build() {
          if (_storedValue == null) {
            return this.init(new DataCiteMetadata.Titles.Title());
          } else {
            return ((DataCiteMetadata.Titles.Title) _storedValue);
          }
        }

        public DataCiteMetadata.Titles.Title.Builder<_B> copyOf(
            final DataCiteMetadata.Titles.Title _other) {
          _other.copyTo(this);
          return this;
        }

        public DataCiteMetadata.Titles.Title.Builder<_B> copyOf(
            final DataCiteMetadata.Titles.Title.Builder _other) {
          return copyOf(_other.build());
        }
      }

      public static class Select
          extends DataCiteMetadata.Titles.Title.Selector<
              DataCiteMetadata.Titles.Title.Select, Void> {

        Select() {
          super(null, null, null);
        }

        public static DataCiteMetadata.Titles.Title.Select _root() {
          return new DataCiteMetadata.Titles.Title.Select();
        }
      }

      public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?>, TParent>
          extends com.kscs.util.jaxb.Selector<TRoot, TParent> {

        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>
            value = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>
            titleType = null;
        private com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>
            lang = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
          super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
          final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
          products.putAll(super.buildChildren());
          if (this.value != null) {
            products.put("value", this.value.init());
          }
          if (this.titleType != null) {
            products.put("titleType", this.titleType.init());
          }
          if (this.lang != null) {
            products.put("lang", this.lang.init());
          }
          return products;
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>
            value() {
          return ((this.value == null)
              ? this.value =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>(
                      this._root, this, "value")
              : this.value);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>
            titleType() {
          return ((this.titleType == null)
              ? this.titleType =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>(
                      this._root, this, "titleType")
              : this.titleType);
        }

        public com.kscs.util.jaxb.Selector<
                TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>
            lang() {
          return ((this.lang == null)
              ? this.lang =
                  new com.kscs.util.jaxb.Selector<
                      TRoot, DataCiteMetadata.Titles.Title.Selector<TRoot, TParent>>(
                      this._root, this, "lang")
              : this.lang);
        }
      }
    }
  }
}
