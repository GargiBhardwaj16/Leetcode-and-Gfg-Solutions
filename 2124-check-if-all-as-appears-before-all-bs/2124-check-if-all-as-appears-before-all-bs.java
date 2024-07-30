class Solution {
    public boolean checkString(String s) {
        int  n = s.length();
        int flag=0;
        for(char c : s.toCharArray())
        {
            if(c == 'b')
            {
                flag=1;
            }
            if(c == 'a' && flag == 1)
            {
                return false;
            }
        }
        return true;   
    }
}