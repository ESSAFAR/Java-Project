package com.Model2;


import java.util.Date;

public class Document {
    private int id;
    private Etudiant etudiant;
    private Admin admin;
    private String objet;
    private String estUrgent;
    private boolean estTraite;
    private java.util.Date dateDemande;



    public Document( int id, Etudiant etudiant, String objet, String urgent, boolean etat, Date dateDemande){
        setId(id);
        setObjet(objet);
        setEtudiant(etudiant);
        setAdmin(admin);
        setEstUrgent(urgent);
        estTraite = false;
        setDateDemande(dateDemande);
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

    public String getEstUrgent() {
        return estUrgent;
    }


    public String estUrgent() {
        return estUrgent;
    }

    public void setEstUrgent(String estUrgent) {
        this.estUrgent = estUrgent;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }
}



