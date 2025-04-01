//package m;
/*
 * This class is pretty much like the main class. It launches the game and the MVCS of the Coinflip and Game
 */
public class GameLauncher {
    /*
     * Main method that runs the MVC's
     */
    public static void main(String[] args) {

        CoinflipModel cfmodel = new CoinflipModel();
        CoinflipView cfview = new CoinflipView();
        CoinflipController cfcontroller = new CoinflipController(cfmodel, cfview);
        cfcontroller.start();
        // Create the model, view, and controller.

        while (cfview.isVisible()) {
            try {
                Thread.sleep(100); // Check every 100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int startingPlayer = cfcontroller.getWinner();

        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        
        model.setStartingPlayer(startingPlayer);
        // Start the game.
        controller.startGame();
    }
}
