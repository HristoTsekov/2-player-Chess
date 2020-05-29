package pieces;

public class Bishop extends PlayingPiece {

    private boolean isBlack;

    public Bishop(int x, int y, boolean isBlack) {
        super(x, y);
        this.isBlack = isBlack;
    }

    @Override
    public String getImagePath() {
        return isBlack ? "src\\images\\blackBishop.png" : "src\\images\\whiteBishop.png";
    }


    @Override
    public boolean moveIsLegal(int newX, int newY) {

        int newPositionX = newX - getX();
        int newPositionY = newY - getY();

        int checkX = this.getX();
        int checkY = this.getY();

        if (super.moveIsLegal(newX, newY)
                && (Math.abs(newPositionX) == Math.abs(newPositionY))) {

            while (checkX != newX && checkY != newY) {

                if (this.isValidTrace(checkX, checkY, newX, newY)) {
                    return true;
                }

                if (checkX > newX) {
                    checkX--;
                } else if (this.getX() < newX) {
                    checkX++;
                }

                if (checkY > newY) {
                    checkY--;
                } else if (this.getY() < newY) {
                    checkY++;
                }

            }
        }

        return false;
    }

    public boolean isValidTrace(int newX, int newY, int lastX, int lastY) {

        boolean isValid = true;
        if ((GameBoard.board[newX][newY]) != null) {
            isValid = false;
        }
        if (((GameBoard.board[lastX][lastY]) != null)) {
            if (GameBoard.board[lastX][lastY].getColor() == this.getColor()) {
                isValid = false;
            } else {
                isValid = true;
            }
        }

        return isValid;

    }


}
