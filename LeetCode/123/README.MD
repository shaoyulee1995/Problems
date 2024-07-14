# Best Time to Buy and Sell Stock III

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of prices

```java
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE,
            buy2 = Integer.MIN_VALUE,
            sell1 = 0,
            sell2 = 0;
        for(int price: prices){
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return Math.max(sell1, sell2);
    }
}
```
