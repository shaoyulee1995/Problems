# Number of 1 Bits

```java
class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res += ((n&1) == 1)? 1: 0;
            n >>= 1;
        }
        return res;
    }
}
```
