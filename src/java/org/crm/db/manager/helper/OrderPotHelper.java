/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.db.manager.helper;

import org.crm.db.manager.AddressDBManager;
import org.crm.db.manager.ClientOrganizationDBManager;
import org.crm.entity.Address;
import org.crm.entity.ClientOrganization;
import org.crm.entity.OrderPot;

/**
 *
 * @author cag
 */
public class OrderPotHelper {
    
    public OrderPot getDetail(OrderPot orderPot) {
        
        AddressDBManager addressDBManager = new AddressDBManager();
        
        Address address = addressDBManager.getOne(orderPot.getClientOrganizationAddressId());
        
        AddressHelper addressHelper = new AddressHelper();
        address = addressHelper.getDetail(address);
        orderPot.setClientOrganizationAddress(address);
        
//        ClientOrganizationDBManager clientOrganizationDBManager = new ClientOrganizationDBManager();
//        ClientOrganization clientOrganization = clientOrganizationDBManager.getOne(address.getOrganizationId());
        
//        orderPot.setClientOrganization(clientOrganization);
        
        return orderPot;
    }
    
}
