/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.Dashboard.filiere;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author carter
 */
public class Filiere {
    
    public SimpleStringProperty label = new SimpleStringProperty();
    public SimpleStringProperty responsable = new SimpleStringProperty();

    
     
    public String getLabel() {
        return label.get();
    }
 
    public void setLabel(String label) {
        this.label.set(label);
    }
    
    public String getResponsable() {
        return responsable.get();
    }
 
    public void setResponsable(String responsable) {
        this.responsable.set(responsable);
    }

    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void set(Filiere filiere) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
       

}
