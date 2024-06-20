class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        
        for (int num : arr) {
            dp.put(num, 1L); 
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) { 
                    int right = arr[i] / arr[j];
                    if (dp.containsKey(right)) {
                        dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(right)) % MOD);
                    }
                }
            }
        }
        
        long result = 0;
        for (long value : dp.values()) {
            result = (result + value) % MOD;
        }
        
        return (int) result;
    }
}