# House Robber II

# Dynamic Programming

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(robRange(nums, 0, nums.length - 2),
                        robRange(nums, 1, nums.length - 1));
    }
    public int robRange(int[] nums, int start, int end){
        int n = nums.length;
        int oneAway = 0, twoAway = 0, cur = 0;
        for(int i = start; i <= end; i++){
            cur = Math.max(cur, twoAway + nums[i]);
            twoAway = oneAway;
            oneAway = cur;
        }
        return cur;
    }
}
```

# Dynamic Programming

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length-2),
                        rob(nums, 1, nums.length-1));
    }
    public int rob(int[] nums, int start, int end){
        if(start==end){
            return nums[start];
        }
        int[] dp = new int[nums.length+1];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for(int i = start+2; i <= end; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[end];
    }
}
```
