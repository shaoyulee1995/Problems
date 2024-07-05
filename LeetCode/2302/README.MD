# Count Subarrays With Score Less Than K

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0,
             curSum = 0;
        for(int i = 0, j = 0; j < nums.length; j++){
            curSum += nums[j];
            while(curSum * (j-i+1) >= k){
                curSum -= nums[i++];
            }
            res += j-i+1;
        }
        return res;
    }
}
```
