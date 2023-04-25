package com.Model2;

import java.util.ArrayList;

public class Admin extends Personne{
    private ArrayList<Etudiant> listEtudiants; // va se charger de la BD
    private ArrayList<Avis> listAvis; // va se charger de la BD
    private EmploiPromotion[] listEmploiPromotions = new EmploiPromotion[3]; // va se charger de la BD
    private ArrayList<EmploiProfesseur> listemploiProfesseurs; // va se charger de la BD
    private ArrayList<Document> listDocument; // va se charger de la BD


    public Admin(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, String dateNaissance, String lieuNaissance, String nationalite, String emailInstitutionnel, String telephone, String adresse) {
        super( nom,  motDePasse,  prenom,  cin,  matricule,  genre,  dateNaissance,  lieuNaissance,  nationalite,  telephone,  adresse);
    }



}
