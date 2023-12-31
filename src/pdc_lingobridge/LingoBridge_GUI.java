/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pdc_lingobridge;

/**
 *
 * @author celin
 */
public class LingoBridge_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public LingoBridge_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        usernameInput = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        titleEnterUser = new javax.swing.JLabel();
        instructionButton = new javax.swing.JButton();
        leaderButton = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(216, 238, 253));

        jPanel1.setBackground(new java.awt.Color(203, 226, 247));

        usernameInput.setBackground(new java.awt.Color(246, 247, 249));
        usernameInput.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        usernameInput.setForeground(new java.awt.Color(51, 51, 51));
        usernameInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameInput.setToolTipText("");
        usernameInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        usernameInput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernameInput.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("MV Boli", 1, 48)); // NOI18N
        title.setText("Lingo Bridge");

        confirmButton.setBackground(new java.awt.Color(204, 226, 165));
        confirmButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        titleEnterUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        titleEnterUser.setText("Enter your Username");

        instructionButton.setBackground(new java.awt.Color(204, 204, 255));
        instructionButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        instructionButton.setText("How to Play");
        instructionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionButtonActionPerformed(evt);
            }
        });

        leaderButton.setBackground(new java.awt.Color(204, 204, 255));
        leaderButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        leaderButton.setText("Leaderboard");
        leaderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(confirmButton)
                        .addGap(328, 328, 328))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titleEnterUser)
                        .addGap(311, 311, 311))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 223, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(instructionButton)
                        .addGap(113, 113, 113)
                        .addComponent(leaderButton))
                    .addComponent(title))
                .addGap(210, 210, 210))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(titleEnterUser)
                .addGap(3, 3, 3)
                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmButton)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leaderButton)
                    .addComponent(instructionButton))
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void instructionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionButtonActionPerformed
        // When "How to Play" button is clicked
        //Instructions instructionsPage = new Instructions();
        //instructionsPage.setVisible(true);
        
        instruc instructionsPage = new instruc();
        instructionsPage.setVisible(true);
    }//GEN-LAST:event_instructionButtonActionPerformed

    private void leaderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leaderButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LingoBridge_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LingoBridge_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LingoBridge_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LingoBridge_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LingoBridge_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton instructionButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leaderButton;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleEnterUser;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
