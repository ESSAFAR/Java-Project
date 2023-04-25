package com.Model2;
import javax.swing.*;
import java.util.Date;

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

    public Personne(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, String dateNaissance, String lieuNaissance, String nationalite, String telephone, String adresse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
        this.prenom = prenom;
        this.cin = cin;
        this.matricule = matricule;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.emailInstitutionnel = nom+ "." +prenom+matricule+"@student.emi.ac.ma" ;
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


    //Cin doit etre sous format (LLXXXX) 2 lettres suivi de 4 chiffres
    public void setCin(String cin) {
        if (cin.matches("^[a-zA-Z]{2}\\d{4}")) {
            this.cin = cin;
        } else {
//            System.out.println("Invalid Cin format. Cin doit etre sous format (LLXXXX) 2 lettres suivi de 4 chiffres");
            this.cin = cin;

        }
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

    //Genre doit être 'male' ou 'female'
    public void setGenre(String genre) {
        if(genre.equalsIgnoreCase("M") || genre.equalsIgnoreCase("F")) {
            this.genre = genre;
        } else {
            this.genre = genre;
        }
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
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


    //Numéro de téléphone doit contenir 10 chiffres
    public void setTelephone(String telephone) {
        if(telephone.matches("^\\d{10}$")) {
            this.telephone = telephone;
        } else {
            throw new IllegalArgumentException("Numéro de téléphone doit contenir 10 chiffres.");
        }
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
