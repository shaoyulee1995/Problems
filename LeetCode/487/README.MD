# Max Consecutive Ones II

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroLeft = 0,
            zeroRight = 0,
            res = 0;
        for(int num: nums){
            zeroRight++;
            if(num == 0){
                zeroLeft = zeroRight;
                zeroRight = 0;
            }
            res = Math.max(res, zeroLeft+zeroRight);
        }
        return res;
    }
}
```