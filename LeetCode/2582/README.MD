# Pass the Pillow

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int passThePillow(int n, int time) {
        return n - Math.abs(n-1-time%(n*2-2));
    }
}
```
