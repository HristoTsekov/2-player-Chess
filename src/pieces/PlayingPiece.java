package pieces;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public abstract class PlayingPiece extends JButton {
    private int x;
    private int y;
    private boolean pressed;

    public PlayingPiece(int x, int y) {
        this.x = x;
        this.y = y;
        setPreferredSize(new Dimension(40, 40));

        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    public void paintComponent(Graphics g) {

        Graphics2D graph = (Graphics2D) g;

        ImageIcon imageIcon = new ImageIcon(getImagePath());
        Image image = imageIcon.getImage();

        graph.drawImage(image, this.x, this.y, 60, 60, null);
    }

    public abstract String getImagePath();

    public void render() {
        if (pressed) {
            int x = (int) MouseInfo.getPointerInfo().getLocation().getX() - getLocation().x;
            int y = (int) MouseInfo.getPointerInfo().getLocation().getY() - getLocation().y;
            System.out.println("x " + x + " y " + y);
            System.out.println("real x " + this.x + " y " + this.y);
            repaint();
        }
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
}

