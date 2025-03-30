import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CoinflipView extends JFrame {
    private JLabel instructionLabel;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel resultLabel;

    public CoinflipView() {
        // Set up the GUI
        setTitle("CoinFlip!");
        setSize(400, 200);
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

    public String getInput() {
        return inputField.getText();
    }

    public void setInstruction(String message) {
        instructionLabel.setText(message);
    }

    public void setResult(String message) {
        System.out.println("");
        resultLabel.setText(message);
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void clearInput() {
        inputField.setText("");
    }
}