/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.Login;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import database.ConnectionDatabase;

/**
 * FXML Controller class
 *
 * @author carter
 */
public class LoginController implements Initializable {

    @FXML
    public TextField userName;

    @FXML
    public PasswordField passWord;

    @FXML
    public Label incorrect;

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
    public void loginButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        //Connection base de données:
        String sql = "SELECT username, password FROM administrateur WHERE username = '" + userName.getText() + "'";
        System.out.println(sql);

        Connection connection = ConnectionDatabase.getDbConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        rs.next();

       // System.out.println(rs);

        if (!userName.getText().equals("") && !passWord.getText().equals("")) {
            if (passWord.getText().equals(rs.getString("password"))) {
                JOptionPane.showMessageDialog(null, "Login Successful");

                //Open home page 
                Parent root = FXMLLoader.load(getClass().getResource("../Dashboard/Dashboard.fxml"));
                Scene scene = new Scene(root);
                Stage dashboard = (Stage) ((Node) event.getSource()).getScene().getWindow();
                dashboard.hide();
                dashboard.setTitle("Login");
                dashboard.setScene(scene);
                dashboard.show();

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect password or username");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter Username and Password");
        }
    }

}
