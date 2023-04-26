package com.Model2;

import java.util.ArrayList;

public class ElementModule {
    private String module;
    private String nom;
    private Professeur professeur;





    //constructors
    public ElementModule(String nom, Professeur professeur){
        setNom(nom);
        setProfesseur(professeur);
    }

    public ElementModule() {

    }




    //setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public void setModule(String module) {
        this.module = module;
    }



    //getters

    public Professeur getProfesseur() {
        return professeur;
    }

    public String getNom() {
        return nom;
    }
    public String getModule() {
        return module;
    }
}

