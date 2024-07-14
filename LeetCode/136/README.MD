# Single Number

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num: nums){
            res ^= num;
        }
        return res;
    }
}
```
