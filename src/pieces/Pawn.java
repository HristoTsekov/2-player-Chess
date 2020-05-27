package pieces;

public class Pawn extends PlayingPiece {

    private boolean hasBeenMoved;

    public Pawn(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean moveIsLegal(int newX, int newY) {

        boolean isLegal = false;

        int newPositionX = newX - this.getX();

        if (super.moveIsLegal(newX, newY)) {
            if ((!hasBeenMoved)
                    && (((Math.abs(newPositionX) <= 2) && getY() == newY))
                    && isValidTrace(newX, newY)) {
                isLegal = true;
            } else if ((hasBeenMoved)
                    && (((Math.abs(newPositionX) <= 1) && getY() == newY))
                    && isValidTrace(newX, newY)) {

                isLegal = true;
            }
        }
        return isLegal;
    }

    public boolean isValidTrace(int newX, int newY) {

        if (GameBoard.board[newX][newY] == null) {
            return true;
        }
        return false;

    }

    @Override
    public String getImagePath() {
        return null;
    }


}
