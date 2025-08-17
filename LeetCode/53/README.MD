# Maximum Subarray

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        int res = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0],
            currentSum = 0;
        for(int num: nums){
            currentSum = Math.max(currentSum + num, num);
            res = Math.max(res, currentSum);
        }
        return res;
    }
}
```