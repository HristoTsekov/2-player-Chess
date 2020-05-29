package pieces;

public class King extends Piece {


    public King(int x, int y, boolean isBlack) {
        super(x, y, isBlack);

        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackKing.png" : "src\\images\\whiteKing.png";
    }

    public boolean isLegalMove(int currX, int currY, int nextY, int nextX, Piece[][] board) {
        if ((Math.abs(currX - nextX) == 1 || currX == nextX) && (Math.abs(currY - nextY) == 1 || currY == nextY)
                && board[nextY][nextX].isBlack() != isBlack && !false) {//todo isKingUnderThread
            //    if(!isBlack) Chess.board.whiteKingCords.makeEqual(nextX, nextY);
            //    else if(color == 'b') Chess.board.blackKingCords.makeEqual(nextX, nextY);
            return true;
        }
        return false;
    }
}

