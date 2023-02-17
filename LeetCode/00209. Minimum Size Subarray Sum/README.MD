# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, res = Integer.MAX_VALUE;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                res = Math.min(res, j-i+1);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
}
```