.# Array

## Solution 1
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int i = 0; i < n; i++){
            int temp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i] - fee);
        }
        return sell;
    }
}
```
## Solution 2
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE,
            sell = 0;
        for(int price: prices){
            buy = Math.max(buy, sell - price - fee);
            sell = Math.max(sell, buy + price);
        }
        return sell;
    }
}
```