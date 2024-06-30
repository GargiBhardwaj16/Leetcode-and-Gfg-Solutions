class Solution {
    public double solve(int []nums,int k,int idx, double dp[][]){
        if(idx==nums.length){
            return 0.0;
        }
        if(dp[idx][k]!=-1){
            return dp[idx][k];
        }
        double avg=0.0;
        double sum=0.0;
        if(k==1){
            for(int i=idx;i<nums.length;i++){
                sum+=nums[i];
            }
            avg=sum/(nums.length-idx)+solve(nums,0,nums.length,dp);
        }
        else{
           for(int i=idx;i<=nums.length-k;i++){
               sum+=nums[i];
               avg=Math.max(avg,sum/(i-idx+1)+solve(nums,k-1,i+1,dp));
           } 
        }
        return dp[idx][k]=avg;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        double sum=0;
        int n=nums.length;
        double dp[][]=new double[n][k+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,k,0,dp);
    }
}