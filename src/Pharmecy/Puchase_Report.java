/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmecy;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mizanur Rahman
 */
public class Puchase_Report extends javax.swing.JFrame {

    /**
     * Creates new form Puchase_Report
     */
    public Puchase_Report() {
        initComponents();
    }
 Purchase_Info pi=new Purchase_Info();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        search = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(null);
        jPanel3.add(jSeparator2);
        jSeparator2.setBounds(837, 99, 270, 0);

        search.setBackground(new java.awt.Color(102, 102, 102));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });
        jPanel3.add(search);
        search.setBounds(980, 60, 180, 30);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/DepartmentPicture/icons8_search_30px_2.png"))); // NOI18N
        jPanel3.add(jLabel15);
        jLabel15.setBounds(950, 60, 30, 40);

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Purchase Reports");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(260, 20, 620, 50);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1410, 120);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Group Name", "Quantity", "Price", "Average Price", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 180, 1030, 402);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/DepartmentPicture/icons8_refresh_25px.png"))); // NOI18N
        jButton1.setText("refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1010, 150, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/DepartmentPicture/Staff_Details.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -60, 1370, 690);

        setSize(new java.awt.Dimension(1223, 659));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
        search.setText("");
    }//GEN-LAST:event_searchMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        // Search pressed enter key
        String id=search.getText();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String m="SELECT `pname`,`name`,`group`,`puQuant`,`price`,`avg_Price`,`Total` FROM `purchage_report` WHERE `pname`='"+id+"' OR `name`='"+id+"'";

            show(m);
           
    }//GEN-LAST:event_searchKeyPressed
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String m="SELECT `pname`,`name`,`group`,`puQuant`,`price`,`avg_Price`,`Total` FROM `purchage_report`";
        show(m);
    }//GEN-LAST:event_jButton1ActionPerformed
   public void show(String m){
       DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
       dt.setRowCount(0);
        try {
            pi.Myconnect();
            pi.rs=pi.pst.executeQuery(m);
            while(pi.rs.next()){
                dt.addRow(new Object[]{pi.rs.getString(1),pi.rs.getString(2),pi.rs.getString(3),pi.rs.getString(4),pi.rs.getString(5),pi.rs.getString(6),pi.rs.getString(7)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Puchase_Report.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Puchase_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puchase_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puchase_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puchase_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puchase_Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}