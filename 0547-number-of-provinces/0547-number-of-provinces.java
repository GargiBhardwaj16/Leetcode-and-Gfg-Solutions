class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];  // for storing that if a particular city is visited or not 

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)graph.add(new ArrayList<>());

        for(int i=0;i<n;i++){  // make graph
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(isConnected[i][j]==1){
                    graph.get(i).add(j);
                }
            }
        }

        int totalProvinces = 0; // variable for storing number of components 
        for(int i=0;i<n;i++){
            if(visited[i]==false){ // if any city is not visited than we apply dfs on that city  
                totalProvinces++;
                dfs(graph,visited,i);
            }
        }
        return totalProvinces;

    }
    public static void dfs(List<List<Integer>> graph,boolean visited[],int currentCity){
        visited[currentCity]=true; // mark true because we visit that city
        
        for(int padosiCity:graph.get(currentCity)){  // now get the padosi city (if connected )of current city from graph and if that city is not visited than apply dfs on that city
            if(visited[padosiCity]==false){
                dfs(graph,visited,padosiCity);
            }
        }

    }
}