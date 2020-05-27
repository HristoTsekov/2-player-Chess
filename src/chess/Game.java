package chess;

import pieces.*;

import java.util.ArrayList;

public class Game {

    private ArrayList<Piece> pieces = new ArrayList<>();

    public Game() {

        UI ui = new UI(600, 600, "Chess");
        pieces.add(new King(15, 15, true));
        pieces.add(new King(150, 150, false));
        pieces.add(new Queen(150, 150, true));
        pieces.add(new Queen(150, 150, false));
        pieces.add(new Bishop(150, 150, true));
        pieces.add(new Bishop(150, 150, false));
        pieces.add(new Knight(150, 150, true));
        pieces.add(new Knight(150, 150, false));
        pieces.add(new Rook(150, 150, true));
        pieces.add(new Rook(150, 150, false));
        pieces.add(new Pawn(150, 150, true));
        pieces.add(new Pawn(150, 150, false));

        for (Piece piece : pieces) {
            ui.addGraphic(piece);
        }

        ui.drawChessGrid();
    }

    void play() {
        while (true) {
            for (Piece piece : pieces) {
                piece.render();
            }
        }
    }
}
