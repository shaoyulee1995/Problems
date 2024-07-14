# Sum of Digits in Base K

- Time Complexity: O(logK)
- Space Complexity: O(1)
  - K as k

```java
class Solution {
    public int sumBase(int n, int k) {
        int res = 0;
        while(n != 0){
            res += n%k;
            n /= k;
        }
        return res;
    }
}
```
