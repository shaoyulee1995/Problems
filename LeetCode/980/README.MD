# Unique Paths III

- Time Complexity: O(4<sup>MN</sup>)
- Space Complexity: O(1)
  - M as length of grid
    - N as length of grid[0]

```
class Solution {
    int empty, res;
    public int uniquePathsIII(int[][] grid) {
        int startX = 0,
            startY = 0;
        empty = 0;
        res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    empty++;
                }else if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                    empty++;
                }
            }
        }
        dfs(grid, startX, startY);
        return res;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int[][] grid, int x, int y){
        if(grid[x][y] == 2){
            if(empty == 0){
                res++;
            }
            return;
        }
        int temp = grid[x][y];
        empty--;
        grid[x][y] = -2;
        for(int[] dir: dirs){
            int nextX = x + dir[0],
                nextY = y + dir[1];
            if(nextX < 0 || nextX == grid.length || nextY < 0 || nextY == grid[0].length){
                continue;
            }
            if(grid[nextX][nextY] == 0 || grid[nextX][nextY] == 2){
                dfs(grid, nextX, nextY);
            }
        }
        grid[x][y] = temp;
        empty++;
    }
}
```
