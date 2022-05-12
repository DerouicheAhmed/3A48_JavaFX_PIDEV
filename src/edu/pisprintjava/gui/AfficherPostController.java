/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.Alert.AlertDialog;
import edu.pisprintjava.entities.Evenement;
import edu.pisprintjava.entities.Post;
import edu.pisprintjava.services.Evenement_service;
import edu.pisprintjava.services.Post_service;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Houcein
 */
public class AfficherPostController implements Initializable {

    @FXML
    private ListView<Post> id_list;
    ObservableList<Post> Post=FXCollections.observableArrayList();
    @FXML
    private Button id_supprimer;
    @FXML
    private Button id_mod;
    @FXML
    private Button id_retour;
    private TextField id_titre;
    @FXML
    private TextField id_contenu;
    @FXML
    private Button id_commentaires;
    @FXML
    private HBox chosenhotelCard;

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
            Logger.getLogger(AfficherPostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void fill(MouseEvent event) {
        Post p= (Post) id_list.getSelectionModel().getSelectedItem();
        id_titre.setText(p.getTitre());
        id_contenu.setText(p.getContenu());
       
       
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
         Post_service sr = new Post_service();
        Post p = new Post();
        sr.Supprimer(p,id_list.getSelectionModel().getSelectedItem().getId());
        AlertDialog.showNotification("supprimer","avec succee", AlertDialog.image_checked);
        afficher();
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        Post p = new Post();
         Post_service sr = new Post_service();
                p.setTitre(id_titre.getText());
                p.setContenu(id_contenu.getText());
                p.setImage("aa");
            
               
                sr.Modifier(p,id_list.getSelectionModel().getSelectedItem().getId());
                AlertDialog.showNotification("modifier","avec succes", AlertDialog.image_checked);
                afficher();
    }

    @FXML
    private void goajout(ActionEvent event) {
        try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("AjoutPost.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void afficher() throws SQLException {
         Post_service sr = new Post_service();
        Post=FXCollections.observableArrayList(sr.Affichertout());
        id_list.setItems(Post);
    }

    @FXML
    private void gocomm(ActionEvent event) {
         try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("AfficherCommentaire.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
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