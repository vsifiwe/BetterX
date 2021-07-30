/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author X
 */
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String supplierName;
    private long outstandingAmount;

    public Supplier(String supplierName, long outstandingAmount) {
        this.supplierName = supplierName;
        this.outstandingAmount = outstandingAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public long getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(long outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
    
    
}
