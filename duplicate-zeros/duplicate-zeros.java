class Solution {
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                // Shift elements to the right from the end to i + 1
                for (int j = n - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                // Duplicate the zero
                i++; // Skip the next index as we just wrote a zero there
            }
        }
    }
}