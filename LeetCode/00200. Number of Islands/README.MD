# DFS
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as length of grid
	* M as length of grid[0]
```
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int x, int y){
        if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x, y+1);
        dfs(grid, x, y-1);
        dfs(grid, x+1, y);
        dfs(grid, x-1, y);
    }
}
```
# BFS
* Time Complexity: O(MN)
* Space Complexity: O(Min(M, N))
	* N as length of grid
	* M as length of grid[0]
```
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }
    public void bfs(char[][] grid, int x, int y){
        Queue<int[]> queue = new LinkedList();
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int i = node[0],
                j = node[1];
            if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0'){
                continue;
            }
            grid[i][j] = '0';
            for(int[] dir: dirs){
                int nextX = dir[0] + i,
                    nextY = dir[1] + j;
                queue.offer(new int[]{nextX, nextY});
            }
        }
    }
}
```