/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belatrixsf;

import java.util.Map;

/**
 *
 * @author ivancp
 */
public class ConsoleHandler extends Loghandler{
    public ConsoleHandler(Map params){
    }
    
    @Override
    public void LogMessage(String messageText, int level){
        System.out.println("Console");
    }
}