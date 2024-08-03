# Minimum Height Trees

- Time Complexity: O(N+E)
- Space Complexity: O(N+E)
  - N as nodes 
  - E as edges

```java
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Arrays.asList(0);
        }
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList());
        }
        int[] inDegree = buildGraph(n, edges, graph);
        List<Integer> leaves = new ArrayList();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 1){
                leaves.add(i);
            }
        }
        while(true){
            List<Integer> newLeaves = new ArrayList();
            for(int leave: leaves){
                for(int neighbor: graph.get(leave)){
                    --inDegree[neighbor];
                    if(inDegree[neighbor] == 1){
                        newLeaves.add(neighbor);
                    }
                }
            }
            if(newLeaves.isEmpty()){
                return leaves;
            }
            leaves = newLeaves;
        }

    }

    public int[] buildGraph(int n, int[][] edges, List<List<Integer>> graph){
        int[] inDegree = new int[n];
        for(int[] edge: edges){
            int a = edge[0],
                b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
            inDegree[a]++;
            inDegree[b]++;
        }
        return inDegree;
    }
}
```