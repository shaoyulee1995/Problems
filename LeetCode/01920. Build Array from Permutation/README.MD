# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
```