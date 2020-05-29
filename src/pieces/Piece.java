package pieces;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public abstract class Piece extends JButton {

    private int x;
    private int y;
//    private boolean pressed;

    public Piece(int x, int y) {
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

//    //public void render() {
//   //     if (pressed) {
//    //        x = (int) MouseInfo.getPointerInfo().getLocation().getX() - getLocation().x;
//            y = (int) MouseInfo.getPointerInfo().getLocation().getY() - getLocation().y;
//            repaint();
//        }
//    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public void setPressed(boolean pressed) {
//        System.out.println("set pressed " + pressed);
//        this.pressed = pressed;
//    }
}
