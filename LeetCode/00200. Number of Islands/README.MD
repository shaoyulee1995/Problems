# DFS
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of grid
	* M as length of grid[0]
```
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0,
            n = grid.length,
            m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    numIslands(grid, i, j);
                    res++;
                }          
            }
        }
        return res;
    }
    public void numIslands(char[][] grid, int i, int j){
        if(i < 0 || i == grid.length){
            return;
        }
        if(j < 0 || j == grid[0].length){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        numIslands(grid, i+1, j);
        numIslands(grid, i-1, j);
        numIslands(grid, i, j+1);
        numIslands(grid, i, j-1);
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
        int n = grid.length, 
            m = grid[0].length,
            res = 0;
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    res++;
                    q.offer(new int[]{i, j});
                    bfs(q, grid);
                }
            }
        }
        return res;
    }
    int[][] dirs = new int[][]{{-1,0}, {1,0},{0,1},{0,-1}};
    public void bfs(Queue<int[]> q, char[][] grid){
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] dir: dirs){
                int x = dir[0] + cell[0],
                    y = dir[1] + cell[1];
                if(x < 0 || x == grid.length || y < 0 || y == grid[0].length){
                    continue;
                }
                if(grid[x][y] == '0'){
                    continue;
                }
                q.offer(new int[]{x,y});
                grid[x][y] = '0';
            }
        }
    }
}
```