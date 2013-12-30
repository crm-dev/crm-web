/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.db.manager.helper;

import org.crm.db.manager.AddressDBManager;
import org.crm.db.manager.OrderTypeDBManager;
import org.crm.db.manager.ProductionTypeDBManager;
import org.crm.entity.Address;
import org.crm.entity.OrderPot;
import org.crm.entity.OrderType;
import org.crm.entity.ProductionType;

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
        
//        OrderTypeDBManager orderTypeDBManager = new OrderTypeDBManager();
//        OrderType orderType = orderTypeDBManager.getOne(orderPot.getOrderTypeId());
//        
//        orderPot.setOrderType(orderType);
//        
//        ProductionTypeDBManager productionTypeDBManager = new ProductionTypeDBManager();
//        ProductionType productionType = productionTypeDBManager.getOne(orderPot.getProductionTypeId());
        
//        orderPot.setProductionType(productionType);
//        ClientOrganizationDBManager clientOrganizationDBManager = new ClientOrganizationDBManager();
//        ClientOrganization clientOrganization = clientOrganizationDBManager.getOne(address.getOrganizationId());
        
//        orderPot.setClientOrganization(clientOrganization);
        
        return orderPot;
    }
    
}
