class Solution {
    public static void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int i: adj.get(node)){
            if(!vis[i]){
                dfs(i,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int v=isConnected.length;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean vis[]=new boolean[v];
        int cnt=0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,vis,adj);
            }
        }
        return cnt;
    }
}