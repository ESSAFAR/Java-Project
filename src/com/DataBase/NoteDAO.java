package com.DataBase;

import com.Model2.ElementModule;
import com.Model2.Note;
import com.Model2.Professeur;

import java.sql.*;
import java.util.ArrayList;

public class NoteDAO {
    private static Connection connection = DBConnection.getConnection();

    // retrieve list des Notes d'un etudiant
    public static ArrayList<Note> getNotes(int matricule){
        ArrayList<Note> listNotes = new ArrayList<>();
        try {
            String sqlQuery = "SELECT ms.nom AS nom_module, em.nom AS nom_element_module, p.nom AS nom_professeur, re.note\n" +
                    "FROM resultat_element re\n" +
                    "JOIN element_module em ON re.id_element = em.id_element\n" +
                    "JOIN module_semestre ms ON em.id_module = ms.id_module\n" +
                    "JOIN professeur p ON em.id_prof = p.id_prof\n" +
                    "WHERE re.id_etudiant = ? \n" +
                    "ORDER BY ms.nom ASC;\n";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,matricule);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Note note = new Note();
                ElementModule elementModule = new ElementModule();
                Professeur professeur = new Professeur("John Doe", "password", "John", "1234567890", 1234, "M", "01/01/1970", "New York", "US", "john.doe@university.edu", "555-555-5555", "123 Main St");

                elementModule.setModule((String) resultSet.getObject(1));
                elementModule.setNom((String) resultSet.getObject(2));
                professeur.setNom((String) resultSet.getObject(3));

                note.setElementModule(elementModule);
                note.setProfesseur(professeur);
                note.setNote((Double) resultSet.getObject(4));

                listNotes.add(note);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listNotes;
    }

    //save Note
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


    //update Note

    public static void updateNote(double newNote, String elementModule,int matricule){
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
                query = "UPDATE resultat_element SET note = ? WHERE id_element = ? AND id_etudiant = ?";
                statement = connection.prepareStatement(query);
                statement.setDouble(1, newNote);
                statement.setInt(2, idElement);
                statement.setInt(3, matricule);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
