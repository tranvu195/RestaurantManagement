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
public class PlatEnDetail {
    private Plat plat;
    private int nombreIg;
    private int nombrePlat;
    
    public PlatEnDetail(){
        nombrePlat = 0;
        nombreIg = 0;
        plat = null;
    }
    
    public Plat getPlat(){
        return this.plat;
    }
    
    public void setPlat(Plat p){
        this.plat = p;
    }
        
    public int getNombrePlat(){
        return this.nombrePlat;
    }
    
    public void setNombrePlat(int num){
        this.nombrePlat = num;
    }
    
    public int getNombreIg(){
        return this.nombreIg;
    }
    
    public void setNombreIg(int i){
        this.nombreIg = i;
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
