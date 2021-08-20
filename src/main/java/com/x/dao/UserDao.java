/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.dao;

import com.x.model.User;
import java.util.Date;

/**
 *
 * @author X
 */
public class UserDao extends GenericDao{
    
    public UserDao(Class type) {
        super(type);
    }
    
    public User createUser(String email, String firstName, String lastName, String password){
        
        if (email == null || firstName == null || lastName == null || password == null){
            System.out.println("Email, first Name, last Name and password should not be null");
            return null;
        }
        
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setCreationDate(new Date());
        
        create(user);
        return user;
    }
    
    public User deleteUser(String email){
        User user;
        if (email == null || email == "") {
            System.out.println("You need to enter an email to be deleted");
            return null;
        }
        try {

            user = (User) findbyID(email);
            delete(user);
            return user;
        } catch (Exception ex) {
            System.out.println("An error occured in deleteUser function");
            System.out.println(ex);
            return null;
        }
    }
    
    public User findUserById(String email){
        User user;
        if (email == null || email.equals("")) {
            System.out.println("You need to enter an email to find");
            return null;
        }
        
        try {

            user = (User) findbyID(email);
            return user;
        } catch (Exception ex) {
            System.out.println("An error occured in findUserById function");
            System.out.println(ex);
            return null;
        }
    }
    
    //Update User function
}
