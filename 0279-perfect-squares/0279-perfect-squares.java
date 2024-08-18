class Solution {
    public int numSquares(int n) {
        int x=1;
        ArrayList<Integer> list=new ArrayList<>();
        while(x*x<=n){
            if(x*x==n){
                return 1;
            }
            list.add(x*x);
            x++;
        }
        for(int i=0;i<list.size();i++){
            for(int j=i;j<list.size();j++){
                if(list.get(i)+list.get(j)==n){
                    return 2;
                }
            }
        }
         for(int i=0;i<list.size();i++){
            for(int j=i;j<list.size();j++){
                for(int k=j;k<list.size();k++){
                   if(list.get(i)+list.get(j) +list.get(k)==n){
                    return 3;
                    }
                }
            }
        }
        return 4;
    }
}
