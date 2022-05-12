///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
// */
//package GUI;
//
//import Campi.Entity.Facture;
//import Campi.Service.ServiceFacture;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
///**
// * FXML Controller class
// *
// * @author mahdi
// */
//public class PromotionListController implements Initializable {
//
//    @FXML
//    private AnchorPane left_main;
//    @FXML
//    private TextField PourcentageTf;
//    @FXML
//    private Button btn_delete;
//    @FXML
//    private Button btn_edit;
//    @FXML
//    private TableView<Facture> PromotionTab;
//    @FXML
//    private TableColumn<Facture, Integer> IDPromotionTab;
//    @FXML
//    private TableColumn<Facture, String> DescriptionTab;
//    @FXML
//    private TableColumn<Facture, Integer> PourcentageTab;
//    @FXML
//    private TableColumn<Facture, Integer> CodeCouponTab;
//    @FXML
//    private TableColumn<Facture, LocalDateTime> DateDebutTab;
//    @FXML
//    private TableColumn<Facture, LocalDateTime> DateFinTab;
//    @FXML
//    private TextField TFSearch;
//    @FXML
//    private Label NombrePromotion;
//    @FXML
//    private TextField CodeCouponTf;
//    @FXML
//    private TextField DescriptionTf;
//    @FXML
//    private Button Statistique;
//    @FXML
//    private DatePicker dateDebut;
//    @FXML
//    private DatePicker dateFin;
//
//    
//    ServiceFacture sp =new ServiceFacture();
//    int id;
//    Facture p;
//    ObservableList<Facture> data=FXCollections.observableArrayList();
//    
//    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            // TODO
//            NombrePromotion.setText(Integer.toString(sp.nbPromotion()));
//            refreshlist();
//            recherche_avance();
//        } catch (SQLException ex) {
//            Logger.getLogger(PromotionListController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//    }    
//
//    @FXML
//    private void AjouterPromotion(ActionEvent event) {
//                    try {
//            Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterPromotion.fxml"));
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(AjouterPromotionController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//     public void recherche_avance() throws SQLException {
//          
//                  data = FXCollections.observableArrayList(sp.afficher());
//            //System.out.println(data);
//            FilteredList<Facture> filteredData = new FilteredList<>(data, b -> true);
//            TFSearch.textProperty().addListener((observable, oldValue, newValue) -> {
//                filteredData.setPredicate(p -> {
//                    if (newValue == null || newValue.isEmpty()) {
//                        return true;
//                    }
//                    String lowerCaseFilter = newValue.toLowerCase();
//                    if (String.valueOf(p.getId()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
//                        return true; 
//                    } 
//                    else if(String.valueOf(p.getDated()).toLowerCase().indexOf(lowerCaseFilter)!=-1){
//                    return true;
//                    }
//                    else if(String.valueOf(p.getDatef()).toLowerCase().indexOf(lowerCaseFilter)!=-1){
//                    return true;
//                    }
//                    else if(p.getDescription().toLowerCase().indexOf(lowerCaseFilter)!=-1){
//                    return true;
//                    }
//                    else if(String.valueOf(p.getPourcentage()).toLowerCase().indexOf(lowerCaseFilter)!=-1){
//                    return true;
//                    }  
//                    else if(String.valueOf(p.getCodecoupone_id()).toLowerCase().indexOf(lowerCaseFilter)!=-1){
//                    return true;
//                    }                        
//                    else
//                        return false; // Does not match.
//                });
//                
//            });
//		// 3. Wrap the FilteredList in a SortedList. 
//		SortedList<Facture> sortedData = new SortedList<>(filteredData);
//		
//		// 4. Bind the SortedList comparator to the TableView comparator.
//		// 	  Otherwise, sorting the TableView would have no effect.
//		sortedData.comparatorProperty().bind(PromotionTab.comparatorProperty());
//		
//		// 5. Add sorted (and filtered) data to the table.
//		PromotionTab.setItems(sortedData);   
//        }
//     
//         public void refreshlist() throws SQLException{
//            data.clear();
//            data = FXCollections.observableArrayList(sp.afficher());
//            PromotionTab.setEditable(true);
//            PromotionTab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//            IDPromotionTab.setCellValueFactory(new PropertyValueFactory<>("id"));
//            DescriptionTab.setCellValueFactory(new PropertyValueFactory<>("description"));
//            PourcentageTab.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
//            CodeCouponTab.setCellValueFactory(new PropertyValueFactory<>("codecoupone_id"));
//            DateDebutTab.setCellValueFactory(new PropertyValueFactory<>("dated"));
//            DateFinTab.setCellValueFactory(new PropertyValueFactory<>("datef"));
//            PromotionTab.setItems(data);
//    }
//    
//     
//    @FXML
//    private void DeletePromotion(ActionEvent event) {
//        int Id;
//        Id=PromotionTab.getSelectionModel().getSelectedItem().getId();
//        try {
//            sp.supprimer(id);
//            refreshlist();
//            recherche_avance();
//        } catch (SQLException ex) {
//            Logger.getLogger(PromotionListController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void updatePromotion() throws SQLException{
//        Facture p = new Facture(dateDebut.getValue().atStartOfDay(),
//                                    dateFin.getValue().atStartOfDay(),
//                                    DescriptionTf.getText(),
//                                    Integer.parseInt(PourcentageTf.getText()),
//                                    Integer.parseInt(CodeCouponTf.getText()));
//        sp.modifier(id, p);
//        refreshlist(); 
//    }
//
//    @FXML
//    private void EditPromotion(ActionEvent event) {
//                try {
//            updatePromotion();
//            refreshlist();
//            recherche_avance();
//        } catch (SQLException ex) {
//            Logger.getLogger(PromotionListController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @FXML
//    private void fillforum(MouseEvent event) {
//        Facture p=PromotionTab.getSelectionModel().getSelectedItem();
//        id=p.getId();
//        DescriptionTf.setText(p.getDescription());
//        PourcentageTf.setText(Integer.toString(p.getPourcentage()));
//        CodeCouponTf.setText(Integer.toString(p.getCodecoupone_id()));
//        dateDebut.setValue(p.getDated().toLocalDate());
//        dateFin.setValue(p.getDatef().toLocalDate());
//    }
//
//    @FXML
//    private void Statistique(ActionEvent event) {
//    }
//    
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
