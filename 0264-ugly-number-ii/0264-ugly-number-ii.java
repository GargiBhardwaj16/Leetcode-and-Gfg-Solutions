class Solution {
    public int nthUglyNumber(int n) {
        /*if(n<=6) return n;
        int count=2;
        for(int i=2;i<=5;i+=i-1){
        for(int j=2;j<=n;j++){
            if(j%i==0){
                count++;
            }
        }
    }
    return count;*/
    int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
  }
}