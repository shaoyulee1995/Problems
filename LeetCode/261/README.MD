# Graph Valid Tree

- Time Complexity: O(EH)
- Space Complexity: O(N)
  - E as edges
  - H as height of tree
  - N as n

```
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge: edges){
            int u = edge[0],
                v = edge[1];
            if(uf.isConnected(u, v)){
                return false;
            }
            uf.union(u,v);
        }
        return uf.count == 1;
    }
    class UF{
        int count;
        int[] parent;
        int[] size;
        public UF(int n){
            this.size = new int[n];
            this.parent = new int[n];
            this.count = n;
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public void union(int node1, int node2){
            int rootA = find(node1),
                rootB = find(node2);
            if(size[rootA] > size[rootB]){
                parent[rootB] = rootA;
            }else{
                parent[rootA] = rootB;
            }
            count--;
        }
        public int find(int node){
            while(node != parent[node]){
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        public boolean isConnected(int node1, int node2){
            return find(node1) == find(node2);
        }
        public int getCount(){
            return count;
        }
    }
}
```
