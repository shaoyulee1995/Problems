# Minimum Difference Between Largest and Smallest Value in Three Moves

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <= 4){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            res = Math.min(res, nums[nums.length - 1 - 3 + i] - nums[i]);
        }
        return res;
    }
}
```
