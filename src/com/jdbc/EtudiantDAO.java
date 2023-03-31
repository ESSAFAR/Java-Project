package com.jdbc;

import com.GUI.AdminFrames.AcceuilAdmin;
import com.GUI.StudentFrame.AcceuilEtudiant;
import com.Model.Etudiant;
import com.mysql.cj.jdbc.PreparedStatementWrapper;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    private Connection connection = DBConnection.getConnection();

    //Teste si un eleve existe dans la BD
    public boolean existe(Etudiant etudiant) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM etudiants WHERE matricule = ?");
            ps.setString(1, "" + etudiant.getMatricule());
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
    public void modifierEtudiant(Etudiant etudiant) {
        try {
            PreparedStatement ps;
            if (etudiant.getMatricule() == 0) {
                ps = connection.prepareStatement("INSERT INTO etudiants (nom, prenom) VALUES (?, ?)");
                ps.setString(1, etudiant.getNom());
                ps.setString(2, etudiant.getPrenom());
            } else {
                // Update an existing record in the database.
                ps = connection.prepareStatement("UPDATE etudiants SET nom=?, prenom=? WHERE matricule=?");
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

    public void ajouterEtudiant(Etudiant etudiant) {
        modifierEtudiant(etudiant);
    }

    public void delete(int matricule) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM etudiants WHERE matricule=?");
            ps.setInt(1, matricule);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Etudiant getEtudiant(int matricule) {
        Etudiant etudiant = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM etudiants WHERE matricule=?");
            ps.setInt(1, matricule);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                etudiant = new Etudiant();
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

    public List<Etudiant> getListEtudiant() {
        List<Etudiant> etudiants = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM etudiants");
            while (rs.next()) {
                Etudiant etudiant = new Etudiant();
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
