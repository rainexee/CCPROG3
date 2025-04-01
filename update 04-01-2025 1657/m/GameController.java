package m;
import javax.swing.*;
import java.awt.event.*;


public class GameController implements KeyListener {

    private GameModel model;
    private GameView view;
    private Player activePlayer;
    // When in selection phase, we expect a number key
    // When an animal is selected, this variable holds it.
    private boolean selectConfirmed = false;
    private boolean keyListenerEnabled = true;
    
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

        turnCheck();
        defaultDisplay();
        view.updateBoard(model.getRoom());
    }
    
    // KeyListener implementation.
    // We use keyPressed to capture user input.
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
    
    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }

    public void startGame() {
        System.out.println("Game has started!");
        initController();
        // Add logic to initialize and start the game here.
    }
    
    public void endGame() {
    	keyListenerEnabled = false;
    	view.getInstructions().setText("<html>P" + activePlayer.playerID + " wins!");
    }
    
    public void winCheck() {
    	if(activePlayer.getWinState() == 1) {
    		endGame();
    	}
    }
    
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
    
    public void defaultDisplay() {
    	view.getInstructions().setText(defaultFooter());
    }
    
    public String defaultFooter() {
    	//get the animals from active player's selected animal index
    	String footer = "<html> Active Player: " + activePlayer.playerID + 
    			"<br>Press a number (1-8) to select your animal and move with WASD: "
    			+ activePlayer.availableAnimals();
    	return footer;
    }
    
    public void selectDisplay() {
    	view.getInstructions().setText(defaultFooter() + showSelected());
    }
    
    public String showSelected() {
    	String selected = "<html><br>Player " + activePlayer.playerID + " selected: " + 
    						activePlayer.getSelectedAnimal().getAnimalName();
    	return selected;
    }
    
    public void turnCheck() {
    	if (model.getRoom().getPlayer(1).turnActive) {
        	activePlayer = model.getRoom().getPlayer(1);
        } else {
            activePlayer = model.getRoom().getPlayer(2);
        }
    }
    
    
}
