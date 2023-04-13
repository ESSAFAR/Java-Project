package com.Model2;

public class EmploiPromotion {
    private String promotion;
    private EmploiJour[] emploi = new EmploiJour[7];



    public class EmploiJour{
        private String jour;
        private Cours[] listCours = new Cours[]{null, null, null, null};
        public EmploiJour(String jour,Cours[] listCours){
            this.jour = jour;
            setListCours(listCours);
        }
        public void setListCours(Cours[] listCours) {
            this.listCours = listCours;
        }
    }


    public EmploiPromotion(String promotion, EmploiJour[] emploi){
        setPromotion(promotion);
        setEmploi(emploi);
    }



    //setters
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
    public void setEmploi(EmploiJour[] emploi) {
        this.emploi = emploi;
    }



    //getters
    public String getPromotion() {
        return promotion;
    }
    public EmploiJour[] getEmploi() {
        return emploi;
    }
}
