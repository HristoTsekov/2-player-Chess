package pieces;

public class Queen extends Piece {

    public Queen(int x, int y, boolean isBlack) {
        super(x, y,isBlack);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src/images/blackQueen.png" : "src/images/whiteQueen.png";
    }

    public boolean isLegalMove(int currX, int currY, int nextY, int nextX,Piece[][]board) {
        //columns move
        if(currY == nextY && nextX != currX) {
            if(nextX > currX) {
                for (int i = currX + 1; i < nextX; i++) {
                    if (board[currY][i] != null) return false;
                }
                return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
            }
            else for (int i = currX - 1; i > nextX ; i--) {
                if (board[currY][i]!=null) return false;
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

        //upper left
        else if(currX - nextX == currY - nextY && currX - nextX > 0) {
            for (int i = 1; i < currX - nextX; i++) {
                if (board[currY - i][currX - i]!= null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        //upper right
        else if(nextX - currX == currY - nextY && nextX - currX > 0) {
            for (int i = 1; i < nextX - currX; i++) {
                if (board[currY - i][currX + i]!=null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        //lower left
        else if(currX - nextX == nextY - currY && currX - nextX > 0) {
            for (int i = 1; i < currX - nextX; i++) {
                if (board[currY + i][currX - i] != null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        //lower right
        else if(nextX - currX == nextY - currY && nextX - currX > 0) {
            for (int i = 1; i < nextX - currX; i++) {
                if (board[currY + i][currX + i] !=null) return false;
            }
            return board[nextY][nextX] == null || board[nextY][nextX].isBlack() != isBlack;
        }
        return false;
    }
}
