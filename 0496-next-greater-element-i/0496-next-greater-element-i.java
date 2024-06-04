class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> st=new Stack<>();
        int nge[]=new int[nums2.length];
        st.push(nums2[nums2.length-1]);
        nge[nums2.length-1]=-1;
        int nge1[]=new int[nums1.length];
        for(int i=nums2.length-2;i>=0;i--){
            while(st.size()!=0 && nums2[i]>=st.peek()){
                st.pop();
            }
            if(st.size()==0){
                nge[i]=-1;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    nge1[i]=nge[j];
                }
            }
        }
        return nge1;
    }
}