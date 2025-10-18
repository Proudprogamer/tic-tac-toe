import java.util.*;

class Game {

    List<Player> players = new ArrayList<>();
    Scanner sc;

    final String RESET = "\u001B[0m";
    final String PURPLE = "\u001B[35m";
    final String CYAN = "\u001B[36m";
    final String YELLOW = "\u001B[33m";
    final String GREEN = "\u001B[32m";
    final String RED = "\u001B[31m";
    final String BLUE = "\u001B[34m";
    final String BOLD = "\u001B[1m";
    final String UNDERLINE = "\u001B[4m";

    Game() {
        sc = new Scanner(System.in);
    }

    void beginGame() {
        System.out.println(PURPLE + BOLD + "\n=== Welcome to TIC TAC TOE ===" + RESET);
        System.out.println(YELLOW + "Enter the names of the Players:\n" + RESET);

        for (int i = 0; i < 2; i++) {
            System.out.print(CYAN + " Name of Player " + (i + 1) + ": " + RESET);
            String name = sc.nextLine();

            if (players.size() == 0) {
                boolean flag = true;
                while (flag) {
                    System.out.print(GREEN + "Choose your symbol (X or O): " + RESET);
                    char symbol = sc.next().charAt(0);
                    symbol = Character.toUpperCase(symbol);

                    if (symbol == 'X' || symbol == 'O') {
                        Player p = new Player(name, symbol);
                        players.add(p);
                        flag = false;
                    } else {
                        System.out.println(RED + "Please enter a valid symbol!" + RESET);
                    }
                }
                sc.nextLine();
            } else {
                char s = players.get(0).symbol;
                char sym = (s == 'X') ? 'O' : 'X';
                Player p = new Player(name, sym);
                players.add(p);
                System.out.println(GREEN + " " + name + " automatically assigned symbol (" + sym + ")" + RESET);
            }
        }

        Board b = new Board();
        b.printBoard();

        System.out.println(BLUE + "\nGame starts! Input format: x y (e.g. 1 3)\n" + RESET);

        boolean flag = true;
        boolean winner = false;
        int cur_player = 0;

        while (flag) {
            boolean turn = true;
            while (turn) {
                System.out.print(PURPLE + BOLD + players.get(cur_player).name + RESET +
                        YELLOW + "'s Turn (" + players.get(cur_player).symbol + "): " + RESET);

                int x = sc.nextInt();
                int y = sc.nextInt();
                x--;
                y--;

                if (x > 2 || x < 0 || y > 2 || y < 0) {
                    System.out.println(RED + "Invalid coordinates! Try again." + RESET);
                } else {
                    int pos = b.place(x, y, players.get(cur_player).symbol);
                    if (pos == -2)
                        System.out.println(RED + "That spot is already taken!" + RESET);
                    else {
                        winner = b.checkWin(players.get(cur_player).symbol);
                        turn = false;
                        cur_player = Math.abs(cur_player - 1);
                        if (pos == -1) {
                            turn = false;
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (winner)
                flag = false;
            b.printBoard();
        }

        System.out.println();
        if (winner) {
            cur_player = Math.abs(cur_player - 1);
            System.out.println(GREEN + BOLD + " "+ players.get(cur_player).name + " won the game!! " + RESET);
        } else {
            System.out.println(CYAN + BOLD + " It's a draw!" + RESET);
        }
    }
}
