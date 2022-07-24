# Negation
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx] < 0){
                return idx;
            }
            nums[idx] = -nums[idx];
        }
        return -1;
    }
}
```
# Fast Slow Pointer
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0,
            fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);
        
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
```