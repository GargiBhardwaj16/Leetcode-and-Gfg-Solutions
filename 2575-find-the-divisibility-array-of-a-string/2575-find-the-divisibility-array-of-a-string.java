class Solution {
    public int[] divisibilityArray(String word, int m) {
        int ans[]=new int[word.length()];
        long num = 0;
        for(int i=0;i<word.length();i++){
            int digit = word.charAt(i) - '0'; // Convert char to integer
            num = (num * 10 + digit) % m; // Update the cumulative value
            ans[i] = (num == 0) ? 1 : 0; 
        }
        return ans;
    }
}