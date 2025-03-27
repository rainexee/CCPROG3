import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinflipController {
    private CoinflipModel model;
    private CoinflipView view;
    private int playerOneNumber = -1;

    public CoinflipController(CoinflipModel model, CoinflipView view) {
        this.model = model;
        this.view = view;

        // Add listener for the submit button
        view.addSubmitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInput();
            }
        });
    }

    public void start() {
        // Set the initial instruction for Player 1
        view.setInstruction("Player 1, pick a number from 1-8:");
        view.setResult(""); // Clear any previous results
    }

    private void handleInput() {
        try {
            int number = Integer.parseInt(view.getInput());
            if (playerOneNumber == -1) {
                // Player 1's turn
                if (model.getAnimalNumbers().contains(number)) {
                    playerOneNumber = number;
                    model.removeNumber(number);
                    view.setInstruction("Player 2, pick a number from the remaining numbers: " + model.getAnimalNumbers());
                    view.clearInput();
                } else {
                    view.setResult("Invalid choice. Please pick a valid number.");
                }
            } else {
                // Player 2's turn
                if (model.getAnimalNumbers().contains(number)) {
                    int playerTwoNumber = number;
                    int playerOneStrength = model.getStrength(playerOneNumber);
                    int playerTwoStrength = model.getStrength(playerTwoNumber);

                    // Display results
                    String result = "Player 1 picked: " + playerOneNumber + " (Strength: " + playerOneStrength + ")\n" +
                                    "Player 2 picked: " + playerTwoNumber + " (Strength: " + playerTwoStrength + ")\n" +
                                    (playerOneStrength > playerTwoStrength ? "Player 1 goes first!" : "Player 2 goes first!");
                    view.setResult(result);
                    view.setInstruction("Game Over!");
                } else {
                    view.setResult("Invalid choice. Please pick a valid number.");
                }
            }
        } catch (NumberFormatException ex) {
            view.setResult("Invalid input. Please enter a number.");
        }
    }
}