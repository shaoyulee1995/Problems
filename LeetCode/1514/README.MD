# Path with Maximum Probability
- Time Complexity: O((V + E)logV)
- Space Complexity: O(V + E)
  - V as number of vertices
  - E as number of edges

```java
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, List<int[]>> graph = new HashMap();
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0],
                b = edges[i][1];
            graph.computeIfAbsent(a, x -> new ArrayList()).add(new int[]{b, i});
            graph.computeIfAbsent(b, x -> new ArrayList()).add(new int[]{a, i});
        }
        double[] prob = new double[n];
        prob[start] = 1d;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int[] data: graph.getOrDefault(cur, Collections.emptyList())){
                int neighbor = data[0],
                    index = data[1];
                if(prob[cur] * succProb[index] > prob[neighbor]){
                    prob[neighbor] = prob[cur] * succProb[index];
                    queue.offer(neighbor);
                }
            }
        }
        return prob[end];
    }
}
```

- Time Complexity: O((V + E)logV)
- Space Complexity: O(V + E)
  - V as number of vertices
  - E as number of edges

```java
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> graph = new HashMap();
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0],
                b = edges[i][1];
            double prob = succProb[i];
            graph.computeIfAbsent(a, x -> new ArrayList<>()).add(new double[]{b, prob});
            graph.computeIfAbsent(b, x -> new ArrayList<>()).add(new double[]{a, prob});
        }
        double[] probs = new double[n];
        probs[start_node] = 1d;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start_node, 1d});
        
        while(!pq.isEmpty()){
            double[] node = pq.poll();
            int index = (int)node[0];
            double currentProb = node[1];

            if(index == end_node){
                return currentProb;
            }

            if(currentProb < probs[index]){
                continue;
            }

            for(double[] neighbor: graph.getOrDefault(index, Collections.emptyList())){
                int nextIndex = (int)neighbor[0];
                double nextProb = neighbor[1],
                       newProb = nextProb * currentProb;
                if(newProb > probs[nextIndex]){
                    probs[nextIndex] = newProb;
                    pq.offer(new double[]{nextIndex, newProb});
                }
            }
        }
        return 0d;
    }
}
```