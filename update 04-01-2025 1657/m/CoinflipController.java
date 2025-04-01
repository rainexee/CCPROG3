//package m;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * Class for the coinflip controller
 * @param model - Uses the model of the coinflip for MVC implementation
 * @param view - uses the view of teh coinflip for MVC implementation
 * @param playerOneNumber - initialize the input for the coinflip for P1
 * @param playerTwoNumber - initialize the input coinflip for P2
 */
public class CoinflipController {
    private CoinflipModel model;
    private CoinflipView view;
    private int playerOneNumber = -1;
    private int playerTwoNumber = -1;
/*
 *Constructor for the coinflip controller with parameters
 *  @param view - Passing the view of the coinflip for MVC implementation 
 * @param model - Passing the model of the coinflip for MVC implementation
 */
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
    /*
     * starts the coinflip by asking for P1's input then results clear
     */
    public void start() {
        view.setInstruction("Player 1, pick a number from 1-8:");
        view.setResult(""); //Clear results
    }
/*
 *  Method that handles the inputs of the players in order to prevent invalid input and also obtains P2's number
 */
    private void handleInput() {
        try {
            int number = Integer.parseInt(view.getInput());
            if (playerOneNumber == -1) {
                // Player 1's turn
                if (model.getAnimalNumbers().contains(number)) {
                    playerOneNumber = number;
                    model.removeNumber(number);
                    view.setInstruction("Player 2, pick a number from the remaining numbers ");
                    view.clearInput();
                } else {
                    view.setResult("Invalid choice. Please pick a valid number.");
                }
            } else {
                // Player 2's turn
                if (model.getAnimalNumbers().contains(number)) {
                    playerTwoNumber = number; // Use the class-level variable
                    int playerOneStrength = model.getStrength(playerOneNumber);
                    int playerTwoStrength = model.getStrength(playerTwoNumber);

                    // Display results
                    String result = "Player 1 picked: " + playerOneNumber + " (Strength: " + playerOneStrength + ")<br>" +
                    "Player 2 picked: " + playerTwoNumber + " (Strength: " + playerTwoStrength + ")<br>" +
                    (playerOneStrength > playerTwoStrength ? "Player 1 goes first!" : "Player 2 goes first!");
                    view.setResult("<html>" + result + "</html>");
                    view.setInstruction("Game Over!");

                    // Close the tab after 2 seconds
                    new Timer(2000, (ActionEvent event) -> view.dispose()).start();
                } else {
                    view.setResult("Invalid choice. Please pick a valid number.");
                }
            }
        } catch (NumberFormatException ex) {
            view.setResult("Invalid input. Please enter a number.");
        }
    }
/*
 * method that gets the winner of the coinflip and returns the strenght level of the player
 * @return (player1) or (player2)strenght
 */
    public int getWinner() {
        // Return 1 if Player 1 wins, or 2 if Player 2 wins
        int playerOneStrength = model.getStrength(playerOneNumber);
        int playerTwoStrength = model.getStrength(playerTwoNumber);
        return playerOneStrength > playerTwoStrength ? 1 : 2;
    }
}