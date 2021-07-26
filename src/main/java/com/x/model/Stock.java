/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.model;

import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long purchasingPrice;
    private Date expiry;
    private String batch;
    private long qty;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public Stock() {
    }

    public Stock(long purchasingPrice, Date expiry, String batch, long qty, Product product) {
        this.purchasingPrice = purchasingPrice;
        this.expiry = expiry;
        this.batch = batch;
        this.qty = qty;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(long purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
