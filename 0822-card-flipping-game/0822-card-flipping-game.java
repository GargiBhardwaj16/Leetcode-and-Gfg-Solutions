class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int minGood = 0;

        boolean[] isGood = new boolean[2000];
        for (int num : fronts) {
            isGood[num - 1] = true;
        }
        for (int num : backs) {
            isGood[num - 1] = true;
        }

        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                isGood[fronts[i] - 1] = false;
            }
        }

        for (int i = 0; i < 2000; i++) {
            if (isGood[i]) {
                minGood = i + 1;
                break;
            }
        }

        return minGood;
    }
}