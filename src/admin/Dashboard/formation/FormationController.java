/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.Dashboard.formation;

import admin.Dashboard.filiere.ListFiliere;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author carter
 */
public class FormationController implements Initializable {

    
    @FXML private TableView tableView;
    @FXML private TableColumn c1;
    @FXML private TableColumn c2;
    
    /**
     *
     * Initializes the controller class.
     */
    
    private ObservableList<ObservableList> formations;
    public Button logout = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          formations= FXCollections.observableArrayList();
            
          formations = ListFormation.getListFormation();
            
             System.out.println("list : ");
        
             System.out.println(formations);
    
           c1.setCellValueFactory(new PropertyValueFactory<>("Label"));
            
           c2.setCellValueFactory(new PropertyValueFactory<>("profRef"));
            
            
        tableView.setItems(formations);
    }    
     @FXML
    public void closeButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        Connection connection = ConnectionDatabase.closeDbConnection();
                Stage dashboard = (Stage) ((Node) event.getSource()).getScene().getWindow();
                dashboard.hide();
                
    }
    
    @FXML
    public void logoutButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        Connection connection = ConnectionDatabase.closeDbConnection();
                
                Parent root = FXMLLoader.load(getClass().getResource("../../Login/Login.fxml"));
                Scene scene = new Scene(root);
                Stage dash = (Stage) ((Node) event.getSource()).getScene().getWindow();
                dash.hide();
                dash.setTitle("Login");
                dash.setScene(scene);
                dash.show();
                
    }
    
}
