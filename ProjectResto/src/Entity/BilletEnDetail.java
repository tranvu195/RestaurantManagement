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
public class BilletEnDetail {
    private Billet bill;
    private Plat[] plat;
    private int nombrePlat;
    private double Prix;
    
    public BilletEnDetail(){
        bill = new Billet();
        plat = new Plat[nombrePlat];
        nombrePlat = 0;
        Prix = 0;
    }
    
    public Billet getBillet(){
        return this.bill;
    }
    
    public void setBillet(Billet fracture){
        this.bill = fracture;
    }
    
    public Plat[] getPlat(){
        return this.plat;
    }
    
    public void setPlat(Plat[] plats){
        this.plat = plats;
    }
    
    public int getNombrePlat(){
        return this.nombrePlat;
    }
    
    public void setNombrePlat(int nombre){
        this.nombrePlat = nombre;
    }
    
    public double getPrix(){
        return this.Prix;
    }
    
    public void setPrix(double p){
        this.Prix = p;
    }
    
    public boolean aujouter(){
        return true;
    }
    
    public boolean supprimer(){
        return true;
    }
    
    public double sommeBillet(){
        return 0;
    }
}
