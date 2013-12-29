/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.db.manager.helper;

import org.crm.db.manager.ClientOrganizationDBManager;
import org.crm.entity.Address;
import org.crm.entity.ClientOrganization;

/**
 *
 * @author cag
 */
public class AddressHelper {
    
    public Address getDetail(Address address) {
        
        ClientOrganizationDBManager clientOrganizationDBManager = new ClientOrganizationDBManager();
        ClientOrganization clientOrganization = clientOrganizationDBManager.getOne(address.getOrganizationId());
        address.setClientOrganization(clientOrganization);
        
        return address;
    }
    
}
