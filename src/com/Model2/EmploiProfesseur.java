package com.Model2;

public class EmploiProfesseur {
    private Professeur professeur;
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


    public EmploiProfesseur(Professeur professeur, EmploiJour[] emploi){
        setProfesseur(professeur);
        setEmploi(emploi);
    }



    //setters

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public void setEmploi(EmploiJour[] emploi) {
        this.emploi = emploi;
    }



    //getters

    public Professeur getProfesseur() {
        return professeur;
    }

    public EmploiJour[] getEmploi() {
        return emploi;
    }
}


