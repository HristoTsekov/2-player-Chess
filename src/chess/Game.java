package chess;

import pieces.*;

public class Game {

    private PlayingPiece[][] board = new PlayingPiece[8][8];
    private PlayingPiece pressedPiece;

    public Game() {

        UI ui = new UI(600, 600, "Chess");
        init(ui);
        ui.drawChessGrid();
        ui.setOnMousePressedListener(new MousePressedListener() {
            @Override
            public void onMousePressed(int x, int y) {
                int row = (x / 70) - 1;
                int col = (y / 70) - 1;
                PlayingPiece piece = board[col][row];
                System.out.println("piece " + piece);
                if (piece != null) {
                    pressedPiece = piece;
                    piece.setPressed(true);
                }

                System.out.println("row " + row + "col " + col);
            }

            @Override
            public void onMouseReleased() {
                if (pressedPiece != null) {
                    pressedPiece.setPressed(false);
                }
            }
        });
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
                board[i][j] =null;
            }
        }
        for (PlayingPiece[] playingPieces : board) {
            for (PlayingPiece playingPiece : playingPieces) {
                if (playingPiece != null) {
                    ui.addGraphic(playingPiece);
                }
            }
        }
    }

    void play() {
        while (true) {
            for (PlayingPiece[] playingPieces : board) {
                for (PlayingPiece playingPiece : playingPieces) {
                    if (playingPiece != null) {
                        playingPiece.render();
                    }
                }
            }
        }
    }
}
