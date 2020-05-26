package pieces;

public class King extends Piece {

    boolean isBlack;

    public King(int x, int y, boolean isBlack) {
        super(x, y);

        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackKing.png" : "src\\images\\whiteKing.png";
    }
}
