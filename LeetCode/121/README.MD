# Best Time to Buy and Sell Stock

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of prices

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++){
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of prices

```java
class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int price: prices){
            buy = Math.max(buy, -price);
            sell = Math.max(sell, buy+price);
        }
        return sell;
    }
}
```
- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of prices
```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,
            res = 0;
        for(int price: prices){
            min = Math.min(min, price);
            if(min < price){
                res = Math.max(res, price - min);
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of prices

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            if(i-1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n-1][0];
    }
}
```
