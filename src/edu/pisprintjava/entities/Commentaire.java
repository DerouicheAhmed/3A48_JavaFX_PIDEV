/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.entities;

/**
 *
 * @author houcein
 */
public class Commentaire {
    private int id;
    private String contenu;
    private int id_post,id_user;
    private int posts_id;
 public Commentaire() {
    }

    public Commentaire(int id, String contenu, int id_post, int id_user, int posts_id) {
        this.id = id;
        this.contenu=contenu;
        this.id_post = id_post;
        this.id_user = id_user;
        this.posts_id= posts_id;
    }

    public int getPosts_id() {
        return posts_id;
    }

    public void setPosts_id(int posts_id) {
        this.posts_id = posts_id;
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

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", contenu=" + contenu + ", id_post=" + id_post + ", id_user" + id_user + '}';
    }


}
