class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0;
    int j = 0;
    int arr[] = new int[n + m];
    int k = 0;
    
    while (i < m && j < n) {
        if (nums1[i] < nums2[j]) {
            arr[k] = nums1[i];
            i++;
        } else {
            arr[k] = nums2[j];
            j++;
        }
        k++;
    }
    
    if (i < m) {
        for (int x = i; x < m; x++) {
            arr[k] = nums1[x];
            k++;
        }
    }
    
    if (j < n) {
        for (int x = j; x < n; x++) {
            arr[k] = nums2[x];
            k++;
        }
    }
    
    for (int x = 0; x < m + n; x++) {
        nums1[x] = arr[x];
    }
}
}