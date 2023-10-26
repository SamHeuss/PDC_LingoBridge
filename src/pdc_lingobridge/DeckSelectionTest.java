/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_lingobridge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckSelectionTest extends JPanel {

    private JComboBox<String> deckComboBox;
    private JButton selectDeckButton;

    public DeckSelectionTest() {
        setLayout(new FlowLayout());

        String[] decks = {
            "Please select one of the following decks:",
            "(1) Los dias de la semana: The days of the week - Difficulty: Easy",
            "(2) Numeros/Numbers (1-100) - Difficulty: Moderate",
            "(3) Saludos y Despididas: Greetings and Farewells - Difficulty: Moderate",
            "(4) Introduccions: Introductions - Difficulty: Hard"
        };

        deckComboBox = new JComboBox<>(decks);
        selectDeckButton = new JButton("Select Deck");

        selectDeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedDeck = deckComboBox.getSelectedIndex(); // 0-based index
                if (selectedDeck != 0) {
                    handleDeckSelection(selectedDeck);
                } else {
                    JOptionPane.showMessageDialog(DeckSelectionTest.this, "Please select a valid deck.");
                }
            }
        });

        add(deckComboBox);
        add(selectDeckButton);
    }

    private void handleDeckSelection(int deck) {
        // This is where you can perform the action after selecting a deck.
        // For now, it just shows a message.
        JOptionPane.showMessageDialog(this, "You selected deck: " + deck);
    }
}
