package com.Model2;
import com.RegularExpressions.RegEx;

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
        setNom(nom);
        setMotDePasse(motDePasse);
        setPrenom(prenom);
        setCin(cin);
        setMatricule(matricule);
        setGenre(genre);
        setDateNaissance(dateNaissance);
        setLieuNaissance(lieuNaissance);
        setNationalite(nationalite);
        this.emailInstitutionnel= (nom+ "." +prenom+matricule+"@student.emi.ac.ma");
        setTelephone(telephone);
        setAdresse(adresse);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(RegEx.matchesNameFormat(nom)){
            this.nom = nom;
        }
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
        if(RegEx.matchesNameFormat(prenom)){
            this.prenom = prenom;
        }
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

    //Genre doit être 'male' ou 'female'
    public void setGenre(String genre) {
        genre = genre.toUpperCase();
        if(genre.equals("M") || genre.equals("F")) {
            this.genre = genre;
        }
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        if (RegEx.matchesDateFormat(dateNaissance)){
            this.dateNaissance = dateNaissance;
        }
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

    public String getTelephone() {
        return telephone;
    }


    //Numéro de téléphone doit contenir 10 chiffres
    public void setTelephone(String telephone) {
           if(RegEx.matchesTelephone(telephone)){
               this.telephone = telephone;
        }
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
