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
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static pidesktop.PIdesktop.main;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AfficherevenementController implements Initializable {
    private boolean verificationDestination;
    private boolean verificationDescription;
    private boolean verificationNbrparticipants;
    private boolean verificationPrix;
    private boolean verificationDate;
    int idd=0;
    Evenement ev;
    public static int id_evenement_participant;
    public static Evenement EvenementStatic;
    @FXML
    private TextField id_seach;
    @FXML
    private Button id_stat;
    
    
   

    public AfficherevenementController() {
    }
    private String recherche ="";
    @FXML
    private TableView<Evenement> id_listt;
    @FXML
    private TableColumn<Evenement, Integer> colId;
    @FXML
    private TableColumn<Evenement, String> colDestination;
    @FXML
    private TableColumn<Evenement, String> colDescription;
    @FXML
    private TableColumn<Evenement, Integer> colNbrParticipants;
    @FXML
    private TableColumn<Evenement, Integer> colNbrParticipantsMax;
    @FXML
    private TableColumn<Evenement, Integer> colPrix;
    @FXML
    private TableColumn<Evenement, Date> colDate;
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
    @FXML
    private ImageView destinationCM;
    @FXML
    private ImageView descriptionCM;
    @FXML
    private ImageView nbrparticipantsCM;
    @FXML
    private ImageView prixCM;
    @FXML
    private Label erreur_destination;
    @FXML
    private Label erreur_description;
    @FXML
    private Label erreur_nbrparticipants;
    @FXML
    private Label erreur_prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            
            affichertableau();

            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherevenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
      public void affichertableau() throws SQLException{
        Evenement_service sr = new Evenement_service();
        //Evenement=FXCollections.observableArrayList(sr.Affichertout());
        ObservableList<Evenement> list= FXCollections.observableArrayList(sr.Affichertout());
        
        colId.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("id"));
        colDestination.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Destination"));
        colNbrParticipants.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("nbr_participants"));
        colNbrParticipantsMax.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("nbr_participants_max"));
        colPrix.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("Prix"));
        colDate.setCellValueFactory(new PropertyValueFactory<Evenement, Date>("date"));
        colDescription.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Description"));
        
        id_listt.setItems(list);
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
        if(id_listt.hasProperties() ){
            Evenement_service sr = new Evenement_service();
            Evenement p = new Evenement();
            sr.Supprimer(p,id_listt.getSelectionModel().getSelectedItem().getId());
            AlertDialog.showNotification("suppression","l'evenement a été supprimer avec succés", AlertDialog.image_checked);
            affichertableau();
        }else{
             AlertDialog.showNotification("Attention","Veuillez selectionner une evenement", AlertDialog.image_cross);
        }    
    }


    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        if(id_listt.hasProperties() ){
            if(verificationDescription && verificationDestination && verificationNbrparticipants && verificationPrix){
            Evenement p = new Evenement();
             Evenement_service sr = new Evenement_service();
                    p.setDestination(id_destination.getText());
                    p.setNbr_participants_max(Integer.parseInt(id_nbr_participants_max.getText()));
                    p.setPrix(Integer.parseInt(id_prix.getText()));
                    p.setDescription(id_description.getText());
                    ZoneId defaultZoneId = ZoneId.systemDefault();
                    Date date = Date.from(id_date.getValue().atStartOfDay(defaultZoneId).toInstant());
                    p.setDate(date);
                    sr.Modifier(p,id_listt.getSelectionModel().getSelectedItem().getId());
                    AlertDialog.showNotification("modification","l'evenement a été modifier avec succés", AlertDialog.image_checked);
                    affichertableau();
            }
        }else{
             AlertDialog.showNotification("Attention","Veuillez selectionner une evenement", AlertDialog.image_cross);
        }
    }

    @FXML
    private void GoToParticipant(ActionEvent event) {
        
        if(id_listt.hasProperties() )
        {    idd=id_listt.getSelectionModel().getSelectedItem().getId();
            System.out.println(idd);
             ev=id_listt.getSelectionModel().getSelectedItem();
            id_evenement_participant=idd;
            EvenementStatic=ev;
        System.out.println(id_evenement_participant);
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
        }else{
             AlertDialog.showNotification("Attention","Veuillez selectionner une evenement", AlertDialog.image_cross);
        }
    
    }

    @FXML
    private void testdestination(KeyEvent event) {
          int nbNonChar = 0;
            for (int i = 1; i < id_destination.getText().trim().length(); i++) {
                char ch = id_destination.getText().charAt(i);
                if (!Character.isLetter(ch)) {
                    nbNonChar++;
                }
            }

            if (nbNonChar == 0 && id_destination.getText().trim().length() >=3) {
            destinationCM.setImage(new Image("Images/checkMark.png"));
            erreur_destination.setText("Destination valide");
            
            verificationDestination = true;
            } else {
              destinationCM.setImage(new Image("Images/erreurcheckMark.png"));
              erreur_destination.setText("Il faut au moins 3 caracteres");
              verificationDestination = false;

            }
    }
public boolean isNumeric(String str){
        if(str==null){
            return false;
        }
        try
        {
            int x=Integer.parseInt(str);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    @FXML
    private void testnbrparticipants(KeyEvent event) {
        if (isNumeric(id_nbr_participants_max.getText())) {
                erreur_nbrparticipants.setText("Valide");
                 nbrparticipantsCM.setImage(new Image("Images/checkMark.png"));
                verificationNbrparticipants = true;
            } else {             nbrparticipantsCM.setImage(new Image("Images/erreurcheckMark.png"));
                erreur_nbrparticipants.setText("Non valide");
                verificationNbrparticipants = false;

            }
    }

    @FXML
    private void testprix(KeyEvent event) {
            if (isNumeric(id_prix.getText())) {
                erreur_prix.setText("Prix valide");
                 prixCM.setImage(new Image("Images/checkMark.png"));
                verificationPrix = true;
            } else {             prixCM.setImage(new Image("Images/erreurcheckMark.png"));
                erreur_prix.setText("Prix non valide");
                verificationPrix = false;

            }
    }

    @FXML
    private void testdescription(KeyEvent event) {
          int nbNonChar = 0;
            for (int i = 1; i < id_description.getText().trim().length(); i++) {
                char ch = id_description.getText().charAt(i);
                if (!Character.isLetter(ch)) {
                    nbNonChar++;
                }
            }

            if (nbNonChar == 0 && id_description.getText().trim().length() >=5) {
            descriptionCM.setImage(new Image("Images/checkMark.png"));
            erreur_description.setText("Description valide");
            
            verificationDescription = true;
            } else {
              descriptionCM.setImage(new Image("Images/erreurcheckMark.png"));
              erreur_description.setText("Il faut au moins 5 caracteres");
              verificationDescription = false;

            }
    }

    @FXML
    private void fill_mod(MouseEvent event) {
        Evenement p= id_listt.getSelectionModel().getSelectedItem();
        
        id_destination.setText(p.getDestination());
        id_nbr_participants_max.setText(String.valueOf(p.getNbr_participants_max()));
        id_prix.setText(String.valueOf(p.getPrix()));
        id_description.setText(p.getDescription());
         java.sql.Date sqlDate = java.sql.Date.valueOf(p.getDate().toString());
         LocalDate localDate2 = sqlDate.toLocalDate();
        id_date.setValue(localDate2);
        verificationDescription = true;
        verificationDestination = true;
        verificationNbrparticipants=true;
        verificationPrix=true;
    }

    @FXML
    private void search(ActionEvent event)  throws SQLException {
        recherche=id_seach.getText();
        Evenement_service sr = new Evenement_service();
        if(recherche.isEmpty() )
        {affichertableau();
        }
        else{
                 List<Evenement> p=sr.Recherche(id_seach.getText());
                 id_listt.getItems().clear();
                 id_listt.getItems().removeAll(Evenement);
                 id_listt.getItems().addAll(p);
                 
        }
        
    }

    @FXML
    private void gostat(ActionEvent event) {
          try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("StatEvenement.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}

