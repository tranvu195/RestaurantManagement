package DLL;


import DAL.BilletDAL;
import Entity.Billet;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class BilletDLL {
    BilletDAL DALBill = new BilletDAL();
    
    public ArrayList<Billet> getBillet(){
        return DALBill.getBillet();
    }
    
    public void finiBillet(String id){
        DALBill.finiBillet(id);
    }
    
    public Billet getPayBillet(String idTable){
        return DALBill.getPayBillet(idTable);
    }
}
