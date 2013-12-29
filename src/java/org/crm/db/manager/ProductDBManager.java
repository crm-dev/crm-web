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
import org.crm.entity.Product;

/**
 *
 * @author cag
 */
public class ProductDBManager {
    
    public Product getOne(int id) {

        Connector connector = new Connector();
        Connection conn = null;
        Product product = null;
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM product WHERE id=?");
            ResultSet rs = null;
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                product = new Product();
                product.setId(rs.getInt("id"));
//                clientOrganization.setClientTitle(rs.getString("title"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("productName"));
                
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return product;
    }
    
    public List<Product> getList(List<Integer> ids) {

        Connector connector = new Connector();
        Connection conn = null;
        List<Product> resultList = new ArrayList<Product>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            String resultParam = StatementHelper.createJoinedStatementParam(ids);
            stmt = conn.prepareStatement("SELECT * FROM product WHERE id IN(" + resultParam + ")");
            ResultSet rs = null;
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Product product = new Product();
                product.setId(rs.getInt("id"));
//                clientOrganization.setClientTitle(rs.getString("title"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("productName"));
                
                
                resultList.add(product);
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
    
    public List<Product> getAll() {

        Connector connector = new Connector();
        Connection conn = null;
        List<Product> resultList = new ArrayList<Product>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM product");
            ResultSet rs = null;
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Product product = new Product();
                product.setId(rs.getInt("id"));
//                clientOrganization.setClientTitle(rs.getString("title"));
//                clientOrganization.setName(rs.getString("price"));
                product.setName(rs.getString("productName"));
                
                
                resultList.add(product);
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
