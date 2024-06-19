# Unique Paths II

# Dynamic Programming

- Time Complexity: O(MN)
- Space Complexity: O(MN)
  - M as obstacleGrid's row
  - N as obstacleGrid's column

```
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,
            n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m && obstacleGrid[i][0] == 0; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n && obstacleGrid[0][i] == 0; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
```
