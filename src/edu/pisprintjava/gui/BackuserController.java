/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import edu.pisprintjava.entities.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Boughnimi
 */
public class BackuserController implements Initializable {

    @FXML
    private TextField BId;
    @FXML
    private TextField BNom;
    @FXML
    private TextField BPrenom;
    @FXML
    private TextField BEmail;
    @FXML
    private TextField BPassword;
    @FXML
    private TableView<User> TableUser;
    @FXML
    private TableColumn<User, Integer> colId;
    @FXML
    private TableColumn<User, String> colNom;
    @FXML
    private TableColumn<User, String> colPrenom;
    @FXML
    private TableColumn<User, String> colEmail;
    @FXML
    private TableColumn<User, String> colPassword;
    @FXML
    private TableColumn<User, String> colNumero;
    @FXML
    private TextField BNumero;
    @FXML
    private Button btnA;
    @FXML
    private Button btnM;
    @FXML
    private Button btnS;
    @FXML
    private TableColumn<User, String> colRole;
    @FXML
    private TextField BRole;
    
    private TextField filterField;
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
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()== btnA){
            insert();
        }else if (event.getSource()== btnM){
            updateUser();
        }else if (event.getSource()== btnS){
            deleteUser();
    }
}
       @FXML
    void effacer(ActionEvent event) {
        User user= TableUser.getSelectionModel().getSelectedItem();
        BId.setText(""+"");
        BNom.setText(""+"");
        BPrenom.setText(""+"");
        BEmail.setText(""+"");
        BPassword.setText(""+"");
        BNumero.setText(""+"");
        BRole.setText(""+"");
    }

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showUser();
        //search_user();
    }

    public Connection getConnection(){
        Connection conn;
        try{
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/campi","root","");
            return conn;
            
        }
        catch(Exception ex){
            System.out.println("Error: " +ex.getMessage());
            return null;
        }
    }
    public ObservableList<User> getUserList(){
        ObservableList<User> userList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM user";
        Statement st;
        ResultSet rs;
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
            User users;
            while (rs.next()){
                users=new User(rs.getInt("id"), rs.getString("Nom"), rs.getString("Prenom"),rs.getString("Email"),rs.getString("Password"),rs.getString("Numerotelephone"),rs.getString("Role"));
                userList.add(users);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return userList;
        
    }
     ObservableList<User> list= getUserList();
    public void showUser(){
      //  ObservableList<User> list= getUserList();
        
        colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<User, String>("Nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<User, String>("Prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
        colNumero.setCellValueFactory(new PropertyValueFactory<User, String>("Numerotelephone"));
        colRole.setCellValueFactory(new PropertyValueFactory<User, String>("Role"));
        TableUser.setItems(list);
        
        
        
        
        
    }
    void search_user(){
        colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<User, String>("Nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<User, String>("Prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
        colNumero.setCellValueFactory(new PropertyValueFactory<User, String>("Numerotelephone"));
        colRole.setCellValueFactory(new PropertyValueFactory<User, String>("Role"));
        
        TableUser.setItems(list);
        
         // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<User> filteredData = new FilteredList<>(list, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getNom().toLowerCase().indexOf(lowerCaseFilter)>-1) {
                    return true; // Filter matches first name.
             //   } else if (User.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                 //   return true; // Filter matches last name.
               // } else return String.valueOf(User.getNumerotelephone()).contains(lowerCaseFilter); // Does not match.
   
      //  });
                }
                return false;
        });
       
        
    
                    });
    
    }
    private void insert(){
        String query = "INSERT INTO `user` (`nom`, `prenom`,`email`,`password`,`numerotelephone`,`role`) VALUES ('"+BNom.getText()+"', '"+BPrenom.getText()+"', '"+BEmail.getText()+"', '"+BPassword.getText()+"', '"+BNumero.getText()+"', '" +BRole.getText()+ "' )";
        executeQuery(query);
        showUser();
    }
    private void updateUser(){
        String query = "UPDATE user SET nom = '"+BNom.getText()+"', `prenom` = '"+BPrenom.getText()+"',`email` = '"+BEmail.getText()+"' , `password` = '"+BPassword.getText()+"',`numerotelephone` = '"+BNumero.getText()+"',`role` = '"+BRole.getText()+"'    WHERE `user`.`id` = " +BId.getText()+"";
        executeQuery(query);
        showUser();
    }
    
    private void deleteUser(){
        String query = "DELETE FROM `user` WHERE id =" +BId.getText()+ "";
        executeQuery(query);
        showUser();
    }
    
    
    
    
    
    
    
    private void executeQuery(String query){
        Connection conn=getConnection();
        Statement st;
    
    try{
        st= conn.createStatement();
        st.executeUpdate(query);
    }catch(Exception ex){
        ex.printStackTrace();
    }
    } 

    @FXML
    private void handleMouse(MouseEvent event) {
        User user= TableUser.getSelectionModel().getSelectedItem();
        BId.setText(""+user.getId());
        BNom.setText(""+user.getNom());
        BPrenom.setText(""+user.getPrenom());
        BEmail.setText(""+user.getEmail());
        BPassword.setText(""+user.getPassword());
        BNumero.setText(""+user.getNumerotelephone());
        BRole.setText(""+user.getRole());
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
