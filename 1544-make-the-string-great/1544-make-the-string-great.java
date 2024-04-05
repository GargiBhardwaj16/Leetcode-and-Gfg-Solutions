class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean flag = false;
        while(!sb.isEmpty() || !flag){
            for(int i = 0; i <= sb.length() - 2; i++){
                if(Character.isUpperCase(sb.charAt(i)) || Character.isUpperCase(sb.charAt(i + 1))){
                    if(Character.toLowerCase(sb.charAt(i)) == sb.charAt(i + 1) || (Character.toLowerCase(sb.charAt(i + 1)) == sb.charAt(i))){
                        sb.deleteCharAt(i); // we have to delete the bas chars, when you deleted ith char then i + 1th char comes to ith position
                        sb.deleteCharAt(i); // so the (i + 1)th char is at ith position lets delete this bad char.
                        flag = true;
                        break; // let's break the loop and again start checking from 0th index.
                    }
                }

            }
            if(!flag){ // checking if we encounter any bad case or not
                break;
            }else flag = false; // reset the flag as it was for the further checks
        }
        return sb.isEmpty() ? "" : sb.toString();
    }
}