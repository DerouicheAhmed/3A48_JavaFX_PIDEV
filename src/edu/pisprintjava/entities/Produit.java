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
public class Produit {
    private int id,quantite;
    private String nom,designation,cat,image;
    private float prix;
    private Categorie catégories_id;

    public Produit(int id, int quantite, String nom, String designation, String cat, float prix, Categorie catégories_id) {
        this.id = id;
        this.quantite = quantite;
        this.nom = nom;
        this.designation = designation;
        this.cat = cat;
        this.prix = prix;
        this.catégories_id = catégories_id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Produit() {
    }

    public Produit(int id, int quantite, String nom, String designation, float prix) {
        this.id = id;
        this.quantite = quantite;
        this.nom = nom;
        this.designation = designation;
        this.prix = prix;
    }

    public Produit(int quantite, String nom, String designation, float prix) {
        this.quantite = quantite;
        this.nom = nom;
        this.designation = designation;
        this.prix = prix;
    }

    public Produit(int id, int quantite, String nom, String designation, float prix, Categorie catégories_id) {
        this.id = id;
        this.quantite = quantite;
        this.nom = nom;
        this.designation = designation;
        this.prix = prix;
        this.catégories_id = catégories_id;
    }

    public Produit(int id, int quantite, String nom, String designation, String cat, String image, float prix, Categorie catégories_id) {
        this.id = id;
        this.quantite = quantite;
        this.nom = nom;
        this.designation = designation;
        this.cat = cat;
        this.image = image;
        this.prix = prix;
        this.catégories_id = catégories_id;
    }

   
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCatégories_id() {
        return catégories_id;
    }

    
    public void setCatégories_id(Categorie catégories_id) {
        this.catégories_id = catégories_id;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", quantite=" + quantite + ", nom=" + nom + ", designation=" + designation + ", prix=" + prix + ", categories_id=" + catégories_id + '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    @Override
//    public int compareTo(Produit p) {
//        return nom.compareTo(p.getNom());
//    }

    
    
    
    
}
