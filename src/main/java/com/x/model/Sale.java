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
public class Sale {
    @Id
    private String saleId;
    @OneToMany
    private List<SaleItem> soldItems;
    private Client client;

    public Sale() {
    }

    public Sale(String saleId, List<SaleItem> soldItems, Client client) {
        this.saleId = saleId;
        this.soldItems = soldItems;
        this.client = client;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public List<SaleItem> getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(List<SaleItem> soldItems) {
        this.soldItems = soldItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public void getTotalSoldAmount(){
    
    }
}
