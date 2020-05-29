package pieces;

public class Knight extends Piece {

    public Knight(int x, int y, boolean isBlack) {
        super(x, y, isBlack);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackKnight.png" : "src\\images\\whiteKnight.png";
    }

    public boolean isLegalMove(int currX, int currY, int nextY, int nextX, Piece[][] board) {
        return ((nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8)
                && ((nextX - currX == 2 && nextY - currY == 1)
                || (nextX - currX == 2 && currY - nextY == 1)
                || (nextY - currY == 2 && nextX - currX == 1)
                || (nextY - currY == 2 && currX - nextX == 1)
                || (currX - nextX == 2 && nextY - currY == 1)
                || (currX - nextX == 2 && currY - nextY == 1)
                || (currY - nextY == 2 && nextX - currX == 1)
                || (currY - nextY == 2 && currX - nextX == 1))
                && isBlack != board[nextY][nextX].isBlack());
    }
}

