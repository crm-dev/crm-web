/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.db.manager.helper;

import java.util.ArrayList;
import java.util.List;
import org.crm.db.manager.OrderPotDBManager;
import org.crm.db.manager.ServiceOrderPotDBManager;
import org.crm.entity.OrderPot;
import org.crm.entity.ServiceOrder;
import org.crm.entity.ServiceOrderPot;
import org.json.simple.JSONObject;

/**
 *
 * @author cag
 */
public class ServiceOrderDetailedListHelper {
    
    public JSONObject getDetailed(ServiceOrder serviceOrder) {
        ServiceOrderPotDBManager serviceOrderPotDBManager = new ServiceOrderPotDBManager();
        List<ServiceOrderPot> serviceOrderPots = serviceOrderPotDBManager.getList(serviceOrder.getId());
        
        List<Integer> serviceOrderPotIds = new ArrayList<Integer>();
        
        for(ServiceOrderPot serviceOrderPot : serviceOrderPots) {
            serviceOrderPotIds.add(serviceOrderPot.getOrderPotId());
        }
        
        List<OrderPot> orderPots = new ArrayList<OrderPot>();
        OrderPotDBManager orderPotDBManager = new OrderPotDBManager();
        if(!serviceOrderPotIds.isEmpty()) {
            orderPots = orderPotDBManager.getList(serviceOrderPotIds);
        }
        
    }
    
}
