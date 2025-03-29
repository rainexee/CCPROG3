package m;

public class GameLauncher {
    public static void main(String[] args) {
        // Create the model, view, and controller.
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
    }
}
