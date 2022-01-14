# Arrays
* Time Complexity: O(NlogN)
* Space Complexity: O(1)

```
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i * 2 < nums.length; i++){
            res = Math.max(res, nums[i] + nums[nums.length - 1 - i]);
        }
        return res;
    }
}
```