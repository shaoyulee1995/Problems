# Top-Down
* Time Complexity: O(NM)
* Space Complexity: O(1)
```
class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0){
                    continue;//(0,0) dont touch
                }
                if(i == 0){ 
                    grid[i][j] += grid[i][j-1];
                    continue; //check (0,1),(0,2)...(0,n)
                }
                if(j == 0){
                    grid[i][j] += grid[i-1][j];
                    continue; //check (1,0),(2,0)...(n,0)
                }
                //rest of the boxes
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length -1][grid[0].length -1];
    }
}
```
# Botton-Up
* Time Complexity: O(NM)
* Space Complexity: O(1)
```
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length,
            m = grid[0].length;
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i == n-1 && j == m-1){
                    continue;
                }
                if(i == n-1){
                    grid[i][j] += grid[i][j+1];
                }else if(j == m-1){
                    grid[i][j] += grid[i+1][j];
                }else{
                    grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
                }
            }
        }
        return grid[0][0];
    }
}
```
# Memorization Recursion
* Time Complexity: O(NM)
* Space Complexity: O(NM)
```
class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int n = grid.length,
            m = grid[0].length;
        dp = new int[n+1][m+1];
        return minPathSum(grid, n-1, m-1);
    }
    public int minPathSum(int[][] grid, int n, int m){
        if(n == 0 && m == 0){
            return grid[0][0];
        }
        if(dp[n][m] != 0){
            return dp[n][m];
        }
        if(n == 0){
            dp[n][m] = minPathSum(grid, n, m-1) + grid[n][m];
            return dp[n][m];
        }
        if(m == 0){
            dp[n][m] = minPathSum(grid, n-1, m) + grid[n][m];
            return dp[n][m];
        }
        dp[n][m] = grid[n][m] + Math.min(minPathSum(grid, n-1, m),
                                     minPathSum(grid, n, m-1));
        return dp[n][m];
    }
}
```