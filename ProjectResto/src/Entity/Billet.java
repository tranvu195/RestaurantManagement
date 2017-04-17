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
public class Billet implements Serializable {
    private String idBillet;
    private String DateTime;
    private String IDTable;
    private String IDPerson;
    private double PrixTotal;
    private int isFini;
    private int Payer;
    
    public Billet(){
        idBillet = null;
        DateTime = null;
        IDTable = null;
        IDPerson = null;
        PrixTotal = 0;
        isFini = 0;
        Payer = 0;
    }
    
    public String getIdBillet(){
        return idBillet;
    }
    
    public void setIdBillet(String id){
        this.idBillet = id;
    }
    
    public String getDateTime(){
        return DateTime;
    }
    
    public void setDateTime(String time){
        this.DateTime = time;
    }
    
    public String getIdTable(){
        return IDTable;
    }
    
    public void setIdTable(String id){
        this.IDTable = id;
    }
    
    public String getIdPersonnel(){
        return IDPerson;
    }
    
    public void setIdPersonnel(String id){
        this.IDPerson = id;
    }
    
    
    public double getPrixTotal(){
        return this.PrixTotal;
    }
    
    public void setPrixTotal(double prix){
        this.PrixTotal = prix;
    }
    
    public void setFini(int i){
        this.isFini = i;
    }
    
    public int getFini(){
        return this.isFini;
    }
    
    public void setPayer(int i){
        this.Payer = i;
    }
    
    public int getPayer(){
        return this.Payer;
    }
    
    public boolean aujouter(){
        return true;
    }
    
    public boolean imprimer(){
        return true;
    }
}
