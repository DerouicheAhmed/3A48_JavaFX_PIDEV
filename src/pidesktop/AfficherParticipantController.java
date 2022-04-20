/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidesktop;

import Alert.AlertDialog;
import Entities.Evenement;
import Entities.Participant;
import Services.Evenement_service;
import Services.Participant_service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AfficherParticipantController implements Initializable {

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
    private TextField id_evenement;
    @FXML
    private TextField id_num;
    @FXML
    private ListView<Participant> id_list;
     ObservableList<Participant> Participant=FXCollections.observableArrayList();
    @FXML
    private Button id_button_evenement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            afficher();
            //afficherID();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherevenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
public void afficher() throws SQLException{
        Participant_service sr = new Participant_service();
        Participant=FXCollections.observableArrayList(sr.Affichertout());
        id_list.setItems(Participant);
    }
    @FXML
     private void supprimer(ActionEvent event) throws SQLException {
        Participant_service sr = new Participant_service();
        Participant p = new Participant();
        sr.Supprimer(p,id_list.getSelectionModel().getSelectedItem().getId());
        AlertDialog.showNotification("supprimer","avec succee", AlertDialog.image_checked);
        afficher();
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        Participant p = new Participant();
         Participant_service sr = new Participant_service();
                p.setNom(id_nom.getText());
                p.setPrenom(id_prenom.getText());
                p.setNumero_telephone(id_num.getText());
                p.setEvenements_id(Integer.parseInt(id_evenement.getText()));
                sr.Modifier(p,id_list.getSelectionModel().getSelectedItem().getId());
                AlertDialog.showNotification("modifier","avec succee", AlertDialog.image_checked);
                afficher();
    }

    @FXML
    private void goAjout(ActionEvent event) {
        try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("AjoutParticipant.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void fill(MouseEvent event) {
         Participant p= id_list.getSelectionModel().getSelectedItem();
        id_nom.setText(p.getNom());
        id_prenom.setText(p.getPrenom());
        id_num.setText(p.getNumero_telephone());
        id_evenement.setText(String.valueOf(p.getEvenements_id()));
        
    }

    @FXML
    private void GoToEvenement(ActionEvent event) {
       /*  try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("afficherevenement.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
