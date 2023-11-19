# Array
* Time Complexity: O(NlogN)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public boolean canMakeArithmeticProgression(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i+1 < nums.length; i++){
            if(nums[i] - nums[i-1] != nums[i+1] - nums[i]){
                return false;
            }
        }
        return true;
    }
}
```