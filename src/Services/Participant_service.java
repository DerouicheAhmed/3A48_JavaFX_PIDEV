/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Participant;
import IServices.Iservices;
import Utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mahdi
 */
public class Participant_service implements Iservices<Participant> {
    
    private Connection c = MyConnexion.getInsCon().getcnx();
    @Override
    public void Ajouter(Participant u) throws SQLException {
       PreparedStatement ps;
        String query = "INSERT INTO `participant`( `evenements_id`,`nom`, `prenom`, `numero_telephone`) VALUES ('"+u.getEvenements_id()+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getNumero_telephone()+"')";
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
    public List<Participant> Affichertout() throws SQLException {
    List<Participant> list = new ArrayList();
    
        String requete = "SELECT * FROM `participant` ";
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
        String query = "UPDATE `participant` SET `evenements_id`=?,`nom`=?,`prenom`=?,`numero_telephone`=? WHERE `id`="+id;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, p.getEvenements_id());
            ps.setString(2, p.getNom());
            ps.setString(3, p.getPrenom());
            ps.setString(4, p.getNumero_telephone());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
}
