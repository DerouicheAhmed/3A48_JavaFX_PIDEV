/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.entities;

/**
 *
 * @author mahdi
 */
public class Participant {
    private int id;
    private String nom,prenom,numero_telephone;
    private int evenements_id,users_id;

    public Participant() {
    }

    public Participant(int id, String nom, String prenom, String numero_telephone, int evenements_id, int users_id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero_telephone = numero_telephone;
        this.evenements_id = evenements_id;
        this.users_id = users_id;
    }

    public Participant(String nom, String prenom, String numero_telephone, int evenements_id, int users_id) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero_telephone = numero_telephone;
        this.evenements_id = evenements_id;
        this.users_id = users_id;
    }

    public Participant(String nom, String prenom, String numero_telephone, int evenements_id) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero_telephone = numero_telephone;
        this.evenements_id = evenements_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public int getEvenements_id() {
        return evenements_id;
    }

    public void setEvenements_id(int evenements_id) {
        this.evenements_id = evenements_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Participant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numero_telephone=" + numero_telephone + ", evenements_id=" + evenements_id + '}';
    }
    
    
}
