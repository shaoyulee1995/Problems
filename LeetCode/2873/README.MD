# Maximum Value of an Ordered Triplet I

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of the array

```java

class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0,   
             maxA = 0,
             maxAB = 0;
        for(int num: nums){
            res = Math.max(res, 1L*maxAB*num);
            maxAB = Math.max(maxAB, maxA-num);
            maxA = Math.max(maxA, num);
        }
        return res;
    }
}
```
