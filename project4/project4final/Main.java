import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Minefield minefield;
        boolean gameOver = false;
        boolean debug = false;
        // Difficulty
        System.out.println("Select difficulty: easy (E), medium (M), hard (H)");
        Scanner myScanner = new Scanner(System.in);
        String difficulty = myScanner.nextLine();
        // Debugging
        System.out.println("Debug mode on? Y/N");
        myScanner = new Scanner(System.in);
        if (myScanner.nextLine().equals("Y")) {
            debug = true;
        }
        // Starting coordinates
        System.out.println("Enter the starting coordinates: [x] [y]");
        myScanner = new Scanner(System.in);
        String coordinates = myScanner.nextLine();
        String[] corArray = coordinates.split(" ");
        int x = Integer.parseInt(corArray[0]);
        int y = Integer.parseInt(corArray[1]);
        // Game setup
        if (difficulty.equals("E")) {
            minefield = new Minefield(5, 5, 5);
            minefield.createMines(x, y, 5);
        }
        else if (difficulty.equals("M")) {
            minefield = new Minefield(9, 9, 12);
            minefield.createMines(x, y, 12);
        }
        else {
            minefield = new Minefield(20 , 20, 40);
            minefield.createMines(x, y, 40);
        }
        minefield.evaluateField();
        minefield.revealMines(x, y);
        minefield.revealZeroes(x, y);
        // Game state
        while (!gameOver) {
            if (debug) {
                minefield.printMinefield();
            }
            System.out.println(minefield);
            System.out.println("Enter a coordinate and if you wish to place a flag (Remaining: " +
                    minefield.getFlags() + ") [x] [y] [Y/else]");
            myScanner = new Scanner(System.in);
            String input = myScanner.nextLine();
            String[] guess = input.split(" ");
            // Flag
            if (guess[2].equals("Y")) {
                if (minefield.guess(Integer.parseInt(guess[0]), Integer.parseInt(guess[1]), true)) {
                    System.out.println("You lose!");
                    break;
                }
            }
            // No flag
            else {
                if (minefield.guess(Integer.parseInt(guess[0]), Integer.parseInt(guess[1]), false)) {
                    System.out.println("You lose");
                    break;
                }

            }
            gameOver = minefield.gameOver();


        }
        System.out.println("Game over!");
    }
}