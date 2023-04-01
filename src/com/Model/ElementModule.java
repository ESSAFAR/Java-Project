package com.Model;

public class ElementModule {
    private String id_element;
    private String nom;
    private String id_module;

    public ElementModule(String id_element, String nom, String id_module) {
        setId_element(id_element);
        setNom(nom);
        setId_module(id_element);
    }

    public String getId_element() {
        return id_element;
    }

    public void setId_element(String id_element) {
        this.id_element = id_element;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId_module() {
        return id_module;
    }

    public void setId_module(String id_module) {
        this.id_module = id_module;
    }
}
