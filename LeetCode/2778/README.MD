# Sum of Squares of Special Elements

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int sumOfSquares(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums.length % (i+1) == 0){
                res += nums[i] * nums[i];
            }
        }
        return res;
    }
}
```
