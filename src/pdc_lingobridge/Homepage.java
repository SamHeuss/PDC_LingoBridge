/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_lingobridge;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

/**
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
    private DeckSelectionTest deckSelectionPanel; // The deck selection panel

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
        deckSelectionPanel = new DeckSelectionTest(); // Initialize the deck selection panel

        jMenu1.setText("jMenu1");

        setBackground(new Color(203, 226, 247));

        usernameInput.setBackground(new Color(246, 247, 249));
        usernameInput.setFont(new Font("Dialog", 0, 18));
        usernameInput.setForeground(new Color(51, 51, 51));
        usernameInput.setHorizontalAlignment(JTextField.CENTER);
        usernameInput.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        usernameInput.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        title.setFont(new Font("MV Boli", 1, 48));
        title.setText("Lingo Bridge");

        confirmButton.setBackground(new Color(204, 226, 165));
        confirmButton.setFont(new Font("Dialog", 0, 12));
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(evt -> {
            // LingoBridge.getInstance().confirmButtonActionPerformed(usernameInput, evt);
            System.out.println("Confirm button pressed"); // Placeholder code
        });

        titleEnterUser.setFont(new Font("Dialog", 0, 12));
        titleEnterUser.setText("Enter your Username");

        instructionButton.setBackground(new Color(204, 204, 255));
        instructionButton.setFont(new Font("Dialog", 0, 12));
        instructionButton.setText("How to Play");
        instructionButton.addActionListener(evt -> {
            // LingoBridge.getInstance().instructionButtonActionPerformed(evt);
            System.out.println("Instructions button pressed"); // Placeholder code
        });

        leaderButton.setBackground(new Color(204, 204, 255));
        leaderButton.setFont(new Font("Dialog", 0, 12));
        leaderButton.setText("Leaderboard");
        leaderButton.addActionListener(evt -> {
            // LingoBridge.getInstance().leaderButtonActionPerformed(evt);
            System.out.println("Leaderboard button pressed"); // Placeholder code
        });

        GroupLayout mainPanelLayout = new GroupLayout(this);
        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(instructionButton)
                                                .addGap(113, 113, 113)
                                                .addComponent(leaderButton))
                                        .addComponent(title)
                                        .addComponent(deckSelectionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))) // Add the deck selection panel here
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(328, 328, 328)
                                .addComponent(confirmButton))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(311, 311, 311)
                                .addComponent(titleEnterUser))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(title)
                                .addGap(18, 18, 18)
                                .addComponent(titleEnterUser)
                                .addGap(3, 3, 3)
                                .addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirmButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deckSelectionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) // And in the vertical layout
                                .addGap(46, 46, 46)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(leaderButton)
                                        .addComponent(instructionButton))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
    }

    public static void main(String[] args) { // Test
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Homepage());
        frame.pack();
        frame.setVisible(true);
    }
}

