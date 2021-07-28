# UnionFind
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String eq: equations){
            if(eq.charAt(1) == '='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x-'a', y-'a');
            }
        }
        for(String eq: equations){
            if(eq.charAt(1) =='!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if(uf.isConnected(x-'a', y-'a')){
                    return false;
                }
            }
        }
        return true;
    }
    class UnionFind{
        int[] parents;
        public UnionFind(int nodes){
            parents = new int[nodes];
            for(int i = 0; i < nodes; i++){
                parents[i] = i;
            }
        }
        
        public void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1 != root2){
                parents[root2] = root1;
            }
        }
        public int find(int node){
            while(parents[node] != node){
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }
        public boolean isConnected(int node1, int node2){
            return find(node1) == find(node2);
        }
    }
}
```