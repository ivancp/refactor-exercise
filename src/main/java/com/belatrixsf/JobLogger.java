/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belatrixsf;

import java.util.Map;
import java.util.Vector;

/**
 *
 * @author ivancp
 */
public class JobLogger {
    
    private Vector<Loghandler> vHandler = new Vector<Loghandler>();
    //private Loghandler;
    
    public JobLogger(int handlers, Map dbParamsMap){

        if((handlers & Loghandler.CONSOLE) > 0 ){
            ConsoleHandler handler = new ConsoleHandler(dbParamsMap);
            vHandler.add((Loghandler)handler);
        }
        if((handlers & Loghandler.DATABASE) > 0 ){
            DatabaseHandler handler = new DatabaseHandler(dbParamsMap);
            vHandler.add((Loghandler)handler);
        }
        if((handlers & Loghandler.FILE) > 0 ){
            FileHandler handler = new FileHandler(dbParamsMap);
            vHandler.add((Loghandler)handler);
        }
    }
    
    public void LogMessage(String message, int level){
        for(int i = 0 ; i < vHandler.size();i++){
            vHandler.get(i).LogMessage(message,level);
        }
    }
}
