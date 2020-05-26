package pieces;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public abstract class PlayingPiece extends JButton implements ChangeListener {
    private int x;
    private int y;
    private boolean pressed;

    public PlayingPiece(int x, int y) {
        this.x = x;
        this.y = y;

        setContentAreaFilled(false);
        setBorderPainted(false);
        getModel().addChangeListener(this);
    }

    public void paintComponent(Graphics g) {
        //System.out.println("paintComponent " + x + " " + y);
        Graphics2D graph = (Graphics2D) g;

        ImageIcon imageIcon = new ImageIcon(getImagePath());
        Image image = imageIcon.getImage();

        graph.drawImage(image, this.x, this.y, 60, 60, null);
    }

    public abstract String getImagePath();

    public void render() {
        if (pressed) {
            x = (int) MouseInfo.getPointerInfo().getLocation().getX();
            y = (int) MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println("render " + x + " " + y);
            this.update(getGraphics());
        }
    }


    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        System.out.println("stateChanged");
        ButtonModel model = (ButtonModel) changeEvent.getSource();
        pressed = model.isPressed();
    }
}
