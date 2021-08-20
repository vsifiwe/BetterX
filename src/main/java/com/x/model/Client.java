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
public class Client {
    @Id
    private String clientId;
    private long outstandingAmount;
    private Date creationDate;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String insurance;

    public Client() {
    }

    public Client(String clientId, long outstandingAmount, Date creationDate, String firstName, String lastName, String phoneNumber, String insurance) {
        this.clientId = clientId;
        this.outstandingAmount = outstandingAmount;
        this.creationDate = creationDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.insurance = insurance;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public long getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(long outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
