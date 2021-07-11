# Recursion (TopDown)
* Time Complexity: O(N^N)
* Space Complexity: O(1)

```
class Solution {
    public int rob(int[] nums) {
        return rob(nums, 0);
    }
    public int rob(int[] nums, int index){
        if(index >= nums.length){
            return 0;
        }
        int res = Math.max(rob(nums, index+1),
                          nums[index] + rob(nums, index+2));
        return res;
    }
}
```

# Recursion with Memorization
* Time Complexity: O(N)
* Space Complexity: O(N)
## Solution 1
```
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0);
    }
    public int rob(int[] nums, int index){
        if(index >= nums.length){
            return 0;
        }
        if(memo[index] != -1){
            return memo[index];
        }
        memo[index] = Math.max(rob(nums, index+1),
                          nums[index] + rob(nums, index+2));
        
        return memo[index];
    }
}
```

## Solution 2
```
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            memo[i+1] = Math.max(memo[i], memo[i-1] + nums[i]);
        }
        return memo[nums.length];
    }
}
```
# BottomUp
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];
        for(int i = nums.length - 1; i >= 0; i--){
            dp[i] = Math.max(dp[i+1], nums[i] + dp[i+2]);
        }
        return dp[0];
    }
}
```

# StateTransition
* Time Complexity: O(N)
* Space Complexity: O(1)

```
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int twoAway = 0, oneAway = 0,
            cur = 0;
        for(int i = n - 1; i >= 0; i--){
            cur = Math.max(oneAway, nums[i] + twoAway);
            twoAway = oneAway;
            oneAway = cur;
        }
        return cur;
    }
}
```