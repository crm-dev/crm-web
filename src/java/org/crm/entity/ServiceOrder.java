/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.entity;

import java.util.List;

/**
 *
 * @author cag
 */
public class ServiceOrder {
    
    private int id;
    
    private String serviceName;
    
    private List<ServiceOrderPot> orderPots;
    
    private double totalOrderPrice;//serviceOrderPot-service

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<ServiceOrderPot> getOrderPots() {
        return orderPots;
    }

    public void setOrderPots(List<ServiceOrderPot> orderPots) {
        this.orderPots = orderPots;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }
    
}
