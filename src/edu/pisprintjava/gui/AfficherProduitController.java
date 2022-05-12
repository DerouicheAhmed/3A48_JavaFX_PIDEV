/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.services.ServiceProduit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AfficherProduitController implements Initializable {
 
    List <Produit> produits =new ArrayList();
    @FXML
    private TextField id_nom;
    @FXML
    private TextField id_designation;
    @FXML
    private TextField id_prix;
    @FXML
    private TextField id_quantite;
    
    @FXML
    private Button id_supprimer;
    private ListView<Produit> id_list;
    ObservableList<Produit> Produit=FXCollections.observableArrayList();
    @FXML
    private Button id_modifier;
    @FXML
    private Button inert;
    @FXML
    private TableView<Produit> id_listt;
    @FXML
    private TableColumn<Produit, Integer> colid;
    @FXML
    private TableColumn<Produit, String> colnomprod;
    @FXML
    private TableColumn<Produit,String> colcatprod;
    @FXML
    private TableColumn<Produit, Integer> colqtprod;
    @FXML
    private TableColumn<Produit, Float> colprixprod;
    @FXML
    private TableColumn<Produit, String> coldesprod;
    @FXML
    private TableColumn<Produit, String> colimgprod;
    @FXML
    private TextField tfnom;
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
            search_produit();
            //afficherID();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
public void afficher() throws SQLException{
//     ServiceProduit sr = new ServiceProduit();
//        Produit=FXCollections.observableArrayList(sr.getAll());
//        id_list.setItems(Produit);
        ServiceProduit sr = new ServiceProduit();
        //Evenement=FXCollections.observableArrayList(sr.Affichertout());
        ObservableList<Produit> list= FXCollections.observableArrayList(sr.getAll());
        System.out.println(list);
        colid.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id"));
        colnomprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        //colcatprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("categories_id"));
        colcatprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("cat"));
        colqtprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        colprixprod.setCellValueFactory(new PropertyValueFactory<Produit, Float>("prix"));
        coldesprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("designation"));
        colimgprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("image"));
       
        id_listt.setItems(list);
    }
    @FXML
    private void supprimer(ActionEvent event)  throws SQLException{
        ServiceProduit sr = new ServiceProduit();
        Produit p = new Produit();
        sr.supprimer(id_listt.getSelectionModel().getSelectedItem().getId());
        
        afficher();
    }

    @FXML
    private void GoAjout(ActionEvent event) {
         try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("AjouterProduit.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fill(MouseEvent event) {
        Produit p= id_list.getSelectionModel().getSelectedItem();
        id_nom.setText(p.getNom());
        id_designation.setText(p.getDesignation());
        id_quantite.setText(String.valueOf(p.getQuantite()));
        id_prix.setText(String.valueOf(p.getPrix()));
        
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        Produit p = new Produit();
            ServiceProduit sr = new ServiceProduit();
                p.setId(id_listt.getSelectionModel().getSelectedItem().getId());
                p.setNom(id_nom.getText());
                p.setDesignation(id_designation.getText());
                p.setPrix(Float.parseFloat(id_prix.getText()));
                p.setQuantite(Integer.parseInt(id_quantite.getText()));
                sr.modifier(p);
                
                afficher();
    }

    @FXML
    private void fill_mod(MouseEvent event) {
         Produit p= id_listt.getSelectionModel().getSelectedItem();
            id_nom.setText(p.getNom());
            id_designation.setText(p.getDesignation());
            id_quantite.setText(String.valueOf(p.getQuantite()));
            id_prix.setText(String.valueOf(p.getPrix()));
    }

    @FXML
    private void stat(javafx.scene.input.MouseEvent event) {
         FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("Statistiques.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                             Parent parent = loader.getRoot();
                            Stage stat = new Stage();
                            stat.setScene(new Scene(parent));
                            stat.initStyle(StageStyle.UTILITY);
                            stat.show();
    }

    
    void search_produit() {   
    
        colid.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id"));
        colnomprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        //colcatprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("categories_id"));
        colcatprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("cat"));
        colqtprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        colprixprod.setCellValueFactory(new PropertyValueFactory<Produit, Float>("prix"));
        coldesprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("designation"));
        colimgprod.setCellValueFactory(new PropertyValueFactory<Produit, String>("image"));
        
        ServiceProduit sr = new ServiceProduit();
        
        List<Produit> li=sr.ListClasse();
        ObservableList<Produit> data = FXCollections.observableArrayList(li);
        id_listt.setItems((ObservableList)data);
        FilteredList<Produit> filteredData = new FilteredList<>(data, b -> true);  
        tfnom.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(test -> {
        if (newValue == null || newValue.isEmpty()) {
        return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    if (test.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
      return true; 
    } else if (test.getDesignation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
      return true; 
    } else if (String.valueOf(test.getQuantite()).indexOf(lowerCaseFilter)!=-1) {
         return true;
    } 
        else  
          return false; 
   });
  });  
  SortedList<Produit> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind((ObservableValue)id_listt.comparatorProperty());  
  id_listt.setItems((SortedList)sortedData);      
    }

    @FXML
    private void recherche(MouseEvent event) {
        
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
