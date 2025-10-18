import java.util.*;


class Game {

    List<Player> players = new ArrayList<>();
    Scanner sc;

    Game(){
        sc = new Scanner(System.in);
    }

    void beginGame() {
        System.out.println("Welcome to TicTacToe!");
        System.out.println("Enter the names of the Players : ");

        for(int i=0;i<2;i++)
        {
            System.out.println("Name of Player "+(i+1)+" : ");
            String name = sc.nextLine();
            if(players.size()==0)
            {
                boolean flag = true;
                while(flag)
                {
                    System.out.println("Symbol for Player "+ (i+1) +" (X or O) : ");
                    char symbol = sc.next().charAt(0);
                    symbol = Character.toUpperCase(symbol);

                    if(symbol=='X' || symbol=='O')
                    {
                        Player p = new Player(name, symbol);
                        players.add(p);
                        flag=false;
                    }
                    else
                    {
                        System.out.println("Please enter a valid symbol!");
                    }
                }
                sc.nextLine();
            }
            else
            {
                char s = players.get(0).symbol;
                char sym='#';
                if(s=='X')
                    sym='O';
                else
                    sym='X';
                Player p = new Player(name, sym);
                players.add(p);
            }
        }
        Board b = new Board();

        b.printBoard();

        boolean flag=true;

        int cur_player=0;
        System.out.println("Game starts, input format - x y");

        boolean winner= false;
        while(flag)
        {
            boolean turn = true;
            while(turn)
            {
                System.out.println(players.get(cur_player).name+"'s Turn-("+players.get(cur_player).symbol+") : ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                x--;
                y--;
                if(x>2 || x<0 || y>2 ||y<0)
                    System.out.println("Invalid Co-ordinates, Please enter again!");
                else
                {
                    int pos = b.place(x, y, players.get(cur_player).symbol);
                    if(pos==-2)
                        System.out.println("Please place at an empty slot!");
                    else
                    {
                        winner = b.checkWin(players.get(cur_player).symbol);
                        turn = false;
                        cur_player = Math.abs(cur_player-1);
                        if(pos==-1)
                        {
                            turn=false;
                            flag=false;
                            break;
                        }
                    }
                }
            }
            if(winner)
                flag=false;
            b.printBoard();
        }

        if(winner)
        {
            cur_player = Math.abs(cur_player-1);
            System.out.println(players.get(cur_player).name+" won!!");
        }
        else
            System.out.println("Draw!");
    }

}