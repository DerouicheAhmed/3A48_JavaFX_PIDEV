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
import java.util.ArrayList;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FrontProduitController implements Initializable {

    @FXML
    private ScrollPane scrollId;
    @FXML
    private GridPane grid;
    private List<Produit> cat=new ArrayList<>();
    @FXML
    private HBox chosenhotelCard;
    
    private List<Produit> getData(){
         ServiceProduit sp =new ServiceProduit();
        return sp.getAll();
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cat.addAll(getData());
//        
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < cat.size(); i++) {
                        
                System.out.println("hello ");

                System.out.println(cat.get(i));
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData( cat.get(i));
                

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
          

                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
      

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(4));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    @FXML
    private void Acceuil(ActionEvent event) {
    }
    
}
