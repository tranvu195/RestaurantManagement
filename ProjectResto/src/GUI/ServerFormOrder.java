/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author ASUS
 */
public class ServerFormOrder extends java.awt.Frame {
    /**
     * Creates new form ServerFormOrder
     */
    public ServerFormOrder() {
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
        Total = new javax.swing.JTextArea();
        BilletTableScroll = new javax.swing.JScrollPane();
        BilletTable = new javax.swing.JTable();
        Envoyer = new javax.swing.JLabel();
        Plus = new javax.swing.JLabel();
        Minus = new javax.swing.JLabel();
        Food6 = new javax.swing.JLabel();
        Food5 = new javax.swing.JLabel();
        Food4 = new javax.swing.JLabel();
        Food3 = new javax.swing.JLabel();
        Food2 = new javax.swing.JLabel();
        Food1 = new javax.swing.JLabel();
        TableButton = new javax.swing.JLabel();
        ServerFormOrderBG = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(652, 652));
        setUndecorated(true);
        setSize(new java.awt.Dimension(652, 652));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NotiScroll.setBorder(null);

        Noti.setColumns(20);
        Noti.setRows(5);
        NotiScroll.setViewportView(Noti);

        add(NotiScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 539, 249, 71));

        Total.setColumns(20);
        Total.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        Total.setRows(5);
        Total.setBorder(null);
        add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 166, 26));

        BilletTableScroll.setBackground(new java.awt.Color(255, 255, 255));
        BilletTableScroll.setBorder(null);

        BilletTable.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        BilletTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        BilletTableScroll.setViewportView(BilletTable);

        add(BilletTableScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 35, 227, 383));
        add(Envoyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 480, 230, 40));
        add(Plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 450, 114, 30));
        add(Minus, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 112, 30));
        add(Food6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 130, 120));
        add(Food5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 120, 120));
        add(Food4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 120, 120));
        add(Food3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 110, 120));
        add(Food2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 85, 140, 125));
        add(Food1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 110, 120));

        TableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableButtonMouseClicked(evt);
            }
        });
        add(TableButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 326, 46));

        ServerFormOrderBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ServerFormOrder.png"))); // NOI18N
        ServerFormOrderBG.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                ServerFormOrderBGMouseDragged(evt);
            }
        });
        ServerFormOrderBG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ServerFormOrderBGMousePressed(evt);
            }
        });
        add(ServerFormOrderBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 652, 652));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void ServerFormOrderBGMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServerFormOrderBGMouseDragged

    }//GEN-LAST:event_ServerFormOrderBGMouseDragged

    private void ServerFormOrderBGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServerFormOrderBGMousePressed

    }//GEN-LAST:event_ServerFormOrderBGMousePressed

    private void TableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableButtonMouseClicked
        this.setVisible(false);
        ServerFormTable sft = new ServerFormTable();
        sft.setVisible(true);
        sft.setLocationRelativeTo(null);
    }//GEN-LAST:event_TableButtonMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BilletTable;
    private javax.swing.JScrollPane BilletTableScroll;
    private javax.swing.JLabel Envoyer;
    private javax.swing.JLabel Food1;
    private javax.swing.JLabel Food2;
    private javax.swing.JLabel Food3;
    private javax.swing.JLabel Food4;
    private javax.swing.JLabel Food5;
    private javax.swing.JLabel Food6;
    private javax.swing.JLabel Minus;
    private javax.swing.JTextArea Noti;
    private javax.swing.JScrollPane NotiScroll;
    private javax.swing.JLabel Plus;
    private javax.swing.JLabel ServerFormOrderBG;
    private javax.swing.JLabel TableButton;
    private javax.swing.JTextArea Total;
    // End of variables declaration//GEN-END:variables
}