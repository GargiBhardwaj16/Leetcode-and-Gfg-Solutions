class DSU{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DSU(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        parent.set(node,findParent(parent.get(node)));
        return parent.get(node);
    }
    public void union(int u,int v){
        int pu=findParent(u);
        int pv=findParent(v);
        if(pu==pv) return;
        if(rank.get(pu)<rank.get(pv)){
            parent.set(pu,pv);
        }
        else if(rank.get(pu)>rank.get(pv)){
            parent.set(pv,pu);
        }
        else{
            parent.set(pv,pu);
            rank.set(pu,rank.get(pu)+1);
        }
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.findParent(source) == dsu.findParent(destination);
    }
}