public class RoomController {
    private Room model;
    private RoomView view;

    public RoomController(Room model, RoomView view) {
        this.model = model;
        this.view = view;

        initializeView();
    }

    private void initializeView() {
        Tile[][] tiles = model.getTilesArray();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                view.updateTile(i, j, tiles[i][j].status);
            }
        }
        view.refresh(); // Refresh the view after initialization
    }

    public void updateTile(int row, int col, char status) {
        model.updateTileStatus(row, col, status);
        view.updateTile(row, col, status);
        view.refresh(); // Refresh the view after updating a tile
    }

    public void start() {
        System.out.println("RoomController started.");
        initializeView();
        // Additional logic to handle user input or other operations can be added here.
    }
}
