/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import edu.pisprintjava.entities.User;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class ProfilController implements Initializable {

    @FXML
    private Label paneNom;
    @FXML
    private Label LNom;
    @FXML
    private Label LPrenom;
    @FXML
    private Label LEmail;
    @FXML
    private Label LNum;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void setNom(String nom){
        LNom.setText(nom);
    }
    
    public void setPrenom(String prenom){
        LPrenom.setText(prenom);
    }
     public void setEmail(String email){
        LEmail.setText(email);
    }
    
    public void setNum(String numerotelephone){
        LNum.setText(numerotelephone);
    }
    
    public void setPrenNomT(String prenom){
        paneNom.setText(prenom);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        
      /*  
        String em=LEmail.getText();
        //public User getByEmail(String email) throws SQLException{
        User t = new User();
        int idd=0;
        String nom;
        String prenom;
        String nm;
        
        try{
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/campi","root","");
       String req = ("Select * from `user` WHERE `email` = '" +em+"'");
       Statement st = con.createStatement();
       ResultSet rs= st.executeQuery(req);
       rs.next();
       
       
       t.setId(rs.getInt("id"));
       t.setNom(rs.getString("nom"));
       t.setPrenom(rs.getString("prenom"));
       t.setEmail(rs.getString("email"));
       t.setNumerotelephone(rs.getString("numerotelephone"));
           
       idd=t.getId();
       nom=t.getNom();
       
       
       LNom.setText(nom);
       //LPrenom.setText(t.getPrenom());
       //LNum.setText(t.getNumerotelephone());
        }
        catch (Exception ex){
              Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
        }
     */
    }
    

          
    @FXML
    private void admin(ActionEvent event) throws IOException {
            
              FXMLLoader loader = new FXMLLoader(getClass().getResource("backuser.fxml"));
              Parent root = loader.load();
              LNom.getScene().setRoot(root);
              
                    BackuserController pp = loader.getController() ;
    }

    @FXML
    private void contact(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("contact.fxml"));
              Parent root = loader.load();
              LNom.getScene().setRoot(root);
              
                    ContactController pp = loader.getController() ;
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
              Parent root = loader.load();
              LNom.getScene().setRoot(root);
              
                    ConnexionController pp = loader.getController() ;
    }
  
}
