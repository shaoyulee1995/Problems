# Divide an Array Into Subarrays With Minimum Cost I

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0],
            min1 = Integer.MAX_VALUE,
            min2 = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(min1 > nums[i]){
                min2 = min1;
                min1 = nums[i];
            }else if(min2 > nums[i]){
                min2 = nums[i];
            }
        }
        return first + min1 + min2;
    }
}
```
