package com.belatrixsf;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<String,String> params = new HashMap<String,String>();
        params.put("logFileFolder","/tmp");
        
        params.put("userName","root");
        params.put("password","w");
        params.put("dbms","mysql");
        params.put("dbName","belatrix");
        params.put("serverName","localhost");
        params.put("portNumber","3306");
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            
            JobLogger logger =  new JobLogger( Loghandler.CONSOLE | Loghandler.FILE | Loghandler.DATABASE, params );        
            logger.LogMessage("Test",JobLevelMSG.ERROR);
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
