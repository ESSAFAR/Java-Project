package com.Model2;

import java.util.Date;

public class Avis {
    public Avis(int id_avis, String objet , String contenu , Date date_avis ) {
        this.id_avis = id_avis;
        this.objet=objet;
        this.contenu=contenu;
        this.date_avis=date_avis;
    }

    private int id_avis;
    private String objet ;
    private String contenu;
    private Date date_avis;



    public int getId_avis() {
        return id_avis;
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate_avis() {
        return date_avis;
    }

    public void setDate_avis(Date date_avis) {
        this.date_avis = date_avis;
    }
}
