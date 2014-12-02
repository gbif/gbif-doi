package org.gbif.doi.services.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.DoiRegistrarException;
import org.gbif.doi.DoiService;
import org.gbif.doi.datacite.DataCiteMetadataV3;
import org.gbif.doi.services.BaseService;

import java.net.URI;

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This DataCite service implementation.
 */
public class DataciteService extends BaseService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(DataciteService.class);
  private static final URI METADATA_ENDPOINT_URI = URI.create("https://mds.xsd.datacite.org/metadata");

  public DataciteService(HttpClient httpClient, String username, String password) {
    super(httpClient, username, password);
  }

  @Override
  public void reserve(DOI doi, DataCiteMetadataV3 metadata, String publisher, String resourceType) throws DoiRegistrarException {
    LOG.info("Reserving identifier: {}", doi);
    postXml(METADATA_ENDPOINT_URI, metadata);
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
}
