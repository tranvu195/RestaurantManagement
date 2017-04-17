/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Lucas
 */
public class Repartissant {
    private Personnel Person;
    private String DateTime;
    private int Cas;
    
    public Repartissant(){
        Person = new Personnel();
        DateTime = null;
        Cas = 0;
    }
    
    public Personnel getPersonnel(){
        return this.Person;
    }
    
    public void setPersonnel(Personnel p){
        this.Person = p;
    }
    
    public String getDateTime(){
        return this.DateTime;
    }
    
    public void setDateTime(String time){
        this.DateTime = time;
    }
    
    public int getCas(){
        return this.Cas;
    }
    
    public void setCas(int c){
        this.Cas = c;
    }
    
    public boolean ajouter(){
        return true;
    }
    
    public boolean supprimer(){
        return true;
    }
    
    public boolean modifier(){
        return true;
    }
}
