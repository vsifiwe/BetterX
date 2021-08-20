/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.helpers;

import java.util.UUID;

/**
 *
 * @author X
 */
public class Helper {
    
    public String generateUUID(){
        return UUID.randomUUID().toString();
    }
    
    public UUID parseUUID(String uuid){
        return UUID.fromString(uuid);
    }
    
}
