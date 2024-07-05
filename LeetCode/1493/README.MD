# Longest Subarray of 1's After Deleting One Element

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0,
            res = 0,
            i = 0;
        for(int j = 0; j < nums.length; j++){
            zeroCount += (nums[j] == 0)? 1: 0;
            while(zeroCount > 1){
                zeroCount -= (nums[i++] == 0)? 1: 0;
            }
            res = Math.max(res, j-i);
        }
        return res;
    }
}
```
