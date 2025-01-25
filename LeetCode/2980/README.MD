# Check if Bitwise Or Has Trailing Zeros

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of nums

```java
class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int even = 0;
        for(int num: nums){
            even += (num%2 == 0)? 1: 0;
            if(even >= 2) {
              return true;
            }
        }
        return false;
    }
}
```