public class Rook {
    private int row;
    private int column;
    private boolean isBlack;

    public Rook (int row, int column,  boolean isBlack) {
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(row, column, endRow, endCol, isBlack)) {
            if (board.verifyVertical(row, column, endRow, endCol) ||
                    board.verifyHorizontal(row, column, endRow, endCol)) {
                return true;
            }
        }
        return false;
    }
}
