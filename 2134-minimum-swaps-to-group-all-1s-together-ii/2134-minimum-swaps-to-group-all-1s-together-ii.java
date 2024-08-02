class Solution {
    public int minSwaps(int[] nums) {
        int windowsize=0;
        //count 1;
        for(int num:nums){
            windowsize+=num;
        }
        //count 0 for first windowsize
        int countzero=0;
        for(int i=0;i<windowsize;i++){
            if(nums[i]==0){
                countzero++;
            }
        }

        int minzero=countzero;
        int start=0;
        int end=windowsize-1;
        int n=nums.length;
        while(start<n){
            if(nums[start]==0){
                countzero--;
            }
            start++;
             
             end++;
             if(nums[end%n]==0){
                countzero++;
             }
             minzero=Math.min(minzero,countzero);
        }
        return minzero;
        
    }
}