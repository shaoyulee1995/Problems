# Shortest Unsorted Continuous Subarray

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE,
            max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                min = Math.min(min, nums[i]);
            }
        }
        for(int j = nums.length - 2; j >= 0; j--){
            if(nums[j] > nums[j+1]){
                max = Math.max(max, nums[j]);
            }
        }
        int i = 0;
        for(; i < nums.length; i++){
            if(nums[i] > min){
                break;
            }
        }
        int j = nums.length - 1;
        for(; j >= 0; j--){
            if(nums[j] < max){
                break;
            }
        }
        return (i>j)?0:(j-i+1);
    }
}
```
