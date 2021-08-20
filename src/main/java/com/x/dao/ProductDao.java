/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.dao;

import com.x.helpers.Helper;
import com.x.model.Product;
import com.x.types.Measure;
import java.util.UUID;

/**
 *
 * @author X
 */
public class ProductDao extends GenericDao {
    
    public ProductDao(Class type) {
        super(type);
    }
    
    public Product createProduct(String productName, String manufacturingCompany, String description, String country, long quantity, Measure measure){
        
        if (productName == null || manufacturingCompany == null || description == null || country == null || quantity == 0 || measure == null){
            System.out.println("Create Product function was passed a null parameter");
        }
        
        Product product = new Product();
        Helper helper = new Helper();
        String id = helper.generateUUID();
        product.setProductId(id);
        product.setProductName(productName);
        product.setManufacturingCompany(manufacturingCompany);
        product.setDescription(description);
        product.setCountry(country);
        product.setQuantity(quantity);
        product.setMeasure(measure);
        
        create(product);
        
        return product;
    
    }
    
    public Product findProductById(String productId){
        Product product;
        if (productId == null || productId.equals("")){
            System.out.println("You need to enter a product ID to search");
            return null;
        }
        
        try{
            product = (Product) findbyID(productId);
            return product;
        } catch (Exception e){
            System.out.println("An error occured in findProductById function");
            System.out.println(e);
            return null;
        }
    }
    
    public Product deleteProduct(String productId){
        
        Product product;
        if (productId == null || productId.equals("")){
            System.out.println("You need to enter a product ID to deleted");
            return null;
        }
        
        try{
            product = (Product) findbyID(productId);
            delete(product);
            return product;
        } catch (Exception e){
            System.out.println("An error occured in deleteProduct function");
            System.out.println(e);
            return null;
        }
    }
    
    //update product function
    
}
