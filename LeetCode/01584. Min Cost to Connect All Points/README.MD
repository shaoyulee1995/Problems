# Union
* Time Complexity: O(ELog(E))
* Space Complexity: O(E+V)
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