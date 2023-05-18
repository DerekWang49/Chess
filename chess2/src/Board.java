import java.lang.Math;
public class Board {

    // Instance variables
    private Piece[][] board;
    private boolean enPassant = false;


    // Construct an object of type Board using given arguments.
    public Board() {
        board = new Piece[8][8];
    }

    // Accessor Methods


    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }


    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move
    // is legal, and to execute the move if it is. Your Game class should not 
    // directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
    if ((board[startRow][startCol] != null && board[startRow][startCol].isMoveLegal(this, endRow, endCol)) ||
            enPassant) {
            board[endRow][endCol] = board[startRow][startCol];
            board[endRow][endCol].setPosition(endRow, endCol);
            board[startRow][startCol] = null;
            enPassant = false;
            return true;
        }
        return false;
    }


    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        boolean whiteKingCaptured = true;
        boolean blackKingCaptured = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // Check if a square contains a king
                if (board[i][j] != null) {
                    if (board[i][j].getCharacter() == '\u2654') {
                        whiteKingCaptured = false;
                    } else if (board[i][j].getCharacter() == '\u265a') {
                        blackKingCaptured = false;
                    }
                }
            }
        }
        // Return true if one of the kings have been captured
        if (whiteKingCaptured) {
            System.out.println("Black has won the game!");
            return true;
        } else if (blackKingCaptured) {
            System.out.println("White has won the game!");
            return true;
        }
        return false;
    }

    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        String output = "   ";
        for (int i = 0; i < board.length; i++) {
            output += i + " " + String.valueOf('\u3000');
        }
        output += "\n";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
//                if (i == 0) {
//                    output += j + " " + String.valueOf('\u3000');
//                }
                if (j == 0) {
                    output += i;
                }
                if (board[i][j] != null) {
                    output += " |" + board[i][j].getCharacter();
                }
                else {
                    output += " |" + String.valueOf('\u3000');

                }
            }
            output += "\n";
        }
        return output;
    }

    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = null;
            }
        }
    }

    // Movement helper functions

    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (0 <= startRow && startRow < board.length && 0 <= startCol && startCol < board[0].length) {
            if (0 <= endRow && endRow < board.length && 0 <= endCol && endCol < board[0].length) {
                if (board[startRow][startCol] != null) {
                    if (board[startRow][startCol].getIsBlack() == isBlack) {
                        if (board[endRow][endCol] == null ||
                                board[endRow][endCol].getIsBlack() != board[startRow][startCol].getIsBlack()) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        // Check for horizontal, vertical, or diagonal adjacent squares
        if (Math.abs(startRow - endRow) == 1 && startCol - endCol == 0) {
            return true;
        } else if (Math.abs(startCol - endCol) == 1 && startRow - endRow == 0) {
            return true;
        } else if (Math.abs(startCol - endCol) == 1 && Math.abs(startRow - endRow) == 1) {
            return true;
        }
        else if (startCol == endCol && startRow == endRow) {
            return true;
        }

        return false;
    }

    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        // Check if going left or right
        int constCol = 1;
        if (endCol < startCol) {
            constCol = -1;
        }
        if (startRow == endRow) {
            for (int j = 0; j < Math.abs(endCol - startCol) - 1; j++) {
                if (board[startRow][startCol + j * constCol + constCol] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        // Check if going up or down
        int constRow = 1;
        if (endRow < startRow) {
            constRow = -1;
        }
        if (startCol == endCol) {
            for (int i = 0; i < Math.abs(endRow - startRow) - 1; i++) {
                if (board[startRow + i * constRow + constRow][startCol] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
//        if (Math.abs(endCol - startCol) == Math.abs(endRow - startRow)) {
//            for (int i = 0; i < Math.abs(endRow - startRow) - 1; i++) {
//                if (board[startRow + i + 1][startCol + i + 1] != null) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;

        // Check the direction of the diagonal squares
        int constCol = 1;
        int constRow = 1;
        if (endCol < startCol) {
            constCol = -1;
        }
        if (endRow < startRow) {
            constRow = -1;
        }
        if (Math.abs(endCol - startCol) == Math.abs(endRow - startRow)) {
            for (int i = 0; i < Math.abs(endCol - startCol) - 1; i++) {
                if (board[startRow + i * constRow + constRow][startCol + i * constCol + constCol] != null) {
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    public boolean getEnPassant() {
        return enPassant;
    }

    public void setEnPassant(boolean enPassantState) {
        enPassant = enPassantState;
    }
}
