	# Dynamic Programming
	* Time Complexity: O(N)
	* Space Complexity: O(N)
```
class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
```
# Dynamic Programming
* Time Complexity: O(N)
* Space Complexity: O(3)

```
class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            int sum = dp[i-1] + dp[i-2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[n];
    }
}
```