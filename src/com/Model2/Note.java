package com.Model2;

import java.security.PrivateKey;

public class Note {
    private Etudiant etudiant;
    private ElementModule elementModule;
    private Professeur professeur ;
    private double note;
    private TypeNote typeNote;
    public enum TypeNote{ NORMALE,RATRAPPAGE }



    public Note(Etudiant etudiant,ElementModule elementModule,Professeur professeur,double note,TypeNote typeNote){
        setEtudiant(etudiant);
        setProfesseur(professeur);
        setNote(note);
        setElementModule(elementModule);
        setTypeNote(typeNote);
    }



    //setters
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public void setElementModule(ElementModule elementModule) {
        this.elementModule = elementModule;
    }
    public void setNote(double note) {
        this.note = note;
    }
    public void setTypeNote(TypeNote typeNote) {
        this.typeNote = typeNote;
    }



    //getters
    public Etudiant getEtudiant() {
        return etudiant;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public double getNote() {
        return note;
    }
    public ElementModule getElementModule() {
        return elementModule;
    }
    public TypeNote getTypeNote() {
        return typeNote;
    }
}
