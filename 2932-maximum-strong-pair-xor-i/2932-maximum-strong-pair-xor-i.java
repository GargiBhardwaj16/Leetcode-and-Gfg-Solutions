class Solution {
    public int maximumStrongPairXor(int[] arr) {
        int maxXOR = 0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(Math.abs(arr[i]-arr[j]) <= Math.min(arr[i],arr[j]))  maxXOR = Math.max(maxXOR,arr[i]^arr[j]);
            }
        }
        return maxXOR;
    }
}