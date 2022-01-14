# Dynamic Programming 
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(robRange(nums, 0, nums.length - 2),
                        robRange(nums, 1, nums.length - 1));
    }
    public int robRange(int[] nums, int start, int end){
        int n = nums.length;
        int oneAway = 0, twoAway = 0, cur = 0;
        for(int i = start; i <= end; i++){
            cur = Math.max(cur, twoAway + nums[i]);
            twoAway = oneAway;
            oneAway = cur;
        }
        return cur;
    }
}
```