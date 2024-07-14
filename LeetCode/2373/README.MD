# Largest Local Values in a Matrix

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length,
            m = grid[0].length;
        int[][] res = new int[n-2][m-2];
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < m-2; j++){
                res[i][j] = localMax(grid, i, j);
            }
        }
        return res;
    }
    public int localMax(int[][] grid, int row, int col){
        int max = Integer.MIN_VALUE;
        for(int i = row; i < row+3; i++){
            for(int j = col; j < col+3; j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
```
