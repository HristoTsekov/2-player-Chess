package pieces;

public class King extends PlayingPiece {

    public King(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean moveIsLegal(int newX, int newY) {

        int newPositionX = newX - getX();
        int newPositionY = newY - getY();
        int checkX = this.getX();
        int checkY = this.getY();

        if (super.moveIsLegal(newX, newY)) {

            if ((Math.abs(newPositionX) == 1) && (newY == getY())) {

                while (checkX != newX) {

                    if (this.isValidTraceX(checkX, newY, newX)) {
                        return true;
                    }

                    if (checkX > newX) {
                        checkX--;
                    } else if (this.getX() < newX) {
                        checkX++;
                    }

                }

            } else if ((newX == getX()) && (Math.abs(newPositionY) == 1)) {

                while (checkY != newY) {

                    if (this.isValidTraceY(newX, checkY, newY)) {
                        return true;
                    }

                    if (checkY > newY) {
                        checkY--;
                    } else if (this.getY() < newY) {
                        checkY++;
                    }

                }

            } else if ((Math.abs(newPositionY) == 1) == (Math.abs(newPositionX) == 1)) {

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

        }
        return false;
    }

    public boolean isValidTraceX(int newX, int newY, int lastX) {

        boolean isValid = true;
        if ((GameBoard.board[newX][newY]) != null) {
            isValid = false;
        }
        if (((GameBoard.board[lastX][newY]) != null)) {
            if (GameBoard.board[lastX][newY].getColor() == this.getColor()) {
                isValid = false;
            } else {
                isValid = true;
            }
        }

        return isValid;

    }

    public boolean isValidTraceY(int newX, int newY, int lastY) {

        boolean isValid = true;
        if ((GameBoard.board[newX][newY]) != null) {
            isValid = false;
        }
        if (((GameBoard.board[newX][lastY]) != null)) {
            if (GameBoard.board[newX][lastY].getColor() == this.getColor()) {
                isValid = false;
            } else {
                isValid = true;
            }
        }

        return isValid;

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
