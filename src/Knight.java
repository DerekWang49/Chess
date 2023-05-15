import java.lang.Math;
public class Knight {
    private int row;
    private int column;
    private boolean isBlack;

    public Knight(int row, int column, boolean isBlack) {
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        // Determine if a knight can move to a given square
        if (board.verifySourceAndDestination(row, column, endRow, endCol, isBlack)) {
            System.out.println(row + column + endRow + endCol);
            if (Math.abs(endCol - column) == 2 && endRow - row == 1) {
                return true;
            } else if (Math.abs(endCol - column) == 2 && endRow - row == -1) {
                return true;
            } else if (Math.abs(endRow - row) == 2 && endCol - column == 1) {
                return true;
            } else if (Math.abs(endRow - row) == 2 && endCol - column == -1) {
                return true;
            }

        }
        return false;
    }
}
