# Reverse Bits

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as n

```java
public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res <<= 1;
            res += ((n&1) == 1)? 1: 0;
            n >>= 1;
        }
        return res;
    }
}
```
