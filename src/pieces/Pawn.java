package pieces;

public class Pawn extends Piece {

    private boolean isBlack;

    public Pawn(int x, int y, boolean isBlack) {
        super(x, y);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackPawn.png" : "src\\images\\whitePawn.png";
    }
}
