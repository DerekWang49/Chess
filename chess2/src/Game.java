import java.util.Scanner;
public class Game {
    public Game() {
    }

    public static void main(String[] args) {
        // Starts at white's turn
        boolean blackTurn = false;
        Board board = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Set up white pieces
                if (i == 7) {
                    if (j == 0 || j == 7) {
                        board.setPiece(i, j, new Piece('\u2656', i, j, false));
                    } else if (j == 1 || j == 6) {
                        board.setPiece(i, j, new Piece('\u2658', i, j, false));
                    } else if (j == 2 || j == 5) {
                        board.setPiece(i, j, new Piece('\u2657', i, j, false));
                    } else if (j == 3) {
                        board.setPiece(i, j, new Piece('\u2655', i, j, false));
                    } else {
                        board.setPiece(i, j, new Piece('\u2654', i, j, false));
                    }
                }
                if (i == 6) {
                    board.setPiece(i, j, new Piece('\u2659', i, j, false));
                }
                // Set up black pieces
                if (i == 1) {
                    board.setPiece(i, j, new Piece('\u265f', i, j, true));
                }
                if (i == 0) {
                    if (j == 0 || j == 7) {
                        board.setPiece(i, j, new Piece('\u265c', i, j, true));
                    } else if (j == 1 || j == 6) {
                        board.setPiece(i, j, new Piece('\u265e', i, j, true));
                    } else if (j == 2 || j == 5) {
                        board.setPiece(i, j, new Piece('\u265d', i, j, true));
                    } else if (j == 3) {
                        board.setPiece(i, j, new Piece('\u265b', i, j, true));
                    } else {
                        board.setPiece(i, j, new Piece('\u265a', i, j, true));
                    }
                }


            }
        }
        System.out.println(board);
        // Check if both kings are still on the board
        while (board.isGameOver() == false) {
            Scanner s = new Scanner(System.in);
            if (blackTurn) {
                System.out.println("It is currently black's turn");
            } else {
                System.out.println("It is currently white's turn");
            }

            System.out.println("What is your move? (format: [start row] [start col] " +
                    "[end row] [end col])");
            String input = s.nextLine();
            String[] data = input.split(" ");
            int startRow = Integer.parseInt(data[0]);
            int startCol = Integer.parseInt(data[1]);
            int endRow = Integer.parseInt(data[2]);
            int endCol = Integer.parseInt(data[3]);
            // Check for legality of move
            if (board.verifySourceAndDestination(startRow, startCol, endRow, endCol, blackTurn)) {
                if (board.movePiece(startRow, startCol, endRow, endCol)) {
                    blackTurn = !blackTurn;
                    System.out.println(board);
                } else {
                    System.out.println("Illegal move");
                    System.out.println(board);
                }
            }
            else {
                System.out.println("Invalid input");
            }


        }
        System.out.println("Game over");

    }
}

