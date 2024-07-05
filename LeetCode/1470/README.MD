# Shuffle the Array

- Time Complexity: O(n)
- Space Complexity: O(N)
  - N as length of nums
  - n as the num gap

```
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0, j = n;
        int[] res = new int[nums.length];
        for(int k = 0; k < n; k++){
            res[i++] = nums[k];
            res[i++] = nums[j++];
        }
        return res;
    }
}
```
