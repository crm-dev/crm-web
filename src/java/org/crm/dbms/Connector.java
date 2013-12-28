/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crm.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cag
 */
public class Connector {

  private static final String url = "jdbc:mysql://localhost:3306/crmdb?useUnicode=true&amp;characterEncoding=utf8";

  private static final String username = "root";

  private static final String password = "1";
  
  public Connection getConnection() {

    Connection conn = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      return null;
    }
    try {
      conn = DriverManager.getConnection(url, username, password);
    }
    catch (SQLException ex) {
      System.out.println("CONNECTION ERROR : SQLException[" + ex + "]");
      return null;
    }

    return conn;
  }


//  public Connection getConnection() {
//
//    Connection conn = null;
//
//    try {
//      Class.forName("com.mysql.jdbc.Driver");
//    }
//    catch (ClassNotFoundException ex) {
//      ex.printStackTrace();
//      return null;
//    }
//    try {
//      conn = DriverManager.getConnection(url, username, password);
//    }
//    catch (SQLException ex) {
//      System.out.println("CONNECTION ERROR : SQLException[" + ex + "]");
//      return null;
//    }
//
//    return conn;
//  }


}