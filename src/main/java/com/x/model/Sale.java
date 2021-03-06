/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.model;

import com.x.dao.GenericDao;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author X
 */
@Entity
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String customerName;
    private List<PurchaseItem> products;

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<PurchaseItem> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseItem> products) {
        this.products = products;
    }
    
    public void saveSale(){
        GenericDao dao = new GenericDao(Product.class);
        for(PurchaseItem item : products){
            Product product = (Product) dao.findbyID(item.getProduct().getId());
            product.reduceStock(item.getAmount());
            dao.update(product);
        }
    }
}
