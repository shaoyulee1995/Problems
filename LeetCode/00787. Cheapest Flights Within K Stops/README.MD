# Bellman-Ford
* Time Complexity: O(kN)
* Space Complexity: O(N)
	* N as edges
	* k as stops
```
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i = 0; i <= k; i++){
            int[] temp = Arrays.copyOf(dist, n);
            for(int[] flight: flights){
                int from = flight[0],
                    to = flight[1],
                    cost = flight[2];
                if(dist[from] == Integer.MAX_VALUE){
                    continue;
                }
                if(dist[from] + cost < temp[to]){
                    temp[to] = dist[from] + cost;
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE?-1: dist[dst];
    }
}
```
# Dijkstra's Algorithm 
* Time Complexity: O(VE)
* Space Complexity: O(VE)
	* V as edges
	* E as stops
```
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, Integer>[] graph = new HashMap[n];
        for(int i = 0; i < n; i++){
            graph[i] = new HashMap();
        }
        for(int[] flight: flights){
            graph[flight[0]].put(flight[1], flight[2]);
        }
        int[] minStops = new int[n];
        int[] minCosts = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minStops[src] = 0;
        minStops[src] = 0;
        //src, cost, stop
        Queue<int[]> pq = new PriorityQueue<int[]>((a,b)-> a[1]-b[1]);
        pq.offer(new int[]{src, 0, 0});
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int curPos = node[0],
                curCost = node[1],
                curStop = node[2];
            
            if(curPos == dst){
                return curCost;
            }
            if(curStop > k){
                continue;
            }
            for(int next: graph[curPos].keySet()){
                int nextCost = graph[curPos].get(next);
                if(curCost + nextCost < minCosts[next]){
                    pq.offer(new int[]{next, nextCost + curCost, curStop + 1});
                    minCosts[next] = curCost + nextCost;
                }else if(curStop < minStops[next]){
                    pq.offer(new int[]{next, nextCost + curCost, curStop + 1});
                }
                minStops[curPos] = curStop;
            }
        }
        return -1;
    }
}
```