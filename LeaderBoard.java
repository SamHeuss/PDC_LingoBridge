/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_lingobridge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LeaderBoard extends JPanel {

    private final DBManager dbManager;
    private final JTable table;
    private final DefaultTableModel tableModel;
        
    public LeaderBoard(DBManager dbManager) {
        this.dbManager = new DBManager();

        String[] columnNames = {"Username", "Score"};
        tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable(tableModel);
        this.add(new JScrollPane(table));
        initComponents();

        List<UserManagement> userList = dbManager.getAllUsers();
        for (UserManagement user : userList) {
            addUserToLeaderboardDisplay(user.getUsername(), user.getScore());
        }
    }

    private void initComponents() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firePropertyChange("backToHome", false, true);

                LingoBridge.getInstance().setMainPanel(new Page());
            }
        });
        //this.add(backButton);
        JScrollPane tableScrollPane = new JScrollPane(table);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(backButton)
            .addComponent(tableScrollPane)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addComponent(backButton)
            .addComponent(tableScrollPane)
        );
    }

    public UserManagement checkUser(String un) {
        String lowercaseName = un.toLowerCase();

        if (!dbManager.isUsernameAvailable(lowercaseName)) {
            UserManagement existingUser = dbManager.getUserByUsername(lowercaseName);

            int n = JOptionPane.showOptionDialog(null,
                    "Duplicate Record of " + existingUser.getUsername() + ". Override?",
                    "Duplicate User",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null);

            if (n == JOptionPane.YES_OPTION) {
                existingUser.setScore(0);
                dbManager.updateUserScore(existingUser);
            } else {
                // Log user in. In GUI, you might open a new frame/window or update some components.
            }
            return existingUser;
        } else {
            dbManager.insertNewUser(lowercaseName);
            // Fetch the newly created user to get any default attributes (like default score).
            UserManagement newUser = dbManager.getUserByUsername(lowercaseName);
            JOptionPane.showMessageDialog(null, "New user created: " + newUser.getUsername());
            return newUser;
        }
    }

    // Further methods and GUI components...
    private void addUserToLeaderboardDisplay(String username, int score) {
        tableModel.addRow(new Object[]{username, score});
    }

}
