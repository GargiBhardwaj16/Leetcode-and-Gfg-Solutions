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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
         int n = accounts.size();
         DSU dsu = new DSU(10001);
         Map<String, Integer> emailToIndex = new HashMap<>();
         Map<String, String> emailToName = new HashMap<>();
         int index = 0;
         for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!emailToIndex.containsKey(account.get(i))) {
                    emailToIndex.put(account.get(i), index++);
                }
                emailToName.put(account.get(i), name);
                dsu.union(emailToIndex.get(account.get(1)), emailToIndex.get(account.get(i)));
            }
        }
        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int root = dsu.findParent(emailToIndex.get(email));
            components.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> component : components.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
            result.add(component);
        }
        return result;
    }
}