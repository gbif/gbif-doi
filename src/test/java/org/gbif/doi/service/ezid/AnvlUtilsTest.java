package org.gbif.doi.service.ezid;

import org.gbif.utils.file.FileUtils;

import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnvlUtilsTest {

  @Test
  public void testRead() throws Exception {
    Map<String, String> map = AnvlUtils.read(FileUtils.classpathStream("anvl.txt"));
    System.out.println(map);
    assertEquals(16, map.size());
    assertEquals("ark:/b6084/m9.figshare.821213", map.get("_shadowedby"));
    assertEquals("http://figshare.com/articles/5000_random_journal_article_CrossRef_DOIs_from_2012/821213", map.get(AnvlUtils.TARGET));
    assertEquals(869, map.get(AnvlUtils.DATACITE).length());
    assertEquals("public", map.get(AnvlUtils.STATUS));
  }

  @Test
  public void testRountrip() throws Exception {
    Map<String, String> map = AnvlUtils.read(FileUtils.classpathStream("anvl.txt"));
    String anvl = AnvlUtils.write(map);
    assertEquals(map, AnvlUtils.read(anvl));
  }
}