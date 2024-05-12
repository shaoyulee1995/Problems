# Maximum Ascending Subarray Sum
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int maxAscendingSum(int[] nums) {
      int res = nums[0],
          curSum = nums[0];
      for(int i = 1; i < nums.length; i++){
          if(nums[i] > nums[i-1]){
            curSum += nums[i];
          }else{
            curSum = nums[i];
          }
          res = Math.max(res, curSum);
      }
      return res;
    }
}
```