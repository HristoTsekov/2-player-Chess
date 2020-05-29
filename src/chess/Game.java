package chess;

import pieces.*;

public class Game {

    UI ui;

    private Piece[][] board = new Piece[8][8];
    private Piece pressedPiece;
    private int selectedRow;
    private int selectedCol;

    public Game() {

        ui = new UI(600, 600, "Chess");
        init(ui);
        ui.drawChessGrid();
        ui.setOnMousePressedListener(new MousePressedListener() {
            @Override
            public void onMousePressed(int x, int y) {
                System.out.println("pressed x " + x + " y " + y);
                int col = getCellByCordinate(x);
                int row = getCellByCordinate(y);

                Piece piece = board[row][col];
                if (piece != null) {
                    System.out.println("set pressed " + piece);
                    pressedPiece = piece;
                    selectedCol = col;
                    selectedRow = row;
                    //piece.setPressed(true);
                }

                System.out.println("row " + col + "col " + row);
            }

            @Override
            public void onMouseReleased(int x, int y) {
                if (pressedPiece != null) {
                    int col = getCellByCordinate(x);
                    int row = getCellByCordinate(y);
                    ui.removePiece(board[row][col]);

                    board[selectedRow][selectedCol] = null;
                    board[row][col] = pressedPiece;
                    pressedPiece = null;
                    //pressedPiece.setPressed(false);
                }
            }
        });
    }

    private int getCellByCordinate(int cord) {
        int row = (cord / 67);
        if (row > 7) {
            row = 7;
        }
        return row;
    }

    public void init(UI ui) {
        int figureWidth = 70;
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Pawn(figureWidth * i, figureWidth, true);
            board[6][i] = new Pawn(figureWidth * i, figureWidth * 6, false);
        }
        board[0][0] = new Rook(0, 0, true);
        board[0][1] = new Knight(figureWidth, 0, true);
        board[0][2] = new Bishop(figureWidth * 2, 0, true);
        board[0][3] = new Queen(figureWidth * 3, 0, true);
        board[0][4] = new King(figureWidth * 4, 0, true);

        board[0][5] = new Bishop(figureWidth * 5, 0, true);
        board[0][6] = new Knight(figureWidth * 6, 0, true);
        board[0][7] = new Rook(figureWidth * 7, 0, true);

        board[7][0] = new Rook(0, figureWidth * 7, false);
        board[7][1] = new Knight(figureWidth, figureWidth * 7, false);
        board[7][2] = new Bishop(figureWidth * 2, figureWidth * 7, false);
        board[7][3] = new Queen(figureWidth * 3, figureWidth * 7, false);
        board[7][4] = new King(figureWidth * 4, figureWidth * 7, false);
        board[7][5] = new Bishop(figureWidth * 5, figureWidth * 7, false);
        board[7][6] = new Knight(figureWidth * 6, figureWidth * 7, false);
        board[7][7] = new Rook(figureWidth * 7, figureWidth * 7, false);
        for (int i = 2; i < board.length - 2; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = null;
            }
        }
        for (Piece[] playingPieces : board) {
            for (Piece playingPiece : playingPieces) {
                if (playingPiece != null) {
                    ui.addGraphic(playingPiece);
                }
            }
        }
    }

    void play() {
        while (true) {
            System.out.print("");
            ui.movePiece(pressedPiece);
        }
    }
}
