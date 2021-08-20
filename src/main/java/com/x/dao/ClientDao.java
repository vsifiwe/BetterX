/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.dao;

import com.x.helpers.Helper;
import com.x.model.Client;
import java.util.Date;

/**
 *
 * @author X
 */
public class ClientDao extends GenericDao {
    
    public ClientDao(Class type) {
        super(type);
    }
    
    //create Client
    
     public Client createClient(String firstName, String lastName, String phoneNumber, String insurance){
        
        Helper helper = new Helper();
        if(firstName == null || firstName.equals("") || lastName == null || lastName.equals("") || phoneNumber == null || phoneNumber.equals("") || insurance == null || insurance.equals("")){
            System.out.println("Please enter a valid Client name");
            return null;
        }
        
        try{
            
            Client client = new Client(helper.generateUUID(), 0 , new Date(), firstName, lastName, phoneNumber, insurance);
            create(client);
            return client;
            
        } catch (Exception e){
            System.out.println("A problem occured in createClient function");
            System.out.println(e);
            return null;
        }
     }
    
    // find Client by Id
    
    public Client findClientById(String clientId){
        Client client;
        if (clientId == null || clientId.equals("")) {
            System.out.println("You need to enter a valid clientId to find");
            return null;
        }
        
        try {

            client = (Client) findbyID(clientId);
            return client;
        } catch (Exception ex) {
            System.out.println("An error occured in findClientById function");
            System.out.println(ex);
            return null;
        }
    }
    
    // delete Client
    
    public Client deleteClient(String clientId){
        
        Client client;
        if (clientId == null || clientId.equals("")){
            System.out.println("You need to enter a valid client ID to deleted");
            return null;
        }
        
        try{
            client = (Client) findbyID(clientId);
            delete(client);
            return client;
        } catch (Exception e){
            System.out.println("An error occured in deleteClient function");
            System.out.println(e);
            return null;
        }
    }
    
    // Update client
}
