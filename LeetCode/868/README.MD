# Binary Gap

# Bit Operation

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as bit length of n

```
class Solution {
    public int binaryGap(int n) {
        int lastPos = -1,
            curPos = 0,
            res = 0;
        while(n != 0){
            if((n&1) == 1){
                if(lastPos != -1){
                    res = Math.max(res, curPos - lastPos);
                }
                lastPos = curPos;
            }
            curPos++;
            n >>= 1;
        }
        return res;
    }
}
```
