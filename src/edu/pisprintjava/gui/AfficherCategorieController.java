/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.entities.Categorie;
import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.services.ServiceCategorie;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AfficherCategorieController implements Initializable {

    @FXML
    private TextField id_nom;
    @FXML
    private TextField id_designation;
    @FXML
    private Button id_supprimer;
    @FXML
    private Button insert;
    private ListView<Categorie> id_list;
    ObservableList<Categorie> Categorie=FXCollections.observableArrayList();
    @FXML
    private Button id_modifier;
    @FXML
    private TableView<Categorie> id_listt;
    @FXML
    private TableColumn<Categorie, Integer> colid;
    @FXML
    private TableColumn<Categorie, String> colnomcat;
    @FXML
    private TableColumn<Categorie, String> colcatdesc;
    @FXML
    private Button btnDeconnexion;
    @FXML
    private Button btnProduit;
    @FXML
    private Button btnEvent;
    @FXML
    private Button btnPost;
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
            afficher();
            //afficherID();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
public void afficher() throws SQLException{
//        ServiceCategorie sr = new ServiceCategorie();
//        Categorie=FXCollections.observableArrayList(sr.getAllCategories());
//        id_list.setItems(Categorie);
        ServiceCategorie sr = new ServiceCategorie();
        //Evenement=FXCollections.observableArrayList(sr.Affichertout());
        ObservableList<Categorie> list= FXCollections.observableArrayList(sr.getAllCategories());
        
        colid.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id"));
        colnomcat.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nom_categorie"));
        colcatdesc.setCellValueFactory(new PropertyValueFactory<Categorie, String>("description"));
          id_listt.setItems(list);
    }
    @FXML
    private void supprimer(ActionEvent event) throws SQLException{
        ServiceCategorie sr = new ServiceCategorie();
        Categorie p = new Categorie();
        sr.supprimer(id_listt.getSelectionModel().getSelectedItem().getId());
        afficher();

        
    }
    @FXML
    private void GoAjout(ActionEvent event) {
         try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("AjouterCategorie.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fill(MouseEvent event) {
        Categorie p= id_list.getSelectionModel().getSelectedItem();
        id_nom.setText(p.getNom_categorie());
        id_designation.setText(p.getDescription());
        
    }

    @FXML
    private void modifier(ActionEvent event)throws SQLException {
         Categorie p = new Categorie();
            ServiceCategorie sr = new ServiceCategorie();
                p.setId(id_listt.getSelectionModel().getSelectedItem().getId());
                p.setNom_categorie(id_nom.getText());
                p.setDescription(id_designation.getText());
                sr.modifier(p);
                afficher();
    }

    @FXML
    private void fill_mod(MouseEvent event) {
        Categorie p= id_listt.getSelectionModel().getSelectedItem();
        id_nom.setText(p.getNom_categorie());
        id_designation.setText(p.getDescription());
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
