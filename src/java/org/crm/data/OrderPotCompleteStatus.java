/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.data;

/**
 *
 * @author cag
 */
public enum OrderPotCompleteStatus {
    
    COMPLETED(1),
    NOT_COMPLETED(0);
    
    private int key;

    private OrderPotCompleteStatus(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    
    
    
}
