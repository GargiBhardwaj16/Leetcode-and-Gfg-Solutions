class Solution {
    public int countWords(String[] words1, String[] words2) {
       HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i=0; i<words1.length; i++) {
            if (map.containsKey(words1[i])) {
                int value = map.get(words1[i]);
                map.put(words1[i], value+1);
            }
            else {
                map.put(words1[i], 1);
            }
        }
        for (int i=0; i<words2.length; i++) {
            if (map1.containsKey(words2[i])) {
                int value = map1.get(words2[i]);
                map1.put(words2[i], value+1);
            }
            else {
                map1.put(words2[i], 1);
            }
        }
        int count = 0;
        for (String i : map1.keySet()) {
            if (map1.containsKey(i) && map.containsKey(i)) {
                if (map1.get(i) == 1 && map.get(i) == 1) {
                    count++;
                }
            }
        }
        return count; 
    }
}