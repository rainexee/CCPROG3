import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RoomView {
    private JFrame frame;
    private JPanel gridPanel;
    private JButton[][] tileButtons;

    public RoomView(int rows, int cols) {
        frame = new JFrame("Room GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gridPanel = new JPanel(new GridLayout(rows, cols));
        tileButtons = new JButton[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tileButtons[i][j] = new JButton();
                tileButtons[i][j].setEnabled(true); 
                gridPanel.add(tileButtons[i][j]);
            }
        }

        frame.add(gridPanel);
        frame.pack(); // Adjust frame size to fit components
        frame.setVisible(true); // Ensure the frame is visible
    }

    public void updateTile(int row, int col, char status) {
        tileButtons[row][col].setText(String.valueOf(status));
    }

    public void enableTileInteraction(int row, int col, ActionListener listener) {
        tileButtons[row][col].setEnabled(true);
        tileButtons[row][col].addActionListener(listener);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible); // Ensure the JFrame visibility is controlled here
        if (visible) {
            System.out.println("RoomView is now visible.");
        }
    }

    public void refresh() {
        frame.repaint(); // Repaint the GUI
        frame.revalidate(); // Revalidate the layout
    }
}
