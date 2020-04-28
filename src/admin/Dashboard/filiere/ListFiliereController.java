/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.Dashboard.filiere;

import database.ConnectionDatabase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author carter
 */
public class ListFiliereController implements Initializable {

    @FXML private TableView tableView;
    @FXML private TableColumn c1;
    @FXML private TableColumn c2;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
     private ObservableList<ObservableList> filieres;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            filieres= FXCollections.observableArrayList();
            
            filieres = ListFiliere.getListFiliere();
            
             System.out.println("list : ");
        
             System.out.println(filieres);
    
           c1.setCellValueFactory(new PropertyValueFactory<>("label"));
            
           c2.setCellValueFactory(new PropertyValueFactory<>("responsable"));
            
            
        tableView.setItems(filieres);
    }    
    
     @FXML
    public void closeButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        Connection connection = ConnectionDatabase.closeDbConnection();
                Stage dashboard = (Stage) ((Node) event.getSource()).getScene().getWindow();
                dashboard.hide();
                
    }
    
    
    
}