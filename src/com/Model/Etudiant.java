package com.Model;

import java.util.Date;

public class Etudiant extends Personne{
    private String cne;
    private String promotion = "1A";

    public Etudiant(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, Date dateNaissance, String lieuNaissance, String nationalite, String emailInstitutionnel, String telephone, String adresse, String cne, String promotion) {
          super( nom,  motDePasse,  prenom,  cin,  matricule,  genre,  dateNaissance,  lieuNaissance,  nationalite,  emailInstitutionnel,  telephone,  adresse);
          this.cne = cne;
          this.promotion = promotion;
    }
    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
}
