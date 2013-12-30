/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crm.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.crm.db.manager.helper.StatementHelper;
import org.crm.dbms.Connector;
import org.crm.entity.ServiceOrderPot;

/**
 *
 * @author cag
 */
public class ServiceOrderPotDBManager {
    
    public List<ServiceOrderPot> getListByOrderIds(List<Integer> orderPotIds) {

        Connector connector = new Connector();
        Connection conn = null;
        List<ServiceOrderPot> resultList = new ArrayList<ServiceOrderPot>();
        try {

            conn = connector.getConnection();
            PreparedStatement stmt = null;
            String joinedStatement = StatementHelper.createJoinedStatementParam(orderPotIds);
            stmt = conn.prepareStatement("SELECT * FROM serviceOrderPot WHERE orderPotId IN(" + joinedStatement + ")");
            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {
                
                ServiceOrderPot serviceOrderPot = new ServiceOrderPot();
                serviceOrderPot.setOrderPotId(rs.getInt("orderPotId"));
                serviceOrderPot.setServiceOrderId(rs.getInt("serviceOrderId"));
                
                resultList.add(serviceOrderPot);
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

    public List<ServiceOrderPot> getList(int serviceOrderId) {

        Connector connector = new Connector();
        Connection conn = null;
        List<ServiceOrderPot> resultList = new ArrayList<ServiceOrderPot>();
        try {

            conn = connector.getConnection();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM serviceOrderPot WHERE serviceOrderId=?");
            ResultSet rs = null;

            stmt.setInt(1, serviceOrderId);

            rs = stmt.executeQuery();

            while (rs.next()) {
                
                ServiceOrderPot serviceOrderPot = new ServiceOrderPot();
                serviceOrderPot.setOrderPotId(rs.getInt("orderPotId"));
                serviceOrderPot.setServiceOrderId(rs.getInt("serviceOrderId"));
                
                resultList.add(serviceOrderPot);
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

    public void saveServiceOrderPot(ServiceOrderPot serviceOrderPot) {

        Connector connector = new Connector();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            conn = connector.getConnection();
            stmt = conn.prepareStatement("INSERT INTO serviceOrderPot(serviceOrderId,orderPotId) VALUES(?,?)");
            
            stmt.setInt(1, serviceOrderPot.getServiceOrderId());
            stmt.setInt(2, serviceOrderPot.getOrderPotId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating serviceOrderPot failed, no rows affected.");
            }

            stmt.getGeneratedKeys();
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }
    }

}
