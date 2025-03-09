//package m;

/*represents the room the players will use for the game and initializes the tiles in the board
 *and initializes the players
 * 
 */
public class Room {
    int i, j;
    int rows = 7;
    int cols = 9;
    int roomID;
    
    private Player[] players = new Player[2];
    Tile[][] tiles;
/*constructor for the room that takes the roomID parameter and initializes the tiles array and the players
 * @param rID as an int
 */
    public Room(int rID) {
        tiles = new Tile[rows][cols];
        this.roomID = 1;
        initializeTiles();
        initializePlayers();
    }
    
    /*initializeTiles method is for initialize the tiles such as grass, river and home tile
     * 
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
    /*initializePlayers methods is for initializing the two players and assigning their playerID
     * 
     */
    private void initializePlayers() {
    	players[0] = new Player(1, this);
    	players[1] = new Player(2, this);
    	//Player p2 = new Player(2);
    	//players[0] = p2;
    }
/*getTiles method is to print out the state of the game board 
 * 
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
    /*getTilesArray is a getter for the tiles
     * 
     */
    public Tile[][] getTilesArray() {
        return tiles;
    }
    /* getPlayer Method is a getting for the playerID from the parameter pID
     * @param pID as an integer
     * @return players[pID-1] as a Player array
     */
    public Player getPlayer(int pID) {
    	return players[pID-1];
    }

    // Make method to restart tile status when animal is destroyed
    // make method that 
}