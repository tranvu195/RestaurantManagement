/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.*;

/**
 *
 * @author Lucas
 */
public class Personnel  implements Serializable{
    private String idPersonnel;
    private String NomPersonnel;
    private String NomUsager;
    private String MotDePass;
    private String DateNaissance;
    private String Role;
    
    public Personnel(){
        idPersonnel = null;
        NomPersonnel = null;
        NomUsager = null;
        MotDePass = null;
        DateNaissance = null;
        Role = null;
    }
    
    public String getIdPersonnel(){
        return this.idPersonnel;
    }
    
    public void setIdPersonnel(String id){
        this.idPersonnel = id;
    }
    
    public String getNomPersonnel(){
        return this.NomPersonnel;
    }
    
    public void setNomPersonnel(String nom){
        this.NomPersonnel = nom;
    }
    
    public String getNomUsager(){
        return this.NomUsager;
    }
    
    public void setNomUsager(String User){
        this.NomUsager = User;
    }
    
    public String getMotDePass(){
        return this.MotDePass;
    }
    
    public void setMotDePass(String mot){
        this.MotDePass = mot;
    }
    
    public String getDateNaissance(){
        return this.DateNaissance;
    }
    
    public void setDateNaissance(String time){
        this.DateNaissance = time;
    }
    public String getRole(){
        return this.Role;
    }
    
    public void setRole(String role){
        this.Role = role;
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
