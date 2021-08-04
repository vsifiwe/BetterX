/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.model;

import com.x.dao.GenericDao;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author X
 */
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date creationDate;
    private Supplier supplier;
    private List<PurchaseItem> products;
    private User createdBy;

    public Purchase() {
    }

    public Purchase(Date creationDate, Supplier supplier, List<PurchaseItem> products, User createdBy) {
        this.creationDate = creationDate;
        this.supplier = supplier;
        this.products = products;
        this.createdBy = createdBy;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<PurchaseItem> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseItem> products) {
        this.products = products;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
    
    public void savePurchase(){
        
        GenericDao dao = new GenericDao(Product.class);
        for(PurchaseItem item : products){
            Product product = (Product) dao.findbyID(item.getProduct().getId());
            product.increaseStock(item.getAmount());
            dao.update(product);
        }
    }
    
    public void creditSupplier(){
        
    }
}
