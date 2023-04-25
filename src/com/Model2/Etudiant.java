package com.Model2;

import java.util.ArrayList;
import java.util.Date;

public class Etudiant extends Personne{
    private String promotion;
    private ArrayList<Avis> listAvis; //  va se charger de la BD
    private EmploiPromotion emploi  ; // va se charger de la BD
    private ArrayList<ElementModule> listElementModule; // va se charger de la BD
    private ArrayList<Document> listDocument;
    private String cne;

    public Etudiant(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, String dateNaissance, String lieuNaissance, String nationalite, String telephone, String adresse, String cne) {
        super( nom,  motDePasse,  prenom,  cin,  matricule,  genre,  dateNaissance,  lieuNaissance,  nationalite,  telephone,  adresse);
        this.cne = cne;
    }
    public String getCne() {
        return cne;
    }

    // Cne doit être une lettre suivie de 9 chiffres
    public void setCne(String cne) {
        if(cne.matches("^[A-Za-z]\\d{9}$")) {
            this.cne = cne;
        } else {
            throw new IllegalArgumentException("Cne doit être une lettre suivie de 9 chiffres.");
        }
    }


    //setters
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
    public void setEmploi(EmploiPromotion emploi) {
        this.emploi = emploi;
    }



    //getters
    public String getPromotion() {
        return promotion;
    }

    
}
