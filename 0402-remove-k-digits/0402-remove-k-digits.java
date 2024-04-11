class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k){
            return "0";
        }
        if(k == 0)
            return num;
        String r="";
        Stack<Character> s=new Stack<>();
        char[] nums = num.toCharArray();
        s.push(nums[0]);
        for(int i = 1; i<num.length(); ++i)
        {
            while(k > 0 && !s.empty() && nums[i] < s.peek())
            {
                --k;
                s.pop();
            }
            s.push(nums[i]);
            if(s.size() == 1 && nums[i] == '0')
                s.pop();
        }
        while(k>0 && !s.empty())
        {
            --k;
            s.pop();
        }
        while(!s.empty())
        {
            r=r+(s.peek()); // pushing stack top to string
            s.pop(); // pop the top element
        }
        
        StringBuilder reverseString = new StringBuilder(r);
        reverseString.reverse();
        
        if(r.length() == 0)
            return "0";
        
        return reverseString.toString();
        
        
    }
}