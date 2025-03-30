public class GameModel {
    private Room room;

    public GameModel() {
        // Initialize your game from your existing code.
        room = new Room(1);
        // For example, set Player 1 as starting (you might want to decide this more robustly)
        room.getPlayer(1).turnActive = true;
    }

    public Room getRoom() {
        return room;
    }
    
    public boolean isGameOver() {
        return room.getPlayer(1).getWinState() == 1 || room.getPlayer(2).getWinState() == 1;
    }

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

    // Add this method to retrieve a player from the room
    public Player getPlayer(int playerID) {
        return room.getPlayer(playerID);
    }
}