/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.*;
import Entity.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class LoginForm extends java.awt.Frame {
    int xMouse;
    int yMouse;
    
    String user;
    Socket sock;
    ObjectOutputStream output;
    ObjectInputStream input;
    String message = ""; 
    PersonnelDLL Per = new PersonnelDLL();
    
    
    /**
     * Creates new form LoginForn
     */
    public LoginForm() {
//        IDLogin = new JTextField();
//        IDLogin.setText("");
//        PassLogin = new JPasswordField();
//        PassLogin.setText("");
        initComponents();
        connect();
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bAnnuler = new javax.swing.JButton();
        bConnexion = new javax.swing.JButton();
        PassLogin = new javax.swing.JPasswordField();
        IDLogin = new javax.swing.JTextField();
        LoginForm = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(652, 652));
        setUndecorated(true);
        setSize(new java.awt.Dimension(652, 652));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bAnnuler.setBackground(new java.awt.Color(255, 240, 211));
        bAnnuler.setFont(new java.awt.Font("UTM Androgyne", 0, 14)); // NOI18N
        bAnnuler.setText("Annuler");
        bAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnnulerActionPerformed(evt);
            }
        });
        add(bAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 448, 110, 50));

        bConnexion.setBackground(new java.awt.Color(255, 240, 211));
        bConnexion.setFont(new java.awt.Font("UTM Androgyne", 0, 14)); // NOI18N
        bConnexion.setText("Connexion");
        bConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConnexionActionPerformed(evt);
            }
        });
        add(bConnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 110, 50));

        PassLogin.setBackground(new java.awt.Color(255, 240, 211));
        PassLogin.setBorder(null);
        add(PassLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 350, 226, 18));

        IDLogin.setBackground(new java.awt.Color(255, 240, 211));
        IDLogin.setBorder(null);
        IDLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLoginActionPerformed(evt);
            }
        });
        add(IDLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 276, 226, 18));

        LoginForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LoginForm.png"))); // NOI18N
        LoginForm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                LoginFormMouseDragged(evt);
            }
        });
        LoginForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginFormMousePressed(evt);
            }
        });
        add(LoginForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 652, 652));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void LoginFormMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginFormMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_LoginFormMousePressed

    private void LoginFormMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginFormMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_LoginFormMouseDragged

    private void IDLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDLoginActionPerformed

    private void bConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConnexionActionPerformed
        ArrayList<String> compte = new ArrayList();
        compte.add(IDLogin.getText());
        compte.add(new String(PassLogin.getPassword()));
                
        message =  "CHECK - LOGIN";

        try{
            output.writeObject(message);
            
            output.flush();
            output.writeObject(compte);
            output.flush();
        } catch(Exception e){
            e.printStackTrace();
            afficheNoti();
        }
    }//GEN-LAST:event_bConnexionActionPerformed

    private void bAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnnulerActionPerformed
        closeConnexion();
    }//GEN-LAST:event_bAnnulerActionPerformed
    
    //------------------DISPOSE FORM---------------------
    public void afficheNoti(){
        LoginFail lg = new LoginFail();
        lg.setVisible(true);
        lg.setLocationRelativeTo(null);
        this.dispose();
        
    }
    public void disposeForm(){
        this.dispose();
    }
    
    //------------------INSTALLER CONNEXION A ADMIN---------------
    
    public class IncomingReader implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println(input.readObject());
                    String message = (String) input.readObject();
                    System.out.println(message);
                    while(!message.equals("SERVER - NULL")){
                        if(message.equals("CHECK - LOGIN RETURN")){
                        
                        int role = (int) input.readObject();
                        System.out.println("Login " + role);
                        Personnel per = (Personnel) input.readObject();
                        
                        System.out.println("Login : " + per.getIdPersonnel());
                        switch(role){
                            case 1:
                                ChefCuisine ch = new ChefCuisine(per);
                                ch.setVisible(true);
                                ch.setLocationRelativeTo(null);
                                disposeForm();
                                break;
                            case 2:
                                Caisse ca = new Caisse(per);
                                ca.setVisible(true);
                                ca.setLocationRelativeTo(null);
                                disposeForm();
                                break;
                            case 3:
                                ServerFormTable se = new ServerFormTable(per);
                                se.setVisible(true);
                                se.setLocationRelativeTo(null);
                                disposeForm();
                                break;
                            default:
                                afficheNoti();
                        }
                        message = "SERVER - NULL";
                        closeConnexion();
                        }
                    }
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                
            
        }
        
    }
    
    //-----------------------------SUPPRIMER CONNECTION-----------------------
    public void closeConnexion(){
        try{
            output.writeObject("END CONNEXION DE PER");
            output.flush();
            input.close();
            output.close();
            sock.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this , "NE PEUT DECONEXION");
        }
    }
    
    public void ListenChat(){
        Thread Incoming = new Thread(new IncomingReader());
        Incoming.start();
    }
    
    public void connect(){
        try{
            sock = new Socket("localhost", 8064);
            output = new ObjectOutputStream(sock.getOutputStream());
            output.flush();
            input = new ObjectInputStream(sock.getInputStream());
            output.writeObject("FORM ATTENDANT");
            output.flush();
            ListenChat();
            
        }
        catch(Exception e){
            afficheNoti();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LoginForm lgi = new LoginForm();
        lgi.setVisible(true);
        lgi.setLocationRelativeTo(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDLogin;
    private javax.swing.JLabel LoginForm;
    private javax.swing.JPasswordField PassLogin;
    private javax.swing.JButton bAnnuler;
    private javax.swing.JButton bConnexion;
    // End of variables declaration//GEN-END:variables
}

