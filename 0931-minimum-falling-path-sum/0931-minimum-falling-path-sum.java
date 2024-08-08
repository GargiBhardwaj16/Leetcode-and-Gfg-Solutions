class Solution {
    public int minFallingPathSum(int[][] matrix) {
         return bottomUp(matrix);
    }

 // tabulation approach
    private int bottomUp(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = mat[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = 10001;
                for (int k = -1; k < 2; k++) {
                    if (isSafe(dp, i - 1, j - k)) {
                        min = Math.min(min, dp[i - 1][j - k]);
                    }
                }

                dp[i][j] = mat[i][j] + min;
            }
        }

        int result = 10001;

        for (int val : dp[m - 1]) {
            result = Math.min(result, val);
        }

        return result;
    }

// memoization approach
    private int dfs(int[][] mat, int[][] dp, int r, int c) {

        if (dp[r][c] != 10001) {
            return dp[r][c];
        }

        int min = 10001;

        for (int i = -1; i < 2; i++) {
            if (isSafe(dp, r + 1, c - i)) {
                min = Math.min(min, dfs(mat, dp, r + 1, c - i));
            }
        }

        min = min == 10001 ? 0 : min;
        dp[r][c] = mat[r][c] + min;

        return dp[r][c];
    }

// this only conditional helper function
    private boolean isSafe(int[][] mat, int i, int j) {
        return i > -1 && i < mat.length && j > -1 && j < mat[0].length;
   
    }
}