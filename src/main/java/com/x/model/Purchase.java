/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author X
 */
@Entity
public class Purchase {
    @Id
    private String purchaseId;
    @OneToMany
    private List<PurchaseItem> purchasedItems;
    private Supplier supplier;

    public Purchase() {
    }

    public Purchase(String purchaseId, List<PurchaseItem> purchasedItems, Supplier supplier) {
        this.purchaseId = purchaseId;
        this.purchasedItems = purchasedItems;
        this.supplier = supplier;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public List<PurchaseItem> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(List<PurchaseItem> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    public void getTotalPurchasedAmount(){
        
    }
}
