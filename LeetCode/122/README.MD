# Best Time to Buy and Sell Stock II
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int i = 0; i < n; i++){
            int temp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, temp-prices[i]);
        }
        return sell;
    }
}
```
# Greedy
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            res += Math.max(prices[i] - prices[i-1], 0);
        }
        return res;
    }
}
```

## Python 
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(len(prices) - 1):
            if prices[i+1] > prices[i]:
                profit += prices[i+1] - prices[i]
        return profit
```