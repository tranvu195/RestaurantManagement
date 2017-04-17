/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.*;
import Entity.*;

/**
 *
 * @author Lucas
 */
public class PersonnelDAL extends DataAccessHelper{
    private final String GET_LOGIN = "select * from personnel per where per.NomUsager= ? and per.MotDePasse=?";
    private final String GET_ROLE =  "select * from personnel per where per.NomUsager = ?;";
    
    public boolean getLogin(String nU, String mp){
        boolean check = false;
        try{
            getConnection();
            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
            ps.setString(1, nU);
            ps.setString(2, mp);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                check = true;
            }
            
            closeConnection();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return check;
    }
    
    public String getRolePer(String user){
        String role = "";
        try{
           getConnection();
           PreparedStatement ps = con.prepareStatement(GET_ROLE);
           ps.setString(1, user);
           System.out.println(user);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               role = rs.getString("RoleP");
                System.out.println(role);
           }
           closeConnection();
        }catch(Exception e){
           e.printStackTrace();
        }
        
        return role; 
    }
    
    public Personnel getPer(String nU, String mp){
        Personnel item = new Personnel();
        try{
            getConnection();
            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
            ps.setString(1, nU);
            ps.setString(2, mp);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                item.setIdPersonnel(rs.getString("IDPersonnel"));
                item.setRole("RoleP");
                item.setNomPersonnel("Nom");
                item.setDateNaissance("DateDeNaissance");
                item.setNomUsager(user);
                item.setMotDePass(mp);
            }
            
            closeConnection();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return item;
    }
}
