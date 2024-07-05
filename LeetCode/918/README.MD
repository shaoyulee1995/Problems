# Maximum Sum Circular Subarray

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, maxSum = nums[0],
            curMin = 0,  minSum = nums[0];
        int total = 0;
        for(int num: nums){
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(curMin, minSum);
            total += num;
        }
        return maxSum > 0? Math.max(total - minSum, maxSum):maxSum;
    }
}
```
