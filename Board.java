import java.util.*;

class Board {

    char[][] board;
    int count;

    Board(){
        board = new char[3][3];
        count=0;
        for(char[] row:board)
            Arrays.fill(row, '-');
    }

    void printBoard(){
        System.out.println("+-----------------------+");
        for(int i=0;i<3;i++)
        {
            String s = "|   ";
            for(int j=0;j<3;j++)
                s+=board[i][j]+"   |   ";
            System.out.println("|       |       |       |");
            System.out.println(s);
            System.out.println("|       |       |       |");
            System.out.println("+-----------------------+");
        }
    }

    int place(int x, int y, char symbol){
        if(count<9)
        {
            if(board[x][y]=='-')
            {
                board[x][y] = symbol;
                count++;
                if(count==9)
                    return -1;
                return 1;
            }
            return -2;
        }
        return -1;
    }

    boolean checkWin(char symbol){
        int consec=0;

        //row
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==symbol)
                    consec++;
            }
            if(consec==3)
                return true;
            consec=0;
        }

        consec=0;
        //column
        for(int j=0;j<3;j++)
        {
            for(int i=0;i<3;i++)
            {
                if(board[i][j]==symbol)
                    consec++;
            }
            if(consec==3)
                return true;
            consec=0;
        }

        consec=0;
        //p-diag
        int i=0, j=0;
        while(i<3 && j<3)
        {
            if(board[i][j]==symbol)
                consec++;
            i++;
            j++;
        }
        if(consec==3)
            return true;


        consec=0;
        //diag
        i=0;
        j=2;
        while(i<3 && j>=0)
        {
            if(board[i][j]==symbol)
                consec++;
            i++;
            j--;
        }
        if(consec==3)
            return true;
        return false;
    }
}