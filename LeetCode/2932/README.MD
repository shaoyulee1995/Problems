# Maximum Strong Pair XOR I

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - P as length of nums

```java
class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])){
                    res = Math.max(res, nums[i] ^ nums[j]);
                }
            }
        }
        return res;
    }
}
```