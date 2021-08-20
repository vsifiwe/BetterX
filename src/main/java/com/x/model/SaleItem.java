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
public class SaleItem {
    @Id
    private String saleId;
    private Product product;
    private long numberOfItems;

    public SaleItem() {
    }

    public SaleItem(String saleId, Product product, long numberOfItems) {
        this.saleId = saleId;
        this.product = product;
        this.numberOfItems = numberOfItems;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
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
