import java.util.*;



class Board {

    char[][] board;

    Board(){
        board = new char[3][3];
        for(char[] row : board)
            Arrays.fill(row, '#');
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

    
}