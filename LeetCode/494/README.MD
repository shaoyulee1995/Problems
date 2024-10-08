# Target Sum

- Time Complexity: O(2<sup>N</sup>)
- Space Complexity: O(N)

```java
class Solution{
    int res;
    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        findTargetSumWays(nums, target, 0);
        return res;
    }
    public void findTargetSumWays(int[] nums, int target, int index) {
        if(index == nums.length){
            if(target == 0){
                res++;
            }
            return;
        }
        target -= nums[index];
        findTargetSumWays(nums, target, index + 1);
        target += nums[index];

        target += nums[index];
        findTargetSumWays(nums, target, index + 1);
        target -= nums[index];
    }
}
```

- Time Complexity: O(NS)
- Space Complexity: O(NS)
  - N is length of nums
  - S is the sum of nums

```java
class Solution{

    HashMap<String, Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        map = new HashMap();
        return findTargetSumWays(nums, target, 0);
    }
    public int findTargetSumWays(int[] nums, int target, int index){
        if(index == nums.length){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        String key = target + "," + index;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int res = findTargetSumWays(nums, target - nums[index], index + 1) +
                  findTargetSumWays(nums, target + nums[index], index + 1);
        map.put(key, res);
        return res;
    }
}
```

- Time Complexity: O(NS)
- Space Complexity: O(S)
  - N is length of nums
  - S is the sum of nums

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum < target || target < -sum){
            return 0;
        }
        int[] dp = new int[2*sum + 1];
        dp[0+sum] = 1;
        for(int i = 0; i < nums.length; i++){
            int[] next = new int[2*sum + 1];
            for(int j = 0; j < 2*sum + 1; j++){
                if(dp[j] != 0){
                    next[j - nums[i]] += dp[j];
                    next[j + nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[sum + target];
    }
}
```

- Time Complexity: O(NS)
- Space Complexity: O(S)
  - N as length of nums
  - S as size

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if((target+sum)%2 == 1){
            return 0;
        }
        int size = (target + sum)/ 2;
        if(Math.abs(target) > sum){
            return 0;
        }
        int[] dp = new int[size+1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = size; j >= nums[i]; j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[size];
    }
}
```
