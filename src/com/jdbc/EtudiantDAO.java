package com.jdbc;

import com.GUI.AdminFrames.AcceuilAdmin;
import com.GUI.StudentFrame.AcceuilEtudiant;
import com.Model.Etudiant;
import com.mysql.cj.jdbc.PreparedStatementWrapper;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
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
    public static void modifierEtudiant(int matricule, String nom, String motDePasse, String prenom, String cin, String genre, Date dateNaissance, String lieuNaissance, String nationalite, String emailInstitutionnel, String telephone, String adresse, String cne, String promotion) {
        {
            try {
                PreparedStatement ps;
                if (!MatriculeExiste(matricule)) {
                    //Default values when adding :
                    Etudiant etudiant = new Etudiant("-", "1", "-", "-", matricule, "-", new Date(), "-", "-", "-", "-", "-.-@student.emi.ac.ma", "-", "-");
                    ps = DBConnection.getConnection().prepareStatement("INSERT INTO etudiant (nom, prenom, cin, mot_de_passe, matricule, cne, genre, date_naissance, lieu_naissance, nationalite, promotion, `email institutionnel`, telephone, adresse) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    ps.setString(1, etudiant.getNom());
                    ps.setString(2, etudiant.getPrenom());
                    ps.setString(3, etudiant.getCin());
                    ps.setString(4, etudiant.getMotDePasse());
                    ps.setInt(5, etudiant.getMatricule());
                    ps.setString(6, etudiant.getCne());
                    ps.setString(7, etudiant.getGenre());
                    ps.setDate(8, new java.sql.Date(etudiant.getDateNaissance().getTime()));
                    ps.setString(9, etudiant.getLieuNaissance());
                    ps.setString(10, etudiant.getNationalite());
                    ps.setString(11, etudiant.getPromotion());
                    ps.setString(12, etudiant.getEmailInstitutionnel());
                    ps.setString(13, etudiant.getTelephone());
                    ps.setString(14, etudiant.getAdresse());
                    ps.executeUpdate();
                } else {
                    ps = DBConnection.getConnection().prepareStatement("UPDATE etudiant SET nom=?, prenom=? WHERE matricule=?");
                    Etudiant etudiant = new Etudiant("-", "1", "-", "-", matricule, "-", new Date(), "-", "-", "-", "-", "-.-@student.emi.ac.ma", "-", "-");
                    ps.setString(1, etudiant.getNom());
                    ps.setString(2, etudiant.getPrenom());
                    ps.setInt(3, etudiant.getMatricule());
                }
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

            public void delete ( int matricule){
                try {
                    PreparedStatement ps = connection.prepareStatement("DELETE FROM etudiant WHERE matricule=?");
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
                    if (rs.next()) {
                        etudiant = new Etudiant("-", "1", "-", "-", 0, "-", new Date(), "-", "-", "-", "-", "-.-@student.emi.ac.ma", "-", "-");
                        etudiant.setMatricule(rs.getInt("matricule"));
                        etudiant.setNom(rs.getString("nom"));
                        etudiant.setPrenom(rs.getString("prenom"));
                    }
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
                        Etudiant etudiant = new Etudiant("-", "1", "-", "-", 0, "-", new Date(), "-", "-", "-", "-", "-.-@student.emi.ac.ma", "-", "-");
                        etudiant.setMatricule(rs.getInt("matricule"));
                        etudiant.setNom(rs.getString("nom"));
                        etudiant.setPrenom(rs.getString("prenom"));
                        etudiants.add(etudiant);
                    }
                    rs.close();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return etudiants;
            }


        }
