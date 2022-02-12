# KnapSack
* Time Complexity: O(NT)
* Space Complexity: O(T)
	* N as length of nums
	* T as target
```
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i < target+1; i++){
            for(int num: nums){
                if(i-num >= 0){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
```
# Recursion Memorization
* Time Complexity: O(NT)
* Space Complexity: O(T)
	* N as length of nums
	* T as target
```
class Solution {
    Integer[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target+1];
        return permutataions(nums, target);
    }
    public int permutataions(int[] nums, int target){
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(dp[target] != null){
            return dp[target];
        }
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            cnt += permutataions(nums, target-nums[i]);
        }
        dp[target] = cnt;
        return cnt;
    }
}
```