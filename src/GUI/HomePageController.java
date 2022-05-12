/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class HomePageController implements Initializable {

    @FXML
    private Label usernameLabel11;
    @FXML
    private Label usernameLabel1;
    @FXML
    private JFXButton Facture;
    @FXML
    private JFXButton Commande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void goTO_Facture(ActionEvent event) {
    }

    @FXML
    private void goTO_Commande(ActionEvent event) {
    }
    
}
