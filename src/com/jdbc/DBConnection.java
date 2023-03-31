package com.jdbc;

import java.sql.*;
public class DBConnection {


    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    public static PreparedStatement preparedStatement ; //Transformer cela to public, utiliser un getter
    ResultSet resultSet ;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/departement", USERNAME, PASSWORD);

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return connection;
    }


}


