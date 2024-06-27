class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> degree = new HashMap<>();
        for (int[] edge : edges) {
            degree.put(edge[0], degree.getOrDefault(edge[0], 0) + 1);
            degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
        }
        for (int node : degree.keySet()) {
            if (degree.get(node) == edges.length) {
                return node;
            }
        }
        return -1;
    }
}