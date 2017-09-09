/**
 * Copyright (c) 2017 Ingenium Software Ltda.
 */

package com.ingenium.camira.retrieval.chileautos.cli;

import com.ingenium.camira.retrieval.chileautos.bot.ChileautosBot;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 *
 * @author JaimeRodrigo
 * @generated "UML to Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ChileautosBotCli {
  private static final String VERBOSE_OPTION = "verbose";
  private static final String FILE_OPTION = "file";
  /**
   * <!-- begin-UML-doc --> <!-- end-UML-doc -->
   *
   * @generated "UML to Java
   *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
   */
  private ChileautosBot bot;

  /**
   * "Definition" stage of command-line parsing with Apache Commons CLI.
   *
   * @return Definition of command-line options.
   */
  
  private static Options generateOptions()
  
  {
    
    final Option verboseOption = Option.builder("v")
        
        .required(false)
        
        .hasArg(false)
        
        .longOpt(ChileautosBotCli.VERBOSE_OPTION)
        
        .desc("Print status with verbosity.")
        
        .build();
    
    final Option fileOption = Option.builder("f")
        
        .required()
        
        .longOpt(ChileautosBotCli.FILE_OPTION)
        
        .hasArg()
        
        .desc("File to be processed.")
        
        .build();
    
    final Options options = new Options();
    
    options.addOption(verboseOption);
    
    options.addOption(fileOption);
    
    return options;
    
  }
}