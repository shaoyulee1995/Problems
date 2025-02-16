# Optimize Water Distribution in a Village

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N is the number of houses

```java
class UnionFind{
    int[] parent;
    public UnionFind(int n){
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }

    public void union(int x, int y){
        parent[find(x)] = parent[find(y)];
    }

    public int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n);
        List<int[]> edges = new ArrayList();
        for(int i = 0; i < n; i++){
            edges.add(new int[]{0, i+1, wells[i]});
        }
        for(int[] pipe: pipes){
            edges.add(pipe);
        }
        Collections.sort(edges, (a,b) -> a[2] - b[2]);
        int res = 0;

        for(int[] edge: edges){
            int x = uf.find(edge[0]),
                y = uf.find(edge[1]);
            if(x != y){
                res += edge[2];
                uf.union(x, y);
            }
        }

        return res;
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N is the number of houses

```java
class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++){
            graph.computeIfAbsent(0, x -> new HashMap<>()).put(i+1, wells[i]);
        }
        for(int[] pipe: pipes){
            int src = pipe[0],
                dest = pipe[1],
                cost = pipe[2],
                costFromSrcToDest = graph.computeIfAbsent(src, x -> new HashMap<>()).getOrDefault(dest, Integer.MAX_VALUE),
                costFromDestToSrc = graph.computeIfAbsent(dest, x -> new HashMap<>()).getOrDefault(src, Integer.MAX_VALUE);
            graph.get(src).put(dest, Math.min(cost, costFromSrcToDest));
            graph.get(dest).put(src, Math.min(cost, costFromDestToSrc));
        }

        HashSet<Integer> visited = new HashSet();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        int res = 0;
        while(!pq.isEmpty()){
            int[] data = pq.poll();
            int node = data[0],
                cost = data[1];
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            res += cost;
            for(int neighbor: graph.getOrDefault(node, new HashMap<>()).keySet()){
                if(!visited.contains(neighbor)){
                    pq.offer(new int[]{neighbor, graph.get(node).get(neighbor)});
                }
            }
        }
        return res;
    }
}
```