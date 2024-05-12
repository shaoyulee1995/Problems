# Max Consecutive Ones III
# Sliding WIndows
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        for(; j < nums.length; j++){
            if(nums[j] == 0){
                k--;
            }
            if(k < 0){
                k += 1 - nums[i++];
            }
        }
        return j - i;
    }
}
```