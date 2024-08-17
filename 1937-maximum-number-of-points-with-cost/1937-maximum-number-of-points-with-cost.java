class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            long[] new_dp = new long[n];
            long leftMax = dp[0];
            for (int j = 0; j < n; j++) {
                leftMax = Math.max(leftMax, dp[j] + j);
                new_dp[j] = points[i][j] + leftMax - j;
            }
            long rightMax = dp[n - 1] - (n - 1);
            for (int j = n - 1; j >= 0; j--) {
                rightMax = Math.max(rightMax, dp[j] - j);
                new_dp[j] = Math.max(new_dp[j], points[i][j] + rightMax + j);
            }
            dp = new_dp;
        }
        long maxPoints = 0;
        for (int j = 0; j < n; j++) {
            maxPoints = Math.max(maxPoints, dp[j]);
        }
        return maxPoints;
    }
}