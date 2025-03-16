# Climbing Stairs

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```java
class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
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

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int prev_prev = 1,
            prev = 2,
            cur = 0;
        for(int i = 3; i <= n; i++){
            cur = prev + prev_prev;
            prev_prev = prev;
            prev = cur;
        }
        return cur;
    }
}
```
