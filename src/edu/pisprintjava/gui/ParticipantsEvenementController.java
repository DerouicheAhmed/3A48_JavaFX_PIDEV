/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class ParticipantsEvenementController implements Initializable {

    @FXML
    private Button id_supprimer;
    @FXML
    private Button id_modifier;
    @FXML
    private Button id_Ajouter;
    @FXML
    private TextField id_nom;
    @FXML
    private TextField id_prenom;
    @FXML
    private TextField id_num;
    @FXML
    private ListView<?> id_list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void goAjout(ActionEvent event) {
    }

    @FXML
    private void testnom(KeyEvent event) {
    }

    @FXML
    private void testprenom(KeyEvent event) {
    }

    @FXML
    private void testnum(KeyEvent event) {
    }

    @FXML
    private void fill(MouseEvent event) {
    }
    
}
