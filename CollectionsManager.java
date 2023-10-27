/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_lingobridge;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CollectionsManager {

    private final int deck;
    private final String filePath;

    // Constructor for deck specific operations
    public CollectionsManager(int deck) {
        this.deck = deck;
        this.filePath = getDeckFilePath(deck);
    }

    // Constructor for general file operations
    public CollectionsManager(String filePath) {
        this.deck = -1; // indicates that deck is not set
        this.filePath = filePath;
    }

    public List<String> readFromFile() {
        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;

            // read each line of the file until the end
            while ((currentLine = reader.readLine()) != null) {
                data.add(currentLine);
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(CollectionsManager.class.getName()).log(Level.SEVERE, "File not found.", e);
        } catch (IOException e) {
            Logger.getLogger(CollectionsManager.class.getName()).log(Level.SEVERE, "Error reading from file.", e);
        }

        return data;
    }

    public void writeToFile(List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            Logger.getLogger(CollectionsManager.class.getName()).log(Level.SEVERE, "Error writing to file.", e);
        }
    }

    public void appendToFile(String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            Logger.getLogger(CollectionsManager.class.getName()).log(Level.SEVERE, "Error appending to file.", e);
        }
    }

    private String getDeckFilePath(int deck) {
        switch (deck) {
            case 1:
                return "./resources/DaysOfTheWeek.txt";
            case 2:
                return "./resources/Numbers.txt";
            case 3:
                return "./resources/GreetingsFarewells.txt";
            case 4:
                return "./resources/Introductions.txt";
            default:
                return "Warning! There is no deck selected!";
        }
    }
}