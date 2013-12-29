/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.entity;

import org.json.simple.JSONObject;

/**
 *
 * @author cag
 */
public class Product {
    
    private int id;
    
    private String name;
    
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public JSONObject toJSon(boolean isDetailed) {
        JSONObject result = new JSONObject();
        result.put("id", this.id);
        result.put("name", this.name);
        
        if(isDetailed) {
            result.put("price", this.price);
        }
        
        return result;
    }
    
}
