/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidesktop;

import Alert.AlertDialog;
import Entities.Evenement;
import Services.Evenement_service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static pidesktop.PIdesktop.main;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AfficherevenementController implements Initializable {

    @FXML
    private ListView<Evenement> id_list;
    @FXML
    private Button Ajout;
    ObservableList<Evenement> Evenement=FXCollections.observableArrayList();
    @FXML
    private Button id_supprimer;
    @FXML
    private Button id_mod;
    @FXML
    private TextField id_prix;
    @FXML
    private TextField id_nbr_participants_max;
    @FXML
    private TextField id_destination;
    @FXML
    private TextField id_description;
    @FXML
    private Button id_button_participant;
    @FXML
    private DatePicker id_date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            afficher();
            //afficherID();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherevenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void afficher() throws SQLException{
        Evenement_service sr = new Evenement_service();
        Evenement=FXCollections.observableArrayList(sr.Affichertout());
        id_list.setItems(Evenement);
    }
    @FXML
    private void goajout(ActionEvent event) {
        try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("Ajoutevenement.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        Evenement_service sr = new Evenement_service();
        Evenement p = new Evenement();
        sr.Supprimer(p,id_list.getSelectionModel().getSelectedItem().getId());
        AlertDialog.showNotification("supprimer","avec succee", AlertDialog.image_checked);
        afficher();
    }

    @FXML
    private void fill(MouseEvent event) {
        Evenement p= id_list.getSelectionModel().getSelectedItem();
        id_destination.setText(p.getDestination());
        id_nbr_participants_max.setText(String.valueOf(p.getNbr_participants_max()));
        id_prix.setText(String.valueOf(p.getPrix()));
        id_description.setText(p.getDescription());
         java.sql.Date sqlDate = java.sql.Date.valueOf(p.getDate().toString());
         LocalDate localDate2 = sqlDate.toLocalDate();
        id_date.setValue(localDate2);
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        Evenement p = new Evenement();
         Evenement_service sr = new Evenement_service();
                p.setDestination(id_destination.getText());
                p.setNbr_participants_max(Integer.parseInt(id_nbr_participants_max.getText()));
                p.setPrix(Integer.parseInt(id_prix.getText()));
                p.setDescription(id_description.getText());
                ZoneId defaultZoneId = ZoneId.systemDefault();
                Date date = Date.from(id_date.getValue().atStartOfDay(defaultZoneId).toInstant());
                p.setDate(date);
                sr.Modifier(p,id_list.getSelectionModel().getSelectedItem().getId());
                AlertDialog.showNotification("modifier","avec succee", AlertDialog.image_checked);
                afficher();
    }

    @FXML
    private void GoToParticipant(ActionEvent event) {
        try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("AfficherParticipant.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}

