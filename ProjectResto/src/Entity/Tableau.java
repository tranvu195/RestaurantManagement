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
public class Tableau {
    private String idTableau;
    private String Position;
    private int nombreChaise;
    
    public Tableau(){
        idTableau = null;
        Position = null;
        nombreChaise = 0;
    }  
    
    /**
     * Prendre numero identifie de table
     * @return numero identifie de table
     */
    public String getIdTableau(){
        return this.idTableau;
    }
    
    /**
     * atribuer Id de Table avec un numero 
     * @param id 
     * atribuer idTableau = id 
     */
    public void setIdTbaleau(String id){
        this.idTableau = id;
    }
    
    public String getPosition(){
        return this.Position;
    }
    
    public void setPosition(String pos){
        this.Position = pos;
    }
    
    public int getNombreChaise(){
        return this.nombreChaise;
    } 
    
    public void setNombreChaise(int num){
        this.nombreChaise = num;
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
    
    public boolean statut()
    {
        return true;
    }
    
}
