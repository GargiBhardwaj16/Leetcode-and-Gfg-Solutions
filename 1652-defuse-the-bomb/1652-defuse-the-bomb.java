class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        int sum = 0, start = 0, end = 0;

        while (start < code.length && k != 0) {
            sum += code[end++ % code.length];
            if (end >= Math.abs(k)) {
                int idx = k < 0 ? end : code.length - 1 + start;
                result[idx % code.length] = sum;
                sum -= code[start++];
            }
        }

        return result;
    }
}