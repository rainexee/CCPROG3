package m;
import javax.swing.*;
import java.awt.event.*;

// import Room;
// import Tile;
// import Player;
// import Animal;

public class GameController implements KeyListener {

    private GameModel model;
    private GameView view;
    private Player activePlayer;
    // When in selection phase, we expect a number key
    // When an animal is selected, this variable holds it.
    private boolean selectConfirmed = false;
    
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        //initController();
    }
    
    private void initController() {
        // In this version, we let the key listener handle both selection and movement.
        view.addKeyListener(this);
        view.setFocusable(true);
        view.requestFocusInWindow();
        
        if (model.getRoom().getPlayer(1).turnActive) {
        	activePlayer = model.getRoom().getPlayer(1);
        } else {
            activePlayer = model.getRoom().getPlayer(2);
        }
        
        view.getInstructions().setText("<html>Active Player: Player " + activePlayer.playerID + 
        		"<br>Game started. Press a number (1-8) to select your animal:");
        view.getInstructions().setText(view.getInstructions().getText() + "<html><br>1 - Elephant  2 - Wolf  3 - Lion");
		view.getInstructions().setText(view.getInstructions().getText() + "<html><br>4 - Rat  5 - Cat  6 - Dog");
		view.getInstructions().setText(view.getInstructions().getText() + "<html><br>7 - Tiger  8 - Leopard");
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
        
        // -- SELECTION PHASE: Expect number keys 1-9 --
        //view.getInstructions().setText("Active Player: " + activePlayer.playerID);
        System.out.println("Checking animal roster...");
        
        int deadAnimals = 0;
		deadAnimals  = activePlayer.bodyCount(deadAnimals);
		if(deadAnimals < 8) {
			if (selectConfirmed == false) {
	        	System.out.println("Square 1");
	        	if (key >= '1' && key <= '8') {
	                int index = key - '1'; // For numbers 1-8, get index 0-7.
	                selectConfirmed = activePlayer.controllerSelect(index);
	                if(selectConfirmed==true) {Animal myAnimal = activePlayer.getSelectedAnimal();
	                view.getInstructions().setText("Player " + activePlayer.playerID + " selected: " + myAnimal.getAnimalName());}
	                }
	            }else {
	            	validMove = activePlayer.controllerMove(key);
	            	if(validMove == true) {
	            		view.updateBoard(room);
	            		activePlayer.endTurn();
	            		selectConfirmed = false;
	            		if (model.getRoom().getPlayer(1).turnActive) {
	                    	activePlayer = model.getRoom().getPlayer(1);
	                    } else {
	                        activePlayer = model.getRoom().getPlayer(2);
	                    }
	            		view.getInstructions().setText("<html>Active Player: Player " + activePlayer.playerID + 
	                    		"<br>Press a number (1-8) to select your animal:");
	            		view.getInstructions().setText(view.getInstructions().getText() + "<html><br>1 - Elephant  2 - Wolf  3 - Lion");
	            		view.getInstructions().setText(view.getInstructions().getText() + "<html><br>4 - Rat  5 - Cat  6 - Dog");
	            		view.getInstructions().setText(view.getInstructions().getText() + "<html><br>7 - Tiger  8 - Leopard");
	            	}
	            }
		}else {
			view.getInstructions().setText("Player " + activePlayer.playerID + " has no remaining animals.");
			activePlayer.endTurn();
			if (model.getRoom().getPlayer(1).turnActive) {
	        	activePlayer = model.getRoom().getPlayer(1);
	        } else {
	            activePlayer = model.getRoom().getPlayer(2);
	        }
		}
		
		/*if(room.getPlayer(1).getWinState() == 1 || room.getPlayer(2).getWinState() == 1) {
        	view.displayMessage("Game over");
        }*/
    }
    
    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }

    public void startGame() {
        System.out.println("Game has started!");
        initController();
        // Add logic to initialize and start the game here.
    }

}
