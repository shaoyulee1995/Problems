# Largest Number At Least Twice of Others

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int dominantIndex(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt(),
            res = 0;
        for(int i = 0; i < nums.length; i++){
          if(nums[i] == max){
            res = i;
            continue;
          }
          if(nums[i]*2 > max){
            return -1;
          }
        }
        return res;
    }
}
```
