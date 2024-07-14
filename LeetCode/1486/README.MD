# XOR Operation in an Array

# XOR

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;
        for(int i = 0; i < n; i++){
            res ^= (start + 2*i);
        }
        return res;
    }
}
```
