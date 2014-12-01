package org.gbif.doi.services.ezid;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.DoiRegistrarException;
import org.gbif.doi.DoiService;
import org.gbif.doi.datacite.DataCiteMetadataV3;
import org.gbif.doi.services.BaseService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This EZID service implementation.
 */
public class EzidService extends BaseService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(EzidService.class);
  private static final String CONTENT_TYPE = "text/plain;charset=UTF-8";
  private static final String ID_ENDPOINT_URI = "https://ezid.cdlib.org/id/";

  public EzidService(HttpClient httpClient, String username, String password) {
    super(httpClient, username, password);
  }

  @Override
  public void reserve(DOI doi, DataCiteMetadataV3 metadata, String publisher, String resourceType) throws DoiRegistrarException {
    LOG.info("Reserving identifier: {}", doi);
/*    try {
      // write metadata file
      MetadataWriter.writeMetadataFile(f, eml, doi, publisher, resourceType);

      // headers
      Map<String, String> headers = Maps.newHashMap();
      headers.put(HTTP.CONTENT_TYPE, CONTENT_TYPE);
      headers.put("Accept", "text/plain");

      // metadata (map) as body
      HashMap<String, String> data = Maps.newHashMap();
      String fromFile = FileUtils.readFileToString(f);
      data.put("xsd.datacite", fromFile);
      data.put("_status", StringUtils.lowerCase(IdentifierStatus.RESERVED.toString())); // must be lower case!
      String anvl = serializeAsANVL(data);
      StringEntity myEntity = new StringEntity(anvl, "UTF-8");

      doPut(createEzidUri(doi), headers, myEntity);
    } catch (IOException e) {
      throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
    } catch (TemplateException e) {
      throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
    } catch (URISyntaxException e) {
      throw new DoiRegistrarException(e, ErrorCode.HTTP_ERROR);
    }*/
    throw new UnsupportedOperationException("Not Implemenented Yet");
  }

  @Override
  public void makePublic(DOI doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public DataCiteMetadataV3 getMetadata(DOI doi) throws DoiRegistrarException {
    // TODO
    return null;
  }

  @Override
  public void delete(DOI doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void makeUnavailable(DOI doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void makeAvailable(DOI doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void updateMetadata(DOI doi, DataCiteMetadataV3 metadata) throws DoiRegistrarException {
    // TODO
  }

  /**
   * This creates the EZID URI, and ensures that it is formatted correctly, e.g.
   * E.g. http://ezid.cdlib.org/id/doi:10.nnnn/suffix Notice the DOI must start with the DOI access schema ("doi:").
   * </br>
   * The EZID URI is used to manipulate the identifier and is used as the address in the HTTP request.
   *
   * @param doi identifier
   *
   * @return EZID URI
   *
   * @throws URISyntaxException if the the target URI could not be parsed
   */
  @VisibleForTesting
  protected URI createEzidUri(DOI doi) throws URISyntaxException {
    return new URI(ID_ENDPOINT_URI + doi.toString());
  }

  /**
   * This method serializes a map of metadata name/value pairs into an ANVL String value. If the
   * map is null, or if it is empty, then it returns a null string.
   * </br>
   * EZID metadata dictionaries must be serialized using a subset of A Name-Value Language (ANVL) rules:
   * -One element name/value pair per line.
   * -Names separated from values by colons.
   *
   * @param metadata the Map of metadata name/value pairs
   *
   * @return an ANVL String or null if no metadata name/value pairs provided
   */
  private String serializeAsANVL(HashMap<String, String> metadata) {
    StringBuffer buffer = new StringBuffer();
    if (metadata != null && !metadata.isEmpty()) {
      for (Map.Entry<String, String> entry : metadata.entrySet()) {
        buffer.append(escape(entry.getKey()) + ": " + escape(entry.getValue()) + "\n");
      }
    }
    return buffer.toString();
  }

  /**
   * This method escapes a string to produce its ANVL escaped equivalent.
   * </br>
   * Care must be taken to escape structural characters that appear in element names and values, specifically,
   * line terminators (both newlines ("\n") and carriage returns ("\r") and, in element names, colons
   * (":"). EZID employs percent-encoding as the escaping mechanism, and thus percent signs ("%") must
   * be escaped as well.
   *
   * @param str string escape
   *
   * @return the escaped String, or an empty string if the string was empty or null
   */
  private String escape(String str) {
    if (!Strings.isNullOrEmpty(str)) {
      return str.replace("%", "%25").replace("\n", "%0A").replace("\r", "%0D").replace(":", "%3A");
    }
    return "";
  }
}
