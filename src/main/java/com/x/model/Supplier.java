/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author X
 */
@Entity
public class Supplier {
    @Id
    private String supplierId;
    private String supplierName;
    private long outstanding;
    private Date creationDate;

    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, long outstanding, Date creationDate) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.outstanding = outstanding;
        this.creationDate = creationDate;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public long getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(long outstanding) {
        this.outstanding = outstanding;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    } 
}
