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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class ProfilFController implements Initializable {

    @FXML
    private Label paneNom;
    @FXML
    private Label LNom;
    @FXML
    private Label LPrenom;
    @FXML
    private Label LEmail;
    @FXML
    private Label LNum;
    @FXML
    private Button btnF;

     public void setNom(String nom){
        LNom.setText(nom);
    }
    
    public void setPrenom(String prenom){
        LPrenom.setText(prenom);
    }
     public void setEmail(String email){
        LEmail.setText(email);
    }
    
    public void setNum(String numerotelephone){
        LNum.setText(numerotelephone);
    }
    public void setPrenNomT(String prenom){
        paneNom.setText(prenom);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fournisseur(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
              Parent root = loader.load();
              LNom.getScene().setRoot(root);
              
                    ConnexionController pp = loader.getController() ;
    }
    
}
