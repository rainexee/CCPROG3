

import javax.swing.*;
import java.awt.*;

// import m.Room;

public class GameView extends JFrame {
    private JPanel[][] boardTiles;
    private JLabel[][] tileLabels;
    
    private JTextArea messageArea;
    private JPanel boardPanel;
    
    public final int ROWS = 7;
    public final int COLS = 9;
    
    public GameView() {
        super("Jungle King");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        boardPanel = new JPanel(new GridLayout(ROWS, COLS));
        boardTiles = new JPanel[ROWS][COLS];
        tileLabels = new JLabel[ROWS][COLS];
        
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
        add(new JScrollPane(messageArea), BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // Call this to update the display of the board based on the Room tiles.
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
                    else{tileLabels[i][j].setText("River");}
                    tileLabels[i][j].setForeground(Color.WHITE);
                    break;
                case 'T': // Mountain
                    boardTiles[i][j].setBackground(Color.GRAY);
                    if(thisTile.defender!=null) {displayToken(i, j, thisTile);}
                    else{tileLabels[i][j].setText("Trap");}
                    tileLabels[i][j].setForeground(Color.BLACK);
                    break;
                case 'H':
                	boardTiles[i][j].setBackground(Color.ORANGE);
                	if(thisTile.defender!=null) {displayToken(i, j, thisTile);}
                	else{tileLabels[i][j].setText("Home");}
                    tileLabels[i][j].setForeground(Color.WHITE);
                    break;
                default: // Default tile
                    boardTiles[i][j].setBackground(Color.LIGHT_GRAY);
                    tileLabels[i][j].setText("");
                    break;
            	}
            }
        }
    }
    
    public void displayMessage(String msg) {
        messageArea.append(msg + "\n");
    }
    
    public JPanel[][] getBoardTiles() {
        return boardTiles;
    }
    
    public void displayToken(int i, int j, Tile thisTile) {
    	tileLabels[i][j].setText(thisTile.defender.getAnimalName());
        if(thisTile.defender.owner.playerID == 1) {
        	tileLabels[i][j].setForeground(Color.RED);
        }else {
        	tileLabels[i][j].setForeground(Color.BLACK);
        }
    }
    
    public void displayTile(int i, int j, Tile thisTile) {
    	
    }
}
