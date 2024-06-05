class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int operations=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }
            int triplets = count / 3;
            int remaining = count % 3;
            if (remaining == 1) {
                if (triplets > 0) {
                    triplets--;
                    remaining += 3;
                } else {
                    return -1;
                }
            }
            int pairs = remaining / 2;
            operations += triplets + pairs;
        }
        
        return operations;
    }
}