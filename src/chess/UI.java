package chess;

import pieces.Piece;

import javax.swing.*;

public class UI {
    JFrame frame = new JFrame();
    int width;
    int height;

    UI(int widthSize, int heightSize, String name) {
        this.width = widthSize - 40;
        this.height = heightSize - 40;

        frame.setSize(widthSize - 24, heightSize - 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle(name);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public void addGraphic(Piece piece) {
        frame.add(piece);
        frame.setVisible(true);
    }

    public void removeGraphic(Piece piece) {
        frame.remove(piece);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}