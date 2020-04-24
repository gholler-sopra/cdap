package co.cask.cdap.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Enumeration;

public class LogTest {

  private static final Logger LOG = LoggerFactory.getLogger(LogTest.class);

  public static void main(String[] args) throws Exception {


    Enumeration<URL> resources = LogTest.class.getClassLoader().getResources("logback.xml");

    while (resources.hasMoreElements()) {
      System.out.println(resources.nextElement());
    }

    LOG.debug("a debug statement");
    LOG.info("an info");
    LOG.warn("a warning");
    LOG.error("an error");





  }
}
