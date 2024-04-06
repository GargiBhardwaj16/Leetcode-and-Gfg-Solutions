class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*int ans[]=new int[nums.length];
        int n=nums.length;
        int p=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                ans[i]=p*nums[j];
                p=ans[i];
            }
            p=1;
        }
        return ans;*/
        int numsLength = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int[] result = new int[numsLength];
        for(int i = 0; i < numsLength; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        for(int i = numsLength-1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return result;
    }
}