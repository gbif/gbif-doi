package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.service.DoiException;
import org.gbif.doi.service.DoiExistsException;
import org.gbif.doi.service.DoiHttpException;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.service.BaseService;
import org.gbif.doi.service.DoiStatus;
import org.gbif.doi.service.ServiceConfig;

import java.net.URI;

import com.google.common.annotations.VisibleForTesting;
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
public class DataciteService extends BaseService {

  private static final Logger LOG = LoggerFactory.getLogger(DataciteService.class);
  private static final ContentType APPLICATION_XML_UTF8 = ContentType.create("application/xml", Charsets.UTF_8);
  private static final URI DEFAULT_API = URI.create("https://mds.datacite.org/");
  // god knows why, but datacite assigns this URI to all reserved test DOIs as target URLs
  private static final URI TEST_404_TARGET = URI.create("http://www.datacite.org/testprefix");
  private final URI apiWs;
  private final URI doiWs;
  private final URI metadataWs;

  public DataciteService(CloseableHttpClient httpClient, ServiceConfig cfg) {
    super(httpClient, cfg);
    apiWs = cfg.getApi() == null ? DEFAULT_API : cfg.getApi();
    doiWs = apiWs.resolve("/doi/");
    metadataWs = apiWs.resolve("/metadata/");
  }

  /**
   * Detecting the status might need 2 calls.
   * A reserved DOI returns metadata and either the test or NULL target URL.
   * An active registered DOI returns metadata and a target URI
   * A deleted but registered DOI returns a http 410 for the metadata and still the target URI.
   */
  @Override
  public DoiStatus resolve(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);
    try {

      final URI target = getTargetUrl(doi);
      try {
        get(metadataUri(doi));
        return target == null ? new DoiStatus(DoiStatus.Status.RESERVED, null) : new DoiStatus(DoiStatus.Status.REGISTERED, target);

      } catch (DoiHttpException e) {
        // we only see a 410 for the metadata when a registered DOI was deleted
        if (e.getStatus() == 410) {
          return new DoiStatus(DoiStatus.Status.DELETED, target);
        }
      }

    } catch (DoiException e) {
      LOG.debug("Unknown error detecting DOI status", e.getMessage());
    }
    return null;
  }

  private URI getTargetUrl(DOI doi) throws DoiHttpException {
    // get target URI
    String content = null;
    try {
      content = get(doiUri(doi));
      if (!Strings.isNullOrEmpty(content)) {
        URI target = URI.create(content);
        if (!TEST_404_TARGET.equals(target)) {
          return target;
        }
      }
    } catch (IllegalArgumentException e) {
      LOG.debug("DataCite returned an invalid target URL {}", content, e.getMessage());
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
      get(metadataUri(doi));
    } catch (DoiHttpException e) {
      return false;
    }
    return true;
  }

  @Override
  public void reserve(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(metadata);
    if (exists(doi)) {
      throw new DoiExistsException(doi);
    }
    post(doi, metadataWs, metadata);
    LOG.info("Reserved {}", doi);
  }

  @Override
  public void register(DOI doi, URI target, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(target);
    Preconditions.checkNotNull(metadata);
    DoiStatus status = resolve(doi);
    if (status != null && DoiStatus.Status.REGISTERED == status.getStatus()) {
      throw new DoiExistsException(doi);
    }
    post(doi, metadataWs, metadata);
    authCall(buildDoiUrlPost(doi, target));
    if (status != null && DoiStatus.Status.DELETED == status.getStatus()) {
      LOG.info("Re-registered {}", doi);
    } else {
      LOG.info("Registered {}", doi);
    }
  }

  @Override
  public boolean delete(DOI doi) throws DoiException {
    Preconditions.checkNotNull(doi);
    delete(metadataUri(doi));
    LOG.info("Deleted {}", doi);
    return resolve(doi) != null;
  }

  @Override
  public void update(DOI doi, DataCiteMetadata metadata) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(metadata);

    DoiStatus status = resolve(doi);
    if (status == null || DoiStatus.Status.REGISTERED != status.getStatus()) {
      throw new DoiException("DOI was not registered yet");
    }
    post(doi, metadataWs, metadata);
    LOG.info("Updated metadata for {}", doi);
  }

  @Override
  public void update(DOI doi, URI target) throws DoiException {
    Preconditions.checkNotNull(doi);
    Preconditions.checkNotNull(target);

    DoiStatus status = resolve(doi);
    if (status == null || DoiStatus.Status.REGISTERED != status.getStatus()) {
      throw new DoiException("DOI was not registered yet");
    }
    authCall(buildDoiUrlPost(doi, target));
    LOG.info("Updated target URL for {}", doi);
  }

  private HttpPost buildDoiUrlPost(DOI doi, URI target) {
    HttpPost post = new HttpPost(doiWs);
    String body = String.format("doi=%s\nurl=%s", doi.getDoiName(), target);
    HttpEntity entity = new StringEntity(body, PLAIN_TEXT_UTF8);
    post.setEntity(entity);
    return post;
  }

  @VisibleForTesting
  protected URI doiUri(DOI doi) throws DoiException {
    try {
      return URI.create(doiWs.toString() + doi.getDoiName());
    } catch (IllegalArgumentException e) {
      throw new DoiException("Unable to convert DOI to DataCite URI", e);
    }
  }

  @VisibleForTesting
  protected  URI metadataUri(DOI doi) throws DoiException {
    try {
      return URI.create(metadataWs.toString() + doi.getDoiName());
    } catch (IllegalArgumentException e) {
      throw new DoiException("Unable to convert DOI to DataCite URI", e);
    }
  }

  /**
   * Executes an HTTP POST request.
   *
   * @param uri  to issue request against
   * @param data request body content to be serialized as XML with jackson
   *
   * @throws org.gbif.doi.service.DoiException in case anything goes wrong during the request.
   */
  private void post(DOI doi, URI uri, DataCiteMetadata data) throws DoiException {
    LOG.debug("POST: {}", uri);
    HttpPost req = new HttpPost(uri);
    // body
    if (data != null) {
      try {
        String xml = toXml(doi, data);
        HttpEntity entity = new StringEntity(xml, APPLICATION_XML_UTF8);
        req.setEntity(entity);
        authCall(req);

      } catch (Exception e) {
        throw new DoiException(e);
      }
    }
  }
}
