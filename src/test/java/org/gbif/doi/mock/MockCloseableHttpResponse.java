package org.gbif.doi.mock;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.params.HttpParams;

/**
 *
 * Mock implementation of CloseableHttpResponse.
 *
 */
public class MockCloseableHttpResponse implements CloseableHttpResponse {

  private int statusCode;

  public MockCloseableHttpResponse(int statusCode){
    this.statusCode = statusCode;
  }

  @Override
  public StatusLine getStatusLine() {
    return new StatusLine(){

      @Override
      public ProtocolVersion getProtocolVersion() {
        return null;
      }

      @Override
      public int getStatusCode() {
        return statusCode;
      }

      @Override
      public String getReasonPhrase() {
        return null;
      }
    };
  }


  @Override
  public void close() throws IOException {

  }

  @Override
  public void setStatusLine(StatusLine statusline) {

  }

  @Override
  public void setStatusLine(ProtocolVersion ver, int code) {

  }

  @Override
  public void setStatusLine(ProtocolVersion ver, int code, String reason) {

  }

  @Override
  public void setStatusCode(int code) throws IllegalStateException {

  }

  @Override
  public void setReasonPhrase(String reason) throws IllegalStateException {

  }

  @Override
  public HttpEntity getEntity() {
    return new HttpEntity(){

      @Override
      public boolean isRepeatable() {
        return false;
      }

      @Override
      public boolean isChunked() {
        return false;
      }

      @Override
      public long getContentLength() {
        return 0;
      }

      @Override
      public Header getContentType() {
        return null;
      }

      @Override
      public Header getContentEncoding() {
        return null;
      }

      @Override
      public InputStream getContent() throws IOException, IllegalStateException {
        return null;
      }

      @Override
      public void writeTo(OutputStream outstream) throws IOException {

      }

      @Override
      public boolean isStreaming() {
        return false;
      }

      @Override
      public void consumeContent() throws IOException {

      }
    };
  }

  @Override
  public void setEntity(HttpEntity entity) {

  }

  @Override
  public Locale getLocale() {
    return null;
  }

  @Override
  public void setLocale(Locale loc) {

  }

  @Override
  public ProtocolVersion getProtocolVersion() {
    return null;
  }

  @Override
  public boolean containsHeader(String name) {
    return false;
  }

  @Override
  public Header[] getHeaders(String name) {
    return new Header[0];
  }

  @Override
  public Header getFirstHeader(String name) {
    return null;
  }

  @Override
  public Header getLastHeader(String name) {
    return null;
  }

  @Override
  public Header[] getAllHeaders() {
    return new Header[0];
  }

  @Override
  public void addHeader(Header header) {

  }

  @Override
  public void addHeader(String name, String value) {

  }

  @Override
  public void setHeader(Header header) {

  }

  @Override
  public void setHeader(String name, String value) {

  }

  @Override
  public void setHeaders(Header[] headers) {

  }

  @Override
  public void removeHeader(Header header) {

  }

  @Override
  public void removeHeaders(String name) {

  }

  @Override
  public HeaderIterator headerIterator() {
    return null;
  }

  @Override
  public HeaderIterator headerIterator(String name) {
    return null;
  }

  @Override
  public HttpParams getParams() {
    return null;
  }

  @Override
  public void setParams(HttpParams params) {

  }
}