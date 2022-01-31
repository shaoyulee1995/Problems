# Dynamic Programming
* Time Complexity: O(N^2)
* Space Complexity: O(N)
	* N as n
```
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i - 1; j++){
                dp[i] = Math.max(dp[i], 
                                Math.max(j*(i-j), j * dp[i-j]));
            }
        }
        return dp[n];
    }
}
```