class Solution {
    public int climbStairs(int n) {
        if(n<=0) return 1;
        if(n==1) return 1;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        solve(n,dp); 
        return dp[n];
    }
    public int solve(int n,int[]dp){
        if(n<=0) return 1;
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=solve(n-1,dp)+solve(n-2,dp);
    }
}