# Array

## Solution 1
* Time Complexity: O(N)
* Space Complexity: O(1)
```
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

## Solution 2
* Time Complexity: O(N)
* Space Complexity: O(1)
```
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