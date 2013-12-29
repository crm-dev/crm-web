/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.db.manager;

import org.crm.db.manager.helper.StatementHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.crm.dbms.Connector;
import org.crm.entity.Address;

/**
 *
 * @author cag
 */
public class AddressDBManager {
    
    public Address getOne(int id) {

        Connector connector = new Connector();
        Connection conn = null;
        Address address = null;
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM address WHERE id=?");
            ResultSet rs = null;
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                address = new Address();
                address.setId(rs.getInt("id"));
                address.setOrganizationId(rs.getInt("organizationId"));
                address.setAddressDescription(rs.getString("addressDescription"));
                
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return address;
    }
    
    public Address getOneByOrganizationId(int organizationId) {

        Connector connector = new Connector();
        Connection conn = null;
        Address address = null;
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM address WHERE organizationId=?");
            ResultSet rs = null;
            
            stmt.setInt(1, organizationId);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                address = new Address();
                address.setId(rs.getInt("id"));
                address.setOrganizationId(rs.getInt("organizationId"));
                address.setAddressDescription(rs.getString("addressDescription"));
                
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return address;
    }
    
    public List<Address> getList(List<Integer> ids) {

        Connector connector = new Connector();
        Connection conn = null;
        List<Address> resultList = new ArrayList<Address>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            String resultParam = StatementHelper.createJoinedStatementParam(ids);
            stmt = conn.prepareStatement("SELECT * FROM address WHERE organizationId IN(" + resultParam + ")");
            ResultSet rs = null;
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setOrganizationId(rs.getInt("organizationId"));
                address.setAddressDescription(rs.getString("addressDescription"));
                
                resultList.add(address);
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return resultList;
    }
    
}
