# Unique Paths II

- Time Complexity: O(MN)
- Space Complexity: O(MN)
  - M as length of grid
  - N as length of grid[0]

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length && grid[i][0] == 0; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < grid[0].length && grid[0][j] == 0; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
```
