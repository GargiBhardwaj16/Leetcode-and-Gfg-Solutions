class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<n;i++){
            if(buy<prices[i]){
                int profit=prices[i]-buy;
                maxprofit=Math.max(maxprofit,profit);
            }
            else{
                buy=prices[i];
            }
        }
        return maxprofit;
    }
}