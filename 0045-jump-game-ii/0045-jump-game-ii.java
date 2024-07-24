class Solution {
    int ans = 0;
    public int jump(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            i = helper(i, nums[i], nums);

        }
        return ans;
    }
    public int helper(int a, int b, int[] nums) {
        ans++;
        if (a + b >= nums.length - 1) {
            return nums.length;
        }
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = a; i <= a + b; i++) {
            if (nums[i] + i >= max) {
                temp = i;
                max = nums[i] + i;
            }
        }
        return temp;
    }
}