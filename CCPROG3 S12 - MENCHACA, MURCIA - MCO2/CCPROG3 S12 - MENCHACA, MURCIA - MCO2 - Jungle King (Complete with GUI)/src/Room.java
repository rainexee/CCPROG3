//package m;

/*
 * This class represents the Room of the game. It has the rows and columns of the board and the roomID
 */
public class Room {
    int i, j;
    int rows = 7;
    int cols = 9;
    int roomID;
    
    private Player[] players = new Player[2];
    Tile[][] tiles;
    
    /*
     * This is the constructor for the room and the roomID
     * @param rID - RoomID
     */
    public Room(int rID) {
        tiles = new Tile[rows][cols];
        this.roomID = 1;
        initializeTiles();
        initializePlayers();
    }
    
    /*
     * This method initializes the tiles of the board
     */
    private void initializeTiles() {
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                tiles[i][j] = new Tile(i, j);
                tiles[i][j].status = '_';
                tiles[i][j].tileType = tiles[i][j].status;
            }
            //System.out.println("Row complete, next row");
        }

        // RIVER TILE INITIALIZATION
        for (i = 1; i < 3; i++) {
            for (j = 3; j < 6; j++) {
                tiles[i][j].status = 'R';
                tiles[i][j].tileType = tiles[i][j].status;
            }
        }
        for (i = 4; i < 6; i++) {
            for (j = 3; j < 6; j++) {
                tiles[i][j].status = 'R';
                tiles[i][j].tileType = tiles[i][j].status;
            }
        }

        // TRAP TILE INITIALIZATION
        tiles[2][0].status = 'T';
        tiles[2][0].tileType = tiles[2][0].status;
        tiles[2][cols - 1].status = 'T';
        tiles[2][cols - 1].tileType = tiles[2][cols - 1].status;

        tiles[3][1].status = 'T';
        tiles[3][1].tileType = tiles[3][1].status;
        tiles[3][cols - 2].status = 'T';
        tiles[3][cols - 2].tileType = tiles[3][cols - 2].status;
        tiles[4][0].status = 'T';
        tiles[4][0].tileType = tiles[4][0].status;
        tiles[4][cols - 1].status = 'T';
        tiles[4][cols - 1].tileType = tiles[4][cols - 1].status;

        // HOME TILE INITIALIZATION
        tiles[3][0].status = 'H';
        tiles[3][0].tileType = tiles[3][0].status;
        tiles[3][cols - 1].status = 'H';
        tiles[3][cols - 1].tileType = tiles[3][cols - 1].status;
    }
    /*
     * This is the method that initializes Player1 and Player2
     */
    private void initializePlayers() {
    	players[0] = new Player(1, this);
    	players[1] = new Player(2, this);
    }
    /*
     * This is a getter for the tiles and prints it out
     */
    public void getTiles() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < cols - 1) {
                    System.out.print(tiles[i][j].status + " | ");
                } else {
                    System.out.print(tiles[i][j].status);
                    System.out.println();
                }
            }
        }
    }
    
    /*
     * This is a getter for the tilesArray
     */
    public Tile[][] getTilesArray() {
        return tiles;
    }
    /*
     * This is a getter for the Player
     * @param pID - PlayerID
     */
    public Player getPlayer(int pID) {
    	return players[pID-1];
    }

    // Make method to restart tile status when animal is destroyed
    // make method that 
}