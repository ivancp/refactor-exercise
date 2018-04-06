/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belatrixsf;

import java.io.File;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivancp
 */
public class JobFileHandler extends Loghandler{

    public JobFileHandler(Map dbParams) throws Exception{
        logger = Logger.getLogger("JobFileHandler");
        logger.setUseParentHandlers(false);

        String folder = (String)dbParams.get("logFileFolder");
        
        if(folder == null){
            throw new Exception("Invalid parameter: missing folder");
        }
                
        try{
            String l = null;
            File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");
            if (!logFile.exists()) {
                    logFile.createNewFile();
            }

            FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt",true);
            logger.addHandler(fh);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }  
}
