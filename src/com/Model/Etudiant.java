package com.Model;

public class Etudiant extends Personne{
    private String cne;
    private String promotion;

    public Etudiant(String nom, String motDePasse, String prenom, String cin, int matricule, String genre, String dateNaissance, String lieuNaissance, String nationalite, String telephone, String adresse, String cne, String promotion) {
          super( nom,  motDePasse,  prenom,  cin,  matricule,  genre,  dateNaissance,  lieuNaissance,  nationalite,  telephone,  adresse);
          setCne(cne);
          setPromotion(promotion);
    }

    private void setPromotion(String promotion) {
        promotion = promotion.toUpperCase();
        if (promotion.equals("1A") || promotion.equals("2A") || promotion.equals("3A")) {
            this.promotion = promotion;
        }
    }

    public String getPromotion() {
        return promotion;
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







}
