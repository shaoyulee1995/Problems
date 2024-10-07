# Calculate Money in Leetcode Bank

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int totalMoney(int n) {
        int extra = n % 7,
            week = n / 7;
        return 28 * week + 7 * week * (week-1)/2 + extra * week + extra*(extra+1)/2;
    }
}
```