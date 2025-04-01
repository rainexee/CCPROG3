//package m;

import javax.swing.*;
import java.awt.*;

// import m.Room;
/*
 * This is the class for the GameView for the MVC implementation of the Game. It contains the following variables
 * boardTiles - Tiles of the board
 * tileLabels - Labels of the tiles such as: Grass, River etc
 * messageArea - Text of the game
 * boardPanel - Frame of the board 
 * instructions - Text of the instructions to guide the player on actions required
 * ROWS - Rows of the board
 * COLS - Columns of the board
 */
public class GameView extends JFrame {
    private JPanel[][] boardTiles;
    private JLabel[][] tileLabels;
    
    private JTextArea messageArea;
    private JPanel boardPanel;
    private JLabel instructions;
    
    public final int ROWS = 7;
    public final int COLS = 9;
    
    /*
     * Constructor of the GameView. It contains the display of the GUI itself
     */
    public GameView() {
        super("Jungle King");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        boardPanel = new JPanel(new GridLayout(ROWS, COLS));
        boardTiles = new JPanel[ROWS][COLS];
        tileLabels = new JLabel[ROWS][COLS];
        instructions = new JLabel("Welcome to Jungle King!");
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                boardTiles[i][j] = new JPanel();
                boardTiles[i][j].setPreferredSize(new Dimension(60, 60));
                boardTiles[i][j].setBackground(Color.LIGHT_GRAY); // Default color
                boardTiles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional border
                boardPanel.add(boardTiles[i][j]);
                
                tileLabels[i][j] = new JLabel("", SwingConstants.CENTER); // Center-align text
                tileLabels[i][j].setForeground(Color.BLACK); // Default text color
                boardTiles[i][j].setLayout(new BorderLayout()); // Use BorderLayout to center JLabel
                boardTiles[i][j].add(tileLabels[i][j], BorderLayout.CENTER);
                
                boardPanel.add(boardTiles[i][j]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
        
        
        messageArea = new JTextArea(5, 20);
        messageArea.setEditable(false);
        add(instructions, BorderLayout.SOUTH);
        //add(new JScrollPane(messageArea), BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /*
     * This method is for updating the board of the GUI
     */
    public void updateBoard(Room room) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                // Example: Update tile background based on status (e.g., grass '_', river 'R')
                //Tile thisTile = room.tiles[i][j];
                Tile thisTile = room.tiles[i][j];
            	char status = room.tiles[i][j].tileType;
            	switch (status) {
                case '_': // Grass
                    boardTiles[i][j].setBackground(Color.GREEN);
                    if(thisTile.defender!=null) {displayToken(i, j, thisTile);}
                    else{tileLabels[i][j].setText("Grass");
                    tileLabels[i][j].setForeground(Color.WHITE);} // Text color
                    break;
                case 'R': // River
                    boardTiles[i][j].setBackground(Color.BLUE);
                    if(thisTile.defender!=null) {displayToken(i, j, thisTile);}
                    else{tileLabels[i][j].setText("River");
                    tileLabels[i][j].setForeground(Color.WHITE);}
                    break;
                case 'T': // Mountain
                    boardTiles[i][j].setBackground(Color.GRAY);
                    if(thisTile.defender!=null) {displayToken(i, j, thisTile);}
                    else{tileLabels[i][j].setText("Trap");
                    tileLabels[i][j].setForeground(Color.BLACK);}
                    break;
                case 'H':
                	boardTiles[i][j].setBackground(Color.ORANGE);
                	if(thisTile.defender!=null) {displayToken(i, j, thisTile);}
                	else{tileLabels[i][j].setText("Home");
                    tileLabels[i][j].setForeground(Color.WHITE);}
                    break;
                default: // Default tile
                    boardTiles[i][j].setBackground(Color.LIGHT_GRAY);
                    tileLabels[i][j].setText("");
                    break;
            	}
            }
        }
    }
    /*
     * This method displays the message 
     */
    public void displayMessage(String msg) {
        messageArea.append(msg + "\n");
    }
    /*
     * This method returns the boardTiles
     * @return boardTiles
     */
    public JPanel[][] getBoardTiles() {
        return boardTiles;
    }
    /*
     * displayToken method is for setting the team colours and the animal name
     */
    public void displayToken(int i, int j, Tile thisTile) {
    	tileLabels[i][j].setText(thisTile.defender.getAnimalName());
        if(thisTile.defender.owner.playerID == 1) {
        	tileLabels[i][j].setForeground(Color.RED);
        }else {
        	tileLabels[i][j].setForeground(Color.BLACK);
        }
    }
    /*
     * getter for the insturctions
     */
    public JLabel getInstructions() {
    	return this.instructions;
    }
}
