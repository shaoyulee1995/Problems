# Maximum Subarray

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE,
            count = 0;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            res = Math.max(count, res);
            if(count < 0){
                count = 0;
            }
        }
        return res;
    }
}
```

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
            max = nums[0];
        for(int num: nums){
            max = Math.max(max + num, num);
            res = Math.max(max, res);
        }
        return res;
    }
}
```