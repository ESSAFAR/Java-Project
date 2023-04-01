package com.Model;

public class ModuleSemestre {
    public ModuleSemestre(String id_module,String nom) {
        this.id_module = id_module;
        this.nom=nom;
    }

    private String id_module;
    private String nom;

    public String getId_module() {
        return id_module;
    }

    public void setId_module(String id_module) {
        this.id_module = id_module;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ModuleSemestre (String id_module, String nom) {
        setId_module(id_module);
        setNom(nom);

    }
}
