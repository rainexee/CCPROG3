import javax.swing.*;
import java.awt.event.*;

// import Room;
// import Tile;
// import Player;
// import Animal;

public class GameController implements KeyListener {

    private GameModel model;
    private GameView view;
    
    // When in selection phase, we expect a number key
    // When an animal is selected, this variable holds it.
    private boolean selectConfirmed = false;
    
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        initController();
    }
    
    private void initController() {
        // In this version, we let the key listener handle both selection and movement.
        view.addKeyListener(this);
        view.setFocusable(true);
        view.requestFocusInWindow();
        
        view.displayMessage("Game started. Press a number (1-8) to select your animal:");
        view.updateBoard(model.getRoom());
    }
    
    // KeyListener implementation.
    // We use keyPressed to capture user input.
    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        Room room = model.getRoom();
        boolean validAnimal = false;
        boolean validMove = false;
        int aIndex = -1;
        char wasd = 'z';
        
        Player activePlayer;
        
        if (room.getPlayer(1).turnActive) {
            activePlayer = room.getPlayer(1);
        } else {
            activePlayer = room.getPlayer(2);
        }
        
        // -- SELECTION PHASE: Expect number keys 1-9 --
        view.displayMessage("Active Player: " + activePlayer.playerID);
        
        if (selectConfirmed == false) {
        	System.out.println("Square 1");
        	if (key >= '1' && key <= '8') {
                int index = key - '1'; // For numbers 1-8, get index 0-7.
                selectConfirmed = activePlayer.controllerSelect(index);
                if(selectConfirmed==true) {Animal myAnimal = activePlayer.getSelectedAnimal();
            	view.displayMessage("Player " + activePlayer.playerID + " selected: " + myAnimal.getAnimalName());}
                }
            }else {
            	validMove = activePlayer.controllerMove(key);
            	if(validMove == true) {
            		view.updateBoard(room);
            		activePlayer.endTurn();
            		selectConfirmed = false;
            	}
            }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }

    public void startGame() {
        System.out.println("Game has started!");
        // Add logic to initialize and start the game here.
    }

}
