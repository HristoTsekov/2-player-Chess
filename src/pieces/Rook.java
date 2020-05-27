package pieces;

public class Rook extends Piece {

    private boolean isBlack;

    public Rook(int x, int y, boolean isBlack) {
        super(x, y);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackRook.png" : "src\\images\\whiteRook.png";
    }
}
