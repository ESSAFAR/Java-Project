package com.Model2;

import java.security.PrivateKey;

public class Note {
    private Etudiant etudiant;
    private ElementModule elementModule;
    private Professeur professeur ;
    private double valeur;
    private TypeNote typeNote;
    public enum TypeNote{ NORMALE,RATRAPPAGE }
}
