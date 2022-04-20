/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Evenement;

import IServices.Iservices;
import Utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author mahdi
 */
public class Evenement_service implements Iservices<Evenement> {
    
    private Connection c = MyConnexion.getInsCon().getcnx();
    @Override
    public void Ajouter(Evenement u) throws SQLException {
       PreparedStatement ps;
        
   // private int id;
   // private String description,image,destination;
   // private Date date;
   // private int prix,nbr_participants,nbr_participants_max,etat;
        String query = "INSERT INTO `evenement`( `destination`,`description`, `image`, `nbr_participants`, `nbr_participants_max`,`prix`, `etat`, `date`) VALUES ('"+u.getDestination()+"','"+u.getDescription()+"','"+u.getImage()+"','"+u.getNbr_participants()+"','"+u.getNbr_participants_max()+"','"+u.getPrix()+"','"+u.getEtat()+"','"+u.getDate()+"')";
        try {
            ps = c.prepareStatement(query);

           /*  ps.setString(1, u.getNom_produit());
          ps.setInt(1, u.getPrix_produit());
          ps.setString(2, u.getImage_produit());
          ps.setInt(3, u.getQuantite_produit());
          ps.setInt(4, u.getID_categorie());*/
            ps.execute();    
            System.out.println(u);
         //AlertDialog.showNotification("ajout","avec succee", AlertDialog.image_checked);
        } catch (Exception e) { 
            System.out.println(e);
        }  



    }
    
    @Override
    public List<Evenement> Affichertout() throws SQLException {
    List<Evenement> list = new ArrayList();
    
        String requete = "SELECT * FROM `evenement`";
        try {
            PreparedStatement ps = c.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Evenement r = new Evenement();
               // list.add(new Evenement(rs.getString("destination"),rs.getString("description"),rs.getString("image"),rs.getInt("nbr_participants"),rs.getInt("nbr_participants_max"),rs.getInt("prix"),rs.getInt("etat"),rs.getInt("users_id")));
            r.setId(rs.getInt(1));
            r.setDestination(rs.getString(6));
            r.setDescription(rs.getString(3));
            r.setNbr_participants_max(rs.getInt(9));
            r.setPrix(rs.getInt(7));
            r.setDate(rs.getDate(5));
            
            list.add(r);
           // Evenement.add(r);
           
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    
    }
    
    
    @Override
     public void Supprimer(Evenement p,int id) throws SQLException {
        PreparedStatement ps;

        String query = "  DELETE FROM `evenement` WHERE `evenement`.`id` ='"+id+"'";;
        
  
        try {
            ps = c.prepareStatement(query);

//            ps.setInt(1,p.getEtat());
            //ps.setInt(2,r.getId());
            ps.execute();

            System.out.println("suppression ");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
     
     
     @Override
  public void Modifier(Evenement p, int id) {
       PreparedStatement ps;
        String query = "UPDATE `evenement` SET `destination`=?,`description`=?,`nbr_participants_max`=?,`prix`=?,`date`=? WHERE `id`="+id;
        try {
            
            ps = c.prepareStatement(query);
         
            ps.setString(1, p.getDestination());
            ps.setString(2, p.getDescription());
            
            ps.setInt(3, p.getNbr_participants_max());
            ps.setInt(4, p.getPrix());
            
             Date date = new Date();
             date=p.getDate();

             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
            ps.setDate(5, date1);
           
                
            
            
            ps.execute();
   

        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
}
