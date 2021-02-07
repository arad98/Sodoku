import java.util.*;

public class board {
    
    // for zie of board, will be in multiple of 3
    private int size = 0;

    private int[][] fullBoard;
    private ArrayList<Integer> rowRandom  = new ArrayList<>();

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

    public void setRandList(int size) {
        for(int i = 0; i < size;i++) {
            rowRandom.add(i);
        }
    }

    /*  
    will just accept 9 for now
    method sets size of board, can only be a multiple of 9
    */
    public void setSize(int num) {
        if(num % 9 == 0) {
            int[][] newBoard = new int[num][num];
            size = num;
            for(int row = 0; row < size;row++) {
                for( int col = 0; col < size;col++) {
                    newBoard[row][col] = 0;
                }
            }
            fullBoard = newBoard;
        }
    }

    /*
    fils board size with mmatching sodoku puzzle
    randomly create solvable board based on size
    removed difficulty level of numbers, easy,med,hard,very hard
    */
    public void fillBoard() {
        Collections.shuffle(rowRandom);
        int[] arrayRand = new int[rowRandom.size()];
        for(int i = 0; i < rowRandom.size();i++) {
            arrayRand[i] = rowRandom.remove(i);
        }
    }

    public void fillDiagonal() {
        
    }


    public void setDifficulty(int difficulty) {

    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for(int i = 0; i < fullBoard.length;i++) {
            
            if (i%3 == 0 && i != 0) {
                System.out.println("- - - - - - - - - - - - ");
            }
            for(int j = 0; j < fullBoard[0].length;j++) {
                if (j%3 == 0 && j != 0) {
                    System.out.print(" | ");
                    
                }
                if(j==8) {
                    System.out.println(fullBoard[i][j]);
                } else {
                    System.out.print(fullBoard[i][j] + " ");
                }
            }
        }
    }

    public int getBoardSpot(int row, int col) {
        int[] out = new int[2];
        return fullBoard[row][col];
    }




    public board() {

        setSize(9);
        fillBoard();
        
    }

    public static void main(String[] args) {
        board temp = new board();
    }



}
