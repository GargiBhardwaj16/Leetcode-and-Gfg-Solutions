class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0;
        int rsum=0;
        int maxsum=0;
        for(int i=0;i<=k-1;i++){
            lsum=lsum+cardPoints[i];
        }
        maxsum=lsum;
        int r=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            lsum=lsum-cardPoints[i];
            rsum=rsum+cardPoints[r];
            r=r-1;
            maxsum=Math.max(lsum+rsum,maxsum);
        }
        return maxsum;
    /*int Sum = 0;
    for(int x : cardPoints){
        Sum += x;
    }
    int len = cardPoints.length - k;
    int min = 0;
    for(int i = 0;i<len;i++){
        min += cardPoints[i];
    }
    int i = 0;
    int j = len;
    int temp = min;
    while(j < cardPoints.length){
        temp = temp - cardPoints[i++] + cardPoints[j++];
        if(temp < min){
            min = temp;
        }
    }
    return Sum - min; */
       /*int n=cardPoints.length;
       int sum=0;
       if(n==k){
           for(int i=0;i<k;i++){
               sum=sum+cardPoints[i];
           }
          return sum;
       }
       Arrays.sort(cardPoints);
       for(int i=n;i>=k;i--){   
           sum=sum+cardPoints[i-1];
       }
       int left=0;
       int right=n-1;
       while(k!=0){
           int l=cardPoints[left];
           int r=cardPoints[right];
           if(l>r){
               sum=sum+l;
               left++;
               //right--;
           }
           else if(l==r){
               sum=sum+l;
               left++;
               right--;
           }
           else{
               sum=sum+r;
               right--;
               //left++;
           }
            k--;
       }
       return sum;*/
    }
}