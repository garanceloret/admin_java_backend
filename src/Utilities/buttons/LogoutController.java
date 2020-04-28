/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.buttons;

import database.ConnectionDatabase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author carter
 */
public class LogoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    public void logoutButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        Connection connection = ConnectionDatabase.closeDbConnection();
                
                Parent root = FXMLLoader.load(getClass().getResource("../../admin/Login/Login.fxml"));
                Scene scene = new Scene(root);
                Stage dash = (Stage) ((Node) event.getSource()).getScene().getWindow();
                dash.hide();
                dash.setTitle("Login");
                dash.setScene(scene);
                dash.show();
                
    }
    
}
