# Bitwise OR of Adjacent Elements

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] orArray(int[] nums) {
        int[] res = new int[nums.length-1];
        for(int i = 0; i+1 < nums.length; i++){
            res[i] = nums[i] | nums[i+1];
        }
        return res;
    }
}
```