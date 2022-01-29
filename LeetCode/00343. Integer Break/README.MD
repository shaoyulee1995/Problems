# Dynamic Programming
* Time Complexity: O(N^2)
* Space Complexity: O(N)
	* N as n
```
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], (i-j) * j);
                dp[i] = Math.max(dp[i], dp[j] * (i-j));
            }
        }
        return dp[n];
    }
}
```