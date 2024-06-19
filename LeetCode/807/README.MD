# Max Increase to Keep City Skyline

# 2D Array

- Time Complexity: O(NM)
- Space Complexity: O(Max(N,M))
  - N as length of grid
  - M as length of grid[0]

```
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length,
            m = grid[0].length;
        int[] rows = new int[n],
              cols = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }
        return res;
    }
}
```
