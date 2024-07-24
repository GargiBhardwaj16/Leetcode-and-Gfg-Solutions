class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        int twenty=0;
        int i=0;
        while(i<bills.length){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                if(five<=0){
                    return false;
                }
                five--;
                ten++;
            }
            else{
                twenty++;
                if(ten>=1 && five>=1){
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five--;
                    five--;
                    five--;
                }
                else{
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}