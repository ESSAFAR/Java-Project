package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbConnection {


    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/departement", USERNAME, PASSWORD);

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return connection;
    }
}


