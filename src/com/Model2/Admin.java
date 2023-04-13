package com.Model2;

import java.util.ArrayList;

public class Admin extends Personne{
    private ArrayList<Etudiant> listEtudiants;
    private ArrayList<Avis> listAvis;
    private EmploiPromotion[] listEmploiPromotions = new EmploiPromotion[3];
    private ArrayList<EmploiProfesseur> listemploiProfesseurs;
    private ArrayList<Document> listDocument;


    public Admin(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, String dateNaissance, String lieuNaissance, String nationalite, String emailInstitutionnel, String telephone, String adresse) {
        super(nom, motDePasse, prenom, cin, matricule, genre, dateNaissance, lieuNaissance, nationalite, emailInstitutionnel, telephone, adresse);
    }



}
