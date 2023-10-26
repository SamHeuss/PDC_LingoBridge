package pdc_lingobridge;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;

public class Page extends JPanel {

    private JButton confirmButton;
    private JButton instructionButton;
    private JButton leaderButton;
    private JLabel title;
    private JLabel titleEnterUser;
    private JTextField usernameInput;
    
    public Page() {
        this.initComponents();
    }

    private void initComponents() {
        usernameInput = new JTextField();
        title = new JLabel();
        confirmButton = new JButton();
        titleEnterUser = new JLabel();
        instructionButton = new JButton();
        leaderButton = new JButton();

        setBackground(new Color(216, 238, 253));

        usernameInput.setBackground(new Color(246, 247, 249));
        usernameInput.setFont(new Font("Dialog", 0, 24)); // Larger font size for the input
        usernameInput.setForeground(new Color(51, 51, 51));
        usernameInput.setHorizontalAlignment(JTextField.CENTER);
        usernameInput.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        usernameInput.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        usernameInput.setSelectedTextColor(new Color(0, 0, 0));
        usernameInput.setPreferredSize(new java.awt.Dimension(300, 40)); // Fixed size for the input

        title.setFont(new Font("MV Boli", 1, 48)); // Large title font
        title.setText("Lingo Bridge");

        confirmButton.setBackground(new Color(204, 226, 165));
        confirmButton.setFont(new Font("Dialog", 1, 18)); // Larger font size for the button
        confirmButton.setText("Confirm");
        confirmButton.addActionListener((ActionEvent evt) -> {
            LingoBridge.getInstance().confirmButtonActionPerformed(usernameInput, evt);
        });

        titleEnterUser.setFont(new Font("Dialog", 1, 18)); // Larger font size for the label
        titleEnterUser.setText("Enter your Username");

        instructionButton.setBackground(new Color(204, 204, 255));
        instructionButton.setFont(new Font("Dialog", 1, 18)); // Larger font size for the button
        instructionButton.setText("How to Play");
        instructionButton.addActionListener((ActionEvent evt) -> {
            LingoBridge.getInstance().instructionButtonActionPerformed(evt);
        });

        leaderButton.setBackground(new Color(204, 204, 255));
        leaderButton.setFont(new Font("Dialog", 1, 18)); // Larger font size for the button
        leaderButton.setText("Leaderboard");
        leaderButton.addActionListener((ActionEvent evt) -> {
            LingoBridge.getInstance().leaderButtonActionPerformed(evt);
        });

        // Adjusted GroupLayout for 800x600 context
        GroupLayout mainPanelLayout = new GroupLayout(this);
        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(title)
                            .addComponent(titleEnterUser)
                            .addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(instructionButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(leaderButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(250, Short.MAX_VALUE))
        )));
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(title)
                .addGap(50, 50, 50)
                .addComponent(titleEnterUser)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(confirmButton)
                .addGap(50, 50, 50)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(leaderButton)
                    .addComponent(instructionButton))
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }
}
