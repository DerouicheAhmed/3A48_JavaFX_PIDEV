/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pisprintjava.gui;

import edu.pisprintjava.entities.Produit;
import edu.pisprintjava.services.ServiceProduit;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ItemController implements Initializable {

    @FXML
    private Label Ldesc;
    @FXML
    private Label Lcat;
    @FXML
    private Label Lprix;
    @FXML
    private Label Lqte;
    @FXML
    private Label Lnom;
    private Produit produit;

    
    
    
    public void setData(Produit produit) {
        Lnom.setText(produit.getNom());
        Ldesc.setText(produit.getDesignation());
        Lprix.setText(String.valueOf(produit.getPrix()));
        Lqte.setText(String.valueOf(produit.getQuantite()));
        Lcat.setText(produit.getCat());
        //Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        //img.setImage(image);
    }
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
