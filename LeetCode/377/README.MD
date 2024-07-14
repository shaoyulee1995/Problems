# Combination Sum IV

# KnapSack

- Time Complexity: O(NT)
- Space Complexity: O(T)
  - N as length of nums
  - T as target

```java
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length && i >= nums[j]; j++){
                dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
```

# Recursion Memorization

- Time Complexity: O(NT)
- Space Complexity: O(T)
  - N as length of nums
  - T as target

```java
class Solution{
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
