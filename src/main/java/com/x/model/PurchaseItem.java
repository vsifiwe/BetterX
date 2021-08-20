/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author X
 */
@Entity
public class PurchaseItem {
    @Id
    private String purchaseItemId;
    private Product product;
    private long numberOfItems;

    public PurchaseItem() {
    }

    public PurchaseItem(String purchaseItemId, Product product, long numberOfItems) {
        this.purchaseItemId = purchaseItemId;
        this.product = product;
        this.numberOfItems = numberOfItems;
    }

    public String getPurchaseItemId() {
        return purchaseItemId;
    }

    public void setPurchaseItemId(String purchaseItemId) {
        this.purchaseItemId = purchaseItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
    
    
    
}
