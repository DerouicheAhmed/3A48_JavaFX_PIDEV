/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.entities.Categorie;
import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.services.ServiceCategorie;
import edu.pisprintjava.services.ServiceProduit;
import edu.pisprintjava.utis.DataSource;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */

public class MainClass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("AfficherPost.fxml"));
       Parent root = FXMLLoader.load(getClass().getResource("connexion.fxml")); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//   Categorie c1= new Categorie(6, "teststests", "ahmed");
//        Categorie c2= new Categorie("Tessssssssst", "test133H");
//        ServiceCategorie sc=new ServiceCategorie();
//        sc.ajouter(c1);
//        //sc.modifier(c2);
//       // System.out.println("les categories :"+sc.getAllCategories());
//        //System.out.println("Categorie added !!!");
//         Produit p1=new Produit(1, 10, "HHHHHHHHH", "HHHHHHHMMMMMMPPPP", 20, c1);
//        ServiceProduit sp=new ServiceProduit();
//        sp.ajouter(p1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}