/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;

import edu.pisprintjava.entities.Categorie;
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
public class ServiceCategorie implements ICService<Categorie>{
    
    Connection cnx =DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Categorie c) {
          try {
            String req = "INSERT INTO `categorie`(`nom_categorie`, `description`) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
          
            ps.setString(1,c.getNom_categorie());
            ps.setString(2,c.getDescription());
            ps.executeUpdate();
            System.out.println("Catégorie Created !! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
         try {
            String req="DELETE FROM `categorie` WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Catégorie deleted !! ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Categorie c) {
         try {
            String req = "UPDATE `categorie` SET `nom_categorie` = '" + c.getNom_categorie() + "', `description` = '" + c.getDescription() + "' WHERE `categorie`.`id` = " + c.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Catégorie updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Categorie> getAllCategories() {
        
     List<Categorie> list = new ArrayList<>();
        try {
            String req = "Select * from categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Categorie c = new Categorie(rs.getInt(1),  rs.getString("nom_categorie"), rs.getString("description"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}
