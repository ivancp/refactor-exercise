/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belatrixsf;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivancp
 */
public class JobLogger {
    
    private Vector<Loghandler> vHandler = new Vector<Loghandler>();
    
    public JobLogger(int handlers, Map dbParamsMap) throws Exception{
        
        if((handlers & Loghandler.CONSOLE) > 0 ){
            JobConsoleHandler handler = new JobConsoleHandler(dbParamsMap);
            vHandler.add((Loghandler)handler);
        }
        if((handlers & Loghandler.DATABASE) > 0 ){
            JobDatabaseHandler handler = new JobDatabaseHandler(dbParamsMap);
            vHandler.add((Loghandler)handler);
        }
        if((handlers & Loghandler.FILE) > 0 ){
            JobFileHandler handler = new JobFileHandler(dbParamsMap);
            vHandler.add((Loghandler)handler);
        }
        
        if(vHandler.size() == 0){
            throw new Exception("Invalid parameters");
        }
    }
    
    public void LogMessage(String message, int level) throws Exception{
        for(int i = 0 ; i < vHandler.size(); i++){
            vHandler.get(i).LogMessage(message,level);
        }        
    }
}
