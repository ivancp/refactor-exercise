/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belatrixsf;

import java.util.logging.Logger;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author ivancp
 */
public class Loghandler {
    
    protected Logger logger;
    
    public static final int FILE      = 0x1;
    public static final int CONSOLE   = 0x2;
    public static final int DATABASE  = 0x4;
    
    public Loghandler(){
        
    }
    boolean isempty(String messageText){
        messageText.trim();
        if (messageText == null || messageText.length() == 0) {
                return true;
        }
        return false;
    }
    public void LogMessage(String messageText, int level) throws Exception{

        if(isempty(messageText)){
            return;
        }
        
        String message = "";
        switch(level){
            case JobLevelMSG.WARNING:
                message = "warning " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " +messageText;
                break;
            case JobLevelMSG.ERROR:
                message = "error " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;
                break;
            case JobLevelMSG.INFO:
                message = "message " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + messageText;
                break;
        }
        logger.log(Level.INFO, message);
    }    
}
