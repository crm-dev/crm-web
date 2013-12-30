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
import org.crm.entity.OrderType;

/**
 *
 * @author cag
 */
public class OrderTypeDBManager {
    
    public List<OrderType> getMainTypes() {

        Connector connector = new Connector();
        Connection conn = null;
        List<OrderType> orderTypes = new ArrayList<OrderType>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM orderType WHERE isMainType=1");
            ResultSet rs = null;
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                OrderType orderType = new OrderType();
                orderType.setId(rs.getInt("id"));
                orderType.setTypeName(rs.getString("typeName"));
                orderType.setIsMainType(rs.getInt("isMainType"));
                
                
                orderTypes.add(orderType);
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return orderTypes;
    }
    
    public List<OrderType> getChildTypes(int seniorType) {

        Connector connector = new Connector();
        Connection conn = null;
        List<OrderType> orderTypes = new ArrayList<OrderType>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM orderType WHERE isMainType=0 AND seniorType=?");
            ResultSet rs = null;
            
            stmt.setInt(1, seniorType);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                OrderType orderType = new OrderType();
                orderType.setId(rs.getInt("id"));
                orderType.setTypeName(rs.getString("typeName"));
                orderType.setIsMainType(rs.getInt("isMainType"));
                
                
                orderTypes.add(orderType);
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return orderTypes;
    }
    
    public OrderType getOne(int id) {

        Connector connector = new Connector();
        Connection conn = null;
        OrderType orderType = null;
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM orderType WHERE id=?");
            ResultSet rs = null;
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                orderType = new OrderType();
                orderType.setId(rs.getInt("id"));
                orderType.setTypeName(rs.getString("typeName"));
                orderType.setIsMainType(rs.getInt("isMainType"));
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return orderType;
    }
    
}
