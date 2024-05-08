class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        Map<Integer, String> map = new HashMap<>();
        int[] sortScore = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            sortScore[i] = score[i];
        }
        Arrays.sort(sortScore);
        int count = 0;
        for (int i = sortScore.length - 1; i >= 0; i--) {
            count++;
            if (count == 1) {
                map.put(sortScore[i], "Gold Medal");
            } else if (count == 2) {
                map.put(sortScore[i], "Silver Medal");
            } else if (count == 3) {
                map.put(sortScore[i], "Bronze Medal");
            } else {
                map.put(sortScore[i], Integer.toString(count));
            }
        }

        for (int i = 0; i < score.length; i++) {
            ans[i] = map.get(score[i]);
        }
        
        return ans;
    }
}