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
public class Plat {
    private String idPlat;
    private String nomPlat;
    private double PrixPlat;
    
    public Plat(){
        idPlat = null;
        nomPlat = null;
        PrixPlat = 0;
    }
    
    public String getIdPlat(){
        return this.idPlat;
    }
    
    public void setIdPlat(String id){
        this.idPlat = id;
    }
    
    public String getNomPlat(){
        return this.nomPlat;
    }
    
    public void setNomPlat(String nom){
        this.nomPlat = nom;
    }
    
    public double getPrixPlat(){
        return this.PrixPlat;
    }
    
    public void setPrixPlat(double prix){
        this.PrixPlat = prix;
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
