# Account Balance After Rounded Purchase

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount+5)/10 * 10;
    }
}
```
