# Max Consecutive Ones

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0,
            count = 0;
        for(int num: nums){
            if(num != 1){
                count = 0;
            }else{
                res = Math.max(res, ++count);
            }
        }
        return res;
    }
}
```
