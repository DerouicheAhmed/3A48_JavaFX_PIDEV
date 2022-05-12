/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;

import edu.pisprintjava.entities.Commentaire;
import edu.pisprintjava.entities.Post;

import edu.pisprintjava.IServices.Iservices;
import edu.pisprintjava.utis.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;


/**
 *
 * @author Houcein
 */
public class Commentaire_service implements Iservices<Commentaire> {
 private Connection c = MyConnexion.getInsCon().getcnx();
    @Override
    public void Ajouter(Commentaire u) throws SQLException {
    PreparedStatement ps;
    u.setId_user(1);
    u.setId_post(1);
    String query = "INSERT INTO `commentaire`( `id`,`contenu`, `id_post`,`id_user`,`posts_id`) VALUES ('"+u.getId()+"','"+u.getContenu()+"','"+u.getId_post()+"','"+u.getId_user()+"','"+u.getPosts_id()+"')";
    try {
                ps = c.prepareStatement(query);
                ps.execute();
                System.out.println(u);
             //AlertDialog.showNotification("ajout","avec succee", AlertDialog.image_checked);
            } catch (Exception e) {
                System.out.println(e);
            }
    }
    @Override
                public List<Commentaire> Affichertout() throws SQLException {
                List<Commentaire> list = new ArrayList();

                    String requete = "SELECT * FROM `commentaire` ";
                    try {
                        PreparedStatement ps = c.prepareStatement(requete);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                            Commentaire r = new Commentaire();
                           // list.add(new Evenement(rs.getString("destination"),rs.getString("description"),rs.getString("image"),rs.getInt("nbr_participants"),rs.getInt("nbr_participants_max"),rs.getInt("prix"),rs.getInt("etat"),rs.getInt("users_id")));
                        r.setId(rs.getInt(1));
                        r.setContenu(rs.getString(3));
                        r.setId_post(rs.getInt(2));
                        r.setId_user(rs.getInt(5));
                        list.add(r);

                        
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    return list;
                }
                     @Override
                         public void Supprimer(Commentaire p,int id) throws SQLException {
                            PreparedStatement ps;

                            String query = "  DELETE FROM `commentaire` WHERE `commentaire`.`id` ='"+id+"'";

                            try {
                                ps = c.prepareStatement(query);
                                ps.execute();
                                System.out.println("suppression ");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }


                         @Override
                      public void Modifier(Commentaire p, int id) {
                           PreparedStatement ps;
                            String query = "UPDATE `commentaire` SET `contenu`=?, `posts_id`=?,`id_user`=? WHERE `id`="+id;
                            try {
                                ps = c.prepareStatement(query);
                                ps.setString(1, p.getContenu());
                                ps.setInt(2, p.getPosts_id());
                                ps.setInt(3, p.getId_user());
                                ps.execute();
                            } catch (Exception e) {
                                System.out.println(e);
                            }

                        }
                    }
