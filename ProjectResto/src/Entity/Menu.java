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
public class Menu {
    private String idMenu;
    private String DateTime;
    private Plat[] plat;
    private int nombrePlat;
    
    public Menu(){
        idMenu = null;
        DateTime = null;
        plat = new Plat[nombrePlat];
        nombrePlat = 0;
    }
    
    public String getIdMenu()
    {
        return this.idMenu;
    }
    
    public void setIdMenu(String id){
        this.idMenu = id;
    }
    
    public String getDateTime(){
        return this.DateTime;
    }
    
    public void setDateTime(String time){
        this.DateTime = time;
    }
    
    public Plat[] getPlat(){
        return plat;
    }
    
    public void setPlat(Plat[] plats){
        this.plat = plats;
    }
    
    public int getNombrePlat(){
        return this.nombrePlat;
    }
    
    public void setNombrePlat(int num){
        this.nombrePlat = num;
    }
    
    public boolean ajouterPlat(){
        return true;
    }
    
    public boolean supprimerPlat(){
        return true;
    }
    
    public boolean modifierPlat(){
        return true;
    }
}
