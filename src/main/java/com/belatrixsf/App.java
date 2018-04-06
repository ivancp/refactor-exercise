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
        System.out.println( "Hello World!" );
        
        Map<String,String> params = new HashMap<String,String>();
        
        
        JobLogger logger =  new JobLogger( Loghandler.CONSOLE | Loghandler.FILE, params );
        
        logger.LogMessage("message",Level.ERROR);
    }
}
