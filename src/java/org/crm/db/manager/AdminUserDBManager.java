/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.crm.dbms.Connector;
import org.crm.entity.AdminUser;
import org.crm.entity.ClientOrganization;

/**
 *
 * @author cag
 */
public class AdminUserDBManager {
    
    public AdminUser getOne(String userName, String password) {

        Connector connector = new Connector();
        Connection conn = null;
        AdminUser adminUser = null;
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM adminUser WHERE userName=? AND password=?");
            ResultSet rs = null;
            
            stmt.setString(1, userName);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                adminUser = new AdminUser();
                adminUser.setId(rs.getInt("id"));
                adminUser.setPassword(rs.getString("password"));
                adminUser.setUserName(rs.getString("userName"));
                
            }
        } catch (java.sql.SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }

        return adminUser;
    }
    
}
