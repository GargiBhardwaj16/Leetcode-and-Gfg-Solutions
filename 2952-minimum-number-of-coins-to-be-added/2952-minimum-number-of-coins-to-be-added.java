class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        long sum = 1;
        int res = 0;
        int i = 0;

        while (sum <= target) {
            if (i < coins.length && coins[i] <= sum) {
                sum += coins[i++];
            } else {
                sum += sum;
                res++;
            }
        }
        return res;
    }
}