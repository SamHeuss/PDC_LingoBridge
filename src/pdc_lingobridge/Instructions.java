package pdc_lingobridge;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class Instructions extends JPanel {
    public Instructions() {
        initComponents();
        Color backgroundColor = new Color(173, 216, 230);
        this.setBackground(backgroundColor);
    }
    
    private void initComponents() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firePropertyChange("backToHome", false, true);
                LingoBridge.getInstance().setMainPanel(new Page());
            }
        });

        JLabel instructionsLabel = new JLabel("Instructions go here...");

        // Filler component
        Box.Filler filler = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addComponent(instructionsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(instructionsLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler)
        );
    }
}

    
//    private void initComponents() {
//        // Add components for your instructions page, e.g., labels, text, etc.
//        // Make sure to include a "Back" button to return to the homepage.
////
////        JButton backButton = new JButton("Back");
////        backButton.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                firePropertyChange("backToHome", false, true);
////                LingoBridge.getInstance().setMainPanel(new Page());
////            }
////        });
////
////        JLabel instructionsLabel = new JLabel("Instructions go here...");
////        // Add more labels, text, or components for your instructions.
////
////        GroupLayout layout = new GroupLayout(this);
////        this.setLayout(layout);
////        //getContentPane().setLayout(layout);
////
////        layout.setAutoCreateGaps(true);
////        layout.setAutoCreateContainerGaps(true);
////
////        layout.setHorizontalGroup(
////            layout.createParallelGroup(Alignment.LEADING)
////                .addComponent(instructionsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
////                .addComponent(backButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
////        );
////
////        layout.setVerticalGroup(
////            layout.createSequentialGroup()
////                .addComponent(instructionsLabel)
////                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
////                .addComponent(backButton)
////        );
        
//        layout.setHorizontalGroup(layout.createSequentialGroup()
//            .addGroup(layout.createParallelGroup(Alignment.LEADING)
//                .addComponent(backButton))
//                .addComponent(instructionsLabel)
//                // Add more components for your instructions page
//        );
//
//        layout.setVerticalGroup(layout.createSequentialGroup()
//            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
//                .addComponent(instructionsLabel))
//            .addPreferredGap(RELATED)
//            // Add more components for your instructions page
//            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
//                .addComponent(backButton))
//        );
        
        //pack();

