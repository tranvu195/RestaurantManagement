/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class DataAccessHelper {
 protected java.sql.Connection con;
    

    String dbName = "demo";
    String user = "root";
    String pass = "123456";
    String driver = "com.mysql.jdbc.Driver" ; 
    String URL = "jdbc:mysql://localhost:3306/" + dbName ;
    
    public void getConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex){
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
