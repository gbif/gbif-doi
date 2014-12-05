package org.gbif.doi.service.datacite;

import org.gbif.api.model.common.DOI;
import org.gbif.doi.service.DoiException;
import org.gbif.doi.service.DoiService;
import org.gbif.doi.metadata.datacite.DataCiteMetadata;
import org.gbif.doi.metadata.datacite.DataCiteMetadataTest;
import org.gbif.doi.service.DoiStatus;

import java.net.URI;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * Base class for shared tests of doi service implementations.
 */
public abstract class DoiServiceIT {
  public final static URI TEST_TARGET = URI.create("http://www.gbif.org/datasets");
  public final static DOI FOREIGN_DOI = new DOI("10.6084/m9.figshare.821213");
  protected final DoiService service;
  protected final String prefix;
  protected final String shoulder;

  public DoiServiceIT(String prefix, String shoulder, DoiService service) {
    this.prefix = prefix;
    this.shoulder = shoulder;
    this.service = service;
  }

  protected DOI newDoi() {
    return new DOI(prefix, shoulder + System.nanoTime());
  }


  @Test
  public void testResolve() throws Exception {
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    assertNull(service.resolve(doi));

    service.reserve(doi, meta);
    assertEquals(new DoiStatus(DoiStatus.Status.RESERVED, null), service.resolve(doi));

    service.register(doi, TEST_TARGET);
    assertEquals(new DoiStatus(DoiStatus.Status.REGISTERED, TEST_TARGET), service.resolve(doi));

    service.delete(doi);
    assertEquals(DoiStatus.Status.DELETED, service.resolve(doi).getStatus());
  }

  @Test
  public void test404() throws Exception {
    final DOI doi = newDoi();
    assertNull(service.resolve(doi));
  }

  @Test
  public void testGet() throws Exception {
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    service.register(doi, TEST_TARGET);
    assertEquals(new DoiStatus(DoiStatus.Status.REGISTERED, TEST_TARGET), service.resolve(doi));
  }

  @Test
  public void testReserve() throws Exception {
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    try {
      service.reserve(doi, meta);
      fail("DOI was reserved already, expected DoiExistsException");
    } catch (DoiException e) {

    }
  }

  @Test
  public void testReserveRandom() throws Exception {
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata();
    DOI doi = service.reserveRandom(prefix, shoulder, 4, meta);
    System.out.println("Reserved random id " + doi);
  }

  @Test
  public void testDeleteReserved() throws Exception {
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    // now delete it and reserving again should work
    service.delete(doi);
    service.reserve(doi, meta);
    service.delete(doi);
  }

  @Test
  public void testDeleteRegistered() throws Exception {
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    service.register(doi, TEST_TARGET);
    assertEquals(new DoiStatus(DoiStatus.Status.REGISTERED, TEST_TARGET), service.resolve(doi));
    // now delete it to mark inactive (datacite) or set to unavailable (ezid)
    service.delete(doi);
    assertEquals(DoiStatus.Status.DELETED, service.resolve(doi).getStatus());
    // registering again should work
    service.register(doi, TEST_TARGET);
    assertEquals(TEST_TARGET, service.resolve(doi).getTarget());
  }

  @Test
  public void testUpdateRegistered() throws Exception {
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    assertEquals(new DoiStatus(DoiStatus.Status.RESERVED, null), service.resolve(doi));
    service.register(doi, TEST_TARGET);
    assertEquals(new DoiStatus(DoiStatus.Status.REGISTERED, TEST_TARGET), service.resolve(doi));

    final URI target2 = TEST_TARGET.resolve("subsub");
    service.update(doi, target2);
    assertEquals(new DoiStatus(DoiStatus.Status.REGISTERED, target2), service.resolve(doi));
  }

  @Test(expected = DoiException.class)
  public void testRegister404() throws Exception {
    final DOI doi = newDoi();
    service.register(doi, TEST_TARGET);
  }



  @Test
  public void testRegister() throws Exception {
    final DOI doi = newDoi();
    DataCiteMetadata meta = DataCiteMetadataTest.testMetadata(doi, "reserve test");
    service.reserve(doi, meta);
    service.register(doi, TEST_TARGET);
    assertEquals(new DoiStatus(DoiStatus.Status.REGISTERED, TEST_TARGET), service.resolve(doi));
    try {
      // try again, this should fail!
      service.register(doi, TEST_TARGET);
      fail("DOI was registered already, expected DoiExistsException");
    } catch (DoiException e) {
      System.out.println(e);
    }
  }

  @Test(expected = DoiException.class)
  public void testRegisterFail() throws Exception {
    final DOI doi = newDoi();
    // registering without previous reservation should throw an error
    service.register(doi, TEST_TARGET);
  }

}