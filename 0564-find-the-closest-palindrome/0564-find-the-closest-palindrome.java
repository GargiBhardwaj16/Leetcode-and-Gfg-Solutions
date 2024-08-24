class Solution {
    public String nearestPalindromic(String n) {
        Long  N = Long.parseLong(n);
        long smaller = previous (String.valueOf(N-1).toCharArray());
        long larger = next (String.valueOf(N+1).toCharArray());

        if (N - smaller > larger - N)
            return String.valueOf(larger);

        return String.valueOf(smaller);
    }

    private long previous (char[] num){
        int left = 0, right = num.length-1;

        while (left < right){
            while (num[left] != num[right]){
                decrement(num, right);
                
                if (num[0] == '0')  return Long.parseLong(new String(num));
            }
            left++;
            right--;
        }
        return Long.parseLong(new String(num));
    }

    private void decrement(char[] num, int indx){
        while (num[indx] == '0'){
            num[indx] = '9';
            indx--;
        }

        num[indx]--;
    }

    private long next (char[] num){
        int left = 0, right = num.length-1;

        while (left < right){
            while (num[left] != num[right]){
                increment(num, right);
            }
            left++;
            right--;
        }

        return Long.parseLong(new String(num));
    }

    private void increment(char[] num, int indx){
        while (num[indx] == '9'){
            num[indx] = '0';
            indx--;
        }

        num[indx]++;
    }
}