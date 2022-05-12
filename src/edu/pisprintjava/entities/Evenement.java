/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mahdi
 */

public class Evenement {
     private int id;
    private String description,image,destination;
    private Date date;
    private int prix,nbr_participants,nbr_participants_max,etat,users_id;

    public Evenement() {
    }

    public Evenement(int id, String description, String image, String destination, Date date, int prix, int nbr_participants, int nbr_participants_max, int etat,int users_id) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.destination = destination;
        this.date = date;
        this.prix = prix;
        this.nbr_participants = nbr_participants;
        this.nbr_participants_max = nbr_participants_max;
        this.etat = etat;
        this.users_id = users_id;
    }

    public Evenement(String description, String image, String destination, Date date, int prix, int nbr_participants, int nbr_participants_max, int etat) {
        this.description = description;
        this.image = image;
        this.destination = destination;
        this.date = date;
        this.prix = prix;
        this.nbr_participants = nbr_participants;
        this.nbr_participants_max = nbr_participants_max;
        this.etat = etat;
    }

    public Evenement( String description, String image, String destination, int prix, int nbr_participants, int nbr_participants_max, int etat,int users_id) {
        
        this.description = description;
        this.image = image;
        this.destination = destination;
        this.prix = prix;
        this.nbr_participants = nbr_participants;
        this.nbr_participants_max = nbr_participants_max;
        this.etat = etat;
        this.users_id = users_id;
    }

    public Evenement(int id) {
        this.id = id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNbr_participants() {
        return nbr_participants;
    }

    public void setNbr_participants(int nbr_participants) {
        this.nbr_participants = nbr_participants;
    }

    public int getNbr_participants_max() {
        return nbr_participants_max;
    }

    public void setNbr_participants_max(int nbr_participants_max) {
        this.nbr_participants_max = nbr_participants_max;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    public String DateToString(){
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
    return formatter1.format(date);
    }
    @Override
    public String toString() {
        return "Evenement: " + "ID=" + id + ", destination=" + destination +  ", date=" + date + ", description=" + description + ", prix=" + prix + ", nombre de participants=" + nbr_participants + "/" + nbr_participants_max + "UtilisateurID=" + users_id + '.';
    }

 
    



}
