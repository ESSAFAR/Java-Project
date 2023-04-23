package com.Model2;

import java.util.ArrayList;

public class Professeur extends Personne{
    private EmploiProfesseur emploiProfesseur; //va se charger de la BD
    private ArrayList<Avis> listAvis; // va se charger de la BD
    private ArrayList<ElementModule> listElementModule;

    public Professeur(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, String dateNaissance, String lieuNaissance, String nationalite, String emailInstitutionnel, String telephone, String adresse) {
        super(nom, motDePasse, prenom, cin, matricule, genre, dateNaissance, lieuNaissance, nationalite, emailInstitutionnel, telephone, adresse);
    }

    public Professeur() {
        super();
    }
}
