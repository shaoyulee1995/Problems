# 2 Pointers
## Solution 1
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZeroIndex++] = nums[i];
            }
        }
        
        for(int i = lastNonZeroIndex; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
```
## Solution 2
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public void moveZeroes(int[] nums) {
        int fast = 0, 
            slow = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for(; slow < nums.length; slow++){
            nums[slow] = 0;
        }
    }
}
```