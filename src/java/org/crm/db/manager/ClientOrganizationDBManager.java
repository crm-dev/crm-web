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
import org.crm.entity.ClientOrganization;
import org.crm.entity.OrderPot;

/**
 *
 * @author cag
 */
public class ClientOrganizationDBManager {
    
    public ClientOrganization getOne(int id) {

        Connector connector = new Connector();
        Connection conn = null;
        ClientOrganization clientOrganization = null;
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM clientOrganization WHERE id=?");
            ResultSet rs = null;
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                clientOrganization = new ClientOrganization();
                clientOrganization.setId(rs.getInt("id"));
//                clientOrganization.setClientTitle(rs.getString("title"));
                clientOrganization.setName(rs.getString("organizationName"));
                
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return clientOrganization;
    }
    
    public List<ClientOrganization> getList(List<Integer> ids) {

        Connector connector = new Connector();
        Connection conn = null;
        List<ClientOrganization> resultList = new ArrayList<ClientOrganization>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            String resultParam = StatementHelper.createJoinedStatementParam(ids);
            stmt = conn.prepareStatement("SELECT * FROM clientOrganization WHERE id IN(" + resultParam + ")");
            ResultSet rs = null;
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                ClientOrganization clientOrganization = new ClientOrganization();
                clientOrganization.setId(rs.getInt("id"));
//                clientOrganization.setClientTitle(rs.getString("title"));
                clientOrganization.setName(rs.getString("name"));
                
                
                resultList.add(clientOrganization);
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
