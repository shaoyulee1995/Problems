# Traversal
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int curDiff = 0,
            prevDiff = 0,
            res = 1;
        for(int i = 0; i + 1 < nums.length; i++){
            curDiff = nums[i+1] - nums[i];
            if((curDiff > 0 && prevDiff <= 0 )|| (curDiff < 0 && prevDiff >= 0)){
                prevDiff = curDiff;
                res++;
            }
        }
        return res;
    }
}
```