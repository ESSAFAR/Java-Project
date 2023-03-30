package com.Model;

import java.util.Date;

public class Etudiant extends Personne{
    private String cne;
    private String promotion = "1A";

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
