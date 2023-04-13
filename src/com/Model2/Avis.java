package com.Model2;

import java.util.Date;

public class Avis {
    private int idAvis;
    private String objet ;
    private String contenu;
    private Date dateAvis;
    private Admin admin;



    public Avis(int id_avis, String objet, String contenu, Date dateAvis, Admin admin){
        this.admin = admin;
        setIdAvis(id_avis);
        setDate_avis(dateAvis);
        setObjet(objet);
        setContenu(contenu);
    }



    //setters
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate_avis(Date dateAvis) {
        this.dateAvis= dateAvis;
    }

    public void setIdAvis(int id_avis) {
        this.idAvis= idAvis;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }





    //getters
    public int getIdAvis() {
        return idAvis;
    }
    public Date getDateAvis() {
        return dateAvis;
    }
    public String getObjet() {
        return objet;
    }
    public String getContenu() {
        return contenu;
    }
    public Admin getAdmin() {
        return admin;
    }
}
