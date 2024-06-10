class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] transformed = new int[n];
        int kIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > k) {
                transformed[i] = 1;
            } else if (nums[i] < k) {
                transformed[i] = -1;
            } else {
                transformed[i] = 0;
                kIndex = i;
            }
        }
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        prefixSumCount.put(0, 1);
        
        for (int i = 0; i < n; i++) {
            prefixSum += transformed[i];
            
            if (i < kIndex) {
                prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
            } else {
                int target1 = prefixSum;
                int target2 = prefixSum - 1;
                
                if (prefixSumCount.containsKey(target1)) {
                    count += prefixSumCount.get(target1);
                }
                
                if (prefixSumCount.containsKey(target2)) {
                    count += prefixSumCount.get(target2);
                }
            }
        }
        
        return count;
    }
}