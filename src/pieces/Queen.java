package pieces;

public class Queen extends Piece {

    private boolean isBlack;

    public Queen(int x, int y, boolean isBlack) {
        super(x, y);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackQueen.png" : "src\\images\\whiteQueen.png";
    }
}
