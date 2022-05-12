/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class BackhomeController implements Initializable {

    @FXML
    private Button btnDeconnexion;
    @FXML
    private Button btnProduit;
    @FXML
    private Button btnEvent;
    @FXML
    private Button btnPost;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button btnPost1;
    @FXML
    private Button btnPost11;
    @FXML
    private Button btnPost111;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
              Parent root = loader.load();
              btnDeconnexion.getScene().setRoot(root);
              
                    ConnexionController pp = loader.getController() ;
    }

    @FXML
    private void lancerProduit(ActionEvent event) throws IOException {
//         AnchorPane pane = FXMLLoader.load(getClass().getResource("afficherevenementBack.fxml"));
//        rootPane.getChildren().setAll(pane);
try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("AfficherProduit.fxml"));
            Stage stage =new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Evenement");
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void lancerEvent(ActionEvent event) throws IOException {
//         AnchorPane pane = FXMLLoader.load(getClass().getResource("afficherevenementBack.fxml"));
//        rootPane.getChildren().setAll(pane);
try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("afficherevenementBack.fxml"));
            Stage stage =new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Evenement");
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void lancerPost(ActionEvent event) throws IOException {
        try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("AfficherPostBack.fxml"));
            Stage stage =new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Evenement");
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void lancerDestination(ActionEvent event) {
        
        
    }

    @FXML
    private void lancerReclamation(ActionEvent event) {
    }

    @FXML
    private void lancerCategorie(ActionEvent event) {
        try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("AfficherCategorie.fxml"));
            Stage stage =new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Evenement");
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
