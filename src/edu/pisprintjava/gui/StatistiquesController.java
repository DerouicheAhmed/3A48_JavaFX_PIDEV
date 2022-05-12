/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.services.ServiceProduit;
import edu.pisprintjava.utis.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class StatistiquesController implements Initializable {
     String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Produit produit = null ;
    ServiceProduit sp= new ServiceProduit();
    @FXML
    private PieChart piChart;
    
    ObservableList<PieChart.Data> pieChartData;
 
    
ArrayList<String>name=new ArrayList<String>();

ArrayList<Integer>quantite=new ArrayList<Integer>();
   String query1 = null;
    Connection connection1 = null ;
    PreparedStatement preparedStatement1 = null ;
    ResultSet resultSet1 = null ;
    Produit produit1 = null ;
     ObservableList<PieChart.Data> pieChartData1;

    @FXML
    private PieChart piChart1;
    ArrayList<String>nom=new ArrayList<String>();

ArrayList<Integer>quantite1=new ArrayList<Integer>();

public void loadData() {
     try {
             pieChartData=FXCollections.observableArrayList();
             query="SELECT * FROM produit";
            Connection cnx =DataSource.getInstance().getCnx();
            preparedStatement = cnx.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
             while (resultSet.next()){
             pieChartData.add(new PieChart.Data(resultSet.getString("nom"),resultSet.getInt("quantite")));
             name.add(resultSet.getString("nom"));
             quantite.add(resultSet.getInt("quantite"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(StatistiquesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("er");
        }
}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         loadData();
        piChart.setData(pieChartData);
    }    
    
}
