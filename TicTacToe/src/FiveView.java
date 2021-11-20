import java.awt.*;
import javax.swing.*;

public class FiveView extends JPanel {

    private final int BOX_SIZE = 26; // how many pixels wide/height a box is

    private FiveModel model;

    public FiveView(FiveModel model) {
        this.model = model;
        int w = model.getWidth() * BOX_SIZE;
        setPreferredSize(new java.awt.Dimension(w,w));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0; i < model.getWidth(); i++) {
            for (int j=0; j < model.getWidth(); j++) {
                FiveCell c = model.getCell(i,j);
                int x = i * BOX_SIZE;
                int y = j * BOX_SIZE;
                if (c == FiveCell.RING) {
                    g.setColor(Color.RED);
                    g.drawOval(x+2, y+2, BOX_SIZE-4, BOX_SIZE-4);
                } else if (c == FiveCell.CROSS) {
                    g.setColor(Color.BLUE);
                    g.drawLine(x+2, y+2, x+BOX_SIZE-2, y+BOX_SIZE-2);
                    g.drawLine(x+BOX_SIZE-2, y+2, x+2, y+BOX_SIZE-2);
                }
                g.setColor(Color.BLACK);
                g.drawRect(i * BOX_SIZE, j * BOX_SIZE, BOX_SIZE, BOX_SIZE);
            }
        }
        if (model.isGameOver()) {
            g.setColor(Color.WHITE);
            g.fillRect(getWidth() / 3, getHeight() / 2, getWidth() / 3, 40);
            g.setColor(Color.BLACK);
            g.drawString("Game Over: " + model.getWinner() + " wins",getWidth() / 3, getHeight() / 2 + 25);
        }
    }

    public int getBoxSize() {
        return BOX_SIZE;
    }

}
