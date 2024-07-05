# Find Minimum in Rotated Sorted Array II

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int findMin(int[] nums) {

        int low = 0,
            high = nums.length - 1;
        if(nums[low] < nums[high]){
            return nums[low];
        }

        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] < nums[high]){
                high = mid;
            }else if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high--;
            }
        }
        return nums[high];
    }
}
```
