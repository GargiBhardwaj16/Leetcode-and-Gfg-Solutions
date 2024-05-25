class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
       ArrayList<Integer>[] adj=new ArrayList[n];
       for(int i=0;i<n;i++){
           adj[i]=new ArrayList<>();
       }
        for(int[] edge: edges){
            int x=edge[0];
            int y=edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] vis=new boolean[n];
        int res=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                List<Integer> hs=new ArrayList<>();
                dfs(i,vis,hs,adj);
                boolean flag=true;
                for(int j: hs){
                 if(adj[j].size()!=hs.size()-1){
                      flag=false;
                  }
                }
                if(flag){
                    res++;
                }
            }
        }
        return res;
    }
    public static  void dfs(int vertex,boolean vis[],List<Integer> hs,ArrayList<Integer>[] adj){
        vis[vertex]=true;
        hs.add(vertex);
        for(int i:adj[vertex]){
            if(!vis[i]){
                dfs(i,vis,hs,adj);
            }
        }
    }
}