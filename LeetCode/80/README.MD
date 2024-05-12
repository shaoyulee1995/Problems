# Remove Duplicates from Sorted Array II
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[j-2] < nums[i]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
```