class Solution {
    public int lengthOfLIS(int[] nums) {
       if(nums.length==0){
           return 0;
       } 
    int n=nums.length;
     int dp[]=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    //System.out.println(dp[i]);
                }
            }
        }
        int maxlength=dp[0];
        for(int i=1;i<n;i++){
            if(dp[i]>maxlength)
              maxlength=dp[i];
        }
        return maxlength;
    }
}