package com.DataBase;

import java.sql.*;

public class NoteDAO {
    private static Connection connection = DBConnection.getConnection();

    public static void saveNote(double note,String elementModule, int matricule) {
        try {
            // Get the ID of the element module from the database using its name
            String query = "SELECT id_element FROM element_module WHERE nom = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, elementModule);
            ResultSet resultSet = statement.executeQuery();
            int idElement = -1;
            if (resultSet.next()) {
                idElement = resultSet.getInt("id_element");
            }

            // Insert the new note into the resultat_element table
            if (idElement != -1) {
                query = "INSERT INTO resultat_element (id_element, id_etudiant, note) VALUES (?, ?, ?)";
                statement = connection.prepareStatement(query);
                statement.setInt(1, idElement);
                statement.setInt(2, matricule);
                statement.setDouble(3, note);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
