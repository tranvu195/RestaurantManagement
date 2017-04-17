/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.*;
/**
 *
 * @author ASUS
 */
public class ServerFormTable extends java.awt.Frame {
    Personnel per = new Personnel();
    /**
     * Creates new form ServerFormTable
     */
    public ServerFormTable() {
        initComponents();
    }
    
    public ServerFormTable(Personnel p){
        per = p;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NotiScroll = new javax.swing.JScrollPane();
        Noti = new javax.swing.JTextArea();
        Table9 = new javax.swing.JLabel();
        Table8 = new javax.swing.JLabel();
        Table7 = new javax.swing.JLabel();
        Table6 = new javax.swing.JLabel();
        Table5 = new javax.swing.JLabel();
        Table4 = new javax.swing.JLabel();
        Table3 = new javax.swing.JLabel();
        Table2 = new javax.swing.JLabel();
        Table1 = new javax.swing.JLabel();
        OrderButton = new javax.swing.JLabel();
        ServerFormTableBG = new javax.swing.JLabel();

        setUndecorated(true);
        setSize(new java.awt.Dimension(652, 652));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NotiScroll.setBorder(null);
        NotiScroll.setFocusable(false);
        NotiScroll.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N

        Noti.setColumns(20);
        Noti.setRows(5);
        NotiScroll.setViewportView(Noti);

        add(NotiScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 539, 249, 71));
        add(Table9, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 372, 172, 122));

        Table8.setToolTipText("");
        add(Table8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 372, 172, 122));
        add(Table7, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 374, 172, 122));
        add(Table6, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 222, 172, 122));
        add(Table5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 172, 122));
        add(Table4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 223, 172, 122));
        add(Table3, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 71, 172, 122));
        add(Table2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 172, 122));
        add(Table1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 71, 172, 122));

        OrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderButtonMouseClicked(evt);
            }
        });
        add(OrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 3, 322, 40));

        ServerFormTableBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ServerFormTable.png"))); // NOI18N
        ServerFormTableBG.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                ServerFormTableBGMouseDragged(evt);
            }
        });
        ServerFormTableBG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ServerFormTableBGMousePressed(evt);
            }
        });
        add(ServerFormTableBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 652, 652));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void ServerFormTableBGMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServerFormTableBGMouseDragged

    }//GEN-LAST:event_ServerFormTableBGMouseDragged

    private void ServerFormTableBGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServerFormTableBGMousePressed

    }//GEN-LAST:event_ServerFormTableBGMousePressed

    private void OrderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderButtonMouseClicked
        this.setVisible(false);
        ServerFormOrder sfo = new ServerFormOrder();
        sfo.setVisible(true);
        sfo.setLocationRelativeTo(null);
    }//GEN-LAST:event_OrderButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ServerFormTable sft = new ServerFormTable();
        sft.setVisible(true);
        sft.setLocationRelativeTo(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Noti;
    private javax.swing.JScrollPane NotiScroll;
    private javax.swing.JLabel OrderButton;
    private javax.swing.JLabel ServerFormTableBG;
    private javax.swing.JLabel Table1;
    private javax.swing.JLabel Table2;
    private javax.swing.JLabel Table3;
    private javax.swing.JLabel Table4;
    private javax.swing.JLabel Table5;
    private javax.swing.JLabel Table6;
    private javax.swing.JLabel Table7;
    private javax.swing.JLabel Table8;
    private javax.swing.JLabel Table9;
    // End of variables declaration//GEN-END:variables
}
