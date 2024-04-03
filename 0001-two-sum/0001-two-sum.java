class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*int complement; 
        //loop to check every element in the array
        for (int x = 0; x<nums.length; x++) {  
            complement = target - nums[x];
            //loop to find complement of current element
            for (int y = x+1; y<nums.length; y++) { 
                //we cannot use same element twice.
                //if (x ==  y) { continue; } 
                if (nums[y] == complement) {
                    return new int[] {x, y};
                }
            }            
        }
        return new int[] {0, 0};*/
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