package pieces;

public class Knight extends PlayingPiece {

private boolean isBlack;

    public Knight(int x, int y, boolean isBlack) {
        super(x, y);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackKnight.png" : "src\\images\\whiteKnight.png";
    }


    @Override
    public boolean moveIsLegal(int newX, int newY) {

        int newPositionX = newX - getX();
        int newPositionY = newY - getY();

        if (super.moveIsLegal(newX, newY)) {
            if (((Math.abs(newPositionX) == 2) && (Math.abs(newPositionY) == 1))
                    || ((Math.abs(newPositionY) == 2) && (Math
                    .abs(newPositionX) == 1))
                    && isValidTrace(newX, newY)) {

                return true;
            }
        }
        return false;
    }

    public boolean isValidTrace(int newX, int newY) {

        if ((GameBoard.board[newX][newY]) != null) {
            if (GameBoard.board[newX][newY].getColor() == this.getColor()) {
                return false;
            }
        }
        return true;

    }

}
