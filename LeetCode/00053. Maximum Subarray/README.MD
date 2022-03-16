# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int maxSubArray(int[] nums) {
        int localMax = nums[0],
            globalMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
```
# DP
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < dp.length; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }
        int res = Integer.MIN_VALUE;
        for(int d: dp){
            res = Math.max(d, res);
        }
        return res; 
    }
}
```