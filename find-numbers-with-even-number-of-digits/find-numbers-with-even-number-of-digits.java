class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            char[] charArray = Integer.toString(nums[i]).toCharArray();
            if(charArray.length%2==0){
                count++;
            }
        }
        return count;
    }
}