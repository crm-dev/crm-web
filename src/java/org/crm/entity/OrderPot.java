/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.entity;

import java.sql.Date;
import org.json.simple.JSONObject;

/**
 *
 * @author cag
 */
public class OrderPot {
    
    private int id;
    
    private int productId;
    
    private int quantity;
    
    private double price;
    
    private int clientOrganizationAddressId;
    
    private Date deliveryAt;
    
    //
    
    private Address clientOrganizationAddress;
    
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getClientOrganizationAddressId() {
        return clientOrganizationAddressId;
    }

    public void setClientOrganizationAddressId(int clientOrganizationAddressId) {
        this.clientOrganizationAddressId = clientOrganizationAddressId;
    }

    public Date getDeliveryAt() {
        return deliveryAt;
    }

    public void setDeliveryAt(Date deliveryAt) {
        this.deliveryAt = deliveryAt;
    }

    public Address getClientOrganizationAddress() {
        return clientOrganizationAddress;
    }

    public void setClientOrganizationAddress(Address clientOrganizationAddress) {
        this.clientOrganizationAddress = clientOrganizationAddress;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public JSONObject toJSon() {
        JSONObject result = new JSONObject();
        result.put("id", this.id);
        
        result.put("quantity", this.quantity);
        
        if(this.product != null) {
            result.put("product", this.product.toJSon(true));
        }
        
        if(this.clientOrganizationAddress != null) {
            result.put("deliveryAddress", this.clientOrganizationAddress.toJSon());
        }
        
        return result;
    }
    
}
