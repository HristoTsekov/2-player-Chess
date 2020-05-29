package pieces;

public class Bishop extends Piece {


    public Bishop(int x, int y, boolean isBlack) {
        super(x, y, isBlack);

    }

    @Override
    public String getImagePath() {
        return isBlack ? "src/images/blackBishop.png" : "src/images/whiteBishop.png";
    }

    @Override
    public boolean isLegalMove(int currX, int currY, int nextY, int nextX, Piece[][] board) {
        //upper left
        if (currX - nextX == currY - nextY && currX - nextX > 0) {
            for (int i = 1; i < currX - nextX; i++) {
                if (board[currY - i][currX - i] != null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        //upper right
        else if (nextX - currX == currY - nextY && nextX - currX > 0) {
            for (int i = 1; i < nextX - currX; i++) {
                if (board[currY - i][currX + i] != null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        //lower left
        else if (currX - nextX == nextY - currY && currX - nextX > 0) {
            for (int i = 1; i < currX - nextX; i++) {
                if (board[currY + i][currX - i] != null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        //lower right
        else if (nextX - currX == nextY - currY && nextX - currX > 0) {
            for (int i = 1; i < nextX - currX; i++) {
                if (board[currY + i][currX + i] != null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        return false;

    }
}
