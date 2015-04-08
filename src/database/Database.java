/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author biswajit
 */
public class Database {

//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      static final String DB_URL = "jdbc:mysql://10.5.18.66/12CS10058";
//    static final String DB_URL = "jdbc:mysql://localhost/12CS10058";
//    static final String DB_URL = "jdbc:mysql://localhost/DBMSTermProject";
      
//    static final String USER = "root";
//    static final String PASS = "prith";
    static final String USER = "12CS10058";
    static final String PASS = "btech12";
//    static final String USER = "biswa";
//    static final String PASS = "biswa";
    
    static Connection conn = null;
    static Statement stmt = null;
    static Connection conn2 = null;
    static Statement stmt2 = null;

    public static int update(String s) {
        try {
            return stmt.executeUpdate(s);
        } catch (SQLException e) {
            System.out.println(s + "\n" + e.toString());
            return -1;
        }
    }

    public static ResultSet query(String s) {
        try {
            return stmt.executeQuery(s);
        } catch (SQLException e) {
            System.out.println(s + "\n" + e.toString());
            return null;
        }
    }

    public static ResultSet query2(String s) {
        try {
            return stmt2.executeQuery(s);
        } catch (SQLException e) {
            System.out.println(s + "\n" + e.toString());
            return null;
        }
    }

    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt2 = conn2.createStatement();
            System.out.println("Connected");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void close() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            System.out.println("Statement Closed");
        } catch (Exception se2) {
        }
        try {
            if (conn != null) {
                conn.close();
            }
            System.out.println("Connection Closed");
        } catch (Exception se) {
            se.printStackTrace();
        }
        
        try {
            if (stmt2 != null) {
                stmt2.close();
            }
            System.out.println("Statement Closed");
        } catch (Exception se2) {
        }
        try {
            if (conn2 != null) {
                conn2.close();
            }
            System.out.println("Connection Closed");
        } catch (Exception se) {
            se.printStackTrace();
        }
    }
}
