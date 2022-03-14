# Matrix
* Time Complexity: O(NMlog(NM))
* Space Complexity: O(NM)
	* N as length of heights
	* M as length of heights[0]
```
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length,
            m = heights[0].length;
        Integer[][] dp = new Integer[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0],
                v = node[1],
                val = node[2];
            if(u == n-1 && v == m-1){
                return val;
            }
            for(int[] dir: dirs){
                int x = u + dir[0],
                    y = v + dir[1];
                if(x < 0 || x == n || y < 0 || y == m){
                    continue;
                }
                int weight = Math.max(val, Math.abs(heights[x][y] - heights[u][v]));
                if(dp[x][y] == null || dp[x][y] > weight){
                    pq.offer(new int[]{x, y, weight});
                    dp[x][y] = weight;
                }
            }
        }
        return -1;
    }
}
```