# Min Cost Climbing Stairs

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for(int i = 2; i < cost.length + 1; i++){
            dp[i] += Math.min(dp[i-2] + cost[i-2], dp[i-1]+cost[i-1]);
        }
        return dp[dp.length - 1];
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int i = 2; i < cost.length; i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }

        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = cost[0],
            prev1 = cost[1];
        for(int i = 2; i < cost.length; i++){
            int cur = cost[i] + Math.min(prev2, prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        return Math.min(prev2, prev1);
    }
}
```
