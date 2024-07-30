class Solution {
    public boolean areNumbersAscending(String s) {
        String [] str=s.split(" ");
        int curr=Integer.MIN_VALUE;
        for(int i=0;i<str.length;i++){
            try{
                int num=Integer.parseInt(str[i]);
                if(num<=curr){
                    return false;
                }
                curr=num;
            }
            catch(NumberFormatException e){
                continue;
            }
        }
        return true;
    }
}