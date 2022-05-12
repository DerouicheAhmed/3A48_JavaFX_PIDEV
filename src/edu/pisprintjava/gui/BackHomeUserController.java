/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class BackHomeUserController implements Initializable {

    @FXML
    private Button btnDeconnexion;
    @FXML
    private Button btnListUser;
    @FXML
    private AnchorPane rootPane;

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
    private void lancerLU(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("backuser.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
}
