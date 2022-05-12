/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

/*import Alert.AlertDialog;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;*/


import edu.pisprintjava.Alert.AlertDialog;
import edu.pisprintjava.entities.Evenement;
import edu.pisprintjava.entities.Participant;
import edu.pisprintjava.services.Evenement_service;
import edu.pisprintjava.services.Participant_service;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AfficherParticipantController implements Initializable {
    
    private boolean verificationUsernom;
    private boolean verificationUserPrenom;
    private boolean verificationUserPhone;
    private boolean verificationUserEvent;
    public  int id_evenement_participant;

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
     ObservableList<Participant> Participant=FXCollections.observableArrayList();
    @FXML
    private Button id_button_evenement;
    @FXML
    private ImageView nomCM;
    @FXML
    private ImageView prenomCM;
    @FXML
    private ImageView numCM;
    @FXML
    private ImageView eventCM;
    @FXML
    private Label erreur_nom;
    @FXML
    private Label erreur_prenom;
    @FXML
    private Label erreur_num;
    @FXML
    private Label erreur_event;
    @FXML
    private TableColumn<Participant, Integer> colId;
    @FXML
    private TableColumn<Participant, String> colNom;
    @FXML
    private TableColumn<Participant, String> colPrenom;
    @FXML
    private TableColumn<Participant, String> colNum;
    @FXML
    private TableView<Participant> id_listt;
    @FXML
    private ImageView qr;
    @FXML
    private HBox chosenhotelCard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            afficher();
            /////////////////////////debut////////////////////////////
            //affichertest();
            
            //////////////////////////fin///////////////////////////
            //afficherID();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherevenementController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherevenementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AfficherParticipantController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }  
 //////////////////////////debut///////////////////////////
//    public void affichertest() throws SQLException{
//        Participant_service sr = new Participant_service();
//        
//        ObservableList<Participant> list= FXCollections.observableArrayList(sr.Affichertout());
//        
//        colnomtest.setCellValueFactory(new PropertyValueFactory<Participant, String>("nom"));
//       
//       
//        
//        table_idd.setItems(list);
//    }
/////////////////////////fin////////////////////////////
public void afficher() throws SQLException, FileNotFoundException, IOException{
    
    
    
    //
        String details ="https://www.google.com/maps/place/"+AfficherevenementController.EvenementStatic.getDestination();
         
         ByteArrayOutputStream out = QRCode.from(details).to(ImageType.JPG).stream();
         File file = new File("C:\\Users\\mahdi\\Documents\\NetBeansProjects\\PISprintJava\\src\\edu\\pisprintjava\\Images\\MyChannel.jpg");
         FileOutputStream fos;

         fos = new FileOutputStream(file);
         fos.write(out.toByteArray());
         fos.flush();

// --> file:/C:/MyImages/myphoto.jpg
         String localUrl = file.toURI().toURL().toString();

         Image image = new Image(localUrl);

         qr.setImage(image);
    //
    
    
        Participant_service sr = new Participant_service();
        //Evenement=FXCollections.observableArrayList(sr.Affichertout());
        ObservableList<Participant> list= FXCollections.observableArrayList(sr.Affichertout());
        
        colId.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Participant, String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Participant, String>("prenom"));
        colNum.setCellValueFactory(new PropertyValueFactory<Participant, String>("numero_telephone"));
       
        
        id_listt.setItems(list);
    }

    @FXML
     private void supprimer(ActionEvent event) throws SQLException, IOException {
         if(id_listt.hasProperties() ){
            Participant_service sr = new Participant_service();
            Participant p = new Participant();
            sr.Supprimer(p,id_listt.getSelectionModel().getSelectedItem().getId());
            AlertDialog.showNotification("suppression","Le participant a été supprimer avec succés", AlertDialog.image_checked);
            afficher();
        }else{
             AlertDialog.showNotification("Attention","Veuillez selectionner un participant", AlertDialog.image_cross);
        }
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException, IOException {
       //////////////////////////////////////////
//        if(table_idd.hasProperties() ){
//                int idd=table_idd.getSelectionModel().getSelectedItem().getId();
//                System.out.println(idd);    
//            }
           //////////////////////////////////////////
        if(id_listt.hasProperties() ){
            if( verificationUserPhone && verificationUserPrenom && verificationUsernom){
                Participant p = new Participant();
                Participant_service sr = new Participant_service();
                    p.setNom(id_nom.getText());
                    p.setPrenom(id_prenom.getText());
                    p.setNumero_telephone(id_num.getText());

                    sr.Modifier(p,id_listt.getSelectionModel().getSelectedItem().getId());
                    AlertDialog.showNotification("modification","La modification a été faite avec succés", AlertDialog.image_checked);
                    afficher();
            }
        }else{
             AlertDialog.showNotification("Attention","Veuillez selectionner un participant", AlertDialog.image_cross);
        }
    }

    @FXML
    private void goAjout(ActionEvent event) {
       
               if(AfficherevenementController.EvenementStatic.getNbr_participants()==AfficherevenementController.EvenementStatic.getNbr_participants_max()){
               AlertDialog.showNotification("Erreur","Plus de place disponible", AlertDialog.image_cross);
               }else{
                     try {
            
                         Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();  
                         stageclose.close();
                         Parent root=FXMLLoader.load(getClass().getResource("/edu/pisprintjava/gui/AjoutParticipant.fxml"));
                         Stage stage =new Stage();
                         Scene scene = new Scene(root);
                         stage.setScene(scene);
                         stage.setTitle("Ajout Participant");
                         stage.show();
                    } catch (IOException ex) {
                         Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
    }


    @FXML
    private void GoToEvenement(ActionEvent event) {
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
    private void testevent(KeyEvent event) {
       
            if (isNumeric(id_evenement.getText())) {
                erreur_event.setText("Id valide");
                 eventCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
                verificationUserEvent = true;
            } else {             eventCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
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
            nomCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
            erreur_nom.setText("Nom valide");
            
            verificationUsernom = true;
            } else {
              nomCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
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
            prenomCM.setImage(new Image("/edu/pisprintjava/Images/checkMark.png"));
            erreur_prenom.setText("Prenom valide");
            
            verificationUserPrenom = true;
            } else {
                prenomCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
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
            } else {             numCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
                erreur_num.setText("Tel non valide");
                verificationUserPhone = false;

            }

        } else {numCM.setImage(new Image("/edu/pisprintjava/Images/erreurcheckMark.png"));
            erreur_num.setText("Il faut 8 chiffres");
            verificationUserPhone = false;
        }
    }

    @FXML
    private void fill_mod(MouseEvent event) {
          Participant p= id_listt.getSelectionModel().getSelectedItem();
        id_nom.setText(p.getNom());
        id_prenom.setText(p.getPrenom());
        id_num.setText(p.getNumero_telephone());
        id_evenement.setText(String.valueOf(p.getEvenements_id()));
       
        verificationUserPhone=true;
        verificationUserPrenom=true;
        verificationUsernom=true;
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