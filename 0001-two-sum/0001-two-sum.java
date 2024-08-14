class Solution {
    public int[] twoSum(int[] nums, int target) {
        int s=nums.length;
        HashMap <Integer, Integer> mp=new HashMap<>();
        for(int i =0;i<s;i++)
        {   
            int n=target-nums[i];  
            
            if(mp.containsKey(n)) 
            {
                return new int[]{i,mp.get(n)};  
            }
            mp.put(nums[i],i);
        }
        return new int[0];
    }
}