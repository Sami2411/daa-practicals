public class NQueens {  
     
    static int N = 4; 
 
    static void printSolution(int[][] board) { 
        for (int[] row : board) { 
            for (int cell : row) { 
                System.out.print(cell == 1 ? "Q " : ". "); 
            } 
            System.out.println(); 
        } 
        System.out.println(); 
    } 
     
    static boolean isSafe(int[][] board, int row, int col) { 
        for (int i = 0; i < col; i++){ 
            if (board[row][i] == 1)  
                return false; 
        }  
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--){ 
            if (board[i][j] == 1)  
                return false; 
        }  
        for (int i = row, j = col; i < N && j >= 0; i++, j--){ 
            if (board[i][j] == 1)  
                return false; 
        } 
        return true; 
    } 
     
    static boolean solveNQueens(int[][] board, int col) { 
        if (col >= N) { 
            printSolution(board); 
            return true; 
        } 
        boolean found = false; 
        for (int i = 0; i < N; i++) { 
            if (isSafe(board, i, col)) { 
                board[i][col] = 1; 
                found = solveNQueens(board, col + 1) || found; 
                board[i][col] = 0; 
            } 
        } 
        return found; 
    } 
     
    public static void main(String[] args) { 
        int[][] board = new int[N][N]; 
        if (!solveNQueens(board, 0)) { 
            System.out.println("No solution exists"); 
        } 
    } 
}