# Longest Alternating Subarray

- Time Complexity: O(N)
- Space Complexity: O(1)
  - P as length of nums

```java
class Solution {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        for(int i = 1, cur = 1, sign = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == sign){
                cur++;
                sign *= -1;
                res = Math.max(res, cur);
            }else{
                cur = 1;
                if(nums[i] - nums[i-1] == 1){
                    cur++;
                    sign = -1;
                }else{
                    sign = 1;
                }
            }
        }
        return res;
    }
}
```