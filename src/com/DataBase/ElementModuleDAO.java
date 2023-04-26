package com.DataBase;

import com.Model2.ElementModule;

import java.sql.Connection;
import java.sql.*;

public class ElementModuleDAO {

    private static Connection conn = DBConnection.getConnection();

    //verifier si un element Module existe
    public static int elementModuleExiste(String name) {

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT id_element FROM element_module WHERE nom = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            int id_element = -1;
            if (rs.next()) {
                id_element = rs.getInt(1);
                return id_element;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }



    // chercher le module et le professeur d'un element module
    public static String[] getModuleAndProfessor(int idElementModule) throws SQLException {
        String[] result = new String[2];
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // préparer la requête SQL
            stmt = conn.prepareStatement("SELECT module_semestre.nom, professeur.nom FROM element_module " +
                    "INNER JOIN module_semestre ON element_module.id_module = module_semestre.id_module " +
                    "INNER JOIN professeur ON element_module.id_prof = professeur.id_prof " +
                    "WHERE element_module.id_element = ?");
            stmt.setInt(1, idElementModule);

            // exécuter la requête SQL
            rs = stmt.executeQuery();

            // récupérer les résultats
            if (rs.next()) {
                result[0] = rs.getString(1); // nom du module
                result[1] = rs.getString(2); // nom du professeur
            }
        } finally {
            // fermer les ressources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
}


}
