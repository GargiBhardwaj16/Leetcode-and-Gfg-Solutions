class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(wordDict.contains(s.substring(j,i)) && dp[j]==true){
                    dp[i]=true;
                }
            }
       }
       return dp[s.length()];
    }
}