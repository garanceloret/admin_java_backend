/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.Dashboard.formation;

import database.ConnectionDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author carter
 */
public class ListFormation {
    
     public static void main(String args[]){       

     }
    
    
    public static ObservableList getListFormation(){
    
       ObservableList<Formation> list = FXCollections.observableArrayList();
       ResultSet rs;
       
        try {
            String sql = "SELECT formation.label, formation.prof_Referent, filiere.label, filiere.responsable "
                    + "FROM formation INNER JOIN filiere WHERE formation.filiere = filiere.id"; 
            Connection connection = ConnectionDatabase.getDbConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
             System.out.println("rs");
             System.out.println(rs);
             
            while(rs.next()){
               Formation  row = new Formation(); 
                row.Label.set(rs.getString("label"));
                row.profRef.set(rs.getString("prof_Referent"));

                //row.filiere.label.set(rs.getString("label")) ;
                //row.filiere.responsable.set(rs.getString("responsable"));
                list.add(row);
                
              /*  list.add(rs.getString("Label"));
                list.add(rs.getString("filiere.label"));
                list.add(rs.getString("prof_Referent"));
                list.add(rs.getString("responsable"));*/
            }
                            
        } catch (SQLException error) {

            System.out.println(error.getMessage());
        }
            return list; 
    }
}
