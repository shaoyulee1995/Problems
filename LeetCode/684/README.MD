# Redundant Connection
# Union Find
* Time Complexity: O(E)
* Space Complexity: O(E)
	* E as length of edges
```
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge: edges){
            if(!(uf.union(edge[0], edge[1]))){
                return edge;
            }
        }
        return new int[]{};
    }
}
class UnionFind{
    int[] parent;
    public UnionFind(int n){
        parent = new int[n+1];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    
    public int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    
    public boolean union(int x, int y){
        int rootX = find(x),
            rootY = find(y);
        if(rootX != rootY){
            parent[rootX] = rootY;
            return true;
        }
        return false;
    }
}
```