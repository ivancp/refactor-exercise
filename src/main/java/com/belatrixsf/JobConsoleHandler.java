/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belatrixsf;

import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 *
 * @author ivancp
 */
public class JobConsoleHandler extends Loghandler{
    public JobConsoleHandler(Map params){
        logger = Logger.getLogger("JobConsoleHandler");
        logger.setUseParentHandlers(false);
        
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
    }
}
