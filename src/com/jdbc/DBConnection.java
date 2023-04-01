package com.jdbc;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

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


    public static int authentificate(int matricule, String motDePasse) {
        //Authentification pour tester
        if (Integer.toString(matricule).equals("3")) {
            return 1;  //1 -> Acceuil Etudiant
        }
        if (Integer.toString(matricule).equals("4")) {
            return 2; //2 -> Acceuil admin
        }
        PreparedStatementWrapper preparedStatement;
        try {
            String query = "SELECT * FROM etudiant WHERE matricule = ? AND mot_de_passe = ?";
            DBConnection.preparedStatement = DBConnection.getConnection().prepareStatement(query);
            DBConnection.preparedStatement.setInt(1, matricule);
            DBConnection.preparedStatement.setString(2, motDePasse);
            ResultSet resultSet = DBConnection.preparedStatement.executeQuery();
            if (resultSet.next()) {
                return 1;
            } else {
                query = "SELECT * FROM admin WHERE matricule = ? AND mot_de_passe = ?";
                DBConnection.preparedStatement = DBConnection.getConnection().prepareStatement(query);
                DBConnection.preparedStatement.setInt(1, matricule);
                DBConnection.preparedStatement.setString(2, motDePasse);
                resultSet = DBConnection.preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return 2;

                } else {
                    return 0;
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;

    }


}


