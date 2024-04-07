class Solution {
    public static int f(int dp[][],int i,int j,int m,int n){
        if(i>=m || j>=n){
            return 0;
         }
        if(i==m-1 && j==n-1){
            return 1;
        }
       
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int r=f(dp,i+1,j,m,n);
        int c=f(dp,i,j+1,m,n);
        return dp[i][j]=r+c;
    } 
    public int uniquePaths(int m, int n) {
      int dp[][]=new int[m][n];
      return f(dp,0,0,m,n);
    }
}