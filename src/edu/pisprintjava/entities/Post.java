/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.entities;

import javafx.scene.image.ImageView;

/**
 *
 * @author houcein
 */
public class Post {
    private int id;
    private String contenu,image,titre;
    private int nbr_reaction,nbr_commentaire,etat,id_user;

    public Post(String contenu, String image, String titre, int id_user) {
        this.contenu = contenu;
        this.image = image;
        this.titre = titre;
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
 public Post() {
    }

    public Post(int id, String contenu, String image, String titre, int nbr_reaction, int nbr_commentaire, int etat) {
        this.id = id;
        this.contenu = contenu;
        this.image = image;
        this.titre = titre;
        this.nbr_reaction = nbr_reaction;
        this.nbr_commentaire = nbr_commentaire;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbr_reaction() {
        return nbr_reaction;
    }

    public void setNbr_reaction(int nbr_reaction) {
        this.nbr_reaction = nbr_reaction;
    }

    public int getNbr_commentaire() {
        return nbr_commentaire;
    }

    public void setNbr_commentaire(int nbr_commentaire) {
        this.nbr_commentaire = nbr_commentaire;
    }

    public int getEtat() {
            return etat;
        }

        public void setEtat(int etat) {
            this.etat = etat;
        }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", contenu=" + contenu + ", image=" + image + ", titre=" + titre + ", nbr_reaction=" + nbr_reaction + ", nbr_commentaire" + nbr_commentaire + ",etat" + etat + '}';
    }

    public void setImage(ImageView id_image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
