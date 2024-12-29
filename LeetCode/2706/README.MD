# Buy Two Cholocate

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of prices

```java
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return (prices[0] + prices[1]) > money? money: money - (prices[0] + prices[1]);
    }
}
```

- Time Complexity: O(Nl)
- Space Complexity: O(1)
  - N as length of prices

```java
class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE,
            secondMin = Integer.MAX_VALUE;
        for(int price: prices){
            if(min > price){
                secondMin = min;
                min = price;
            }else if(secondMin > price){
                secondMin = price;
            }
        }
        return (min + secondMin) > money? money: money - (min + secondMin);
    }
}
```
