class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-2);
        int start_idx_i=-1,start_idx_j=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    start_idx_i=i;
                    start_idx_j=j;
                }
            }
        }
        return helper(start_idx_i,start_idx_j,dp,grid);
    }
    private int helper(int i,int j,int[][] dp,int[][] grid){
        // System.out.println(i+" "+j);
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==-1||grid[i][j]==3)return 0;
        if(grid[i][j]==2) return check(grid);
        if(dp[i][j]!=-2) return dp[i][j];
        grid[i][j]=3;
        int up = helper(i-1,j,dp,grid);
        int down = helper(i+1,j,dp,grid);
        int left = helper(i,j-1,dp,grid);
        int right = helper(i,j+1,dp,grid);
        grid[i][j]=0;
        return up+down+left+right;

    }
    private int check(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) return 0;
            }
        }
        return 1;
    }
}