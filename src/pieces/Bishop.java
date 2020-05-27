package pieces;

public class Bishop extends Piece {
    private boolean isBlack;

    public Bishop(int x, int y, boolean isBlack) {
        super(x, y);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackBishop.png" : "src\\images\\whiteBishop.png";
    }
}
