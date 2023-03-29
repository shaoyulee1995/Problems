# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int maximumDifference(int[] nums) {
        int res = -1,
            min = nums[0];
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            res = Math.max(res, nums[i] - min);
        }
        return res == 0? -1: res;
    }
}
```