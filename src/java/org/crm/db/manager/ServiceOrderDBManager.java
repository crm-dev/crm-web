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
import org.crm.dbms.Connector;
import org.crm.entity.ServiceOrder;

/**
 *
 * @author cag
 */
public class ServiceOrderDBManager {
    
    public ServiceOrder getOne(int id) {

        Connector connector = new Connector();
        Connection conn = null;
        ServiceOrder result = null;
        try {
            
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM serviceOrder WHERE id=?");
            ResultSet rs = null;
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                result = new ServiceOrder();
                result.setId(rs.getInt("id"));
                result.setServiceName(rs.getString("serviceName"));
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return result;
    }

    public List<ServiceOrder> getList() {

        Connector connector = new Connector();
        Connection conn = null;
        List<ServiceOrder> resultList = new ArrayList<ServiceOrder>();
        try {
            
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM serviceOrder");
            ResultSet rs = null;
            rs = stmt.executeQuery();

            while (rs.next()) {
                ServiceOrder serviceOrder = new ServiceOrder();
                serviceOrder.setId(rs.getInt("id"));
                serviceOrder.setServiceName(rs.getString("serviceName"));

                resultList.add(serviceOrder);
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

    public ServiceOrder saveServiceOrder(ServiceOrder serviceOrder) {

        Connector connector = new Connector();
        Connection conn = null;
        ResultSet generatedKeys = null;
        PreparedStatement stmt = null;
        try {

            conn = connector.getConnection();
            stmt = conn.prepareStatement("INSERT INTO serviceOrder(serviceName) VALUES(?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, serviceOrder.getServiceName());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating serviceOrder failed, no rows affected.");
            }

            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                serviceOrder.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating serviceOrder failed, no generated key obtained.");
            }
        } catch (java.sql.SQLException ex) {
            System.out.println(ex.getStackTrace());
        } finally {
            try {
                stmt.close();
                generatedKeys.close();
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return serviceOrder;
    }

}
