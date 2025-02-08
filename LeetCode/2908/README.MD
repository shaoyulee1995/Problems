# Minimum Sum of Mountain Triplets I

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of the array

```java
class Solution {
    public int minimumSum(int[] nums) {

        int[] left = new int[nums.length],
              right = new int[nums.length];
        left[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            left[i] = Math.min(nums[i], left[i-1]);
        }
        right[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--){
            right[i] = Math.min(right[i+1], nums[i]);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i+1 < nums.length; i++){
            if(left[i-1] < nums[i] && nums[i] > right[i+1]){
                res = Math.min(res, left[i-1] + nums[i] + right[i+1]);
            }
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}
```
