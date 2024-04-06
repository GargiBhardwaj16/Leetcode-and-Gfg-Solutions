class Solution {
    public static int f(int n,int nums[],int dp[]){
        if(n==0) return nums[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int pick=nums[n]+f(n-2,nums,dp);
        int notpick=0+f(n-1,nums,dp);
        return dp[n]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,nums,dp);
    }
}