//package m;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
 * Class for the coinflip view in order to implement MVC. It extends JFrame and obtains the following varirables
 * InstructionLabel - Text for giving instructions
 * inputField- For user input
 * JButton - for submit button
 * resultLabel - to print output of conflip
 */
public class CoinflipView extends JFrame {
    private JLabel instructionLabel;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel resultLabel;
/*
 * Constructor for Coinflip view, Its for the implementation and is the GUI of the coinflip 
 */
    public CoinflipView() {
        // Set up the GUI
        setTitle("CoinFlip!");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        instructionLabel = new JLabel("Player 1, pick a number from 1-8:");
        inputField = new JTextField();
        submitButton = new JButton("Submit");
        resultLabel = new JLabel("");

        add(instructionLabel);
        add(inputField);
        add(submitButton);
        add(resultLabel);

        setVisible(true);
    }
/*
 * Getter for the input of the user
 * @return inputField
 */
    public String getInput() {
        return inputField.getText();
    }
/*
 * setter for the instructions
 * @param message - for instructions text
 */
    public void setInstruction(String message) {
        instructionLabel.setText(message);
    }
/*
 * setter for the result of the coinflip
 * @param message - for printing the result on the GUI
 */
    public void setResult(String message) {
        System.out.println("");
        resultLabel.setText(message);
    }
    /*
     * Method to add the submit button listener for it to respond to actions
     * @param listener - Part of ActionListener in order to interact with button
     */
    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
/*
 * Method for clearing the input to prevent concatenated or mismatch inputs
 */
    public void clearInput() {
        inputField.setText("");
    }
}