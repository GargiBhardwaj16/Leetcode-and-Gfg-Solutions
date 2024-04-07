class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
        /*int countL=0;
        int countS=0;
        int counter=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                countL++;
            }
            else if(s.charAt(i)==')'){
                countL--;
            }
            else{
                countS++;
            }
        }
        if(countL>0){if(countS>0){
             countL--;
             countS--;}
        }
        if(countL==0){
            return true;
        }
        if(countL<0&&countS>0){
             countS--;
             counter++;
            if(countL+counter==0){
            return true;}
        }
        return false;*/
    }
}