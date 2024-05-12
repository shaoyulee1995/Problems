# Search Insert Position
# Iteration
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]){
                return i;
            }else if(target < nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}
```

# Binary Search
* Time Complexity: O(log(N))
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length;
        while(i < j){
            int mid = i + (j-i)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }
}
```