import java.util.Scanner;

public class board {
    
    // for zie of board, will be in multiple of 3
    private int size = 0;

    private int[][] board;
    private int[] rowRandom = {1,2,3,4,5,6,7,8,9};

    public int[][] GRID_TO_SOLVE = {
        {7,8,0,4,0,0,1,2,0},
        {6,0,0,0,7,5,0,0,9},
        {0,0,0,6,0,1,0,7,8},
        {0,0,7,0,4,0,2,6,0},
        {0,0,1,0,5,0,9,3,0},
        {9,0,4,0,6,0,0,0,5},
        {0,7,0,3,0,0,0,1,2},
        {1,2,0,0,0,7,4,0,0},
        {0,4,9,2,0,6,0,0,7},
    };

    /*  
    method sets size of board, can only be a multiple of 9
    */
    public void setSize(int num) {
        if(num % 9 == 0) {
            size = num;
            for(int row = 0; row < size;row++) {
                for( int col = 0; col < size;col++) {
                    board[row][col] = 0;
                }
            }
        } else {
            System.out.print("Needs to be a multiple of 9");
            Scanner newNum = new Scanner(System.in);
            num = newNum.nextInt();
            setSize(num);
        }
    }

    /*
    fils board size with mmatching sodoku puzzle
    randomly create solvable board based on size
    removed difficulty level of numbers, easy,med,hard,very hard
    */
    public void fillBoard() {
        collections.shuffle(rowRandom);
        for(int col = 0; col < size;col++) {
            board[1][col] =rowRandom[col];
        }
    }

    public void fillDiagonal() {
        
    }


    public void setDifficulty(int difficulty) {

    }

    public int getSize() {
        return size;
    }




    public static void Main(string[] args ) {

    }

}
