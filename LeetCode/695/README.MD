# Max Area of Island

# DFS

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of grid
  - M as length of grid[0]

```
class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length,
            m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i == grid.length){
            return 0;
        }
        if(j < 0 || j == grid[0].length){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        int cnt = 0;
        grid[i][j] = 0;
        cnt += dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1) + 1;
        return cnt;
    }
}
```

# DFS for loop check

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of grid
  - M as length of grid[0]

```
class Solution {
    int maxArea = 0;
    int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length,
            m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                dfs(grid, i, j, 1);
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int i, int j, int cnt){
        grid[i][j] = 0;
        for(int[] dir: dirs){
            int x = dir[0] + i,
                y = dir[1] + j;
            if(x < 0 || x == grid.length){
                continue;
            }
            if(y < 0 || y == grid[0].length){
                continue;
            }
            if(grid[x][y] == 0){
                continue;
            }
            cnt = dfs(grid, x, y, cnt+1);
        }
        maxArea = Math.max(cnt, maxArea);
        return cnt;
    }
}
```
