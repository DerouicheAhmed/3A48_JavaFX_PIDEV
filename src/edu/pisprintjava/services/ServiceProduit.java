/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.services;

import edu.pisprintjava.entities.Categorie;
import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.utis.DataSource;
import java.sql.Array;
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
//public class ServiceProduit implements Iservice<Produit>{
//
//    Connection cnx =DataSource.getInstance().getCnx();
//    @Override
//    public void ajouter(Produit p) {
//          try {
//              p.setCat("tente");
//              String cat=p.getCatégories_id().getNom_categorie();
//            String req = "INSERT INTO `produit`( `categories_id`, `designation`, `quantite`, `prix`, `nom`,`cat`) VALUES (?,?,?,?,?,'"+cat+"')";
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setInt(1,p.getCatégories_id().getId());
//            ps.setString(5, p.getNom());
//            ps.setString(2, p.getDesignation());
//            ps.setFloat(4, p.getPrix());
//            ps.setInt(3, p.getQuantite());
//            ps.executeUpdate();
//            System.out.println("Produit Created !! ");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        
//    }
//
//    @Override
//    public void supprimer(int id) {
//        try {
//            String req="DELETE FROM `produit` WHERE id="+id;
//            Statement st=cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("Produit deleted !! ");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        
//    }
//    
//
//    @Override
//    public void modifier(Produit p) {
//         try {
//            String req = "UPDATE `produit` SET `nom` = '" + p.getNom() + "', `designation` = '" + p.getDesignation() + "',`prix` = '" + p.getPrix() + "',`quantite` = '" + p.getQuantite() + "' WHERE `produit`.`id` = " + p.getId();
//            Statement st = cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("Produit updated !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//    }
//    public Categorie affichercat(int id) {
//        //Categorie c=new Categorie(1, "aa", "bb");
//         try {
//        String req = "SELECT * FROM categorie WHERE id="+id;
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//          while(rs.next()){
//               Categorie cc = new Categorie(rs.getInt(1), rs.getString("nom_categorie"), rs.getString("description"));
//                return cc;
//            }
//                } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//       return null; 
//    }
//    public int findcatbynom(String nom) {
//        
//         try {
//        String req = "SELECT * FROM categorie WHERE nom_categorie LIKE '"+nom+"'";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//          while(rs.next()){
//               Categorie cc = new Categorie(rs.getInt(1), rs.getString("nom_categorie"), rs.getString("description"));
//                return cc.getId();
//            }
//                } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//       return 0; 
//    }
//
//    @Override
//    public List<Produit> getAll() {
//     List<Produit> list = new ArrayList<>();
//        try {
//            String req = "Select * from produit";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while(rs.next()){
//               // Produit p = new Produit(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("designation"), rs.getInt(2));
//               Categorie c=new Categorie();
//               c.setId(rs.getInt(2));
//               c.setNom_categorie("aaaaaa");
//               int id_cat=rs.getInt(2);
//               //Categorie aa=affichercat(id_cat);
//                //System.out.println(aa);
//               Produit p = new Produit(rs.getInt(1),rs.getInt(4), rs.getString("nom"), rs.getString("designation"),rs.getString("cat"),rs.getInt(5),affichercat(id_cat));
//                list.add(p);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return list;
//    }
//    
//}
public class ServiceProduit implements Iservice<Produit>{

    Connection cnx =DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Produit p) {
          try {
              p.setCat("tente");
              String cat=p.getCatégories_id().getNom_categorie();
            String req = "INSERT INTO `produit`( `categories_id`, `designation`, `quantite`, `prix`, `nom`,`image`,`cat`) VALUES (?,?,?,?,?,?,'"+cat+"')";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,p.getCatégories_id().getId());
            ps.setString(5, p.getNom());
            ps.setString(2, p.getDesignation());
            ps.setFloat(4, p.getPrix());
            ps.setInt(3, p.getQuantite());
            ps.setString(6, p.getImage());
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
    public Categorie affichercat(int id) {
        //Categorie c=new Categorie(1, "aa", "bb");
         try {
        String req = "SELECT * FROM categorie WHERE id="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
          while(rs.next()){
               Categorie cc = new Categorie(rs.getInt(1), rs.getString("nom_categorie"), rs.getString("description"));
                return cc;
            }
                } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       return null; 
    }
    public int findcatbynom(String nom) {
        
         try {
        String req = "SELECT * FROM categorie WHERE nom_categorie LIKE '"+nom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
          while(rs.next()){
               Categorie cc = new Categorie(rs.getInt(1), rs.getString("nom_categorie"), rs.getString("description"));
                return cc.getId();
            }
                } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       return 0; 
    }

    @Override
    public List<Produit> getAll() {
     List<Produit> list = new ArrayList<>();
        try {
            String req = "Select * from produit";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               // Produit p = new Produit(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("designation"), rs.getInt(2));
               Categorie c=new Categorie();
               c.setId(rs.getInt(2));
               c.setNom_categorie("aaaaaa");
               int id_cat=rs.getInt(2);
               //Categorie aa=affichercat(id_cat);
                //System.out.println(aa);
              Produit p = new Produit(rs.getInt(1),rs.getInt(4), rs.getString("nom"), rs.getString("designation"),rs.getString("cat"),rs.getInt(5),affichercat(id_cat));
              //Produit p = new Produit(rs.getInt(1),rs.getInt(4), rs.getString("nom"), rs.getString("designation"),rs.getString("cat"),rs.getString("image"),rs.getInt(5),affichercat(id_cat));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    public List<Produit> ListClasse() {
        List<Produit> Mylist = new ArrayList<>();
        try {
            String requete = "select * from produit ORDER BY  nom ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet e = pst.executeQuery();
            while (e.next()) {
            Produit pr = new Produit();
            pr.setId(e.getInt("id"));
            pr.setNom(e.getString("nom"));
            pr.setPrix(e.getFloat("prix"));
            pr.setImage(e.getString("image"));
          //  pr.setCategorie_id(e.getString("categorie_id"));
            pr.setDesignation(e.getString("designation"));
            pr.setQuantite(e.getInt("quantite"));
                Mylist.add(pr);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Mylist;
    }
    

}