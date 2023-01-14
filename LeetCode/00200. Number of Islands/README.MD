# DFS
* Time Complexity: O(NM)
* Space Complexity: O(1)
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
        Queue<int[]> q = new LinkedList();
        int res = 0,
            n = grid.length,
            m = grid[0].length;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                res++;
                q.offer(new int[]{i, j});
                while(!q.isEmpty()){
                    int[] pos = q.poll();
                    int x = pos[0],
                        y = pos[1];
                    for(int[] dir: dirs){
                        int newX = dir[0] + x;
                        int newY = dir[1] + y;
                        if(newX < 0 || newX == n){
                            continue;
                        }
                        if(newY < 0 || newY == m){
                            continue;
                        }
                        if(grid[newX][newY] == '0'){
                            continue;
                        }
                        grid[newX][newY] = '0';
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return res;
    }
}
```