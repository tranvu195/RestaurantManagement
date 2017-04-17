/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.javafx.geom.Shape;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;
import static sun.security.x509.OIDMap.getClass;
/**
 *
 * @author Lucas
 */
public class MainForm {
    
    
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                LoginForm Login = new LoginForm();
                Login.setResizable(false);
                Login.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Logo.png")));
                
            }  
        });
    }
    
}


