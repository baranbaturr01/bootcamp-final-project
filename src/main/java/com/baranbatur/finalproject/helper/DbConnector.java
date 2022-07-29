package com.baranbatur.finalproject.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {



    public Connection connector() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "root", "toor");
        if (conn != null) {
            System.out.println("Connected to the database");

        } else {
            System.out.println("Failed to make connection!");
        }
        return conn;
    }

    public static Connection getInstance() throws SQLException {
        return new DbConnector().connector();
    }
}
