/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
import Entity.*;
import javax.sound.sampled.*;
import javax.swing.table.*;
/**
 *
 * @author Lucas
 */
public class ChefCuisine extends JFrame {
    String user;
    Socket sock;
    ObjectOutputStream output;
    ObjectInputStream input;
    String message = "";
    Personnel per = new Personnel();
    ArrayList<Entity.Billet> listeBillet;

    /**
     * Creates new form ChefCuisine
     */
    public ChefCuisine() {
        initComponents();
        listeBillet = new ArrayList();
        connect();
        th1.start();
    }
    
    public ChefCuisine(Personnel p){
        per = p;
        initComponents();
        listeBillet = new ArrayList();
        connect();
        th1.start();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pScroll = new javax.swing.JScrollPane();
        tablePlat = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatBox = new javax.swing.JTextArea();
        bAnuller = new javax.swing.JButton();
        Finir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pScroll.setFont(new java.awt.Font("UTM Androgyne", 2, 10)); // NOI18N

        tablePlat.setBackground(new java.awt.Color(255, 204, 204));
        tablePlat.setFont(new java.awt.Font("UTM Androgyne", 0, 10)); // NOI18N
        tablePlat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDBillet", "Table", "Date time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePlat.getTableHeader().setReorderingAllowed(false);
        pScroll.setViewportView(tablePlat);
        if (tablePlat.getColumnModel().getColumnCount() > 0) {
            tablePlat.getColumnModel().getColumn(0).setResizable(false);
            tablePlat.getColumnModel().getColumn(1).setResizable(false);
            tablePlat.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(pScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 102, 370, 360));

        chatBox.setEditable(false);
        chatBox.setColumns(20);
        chatBox.setLineWrap(true);
        chatBox.setRows(5);
        chatBox.setCaretColor(new java.awt.Color(255, 204, 204));
        chatBox.setOpaque(false);
        jScrollPane1.setViewportView(chatBox);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 102, 210, 360));

        bAnuller.setBackground(new java.awt.Color(255, 240, 211));
        bAnuller.setFont(new java.awt.Font("UTM Androgyne", 0, 14)); // NOI18N
        bAnuller.setText("Annuler");
        bAnuller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnullerActionPerformed(evt);
            }
        });
        getContentPane().add(bAnuller, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 170, 40));

        Finir.setBackground(new java.awt.Color(255, 240, 211));
        Finir.setFont(new java.awt.Font("UTM Androgyne", 2, 14)); // NOI18N
        Finir.setText("Finir");
        Finir.setToolTipText("");
        Finir.setAutoscrolls(true);
        Finir.setBorderPainted(false);
        Finir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinirActionPerformed(evt);
            }
        });
        getContentPane().add(Finir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 160, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ChefdeCuisine.png"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 649, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAnullerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnullerActionPerformed
        message = "END CONNEXION DE PER";
        
        try{
            output.writeObject(message);
            output.flush();
            
            output.close();
            input.close();
            sock.close();
            this.dispose();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bAnullerActionPerformed
    
    private void FinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinirActionPerformed
        message = "CHEF - FINIR DE PLAT";
      
        //-----Check 
        System.out.println(message);
        //------
        
        try{
            output.writeObject(message);
            output.flush();
            output.writeObject(listeBillet.get(0).getIdBillet());
            
        //-----Check 
        System.out.println(message);
        //------
        
        }
        
        catch(Exception e){
            e.printStackTrace();
        } 
        
    }//GEN-LAST:event_FinirActionPerformed
    
    //-------------------- PRENDRE LES BILLET-----------------
    Thread th1 = new Thread(){
        public void run(){
            message = "CHEF - BILLET EN COURS";
           
            try{
                output.writeObject(message);
                output.flush();
                
            }
            catch(Exception e){
                e.printStackTrace();
            } 
        }
        
    };
    
    //---------AFFICHER TABLE------
    public void afficheDansTable(ArrayList<Billet> billets){
       
        DefaultTableModel model =(DefaultTableModel) tablePlat.getModel();
        while(model.getRowCount() > 0){
            int i = model.getRowCount() - 1;
            model.removeRow(i);
            i--;
        }
        for(int i = 0; i < billets.size();i++){
            model.addRow(new Object[] {billets.get(i).getIdBillet(), billets.get(i).getIdTable(), billets.get(i).getDateTime()});
        }
    }
    
    
    
    //------------------INSTALLER CONNEXION A ADMIN-------------------------
    
    public class IncomingReader implements Runnable{

        @Override
        public void run() {
            try {  
                message = (String) input.readObject();
                while(!message.equals("SERVER - NULL")){

                        

                        if(message.equals("CHEF - VOTRE BILLET")){
                            chatBox.append(message + "\n");
                            listeBillet = new ArrayList ((ArrayList<Entity.Billet>) input.readObject());
                            afficheDansTable(listeBillet);

                            try {
                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\Sounds\\notify.wav").getAbsoluteFile());
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioInputStream);
                                clip.start();
                            }catch(Exception x) { x.printStackTrace(); }
                            message = "";
                            }


                        else if(message.equals("CLIENT - END")){
                            input.close();
                            output.close();
                            sock.close();

                        }

                        else if (message.equals("FROM SERVER")){
                            chatBox.append(message + "\n");

                            message = (String) input.readObject();
                            if(message != null){
                            chatBox.append(message + "\n");}
                        }

                }
                   
            } catch (IOException ex) {
                chatBox.append("Connexion erreur... \n");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChefCuisine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void closeConnexion(){
        try{
            output.writeObject("END CONNEXION DE PER");
            output.flush();
            input.close();
            output.close();
            sock.close();
        } catch (Exception e){
            chatBox.append("Desactive erreur.... \n");
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
            output.writeObject("CHEF CONNECT \n");
            output.flush();
            message = (String) input.readObject();
            chatBox.append(message + "\n");
           
            ListenChat();
            
        }
        catch(Exception e){
            chatBox.append("Can not connect to server.... \n");
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
            java.util.logging.Logger.getLogger(ChefCuisine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChefCuisine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChefCuisine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChefCuisine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChefCuisine cc = new ChefCuisine();
                cc.setVisible(true);
                cc.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Finir;
    private javax.swing.JButton bAnuller;
    private javax.swing.JTextArea chatBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane pScroll;
    private javax.swing.JTable tablePlat;
    // End of variables declaration//GEN-END:variables
}
