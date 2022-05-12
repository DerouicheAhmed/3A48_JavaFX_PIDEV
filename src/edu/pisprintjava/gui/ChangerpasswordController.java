/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import edu.pisprintjava.entities.User;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class ChangerpasswordController implements Initializable {

    @FXML
    private TextField tfNewPass;
    @FXML
    private Button btnNewPass;
    @FXML
    private PasswordField tfcmp;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    
    public String user;
    @FXML
    private Label setmail;
    
    
     public void setEmail(String email){
        setmail.setText(email);
    }
   
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newpass(ActionEvent event) {
        String email = setmail.getText();
       
        
        
    if( tfNewPass.getText().equals(tfcmp.getText())){
        try{
             User t = new User();
            int idd=0;
        
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/campi","root","");
            String req = ("Select id from `user` WHERE `email` = '" +email+"'");
            Statement st = con.createStatement();
       
            ResultSet rs= st.executeQuery(req);
            rs.next();
            
              t.setId(rs.getInt("id"));
              //t.setNom(rs.getString("nom"));
              //t.setPrenom(rs.getString("prenom"));
              //t.setEmail(rs.getString("email"));
              //t.setNumerotelephone(rs.getString("numerotelephone"));
           
              idd=t.getId();
            
            String updatequery = "UPDATE user SET `password`=? WHERE `user`.`id` ="+idd+"";
           
            pst=con.prepareStatement(updatequery);
            pst.setString(1, tfNewPass.getText());
          
         
            pst.executeUpdate();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Mot de passe changé", ButtonType.OK);
            a.showAndWait();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
                    Parent root = loader.load();
                    tfNewPass.getScene().setRoot(root);
                    ConnexionController pp = loader.getController() ;
        }
        catch (Exception ex){
             Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
        }
    }
    else{
          Alert a = new Alert(Alert.AlertType.WARNING,"Le mot de passe ne correspond pas", ButtonType.OK);
                a.showAndWait();
    }
    }
    
}
