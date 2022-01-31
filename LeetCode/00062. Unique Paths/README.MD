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
# DFS [TLE]
* Time Complexity: O(2^(M + N -1)-1)
* Space Complexity: O(1)
	* M as m
	* N as n
```
class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(1, 1, m, n);
    }
    public int dfs(int i, int j, int m, int n){
        if(i > m || j > n){
            return 0;
        }
        if(i == m || j == n){
            return 1;
        }
        return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
    }
}
```