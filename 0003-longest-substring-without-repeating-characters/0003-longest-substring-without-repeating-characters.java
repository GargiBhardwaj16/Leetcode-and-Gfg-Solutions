class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*Set<Character>set=new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);
            }
            else{
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));left++;
                set.add(s.charAt(right));
            } 
        }
        return maxLength;*/
        int i=0, j=0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        while(j<n)
        {
            if(map.containsKey(s.charAt(j)))
            {
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            len = Math.max(len, j-i+1);
            map.put(s.charAt(j), j);
            j++;
        }
        return len;
    }
}