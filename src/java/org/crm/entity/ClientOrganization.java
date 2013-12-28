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
public class ClientOrganization {
    
    private int id;
    
    private String name;
    
    private ClientTitle clientTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientTitle getClientTitle() {
        return clientTitle;
    }

    public void setClientTitle(ClientTitle clientTitle) {
        this.clientTitle = clientTitle;
    }
    
}
