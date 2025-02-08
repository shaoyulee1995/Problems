# Sum of All Subset XOR Totals

- Time Complexity: O(2<sup>N</sup>)
- Space Complexity: O(N)
  - N as nums.length

```java

class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    public int dfs(int[] nums, int idx, int xor){
        if(idx == nums.length){
            return xor;
        }
        int x = dfs(nums, idx+1, nums[idx]^xor),
            y = dfs(nums, idx+1, xor);
        return x + y;
    }
}
```