class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length; int n2=nums2.length;
        int[] arr3=new int[n1+n2];
        int i = 0; 
        int j = 0; 
        int k = 0; 
        while(i < n1){  
         arr3[k++] = nums1[i++];  
        }  
        while(j < n2){  
         arr3[k++] = nums2[j++];  
        }  
        Arrays.sort(arr3);
        int x=arr3.length;
        if(x%2==0){
          int mid=x/2;
          double m=(double)(arr3[mid]+arr3[mid-1])/2;
          return m;
        }
        int mid= x/2;
        return arr3[mid];
    }
}