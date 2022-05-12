/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.entities;

/**
 *
 * @author Boughnimi
 */
public class User {
    private int id;
    private String nom, prenom;
    private String email;
    private String password;
    private String numerotelephone;
    private String role;
    
    public User() {
    }
    public User( String nom, String prenom, String email, String password , String numerotelephone,String role){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.password=password;
        this.numerotelephone=numerotelephone;
        this.role=role;
    }
    public User(int id , String nom, String prenom, String email, String password , String numerotelephone,String role){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.password=password;
        this.numerotelephone=numerotelephone;
        this.role=role;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the numerotelephone
     */
    public String getNumerotelephone() {
        return numerotelephone;
    }

    /**
     * @param numerotelephone the numerotelephone to set
     */
    public void setNumerotelephone(String numerotelephone) {
        this.numerotelephone = numerotelephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return "User{" + "nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", numerotelephone=" + numerotelephone + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;   
}
    
    
    
    
    
}
