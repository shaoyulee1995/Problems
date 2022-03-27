# Dijkstra
* Time Complexity: O((N<sup>2</sup>)
* Space Complexity: O(N<sup>2</sup>)
	* N as n
```
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adj = new List[n];
        int[][] dist = new int[n][n];
        int INF = (int)1e9+7;
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }
        for(int[] edge: edges){
            int u = edge[0],
                v = edge[1],
                weight = edge[2];
            adj[u].add(new int[]{v, weight});
            adj[v].add(new int[]{u, weight});
        }
        for(int i = 0; i < n; i++){
            dijkstra(adj, dist[i], i);
        }
        int minCity = -1,
            minCityCount = n;
        for(int i = 0; i < n; i++){
            int curCity = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(dist[i][j] <= distanceThreshold){
                    curCity++;
                }
            }
            if(minCityCount >= curCity){
                minCityCount = curCity;
                minCity = i;
            }
        }
        return minCity;
    }
    public void dijkstra(List<int[]>[] adj, int[] dist, int src){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        while(!pq.isEmpty()){
            int[] node = pq.remove();
            int u = node[0],
                weightU = node[1];
            if(weightU > dist[u]){
                continue;
            }
            for(int[] neighbor: adj[u]){
                int v = neighbor[0],
                    weightV = neighbor[1];
                if(dist[v] > weightU + weightV){
                    dist[v] = weightU + weightV;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
    }
}
```
# Bellman
* Time Complexity: O((N<sup>2</sup>E)
* Space Complexity: O(N<sup>2</sup>)
	* N as n
	* E as length of edges
```
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adj = new List[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList();
        }
        int INF = (int)1e9+7;
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int[] edge: edges){
            int u = edge[0],
                v = edge[1],
                weight = edge[2];
            adj[u].add(new int[]{v, weight});
            adj[v].add(new int[]{u, weight});
        }
        for(int i = 0; i < n; i++){
            bellman(n, edges, dist[i], i);
        }
        int minCity = -1,
            minCityCount = n;
        for(int i = 0; i < n; i++){
            int curCityCount = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(dist[i][j] <= distanceThreshold){
                    curCityCount++;
                }
            }
            if(minCityCount >= curCityCount){
                minCityCount = curCityCount;
                minCity = i;
            }
        }
        return minCity;
    }
    public void bellman(int n, int[][] edges, int[] dist, int src){
        for(int i = 1; i < n; i++){
            for(int[] edge: edges){
                int u = edge[0],
                    v = edge[1],
                    weight = edge[2];
                if(dist[u] > dist[v] + weight){
                    dist[u] = dist[v] + weight;
                }
                if(dist[v] > dist[u] + weight){
                    dist[v] = dist[u] + weight;
                }
            }
        }
    }
}
```
# Floyd Warshall
* Time Complexity: O((N<sup>3</sup>)
* Space Complexity: O(N<sup>2</sup>)
```
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int INF = (int)1e9+7;
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int[] edge: edges){
            int u = edge[0],
                v = edge[1],
                weight = edge[2];
            dist[u][v] = weight;
            dist[v][u] = weight;
        }
        floyd(n, dist);
        int minCity = -1,
            minCityCount = n;
        for(int i = 0; i < n; i++){
            int curCityCount = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(dist[i][j] <= distanceThreshold){
                    curCityCount++;
                }
            }
            if(minCityCount >= curCityCount){
                minCityCount = curCityCount;
                minCity = i;
            }
        }
        return minCity;
    }
    public void floyd(int n, int[][] dist){
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
```