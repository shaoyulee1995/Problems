# TLE
```
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum /= 2;
        return canPartition(nums, sum, 0);
    }
    public boolean canPartition(int[] nums,  int target, int index){
        if(target == 0){
            return true;
        }
        if(index < 0 || index == nums.length){
            return false;
        }
        if(canPartition(nums, target - nums[index], index + 1)){
            return true;
        }
        int j = index + 1;
        while(j < nums.length && nums[j] == nums[index]){
            j++;
        }
        return canPartition(nums, target, j);
    } 
}
```
# DP
* Time Complexity: O(N*S)
* Space Complexity: O(S)
	* N is the length of nums
	* S is the sum of nums
```
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum /= 2;
        int[] dp = new int[sum+1];
        for(int num: nums){
            for(int i = sum; i >= num; i--){
                dp[i] = Math.max(dp[i], dp[i - num] + num);
            }
        }
        return dp[sum] == sum;
    }
}
```
# Memorized DP
* Time Complexity: O(NS)
* Space Complexity: O(NS)
	* N is the length of nums
	* S is the sum of nums
```
class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length,
            sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum /= 2;
        dp = new Boolean[n+1][sum + 1];
        return canPartition(nums, 0, sum);
    }
    public boolean canPartition(int[] nums, int index, int sum){
        if(sum == 0){
            return true;
        }
        if(index == nums.length || sum < 0){
            return false;
        }
        if(dp[index][sum] != null){
            return dp[index][sum];
        }
        return dp[index][sum] = (canPartition(nums, index + 1, sum - nums[index]) || 
                                canPartition(nums, index + 1, sum));
    }
}
```