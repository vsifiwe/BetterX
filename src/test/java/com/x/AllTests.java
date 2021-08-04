/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x;

import com.x.dao.GenericDao;
import com.x.model.Product;
import com.x.model.Purchase;
import com.x.model.PurchaseItem;
import com.x.model.Sale;
import com.x.model.Supplier;
import com.x.model.User;
import com.x.types.AccessLevel;
import com.x.types.Measure;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
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
    @Test
    public void testCreateSuppliers(){
        Supplier supplier1 = new Supplier("MediPhar LTD","0788427257");
        Supplier supplier2 = new Supplier("KopiVitamin LTD","0788123123");
        Supplier supplier3 = new Supplier("Kipharma LTD","0787888800");
        
        supplierDao.create(supplier1);
        supplierDao.create(supplier2);
        supplierDao.create(supplier3);
        
        List<Supplier> suppliers = supplierDao.findAll();
        assertEquals(suppliers.size(), 3);
    }
    @Test
    public void testCreateUsers() {
        User user1 = new User("Manzi","Asifiwe","asifiwemanzi@gmail.com","Pass",AccessLevel.user);
        User user2 = new User("Ineza","Ines","inesineza@gmail.com","Pass",AccessLevel.admin);
        User user3 = new User("Ishimwe","Yannick","ishimweyannick@gmail.com","Pass",AccessLevel.superuser);
        
        userDao.create(user1);
        userDao.create(user2);
        userDao.create(user3);
        
        List<User> users = userDao.findAll();
        
        assertEquals(users.size(), 3);
        
    }
    
    public void testCreatePurchase(){
        User user1 =(User) userDao.findbyID(1);
        User user2 = (User) userDao.findbyID(2);
        Supplier supplier1 = (Supplier) supplierDao.findbyID(3);
        Supplier supplier2 = (Supplier) supplierDao.findbyID(4);
        
        List<PurchaseItem> products1 = null;
        List<PurchaseItem> products2 = null;
        List<PurchaseItem> products3 = null;
        
        Purchase purchase1 = new Purchase(new Date(), supplier1,  products1, user1);
        Purchase purchase2 = new Purchase(new Date(), supplier2,  products2, user2);
        Purchase purchase3 = new Purchase(new Date(), supplier2,  products3, user1);
        
        purchaseDao.create(purchase1);
        purchaseDao.create(purchase2);
        purchaseDao.create(purchase3);
        purchase1.savePurchase();
        purchase2.savePurchase();
        purchase3.savePurchase();
        
        List<Purchase> purchases = purchaseDao.findAll();
        
        assertEquals(purchases.size(), 3);
        
        
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
