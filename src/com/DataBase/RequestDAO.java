package com.DataBase;

import com.Model2.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {
    private static Connection connection = DBConnection.getConnection();

    public static void addDemande(int id_demande, int objet, int id_etudiant, String etat, Date date_demande) {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("INSERT INTO demandedocument(id, objet, id_etudiant, etat, date_demande) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, id_demande);
            ps.setInt(2, objet);
            ps.setInt(3, id_etudiant);
            ps.setString(4, etat);
            ps.setDate(5, date_demande);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDemande(int id_demande, String objet, int id_etudiant, boolean etat, Date date_demande) {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("UPDATE demandedocument SET objet = ?, id_etudiant = ?, etat = ?, date_demande = ? WHERE id = ?");
            ps.setString(1, objet);
            ps.setInt(2, id_etudiant);
            ps.setString(3, etat?"traite":"nonTraite");
            ps.setDate(4, date_demande);
            ps.setInt(5, id_demande);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDemande(int id) {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("DELETE FROM demandedocument WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Document getRequest (int id){
        Document demande = null;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM demandedocument WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                demande = new Document(
                        id,
                        EtudiantDAO.getEtudiant(Integer.parseInt(rs.getString("id_etudiant"))),
                        rs.getString("objet"),
                        Boolean.parseBoolean(rs.getString("etat")));
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return demande;
    }

    public static List<Document> getListRequest() {
        List<Document> requests = new ArrayList<>();
        try {
            Statement stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM demandedocument");
            while (rs.next()) {
                Document request = RequestDAO.getRequest(rs.getInt("id"));
                requests.add(request);            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }


    public static void traiterDemande(int id) {
        Document document = getRequest(id);
        updateDemande(document.getId(),document.getObjet(),document.getEtudiant().getMatricule(),document.isEstTraite(),document.getDateDemande());
    }
    public static int generateId(){
        int id=0;
        while (idExiste(id)){
            id++;
        }
        return id;
    }
    public static boolean idExiste(int id) {
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM demandedocument WHERE id = ?");
            ps.setString(1, "" + id);
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
}
