class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int l=0;
        int r=0;
        while(r<g.length && l<s.length){
            if(s[l]>=g[r]){
                r++;
            }
                l++;
       }
        return r;
    }
}