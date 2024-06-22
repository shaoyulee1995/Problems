# House Robber

- Time Complexity: O(N^N)
- Space Complexity: O(1)
  - N as length of nums

```java
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

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums


```java
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

```java
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

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

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

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

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

# DP

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
```
