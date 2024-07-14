# Best Time to Buy and Sell Stock with Cooldown

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MIN_VALUE, sell = 0,
            prevBuy = 0;
        for(int i = 0; i < n; i++){
            int temp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, prevBuy - prices[i]);
            prevBuy =  temp;
        }
        return sell;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0,
            cooldown = 0,
            buy = Integer.MIN_VALUE;

        for(int price: prices){
            buy = Math.max(buy, cooldown - price);
            cooldown = Math.max(cooldown, sell);
            sell = buy + price;
        }
        return Math.max(sell, cooldown);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int cool_down = 0,
            buy = -prices[0],
            sell = 0,
            hold = -prices[0];
        for(int i = 1; i < prices.length; i++){
            int original_hold = hold,
                original_sell = sell;
            hold = Math.max(buy, hold);
            sell = prices[i] + Math.max(buy, original_hold);
            buy = cool_down - prices[i];
            cool_down = Math.max(cool_down, original_sell);
        }
        return Math.max(cool_down, sell);
    }
}
```
