```
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length,
            m = heights[0].length;
        //i, j, val
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Integer.compare(a[2], b[2]));
        pq.offer(new int[] {0, 0, 0});
        Integer[][] minDist = new Integer[n][m];
        minDist[0][0] = 0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0],
                v = node[1],
                dist = node[2];
            if(u == n - 1 && v == m - 1){
                return dist;
            }    
            for(int[] dir: dirs){
                int x = dir[0] + u,
                    y = dir[1] + v;
                if(x < 0 || y < 0 || x >= n || y >= m){
                    continue;
                }
                int weights = Math.max(dist, Math.abs(heights[u][v] - heights[x][y]));
                if(minDist[x][y] == null || minDist[x][y] > weights){
                    minDist[x][y] = weights;
                    pq.offer(new int[]{x, y, weights});
                }
            }
        }
        return -1;
    }
}
```