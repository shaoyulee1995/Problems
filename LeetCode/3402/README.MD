# Minimum Operations to Make Columns Strictly Increasing

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {
    public int minimumOperations(int[][] grid) {
        int res = 0;
        for(int j = 0; j < grid[0].length; j++){
            for(int i = 1; i < grid.length; i++){
                if(grid[i][j] < grid[i-1][j]+1){
                    res += grid[i-1][j]+1 - grid[i][j];
                    grid[i][j] = grid[i-1][j]+1;
                }
            }
        }
        return res;
    }
}
```