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
public class ProductionType {
    
    private int id;
    
    private String typeName;
    
    private int seniorType;
    
    private int isMainType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getSeniorType() {
        return seniorType;
    }

    public void setSeniorType(int seniorType) {
        this.seniorType = seniorType;
    }

    public int getIsMainType() {
        return isMainType;
    }

    public void setIsMainType(int isMainType) {
        this.isMainType = isMainType;
    }
    
    public JSONObject toJSon() {
        JSONObject result = new JSONObject();
        result.put("id", this.id);
        result.put("typeName", this.typeName);
        
        return result;
    }
    
    
}
