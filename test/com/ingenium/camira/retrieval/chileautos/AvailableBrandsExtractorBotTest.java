/**
 * Copyright (c) 2017 Ingenium Software Ltda.
 */

package com.ingenium.camira.retrieval.chileautos;

import com.ingenium.camira.retrieval.chileautos.util.AvailableBrandsExtractor;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JaimeRodrigo
 */
public class AvailableBrandsExtractorBotTest {
  private static Logger log = Logger.getLogger(
      "com.ingenium.camira.retrieval.chileautos.AvailableBrandsExtractorBotTest");

  /**
   * Test method for
   * {@link com.ingenium.camira.retrieval.chileautos.util.AvailableBrandsExtractor#extractAvailableBrands()}.
   */
  @Test
  public final void testExtractAvailableBrands() {
    final AvailableBrandsExtractor bot = new AvailableBrandsExtractor();
    final List<String> results = bot.extractAvailableBrands();
    for (final String result : results) {
      // AvailableBrandsExtractorBotTest.log.info(result);
      System.out.println("\"" + result + "\",");
    }
    Assert.assertTrue(results.size() > 0);
  }

}
