class Solution {
    public int lengthOfLastWord(String s) {
     String words[]=s.split(" ");
     int n=words.length;
     String x=words[n-1];
     int m=x.length();
     return m;
    }
}