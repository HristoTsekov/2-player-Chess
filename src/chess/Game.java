package chess;

import pieces.King;
import pieces.Piece;

import java.util.ArrayList;

public class Game {

    private ArrayList<Piece> pieces = new ArrayList<>();

    public Game() {
        UI ui = new UI(600, 600, "Chess");
        pieces.add(new King(100, 100, true));
        pieces.add(new King(150, 150, false));

        for (Piece piece: pieces) {
            ui.addGraphic(piece);
        }

        ui.drawChessGrid();
    }

    void play() {
        while (true) {
            for (Piece piece: pieces) {
                piece.render();
            }
        }
    }
}
