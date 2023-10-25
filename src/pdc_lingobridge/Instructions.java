package pdc_lingobridge;

import javax.swing.*;

public class Instructions extends javax.swing.JFrame {
    
    // Add components for displaying instructions
    private JLabel instructionsLabel;
    private JButton backButton;

    public Instructions() {
        initComponents();
    }

    private void initComponents() {
        // Initialize and arrange components
        
        instructionsLabel = new JLabel("Here are the instructions on how to play the game...");
        backButton = new JButton("Back");
        
        // Configure the layout, fonts, and other properties as needed

        // Implement an ActionListener for the Back button
        backButton.addActionListener(e -> {
            this.dispose(); // Close the HowToPlayPage
            LingoBridge_GUI mainPage = new LingoBridge_GUI();
            mainPage.setVisible(true); // Reopen the main page
        });
        
        setSize(800, 600);
        setTitle("How to Play");
        
        // Add components to the frame
        // (You can use GroupLayout, BorderLayout, or another layout manager of your choice)

        // Set the frame properties (size, title, etc.)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Instructions howTo = new Instructions();
            howTo.setVisible(true);
        });
    }
}
