# Coin Change 2

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0]=1;
        for(int coin: coins){
            for(int i = coin; i <=amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
```
