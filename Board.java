import java.util.*;

class Board {

    char[][] board;
    int count;

    final String RESET = "\u001B[0m";
    final String BLUE = "\u001B[34m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String CYAN = "\u001B[36m";
    final String YELLOW = "\u001B[33m";
    final String MAGENTA = "\u001B[35m";
    final String BOLD = "\u001B[1m";

    Board() {
        board = new char[3][3];
        count = 0;
        for (char[] row : board)
            Arrays.fill(row, '-');
    }

    void printBoard() {
        System.out.println(CYAN + BOLD + "\n+--------- TIC TAC TOE BOARD ---------+" + RESET);
        System.out.println(MAGENTA + BOLD + "      1       2       3" + RESET);
        System.out.println(MAGENTA + "+-------------------------+" + RESET);
        for (int i = 0; i < 3; i++) {
            System.out.print(MAGENTA + (i + 1) + " " + RESET);
            System.out.println("|       |       |       |");
            for (int j = 0; j < 3; j++) {
                char cell = board[i][j];
                String color;

                if (cell == 'X')
                    color = RED + BOLD;
                else if (cell == 'O')
                    color = GREEN + BOLD;
                else
                    color = BLUE;

                if(j==2)
                    System.out.print("  |   " + color + cell + RESET + "   ");
                else
                    System.out.print("  |   " + color + cell + RESET + " ");

            }
            System.out.println("|");
            System.out.println("  |       |       |       |");
            System.out.println(MAGENTA + "+-------------------------+" + RESET);
        }
        System.out.println();
    }

    int place(int x, int y, char symbol) {
        // so what we're doing here is, we check if there are any empty slots in the board or not
        //if yes, we place the symbol, and increment count
        //if the slot already has a symbol, we return -2
        if (count < 9) {
            if (board[x][y] == '-') {
                board[x][y] = symbol;
                count++;
                if (count == 9)
                    return -1;
                return 1;
            }
            return -2;
        }
        return -1;
    }

    boolean checkWin(char symbol) {
        //we are traversing each row and checking for 3 consecutive symbols
        for (int i = 0; i < 3; i++)
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;

        //we are traversing each column and checking for 3 consecutive symbols
        for (int j = 0; j < 3; j++)
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol)
                return true;

        //here we are traversing both the diagonals of the board
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }
}
