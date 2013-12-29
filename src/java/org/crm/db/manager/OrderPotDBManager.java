/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crm.db.manager;

import org.crm.db.manager.helper.StatementHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.crm.dbms.Connector;
import org.crm.entity.OrderPot;

/**
 *
 * @author cag
 */
public class OrderPotDBManager {

    public List<OrderPot> getList(List<Integer> ids) {

        Connector connector = new Connector();
        Connection conn = null;
        List<OrderPot> resultList = new ArrayList<OrderPot>();
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            String resultParam = StatementHelper.createJoinedStatementParam(ids);
            stmt = conn.prepareStatement("SELECT * FROM orderPot WHERE id IN(" + resultParam + ")");
            ResultSet rs = null;
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                OrderPot orderPot = new OrderPot();
                orderPot.setId(rs.getInt("id"));
                orderPot.setPrice(rs.getDouble("price"));
                orderPot.setProductId(rs.getInt("productId"));
                orderPot.setQuantity(rs.getInt("quantity"));
                orderPot.setClientOrganizationAddressId(rs.getInt("clientOrganizationAddressId"));
                orderPot.setDeliveryAt(rs.getDate("deliveryAt"));
                
                resultList.add(orderPot);
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

    public OrderPot saveOrderPot(OrderPot orderPot) {

        Connector connector = new Connector();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = connector.getConnection();
            stmt = conn.prepareStatement("INSERT INTO orderPot(productId,quantity,price,clientOrganizationAddressId,deliveryAt) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, orderPot.getProductId());
            stmt.setInt(2, orderPot.getQuantity());
            stmt.setDouble(3, orderPot.getPrice());
            stmt.setDouble(4, orderPot.getClientOrganizationAddressId());
            stmt.setDate(5, orderPot.getDeliveryAt());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating serviceOrderPot failed, no rows affected.");
            }

            resultSet = stmt.getGeneratedKeys();
            
            if(resultSet.next()) {
                orderPot.setId(resultSet.getInt(1));
            }
            
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }
        
        return orderPot;
    }

}
