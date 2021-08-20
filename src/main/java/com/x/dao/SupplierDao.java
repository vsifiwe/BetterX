/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.dao;

import com.x.helpers.Helper;
import com.x.model.Supplier;
import java.util.Date;

/**
 *
 * @author X
 */
public class SupplierDao extends GenericDao{

    public SupplierDao(Class type) {
        super(type);
    }
    
    // Create Supplier function
    public Supplier createSupplier(String supplierName){
        Supplier supplier = new Supplier();
        Helper helper = new Helper();
        if(supplierName == null || supplierName.equals("")){
            System.out.println("Please enter a valid supplier name");
            return null;
        }
        
        try{
            supplier.setCreationDate(new Date());
            supplier.setSupplierId(helper.generateUUID());
            supplier.setOutstanding(0);
            supplier.setSupplierName(supplierName);
            
            create(supplier);
            return supplier;
        } catch (Exception e){
            System.out.println("A problem occured in createSupplier function");
            System.out.println(e);
            return null;
        }
    }
    // Find Supplier By Id function
    
    public Supplier findSupplierById(String supplierId){
        Supplier supplier;
        if (supplierId == null || supplierId.equals("")) {
            System.out.println("You need to enter a valid supplierId to find");
            return null;
        }
        
        try {

            supplier = (Supplier) findbyID(supplierId);
            return supplier;
        } catch (Exception ex) {
            System.out.println("An error occured in findSupplierById function");
            System.out.println(ex);
            return null;
        }
    }
    
    // delete Supplier function
    
    public Supplier deleteSupplier(String supplierId){
        
        Supplier supplier;
        if (supplierId == null || supplierId.equals("")){
            System.out.println("You need to enter a valid supplier ID to deleted");
            return null;
        }
        
        try{
            supplier = (Supplier) findbyID(supplierId);
            delete(supplier);
            return supplier;
        } catch (Exception e){
            System.out.println("An error occured in deleteSupplier function");
            System.out.println(e);
            return null;
        }
    }
    
    // update supplier function
    
    
    
}
