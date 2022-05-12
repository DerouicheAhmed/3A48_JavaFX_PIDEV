/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;
import edu.pisprintjava.entities.Participant;
import edu.pisprintjava.IServices.Iservices;
import edu.pisprintjava.utis.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.pisprintjava.gui.AfficherevenementController;



/**
 *
 * @author mahdi
 */

public class Participant_service implements Iservices<Participant> {
    AfficherevenementController a= new AfficherevenementController();
       
    public int id_evenement_participant;
    
    private Connection c = MyConnexion.getInsCon().getcnx();
    @Override
    public void Ajouter(Participant u) throws SQLException {
       PreparedStatement ps;
       PreparedStatement pss;
        String query = "INSERT INTO `participant`( `evenements_id`,`nom`, `prenom`, `numero_telephone`) VALUES ('"+u.getEvenements_id()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getNumero_telephone()+"')";
         String queryy = "UPDATE `evenement` SET `nbr_participants` = `nbr_participants`+1 WHERE `evenement`.`id` ='"+AfficherevenementController.id_evenement_participant+"'";
        try {
            ps = c.prepareStatement(query);
            pss = c.prepareStatement(queryy);
            ps.execute(); 
            pss.execute();
            System.out.println(u);
         //AlertDialog.showNotification("ajout","avec succee", AlertDialog.image_checked);
        } catch (Exception e) { 
            System.out.println(e);
        }  



    }
    
    @Override
    public List<Participant> Affichertout() throws SQLException {
        
    List<Participant> list = new ArrayList();
        System.out.println(AfficherevenementController.id_evenement_participant);
    
        String requete = "SELECT * FROM `participant` WHERE `participant`.`evenements_id`='"+AfficherevenementController.id_evenement_participant+"'";
       
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            
            ResultSet rs = ps.executeQuery();
           

            while (rs.next()) {
                Participant r = new Participant();
               // list.add(new Evenement(rs.getString("destination"),rs.getString("description"),rs.getString("image"),rs.getInt("nbr_participants"),rs.getInt("nbr_participants_max"),rs.getInt("prix"),rs.getInt("etat"),rs.getInt("users_id")));
            r.setId(rs.getInt(1));
            r.setEvenements_id(rs.getInt(2));
            r.setNom(rs.getString(4));
            r.setPrenom(rs.getString(5));
            r.setNumero_telephone(rs.getString(6));
            list.add(r);
           
           
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    
    }
    
    
    @Override
     public void Supprimer(Participant p,int id) throws SQLException {
        PreparedStatement ps;

        String query = "  DELETE FROM `participant` WHERE `participant`.`id` ='"+id+"'";
  
        try {
            ps = c.prepareStatement(query);
            ps.execute();
            System.out.println("suppression ");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
     
     
     @Override
  public void Modifier(Participant p, int id) {
       PreparedStatement ps;
        String query = "UPDATE `participant` SET `nom`=?,`prenom`=?,`numero_telephone`=? WHERE `id`="+id;
        try {
            ps = c.prepareStatement(query);
           
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getNumero_telephone());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
}
