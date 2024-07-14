# Factorial Trailing Zeroes

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n >= 1){
            res += n/5;
            n /= 5;
        }
        return res;
    }
}
```
