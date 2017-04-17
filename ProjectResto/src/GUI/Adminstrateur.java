/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.*;
import Entity.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.logging.*;

/**
 *
 * @author Lucas
 */
public class Adminstrateur extends javax.swing.JFrame {
    ArrayList empOutputStreams;
    ArrayList<String> employees;
   
    ObjectOutputStream output;
    
    BilletDLL billDLL;
    PersonnelDLL perDLL;
    
    

//    private ObjectInputStream input;
    private String message = "";
  //  private Socket sock;
    
    
    
    
    /**
     * Creates new form Adminstrateur
     */
    public Adminstrateur() {
        billDLL = new BilletDLL();
        perDLL = new PersonnelDLL();
        initComponents();
        Thread starter = new Thread(new startAdmin());
        starter.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chatBox = new javax.swing.JTextArea();
        chatText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(652, 652));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chatBox.setEditable(false);
        chatBox.setColumns(20);
        chatBox.setLineWrap(true);
        chatBox.setRows(5);
        chatBox.setBorder(null);
        chatBox.setOpaque(false);
        jScrollPane1.setViewportView(chatBox);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 560, 410));

        chatText.setBorder(null);
        chatText.setOpaque(false);
        chatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatTextActionPerformed(evt);
            }
        });
        getContentPane().add(chatText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 540, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Admin.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 652, 652));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatTextActionPerformed
        
        message = chatText.getText();
        chatText.setText("");
        tellEveryone(message);
        
    }//GEN-LAST:event_chatTextActionPerformed
    
    //********************GESTION DE PERSONNEL***************
    public int checkCompte(String user, String mdp){
        int r = 0;
        if (perDLL.getLogin(user, mdp)){
            String role = perDLL.getRolePer(user);
            System.out.println("Admin : role : " + role);
            if(role.equals("chef")){
                r = 1;
            }
            else if(role.equals("caisse")){
                r = 2;
            }
            else if(role.equals("serveur")){
                r = 3;
            }
        }
        else{
            return r;
        }
        return  r;
    }
    
    
    
    //********************GESTION DE CHEF CUISINE*************************
    //------------------ENVOYER LISTE DES BILLETS-------------
    public void envoyerBillet(){
        message = "CHEF - VOTRE BILLET";
        try{
            output.writeObject(message);
            ArrayList<Entity.Billet> objs = new ArrayList(billDLL.getBillet());
 
            output.writeObject(objs);
            output.flush();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //----------------FINI BILLET---------
    public void finiBillet(String idBillet){
        billDLL.finiBillet(idBillet);
    }
    
    
    
    //-----------------CONTROLE LE CONNEXION-------------
    //----------------EMPLOYEES CONNEXION
    public class employConnect implements Runnable{
        
        ObjectInputStream empInput;
        Socket emp;
        ObjectOutputStream empOutput;
        
        public employConnect(Socket empSock, ObjectOutputStream empOut){
           
            empOutput = empOut;
            
            try{
                emp = empSock; 
                empInput = new ObjectInputStream(emp.getInputStream());
                String mes = (String) empInput.readObject();
                chatBox.append(mes + "\n");
            } catch (Exception e){
               e.printStackTrace();
            }
        }
        
        public void run(){
            try{
              
                System.out.println("Received tren : " + message);
                message = (String) empInput.readObject();
                System.out.println("Received duoi : " + message);
                do{
                    //--------------------ATTENDANT MESSAGE DE LOGINFORM --------------------
                    if(message.equals("CHECK - LOGIN")){
                        
                        ArrayList<String> compte;
                        compte = new  ArrayList((ArrayList<String>) empInput.readObject());
                        Personnel per = new Personnel();
                        int check = 0;
                        check = checkCompte(compte.get(0), compte.get(1));
                        per = perDLL.getPer(compte.get(0), compte.get(1));
                        
                        System.out.println("Admin : " + per.getIdPersonnel());
                        output.writeObject("CHECK - LOGIN RETURN");
                        output.flush();
                        output.writeObject(check);
                        output.writeObject(per);
                        output.flush();
                        
                    }
                    
                    
                    //--------------------ATTENDANT MESSAGE DE CHEF CUISINE--------
                    
                    if (message.equals("CHEF - BILLET EN COURS")){
                        chatBox.append(message + "\n");
                        envoyerBillet();
                    }
                        
                    if (message.equals("CHEF - FINIR DE PLAT")){
                        String id = (String) empInput.readObject();
                        finiBillet(id);
                        envoyerBillet();
                        tellEveryone("TABLE " + id + " EST FINI");
                    }
                    
                    //---------------------ATTENDANT MESSAGE DE CAISSE-------------------
                    if(message.equals("DE BILLET FORM A ADMIN - AFFICHE BILLET")){
                        Billet b = new Billet();
                        String idTable = (String) empInput.readObject();
                        b = billDLL.getPayBillet(idTable);
                        System.out.println(b.getIdBillet());
                        output.writeObject("DE SERVER A BILLET FORM - AFFICHE BILLET");
                        output.flush();
                        output.writeObject(b);
                    }
                    
                    
                    
                    
                    //---------------------ATTENDANT MESSAGE DE SERVEUR----------------
                    
                    
                    
                    
                }while (!message.equals("END CONNEXION DE PER"));
            } catch(Exception e){
                e.printStackTrace();
            } finally {
                try {
                    output.writeObject("SERVER - NULL");
                        output.flush();
                        empInput.close();
                        empOutput.close();
                    emp.close();
                } catch (IOException ex) {
                    Logger.getLogger(Adminstrateur.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
        }
    
    }
    
    //--------------------CREER SERVER------------------------
    public class startAdmin implements Runnable{
        
        public void run(){
            empOutputStreams = new ArrayList();
            employees = new ArrayList();
            chatBox.append("----------------------------------------ATTENDRE CONNEXION------------------------------------- \n");
            
            try {
                ServerSocket sock = new ServerSocket(8064);
                
                while (true){
                    Socket empSock = sock.accept();
                    
                    message = "PERMETRE CONECTER \n";
                    
                    output = new ObjectOutputStream(empSock.getOutputStream());
                    output.writeObject(message);
                    output.flush();
                    empOutputStreams.add(output);
                   
                    Thread listener = new Thread(new employConnect(empSock, output));
                    listener.start();
                }
            } catch (IOException ex) {
                chatBox.append("CONNEXION ERREUR......\n");
            }
        }
    }
    
    //-----------Tell everyone-----------
    public void tellEveryone(String mes){
       
	Iterator it = empOutputStreams.iterator();

        while (it.hasNext()) 
        { 
            ObjectOutputStream out = (ObjectOutputStream) it.next();
          
            try 
            {
                message = "FROM SERVER";
		out.writeObject(message);
                out.flush();
                out.writeObject(mes);
		chatBox.append("Sending: " + mes + "\n");
                out.flush();
                chatBox.setCaretPosition(chatBox.getDocument().getLength());    

            } 
            catch (Exception ex) 
            {
		chatBox.append("Error telling everyone. \n");
            }
        } 
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adminstrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adminstrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adminstrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adminstrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Adminstrateur ad = new Adminstrateur();
                ad.setVisible(true);
                ad.setLocationRelativeTo(null);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatBox;
    private javax.swing.JTextField chatText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
