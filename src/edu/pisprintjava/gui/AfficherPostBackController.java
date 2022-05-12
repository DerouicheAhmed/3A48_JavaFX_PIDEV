/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.entities.Post;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Houcein
 */
public class AfficherPostBackController implements Initializable {

    @FXML
    private TextField id_image;
    @FXML
    private TextField id_post;
    @FXML
    private TextField id_titre;
    @FXML
    private TextField id_contenu;
    @FXML
    private Button id_mod;
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
    @FXML
    private TableView<Post> id_listt;
    @FXML
    private Button id_valider;
    @FXML
    private Button btnDeconnexion;
    @FXML
    private Button btnProduit;
    @FXML
    private Button btnEvent;
    @FXML
    private Button btnPost;
    @FXML
    private TextField id_user;
    @FXML
    private TableColumn<Post, Integer> colPostID;
    @FXML
    private TableColumn<Post, Integer> colUserID;
    @FXML
    private TableColumn<Post, String> colTitre;
    @FXML
    private TableColumn<Post, String> colImage;
    @FXML
    private TableColumn<Post, String> colContenu;
    @FXML
    private Button btnPost1;
    @FXML
    private Button btnPost11;
    @FXML
    private Button btnPost111;

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
            Logger.getLogger(AfficherPostBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void affichertableau() throws SQLException{
        Post_service sr = new Post_service();
        //Evenement=FXCollections.observableArrayList(sr.Affichertout());
        ObservableList<Post> list= FXCollections.observableArrayList(sr.AffichertoutBack());
        
        colPostID.setCellValueFactory(new PropertyValueFactory<Post, Integer>("id"));
        colUserID.setCellValueFactory(new PropertyValueFactory<Post, Integer>("id_user"));
        colTitre.setCellValueFactory(new PropertyValueFactory<Post, String>("titre"));
        colImage.setCellValueFactory(new PropertyValueFactory<Post, String>("image"));
        colContenu.setCellValueFactory(new PropertyValueFactory<Post, String>("contenu"));
       
        id_listt.setItems(list);
    }


    @FXML
    private void fill_mod(MouseEvent event) {
        Post p= (Post) id_listt.getSelectionModel().getSelectedItem();
        
        id_titre.setText(p.getTitre());
        id_contenu.setText(p.getContenu());
        id_user.setText(String.valueOf(p.getId_user()));
        id_image.setText(p.getImage());
        id_post.setText(String.valueOf(p.getId()));
    }



    @FXML
    private void decliner(ActionEvent event) throws SQLException {
        Post p= (Post) id_listt.getSelectionModel().getSelectedItem();
        Post_service es=new Post_service();
        es.Decliner(p);
        affichertableau();
    }

    @FXML
    private void accepter(ActionEvent event) throws SQLException {
         Post p= (Post) id_listt.getSelectionModel().getSelectedItem();
        Post_service es=new Post_service();
        es.Accepter(p);
        affichertableau();
    }
@FXML
    private void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
              Parent root = loader.load();
              btnDeconnexion.getScene().setRoot(root);
              
                    ConnexionController pp = loader.getController() ;
    }

    @FXML
    private void lancerProduit(ActionEvent event) throws IOException {
//         AnchorPane pane = FXMLLoader.load(getClass().getResource("afficherevenementBack.fxml"));
//        rootPane.getChildren().setAll(pane);
try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("AfficherProduit.fxml"));
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
    private void lancerEvent(ActionEvent event) throws IOException {
//         AnchorPane pane = FXMLLoader.load(getClass().getResource("afficherevenementBack.fxml"));
//        rootPane.getChildren().setAll(pane);
try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("afficherevenementBack.fxml"));
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
    private void lancerPost(ActionEvent event) throws IOException {
        try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("AfficherPostBack.fxml"));
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
    private void lancerDestination(ActionEvent event) {
        
        
    }

    @FXML
    private void lancerReclamation(ActionEvent event) {
    }

    @FXML
    private void lancerCategorie(ActionEvent event) {
        try {
            
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("AfficherCategorie.fxml"));
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

