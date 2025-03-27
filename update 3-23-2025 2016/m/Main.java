// package m;
import java.util.Scanner;

/* Represents the Driver/Main file that contains the room, players, win conditions, animal, etc. */
public class Main {
    public static void main(String[] args) {
        // Launch the Coinflip GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            Coinflip coinflip = new Coinflip();
            coinflip.setVisible(true);

            // Add a listener to detect when Coinflip is completed
            coinflip.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    // Initialize Room GUI and simulate actions
                    Room room = new Room(1); // Example: Initialize Room with ID 1
                    RoomView roomView = new RoomView(7, 9); // Example: RoomView with 7x9 grid
                    RoomController roomController = new RoomController(room, roomView);

                    roomView.setVisible(true); // Display the Room GUI

                    // Simulate player actions
                    System.out.println("Simulating player actions...");
                    roomController.updateTile(2, 2, 'X'); // Example: Player marks tile (2, 2) with 'X'
                    roomController.updateTile(3, 3, 'O'); // Example: Player marks tile (3, 3) with 'O'
                }
            });
        });

        // Prevent program from exiting immediately
        System.out.println("GUIs should now be visible. Program running...");
        while (true) {
            // Keep the program running to allow GUI interaction
        }
    }
}
