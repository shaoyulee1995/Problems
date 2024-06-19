# Ant on the Boundary

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int res = 0,
            bal = 0;
        for(int num: nums){
            bal += num;
            res += (bal==0)? 1:0;
        }
        return res;
    }
}
```
