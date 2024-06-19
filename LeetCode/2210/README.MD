# Count Hills and Valleys in an Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int countHillValley(int[] nums) {
        int res = 0;
        for(int i = 1; i + 1 < nums.length; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                res++;
            }
            if(nums[i] < nums[i-1] && nums[i] < nums[i+1]){
                res++;
            }
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i-1];
            }
        }
        return res;
    }
}
```
