# Number of Distinct Islands

- Time Complexity: O(NM*4<sup>NM</sup>)
- Space Complexity: O(NM)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> seen = new HashSet();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    sb.append("X");
                    dfs(grid, i, j, sb, "");
                    seen.add(sb.toString());
                }
            }
        }
        return seen.size();
    }

    private void dfs(int[][] grid, int x, int y, StringBuilder sb, String dir){
        if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0){
            return;
        }
        sb.append(dir);
        grid[x][y] = 0;
        dfs(grid, x-1, y, sb, "U");
        dfs(grid, x+1, y, sb, "D");
        dfs(grid, x, y+1, sb, "R");
        dfs(grid, x, y-1, sb, "L");
        sb.append("X");
    }
}
```