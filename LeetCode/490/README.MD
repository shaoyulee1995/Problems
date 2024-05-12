# The Maze
# One direction BFS
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of maze
	* M as length of maze[0]
```
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length,
            m = maze[0].length;
        int[][] dirs = new int[][]{{-1,0},{1,0}, {0,-1}, {0,1}};
        Queue<int[]> q = new LinkedList();
        q.offer(start);
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1]){
                return true;
            }
            for(int[] dir: dirs){
                int x = cur[0] + dir[0],
                    y = cur[1] + dir[1];
                while(x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                
                x -= dir[0];
                y -= dir[1];
                
                if(!visited[x][y]){
                    q.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
```