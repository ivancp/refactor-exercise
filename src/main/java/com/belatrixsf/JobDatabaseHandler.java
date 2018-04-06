/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belatrixsf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivancp
 */
public class JobDatabaseHandler extends Loghandler{
    Connection connection = null;
    
    public JobDatabaseHandler(Map dbParams){
        
        //we don't need log handler
        //logger = Logger.getLogger("JobDatabaseHandler");
        //logger.setUseParentHandlers(false);
        
        try {
            Properties connectionProps = new Properties();
            connectionProps.put("user", dbParams.get("userName"));
            connectionProps.put("password", dbParams.get("password"));  
            connectionProps.put("useSSL", "false");  
            
            String connectionString = "jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")  
                     + ":" + dbParams.get("portNumber") + "/" + dbParams.get("dbName");
            System.out.println(connectionString);
            
            connection = DriverManager.getConnection(connectionString , connectionProps);
            
        } catch (SQLException ex) {

            System.out.println(ex.getMessage() + ex.getSQLState());
        } 
}
    
    @Override
    public void LogMessage(String messageText, int level) throws Exception{
       
        PreparedStatement stmt = null;
        String sql  = "insert into Log_Values (messageText, logLevel) "
                    + " values (?, ?)";
        try {
            connection.setAutoCommit(false);
            //stmt = connection.createStatement();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, messageText);
            stmt.setInt(2, level);            
            stmt.executeUpdate();
            connection.commit();   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(stmt != null){
                stmt.close();
            }
            connection.setAutoCommit(false);
        }
    }
}
