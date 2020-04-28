/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.Dashboard.formation;

import admin.Dashboard.filiere.Filiere;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author carter
 */
public class Formation {
    public SimpleStringProperty Label = new SimpleStringProperty();
    public SimpleStringProperty profRef = new SimpleStringProperty();

    public Filiere filiere = new Filiere(); 

    
    public String getLabel() {
        return Label.get();
    }
 
    public void setLabel(String Label) {
        this.Label.set(Label);
    }
    
    public String getProfRef(){
        return profRef.get();
    }
    
    public void setProfRef(String profRef){
    this.profRef.set(profRef);
    }
    
    public Filiere getFiLiere(){
        return filiere;
    }
    
    public void setFiliere(Filiere filiere){
        this.filiere.set(filiere); 
    }
}
