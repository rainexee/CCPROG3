import java.util.Scanner;

/* Represents the Driver/Main file that contains the room, players, win conditions, animal, etc. */
public class Main {
    public static void main(String[] args) {
        // Initialize the Coinflip MVC components
        CoinflipModel model = new CoinflipModel(); // Handles game data and logic
        CoinflipView view = new CoinflipView();   // Handles terminal-based input/output
        CoinflipController controller = new CoinflipController(model, view); // Manages game flow

        // Start the Coinflip game
        controller.start(); // Use the terminal-based method to run the game

        // After the Coinflip game, continue with other logic (e.g., Room initialization)
        System.out.println("Coinflip game completed. Proceeding to the next phase...");

        // Example: Initialize Room logic here
        Room room = new Room(1); // Example: Initialize Room with ID 1
        RoomView roomView = new RoomView(7, 9); // Example: RoomView with 7x9 grid
        RoomController roomController = new RoomController(room, roomView);

        // Start the Room logic
        roomController.start(); // Use the terminal-based method to run the Room logic
    }
}