# Burst Balloons
# 2DP
* Time Complexity: O(NN)
* Space Complexity: O(NN)
```
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        return maxCoins(nums, dp, 0, n-1);
    }
    public int maxCoins(int[] nums, int[][] dp, int start, int end) {
        if(start > end){
            return 0;
        }
        if(dp[start][end] != 0){
            return dp[start][end];
        }
        int max = nums[start];
        for(int i = start; i <= end; i++){
            int val = maxCoins(nums, dp,  start, i-1) + 
                      get(nums, start-1) * get(nums, i) * get(nums, end+1) + 
                      maxCoins(nums, dp, i+1, end);
            max = Math.max(max, val);
        }
        dp[start][end] = max;
        return max;
        
    }
    public int get(int[] nums, int i){
        if(i < 0 || i == nums.length){
            return 1;
        }
        return nums[i];
    }
}
```