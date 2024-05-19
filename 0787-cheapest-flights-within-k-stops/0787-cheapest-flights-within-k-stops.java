class Solution {
    class Pair{
        int f;
        int s;
        Pair(int f,int s){
            this.f=f;
            this.s=s;
        }
    }
    class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
              adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
        while(!q.isEmpty()){
            int dis=q.peek().first;
            int node=q.peek().second;
            int cost=q.peek().third;
            Tuple t=q.poll();
            if(dis>k) continue;
            for(Pair it:adj.get(node)){
                int nod=it.f;
                int edgeWeight=it.s;
                if(cost+edgeWeight<dist[nod] && dis<=k){
                    dist[nod]=cost+edgeWeight;
                    q.add(new Tuple(dis+1,nod,dist[nod]));
                }
            }
        }
        if(dist[dst]==(int)(1e9) || dist[dst]==0) return -1;
    return dist[dst];
    }
}