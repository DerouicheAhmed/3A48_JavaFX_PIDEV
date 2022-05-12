/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class ResetpasswordController implements Initializable {
    
    
    int randomCode;
    @FXML
    private TextField txtResetEmail;
    @FXML
    private TextField codeVer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendcode(ActionEvent event) {
        try{
        Random rand = new Random();
        randomCode=rand.nextInt(999999);
        String host = "smtp.gmail.com";
        String user = "campi.projet@gmail.com";
        String pass=  "campi1234A";
        
        String to = txtResetEmail.getText();
        String subject="Mot Passe Oublié";
        String message="Code de vérificarion:"+randomCode;
        boolean sessionDebug = false ;
        Properties pros = System.getProperties();
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
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Message envoyer", ButtonType.OK);
        a.showAndWait();
        }
        catch(Exception ex){
                 Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
        }
        
    }

    @FXML
    private void verifcode(ActionEvent event) throws IOException {
        if (Integer.valueOf(codeVer.getText())==randomCode){
              
              FXMLLoader loader = new FXMLLoader(getClass().getResource("changerpassword.fxml"));
              Parent root = loader.load();
              codeVer.getScene().setRoot(root);
              
              
              ChangerpasswordController pp = loader.getController() ;
              
              pp.setEmail(txtResetEmail.getText());
              
        }
    }
    
}
