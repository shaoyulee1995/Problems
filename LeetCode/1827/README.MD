# Minimum Operations to Make the Array Increasing

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]){
                res += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }
        return res;
    }
}
```
