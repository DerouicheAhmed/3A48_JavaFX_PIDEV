/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;

import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.utis.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public class ServiceProduit implements Iservice<Produit>{

    Connection cnx =DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Produit p) {
          try {
            String req = "INSERT INTO `produit`( `categories_id`, `designation`, `quantite`, `prix`, `nom`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,p.getCatégories_id().getId());
            ps.setString(5, p.getNom());
            ps.setString(2, p.getDesignation());
            ps.setFloat(4, p.getPrix());
            ps.setInt(3, p.getQuantite());
            ps.executeUpdate();
            System.out.println("Produit Created !! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req="DELETE FROM `produit` WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Produit deleted !! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

    @Override
    public void modifier(Produit p) {
         try {
            String req = "UPDATE `produit` SET `nom` = '" + p.getNom() + "', `designation` = '" + p.getDesignation() + "',`prix` = '" + p.getPrix() + "',`quantite` = '" + p.getQuantite() + "' WHERE `produit`.`id` = " + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Produit updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public List<Produit> getAll() {
     List<Produit> list = new ArrayList<>();
        try {
            String req = "Select * from produit";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Produit p = new Produit(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("designation"), rs.getInt(2));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}
