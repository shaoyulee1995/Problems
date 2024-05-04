# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length],
              rightSum = new int[nums.length],
              res = new int[nums.length];
        for(int i = 1; i < nums.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }    
        for(int i = nums.length-2; i >= 0; i--){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }
        for(int i = 0; i < res.length; i++){
            res[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return res;
    }
}
```