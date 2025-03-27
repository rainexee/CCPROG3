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
    }

    public void updateTile(int row, int col, char status) {
        model.updateTileStatus(row, col, status);
        view.updateTile(row, col, status);
    }
}
