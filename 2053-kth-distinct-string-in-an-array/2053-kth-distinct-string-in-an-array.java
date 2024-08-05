class Solution {
    public String kthDistinct(String[] arr, int k) {
        int n = arr.length;
        List<String> distinctStrings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String currentString = arr[i];
            boolean isDistinct = true;
            for (int j = 0; j < n; j++) {
                if (j == i) continue; 
                if (arr[j].equals(currentString)) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) {
                distinctStrings.add(currentString);
            }
        }

        if (distinctStrings.size() < k) {
            return "";
        }

        return distinctStrings.get(k - 1);
    }
}