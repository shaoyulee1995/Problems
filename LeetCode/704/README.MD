# Binary Search

# Binary Search

- Time Complexity: O(logN)
- Space Complexity: O(1)

```
class Solution {
    public int search(int[] nums, int target) {
        int i = 0,
            j = nums.length-1;
        while(i <= j){
            int k = i + (j-i)/2;
            if(nums[k] == target){
                return k;
            }
            if(nums[k] > target){
                j = k-1;
            }else{
                i = k+1;
            }
        }
        return -1;
    }
}
```
