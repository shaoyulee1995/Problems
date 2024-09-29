# Partition Equal Subset Sum

```java
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

- Time Complexity: O(NS)
- Space Complexity: O(NS)
  - N is the length of nums
  - S is the sum of nums

```java
class Solution{
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

- Time Complexity: O(N\*S)
- Space Complexity: O(S)
  - N is the length of nums
  - S is the sum of nums

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num: nums){
            for(int i = target; i >= num; i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[target];
    }
}
```

- Time Complexity: O(NS)
- Space Complexity: O(NS)
  - N is the length of nums
  - S is the sum of nums

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i = 1; i < n+1; i++){
            dp[i][0] = true;
        }
        for(int j = 1; j < sum+1; j++){
            dp[0][j] = false;
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < sum+1; j++){
                dp[i][j] = dp[i][j-1];
                if(j>= nums[i-1]){
                    dp[i][j] = (dp[i][j] || dp[i][j-nums[i-1]]);
                }
            }
        }
        return dp[n][sum];
    }
}
```
