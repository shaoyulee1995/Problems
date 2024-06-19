# Number of 1 Bits

```
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res += ((n&1) == 1)? 1: 0;
            n >>= 1;
        }
        return res;
    }
}
```
