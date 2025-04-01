//package m;
/*
 * This class is pretty much like the main class. It launches the game and the MVCS of the Coinflip and Game
 */

/*********************************************************************************************************
This is to certify that this project is my own work, based on my personal efforts in studying and applying the
concepts learned. I have constructed the functions and their respective algorithms and corresponding code by
myself. The program was run, tested, and debugged by my own efforts. I further certify that I have not copied
in part or whole or otherwise plagiarized the work of other students and/or persons.
<Juan Antonio Menchaca>, DLSU ID# <12110612>
<Elijah Raphael Murcia>, DLSU ID# <11901543>
*********************************************************************************************************/
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
