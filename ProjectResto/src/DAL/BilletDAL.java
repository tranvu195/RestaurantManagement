/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Lucas
 */
public class BilletDAL extends DataAccessHelper{
    
    //------------------ MySQL query ----------------------//
    String GET_BILLET = "select * from billet bil where bil.Fini = 0 and bil.Paye = 0; ";
    String BILLET_FINI = "update billet bil set bil.Fini = 1 where bil.IDBillet = ?;";
    String GET_PAY_BILLET = "select * from billet bil where bil.IDTable = ? and bil.Paye = 0;";
    
    
//------------------------------------------------------//
   
    
    public ArrayList<Billet> getBillet(){
        ArrayList<Billet> temp = new ArrayList();
        
        try{
            getConnection();
            PreparedStatement ps = con.prepareStatement(GET_BILLET);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                Billet item = new Billet();
                
                item.setIdBillet(rs.getString("IDBillet"));
                item.setDateTime(rs.getString("DateB"));
                item.setIdPersonnel(rs.getString("IDPersonnel"));
                item.setIdTable(rs.getString("IDTable"));
                item.setPrixTotal(Double.parseDouble(rs.getString("PrixTotal")));
                item.setFini(Integer.parseInt(rs.getString("Fini")));
                item.setPayer(Integer.parseInt(rs.getString("Paye")));
               
                temp.add(item);
                }
            }
            closeConnection();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        
        return temp;
    }
    
    public void finiBillet(String id){
        try{
            getConnection();
            PreparedStatement ps = con.prepareStatement(BILLET_FINI);
            ps.setString(1, id);
            ps.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public Billet getPayBillet(String idTable){
        Billet item = new Billet();
        try{
            getConnection();
            PreparedStatement ps = con.prepareStatement(GET_PAY_BILLET);
            ps.setString(1, idTable);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                item.setIdBillet(rs.getString("IDBillet"));
                item.setDateTime(rs.getString("DateB"));
                item.setIdPersonnel(rs.getString("IDPersonnel"));
                item.setIdTable(rs.getString("IDTable"));
                item.setPrixTotal(Double.parseDouble(rs.getString("PrixTotal")));
                item.setFini(Integer.parseInt(rs.getString("Fini")));
                item.setPayer(Integer.parseInt(rs.getString("Paye")));
                System.out.println(item.getIdBillet());
            }
            closeConnection();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return item;
    }
}
