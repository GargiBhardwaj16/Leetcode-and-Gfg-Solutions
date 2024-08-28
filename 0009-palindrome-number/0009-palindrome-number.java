class Solution {
    public boolean isPalindrome(int x) {
      if(x<0){
         return false;
      }
      else{
        int r,sum=0,temp;  
        temp=x;    
  while(x>0){    
   r=x%10;  //getting remainder  
   sum=(sum*10)+r;    
   x=x/10;    
  }    
  if(temp==sum)    
   return true;    
  else    
   return false;    
}
}
}