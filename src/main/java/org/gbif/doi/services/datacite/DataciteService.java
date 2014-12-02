package org.gbif.doi.services.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.DoiException;
import org.gbif.doi.DoiExistsException;
import org.gbif.doi.DoiService;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.services.BaseService;

import java.net.URI;

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This DataCite service implementation.
 * https://mds.datacite.org/static/apidoc
 */
public class DataciteService extends BaseService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(DataciteService.class);
  private static final URI METADATA_ENDPOINT_URI = URI.create("https://mds.xsd.datacite.org/metadata");

  public DataciteService(HttpClient httpClient, String username, String password) {
    super(httpClient, username, password);
  }

  @Override
  public URI get(DOI doi) throws DoiException {
    // TODO: Write implementation
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Object getMetadata(DOI doi) throws DoiException {
    // TODO: Write implementation
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException {
    LOG.info("Reserving identifier: {}", doi);
    updateMetadataIdentifier(doi, metadata);
    //TODO: throw DoiExistsException after we detect that somehow
    post(METADATA_ENDPOINT_URI, metadata);
  }

  @Override
  public DOI reserveRandom(String prefix, DataCiteMetadata metadata) throws DoiException {
    // a random DOI might exist already so we need to try to reserve one until we find a good one.
    // to avoid endless loop do a max of 100 tries though, we should never ever reach that
    for (int x=1; x<100; x++) {
      DOI doi = random(prefix);
      try {
        reserve(doi, metadata);
        return doi;
      } catch (DoiExistsException e) {
        // this doi did exist already, mint another one
      }
    }
    LOG.error("Failed to generate a new, random DOI for prefix {}. We have tried 100 random suffices.", prefix);
    throw new DoiException("Failed to generate a new, random DOI for prefix " + prefix);
  }

  @Override
  public void register(DOI doi, DataCiteMetadata metadata) throws DoiException {
    // TODO: Write implementation
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public boolean delete(DOI doi) throws DoiException {
    // TODO: Write implementation
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public void updateMetadata(DOI doi, DataCiteMetadata metadata) throws DoiException {
    updateMetadataIdentifier(doi, metadata);
    // TODO: Write implementation
    throw new UnsupportedOperationException("Not implemented yet");
  }

}
