/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.entity;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author cag
 */
public class ServiceOrder {
    
    private int id;
    
    private String serviceName;
    
    private double totalOrderPrice;//serviceOrderPot-service
    
    
    //
    
    private List<OrderPot> orderPots;
    
//    private ClientOrganization clientOrganization;

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

    public List<OrderPot> getOrderPots() {
        return orderPots;
    }

    public void setOrderPots(List<OrderPot> orderPots) {
        this.orderPots = orderPots;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }
    
    public JSONObject toJSon() {
        JSONObject jo = new JSONObject();
        jo.put("id", this.id);
        jo.put("serviceName", this.serviceName);
        
        
        if(this.orderPots != null) {
            if(!this.orderPots.isEmpty()) {
                JSONArray orderPotsJSON = new JSONArray();
                for(OrderPot orderPot : this.orderPots) {
                    JSONObject serviceOrderPotJSON = orderPot.toJSon();
                    orderPotsJSON.add(serviceOrderPotJSON);
                }
                
                jo.put("orderPots", orderPotsJSON);
            }
        }
        
        return jo;
    }
    
}
