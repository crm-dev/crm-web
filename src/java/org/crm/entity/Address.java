/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.entity;

/**
 *
 * @author cag
 */
public class Address {
    
    //TODO : Bura semt il ilçe gelecek
    
    private int id;
    
    private int organizationId;
    
    private String addressDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String fullAddress) {
        this.addressDescription = fullAddress;
    }
    
}
