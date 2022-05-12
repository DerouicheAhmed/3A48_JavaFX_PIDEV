
//package edu.pisprintjava.gui;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import edu.pisprintjava.entities.User;
//import edu.pisprintjava.IServices.ServiceUser;
//
///**
// * FXML Controller class
// *
// * @author Boughnimi
// */
//public class AjoutUserController implements Initializable {
//
//    @FXML
//    private TextField tfNom;
//    @FXML
//    private TextField tfPrenom;
//    @FXML
//    private TextField tfEmail;
//    @FXML
//    private PasswordField tfPassword;
//    @FXML
//    private TextField tfNumerotelephone;
//    @FXML
//    private ChoiceBox<String> CBrole;
//    
//    private String[] roles = {"Admin","Fournisseur","User"};
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        CBrole.getItems().addAll(roles);
//    }    
//    private boolean validateEmaill(){
//        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
//        Matcher m = p.matcher(tfEmail.getText());
//        if(m.find() && m.group().equals(tfEmail.getText())){
//            return true;
//        }else{
//                Alert alert = new Alert(AlertType.WARNING);
//                alert.setTitle("Validate Email");
//                alert.setHeaderText(null);
//                alert.setContentText("SVP! Saisir une adresse mail valide");
//                alert.showAndWait();
//            
//            return false;            
//        }
//    }
//
//    @FXML
//    private void ajouteruser(ActionEvent event) throws IOException {
//    if(tfNumerotelephone.getText().length()!=8){
//        Alert a = new Alert(Alert.AlertType.ERROR, "Le numéro de téléphone doit étre de 8 caractére", ButtonType.OK);
//            a.showAndWait();
//            return;
//    }
//      if(tfPassword.getText().length()<8){
//        Alert a = new Alert(Alert.AlertType.ERROR, "Le mot de passe doit étre supérieur à 7 caractére", ButtonType.OK);
//            a.showAndWait();
//            return;
//    }
//    
//    if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty()|| tfEmail.getText().isEmpty() || tfPassword.getText().isEmpty()||tfNumerotelephone.getText().isEmpty()) {
//            Alert a = new Alert(Alert.AlertType.ERROR, "SVP Remplir la formulaire", ButtonType.OK);
//            a.showAndWait();
//        } else {
//            try {
//                
//                  ServiceUser sp = new ServiceUser();
//                  User p = new User(tfNom.getText(), tfPrenom.getText(),tfEmail.getText(),tfPassword.getText(),tfNumerotelephone.getText(),CBrole.getValue());
//                  if (validateEmaill()){
//                  sp.ajouter(p);
//                  Alert a = new Alert(Alert.AlertType.INFORMATION, "Utilisateur Ajouté", ButtonType.OK);
//                  a.showAndWait();
//                  }
//                  
//            }catch (SQLException ex){
//                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
//                a.showAndWait();
//            }
//        }
//}
//
//    @FXML
//    private void back(ActionEvent event) throws IOException {
//              FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
//              Parent root = loader.load();
//              tfNom.getScene().setRoot(root);
//              
//              ConnexionController pp = loader.getController() ;
//    }
//    
//}

//////////////////////////////////////////////////
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import edu.pisprintjava.entities.User;
import edu.pisprintjava.IServices.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class AjoutUserController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfNumerotelephone;
    @FXML
    private ChoiceBox<String> CBrole;
    
    private String[] roles = {"Admin","Fournisseur","Utilisateur"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CBrole.getItems().addAll(roles);
    }    
    private boolean validateEmaill(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(tfEmail.getText());
        if(m.find() && m.group().equals(tfEmail.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Email");
                alert.setHeaderText(null);
                alert.setContentText("SVP! Saisir une adresse mail valide");
                alert.showAndWait();
            
            return false;            
        }
    }

    @FXML
    private void ajouteruser(ActionEvent event) throws IOException, AddressException, MessagingException {
    if(tfNumerotelephone.getText().length()!=8 ){
        Alert a = new Alert(Alert.AlertType.ERROR, "Le numéro de téléphone doit étre de 8 nombre", ButtonType.OK);
            a.showAndWait();
            return;
    }
    if (!tfNumerotelephone.getText().matches("[0-9]+")){
           Alert a = new Alert(Alert.AlertType.ERROR, "Le numéro de téléphone doit étre un nombre", ButtonType.OK);
            a.showAndWait();
            return;
    }
      if(tfPassword.getText().length()<8){
        Alert a = new Alert(Alert.AlertType.ERROR, "Le mot de passe doit étre supérieur à 7 caractére", ButtonType.OK);
            a.showAndWait();
            return;
    }

    if (tfNom.getText().isEmpty() ){
            Alert a = new Alert(Alert.AlertType.ERROR, "SVP Saisir votre nom", ButtonType.OK);
            a.showAndWait();
        }
    else if(tfPrenom.getText().isEmpty()){
          Alert a = new Alert(Alert.AlertType.ERROR, "SVP Saisir votre prénom", ButtonType.OK);
            a.showAndWait();
    }
     else if(tfEmail.getText().isEmpty()){
          Alert a = new Alert(Alert.AlertType.ERROR, "SVP Saisir votre adresse mail", ButtonType.OK);
            a.showAndWait();
    }
    else if(tfPassword.getText().isEmpty()){
          Alert a = new Alert(Alert.AlertType.ERROR, "SVP Saisir votre mot de passe", ButtonType.OK);
            a.showAndWait();
    }
    else if(tfNumerotelephone.getText().isEmpty()){
          Alert a = new Alert(Alert.AlertType.ERROR, "SVP Saisir votre numéro téléphone", ButtonType.OK);
            a.showAndWait();
    }
    
    else {
        
            try {
                
                  ServiceUser sp = new ServiceUser();
                  User p = new User(tfNom.getText(), tfPrenom.getText(),tfEmail.getText(),tfPassword.getText(),tfNumerotelephone.getText(),CBrole.getValue());
                  if (validateEmaill()){
                  sp.ajouter(p);
                  String host = "smtp.gmail.com";
                  String user = "campi.projet@gmail.com";
                  String pass=  "campi1234A";
                  String to = tfEmail.getText();
                  String subject="Bienvenue dans Campi";
                  String message="Bonjour "+tfPrenom.getText()+" Votre Compte est créer avec succès, Votre Information sont : "
                          + " , Prénom : "+tfPrenom.getText()+" , Nom : "+tfNom.getText()+" , Numéro de téléphone: "+tfPassword.getText();
                 
                  
                  Alert a = new Alert(Alert.AlertType.INFORMATION, "Utilisateur Ajouté", ButtonType.OK);
                  Properties pros = System.getProperties();

                  boolean sessionDebug = false ;
        pros.put("mail.smtp.starttls.enable","true");
        pros.put("mail.smtp.host", "host");
        pros.put("mail.smtp.port", "587");
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.required","true");
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(pros, null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(user));
        InternetAddress [] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject);
        msg.setText(message);
        
        Transport transport = mailSession.getTransport("smtps");
        transport.connect(host,user,pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
                  a.showAndWait();
                  }
                  
            }catch (SQLException ex){
                Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
            }
        }
}

    @FXML
    private void back(ActionEvent event) throws IOException {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
              Parent root = loader.load();
              tfNom.getScene().setRoot(root);
              
              ConnexionController pp = loader.getController() ;
    }
    
}
