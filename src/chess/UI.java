package chess;

import pieces.Piece;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI implements MouseListener {
    private JFrame frame = new JFrame();
    private int width;
    private int height;
    private ChessGrid chessGrid = new ChessGrid(0, 0, 555, 555);
    private MousePressedListener mousePressedListener;

    UI(int widthSize, int heightSize, String name) {
        this.width = widthSize - 40;
        this.height = heightSize - 40;

        frame.setSize(widthSize - 24, heightSize - 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle(name);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.addMouseListener(this);
    }

    public void drawChessGrid() {
        frame.add(chessGrid);
        frame.setVisible(true);
    }

    public void addGraphic(Piece piece) {
        if (piece == null) {
            return;
        }

        piece.addMouseListener(this);
        frame.add(piece);
        frame.setVisible(true);
    }

    public void removePiece(Piece piece) {
        if (piece != null) {
            frame.remove(piece);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setOnMousePressedListener(MousePressedListener listener) {
        mousePressedListener = listener;
    }

    public void movePiece(Piece piece) {
        if (piece != null) {
            piece.setPaintedX(getMouseX() - 34);
            piece.setPaintedY(getMouseY() - 34);
            piece.repaint();
        }
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece == null) {
            return;
        }
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        piece.setPaintedX(x);
        piece.setPaintedY(y);
        piece.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mousePressedListener != null) {
            int x = getMouseX();
            int y = getMouseY();
            mousePressedListener.onMousePressed(x, y);
        }
    }

    private int getMouseY() {
        return (int) MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocation().y - 30;
    }

    private int getMouseX() {
        return (int) MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocation().x - 10;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mousePressedListener != null) {
            mousePressedListener.onMouseReleased(getMouseX(), getMouseY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
