/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class LoginFail extends javax.swing.JFrame {
    int xMouseLF;
    int yMouseLF;
    /** Creates new form LoginFail */
    public LoginFail() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        LoginFailAn = new javax.swing.JLabel();
        LoginFailBG = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginFailAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginFailAnMouseClicked(evt);
            }
        });
        getContentPane().add(LoginFailAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 100, 40));

        LoginFailBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LoginFail.png"))); // NOI18N
        LoginFailBG.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                LoginFailBGMouseDragged(evt);
            }
        });
        LoginFailBG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginFailBGMousePressed(evt);
            }
        });
        getContentPane().add(LoginFailBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginFailAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginFailAnMouseClicked
        this.setVisible(false);
        LoginForm lgi = new LoginForm();
        lgi.setVisible(true);
        lgi.setLocationRelativeTo(null);
    }//GEN-LAST:event_LoginFailAnMouseClicked

    private void LoginFailBGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginFailBGMousePressed
        xMouseLF = evt.getX();
        yMouseLF = evt.getY();
    }//GEN-LAST:event_LoginFailBGMousePressed

    private void LoginFailBGMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginFailBGMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouseLF , y - yMouseLF);
    }//GEN-LAST:event_LoginFailBGMouseDragged
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginFailAn;
    private javax.swing.JLabel LoginFailBG;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}