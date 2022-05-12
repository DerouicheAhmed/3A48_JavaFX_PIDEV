/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.entities.Categorie;
import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.services.ServiceProduit;
import edu.pisprintjava.utis.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class AjouterProduitController implements Initializable {

    @FXML
    private TextField id_nom;
    @FXML
    private TextField id_designation;
    @FXML
    private TextField id_prix;
    @FXML
    private TextField id_quantite;
    private TextField id_categorie;
    @FXML
    private Button id_retour;
    @FXML
    private Button inert;
    @FXML
    private ChoiceBox<String> categorie;
    @FXML
    private ImageView imgv;
    private File Current_file;
    private String file_image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choice();
    }    

    @FXML
    private void retour(ActionEvent event) {
        try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("AfficherProduit.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouter(ActionEvent event) {
        Boolean ok=false;
     if ((id_nom.getText().toString().compareTo("") == 0) || (id_designation.getText().toString().compareTo("") == 0 ) ||  (id_prix.getText().toString().compareTo("") == 0 )|| (id_quantite.getText().toString().compareTo("") == 0 )) {
         ok=true;
            JOptionPane.showMessageDialog(null, "champs vide");

} else {
        ServiceProduit sp=new ServiceProduit(); 
        Produit u = new Produit();
        u.setNom(id_nom.getText());
        u.setDesignation(id_designation.getText());
//        Categorie c = new Categorie();
//        c.setId(Integer.parseInt(id_categorie.getText()));
//        u.setCatégories_id(c);
 String cat = categorie.getValue();
 int id=sp.findcatbynom(cat);
 Categorie c = new Categorie();
       c.setNom_categorie(cat);
       c.setId(id);
        u.setPrix(Integer.parseInt(id_prix.getText()));
        u.setQuantite(Integer.parseInt(id_quantite.getText()));
        u.setCatégories_id(c);
        file_image = "src/edu/pisprintjava/Images/" + file_image;
        u.setImage(file_image);
        sp.ajouter(u);
    }
    }
    
    
      public void choice() {
      try {  
        ResultSet resultSet = null;
              String req = "select * from categorie ";
               //connection = MaConnection.getInstance().getConnection();
                Connection cnx =DataSource.getInstance().getCnx();
               //preparedStatement = connection.prepareStatement(query);
                Statement st=cnx.createStatement();
                PreparedStatement ps = cnx.prepareStatement(req);
                resultSet =  ps.executeQuery();
      
               while (resultSet.next()) {
                   Categorie c = new Categorie();
            c.setNom_categorie(resultSet.getString("nom_categorie"));
            
            categorie.getItems().addAll(c.getNom_categorie()); 
    
    
         }
         } catch (SQLException ex) {
            Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }

//    @FXML
//    private void importer(MouseEvent event) {
//        
//       
//        
//    }

//    @FXML
//    private void importer(ActionEvent event) {
//        JFileChooser chooser = new JFileChooser();
//        chooser.showOpenDialog(null);
//        File f = chooser.getSelectedFile();
//        String ImageName=f.getAbsolutePath();
//        tfimg.setText(ImageName);
//    }

    @FXML
    private void dragover(DragEvent event) {
        
       Dragboard board = event.getDragboard();
        
        if (board.hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
       
    }

    @FXML
    private void dropimage(DragEvent event)throws FileNotFoundException {
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
            Produit p = new Produit();
            p.setImage(selectedFile.getName());
           imgv.setImage(image);
    } }


   

       
      
        
    }
    