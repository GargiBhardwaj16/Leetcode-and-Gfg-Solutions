class Solution {
    public int compareVersion(String v1, String v2) {
        int res = 0;
        int k1 = v1.length(), k2 = v2.length();
        
        for(int i=0, j=0; i<k1 || j<k2; ++i, ++j) {
            
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            while(i<k1 && v1.charAt(i) != '.') {
                if(s1.length() == 0 && v1.charAt(i) == '0') {
                    ++i; continue;
                }
                
                s1.append(v1.charAt(i++));
            }
            
            while(j<k2 && v2.charAt(j) != '.') {
                if(s2.length() == 0 && v2.charAt(j) == '0') {
                    ++j; continue;
                }
                
                s2.append(v2.charAt(j++));
            }
            
            if(s1.length() < s2.length()) return -1;
            else if(s2.length() < s1.length()) return 1;
            
            res = s1.toString().compareTo(s2.toString());
            if(res< 0) return -1;
            else if(res > 0) return 1;
        }
        
        return 0;
    }
}