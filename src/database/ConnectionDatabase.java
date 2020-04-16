/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author carter
 */
public class ConnectionDatabase {

    static Connection connection = null;

    public static Connection getDbConnection() {

        if (ConnectionDatabase.connection == null) {
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/db_covoiturage?autoReconnect=true";
                String user = "carter";
                String pass = "toutankhamon";
                ConnectionDatabase.connection = DriverManager.getConnection(url, user, pass);

                System.out.println("Got it!");

            } catch (SQLException e) {

                throw new Error("Problem", e);
            }
        }

        return ConnectionDatabase.connection;
    }

    public static Connection closeDbConnection() {

        if (ConnectionDatabase.connection != null) {
            try {

                ConnectionDatabase.connection.close();
                System.out.println("Connection closed.");
                JOptionPane.showMessageDialog(null, "Connection closed !");

            } catch (SQLException echec){

                echec.printStackTrace();
            }

        }
        return ConnectionDatabase.connection = null;
    }

}
