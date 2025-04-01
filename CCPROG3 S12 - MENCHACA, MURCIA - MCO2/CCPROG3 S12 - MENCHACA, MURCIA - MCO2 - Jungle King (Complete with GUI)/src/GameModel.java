//package m;

/*
 * This is the class for the model of the Game in order to implement the MVC's
 *
 */
public class GameModel {
    private Room room;

    /*
     * This is the constructor of the GameaModel and it initializes a room for the player and defaults player 1 starting
     */
    public GameModel() {
        // Initialize your game from your existing code.
        room = new Room(1);
        // Defaults to player1 stater 
        room.getPlayer(1).turnActive = true;
    }
/*
 * This is a getter for the room
 * @return room 
 */
    public Room getRoom() {
        return room;
    }
    /*
     * This returns the winstate of either player1 or player2
     */
    public boolean isGameOver() {
        return room.getPlayer(1).getWinState() == 1 || room.getPlayer(2).getWinState() == 1;
    }
    /*
     * This is the method the sets the starting player. It will either be player 1 or player 2
     */
    public void setStartingPlayer(int playerID) {
        // Logic to set the starting player
        if (playerID == 1) {
            getPlayer(1).turnActive = true;
            getPlayer(2).turnActive = false;
        } else {
            getPlayer(1).turnActive = false;
            getPlayer(2).turnActive = true;
        }
    }

    /*
     * This method returns the playerID from the room
     */
    public Player getPlayer(int playerID) {
        return room.getPlayer(playerID);
    }
}