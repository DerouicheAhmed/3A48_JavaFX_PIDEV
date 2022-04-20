/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.tests;

import edu.pisprintjava.entities.Categorie;
import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.services.ServiceCategorie;
import edu.pisprintjava.services.ServiceProduit;
import edu.pisprintjava.utis.DataSource;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
public class MainClass  {
    
    
    public static void main(String[] args) {
        
       Categorie c1= new Categorie(7, "teststests", "ahmed");
        Categorie c2= new Categorie("Tessssssssst", "test133H");
        ServiceCategorie sc=new ServiceCategorie();
        //sc.ajouter(c1);
        //sc.modifier(c2);
       // System.out.println("les categories :"+sc.getAllCategories());
        System.out.println("Categorie added !!!");
         Produit p1=new Produit(1, 10, "HHHHHHHHH", "HHHHHHHMMMMMMPPPP", 20, c1);
        ServiceProduit sp=new ServiceProduit();
        //sp.ajouter(p1);
        
        System.out.println("Produit added !!!");
        
    }
}
