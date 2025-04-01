//package m;
import javax.swing.*;
import java.awt.event.*;

/*
 * Class for the GameController for its MVC Implementation, it implements keylistener
 *  and also has the following variables
 * model - Game Model of the Game for MVC implementation
 *  view - View model of the game for MVC implementation
 * activePlayer - to determine which player is in play
 * selectConfirmed - tracks if the player selected an animal during their turn
 * keylistenerenabled - True in order to process user input
 * 
 */
public class GameController implements KeyListener {

    private GameModel model;
    private GameView view;
    private Player activePlayer;
    // When in selection phase, we expect a number key
    // When an animal is selected, this variable holds it.
    private boolean selectConfirmed = false;
    private boolean keyListenerEnabled = true;
    
	/*
	 * Constructor of GameController with the model and view attached in order to 
	 * make the MVC work
	 */
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        //initController();
    }
    /*
	 * This method initializes the controller for it to function properly
	 */
    private void initController() {
        // In this version, we let the key listener handle both selection and movement.
        view.addKeyListener(this);
        view.setFocusable(true);
        view.requestFocusInWindow();

        turnCheck();
        defaultDisplay();
        view.updateBoard(model.getRoom());
    }
    
    // KeyListener implementation.
    // We use keyPressed to capture user input.

	/*
	 * This method is to capture user input
	 * @param e - represents keyboard event
	 */
    @Override
    public void keyPressed(KeyEvent e) {
        if(!keyListenerEnabled) {
        	return;
        }
        char key = e.getKeyChar();
        Room room = model.getRoom();
        boolean validMove = false;
        
        int controllerError = -1;
        System.out.println("error status: " + controllerError);
        
        int deadAnimals = 0;
		deadAnimals  = activePlayer.bodyCount(deadAnimals);
		if(deadAnimals < 8) {
			if (selectConfirmed == false) {
	        	if (key >= '1' && key <= '8') {
	                int index = key - '1'; // For numbers 1-8, get index 0-7.
	                selectConfirmed = activePlayer.controllerSelect(index);
	                if(selectConfirmed==true) {
	                		selectDisplay();
	                	}
	                }else {
	                	controllerError = 1;
	                	view.getInstructions().setText("<html>Select again!<br> ErrorCode: " + controllerError + defaultFooter());
	                }
	            }else {
	            	validMove = activePlayer.controllerMove(key);
	            	if(validMove == true && controllerError == -1) {
	            		view.updateBoard(room);
	            		activePlayer.endTurn();
	            		selectConfirmed = false;
	            		winCheck();
	            		if(activePlayer.getWinState()!=1) {
	            			turnCheck();
	            			defaultDisplay();}
	            	}else {
	            		//player made an invalid move
	            		controllerError = activePlayer.getErrorCode();
	            		view.getInstructions().setText(getErrorMessage(controllerError) + defaultFooter());
	            		System.out.println("EC VALUE: " + controllerError);
	            		selectConfirmed = false;
	            	}
	            }
		}else {
			view.getInstructions().setText("Player " + activePlayer.playerID + " has no remaining animals. Turn surrendered.");
			activePlayer.endTurn();
			turnCheck();
    		defaultDisplay();
		}
    }
    /*
	 * override method to stop keyboard input
	 * @param e - release keybaord input
	 */
    @Override
    public void keyReleased(KeyEvent e) { }
	/*
	 * Override method to capture keyboard input 
	 * @param e - captures keyboard event
	 */
    @Override
    public void keyTyped(KeyEvent e) { }
/*
 * This method starts the game and calls the initializeController method
 */
    public void startGame() {
        System.out.println("Game has started!");
        initController();
        
    }
    /*
	 * This method ends the game when there is a winner and sets the text for the GUI
	 */
    public void endGame() {
    	keyListenerEnabled = false;
    	view.getInstructions().setText("<html>P" + activePlayer.playerID + " wins!");
    }
    /*
	 * This method checks if there is a player that won in order to end the game
	 */
    public void winCheck() {
    	if(activePlayer.getWinState() == 1) {
    		endGame();
    	}
    }
    /*
	 * This method is for returning error messages when the player attempts invalid/out of bounds inputs
	 * It also checks if the animal can swim or if tiles are blocked
	 */
    public String getErrorMessage(int errorCode) {
    	//error code 1
    	String errorMsg = "";
    	switch(errorCode) {
    		case 1:
    			errorMsg = "<html>Invalid selection<br>";
    			break;
    		case 2:
    			errorMsg = "<html>Out of Bounds<br>";
    			break;
    		case 3:
    			errorMsg = "<html>" + activePlayer.getSelectedAnimal().getAnimalName() + " cannot swim<br>";
    			break;
    		case 4:
    			errorMsg = "<html>Destination tile is obstructed<br>";
    			break;
    		case 5:
    			errorMsg = activePlayer.getSelectedAnimal().getAnimalName() + 
    			"<html>Animal has been captured!<br>";
    			break;
			default:
				errorMsg = "";
    	}
    	return errorMsg;
    }
    /*
	 * Displays the default footer only
	 */
    public void defaultDisplay() {
    	view.getInstructions().setText(defaultFooter());
    }
    /*
	 * this is a method for printing the animals of the active players animal index
	 */
    public String defaultFooter() {
    	//get the animals from active player's selected animal index
    	String footer = "<html> Active Player: " + activePlayer.playerID + 
    			"<br>Press a number (1-8) to select your animal and move with WASD: "
    			+ activePlayer.availableAnimals();
    	return footer;
    }
    /*
	 * This method displays which animal is selected by the player
	 */
    public void selectDisplay() {
    	view.getInstructions().setText(defaultFooter() + showSelected());
    }
    /*
	 * This method sets the string to the active players selected animal
	 * @return selected
	 */
    public String showSelected() {
    	String selected = "<html><br>Player " + activePlayer.playerID + " selected: " + 
    						activePlayer.getSelectedAnimal().getAnimalName();
    	return selected;
    }
    /*
	 * This method checks which players turn is active
	 */
    public void turnCheck() {
    	if (model.getRoom().getPlayer(1).turnActive) {
        	activePlayer = model.getRoom().getPlayer(1);
        } else {
            activePlayer = model.getRoom().getPlayer(2);
        }
    }
    
    
}
