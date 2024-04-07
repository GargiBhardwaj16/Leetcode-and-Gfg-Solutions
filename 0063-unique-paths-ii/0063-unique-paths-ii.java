class Solution {
    /*public static int f(int[][] obstacleGrid,int dp[][],int i,int j,int m,int n){
        if(i>=m || j>=n){
            return 0;
         }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(obstacleGrid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int r=f(obstacleGrid,dp,i+1,j,m,n);
        int c=f(obstacleGrid,dp,i,j+1,m,n);
        return dp[i][j]=r+c;
    } */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(obstacleGrid, dp, m - 1, n - 1);
    }

    public int f(int[][] mat, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || mat[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int left = f(mat, dp, i, j - 1);
        int up = f(mat, dp, i - 1, j);
        return dp[i][j] = left + up;
    }
}