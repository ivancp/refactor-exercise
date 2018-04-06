package com.belatrixsf;

import java.util.HashMap;
import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testFileHandler()
    {
        try {
            Map<String,String> params = new HashMap<String,String>();
            JobLogger logger =  new JobLogger( Loghandler.FILE , params );
            
            fail( "Invalid parameters for File" );
            
        } catch (Exception ex) {
            assertTrue(true);
        }  
    }
    
    public void testDatabaseHandler()
    {
        try {
                Map<String,String> params = new HashMap<String,String>();

                Class.forName("com.mysql.jdbc.Driver").newInstance();

                JobLogger logger =  new JobLogger(Loghandler.DATABASE, params );
                
                fail( "Invalid parameters for database" );
        
        } catch (Exception ex) {
            assertTrue(true);
        }
    }
    
    public void testParameters()
    {
        try {
            Map<String,String> params = new HashMap<String,String>();
            
            JobLogger logger =  new JobLogger( 999 , params );
            
            fail( "Mising all paramters" );
            
        } catch (Exception ex) {
            assertTrue(true);
        }
    }

    public void testInvalidLevel()
    {
        try {
            Map<String,String> params = new HashMap<String,String>();
            
            JobLogger logger =  new JobLogger( Loghandler.CONSOLE, params );
            logger.LogMessage("Test",999 );
            
            fail( "Mising all paramters" );
            
        } catch (Exception ex) {
            assertTrue(true);
        }
    }
}
