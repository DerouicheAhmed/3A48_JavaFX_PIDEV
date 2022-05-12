/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class MailFournisseurController implements Initializable {

    @FXML
    private TextArea tdesc;
    @FXML
    private TextField tfto;
    @FXML
    private TextField tffrom;
    @FXML
    private TextField tfpassword;
    @FXML
    private Button tbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
        sendEmail();
    }
     public void sendEmail(){
        String to = tfto.getText();
        String from = tffrom.getText();
        String host = "smtp.gmail.com";
        final String username = tffrom.getText();
        final String password = tfpassword.getText();

        //setup mail server

        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password); //To change body of generated methods, choose Tools | Templates.
            }
           
            
            
            
        });

        try{

            //create mail
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            m.setText(tdesc.getText());

            //send mail
 
            Transport.send(m);
           // sentBoolValue.setVisible(true);
            System.out.println("Message sent!");

        }   catch (MessagingException e){
            e.printStackTrace();
        }

    }
    
}
