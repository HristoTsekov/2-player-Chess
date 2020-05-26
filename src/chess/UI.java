package chess;

import pieces.Piece;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UI {
    private JFrame frame = new JFrame();
    private int width;
    private int height;
    private ChessGrid chessGrid = new ChessGrid(0, 0, 600,
            600);

    UI(int widthSize, int heightSize, String name) {
        this.width = widthSize - 40;
        this.height = heightSize - 40;

        frame.setSize(widthSize - 24, heightSize - 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle(name);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void drawChessGrid() {
        frame.add(chessGrid);
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
