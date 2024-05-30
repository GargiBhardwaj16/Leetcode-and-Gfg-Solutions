class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int []dpl=new int[n];
        int []dpr=new int[n];
        Arrays.fill(dpl,1);
        Arrays.fill(dpr,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dpl[i]<dpl[j]+1){
                    dpl[i]=dpl[j]+1;
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[j]<nums[i] && dpr[i]<dpr[j]+1){
                    dpr[i]=dpr[j]+1;
                }
            }
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            if(dpr[i]>1&& dpl[i]>1){
                ans=Math.max(ans,dpl[i]+dpr[i]-1);
            }
        }
        return n-ans;
    }
}