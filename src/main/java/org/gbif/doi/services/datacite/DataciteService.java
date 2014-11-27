package org.gbif.doi.services.datacite;

import org.gbif.doi.api.DoiRegistrarException;
import org.gbif.doi.api.DoiService;
import org.gbif.doi.api.ErrorCode;
import org.gbif.doi.metadata.MetadataWriter;
import org.gbif.doi.services.BaseService;
import org.gbif.metadata.eml.Eml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import com.google.common.collect.Maps;
import freemarker.template.TemplateException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This DataCite service implementation.
 */
public class DataciteService extends BaseService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(DataciteService.class);
  private static final String CONTENT_TYPE = "application/xml;charset=UTF-8";
  private static final String METADATA_ENDPOINT_URI = "https://mds.datacite.org/metadata";

  public DataciteService(HttpClient httpClient, String username, String password) {
    super(httpClient, username, password);
  }

  @Override
  public void reserve(File f, Eml eml, String doi, String publisher, String resourceType) throws
    DoiRegistrarException {
    LOG.info("Reserving identifier: {}", doi);
    try {
      // write metadata file
      MetadataWriter.writeMetadataFile(f, eml, doi, publisher, resourceType);

      // headers
      Map<String, String> headers = Maps.newHashMap();
      headers.put(HTTP.CONTENT_TYPE, CONTENT_TYPE);

      // metadata as body
      InputStreamEntity ise = new InputStreamEntity(new FileInputStream(f), f.length());
      BufferedHttpEntity buffered = new BufferedHttpEntity(ise);

      doPost(new URI(METADATA_ENDPOINT_URI), headers, buffered);
    } catch (IOException e) {
      throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
    } catch (TemplateException e) {
      throw new DoiRegistrarException(e, ErrorCode.IO_EXCEPTION);
    } catch (URISyntaxException e) {
      throw new DoiRegistrarException(e, ErrorCode.HTTP_ERROR);
    }
  }

  @Override
  public void makePublic(String doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void getMetadata(String doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void delete(String doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void makeUnavailable(String doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void makeAvailable(String doi) throws DoiRegistrarException {
    // TODO
  }

  @Override
  public void updateMetadata(String doi) throws DoiRegistrarException {
    // TODO
  }
}
