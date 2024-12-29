# Number of Even and Odd Bits

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int idx = 0;
        while(n != 0){
            if((n&1) == 1){
              if(idx%2 == 0){
                  res[0]++;
              }else{
                  res[1]++;
              }
            }
            idx++;
            n >>= 1;
        }
        return res;    
    }
}
```