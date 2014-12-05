package org.gbif.doi.service.ezid;

import org.gbif.doi.service.DoiStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Charsets;

/**
 * ANVL (A Name-Value Language) is a simple record syntax based on email headers.
 * An ANVL record is a sequence of data elements ending in a blank line.
 * An element consists of a label, a colon, and an optional value, and a long value may be folded (continued)
 * onto the next line by inserting a newline and indenting the next line.
 *
 * ANVL is used to excahnge metadata with EZID.
 * This utils class contains methods to (de)serialize them from a java map to a plain string.
 *
 * @see <a href="https://wiki.ucop.edu/display/Curation/Anvl">ANVL specs</a>
 * @see <a href="http://ezid.cdlib.org/doc/apidoc.html#request-response-bodies">EZID API</a>
 */
public class AnvlUtils {

  /**
   * The identifier's target URL. Defaults to the identifier's EZID URL.
   * That is, the default target URL for identifier foo is the self-referential URL http://ezid.cdlib.org/id/foo.
   * Note that creating or updating the target URL of a DOI identifier may take up to 30 minutes
   * to take effect in the Handle System.
   */
  public static final String TARGET = "_target";
  public static final String DATACITE = "datacite";
  /**
   * The identifier's status (see Identifier status above).
   */
  public static final String STATUS = "_status";
  /**
   * The identifier's preferred metadata profile (see Metadata profiles next).
   */
  public static final String PROFILE = "_profile";
  /**
   * If returned, indicates that the identifier is registered with CrossRef
   * (or, in the case of a reserved identifier, will be registered),
   * and also indicates the status of the registration process.
   * When setting, must be set to "yes" or "no".
   */
  public static final String CROSSREF = "_crossref";

  /**
   * This method serializes a map of metadata name/value pairs into an ANVL String value. If the
   * map is null, or if it is empty, then it returns a null string.
   * </br>
   * EZID metadata dictionaries must be serialized using a subset of A Name-Value Language (ANVL) rules:
   * -One element name/value pair per line.
   * -Names separated from values by colons.
   *
   * @see <a href="http://ezid.cdlib.org/doc/apidoc.html#request-response-bodies">EZID API</a>
   * @param metadata the Map of metadata name/value pairs
   *
   * @return an ANVL String or null if no metadata name/value pairs provided
   */
  public static String write(Map<String, String> metadata) {
    StringBuffer buffer = new StringBuffer();
    if (metadata != null) {
      for (Map.Entry<String, String> entry : metadata.entrySet()) {
        buffer.append(encode(entry.getKey()) + ": " + encode(entry.getValue()) + "\n");
      }
    }
    return buffer.toString();
  }

  private static String encode(String s) {
    return s.replace("%", "%25")
      .replace("\n", "%0A")
      .replace("\r", "%0D")
      .replace(":", "%3A");
  }

  private static String decode (String s) {
    StringBuffer b = new StringBuffer();
    int i;
    while ((i = s.indexOf("%")) >= 0) {
      b.append(s.substring(0, i));
      b.append((char)Integer.parseInt(s.substring(i+1, i+3), 16));
      s = s.substring(i+3);
    }
    b.append(s);
    return b.toString();
  }

  private static String[] parseAnvlLine (String line) {
    String[] kv = line.split(":", 2);
    kv[0] = decode(kv[0]).trim();
    kv[1] = decode(kv[1]).trim();
    return kv;
  }

  /**
   * Reads an ANVL input stream into a map.
   */
  public static Map<String, String> read(InputStream is) throws IOException {
    return read(new BufferedReader(new InputStreamReader(is, Charsets.UTF_8)));
  }

  public static Map<String, String> read(Reader r) throws IOException {
    return read(new BufferedReader(r));
  }

  public static Map<String, String> read(String anvl) {
    try {
      return read(new BufferedReader(new StringReader(anvl)));
    } catch (IOException e) {
      // cant happen so we hide the IOException as a runtime exception
      // we have a string wrapped reader
      throw new IllegalStateException(e);
    }
  }

  private static Map<String, String> read(BufferedReader br) throws IOException {
    HashMap<String, String> d = new HashMap<String, String>();
    String l;
    while ((l = br.readLine()) != null) {
      String[] kv = parseAnvlLine(l);
      d.put(kv[0], kv[1]);
    }
    return d;
  }

  public static class Anvl{
    private String target;

    public Anvl(String target, String datacite, String status) {
      this.target = target;
      this.datacite = datacite;
      this.status = status;
    }

    private String datacite;
    private String status;
  }

  public static class Builder {

    private Map<String, String> map = new HashMap<String, String>();

    public Builder target(URI target) {
      if (target == null) {
        this.map.put(AnvlUtils.TARGET, "");
      } else {
        this.map.put(AnvlUtils.TARGET, target.toString());
      }
      return this;
    }

    public Builder datacite(String datacite) {
      this.map.put(AnvlUtils.DATACITE, datacite);
      return this;
    }

    public Builder status(DoiStatus.Status status) {
      this.map.put(AnvlUtils.STATUS, status.getEzid());
      return this;
    }

    public Builder entry(String key, String value) {
      this.map.put(key, value);
      return this;
    }

    public Map<String, String> build() {
      return map;
    }
  }

  public static Builder builder() {
    return new Builder();
  }
}
