# Min Cost to Connect All Points

- Time Complexity: O(ELog(E))
- Space Complexity: O(E+V)

```java
class Solution {
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
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of points

```java
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

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of points

```java
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        minDistance[0] = 0;
        for(int i = 0; i < n; i++){
            int nextPoint = -1;
            for(int j = 0; j < n; j++){
                if(!visited[j] && (nextPoint == -1 || minDistance[j] < minDistance[nextPoint])){
                    nextPoint = j;
                }
            }
            visited[nextPoint] = true;
            for(int j = 0; j < n; j++){
                if(!visited[j]){
                    minDistance[j] = Math.min(minDistance[j], matrix[nextPoint][j]);
                }
            }
        }
        return Arrays.stream(minDistance).sum();
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of points
  
```java
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length,
            minCost = 0;
        HashSet<Integer> visited = new HashSet();
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[0] = 0;
        while(visited.size() < n){
            int curMinEdge = Integer.MAX_VALUE,
                node = -1;
            for(int i = 0; i < n; i++){
                if(!visited.contains(i) && minDistance[i] < curMinEdge){
                    curMinEdge = minDistance[i];
                    node = i;
                }
            }
            if(curMinEdge == Integer.MAX_VALUE){
                return -1;
            }
            minCost += curMinEdge;
            visited.add(node);
            for(int next = 0; next < n; next++){
                int weight = Math.abs(points[node][0] - points[next][0]) + Math.abs(points[node][1] - points[next][1]);
                if(!visited.contains(next) && minDistance[next] > weight){
                    minDistance[next] = weight;
                }
            }
        }
        return (visited.size() == n)? minCost: -1;
    }
}
```