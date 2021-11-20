import java.awt.event.*;
import javax.swing.*;

/**
 * Tic-Tac-Toe Five in a row
 * Demo from schoolclass
 */

public class FiveControl extends JFrame {

    public FiveControl() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400); setLocation(50,50);
        FiveModel model = new FiveModel(15);
        FiveView view = new FiveView(model);
        MouseListener ml = new MouseListener() {
            public void mousePressed(MouseEvent e) {
                if (!model.isGameOver()) {
                    int b = view.getBoxSize();
                    int i = e.getX() / b;
                    int j = e.getY() / b;
                    model.clickIndex(i,j);
                    view.repaint();
                }
            }
            public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        };
        view.addMouseListener(ml);
        add(view); pack(); setVisible(true);
    }

    public static void main(String[] args) {
        FiveControl f = new FiveControl();
    }

}
