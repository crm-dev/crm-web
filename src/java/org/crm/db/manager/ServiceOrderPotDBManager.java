/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crm.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.crm.entity.ServiceOrder;
import org.crm.entity.ServiceOrderPot;
import org.sanalika.unused.ozg.Connector;

/**
 *
 * @author cag
 */
public class ServiceOrderPotDBManager {

    public List<ServiceOrderPot> getList(int serviceOrderId) {

        Connection conn = Connector.getConnection();
        List<ServiceOrderPot> resultList = new ArrayList<ServiceOrderPot>();
        try {

            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM serviceOrderPot WHERE serviceOrderId=?");
            ResultSet rs = null;

            stmt.setInt(1, serviceOrderId);

            rs = stmt.executeQuery();

            while (rs.next()) {
                
                ServiceOrderPot serviceOrderPot = new ServiceOrderPot();
                serviceOrderPot.setOrderPotId(rs.getInt("orderPotId"));
                serviceOrderPot.setServiceOrderId(rs.getInt("serviceOrderId"));
                serviceOrderPot.setClientAdressId(rs.getInt("clientAddressId"));
                serviceOrderPot.setDeliveryAt(rs.getDate("deliveryAt"));
                
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

    public void saveServiceOrder(ServiceOrderPot serviceOrderPot) {

        Connection conn = Connector.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = conn.prepareStatement("INSERT INTO serviceOrderPot(serviceOrderId,orderPotId,clientOrganizationAddressId,deliveryAt) VALUES(?,?,?,?)");
            
            stmt.setInt(1, serviceOrderPot.getServiceOrderId());
            stmt.setInt(2, serviceOrderPot.getOrderPotId());
            stmt.setInt(3, serviceOrderPot.getClientAdressId());
            stmt.setDate(4, serviceOrderPot.getDeliveryAt());

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
