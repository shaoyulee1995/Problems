# Wiggle Subsequence

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int res = 1,
            curDiff = 0,
            prevDiff = 0;
        for(int i = 1; i < nums.length; i++){
            curDiff = nums[i] - nums[i-1];
            if((curDiff > 0 && prevDiff <= 0) || (curDiff < 0 && prevDiff >= 0)){
                res++;
                prevDiff = curDiff;
            }
        }
        return res;
    }
}
```
