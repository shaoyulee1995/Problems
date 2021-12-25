# 2 Pointers
## Solution 1
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for(int num: nums){
            if(num != val){
                nums[cnt++]= num;
            }
        }
        return cnt;
    }
}
```
## Solution 2
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0,
            slow = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
```