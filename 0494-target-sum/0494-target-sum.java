class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }
    
    public int solve(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        int countAdd = solve(nums, i + 1, sum + nums[i], target);
        int countSubtract = solve(nums, i + 1, sum - nums[i], target);
        
        return countAdd + countSubtract;
    }
}