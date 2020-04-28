/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.Dashboard;

import admin.Dashboard.filiere.ListFiliere;
import admin.Dashboard.filiere.Filiere;

import database.ConnectionDatabase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author carter
 */
public class DashboardController implements Initializable {

    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 
    @FXML
    public void getListFiliere(ActionEvent event)throws ClassNotFoundException, SQLException, IOException{
    //Open Filiere page 
                Parent root = FXMLLoader.load(getClass().getResource("./filiere/listFiliere.fxml"));
                Scene scene = new Scene(root);
                Stage filieres = (Stage) ((Node) event.getSource()).getScene().getWindow();
                filieres.setTitle("Filières");
                filieres.setScene(scene);
                filieres.show();
    }
    
    @FXML
    public void getListFormation(ActionEvent event)throws ClassNotFoundException, SQLException, IOException{
    //Open Formation page 
                Parent root = FXMLLoader.load(getClass().getResource("./formation/Formation.fxml"));
                Scene scene = new Scene(root);
                Stage formations = (Stage) ((Node) event.getSource()).getScene().getWindow();
                formations.setTitle("Formations");
                formations.setScene(scene);
                formations.show();
    }
}
