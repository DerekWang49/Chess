public class King {
    private int row;
    private int column;
    private boolean isBlack;

    public King (int row, int column, boolean isBlack) {
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(row, column, endRow, endCol, isBlack)) {
            if (board.verifyAdjacent(row, column, endRow, endCol)) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                    }
                }
                return true;
            }
        }
        return false;
    }
}
