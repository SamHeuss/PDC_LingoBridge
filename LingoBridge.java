/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_lingobridge;

import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author celin
 */
public class LingoBridge extends JFrame {

    private final DBManager dbManager;
    private static LingoBridge instance;
    
    public static LingoBridge getInstance() {
        return instance;
    }

    public LingoBridge(DBManager dbManager) {
        this.dbManager = dbManager;
        instance = this;

        // setup start panel
        this.setMainPanel(new Page());
    }

    public void setMainPanel(JPanel panel) {
        GroupLayout layout = new GroupLayout(LingoBridge.getInstance().getContentPane());

        getContentPane().removeAll();

        LingoBridge.getInstance().getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

//        LingoBridge.getInstance().pack();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LingoBridge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        DBManager dbManager = new DBManager();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            JFrame x1 = new LingoBridge(dbManager);
            x1.setVisible(true);
            x1.setResizable(false);
            x1.setSize(800, 600);
        });
    }

    public void confirmButtonActionPerformed(JTextField usernameInput, ActionEvent evt) {
        // TODO add your handling code here:
        String enteredUsername = usernameInput.getText();
        if (enteredUsername.isEmpty()) {
            System.out.println("Username is empty.");
            // Handle empty username (you can show an error message)
        } else {
            // DBManager dbManager = new DBManager();

            if (dbManager.insertNewUser(enteredUsername)) {
                System.out.println("User successfully inserted into the database.");
                // cardLayout.show(cards, "playGame");
            } else {
                // Username is not available, show an error message
                System.out.println("Username is not available.");
            }

            setMainPanel(new PlayGame());
        }
    }

    public void instructionButtonActionPerformed(ActionEvent evt) {
        // When "How to Play" button is clicked
        setMainPanel(new Instructions());

        // Show or switch to the instructions page
//        cardLayout.show(cards, "instructions");

    }

    public void leaderButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        LeaderBoard lbPanel = new LeaderBoard(dbManager);
        setMainPanel(lbPanel);
    }
}
