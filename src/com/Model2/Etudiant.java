package com.Model2;

import java.util.ArrayList;
import java.util.Date;

public class Etudiant extends Personne{
    private String promotion;
    private ArrayList<Avis> listAvis; //  va se charger de la BD
    private EmploiPromotion emploi  ; // va se charger de la BD
    private ArrayList<ElementModule> listElementModule; // va se charger de la BD
    private ArrayList<Document> listDocument;


    public Etudiant(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, String dateNaissance, String lieuNaissance, String nationalite, String emailInstitutionnel, String telephone, String adresse, String promotion,EmploiPromotion emploi) {
        super(nom, motDePasse, prenom, cin, matricule, genre, dateNaissance, lieuNaissance, nationalite, emailInstitutionnel, telephone, adresse);
        setPromotion(promotion);
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
