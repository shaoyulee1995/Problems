# Unique Paths
# Dynamic Programming
* Time Complexity: O(MN)
* Space Complexity: O(MN)
	* M as m
	* N as n
```
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
```
# BottomUp
* Time Complexity: O(MN)
* Space Complexity: O(MN)
	* M as m
	* N as n
```
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];
        return dfs(m-1, n-1, mat);
    }
    public int dfs(int x, int y, int[][] mat){
        if(x == 0 || y == 0){
            return 1;
        }
        if(mat[x][y] > 0){
            return mat[x][y];
        }
        mat[x][y] =  dfs(x-1, y, mat) + dfs(x, y-1, mat);
        return mat[x][y];
    }
}
```
# TopDown
* Time Complexity: O(MN)
* Space Complexity: O(MN)
	* M as m
	* N as n
```
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(dp, 0, 0);
    }

    public int dfs(int[][] dp, int x, int y){
        if(x == dp.length-1 && y == dp[0].length-1){
            return 1;
        }
        if(x == dp.length || y == dp[0].length){
            return 0;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = dfs(dp, x+1, y) + dfs(dp, x, y+1);
        return dp[x][y];
    }
}
```