
package votingsystem.registeredaspirant;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;
import static votingsystem.databaseconnection.DatabaseConnection.*;


public class Registered_Aspirants extends javax.swing.JFrame {

    /**
     * Creates new form Registered_Aspirants
     *
     * @throws java.sql.SQLException
     */
    public Registered_Aspirants() throws SQLException {
        initComponents();
         setIconImage(new ImageIcon("MMUST-Logo.jpeg").getImage());
       try{
        new votingsystem.databaseconnection.DatabaseConnection().dbConnect();
       }catch(java.lang.NullPointerException e){
       JOptionPane.showMessageDialog(null, "Problem loading tables","No connection",JOptionPane.ERROR_MESSAGE);
       
       }
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        tblRegisterd_Aspirants.setEnabled(false);

        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //Update the component tree - associate the look and feel with the given frame.
            SwingUtilities.updateComponentTreeUI(this);
        }//end try
        
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
                  
        try {
            String sql = "SELECT Post_Name FROM posts ORDER BY Post_ID";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cmbPost.addItem(rs.getObject("Post_Name"));

            }
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No connection","Connection Failed",JOptionPane.ERROR_MESSAGE);
        }

        try {
            String sql = "SELECT Reg_No, CONCAT(Surname,'   ',First_name,'   ',Second_name)AS NAME,Gender,Residence FROM aspirants WHERE Post='" + (String) cmbPost.getSelectedItem() + "'";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            tblRegisterd_Aspirants.setVisible(true);
            tblRegisterd_Aspirants.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (java.lang.NullPointerException e) {
           

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegisterd_Aspirants = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbPost = new javax.swing.JComboBox();
        lblPost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aspirants Details");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Somu Elections Registered Aspirants For");

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPrint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        tblRegisterd_Aspirants.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        tblRegisterd_Aspirants.setForeground(new java.awt.Color(51, 51, 255));
        tblRegisterd_Aspirants.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblRegisterd_Aspirants);

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("MMUST-Logo.jpeg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cmbPost.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmbPost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Please Select Post---" }));
        cmbPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPostActionPerformed(evt);
            }
        });

        lblPost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPost.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnPrint)
                        .addGap(155, 155, 155)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(cmbPost, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPost, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(cmbPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        MessageFormat header = new MessageFormat("Somu Elections Registered Aspirants For:  " + (String) cmbPost.getSelectedItem());
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try {
            tblRegisterd_Aspirants.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnPrintActionPerformed

    private void cmbPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPostActionPerformed
        
        try {
           

            String sql = "SELECT Reg_No, CONCAT(Surname,'   ',First_name,'   ',Second_name)AS NAME,Gender,Residence FROM aspirants WHERE Post='" + (String) cmbPost.getSelectedItem() + "'";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(!rs.isBeforeFirst()){
            lblPost.setText((String) cmbPost.getSelectedItem());
            tblRegisterd_Aspirants.setVisible(false);
            btnPrint.setEnabled(false);
            }
            else{
            tblRegisterd_Aspirants.setVisible(true);
            tblRegisterd_Aspirants.setModel(DbUtils.resultSetToTableModel(rs));
            lblPost.setText((String) cmbPost.getSelectedItem());
            btnPrint.setEnabled(true);
            }
            

        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Connection Lost","Connection Failure",JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Problem Loading Table","Registerd_Voters",JOptionPane.ERROR_MESSAGE);
        } 
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Connection Lost,please reload","Connection Failure",JOptionPane.ERROR_MESSAGE);
        
        }
        catch (Exception ex) {
        Logger.getLogger(Registered_Aspirants.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_cmbPostActionPerformed

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
            java.util.logging.Logger.getLogger(Registered_Aspirants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registered_Aspirants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registered_Aspirants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registered_Aspirants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Registered_Aspirants().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Registered_Aspirants.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox cmbPost;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPost;
    private javax.swing.JTable tblRegisterd_Aspirants;
    // End of variables declaration//GEN-END:variables
}

