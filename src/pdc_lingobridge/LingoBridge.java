/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_lingobridge;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
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

//    public void confirmButtonActionPerformed(JTextField usernameInput, ActionEvent evt) {
//        // TODO add your handling code here:
//        String enteredUsername = usernameInput.getText();
//        if (enteredUsername.isEmpty()) {
//            System.out.println("Username is empty.");
//            // Handle empty username (you can show an error message)
//        } else {
//            if(dbManager.usernameExists(enteredUsername)){
//                System.out.println("Username is occupied.");
//                
//                usernameInput.setBackground(Color.RED);
//                JOptionPane.showMessageDialog(this, "User record found: "+ enteredUsername);
//                
//                String[] options = {"Override Record", "Enter New Username"};
//                int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
//
//                if (choice == 0) {  // Override Record
//                    // Here you might want to handle overriding the record or just proceed to the PlayGame panel
//                    setMainPanel(new PlayGame());
//                } else {
//                    // Reset background color and let the user enter a new username
//                    usernameInput.setBackground(Color.WHITE);
//                }
//            } else{
//                if (dbManager.insertNewUser(enteredUsername)) {
//                    System.out.println("User successfully inserted into the database.");
//                    setMainPanel(new PlayGame());
//                } else {
//                    // Handle insertion error
//                    System.out.println("There was an error inserting the user.");
//                } 
//            }
//            // DBManager dbManager = new DBManager();
//
//            if (dbManager.insertNewUser(enteredUsername)) {
//                System.out.println("User successfully inserted into the database.");
//                // cardLayout.show(cards, "playGame");
//            } else {
//                // Username is not available, show an error message
//                System.out.println("Username is not available.");
//            }
//
//            setMainPanel(new PlayGame());
//        }
//    }
    public void confirmButtonActionPerformed(JTextField usernameInput, ActionEvent evt) {
        // TODO add your handling code here:
        String enteredUsername = usernameInput.getText();
        if (enteredUsername.isEmpty()) {
            System.out.println("Username is empty.");
            // Handle empty username (you can show an error message)
        } else {
            if (dbManager.usernameExists(enteredUsername)) {
                System.out.println("Username is occupied.");

                usernameInput.setBackground(Color.RED);
                JOptionPane.showMessageDialog(this, "User record found: " + enteredUsername);

                String[] options = {"Override Record", "Enter New Username"};
                int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (choice == 0) {  // Override Record
                    // Here you might want to handle overriding the record or just proceed to the PlayGame panel
                    setMainPanel(new PlayGame());
                } else {
                    // Reset background color and let the user enter a new username
                    usernameInput.setBackground(Color.WHITE);
                    return; // Exit the method early to avoid the code below
                }
            } else {
                if (dbManager.insertNewUser(enteredUsername)) {
                    System.out.println("User successfully inserted into the database.");
                    setMainPanel(new PlayGame());
                } else {
                    // Handle insertion error
                    System.out.println("There was an error inserting the user.");
                    return; // Exit the method early to avoid the code below
                }
            }
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
