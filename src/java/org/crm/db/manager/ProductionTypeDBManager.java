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
import org.crm.entity.ProductionType;

/**
 *
 * @author cag
 */
public class ProductionTypeDBManager {
    
    public List<ProductionType> getMainTypes() {

        Connector connector = new Connector();
        Connection conn = null;
        List<ProductionType> productionTypes = new ArrayList<ProductionType>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM productionType WHERE isMainType=1");
            ResultSet rs = null;
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                ProductionType productionType = new ProductionType();
                productionType.setId(rs.getInt("id"));
                productionType.setTypeName(rs.getString("typeName"));
                productionType.setIsMainType(rs.getInt("isMainType"));
                
                
                productionTypes.add(productionType);
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return productionTypes;
    }
    
    public List<ProductionType> getChildTypes(int seniorType) {

        Connector connector = new Connector();
        Connection conn = null;
        List<ProductionType> orderTypes = new ArrayList<ProductionType>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM productionType WHERE isMainType=0 AND seniorType=?");
            ResultSet rs = null;
            
            stmt.setInt(1, seniorType);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                ProductionType productionType = new ProductionType();
                productionType.setId(rs.getInt("id"));
                productionType.setTypeName(rs.getString("typeName"));
                productionType.setIsMainType(rs.getInt("isMainType"));
                
                
                orderTypes.add(productionType);
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
    
    public ProductionType getOne(int id) {

        Connector connector = new Connector();
        Connection conn = null;
        ProductionType productionType = null;
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM productionType WHERE id=?");
            ResultSet rs = null;
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                productionType = new ProductionType();
                productionType.setId(rs.getInt("id"));
                productionType.setTypeName(rs.getString("typeName"));
                productionType.setIsMainType(rs.getInt("isMainType"));
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return productionType;
    }
    
}
