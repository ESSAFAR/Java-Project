package com.Model2;

public class Document {
    private Etudiant etudiant;
    private Admin admin;
    private String nom;
    private String contenu;



    public Document( Etudiant etudiant, Admin admin, String nom, String contenu){

    }



    //setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }




    //getters
    public String getNom() {
        return nom;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public String getContenu() {
        return contenu;
    }
}
