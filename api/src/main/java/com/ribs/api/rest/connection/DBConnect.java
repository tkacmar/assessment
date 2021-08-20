package com.ribs.api.rest.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    static Connection conn = null;

    public static void makeJDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/jgp6y3rjWo", "jgp6y3rjWo", "vhbjNSfOlL");
            if (conn != null) {
                System.out.println("Database Connection Successful! Enjoy. Now it's time to push data");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

    public static void main(String[] args) {
        makeJDBCConnection();
    }
}
