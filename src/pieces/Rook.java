package pieces;

public class Rook extends Piece {

    public Rook(int x, int y, boolean isBlack) {
        super(x, y,isBlack);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src/images/blackRook.png" : "src/images/whiteRook.png";
    }
    @Override
    public boolean isLegalMove(int currX, int currY, int nextY, int nextX,Piece[][] board) {
    //columns move
    if(currY == nextY && nextX != currX) {
        if(nextX > currX) {
            for (int i = currX + 1; i < nextX; i++) {
                if (board[currY][i]!= null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        else for (int i = currX - 1; i > nextX ; i--) {
            if (board[currY][i] != null) return false;
        }
        return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;

    }

    //rows move
    else if(currX == nextX && currY != nextY) {
        if(nextY > currY) {
            for (int i = currY + 1; i < nextY; i++) {
                if (board[i][currX] != null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        else for (int i = currY - 1; i > nextY ; i--) {
            if (board[i][currX] != null) return false;
        }
        return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
    }

    return false;
    }
}
