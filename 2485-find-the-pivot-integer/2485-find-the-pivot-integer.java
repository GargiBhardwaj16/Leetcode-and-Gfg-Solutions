class Solution {
    public int pivotInteger(int n) {
        int Totalsum=0;
        for(int i=1;i<=n;i++){
            Totalsum+=i;
        }
        int sum1=0;
        int sum2=0;
        for(int i=1;i<=n;i++){
            sum1=sum1+i;
            sum2=Totalsum-sum1+i;
            if(sum1==sum2){
                return i;
            }
        }
        return -1;
    }
}