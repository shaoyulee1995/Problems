# Network Delay Time
# Dijkstra
* Time Complexity: O(Tlog(T))
* Space Complexity: O(T+N)
	* N as n
	* T as length of times
```
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer> > map = new HashMap();
        for(int[] time: times){
            map.computeIfAbsent(time[0], x -> new HashMap<>()).put(time[1], time[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[] {0,k});
        int res = 0;
        boolean[] visited = new boolean[n+1];
        while(!pq.isEmpty()){
            int[] data = pq.remove();
            int curNode = data[1],
                totalTravel = data[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = totalTravel;
            n--;
            if(n == 0){
                return res;
            }
            
            if(map.containsKey(curNode)){
                for(int next: map.get(curNode).keySet()){
                    pq.add(new int[]{totalTravel + map.get(curNode).get(next), next});
                }
            }
        }
        return n == 0? res: -1;
        
    }
}
```
# Floyd-Warshall
* Time Complexity: O(N<sup>3</sup>)
* Space Complexity: O(N<sup>2</sup>)
	* N as n
```
class Solution {
    public int networkDelayTime(int[][] times, int n, int K) {
        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for(int[] time: times){
            graph[time[0]][time[1]] = time[2];
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(graph[K][i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, graph[K][i]);
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}
```
# Bellman-Ford
* Time Complexity: O(kT)
* Space Complexity: O(N)
	* T as length of times
	* k as stops
	* N as n
```
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        for(int i = 0; i < n; i++){
            for(int[] time: times){
                int u = time[0],
                    v = time[1],
                    w = time[2];
                if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w){
                    distance[v] = distance[u] + w;
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            res = Math.max(res, distance[i]);
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}
```