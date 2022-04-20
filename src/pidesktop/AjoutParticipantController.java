/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidesktop;

import Alert.AlertDialog;
import Entities.Evenement;
import Entities.Participant;
import Services.Participant_service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AjoutParticipantController implements Initializable {
    private boolean verificationUsernom;
    private boolean verificationUserPrenom;
    private boolean verificationUserPhone;
    private boolean verificationUserEvent;
    @FXML
    private TextField id_evenement;
    @FXML
    private TextField id_nom;
    @FXML
    private TextField id_prenom;
    @FXML
    private TextField id_num;
    @FXML
    private Button insert;
    @FXML
    private Button id_retour;
    @FXML
    private ComboBox<Evenement> id_event;
    @FXML
    private ImageView eventCM;
    @FXML
    private ImageView nomCM;
    @FXML
    private ImageView prenomCM;
    @FXML
    private ImageView numCM;
    @FXML
    private Label erreur_event;
    @FXML
    private Label erreur_nom;
    @FXML
    private Label erreur_prenom;
    @FXML
    private Label erreur_num;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        if ( verificationUserPhone && verificationUserPrenom && verificationUsernom && verificationUserEvent) {
            
        
        Participant_service sp=new Participant_service(); 
        Participant u = new Participant();
        u.setNom(id_nom.getText());
        u.setPrenom(id_prenom.getText());
        u.setNumero_telephone(id_num.getText());
        u.setEvenements_id(Integer.parseInt(id_evenement.getText()));
        sp.Ajouter(u);
        AlertDialog.showNotification("ajout","avec succees", AlertDialog.image_checked);
        }
    }

    @FXML
    private void Retour(ActionEvent event) {
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

    @FXML
    private void testevent(KeyEvent event) {
       
            if (isNumeric(id_evenement.getText())) {
                erreur_event.setText("Id valide");
                 eventCM.setImage(new Image("Images/checkMark.png"));
                verificationUserEvent = true;
            } else {             eventCM.setImage(new Image("Images/erreurcheckMark.png"));
                erreur_event.setText("Id non valide");
                verificationUserEvent = false;

            }

      
    }

    @FXML
    private void testnom(KeyEvent event) {
         int nbNonChar = 0;
            for (int i = 1; i < id_nom.getText().trim().length(); i++) {
                char ch = id_nom.getText().charAt(i);
                if (!Character.isLetter(ch)) {
                    nbNonChar++;
                }
            }

            if (nbNonChar == 0 && id_nom.getText().trim().length() >=3) {
            nomCM.setImage(new Image("Images/checkMark.png"));
            erreur_nom.setText("Nom valide");
            
            verificationUsernom = true;
            } else {
              nomCM.setImage(new Image("Images/erreurcheckMark.png"));
              erreur_nom.setText("Il faut au moins 3 caracteres");
              verificationUsernom = false;

            }
    }

    @FXML
    private void testprenom(KeyEvent event) {
        int nbNonChar = 0;
            for (int i = 1; i < id_prenom.getText().trim().length(); i++) {
                char ch = id_prenom.getText().charAt(i);
                if (!Character.isLetter(ch)) {
                    nbNonChar++;
                }
            }

            if (nbNonChar == 0 && id_prenom.getText().trim().length() >=3) {
            prenomCM.setImage(new Image("Images/checkMark.png"));
            erreur_prenom.setText("Prenom valide");
            
            verificationUserPrenom = true;
            } else {
                prenomCM.setImage(new Image("Images/erreurcheckMark.png"));
                erreur_prenom.setText("Il faut au moins 3 caracteres");
                verificationUserPrenom = false;

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
    private void testnum(KeyEvent event) {
        if (id_num.getText().trim().length() == 8) {
            int nbChar = 0;
            for (int i = 1; i < id_num.getText().trim().length(); i++) {
                char ch = id_num.getText().charAt(i);

                if (Character.isLetter(ch)) {

                    nbChar++;

                }
                //System.out.println(nbChar);
            }

            if (isNumeric(id_num.getText())) {
                erreur_num.setText("Tel valide");
                 numCM.setImage(new Image("Images/checkMark.png"));
                verificationUserPhone = true;
            } else {             numCM.setImage(new Image("Images/erreurcheckMark.png"));
                erreur_num.setText("Tel non valide");
                verificationUserPhone = false;

            }

        } else {numCM.setImage(new Image("Images/erreurcheckMark.png"));
            erreur_num.setText("Il faut 8 chiffres");
            verificationUserPhone = false;
        }
    }
    
}
