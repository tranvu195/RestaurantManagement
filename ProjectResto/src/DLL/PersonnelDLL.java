/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.PersonnelDAL;
import Entity.*;

/**
 *
 * @author Lucas
 */
public class PersonnelDLL {
    PersonnelDAL dal = new PersonnelDAL();
    
    public boolean getLogin(String nU, String mP){
        return dal.getLogin(nU, mP);
    }
    
    public String getRolePer(String user){
        return dal.getRolePer(user);
    }
    
    public Personnel getPer(String nU, String mP){
        return dal.getPer(nU, mP);
    }
}
