package com.DataBase;

import com.Model.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    private Connection connection = DBConnection.getConnection();

    //Teste si un eleve existe dans la BD
    public static boolean MatriculeExiste(int matricule) {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM etudiant WHERE matricule = ?");
            ps.setString(1, "" + matricule);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            ps.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Si l'etudiant existe, il est modifie, sinon, il sera ajoute a la BD
    public static void modifierEtudiant(int matricule, String nom, String prenom, String motDePasse, String cin, String genre, String dateNaissance, String lieuNaissance, String nationalite, String telephone, String adresse, String cne) {
        {
            try {
                PreparedStatement ps;
                if (!MatriculeExiste(matricule)) {
                    ps = DBConnection.getConnection().prepareStatement("INSERT INTO etudiant (nom, prenom, cin, mot_de_passe, matricule, cne, genre, date_naissance, lieu_naissance, nationalite, `email`, telephone, adresse) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    ps.setString(1, nom);
                    ps.setString(2, prenom);
                    ps.setString(3, cin);
                    ps.setString(4, motDePasse);
                    ps.setInt(5, matricule);
                    ps.setString(6, cne);
                    ps.setString(7, genre);
                    ps.setDate(8, new java.sql.Date(2005-06-07));
                    ps.setString(9, lieuNaissance);
                    ps.setString(10, nationalite);
                    ps.setString(11, nom+"."+prenom+"@student.emi.ac.ma");
                    ps.setString(12, telephone);
                    ps.setString(13, adresse);
                } else {
                    ps = DBConnection.getConnection().prepareStatement("UPDATE etudiant SET nom = ?, prenom = ?, cin = ?, mot_de_passe = ?, cne = ?, genre = ?, date_naissance = ?, lieu_naissance = ?, nationalite = ?, email = ? , telephone = ?, adresse = ? WHERE matricule = ?");
                    ps.setString(1, nom);
                    ps.setString(2, prenom);
                    ps.setString(3, cin);
                    ps.setString(4, motDePasse);
                    ps.setString(5, cne);
                    ps.setString(6, genre);
                    ps.setString(7, dateNaissance);
                    ps.setString(8, lieuNaissance);
                    ps.setString(9, nationalite);
                    ps.setString(10, nom+"."+prenom+"@student.emi.ac.ma");
                    ps.setString(11, telephone);
                    ps.setString(12, adresse);
                    ps.setInt(13, matricule);
                }
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }





    public static void delete ( int matricule){
                try {
                    PreparedStatement ps = DBConnection.getConnection().prepareStatement("DELETE FROM etudiant WHERE matricule=?");
                    ps.setInt(1, matricule);
                    ps.executeUpdate();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            public static Etudiant getEtudiant ( int matricule){
                Etudiant etudiant = null;
                try {
                    PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM etudiant WHERE matricule=?");
                    ps.setInt(1, matricule);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next())
                        etudiant = new Etudiant(
                            rs.getString("nom"),
                                rs.getString("mot_de_passe"),
                                rs.getString("prenom"),
                            rs.getString("cin"),
                            rs.getInt("matricule"),
                                rs.getString("genre"),
                                rs.getString("date_naissance"),
                                rs.getString("lieu_naissance"),
                            rs.getString("nationalite"),
                            rs.getString("telephone"),
                            rs.getString("adresse"),
                                rs.getString("cne")

                                );
                    rs.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return etudiant;
            }

            public static List<Etudiant> getListEtudiant () {
                List<Etudiant> etudiants = new ArrayList<>();
                try {
                    Statement stmt = DBConnection.getConnection().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM etudiant");
                    while (rs.next()) {
                        Etudiant etudiant = EtudiantDAO.getEtudiant(rs.getInt("matricule"));
                        etudiants.add(etudiant);
                    }
                    rs.close();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return etudiants;
            }






    public static int getCount() {
             int count = 0;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) FROM etudiant";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


}
