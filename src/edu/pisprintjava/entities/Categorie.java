/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.entities;

import java.util.Objects;

/**
 *
 * @author Ahmed
 */
public class Categorie {
    
    private int id;
    private String nom_categorie,description;

    public Categorie() {
    }

    public Categorie(int id, String nom_categorie, String description) {
        this.id = id;
        this.nom_categorie = nom_categorie;
        this.description = description;
    }

    public Categorie(String nom_categorie, String description) {
        this.nom_categorie = nom_categorie;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nom_categorie);
        hash = 97 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Categorie{" + "nom_categorie=" + nom_categorie + ", description=" + description + '}';
    }
    
    
    
}
