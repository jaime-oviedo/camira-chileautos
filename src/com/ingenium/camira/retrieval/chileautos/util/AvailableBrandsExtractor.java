
package com.ingenium.camira.retrieval.chileautos.util;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.google.common.collect.ImmutableList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

public class AvailableBrandsExtractor {
  
  private static Logger log = Logger.getLogger(
      "com.ingenium.camira.retrieval.chileautos.AvailableBrandsExtractor");
  
  public AvailableBrandsExtractor() {
    // TODO Auto-generated constructor stub
  }
  
  public List<String> extractAvailableBrands() {
    final List<String> availableBrands = new ArrayList<>(300);
    final WebClient webClient = new WebClient();
    // Get the main page
    HtmlPage mainPage = null;
    try {
      mainPage = webClient.getPage("https://www.chileautos.cl");
      final HtmlSelect carBrandSelect = (HtmlSelect) mainPage
          .getElementById("cars-make-box");
      final List<HtmlOption> carBrandOptions = carBrandSelect.getOptions();
      for (final HtmlOption option : carBrandOptions) {
        final String optionValue = option.getValueAttribute();
        if (!"".equals(optionValue) && (optionValue != null)) {
          if (!availableBrands.contains(optionValue)) {
            availableBrands.add(optionValue);
          }
        }
        
      }
    } catch (FailingHttpStatusCodeException | IOException e) {
      AvailableBrandsExtractor.log.severe(new StringBuilder(
          "Unable to retrieve the available car brands information from the webpage:")
              .append(e.getMessage()).toString());
    } finally {
      webClient.close();
    }
    availableBrands.sort(String.CASE_INSENSITIVE_ORDER);
    return ImmutableList.copyOf(availableBrands);
  }
  
  public List<String> extractAndStoreAvailableBrands(
      final String destinationPath) {
    final List<String> availableBrands = this.extractAvailableBrands();
    final File destinationFile = new File(destinationPath);
    try {
      FileUtils.writeLines(destinationFile, availableBrands);
    } catch (final IOException e) {
      AvailableBrandsExtractor.log
          .severe(new StringBuffer("Unable to write elements to file:")
              .append(e.getMessage()).toString());
    }
    return availableBrands;
  }
}
