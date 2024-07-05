# Non-decreasing Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public boolean checkPossibility(int[] nums) {
        int k = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                k++;
                if(k == 2){
                    return false;
                }
                if(i-2 >= 0 && i+1 < nums.length && nums[i-2] > nums[i] && nums[i-1] > nums[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
```
