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
public class FileHandler extends Loghandler{

    public FileHandler(Map param){
    }

    @Override
    public void LogMessage(String messageText, int level){
        System.out.println("File");
    }
    
}
