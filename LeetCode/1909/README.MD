# Remove One Element to Make the Array Strictly Increasing

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int prev = nums[0],
            dip = 0;
        for(int i = 1; i < nums.length; i++){
            if(prev >= nums[i]){
                dip++;
                if(dip == 2){
                    return false;
                }
                if(i == 1 || nums[i] > nums[i-2]){
                    prev = nums[i];
                }
            }else{
                prev = nums[i];
            }
        }
        return true;
    }
}
```
