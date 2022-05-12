/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.Alert.AlertDialog;
import edu.pisprintjava.entities.Evenement;
import edu.pisprintjava.services.Evenement_service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AjoutevenementController implements Initializable {
    private boolean verificationDestination;
    private boolean verificationDescription;
    private boolean verificationNbrparticipants;
    private boolean verificationPrix;
    private boolean verificationDate;

    @FXML
    private TextField id_destination;
    @FXML
    private TextField id_nbr_participants_max;
    @FXML
    private TextField id_prix;
    @FXML
    private TextField id_description;
    @FXML
    private ImageView img;
    @FXML
    private Button insert;
    
    private File Current_file;
 
    private String file_image;
    @FXML
    private DatePicker id_date;
    @FXML
    private Button id_retour;
    @FXML
    private ImageView destinationCM;
    @FXML
    private ImageView prixCM;
    @FXML
    private ImageView descriptionCM;
    @FXML
    private ImageView nbrparticipantsCM;
    @FXML
    private ImageView dateCM;
    @FXML
    private Label erreur_destination;
    @FXML
    private Label erreur_prix;
    @FXML
    private Label erreur_description;
    @FXML
    private Label erreur_nbrparticipants;
    @FXML
    private Label erreur_date;
    @FXML
    private HBox chosenhotelCard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dragover(DragEvent event) {
        Dragboard board = event.getDragboard();
        
        if (board.hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
            
        }
    }

    @FXML
    private void dropimg(DragEvent event) throws FileNotFoundException {
        Dragboard board = event.getDragboard();
        List<File> phil = board.getFiles();
        FileInputStream fis;
        fis = new FileInputStream(phil.get(0));
        Image image = new Image(fis);
        File selectedFile = phil.get(0);
        if (selectedFile != null) {

            String test = selectedFile.getAbsolutePath();
            System.out.println(test);

            Current_file = selectedFile.getAbsoluteFile();
            file_image = Current_file.getName();
            Evenement e = new Evenement();
            e.setImage(selectedFile.getName());
           img.setImage(image);
        }
    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException, ParseException {
         if ( verificationDescription && verificationDestination && verificationNbrparticipants && verificationPrix) {
            file_image = "src/edu/pisprintjava/Images/" + file_image;
            SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");  
            Evenement_service sp=new Evenement_service(); 
            System.out.println(id_date.toString());
            Evenement u = new Evenement();
            u.setDestination(id_destination.getText());
            u.setDescription(id_description.getText());
            u.setNbr_participants_max(Integer.parseInt(id_nbr_participants_max.getText()));
            u.setPrix(Integer.parseInt(id_prix.getText()));
            Date datee = Date.valueOf(id_date.getValue());
            u.setDate(datee);
            u.setImage(file_image); 
            sp.Ajouter(u);
            AlertDialog.showNotification("Ajouter","L'evenement avec succees", AlertDialog.image_checked);
             try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/edu/pisprintjava/gui/afficherevenement.fxml"));
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
    private void retour(ActionEvent event) {
         try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("/edu/pisprintjava/gui/afficherevenement.fxml"));
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
    private void testdestination(KeyEvent event) {
          int nbNonChar = 0;
            for (int i = 1; i < id_destination.getText().trim().length(); i++) {
                char ch = id_destination.getText().charAt(i);
                if (!Character.isLetter(ch)) {
                    nbNonChar++;
                }
            }

            if (nbNonChar == 0 && id_destination.getText().trim().length() >=3) {
            destinationCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
            erreur_destination.setText("Destination valide");
            
            verificationDestination = true;
            } else {
              destinationCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
              erreur_destination.setText("Il faut au moins 3 caracteres");
              verificationDestination = false;

            }
    }

    @FXML
    private void testnbrparticipants(KeyEvent event) {
        if ((isNumeric(id_nbr_participants_max.getText()))&& Integer.parseInt(id_nbr_participants_max.getText())>0) {
                erreur_nbrparticipants.setText("Valide");
                 nbrparticipantsCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
                verificationNbrparticipants = true;
            } else {             nbrparticipantsCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
                erreur_nbrparticipants.setText("Non valide");
                verificationNbrparticipants = false;

            }
    }

    @FXML
    private void testprix(KeyEvent event) {
            if (isNumeric(id_prix.getText())) {
                erreur_prix.setText("Prix valide");
                 prixCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
                verificationPrix = true;
            } else {             prixCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
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
            descriptionCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
            erreur_description.setText("Description valide");
            
            verificationDescription = true;
            } else {
              descriptionCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
              erreur_description.setText("Il faut au moins 5 caracteres");
              verificationDescription = false;

            }
    }

    private void testdate(KeyEvent event) {
        
        LocalDate now= LocalDate.now();
        LocalDate date =id_date.getValue();
        
        if(date.isAfter(now)){
            dateCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
            erreur_date.setText("Date valide");
            
            verificationDate = true;
        }else{
            dateCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
              erreur_date.setText("Date non valide");
              verificationDate = false;
        
        }
    }

    private void testdate(InputMethodEvent event) {
        LocalDate now= LocalDate.now();
        LocalDate date =id_date.getValue();
        
        if(date.isAfter(now)){
            dateCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
            erreur_date.setText("Date valide");
            
            verificationDate = true;
        }else{
            dateCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
              erreur_date.setText("Date non valide");
              verificationDate = false;
        
        }
    }

    @FXML
    private void testdate(MouseEvent event) {
               LocalDate now= LocalDate.now();
        LocalDate date =id_date.getValue();
        
        if(date.isAfter(now)){
            dateCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
            erreur_date.setText("Date valide");
            
            verificationDate = true;
        }else{
            dateCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
              erreur_date.setText("Date non valide");
              verificationDate = false;
        
        }
    }

    @FXML
    private void GoAcceuil(ActionEvent event) {
        try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("AcceuilFront.fxml"));
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
    private void GoEvenement(ActionEvent event) {
        try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("afficherevenement.fxml"));
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
    private void GoShop(ActionEvent event) {
         try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("FrontProduit.fxml"));
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
    private void GoBlog(ActionEvent event) {
         try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("AfficherPost.fxml"));
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
    private void GoDestination(ActionEvent event) {
    }

    @FXML
    private void GoFacture(ActionEvent event) {
         try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("FactureList.fxml"));
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
    private void GoCommande(ActionEvent event) {
        try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("CommandeList.fxml"));
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
    private void LogOut(ActionEvent event) {
//          FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
//              Parent root = loader.load();
//              btnDeconnexion.getScene().setRoot(root);
//              
//                    ConnexionController pp = loader.getController() ;
try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("connexion.fxml"));
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