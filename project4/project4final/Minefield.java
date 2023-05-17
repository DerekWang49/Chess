import java.util.Random;

public class Minefield {
    /**
    Global Section
    */
    private Cell[][] minefield;
    private int tempCount;
    private int mines;
    private int flags;

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE_BRIGHT = "\u001b[34;1m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_RED_BRIGHT = "\u001b[31;1m";
    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_GREY_BG = "\u001b[0m";
    /**
     * Constructor
     * @param rows       Number of rows.
     * @param columns    Number of columns.
     * @param flags      Number of flags, should be equal to mines
     */
    public Minefield(int rows, int columns, int flags) {
        minefield = new Cell[rows][columns];
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[0].length; j++) {
                minefield[i][j] = new Cell(false, "-");
            }
        }
        tempCount = 0;
        this.mines = flags;
        this.flags = flags;

    }
    /**
     * evaluateField
     *
     * @function When a mine is found in the field, calculate the surrounding 9x9 tiles values. If a mine is found, increase the count for the square.
     */
    public void evaluateField() {
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[0].length; j++) {
                // Loop through each square
                if (!minefield[i][j].getStatus().equals("M")) {
                    // Increase surrounding square counts for each mine
                    if (i - 1 >= 0) {
                        if (j - 1 >= 0) {
                            if (minefield[i - 1][j - 1].getStatus().equals("M")) {
                                tempCount += 1;
                            }
                        }
                        if (j + 1 < minefield.length) {
                            if (minefield[i - 1][j + 1].getStatus().equals("M")) {
                                tempCount += 1;
                            }
                        }
                        if (minefield[i - 1][j].getStatus().equals("M")) {
                            tempCount += 1;
                        }
                    }
                    if (i + 1 < minefield.length) {
                        if (j - 1 >= 0) {
                            if (minefield[i + 1][j - 1].getStatus().equals("M")) {
                                tempCount += 1;
                            }
                        }

                        if (j + 1 < minefield.length) {
                            if (minefield[i + 1][j + 1].getStatus().equals("M")) {
                                tempCount += 1;
                            }
                        }
                        if (minefield[i + 1][j].getStatus().equals("M")) {
                            tempCount += 1;
                        }

                    }
                    if (j - 1 >= 0) {
                        if (minefield[i][j - 1].getStatus().equals("M")) {
                            tempCount += 1;
                        }
                    }

                    if (j + 1 < minefield.length) {
                        if (minefield[i][j + 1].getStatus().equals("M")) {
                            tempCount += 1;
                        }
                    }
                    minefield[i][j].setStatus(String.valueOf(tempCount));
                    tempCount = 0;
                }

            }
        }
    }
    /**
     * createMines
     *
     * @param x       Start x, avoid placing on this square.
     * @param y        Start y, avoid placing on this square.
     * @param mines      Number of mines to place.
     */
    public void createMines(int x, int y, int mines) {
        Random ran = new Random();
        for (int i = 0; i < mines; i++) {
            int randX = ran.nextInt(minefield.length);
            int randY = ran.nextInt(minefield[0].length);
            // Check if random integers don't match revealed or inputted coordinates
            while (minefield[randX][randY].getRevealed() || minefield[randX][randY].getStatus().equals("M") ||
                    (randX == x && randY == y)) {
                randX = ran.nextInt(minefield.length);
                randY = ran.nextInt(minefield[0].length);
            }
            minefield[randX][randY].setStatus("M");
        }

    }

    /**
     * guess
     *
     * @param x       The x value the user entered.
     * @param y       The y value the user entered.
     * @param flag    A boolean value that allows the user to place a flag on the corresponding square.
     * @return boolean Return false if guess did not hit mine or if flag was placed, true if mine found.
     */
    public boolean guess(int x, int y, boolean flag) {
        // Check for bounds
        if (0 <= x && x < minefield.length && 0 <= y && y < minefield.length) {
            // Place flag
            if (flag && flags != 0) {
                minefield[x][y].setStatus("F");
                flags -= 1;
            }
            if (!flag) {
                // Reveal surrounding zeroes to user
                if (minefield[x][y].getStatus().equals("0")) {
                    revealZeroes(x, y);
                }
                // End game
                else if (minefield[x][y].getStatus().equals("M")) {
                    return true;
                }
            }
            minefield[x][y].setRevealed(true);
        }
        else {
            System.out.println("Invalid coordinate");
        }
        return false;
    }
    /**
     * gameOver
     *
     * @return boolean Return false if game is not over and squares have yet to be revealed, otheriwse return true.
     */
    public boolean gameOver() {
        // Win state
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield.length; j++) {
                if (!minefield[i][j].getRevealed()) {
                    return false;
                }
            }
        }
        System.out.println("You win!");
        return true;
    }

    /**
     * revealField
     *
     * This method should follow the psuedocode given.
     * Why might a stack be useful here rather than a queue?
     *
     * @param x      The x value the user entered.
     * @param y      The y value the user entered.
     */
    public void revealZeroes(int x, int y) {
        Stack1Gen<int[]> mineStack = new Stack1Gen<>();
        mineStack.push(new int[]{x, y});
        int[] top;

        // Reveal surrounding zeros of squares
        while (mineStack.top() != null) {
            top = mineStack.pop();
            minefield[top[0]][top[1]].setRevealed(true);
            if (top[0] - 1 >= 0) {
                if (!minefield[top[0] - 1][top[1]].getRevealed() &&
                        minefield[top[0] - 1][top[1]].getStatus().equals("0")) {
                    mineStack.push(new int[]{top[0] - 1, top[1]});
                }

            }
            if (top[1] - 1 >= 0) {
                if (top[0] - 1 >= 0) {
                    if (!minefield[top[0]][top[1] - 1].getRevealed() &&
                            minefield[top[0]][top[1] - 1].getStatus().equals("0")) {
                        mineStack.push(new int[]{top[0], top[1] - 1});
                    }
                }

            }

            if (top[0] + 1 < minefield.length) {
                if (top[0] - 1 >= 0) {
                    if (!minefield[top[0] + 1][top[1]].getRevealed() &&
                            minefield[top[0] + 1][top[1]].getStatus().equals("0")) {
                        mineStack.push(new int[]{top[0] + 1, top[1]});
                    }
                }

            }

            if (top[1] + 1 < minefield.length) {
                if (top[0] - 1 >= 0) {
                    if (!minefield[top[0]][top[1] + 1].getRevealed() &&
                            minefield[top[0]][top[1] + 1].getStatus().equals("0")) {
                        mineStack.push(new int[]{top[0], top[1] + 1});
                    }
                }
            }



        }

    }

    /**
     * revealMines
     *
     * This method should follow the psuedocode given.
     * Why might a queue be useful for this function?
     *
     * @param x     The x value the user entered.
     * @param y     The y value the user entered.
     */
    public void revealMines(int x, int y) {
        Q1Gen<int[]> mineQueue = new Q1Gen<int[]>();
        mineQueue.add(new int[]{x, y});
        int[] temp = mineQueue.remove();
        // Give user squares until one mine is found
        while (temp != null) {
            minefield[temp[0]][temp[1]].setRevealed(true);
            if (minefield[temp[0]][temp[1]].getStatus().equals("M")) {
                break;
            }
            if (temp[0] - 1 >= 0) {
                if (!minefield[temp[0] - 1][temp[1]].getRevealed()) {
                    mineQueue.add(new int[]{temp[0] - 1, temp[1]});
                }
            }
            if (temp[1] - 1 >= 0) {
                if (!minefield[temp[0]][temp[1] - 1].getRevealed()) {
                    mineQueue.add(new int[]{temp[0] - 1, temp[1]});
                }
            }

            if (temp[0] + 1 < minefield.length) {
                if (!minefield[temp[0] + 1][temp[1]].getRevealed()) {
                    mineQueue.add(new int[]{temp[0] + 1, temp[1]});
                }
            }

            if (temp[1] + 1 < minefield.length) {
                if (!minefield[temp[0] + 1][temp[1]].getRevealed()) {
                    mineQueue.add(new int[]{temp[0], temp[1] + 1});
                }
            }
            temp = mineQueue.remove();
        }
    }

    /**
     * revealStart
     *
     * @param x       The x value the user entered.
     * @param y       The y value the user entered.
     */
    public void revealStart(int x, int y) {
        minefield[x][y].setRevealed(true);
    }
    /**
     * printMinefield
     *
     * @fuctnion This method should print the entire minefield, regardless if the user has guessed a square.
     * *This method should print out when debug mode has been selected. 
     */
    public void printMinefield() {
        // Print all squares
        String output = "  " + String.valueOf('\u3000');
        for (int i = 0; i < minefield.length; i++) {
            output += i + " " + String.valueOf('\u3000');
        }
        output += "\n";
        for (int i = 0; i < minefield.length; i++) {
            output += i;
            for (int j = 0; j < minefield[0].length; j++) {
                output += " " + String.valueOf('\u3000');
                output += minefield[i][j].getStatus();
            }
            output += "\n";
        }
        System.out.println(output);
    }

    public int getFlags() {
        return flags;
    }

    /**
     * toString
     *
     * @return String The string that is returned only has the squares that has been revealed to the user or that the user has guessed.
     */
    public String toString() {
        // Print only revealed squares
        String output = "  " + String.valueOf('\u3000');
        for (int i = 0; i < minefield.length; i++) {
            output += i + " " + String.valueOf('\u3000');
        }
        output += "\n";
        for (int i = 0; i < minefield.length; i++) {
            output += i;
            for (int j = 0; j < minefield[0].length; j++) {
                output += " " + String.valueOf('\u3000');
                if (minefield[i][j].getRevealed())  {
                    output += minefield[i][j].getStatus();
                }
                else {
                    output += "-";
                }

            }
            output += "\n";
        }
        return output;
    }
}
