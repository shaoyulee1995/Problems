# Find the Child Who Has the Ball After K Seconds

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int numberOfChild(int n, int k) {
        return (n-1) - Math.abs((n-1) - k%((n-1)*2));
    }
}
```
