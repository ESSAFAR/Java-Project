package com.Model2;

import java.util.ArrayList;

public class ElementModule {
    private String module;
    private String nom;
    private ArrayList<Professeur> listProfesseurs;
    private ArrayList<Etudiant> listEtudiants;




    //constructors
    public ElementModule(String nom, ArrayList<Professeur> listProfesseurs, ArrayList<Etudiant> listEtudiants){
        setNom(nom);
        setListEtudiants(listEtudiants);
        setListProfesseurs(listProfesseurs);
    }

    public ElementModule() {

    }




    //setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setListEtudiants(ArrayList<Etudiant> listEtudiants) {
        this.listEtudiants = listEtudiants;
    }
    public void setListProfesseurs(ArrayList<Professeur> listProfesseurs) {
        this.listProfesseurs = listProfesseurs;
    }
    public void setModule(String module) {
        this.module = module;
    }
}

