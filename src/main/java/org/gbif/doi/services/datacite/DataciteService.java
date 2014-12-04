package org.gbif.doi.services.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.DoiException;
import org.gbif.doi.DoiHttpException;
import org.gbif.doi.DoiService;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.services.BaseService;
import org.gbif.doi.services.ServiceConfig;

import java.net.URI;
import javax.annotation.Nullable;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This DataCite service implementation.
 * https://mds.datacite.org/static/apidoc
 */
public class DataciteService extends BaseService implements DoiService {

  private static final Logger LOG = LoggerFactory.getLogger(DataciteService.class);
  private static final URI DEFAULT_API = URI.create("https://mds.datacite.org/");
  private final URI apiWs;
  private final URI doiWs;
  private final URI metadataWs;
  private static final ContentType PALINT_TEXT_UTF8 = ContentType.create("text/plain", Charsets.UTF_8);
  // god knows why, but datacite assigns this URI to all reserved test DOIs as target URLs
  private static final URI TEST_404_TARGET = URI.create("http://www.datacite.org/testprefix");

  public DataciteService(CloseableHttpClient httpClient, ServiceConfig cfg) {
    super(httpClient, cfg);
    if (cfg.getApi() == null) {
      cfg.setApi(DEFAULT_API);
    }
    apiWs = cfg.getApi();
    doiWs = apiWs.resolve("/doi");
    metadataWs = apiWs.resolve("/metadata");
  }

  @Override
  @Nullable
  public URI get(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);
    try {
      String content = get(doiUri(doiWs, doi));
      if (!Strings.isNullOrEmpty(content)) {
        return URI.create(content);
      }
    } catch (IllegalArgumentException e) {
      LOG.debug("Invalid DOI URL", e.getMessage());
    } catch (DoiHttpException e) {
      if (Math.round( e.getStatus() / 100.0) == 4) {
        throw e;
      }
      LOG.debug("Non existing DOI", e.getMessage());
    } catch (DoiException e) {
      LOG.debug("Non existing DOI", e.getMessage());
    }
    return null;
  }

  /**
   * @return true if the DOI is reserved or registered
   */
  private boolean exists(DOI doi) throws DoiException {
    try {
      String content = get(doiUri(metadataWs, doi));
    } catch (DoiHttpException e) {

      return false;
    }
    return true;
  }

  /**
   * Checks of a DOI is publicly registered already.
   * Registered but deleted DOIs are still considered registered and return true!
   * @return true if the DOI is registered
   */
  private boolean isRegistered(DOI doi) throws DoiException {
    try {
      URI url = get(doi);
      if (url != null && !TEST_404_TARGET.equals(url)) {
        return true;
      }
    } catch (DoiHttpException e) {
    }
    return false;
  }

  @Override
  public void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(metadata);
    if (exists(doi)) {
      throw new DoiException("DOI exists already");
    }
    LOG.info("Reserving {}", doi);
    updateMetadataIdentifier(doi, metadata);
    post(doi, metadataWs, metadata);
  }

  @Override
  public DOI reserveRandom(String prefix, int length, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkArgument(length > 2, "The suffix length must be larger than 2");
    Preconditions.checkArgument(prefix.startsWith("10."), "The DOI prefix must begin with 10");

    // a random DOI might exist already so we need to try to reserve one until we find a good one.
    // to avoid endless loop do a max of 100 tries though, we should never ever reach that
    for (int x=1; x<100; x++) {
      DOI doi = random(prefix, length);
      if (!exists(doi)) {
        reserve(doi, metadata);
        return doi;
      }
    }
    LOG.error("Failed to generate a new, random DOI for prefix {}. We have tried 100 random suffices.", prefix);
    throw new DoiException("Failed to generate a new, random DOI for prefix " + prefix);
  }

  @Override
  public void register(DOI doi, URI target) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(target);
    if (isRegistered(doi)) {
      throw new DoiException("DOI was already registered");
    }
    LOG.info("Registering {}", doi);
    authCall(buildDoiUrlPost(doi, target));
  }

  @Override
  public boolean delete(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);
    LOG.info("Deleting {}", doi);
    delete(doiUri(metadataWs, doi));
    URI url = get(doi);
    return url != null;
  }

  @Override
  public void update(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(metadata);
    LOG.info("Updating metadata for {}", doi);
    updateMetadataIdentifier(doi, metadata);
    post(doi, metadataWs, metadata);
  }

  @Override
  public void update(DOI doi, URI target) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(target);
    if (!isRegistered(doi)) {
      throw new DoiException("DOI was not registered yet");
    }
    LOG.info("Updating target URL for {}", doi);
    authCall(buildDoiUrlPost(doi, target));
  }

  private HttpPost buildDoiUrlPost(DOI doi, URI target) {
    HttpPost post = new HttpPost(doiWs);
    String body = String.format("doi=%s\nurl=%s", doi.getDoiName(), target);
    HttpEntity entity = new StringEntity(body, PALINT_TEXT_UTF8);
    post.setEntity(entity);
    return post;
  }
}
