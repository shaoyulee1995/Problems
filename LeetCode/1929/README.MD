# Concatenation of Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        for(int i = 0, j = nums.length; i < nums.length; i++, j++){
            res[i] = nums[i];
            res[j] = nums[i];
        }
        return res;
    }
}
```
