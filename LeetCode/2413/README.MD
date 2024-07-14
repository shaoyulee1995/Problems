# Smallest Even Multiple

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int smallestEvenMultiple(int n) {
        return (n&1) == 0? n: n*2;
    }
}
```
