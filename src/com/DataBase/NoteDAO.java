package com.DataBase;

import java.sql.*;

public class NoteDAO {
    private static Connection connection = DBConnection.getConnection();


    public static void updateNote(String module,String element,String professeur,double note){
        try {
            // create a prepared statement to update a row in the database
            PreparedStatement ps = connection.prepareStatement("UPDATE resultat_element SET note = ? WHERE id_element = (SELECT id_element FROM element_module WHERE nom = ?)");
            ps.setDouble(1, note);
            ps.setString(2,element);

            // execute the update statement
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated == 0) {
                System.out.println("No rows updated");
            } else {
                System.out.println(rowsUpdated + " rows updated");
            }
        } catch (SQLException e) {
            // handle any SQL exceptions here
        }

    }
}
