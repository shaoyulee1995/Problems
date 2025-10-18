# Minimum Number of Increments on Subarrays to Form a Target Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of target

```java
class Solution {
    public int minNumberOperations(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            res += Math.max(0, target[i] - target[i - 1]);
        }
        return res;
    }
}
```
