import java.util.prefs.PreferenceChangeEvent;

public class EightQueens {
    int[][] board;
    int n = 8;
    public EightQueens(){
        this.board = new int[8][8];
    }

    void printSolution(int[][] board){
        for (int i = 0; i < n;i++){
            for (int j = 0; j < n;j++){
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean isSafe(int[][] board, int row, int col){
        int n = board.length;
        int i, j;

        // 1 = queen is one, 0 mean empty
        //Check for all column at row (n), Row is the number of user input
        for (i = 0; i < row;i++){
            if (board[i][col] == 1){
                return false;
            }
        }

        //Check for upper left
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 1) return false;
        }

        for (i = row, j = col; i>= 0 && j < n; i--, j++){
            if (board[i][j] ==1) return false;
        }
        return true;
    }

    boolean solveNQUtil(int[][] board, int row){
        if (row >= n){
            printSolution(board);
            return true;
        }
        boolean res = false;

        for (int i = 0; i < n ;i++){
            if (isSafe(board, row, i)){
                board[row][i] = 1;

                res = solveNQUtil(board,row+1) || res;

                board[row][i] = 0;

            }
        }
        return res;
    }
}
