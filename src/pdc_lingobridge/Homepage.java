/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_lingobridge;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;

/**
 *
 * @author celin
 */
public class Homepage extends JPanel {

    private JButton confirmButton;
    private JButton instructionButton;
    private JMenu jMenu1;
    private JButton leaderButton;
    private JLabel title;
    private JLabel titleEnterUser;
    private JTextField usernameInput;
    
    public Homepage() {
        this.initComponents();
    }

    private void initComponents() {
        jMenu1 = new JMenu();
        usernameInput = new JTextField();
        title = new JLabel();
        confirmButton = new JButton();
        titleEnterUser = new JLabel();
        instructionButton = new JButton();
        leaderButton = new JButton();

        jMenu1.setText("jMenu1");

        setBackground(new Color(203, 226, 247));

        usernameInput.setBackground(new Color(246, 247, 249));
        usernameInput.setFont(new Font("Dialog", 0, 18)); // NOI18N
        usernameInput.setForeground(new Color(51, 51, 51));
        usernameInput.setHorizontalAlignment(JTextField.CENTER);
        usernameInput.setToolTipText("");
        usernameInput.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        usernameInput.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        usernameInput.setSelectedTextColor(new Color(0, 0, 0));

        title.setBackground(new Color(255, 255, 255));
        title.setFont(new Font("MV Boli", 1, 48)); // NOI18N
        title.setText("Lingo Bridge");

        confirmButton.setBackground(new Color(204, 226, 165));
        confirmButton.setFont(new Font("Dialog", 0, 12)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener((ActionEvent evt) -> {
            LingoBridge.getInstance().confirmButtonActionPerformed(usernameInput, evt);
        });

        titleEnterUser.setFont(new Font("Dialog", 0, 12)); // NOI18N
        titleEnterUser.setText("Enter your Username");

        instructionButton.setBackground(new Color(204, 204, 255));
        instructionButton.setFont(new Font("Dialog", 0, 12)); // NOI18N
        instructionButton.setText("How to Play");
        instructionButton.addActionListener((ActionEvent evt) -> {
            LingoBridge.getInstance().instructionButtonActionPerformed(evt);
        });

        leaderButton.setBackground(new Color(204, 204, 255));
        leaderButton.setFont(new Font("Dialog", 0, 12)); // NOI18N
        leaderButton.setText("Leaderboard");
        leaderButton.addActionListener((ActionEvent evt) -> {
            LingoBridge.getInstance().leaderButtonActionPerformed(evt);
        });

        GroupLayout mainPanelLayout = new GroupLayout(this);
        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addComponent(confirmButton)
                                                .addGap(328, 328, 328))
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addComponent(titleEnterUser)
                                                .addGap(311, 311, 311))))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 223, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(instructionButton)
                                                .addGap(113, 113, 113)
                                                .addComponent(leaderButton))
                                        .addComponent(title))
                                .addGap(210, 210, 210))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(51, Short.MAX_VALUE)
                                .addComponent(title)
                                .addGap(18, 18, 18)
                                .addComponent(titleEnterUser)
                                .addGap(3, 3, 3)
                                .addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirmButton)
                                .addGap(46, 46, 46)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(leaderButton)
                                        .addComponent(instructionButton))
                                .addGap(118, 118, 118))
        );
    }
}
