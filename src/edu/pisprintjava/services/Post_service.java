/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;
import edu.pisprintjava.entities.Post;
import edu.pisprintjava.IServices.Iservices;
import edu.pisprintjava.utis.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author houcein
 */
public class Post_service implements Iservices<Post> {
 private Connection c = MyConnexion.getInsCon().getcnx();
    @Override
    public void Ajouter(Post u) throws SQLException {
    PreparedStatement ps;
    String query = "INSERT INTO `post`( `id`,`contenu`, `image`,`titre`, `id_user`) VALUES ('"+u.getId()+"','"+u.getContenu()+"','"+u.getImage()+"','"+u.getTitre()+"','"+u.getId_user()+"')";
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
                public List<Post> Affichertout() throws SQLException {
                List<Post> list = new ArrayList();

                    String requete = "SELECT * FROM `post` WHERE etat=1";
                    try {
                        PreparedStatement ps = c.prepareStatement(requete);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                            Post r = new Post();
                           // list.add(new Evenement(rs.getString("destination"),rs.getString("description"),rs.getString("image"),rs.getInt("nbr_participants"),rs.getInt("nbr_participants_max"),rs.getInt("prix"),rs.getInt("etat"),rs.getInt("users_id")));
                        r.setId(rs.getInt(1));
                        r.setContenu(rs.getString(3));
                        r.setImage(rs.getString(4));
                        r.setNbr_reaction(rs.getInt(5));
                        r.setNbr_commentaire(rs.getInt(6));
                        r.setEtat(rs.getInt(7));
                        r.setTitre(rs.getString(8));
                        list.add(r);


                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    return list;
                }
                public List<Post> AffichertoutBack() throws SQLException {
                List<Post> list = new ArrayList();

                    String requete = "SELECT * FROM `post` WHERE etat=0";
                    try {
                        PreparedStatement ps = c.prepareStatement(requete);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                            Post r = new Post();
                           // list.add(new Evenement(rs.getString("destination"),rs.getString("description"),rs.getString("image"),rs.getInt("nbr_participants"),rs.getInt("nbr_participants_max"),rs.getInt("prix"),rs.getInt("etat"),rs.getInt("users_id")));
                        r.setId(rs.getInt(1));
                        r.setContenu(rs.getString(3));
                        r.setImage(rs.getString(4));
                        r.setNbr_reaction(rs.getInt(5));
                        r.setNbr_commentaire(rs.getInt(6));
                        r.setEtat(rs.getInt(7));
                        r.setTitre(rs.getString(8));
                        list.add(r);


                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    return list;
                }
                     @Override
                         public void Supprimer(Post p,int id) throws SQLException {
                            PreparedStatement ps;
                            String query = "  UPDATE post SET `etat`=0 WHERE `post`.`id` ='"+id+"'";
//                            String query = "  DELETE FROM `post` WHERE `post`.`id` ='"+id+"'";

                            try {
                                ps = c.prepareStatement(query);
                                ps.execute();
                                System.out.println("suppression ");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }

    
                         @Override
                      public void Modifier(Post p, int id) {
                           PreparedStatement ps;
                          
                            String query = "UPDATE `post` SET `contenu`=?, `image`=?,`titre`=?, `nbr_reaction`=?,`nbr-commentaire`=?, `etat`=? WHERE `id`="+id;
                            try {
                                ps = c.prepareStatement(query);
                                ps.setString(1, p.getContenu());
                                ps.setString(2, p.getImage());
                                ps.setString(3, p.getTitre());
                                ps.setInt(4, p.getNbr_reaction());
                                ps.setInt(5, p.getNbr_commentaire());
                                ps.setInt(6, p.getEtat());
                                ps.execute();
                            } catch (Exception e) {
                                System.out.println(e);
                            }}
                            
                      public void Accepter(Post p) throws SQLException {
                            PreparedStatement ps;
                             String query = "UPDATE `post` SET `etat`=1 WHERE `post`.`id` ='"+p.getId()+"'";
                            try {
                             ps = c.prepareStatement(query);
                             ps.execute();    
           

                             } catch (SQLException e) { 
                              System.out.println(e);
                             }  

                        }
                      public void Decliner(Post p) throws SQLException {
                            PreparedStatement ps;
                             String query = "UPDATE `post` SET `etat`=2 WHERE `post`.`id` ='"+p.getId()+"'";
                            try {
                             ps = c.prepareStatement(query);
                             ps.execute();    
           

                             } catch (SQLException e) { 
                              System.out.println(e);
                             }  

                        }
                    }
