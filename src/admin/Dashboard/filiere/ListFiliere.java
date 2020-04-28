/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.Dashboard.filiere;


import database.ConnectionDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author carter
 */




public class ListFiliere {
   
   
     public static void main(String args[]){       

     }
    
    
    public static ObservableList getListFiliere(){
    
       ObservableList<Filiere> list = FXCollections.observableArrayList();
       ResultSet rs;
       
        try {
            String sql = "SELECT * FROM filiere"; 
            Connection connection = ConnectionDatabase.getDbConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Filiere  row = new Filiere(); 
                row.label.set(rs.getString("label"));
                row.responsable.set(rs.getString("responsable")) ;
                list.add(row);
                
                /*list.add(rs.getString("label"));
                list.add(rs.getString("responsable"));*/
            }
                             
        } catch (SQLException error) {

            System.out.println(error.getMessage());
        }
            return list; 
    }
    
}
