class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            visited[to] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result.add(i);
            }
        }
        return result;
    }
}