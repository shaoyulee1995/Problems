# Largest Perimeter Triangle

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length-1; i-2 >= 0; i--){
            if(nums[i] < nums[i-1] + nums[i-2]){
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
}
```
