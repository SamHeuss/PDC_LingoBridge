package pdc_lingobridge;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class Instructions extends JPanel {
    public Instructions() {
        initComponents();
    }
    
    private void initComponents() {
        // Add components for your instructions page, e.g., labels, text, etc.
        // Make sure to include a "Back" button to return to the homepage.

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firePropertyChange("backToHome", false, true);
                
                LingoBridge.getInstance().setMainPanel(new Page());
            }
        });

        JLabel instructionsLabel = new JLabel("Instructions go here...");
        // Add more labels, text, or components for your instructions.

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        //getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(backButton))
                .addComponent(instructionsLabel)
                // Add more components for your instructions page
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(instructionsLabel))
            .addPreferredGap(RELATED)
            // Add more components for your instructions page
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(backButton))
        );
        
        //pack();
    }
}
