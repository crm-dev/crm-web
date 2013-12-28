/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.entity;

import java.sql.Date;

/**
 *
 * @author cag
 */
public class ServiceOrderPot {
    
    private int orderPotId;
    
    private int serviceOrderId;
    
    private int clientAdressId;
    
    private Date deliveryAt;

    public int getOrderPotId() {
        return orderPotId;
    }

    public void setOrderPotId(int orderPotId) {
        this.orderPotId = orderPotId;
    }

    public int getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(int serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public int getClientAdressId() {
        return clientAdressId;
    }

    public void setClientAdressId(int clientAdressId) {
        this.clientAdressId = clientAdressId;
    }

    public Date getDeliveryAt() {
        return deliveryAt;
    }

    public void setDeliveryAt(Date deliveryAt) {
        this.deliveryAt = deliveryAt;
    }
    
    
    
}
