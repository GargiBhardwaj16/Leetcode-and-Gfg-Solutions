class Solution {
    public int trap(int[] height) {
       int n=height.length;
       int hl[]=new int[n];
       int hr[]=new int[n];
       hl[0]=height[0];
       hr[n-1]=height[n-1];
       int sum=0;
       for(int i=1;i<n;i++){
        hl[i]=Math.max(hl[i-1],height[i]);
       }
       for(int i=n-2;i>=0;i--){
        hr[i]=Math.max(hr[i+1],height[i]);
       }
       for(int i=0;i<n;i++){
        sum+=Math.min(hr[i],hl[i])-height[i];
       }

       /*for(int i=1;i<n-1;i++){
            int l=height[i];
            for(int j=0;j<=i;j++){
                l=Math.max(l,height[j]);
            }
            int r=height[i];
            for(int j=i;j<n;j++){
                r=Math.max(r,height[j]);
            }
            sum+=Math.min(l,r)-height[i];
       }*/
       return sum;
    }
}