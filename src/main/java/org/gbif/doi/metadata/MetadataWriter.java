package org.gbif.doi.metadata;

import org.gbif.metadata.eml.Eml;
import org.gbif.utils.file.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MetadataWriter {

  private static final String DATACITE_TEMPLATE = "datacite.ftl";
  private static final Configuration FTL = provideFreemarker();

  /**
   * TODO return String instead of writing File
   *
   * Writes an {@link Eml} object to a DataCite XML file using a Freemarker {@link freemarker.template.Configuration}.
   *
   * @param f         the DataCite XML file to write to
   * @param eml       the EML object
   * @param doi       the identifier (DOI)
   * @param publisher the publishing organisation name
   * @param resourceType term describing what type of data set is described
   */
  public static void writeMetadataFile(File f, Eml eml, String doi, String publisher, String resourceType) throws IOException, TemplateException {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("eml", eml);
    map.put("doi", doi);
    map.put("publisher", publisher);
    map.put("resourceType", resourceType);
    writeFile(f, DATACITE_TEMPLATE, map);
  }

  /**
   * Provides a freemarker template loader. It is configured to access the utf8 templates folder on the classpath, i.e.
   * /src/resources/templates
   */
  private static Configuration provideFreemarker() {
    // load templates from classpath by prefixing /templates
    TemplateLoader tl = new ClassTemplateLoader(MetadataWriter.class, "/templates");

    Configuration fm = new Configuration();
    fm.setDefaultEncoding("utf8");
    fm.setTemplateLoader(tl);

    return fm;
  }

  /**
   * Writes a map of data to a utf8 encoded file using a Freemarker {@link Configuration}.
   */
  private static void writeFile(File f, String template, Object data) throws IOException, TemplateException {
    String result = processTemplateIntoString(FTL.getTemplate(template), data);
    Writer out = FileUtils.startNewUtf8File(f);
    out.write(result);
    out.close();
  }

  /**
   * Processes a freemarker template into a string.
   */
  private static String processTemplateIntoString(Template template, Object model)
    throws IOException, TemplateException {
    StringWriter result = new StringWriter();
    template.process(model, result);
    return result.toString();
  }
}
