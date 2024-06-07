class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        /*int n = nums.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            int maxIndex = -1;
            for (int j = i + 1; j < n; j++) {
                if (!vis[j] && 2 * nums[i] <= nums[j]) {
                    if (maxIndex == -1 || nums[j] > nums[maxIndex]) {
                        maxIndex = j;
                    }
                }
            }
            if (maxIndex != -1) {
                vis[i] = true;
                vis[maxIndex] = true;
                count += 2;
            }
        }
        
        return count;*/
         Arrays.sort(nums);
        int counter = 0;
        int i =0, j =nums.length/2;

        while(i < nums.length/2  &&  j < nums.length){
            if(nums[i] * 2 <= nums[j]){
                counter += 2;
                i++;j++;
                continue;
            }
           j++;
        } 

        return counter;
    }
}
