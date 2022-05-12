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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import edu.pisprintjava.entities.User;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField tfLEmail;
    @FXML
    private PasswordField tfLPassword;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        
          if (tfLEmail.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Saisir votre adresse email SVP!", ButtonType.OK);
            a.showAndWait();
            return;
        }
          if (tfLPassword.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Saisir votre mot de passe SVP!", ButtonType.OK);
            a.showAndWait();
            return;
        }
          
        String email=tfLEmail.getText();
        String pass=tfLPassword.getText();
        try{
        Class.forName("com.mysql.jdbc.Driver");
        
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/campi","root","");
        pst = con.prepareStatement("Select * from user where email=? and password=?");
        
        pst.setString(1,email);
        pst.setString(2,pass);
        
        rs= pst.executeQuery();
        if (rs.next())
        {
              Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Connexion Valider", ButtonType.OK);
                a.showAndWait();
                
               String s1 = rs.getString("role"); 
              if (s1.equalsIgnoreCase("Fournisseur")){
              FXMLLoader loader = new FXMLLoader(getClass().getResource("profilF.fxml"));
              Parent root = loader.load();
              tfLEmail.getScene().setRoot(root);
        
              ProfilFController pp = loader.getController() ;
            
              
                 
                    User t = new User();
                    int idd=0;
                    String nom;
                    String prenom;
                    String nm;
                    
                    
       try{
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/campi","root","");
       String req = ("Select * from `user` WHERE `email` = '" +email+"'");
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
       
       
      // LNom.setText(nom);
       //LPrenom.setText(t.getPrenom());
       //LNum.setText(t.getNumerotelephone());
         pp.setNom(t.getNom());
         pp.setPrenom(t.getPrenom());
         pp.setNum(t.getNumerotelephone());
         pp.setEmail(email);
         pp.setPrenNomT(t.getPrenom());
        }
        catch (Exception ex){
              Alert ac = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                ac.showAndWait();
        }
              
            
            }
            if(s1.equalsIgnoreCase("Admin")){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("profil.fxml"));
                    Parent root = loader.load();
                    tfLEmail.getScene().setRoot(root);
                    ProfilController pp = loader.getController() ;
                    
                    
                    User t = new User();
                    int idd=0;
                    String nom;
                    String prenom;
                    String nm;
                    
                    
       try{
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/campi","root","");
       String req = ("Select * from `user` WHERE `email` = '" +email+"'");
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
       
       
      // LNom.setText(nom);
       //LPrenom.setText(t.getPrenom());
       //LNum.setText(t.getNumerotelephone());
         pp.setNom(t.getNom());
         pp.setPrenom(t.getPrenom());
         pp.setNum(t.getNumerotelephone());
         pp.setEmail(email);
         pp.setPrenNomT(t.getPrenom());
        }
        catch (Exception ex){
              Alert ac = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                ac.showAndWait();
        }
                   
                 
                   
            }
            ////if
            if(s1.equalsIgnoreCase("Utilisateur")){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilFront.fxml"));
                    Parent root = loader.load();
                    tfLEmail.getScene().setRoot(root);
                    ProfilController pp = loader.getController() ;
                    
                    
                    User t = new User();
                    int idd=0;
                    String nom;
                    String prenom;
                    String nm;
                    
                    
       try{
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/campi","root","");
       String req = ("Select * from `user` WHERE `email` = '" +email+"'");
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
       
       
      // LNom.setText(nom);
       //LPrenom.setText(t.getPrenom());
       //LNum.setText(t.getNumerotelephone());
         pp.setNom(t.getNom());
         pp.setPrenom(t.getPrenom());
         pp.setNum(t.getNumerotelephone());
         pp.setEmail(email);
         pp.setPrenNomT(t.getPrenom());
        }
        catch (Exception ex){
              Alert ac = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                ac.showAndWait();
        }
                   
                 
                   
            }
            ////endif
        }
        else{
              Alert a = new Alert(Alert.AlertType.ERROR, "Echec Connexion", ButtonType.OK);
            a.showAndWait();
            
            tfLEmail.setText("");
            tfLPassword.setText("");
            tfLEmail.requestFocus();
            
        }
        
          
    }catch (ClassNotFoundException ex){
        Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null,ex );
    }   catch (SQLException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

    @FXML
    private void inscri(ActionEvent event) throws IOException {
              
              FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutUser.fxml"));
              Parent root = loader.load();
              tfLEmail.getScene().setRoot(root);
              
              AjoutUserController pp = loader.getController() ;
            
    }

    @FXML
    private void motdepass(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resetpassword.fxml"));
              Parent root = loader.load();
              tfLEmail.getScene().setRoot(root);
              
              ResetpasswordController pp = loader.getController() ;
    }
    
}
