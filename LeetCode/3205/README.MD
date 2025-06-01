# Maximum Array Hopping Score I

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int maxScore(int[] nums) {
        int res = 0,
            max = Integer.MIN_VALUE;
        for(int i = nums.length-1; i > 0; i--){
            max = Math.max(max, nums[i]);
            res += max;
        }
        return res;
    }
}
```