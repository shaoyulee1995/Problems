# Min Cost to Connect All Points

# Union

- Time Complexity: O(ELog(E))
- Space Complexity: O(E+V)

```
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList();
        int n = points.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int xi = points[i][0], yi = points[i][1],
                    xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{
                    i, j, Math.abs(xi - xj)+ Math.abs(yi - yj)
                });
            }
        }
        Collections.sort(edges, (a,b)->{
            return a[2]-b[2];
        });
        int mst = 0;
        UF uf = new UF(n);
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if(uf.isConnect(u,v)){
                continue;
            }
            mst += weight;
            uf.union(u,v);
        }
        return mst;
    }
    class UF{
        private int count;
        private int[] parent, size;

        public UF(int n){
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            if(size[rootP] > size[rootQ]){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }else{
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
        public boolean isConnect(int p, int q){
            int rootp = find(p);
            int rootq = find(q);
            return rootp == rootq;
        }
        public int find(int x){
            while(parent[x] != x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public int count(){
            return count;
        }
    }
}
```

# Prim's Algorithm

- Time Complexity: O(N^2)
- Space Complexity: O(N)
  - N as length of points

```
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length,
            minCost = 0,
            edgeUsed = 0;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        for(int i = 0; i < n; i++){
            minDist[i] = Integer.MAX_VALUE;
        }
        minDist[0] = 0;
        while(edgeUsed < n){
            int curMinEdge = Integer.MAX_VALUE,
                curNode = -1;
            for(int node = 0; node < n; node++){
                if(!visited[node] && minDist[node] < curMinEdge){
                    curNode = node;
                    curMinEdge = minDist[node];
                }
            }
            minCost += curMinEdge;
            edgeUsed++;
            visited[curNode] = true;
            for(int nextNode = 0; nextNode < n; nextNode++){
                int weight = Math.abs(points[curNode][0] - points[nextNode][0]) +
                             Math.abs(points[curNode][1] - points[nextNode][1]);
                if(!visited[nextNode] && minDist[nextNode] > weight){
                    minDist[nextNode] = weight;
                }
            }
        }
        return minCost;
    }
}
```
