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

        System.out.println("List of players :");
        for(int i=0;i<2;i++)
        {
            System.out.println(players.get(i).name +" "+players.get(i).symbol);
        }

    }
}