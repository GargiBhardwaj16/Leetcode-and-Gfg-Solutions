class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, graph[0], graph, new ArrayList<>(), res);
        return res;
    }

    void dfs(int node, int[]path, int[][] graph, List<Integer> list, List<List<Integer>> res){
        list.add(node);
        if(node == graph.length - 1) {
            res.add(list);
            return;
        }
        for(int p : path){
            dfs(p, graph[p], graph, new ArrayList<>(list), res);
        }
    }


}