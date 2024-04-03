class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        queen(board, 0, count);
        return count[0];
    }

    static void queen(char[][] board, int row, int[] count) {
        if(row == board.length) {
            count[0]++;
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                queen(board, row + 1, count);
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {

        //for checking vertical row
        for (int i = row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //for checking left diagonal

        for (int i = row-1,j=col-1; i >=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row-1,j=col+1; i >=0 && j<board.length; i--,j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
