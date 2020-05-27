package pieces;

public class Knight extends Piece{

private boolean isBlack;

    public Knight(int x, int y, boolean isBlack) {
        super(x, y);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackKnight.png" : "src\\images\\whiteKnight.png";
    }
}
