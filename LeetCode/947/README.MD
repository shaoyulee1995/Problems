# Most Stones Removed with Same Row or Column

# Union Find

- Time Complexity: O(N<sup>2</sup>logN)
- Space Complexity: O(N)
  - N as length of stones

```
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UF uf = new UF(n);
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int[] a = stones[i],
                      b = stones[j];
                if(a[0] == b[0] || a[1] == b[1]){
                    uf.union(i, j);
                }
            }
        }
        return n - uf.size();
    }
}
class UF{
    int[] nodes;
    int size;
    public UF(int n){
        size = n;
        nodes = new int[n];
        for(int i = 0; i < n; i++){
            nodes[i] = i;
        }
    }
    public void union(int a, int b){
        int rootA = find(a),
            rootB = find(b);
        if(rootA != rootB){
            nodes[rootA] = rootB;
            size--;
        }
    }
    public int find(int root){
        while(nodes[root] != root){
            nodes[root] = nodes[nodes[root]];
            root = nodes[root];
        }
        return root;
    }
    public int size(){
        return size;
    }
}
```
