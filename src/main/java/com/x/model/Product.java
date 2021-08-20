/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.model;

import com.x.types.Measure;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author X
 */
@Entity
public class Product {
    @Id
    private String productId;
    private String productName;
    private String manufacturingCompany;
    private String description;
    private String country;
    private long quantity;
    private Measure measure;

    public Product() {
    }

    public Product(String productId, String productName, String manufacturingCompany, String description, String country, long quantity, Measure measure) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturingCompany = manufacturingCompany;
        this.description = description;
        this.country = country;
        this.quantity = quantity;
        this.measure = measure;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
