package com.DataBase;

import com.Model2.Avis;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvisDAO {
    private static Connection connection = DBConnection.getConnection();
    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Teste si un avis existe dans la BD
    public static boolean idExiste(int id_avis) {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM avis WHERE id_avis = ?");
            ps.setString(1, "" + id_avis);
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
    public static void updateAvis(int id_avis, String objet, String contenu) {
        try {
            PreparedStatement ps = null;
            if (!idExiste(id_avis)) {
                ps = DBConnection.getConnection().prepareStatement("INSERT INTO avis (id_avis,objet,contenu,date_creation) VALUES (?,?,?,sysdate)");
                ps.setInt(1, id_avis);
                ps.setString(2, objet);
                ps.setString(3, contenu);
            } else {
                ps = DBConnection.getConnection().prepareStatement("UPDATE avis SET objet=?,contenu=? WHERE id_avis=?");
                ps.setString(1, objet);
                ps.setString(2, contenu);
                ps.setInt(3, id_avis);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // supprimer avis
    public static void deleteAvis ( int id_avis){
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("DELETE FROM avis WHERE id_avis=?");
            ps.setInt(1, id_avis);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Avis getAvis (int id_avis){

        Avis avis = null ;

        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM avis WHERE id_avis=?");
            ps.setInt(1, id_avis);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avis = new Avis(id_avis,
                       rs.getString("objet"),
                       rs.getString("contenu"),
                        rs.getDate("date_creation")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avis;
    }
    public static List<Avis> getListAvis () {
        List<Avis> aviss = new ArrayList<>();
        try {
            Statement stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM avis");
            while (rs.next()) {
                Avis avis = AvisDAO.getAvis(rs.getInt("id_avis"));
                aviss.add(avis);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aviss;
    }
    public static int getCount() {
        int count = 0;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) FROM avis";
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
    //generate a non existing matricule
    public static int generateidAvis(){
        int id_avis=0;
        while (idExiste(id_avis)){
            id_avis++;
        }
        return id_avis;
    }


}
