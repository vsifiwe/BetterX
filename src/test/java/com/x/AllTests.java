/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x;

import com.x.dao.GenericDao;
import com.x.model.Product;
import com.x.model.Purchase;
import com.x.model.Sale;
import com.x.model.Supplier;
import com.x.model.User;
import com.x.types.Measure;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 *
 * @author X
 */
public class AllTests {
    GenericDao productDao = new GenericDao(Product.class);
    GenericDao userDao = new GenericDao(User.class);
    GenericDao supplierDao = new GenericDao(Supplier.class);
    GenericDao purchaseDao = new GenericDao(Purchase.class);
    GenericDao saleDao = new GenericDao(Sale.class);

    @Test
    public void testCreateProducts(){
        Product product1 = new Product("Paidoterin", 1, Measure.piece, "Syrop for kids", "GSK LTD", "India");
        Product product2 = new Product("Paracetamol", 10, Measure.piece, "Paracetamol 100mg", "GSK LTD", "India");
        Product product3 = new Product("Ibuprofen", 5, Measure.piece, "To reduce temperature", "GSK LTD", "India");
        Product product4 = new Product("Ibupar", 12, Measure.piece, "Temperature & Pain", "GSK LTD", "India");
        Product product5 = new Product("Eno", 1, Measure.piece, "For gastro intestines", "GSK LTD", "India");
        
        productDao.create(product1);
        productDao.create(product2);
        productDao.create(product3);
        productDao.create(product4);
        productDao.create(product5);
        
        List<Product> products = productDao.findAll();
        assertEquals(products.size(), 5);
    }
    
    public void testCreateSuppliers(){
    
    }
    
    public void testCreateUsers() {
        
    }
    
    public void testCreatePurchase(){
    
    }
    
    public void testCreateSale(){
    
    }
    
    @AfterClass
    public void afterEverything(){
    try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/betterx?zeroDateTimeBehavior=convertToNull",
                    "root", "")) {
                Statement st = con.createStatement();
                st.execute("DROP table product");
                st.execute("DROP table users");
                st.execute("DROP table hibernate_sequence");
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
