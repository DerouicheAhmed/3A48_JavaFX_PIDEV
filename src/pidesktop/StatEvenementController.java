/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidesktop;

import Entities.Evenement;
import Services.Evenement_service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahdi
 */
public class StatEvenementController implements Initializable {

    @FXML
    private PieChart chart;
    @FXML
    private Button id_retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Evenement_service p =new Evenement_service();
          chart.setTitle("l'ampleur des événements: \n           (<10 faible) \n    (10< <50 Moyennne)\n           (50< Grande)"); 
        try {
            chart.getData().setAll(new PieChart.Data("Faible", p.Recherche2()), new PieChart.Data("Moyenne", p.Recherche3()),
                    new PieChart.Data("Grande", p.Recherche4())
            );
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(StatEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void retour(ActionEvent event) {
          try {
            
                Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
                Parent root=FXMLLoader.load(getClass().getResource("afficherevenement.fxml"));
            Stage stage =new Stage();
            
                Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
                Logger.getLogger(PIdesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
