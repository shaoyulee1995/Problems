# Binary Search
* Time Complexity: O(log(N))
* Space Complexity: O(1)

## Left Bound
* Time Complexity: O(log(N))
* Space Complexity: O(1)
## Right Bound
* Time Complexity: O(log(N))
* Space Complexity: O(1)

```
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = leftBound(nums, target);
        result[1] = rightBound(nums, target);
        return result;
    }
    public int leftBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }
    public int rightBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }
}
```