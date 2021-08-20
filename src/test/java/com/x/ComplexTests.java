/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x;

import com.x.dao.GenericDao;
import com.x.dao.ActionDao;
import com.x.model.Product;
import com.x.model.Purchase;
import com.x.model.PurchaseItem;
import com.x.model.Sale;
import com.x.model.Supplier;
import com.x.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 *
 * @author X
 */
public class ComplexTests {

    GenericDao productDao = new GenericDao(Product.class);
    GenericDao userDao = new GenericDao(User.class);
    GenericDao supplierDao = new GenericDao(Supplier.class);
    GenericDao purchaseDao = new GenericDao(Purchase.class);
    GenericDao saleDao = new GenericDao(Sale.class);
    GenericDao itemDao = new GenericDao(PurchaseItem.class);

    @Test
    public void testCreatePurchase() {
        User Manzi = (User) userDao.findbyID("asifiwemanzi@gmail.com");
        Supplier Kipharma = (Supplier) supplierDao.findbyID(8);

        Product product1 = (Product) productDao.findbyID(1);
        Product product2 = (Product) productDao.findbyID(2);

        PurchaseItem item1 = new PurchaseItem(product1, 1);
        PurchaseItem item2 = new PurchaseItem(product2, 2);

        List<PurchaseItem> products1 = new ArrayList<PurchaseItem>();

        products1.add(item1);
        products1.add(item2);
        
        ActionDao purchasedao = new ActionDao();
        purchasedao.savePurchase(products1, Manzi, Kipharma);

        List<Purchase> purchases = purchaseDao.findAll();
        assertEquals(purchases.size(), 1);

    }

    public void testCreateSale() {

    }

    @AfterClass
    public void afterEverything() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/betterx?zeroDateTimeBehavior=convertToNull",
                    "root", "")) {
                Statement st = con.createStatement();
                st.execute("DROP table hibernate_sequence");
                st.execute("DROP table listitems");
                st.execute("DROP table purchaseitem");
                st.execute("DROP table purchase");
                st.execute("DROP table product");
                st.execute("DROP table users");
                st.execute("DROP table supplier");
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
