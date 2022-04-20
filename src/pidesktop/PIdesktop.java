/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidesktop;

import Entities.Evenement;
import Entities.Participant;
import Services.Participant_service;
import Services.Evenement_service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mahdi
 */
public class PIdesktop extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("afficherevenement.fxml")); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
//        Participant P = new Participant("test5", "test6", "27083856", 1);
//        Participant_service ps = new Participant_service();
//        ps.Ajouter(P);
//        System.out.println(ps.Affichertout());
//        Evenement P= new Evenement("granooola","50","image6",2,2,2,1,1);
//       Evenement_service ps = new Evenement_service();
//        ps.Ajouter(P);           
//        System.out.println(ps.Affichertout());
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
