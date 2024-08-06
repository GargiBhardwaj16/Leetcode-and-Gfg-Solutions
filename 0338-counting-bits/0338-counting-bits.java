class Solution {
    private static int decToBinary(int n){
        int[] binaryNum = new int[32];
        int count=0;
        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--){
            if(binaryNum[j]==1){
                count++;
            }
        }
        return count;
    }
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=decToBinary(i);
        }
        return arr;
    }
}