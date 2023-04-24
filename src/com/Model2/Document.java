package com.Model2;

import java.sql.Date;

public class Document {
    private int id;
    private Etudiant etudiant;
    private Admin admin;
    private String objet;
    private boolean estUrgent;
    private boolean estTraite;
    private Date dateDemande;



    public Document( int id, Etudiant etudiant, String objet, boolean urgent){
        setId(id);
        setObjet(objet);
        setEtudiant(etudiant);
        setAdmin(admin);
        setEstUrgent(urgent);
        estTraite = false;
    }



    //setters

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstTraite() {
        return estTraite;
    }

    public void setEstTraite(boolean estTraite) {
        this.estTraite = estTraite;
    }

    public int getId() {
        return id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public boolean isEstUrgent() {
        return estUrgent;
    }


    public boolean estUrgent() {
        return estUrgent;
    }

    public void setEstUrgent(boolean estUrgent) {
        this.estUrgent = estUrgent;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }
}



