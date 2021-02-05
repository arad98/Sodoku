
/**
 * Sodoku
 * rules for board: 9x9 square blocks make 3x3 square, each block has 1-9 no repeats, earch row has 1-9 and each columnhas 1-9
 * the lowest amount of clues to solve a sodoku puzzel is 17 
 * 
 * most efficent method:randomly fill 17 cells with 17 random 1-9 numbers
 */
public class SodokuBackTrack {
    int z = 0;
    int EMPTY = 0;
    

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

    int SIZE = GRID_TO_SOLVE[0].length;


    public static void main(String[] args) {
    Sodoku mySodoku = new Sodoku();
    }

    

    public SodokuBackTrack() {
        printBoard(GRID_TO_SOLVE);
        solve();
        System.out.println("------------------------------------------------------------------");
        printBoard(GRID_TO_SOLVE);

    }

    public boolean solve() {


        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
             // we search an empty cell
             if (GRID_TO_SOLVE[row][col] == EMPTY) {
               // we try possible numbers
               for (int number = 1; number <= SIZE; number++) {
                 if (isOk(row, col, number)) {
                   // number ok. it respects sudoku constraints
                   GRID_TO_SOLVE[row][col] = number;
   
                   if (solve()) { // we start backtracking recursively
                     return true;
                   } else { // if not a solution, we empty the cell and we continue
                    GRID_TO_SOLVE[row][col] = EMPTY;
                   }
                }
               }
   
               return false; // we return false
              }
             }
            }
   
            return true; // sudoku solved
    }
    // we check if a possible number is already in a row
	private boolean isInRow(int row, int number) {
		for (int i = 0; i < SIZE; i++)
			if (GRID_TO_SOLVE[row][i] == number)
				return true;
		
		return false;
    }
    
    // we check if a possible number is already in a column
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < SIZE; i++)
			if (GRID_TO_SOLVE[i][col] == number)
				return true;
		
		return false;
	}

    public boolean isInBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;
		
		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (GRID_TO_SOLVE[i][j] == number)
					return true;
		
		return false;
    }
    
    // combined method to check if a number possible to a row,col position is ok
	private boolean isOk(int row, int col, int number) {
		return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
	}

    public void printBoard(int bo[][]) {

        for(int i = 0; i < bo.length;i++) {
            
            if (i%3 == 0 && i != 0) {
                System.out.println("- - - - - - - - - - - - ");
            }
            for(int j = 0; j < bo[0].length;j++) {
                if (j%3 == 0 && j != 0) {
                    System.out.print(" | ");
                    
                }
                if(j==8) {
                    System.out.println(bo[i][j]);
                } else {
                    System.out.print(bo[i][j] + " ");
                }
            }
        }
        
    }

    public int[] find_empty(int bo[][]) {
        int[] outArray = new int[2];

        for(int i = 0; i < bo.length;i++) {
            for(int j = 0 ; j < bo[0].length;j++){
                if (bo[i][j] == 0) {
                    outArray[0] = i; // row, col
                    outArray[1] = j;
                    return outArray; 
                }
            }
        }
        return outArray;
    }

    
}