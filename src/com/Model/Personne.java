package com.Model;

import java.util.Date;

public class Personne {
    protected String nom;
    protected String motDePasse;
    protected String prenom;
    protected String cin;
    protected int matricule;
    protected String genre;
    protected Date dateNaissance;
    protected String lieuNaissance;
    protected String nationalite = "marocaine";
    protected String emailInstitutionnel = "nom.prenom@student.emi.ac.ma";
    protected String telephone;
    protected String adresse;

    public Personne(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, Date dateNaissance, String lieuNaissance, String nationalite, String emailInstitutionnel, String telephone, String adresse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
        this.prenom = prenom;
        this.cin = cin;
        this.matricule = matricule;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.emailInstitutionnel = emailInstitutionnel;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getEmailInstitutionnel() {
        return emailInstitutionnel;
    }

    public void setEmailInstitutionnel(String emailInstitutionnel) {
        this.emailInstitutionnel = emailInstitutionnel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}