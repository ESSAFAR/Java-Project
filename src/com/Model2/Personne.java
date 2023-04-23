package com.Model2;

public class Personne {
    protected String nom;
    protected String motDePasse;
    protected String prenom;
    protected String cin;
    protected int matricule;
    protected String genre;
    protected String dateNaissance;
    protected String lieuNaissance;
    protected String nationalite = "marocaine";
    protected String emailInstitutionnel = "nom.prenom@student.emi.ac.ma";
    protected String telephone;
    protected String adresse;
    public Personne( String nom, String motDePasse, String prenom, String cin, int matricule, String genre, String dateNaissance, String lieuNaissance, String nationalite , String emailInstitutionnel , String telephone, String adresse){
        setNom(nom);
        setPrenom(prenom);
        setCin(cin);
        setMatricule(matricule);
        setGenre(genre);
        setDateNaissance(dateNaissance);
        setLieuNaissance(lieuNaissance);
        setNationalite(nationalite);
        setEmailInstitutionnel(emailInstitutionnel);
        setTelephone(telephone);
        setAdresse(adresse);
    }

    public Personne() {

    }


    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setEmailInstitutionnel(String emailInstitutionnel) {
        this.emailInstitutionnel = emailInstitutionnel;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
