class Solution {
    public int coinChange(int[] coins, int amount) {
         int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
        /*int ans=0;
        if(amount==0) return 0;
        Arrays.sort(coins);
        for(int i=coins.length-1;i>=0;i--){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    ans++;
                    amount-=coins[i];
                }
            }
        }
        if(ans==0 || amount!=0) return -1;
        return ans;*/
        
       /* boolean allMultiply = true;

        for (int i = 1; i < coins.length; ++i) {

            if (coins[i] % coins[0] != 0) {
                allMultiply = false;
                break;
            }
        }

        if (allMultiply && (amount % coins[0]) != 0) {
            return -1;
        }

        int minCount = Integer.MAX_VALUE;
        int[] counts = new int[coins.length];
        int i = coins.length - 1;
        int count = amount / coins[i];
        int amount1 = amount - count * coins[i];

        if (amount1 == 0) {
            return count;
        }

        if (coins[0] * (count + 1) == amount) {
            return count + 1;
        }

        if (count == amount / coins[0]) {
            return -1;
        }

        counts[i] = count;
        amount = amount1;

        while (true) {
            if (count >= minCount || i <= 0) {
                count -= counts[i];
                amount += counts[i] * coins[i];

                do {
                    ++i;

                    if (i >= coins.length) {
                        return minCount < Integer.MAX_VALUE ? minCount : -1;
                    }

                } while (counts[i] == 0);
                --counts[i];
                --count;
                amount += coins[i];
            }

            --i;
            counts[i] = 0;

            while (amount >= coins[i]) {
                amount -= coins[i];
                ++counts[i];
            }

            count += counts[i];

            if (amount == 0 && count < minCount) {
                minCount = count;
            }
        }*/
    }
}