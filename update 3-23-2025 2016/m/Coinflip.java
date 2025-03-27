import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Coinflip extends JFrame {
    private List<Integer> animalNumbers;
    private List<Integer> animalStrengths;
    private int playerOneNumber = -1;
    private int playerTwoNumber = -1;

    public Coinflip() {
        // Initialize animal numbers and strengths
        animalNumbers = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            animalNumbers.add(i);
        }

        animalStrengths = new ArrayList<>();
        animalStrengths.add(1);
        animalStrengths.add(2);
        animalStrengths.add(3);
        animalStrengths.add(4);
        animalStrengths.add(5);
        animalStrengths.add(6);
        animalStrengths.add(7);
        animalStrengths.add(8);

        // Shuffle the lists
        long seed = System.nanoTime();
        Collections.shuffle(animalNumbers, new Random(seed));
        Collections.shuffle(animalStrengths, new Random(seed));

        // Set up the GUI
        setTitle("Coinflip Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JLabel instructionLabel = new JLabel("Player 1, pick a number from 1-8:");
        add(instructionLabel);

        JComboBox<Integer> playerOneComboBox = new JComboBox<>(animalNumbers.toArray(new Integer[0]));
        add(playerOneComboBox);

        JButton submitButton = new JButton("Submit Player 1 Choice");
        add(submitButton);

        JLabel resultLabel = new JLabel("");
        add(resultLabel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerOneNumber = (int) playerOneComboBox.getSelectedItem();
                animalNumbers.remove(Integer.valueOf(playerOneNumber));

                // Update GUI for Player 2
                instructionLabel.setText("Player 2, pick a number from the remaining numbers:");
                playerOneComboBox.setModel(new DefaultComboBoxModel<>(animalNumbers.toArray(new Integer[0])));
                submitButton.setText("Submit Player 2 Choice");

                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        playerTwoNumber = (int) playerOneComboBox.getSelectedItem();

                        // Determine strengths
                        int playerOneStrength = animalStrengths.get(playerOneNumber - 1);
                        int playerTwoStrength = animalStrengths.get(playerTwoNumber - 1);

                        // Display results
                        resultLabel.setText("<html>Player 1 picked: " + playerOneNumber + " (Strength: " + playerOneStrength + ")<br>" +
                                "Player 2 picked: " + playerTwoNumber + " (Strength: " + playerTwoStrength + ")<br>" +
                                (playerOneStrength > playerTwoStrength ? "Player 1 goes first!" : "Player 2 goes first!") + "</html>");
                        submitButton.setEnabled(false);

                        // Close the Coinflip window after completion
                        dispose();
                    }
                });
            }
        });
    }


}
