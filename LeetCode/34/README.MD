# Find First and Last Position of Element in Sorted Array

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as num

_Left Bound_

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as length of nums

_Right Bound_

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums.length == 0){
            return res;
        }
        res[0] = leftBound(nums, target);
        res[1] = rightBound(nums, target);
        return res;
    }
    public int leftBound(int[] nums, int target){
        int i = 0, j = nums.length -1;
        while(i <= j){
            int k = i + (j-i)/2;
            if(nums[k] == target){
                j = k-1;
            }else if(nums[k] < target){
                i = k+1;
            }else if(nums[k] > target){
                j = k-1;
            }
        }
        if(i >= nums.length || nums[i] != target){
            return -1;
        }
        return i;
    }
    public int rightBound(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int k = i + (j-i)/2;
            if(nums[k] == target){
                i = k+1;
            }else if(nums[k] < target){
                i = k+1;
            }else if(nums[k] > target){
                j = k-1;
            }
        }
        if(j  < 0 || nums[j] != target){
            return -1;
        }
        return j;
    }
}
```

```c++
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result(2);
        result[0] = leftBound(nums, target);
        result[1] = rightBound(nums, target);
        return result;
    }
    int leftBound(vector<int>& nums, int target){
        int left = 0, right = nums.size() - 1;
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
        if(left >= nums.size() || nums[left] != target){
            return -1;
        }
        return left;
    }
    int rightBound(vector<int>& nums, int target){
        int left = 0, right = nums.size() - 1;
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
        if(right < 0 || target != nums[right]){
            return -1;
        }
        return right;
    }
};
```
