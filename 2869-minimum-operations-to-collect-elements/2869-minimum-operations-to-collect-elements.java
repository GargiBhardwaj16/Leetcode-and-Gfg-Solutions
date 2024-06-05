class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> s = new HashSet<>();
        int n = nums.size();
        int operations = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = nums.get(i);
            if (curr >= 1 && curr <= k) {
                s.add(curr);
            }
            operations++;
            if (s.size() == k) {
                break;
            }
        }
        return operations;
    }
}
